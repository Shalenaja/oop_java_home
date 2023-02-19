package oop_java_home_2_Competition_game;

public class Discus {

    private final int distance;

    public Discus(int distance) {
        this.distance = distance;
    }

    public boolean pass(CanDiscus discus) {
        return discus.getDiscus()>= distance;       
    }     
}
