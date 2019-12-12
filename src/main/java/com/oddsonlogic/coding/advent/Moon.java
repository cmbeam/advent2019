package com.oddsonlogic.coding.advent;

public class Moon {
    int x;
    int y;
    int z;
    int xVelocity;
    int yVelocity;
    int zVelocity;

    public Moon(int x, int y, int z, int xVelocity, int yVelocity, int zVelocity){
        this.x = x;
        this.y = y;
        this.z = z;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.zVelocity = zVelocity;
    }

    public int totalEnergy(){
        int potentialEnergy = Math.abs(x)+Math.abs(y)+Math.abs(z);
        int kineticEnergy = Math.abs(xVelocity)+Math.abs(yVelocity)+Math.abs(zVelocity);
        return potentialEnergy*kineticEnergy;
    }

    public void gravity(Moon otherMoon){
        if (this.x > otherMoon.x)
            this.xVelocity--;
        else if(this.x < otherMoon.x)
            this.xVelocity++;

        if (this.y > otherMoon.y)
            this.yVelocity--;
        else if(this.y < otherMoon.y)
            this.yVelocity++;

        if (this.z > otherMoon.z)
            this.zVelocity--;
        else if(this.z < otherMoon.z)
            this.zVelocity++;
    }

    public void velocity(){
        this.x=this.x+this.xVelocity;
        this.y=this.y+this.yVelocity;
        this.z=this.z+this.zVelocity;
    }
}
