package oop_java_home_2_Competition_game;

public class DiscusObstacleAdapter implements Obstacle {

    private final Discus disc;

    public DiscusObstacleAdapter(Discus disc) {
        this.disc = disc;
    }

    @Override
    public boolean pass(Participant participant) {        
        return disc.pass(participant);
    }  
}
