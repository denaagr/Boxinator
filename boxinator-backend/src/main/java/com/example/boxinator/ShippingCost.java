package com.example.boxinator;

public class ShippingCost {

    private static final double sweden=1.3;
    private static final double china=4;
    private static final double brazil=8.6;
    private static final double australia=7.2;


    public double costCalculator(double weight, String country){
        System.out.println(country);
        switch (country){
            case "Sweden":
                return weight *sweden;

            case "China" :
                return weight * china;

            case "Brazil" :
                return weight * brazil;

            case "Australia" :
                return weight * australia;

        }
        return 0;
    }
}
