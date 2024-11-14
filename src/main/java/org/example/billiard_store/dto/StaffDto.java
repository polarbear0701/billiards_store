package org.example.billiard_store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StaffDto {
    private Long Id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
