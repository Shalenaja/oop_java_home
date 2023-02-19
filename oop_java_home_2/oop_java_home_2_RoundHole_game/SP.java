package oop_java_home_2_RoundHole_game;

public class SP implements Stakes {

    private final String name; 
    private final double side;
   

    public SP(String name, double side) {
        this.name = name;
        this.side = side;  
    }

    @Override
    public String getName() {
        return name;
    }
       
    @Override
    public double getSide() {
        return side;
    }

    @Override
    public double getRadius() {
        double radius = Math.sqrt(Math.pow(side, 4));
        return radius;
    } 
} 