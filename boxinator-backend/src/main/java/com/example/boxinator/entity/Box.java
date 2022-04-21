package com.example.boxinator.entity;

import com.example.boxinator.ShippingCost;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @DecimalMin(value = "0.01")
    private double weight;

    @NotNull
    private String boxColour;

    @NotNull
    private String country;

    private double shippingCost;

    public Box() {
    }

    public Box(Integer id, String name, double weight, String boxColour, String country) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.boxColour = boxColour;
        this.country = country;

    }

    public Box(String name, double weight, String boxColour, String country) {
        this.name = name;
        this.weight = weight;
        this.boxColour = boxColour;
        this.country = country;
    }


    public double calcCost() {
        ShippingCost cost = new ShippingCost();
        return cost.costCalculator(weight, country);
    }


}
