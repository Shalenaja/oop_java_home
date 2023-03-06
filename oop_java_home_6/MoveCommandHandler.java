package oop_java_home_6;

import java.util.Optional;


public class MoveCommandHandler implements CommandHandler {
        
    private RobotMap map;

    public MoveCommandHandler(RobotMap map) {
        this.map = map;    
    }
      
    @Override
    public String name() {
        return "move";
    }

    @Override
    public void runCommand(String[] args) {                   // в методе замена класса RobotMap.Robot на интерфейc
        Long robotId = Long.parseLong(args[0]);
        Optional<RobotInterface> robot = map.getById(robotId);
        robot.ifPresentOrElse(RobotInterface::move, () -> System.out.println("Робот с идентификатором " + robotId + " не найден"));
    }
}
