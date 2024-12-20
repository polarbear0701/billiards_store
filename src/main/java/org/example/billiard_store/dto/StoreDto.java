package org.example.billiard_store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreDto {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String description;
}
