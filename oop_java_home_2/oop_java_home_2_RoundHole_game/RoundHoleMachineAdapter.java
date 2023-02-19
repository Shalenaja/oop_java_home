package oop_java_home_2_RoundHole_game;

public class RoundHoleMachineAdapter implements RoundHole {

    private final RoundHoleMachine machine;

    public RoundHoleMachineAdapter(RoundHoleMachine machine) {
        this.machine = machine;
    }
   
    @Override
    public boolean pass(Stakes stakes) {
        return machine.pass(stakes);
    }

    @Override
    public double getRadius() {
        return machine.getRadius();
    }
}
