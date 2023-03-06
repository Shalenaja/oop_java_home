package oop_java_home_6;

import java.util.Optional;
import java.util.function.Consumer;

public class DirectionCommandHandler implements CommandHandler {
        
    private RobotMap map;

    public DirectionCommandHandler(RobotMap map) {
        this.map = map;    
    }
      
    @Override
    public String name() {
        return "changedir";
    }

    @Override                      
    public void runCommand(String[] args) {           // в методе замена класса RobotMap.Robot на интерфейc  
        Long robotId = Long.parseLong(args[0]);           
        Optional<RobotInterface> robot = map.getById(robotId);
        Optional<Direction> direction = Direction.ofString(args[1]);
        robot.ifPresentOrElse(new Consumer<RobotInterface>() {               
            @Override                                              
            public void accept(RobotInterface robot) {                            
                Direction start = robot.getDir();
                direction.ifPresent(new Consumer<Direction>() {               
                    @Override                                              
                    public void accept(Direction direction) {        
                    robot.changeDirection(direction); 
                    System.out.println("Робот повернулся с " + start + " на " + direction);
                    }
                });                                  
            }                                
            
        }, new Runnable() {                                       
            @Override                                            
            public void run() {                                                        
                System.out.println("Робот с идентификатором " + robotId + " не найден");   
            }
        });
    }            
}
