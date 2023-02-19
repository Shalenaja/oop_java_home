package oop_java_home_2_Competition_game;


public class SwimmingPollObstacleAdapter implements Obstacle {

    private final SwimmingPoll swimingPoll;

    public SwimmingPollObstacleAdapter(SwimmingPoll swimingPoll) {
        this.swimingPoll = swimingPoll;
    }

    @Override
    public boolean pass(Participant participant) {
        return swimingPoll.pass(participant);
    }
}