package org.example.billiard_store.repository;

import org.example.billiard_store.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByUsername(String username);
    Staff findByEmail(String email);
    Staff findByPhone(String phone);
}
