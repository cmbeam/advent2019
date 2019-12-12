package com.oddsonlogic.coding.advent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day12 {
    public static void main(String[] args) {
        /*
        <x=-9, y=10, z=-1>
        <x=-14, y=-8, z=14>
        <x=1, y=5, z=6>
        <x=-19, y=7, z=8>
         */


        Moon io = new Moon(-9,10,-1,0,0,0);
        Moon europa = new Moon(-14,-8,14,0,0,0);
        Moon ganymede = new Moon(1,5,6,0,0,0);
        Moon callisto = new Moon(-19,7,8,0,0,0);

        int totalSystemEnergy = 0;

        for (int i = 0; i < 1000 ; i++) {
            //Apply gravity
            io.gravity(europa);
            io.gravity(ganymede);
            io.gravity(callisto);

            europa.gravity(io);
            europa.gravity(ganymede);
            europa.gravity(callisto);

            ganymede.gravity(io);
            ganymede.gravity(europa);
            ganymede.gravity(callisto);

            callisto.gravity(io);
            callisto.gravity(europa);
            callisto.gravity(ganymede);

            //Apply velocity
            io.velocity();
            europa.velocity();
            ganymede.velocity();
            callisto.velocity();


            totalSystemEnergy = io.totalEnergy()+europa.totalEnergy()+ganymede.totalEnergy()+callisto.totalEnergy();
        }

        System.out.println("Total System Energy: "+totalSystemEnergy);




        io = new Moon(-9,10,-1,0,0,0);
        europa = new Moon(-14,-8,14,0,0,0);
        ganymede = new Moon(1,5,6,0,0,0);
        callisto = new Moon(-19,7,8,0,0,0);

        Moon newIo = io;
        Moon newEuropa = europa;
        Moon newGanymede = ganymede;
        Moon newCallisto = callisto;

        UniverseState initialState = new UniverseState();
        initialState.io = newIo;
        initialState.europa = newEuropa;
        initialState.ganymede = newGanymede;
        initialState.callisto = newCallisto;

        boolean stateMatches = false;
        int count = 0;
        List<UniverseState> states = new ArrayList<>();
        states.add(initialState);

        List<String> stringBasesStates = new ArrayList<>();
        stringBasesStates.add(io.x+","+io.y+","+io.z+","+io.xVelocity+","+io.yVelocity+","+io.zVelocity+
                ","+europa.x+","+europa.y+","+europa.z+","+europa.xVelocity+","+europa.yVelocity+","+europa.zVelocity+
                ","+ganymede.x+","+ganymede.y+","+ganymede.z+","+ganymede.xVelocity+","+ganymede.yVelocity+","+ganymede.zVelocity+
                ","+callisto.x+","+callisto.y+","+callisto.z+","+callisto.xVelocity+","+callisto.yVelocity+","+callisto.zVelocity);

        while(!stateMatches){
            //Apply gravity
            io.gravity(europa);
            io.gravity(ganymede);
            io.gravity(callisto);

            europa.gravity(io);
            europa.gravity(ganymede);
            europa.gravity(callisto);

            ganymede.gravity(io);
            ganymede.gravity(europa);
            ganymede.gravity(callisto);

            callisto.gravity(io);
            callisto.gravity(europa);
            callisto.gravity(ganymede);

            //Apply velocity
            io.velocity();
            europa.velocity();
            ganymede.velocity();
            callisto.velocity();

            Moon newIo2 = io;
            Moon newEuropa2 = europa;
            Moon newGanymede2 = ganymede;
            Moon newCallisto2 = callisto;

            UniverseState newState = new UniverseState();
            newState.io = newIo2;
            newState.europa = newEuropa2;
            newState.ganymede = newGanymede2;
            newState.callisto = newCallisto2;

            String newStringBasedState =io.x+","+io.y+","+io.z+","+io.xVelocity+","+io.yVelocity+","+io.zVelocity+
                    ","+europa.x+","+europa.y+","+europa.z+","+europa.xVelocity+","+europa.yVelocity+","+europa.zVelocity+
                    ","+ganymede.x+","+ganymede.y+","+ganymede.z+","+ganymede.xVelocity+","+ganymede.yVelocity+","+ganymede.zVelocity+
                    ","+callisto.x+","+callisto.y+","+callisto.z+","+callisto.xVelocity+","+callisto.yVelocity+","+callisto.zVelocity;



            if(stringBasesStates.contains(newStringBasedState))
                stateMatches=true;

            stringBasesStates.add(newStringBasedState);
            count++;
            System.out.println(count);
        }

        System.out.println("State matching count: "+count);

    }

}
