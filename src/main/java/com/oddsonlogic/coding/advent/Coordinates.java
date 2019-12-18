package com.oddsonlogic.coding.advent;

public class Coordinates {
    int x;
    int y;

    public String toString(){
        return this.x+","+this.y;
    }

     public static Coordinates stringValue(String stringCoordinate){
        Coordinates coordinate = new Coordinates();
        String[] parsedCoordinates = stringCoordinate.split(",");
        coordinate.x = Integer.parseInt(parsedCoordinates[0]);
        coordinate.y = Integer.parseInt(parsedCoordinates[1]);
        return coordinate;
    }
}
