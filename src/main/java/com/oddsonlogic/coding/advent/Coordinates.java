package com.oddsonlogic.coding.advent;

public class Coordinates {
    int x;
    int y;
    int level;

    public Coordinates(){};
    public Coordinates(Coordinates coordinate){
        this.x = coordinate.x;
        this.y = coordinate.y;
        this.level = coordinate.level;
    }

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

    public static Coordinates up(Coordinates point){
        Coordinates adjPoint = new Coordinates(point);
        adjPoint.y++;
        return adjPoint;
    }
    public static Coordinates down(Coordinates point){
        Coordinates adjPoint = new Coordinates(point);
        adjPoint.y--;
        return adjPoint;
    }
    public static Coordinates left(Coordinates point){
        Coordinates adjPoint = new Coordinates(point);
        adjPoint.x--;
        return adjPoint;
    }
    public static Coordinates right(Coordinates point){
        Coordinates adjPoint = new Coordinates(point);
        adjPoint.x++;
        return adjPoint;
    }
}
