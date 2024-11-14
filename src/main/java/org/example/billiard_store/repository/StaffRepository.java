package org.example.billiard_store.repository;

import org.example.billiard_store.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByUsername(String username);
    Staff findByEmail(String email);
    Staff findByPhone(String phone);
}
