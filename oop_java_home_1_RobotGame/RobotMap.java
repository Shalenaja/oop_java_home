package oop_java_home_1_RobotGame;

import java.util.ArrayList;
import java.util.List;

public class RobotMap {

    public static final int DEFAULT_COUNT = 5;   // добавлено ограничение по количеству роботов

    private int n;
    private int m;
    private int count;   
    private final List<Robot> robots;

    
    public RobotMap(int n, int m) { 
        validateMap(n, m, count);                  // добавлена валидация параметров при создании карты
        this.n = n;
        this.m = m;
        this.count = DEFAULT_COUNT;                  
        this.robots = new ArrayList<>();
    }

    public RobotMap(int n, int m, int count) {        // добавлен конструктор для с учетом количества роботов
        validateMap(n, m, count);
        this.n = n;
        this.m = m;
        this.count = DEFAULT_COUNT;             
        this.robots = new ArrayList<>();
    }
   
   
    public void validateMap(int n, int m, int count) {             // добавлен метод валидации карты              
        if(n <= 10 && n > 0 && m <= 10 && m > 0 && count <= DEFAULT_COUNT) {
            this.n = n;
            this.m = m;
            this.count = count;

        }
        else if (n <= 10 && n > 0 && m <= 10 && m > 0 && count > DEFAULT_COUNT) {
            throw new IllegalStateException("Некоректное значение количества роботов!");
        }
        else if ((n > 10 || n < 0 || m > 10 || m < 0) && count <= DEFAULT_COUNT) {
            throw new IllegalStateException("Некоректное значение размера поля!");
        }
        else if ((n > 10 || n < 0 || m > 10 || m < 0) && count > DEFAULT_COUNT) {
            throw new IllegalStateException("Некоректное значение размера поля и количества роботов!"); 
        }
    }

    public Robot createRobot(Point point) {        
        validatePoint(point);
        Robot robot = new Robot(point);
        robots.add(robot);        
        return robot;       
    }

    public Point createPoint(Point point) {                  // добавлен метод создания объекта класса Point
        Point p = new Point(point.x(), point.y());           // используется в методе  move_some(int c) 
        return p;        
     }

    private void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    private void validatePointIsCorrect(Point point) {
        if (point.x() < 0 || point.x() > n || point.y() < 0 || point.y() > m) {
            throw new IllegalStateException("Некоректное значение точки!");
        }
    }

    private void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            Point robotPoint = robot.point;
            if (robotPoint.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }

    public class Robot {
        
        public static final Direction DEFAULT_DIRECTION = Direction.TOP; 

        private Direction direction;
        private Point point;        

        public Robot(Point point) {           
            this.direction = DEFAULT_DIRECTION;  
            this.point = point;                  
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move() {
            Point newPoint = switch (direction) {
                case TOP -> new Point(point.x() - 1, point.y());
                case RIGHT -> new Point(point.x(), point.y() + 1);
                case BOTTOM -> new Point(point.x() + 1, point.y());
                case LEFT -> new Point(point.x(), point.y() - 1);
            };
            validatePoint(newPoint);

            System.out.println("Робот переместился с " + point + " на " + newPoint);
            this.point = newPoint;
        }

        @Override
        public String toString() {
            return point.toString() + ", [" + direction.name() + "]";
        }

        public void move_some(int c) {                // добавлен метод с параметром - количество шагов вперед
            Point p = createPoint(point);
            Point r = createPoint(point);                 
            for (int i = 1; i <= c; i++) {             
                Point newPoint = switch (direction) {
                    case TOP -> new Point(p.x() - 1, p.y());
                    case RIGHT -> new Point(p.x(), p.y() + 1);
                    case BOTTOM -> new Point(p.x() + 1, p.y());
                    case LEFT -> new Point(p.x(), p.y() - 1);
                };
                validatePoint(newPoint);                   
                p = newPoint;   
                if (i == c) {
                    this.point = newPoint;
                    System.out.println("Робот переместился с " + r + " на " + newPoint);                                     
                }           
            }           
        }
    }
}

