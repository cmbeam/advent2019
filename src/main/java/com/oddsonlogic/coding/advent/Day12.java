package com.oddsonlogic.coding.advent;

import java.math.BigInteger;
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


        //Moon io = new Moon(-9,10,-1,0,0,0);
        //Moon europa = new Moon(-14,-8,14,0,0,0);
        //Moon ganymede = new Moon(1,5,6,0,0,0);
        //Moon callisto = new Moon(-19,7,8,0,0,0);

        Moon io = new Moon(-1,0,2,0,0,0);
        Moon europa = new Moon(2,-10,-7,0,0,0);
        Moon ganymede = new Moon(4,-8,8,0,0,0);
        Moon callisto = new Moon(3,5,-1,0,0,0);


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

        //io = new Moon(-1,0,2,0,0,0);
        //europa = new Moon(2,-10,-7,0,0,0);
        //ganymede = new Moon(4,-8,8,0,0,0);
       // callisto = new Moon(3,5,-1,0,0,0);




        Moon newIo = io;
        Moon newEuropa = europa;
        Moon newGanymede = ganymede;
        Moon newCallisto = callisto;

        UniverseState initialState = new UniverseState();
        initialState.io = newIo;
        initialState.europa = newEuropa;
        initialState.ganymede = newGanymede;
        initialState.callisto = newCallisto;

        boolean xStateMatches = false;
        boolean yStateMatches = false;
        boolean zStateMatches = false;
        int count = 1;
        List<UniverseState> states = new ArrayList<>();
        states.add(initialState);

        List<String> stringBasesStates = new ArrayList<>();
        stringBasesStates.add(io.x+","+io.y+","+io.z+","+io.xVelocity+","+io.yVelocity+","+io.zVelocity+
                ","+europa.x+","+europa.y+","+europa.z+","+europa.xVelocity+","+europa.yVelocity+","+europa.zVelocity+
                ","+ganymede.x+","+ganymede.y+","+ganymede.z+","+ganymede.xVelocity+","+ganymede.yVelocity+","+ganymede.zVelocity+
                ","+callisto.x+","+callisto.y+","+callisto.z+","+callisto.xVelocity+","+callisto.yVelocity+","+callisto.zVelocity);

        while(!xStateMatches || !yStateMatches || !zStateMatches){
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




            if(io.xVelocity == 0 && europa.xVelocity == 0 && ganymede.xVelocity == 0 && callisto.xVelocity == 0 ) {
                xStateMatches = true;
                System.out.println("x number: "+ count*2);
            }
            if(io.yVelocity == 0 && europa.yVelocity == 0 && ganymede.yVelocity == 0 && callisto.yVelocity == 0 ) {
                yStateMatches = true;
                System.out.println("y number: "+ count*2);
            }
            if(io.zVelocity == 0 && europa.zVelocity == 0 && ganymede.zVelocity == 0 && callisto.zVelocity == 0 ) {
                zStateMatches = true;
                System.out.println("z number: "+ count*2);
            }

            count++;
            //System.out.println(count);
        }

        BigInteger lcm = lcm(BigInteger.valueOf(108344),BigInteger.valueOf(161428));
        lcm = lcm(lcm,BigInteger.valueOf(231614));
        System.out.println("LCM: "+lcm);



    }

    public static BigInteger lcm(BigInteger number1, BigInteger number2) {
        if (number1.equals(BigInteger.ZERO) || number2.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        BigInteger absNumber1 = number1;// BigInteger.valueOf(Math.abs(number1.intValue()));
        BigInteger absNumber2 = number2; //BigInteger.valueOf(Math.abs(number2.intValue()));
        BigInteger absHigherNumber =absNumber1.max(absNumber2);
        BigInteger absLowerNumber = absNumber1.min(absNumber2);
        BigInteger lcm = absHigherNumber;
        while (lcm.mod(absLowerNumber) != BigInteger.ZERO) {
            lcm= lcm.add(absHigherNumber);
        }
        return lcm;
    }

}
