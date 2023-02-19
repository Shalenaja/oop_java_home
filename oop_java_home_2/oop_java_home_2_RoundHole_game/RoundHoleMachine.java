package oop_java_home_2_RoundHole_game;

public class RoundHoleMachine {

        
    private final double radius;
 
    public RoundHoleMachine(double radius) {
    this.radius = radius;
   
    }
    
    public boolean pass(CanEnter canEnter) {     
       return canEnter.getRadius() < radius;
    }

    public double getRadius() {
        return radius;
    }
}  

