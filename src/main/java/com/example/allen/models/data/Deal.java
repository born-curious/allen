package com.example.allen.models.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deal {
    private String id;
    private String name;
    private BigDecimal price;
    private int maxLimit;
    private Date endDate;
}
