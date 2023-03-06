package oop_java_home_6;

public class ListCommandHandler implements CommandHandler {
   
    private RobotMap map;
   
    public ListCommandHandler(RobotMap map) {
        this.map = map;
    }

    @Override
    public String name() {
        return "list";
    }

    @Override
    public void runCommand(String[] args) {
        map.acceptRobots(System.out::println);
    }   
}
