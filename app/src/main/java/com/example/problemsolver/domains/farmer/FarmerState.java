package com.example.problemsolver.domains.farmer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.example.problemsolver.framework.State;
import java.util.Objects;

/**
 *
 * @author isaka
 */
public class FarmerState extends State {

    public FarmerState(String farmer, String wolf, String goat, String cabbage) {
        this.farmer = farmer;
        this.wolf = wolf;
        this.goat = goat;
        this.cabbage = cabbage;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null)
            return false;
        FarmerState f = (FarmerState) o;
        return this.farmer.equals(f.farmer) && this.wolf.equals(f.wolf)
                && this.goat.equals(f.goat) && this.cabbage.equals(f.cabbage);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.farmer);
        hash = 41 * hash + Objects.hashCode(this.wolf);
        hash = 41 * hash + Objects.hashCode(this.goat);
        hash = 41 * hash + Objects.hashCode(this.cabbage);
        return hash;
    }



    @Override
    public String toString() {
        return "   |  |   \n" +
                farmerState() +
                wolfState() +
                goatState() +
                cabbageState() +
                "   |  |   ";
    }

    public String getFarmer() {
        return this.farmer;
    }

    public String getWolf() {
        return this.wolf;
    }

    public String getGoat() {
        return this.goat;
    }

    public String getCab() {
        return this.cabbage;
    }

    private String farmerState() {
        if ("East".equals(this.farmer))
            return "   |  | F \n";
        return " F |  |   \n";
    }

    private String wolfState() {
        if ("East".equals(this.wolf))
            return "   |  | W \n";
        return " W |  |   \n";
    }

    private String goatState() {
        if ("East".equals(this.goat))
            return "   |  | G \n";
        return " G |  |   \n";
    }

    private String cabbageState() {
        if ("East".equals(this.cabbage))
            return "   |  | C \n";
        return " C |  |   \n";
    }

    private final String farmer;
    private final String wolf;
    private final String goat;
    private final String cabbage;

}

