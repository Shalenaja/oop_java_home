package oop_java_home_6;

public class CreateCommandHandler implements CommandHandler {
        
    private RobotMap map;

    public CreateCommandHandler(RobotMap map) {
        this.map = map;    
    }
      
    @Override
    public String name() {
        return "create";
    }

    @Override
    public void runCommand(String[] args) {           // в методе замена класса RobotMap.Robot на интерфейc
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        RobotInterface robot = map.createRobot(new Point(x, y));  
        System.out.println("Робот " + robot + " успешно создан");
    }
}
