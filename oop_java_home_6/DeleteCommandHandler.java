package oop_java_home_6;

import java.util.Optional;
import java.util.function.Consumer;

public class DeleteCommandHandler implements CommandHandler {
        
    private RobotMap map;

    public DeleteCommandHandler(RobotMap map) {
        this.map = map;    
    }
      
    @Override
    public String name() {
        return "delete";
    }

    @Override
    public void runCommand(String[] args) {                   // в методе замена класса RobotMap.Robot на интерфейc 
        Long robotId = Long.parseLong(args[0]);           
        Optional<RobotInterface> robot = map.getById(robotId);  
        robot.ifPresentOrElse(new Consumer<RobotInterface>() {             
            @Override                                              
            public void accept(RobotInterface robot) {           
                robot.delete(robotId);                                               
            }                                
            
        }, new Runnable() {                                       
            @Override                                            
            public void run() {                                                        
                System.out.println("Робот с идентификатором " + robotId + " не найден");   
            }            
        });
    }                     
}







