package org.example.billiard_store.repository;

import org.example.billiard_store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findStoreByName(String name);
}
