package oop_java_home_1_RobotGame;

public class GameMain {

    public static void main(String[] args) {
        // Карта с роботами.
        // Карта имеет nxm, где n и m - положительные целые числа.
        // Должна быть возможность создания робота на какой-то точке на карте.
        // Точка на карте описывается двумя целочисленными координатами.
        // Роботы могут перемещаться по карте вперед.
        // В одной точке не может находиться несколько роботов.

        // HOMEWORK
        // 0. Разобраться с проектом. Подготовить вопросы к следующему семинару, если возникнут.
        // 1. Добавить валидацию параметров при создании карты
        // 2. Реализовать возможность задать ограничение по количеству создаваемых
        // на карте роботов (в конструкторе карты)
        // При этом если параметр не указан, то используем значение по-умолчанию: 5
        // 3*. Реализовать возможность вызова метода move с параметром - количество шагов вперед
        // Подсказка: можно несколько раз вызвать метод #move

        /*
          * * * * *
          * * * * *
          * * * * *
          * * * * *
          * * * * *
        */

        RobotMap map = new RobotMap(10, 10, 4);    
  
        RobotMap.Robot robot = map.createRobot(new Point(8, 3));
        RobotMap.Robot robot_2 = map.createRobot(new Point(5, 3));
        System.out.println(robot); 
        System.out.println(robot_2);
        robot_2.move();    
        robot_2.changeDirection(Direction.LEFT);        
        robot_2.move_some(2); 
        robot_2.changeDirection(Direction.BOTTOM);       
        robot_2.move_some(4);  
        robot.changeDirection(Direction.RIGHT);
        robot.move_some(4);
        robot.changeDirection(Direction.TOP);       
        robot.move_some(6);
        System.out.println(robot_2); // [8, 1]
        System.out.println(robot);   // [2, 7]
     }
}
