package org.example.billiard_store.service.impl;

import org.example.billiard_store.dto.StaffDto;
import org.example.billiard_store.model.Staff;
import org.example.billiard_store.repository.StaffRepository;
import org.example.billiard_store.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService, UserDetailsService {
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository, PasswordEncoder passwordEncoder) {
        this.staffRepository = staffRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private StaffDto convertToDto(Staff staff) {
        return StaffDto.builder()
                .Id(staff.getId())
                .name(staff.getName())
                .email(staff.getEmail())
                .phone(staff.getPhone())
                .address(staff.getAddress())
                .build();
    }

    public void registerNewStaff(Staff staff) {
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        staffRepository.save(staff);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(staff.getUsername())
                .password(staff.getPassword())
                .authorities(Collections.emptyList()) // No roles or authorities for now
                .build();
    }

}
