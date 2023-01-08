package com.example.problemsolver.domains.farmer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.example.problemsolver.framework.Mover;
import com.example.problemsolver.framework.State;
/**
 *
 * @author isaka
 */
public class FarmerMover extends Mover {

    public static final String goesAlone = "Farmer Goes Alone";
    public static final String takesWolf = "Farmer Takes Wolf";
    public static final String takesGoat = "Farmer Takes Goat";
    public static final String takesCabbage = "Farmer Takes Cabbage";

    public FarmerMover() {
        super.addMove(goesAlone, s -> tryAlone(s));
        super.addMove(takesWolf, s -> tryWolf(s));
        super.addMove(takesGoat, s -> tryGoat(s));
        super.addMove(takesCabbage, s -> tryCab(s));
    }

    private State tryAlone(State s) {
        FarmerState state = (FarmerState) s; // null check below?
        if (!state.getGoat().equals(state.getWolf()) && !state.getGoat().equals(state.getCab())) {
            if ("East".equals(state.getFarmer()))
                return new FarmerState("West", state.getWolf(), state.getGoat(), state.getCab());
            else return new FarmerState("East", state.getWolf(), state.getGoat(), state.getCab());
        }
        else return null;
    }

    private State tryWolf(State s) {
        FarmerState state = (FarmerState) s;
        if (!state.getCab().equals(state.getGoat()) && state.getFarmer().equals(state.getWolf())) {
            if ("East".equals(state.getWolf()))
                return new FarmerState("West", "West", state.getGoat(), state.getCab());
            else return new FarmerState("East", "East", state.getGoat(), state.getCab());
        }
        else return null;
    }

    private State tryGoat(State s) {
        FarmerState state = (FarmerState) s;
        if (state.getGoat().equals(state.getFarmer())) {
            if ("East".equals(state.getGoat()))
                return new FarmerState("West", state.getWolf(), "West", state.getCab());
            else return new FarmerState("East", state.getWolf(), "East", state.getCab());
        }
        else return null;
    }

    private State tryCab(State s) {
        FarmerState state = (FarmerState) s;
        if (state.getFarmer().equals(state.getCab())) {
            if (state.getGoat().equals(state.getWolf()))
                return null;
            if ("East".equals(state.getCab()))
                return new FarmerState("West", state.getWolf(), state.getGoat(), "West");
            else return new FarmerState("East", state.getWolf(), state.getGoat(), "East");
        }
        else return null;
    }

}
