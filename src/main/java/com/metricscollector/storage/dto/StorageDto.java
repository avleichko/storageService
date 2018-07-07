package com.metricscollector.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto {
    private Long Id;
    @NotNull
    private String metric;
    @NotNull
    private Long value;
    @NotNull
    private Date timestamp;

}
