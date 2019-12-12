package com.oddsonlogic.coding.advent;



public class UniverseState {
    Moon io;
    Moon europa;
    Moon ganymede;
    Moon callisto;

    public boolean equals(Object o){
        if(o instanceof UniverseState) {
            UniverseState state2 = (UniverseState)o;
            if (io.x == state2.io.x &&
                    europa.x == state2.europa.x &&
                    ganymede.x == state2.ganymede.x &&
                    callisto.x == state2.callisto.x &&
                    io.xVelocity == state2.io.xVelocity &&
                    europa.xVelocity == state2.europa.xVelocity &&
                    ganymede.xVelocity == state2.ganymede.xVelocity &&
                    callisto.xVelocity == state2.callisto.xVelocity
            )
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
