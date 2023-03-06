package oop_java_home_6;

public interface RobotInterface {         // создан интерфеес
    
    void changeDirection(Direction direction);
    void move();
    void delete(Long idd);

    Direction getDir();
    
}
