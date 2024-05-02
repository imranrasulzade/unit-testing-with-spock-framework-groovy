package com.rsl.unittestspockfw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerRespDto {
    private Integer id;
    private String fullName;
    private Integer status;
}
