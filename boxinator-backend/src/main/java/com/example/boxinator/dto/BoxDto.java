package com.example.boxinator.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
public class BoxDto {



    private Integer id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 40, message = "Name length should be between 2-40")
    private String name;
    @NotEmpty(message = "BoxColour cannot be empty")
    private String boxColour;
    @NotEmpty(message = "BoxColour cannot be empty")
    private String country;
    private double weight;
    private double shippingCost;


}
