package oop_java_home_2_RoundHole_game;

public class RP implements Stakes {   

    private final String name;
    private final double radius;
      

    public RP(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getSide() {
        return 0;
    }
}
   