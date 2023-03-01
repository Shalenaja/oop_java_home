
// TODO: 24.02.2023 Домашнее задание:
//  1. Разобраться с проектом
//  2. Реализовать пункты 4 и 5 для действий пользователя

package oop_java_home_5;

import java.util.*;
import java.util.function.Consumer;


public class RobotGameMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру RobotsGame!:");

        System.out.println("Введите размеры карты:");
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        final RobotMap map = new RobotMap(n, m);
        System.out.println("Карта успешно создана");

        final CommandManager manager = new CommandManager(map);
        while (true) {
            System.out.println("""
                    Доступные действия:
                    1. Для создания робота введите create x y, где x и y - координаты для нового робота
                    2. Для вывода списка всех созданных роботов, введите list
                    3. Для перемещения робота введите move id, где id - идентификатор робота
                    4. Для изменения направления введите changedir id DIRECTION, где id - идентификатор робота, DIRECTION - одно из значений {TOP, RIGHT, BOTTOM, LEFT}
                    5. Для удаления робота введите delete id, где id - идентификатор робота
                    6. Для выхода напишите exit
                    ... список будет пополняться
                    """);
                   
            String command = sc.nextLine();
            manager.acceptCommand(command);
        }
    }    
   
    private static class CommandManager {
        
        private final RobotMap map;
        private final List<CommandHandler> handlers;

        public CommandManager(RobotMap map) {
            this.map = map;
            handlers = new ArrayList<>();
            initHandlers();
        }

        private void initHandlers() {
            initCreateCommandHandler();
            initListCommandHandler();
            initMoveCommandHandler();
            initDirectionCommandHandler();      // добавлено
            initDeleteCommandHandler();         // добавлено
        }

        private void initCreateCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "create";
                }

                @Override
                public void runCommand(String[] args) {
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[1]);
                    RobotMap.Robot robot = map.createRobot(new Point(x, y));
                    System.out.println("Робот " + robot + " успешно создан");
                }
            });
        }

        private void initListCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "list";
                }

                @Override
                public void runCommand(String[] args) {
                 map.acceptRobots(System.out::println);
                 //map.acceptRobots(robot -> System.out.println(robot));
                 //map.acceptRobots(new Consumer<RobotMap.Robot>() {
                     //@Override
                     //public void accept(RobotMap.Robot robot) {
                        // System.out.println(robot);
                    // }
                // });
                }
            });
        }

        private void initMoveCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "move";
                }

                @Override
                public void runCommand(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Optional<RobotMap.Robot> robot = map.getById(robotId);
                    robot.ifPresentOrElse(RobotMap.Robot::move, () -> System.out.println("Робот с идентификатором " + robotId + " не найден"));
                }
            });
        
        }

        private void initDirectionCommandHandler() {       // добавлена команда на смену направления
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "changedir";
                }

                @Override
                public void runCommand(String[] args) {
                    Long robotId = Long.parseLong(args[0]);           
                    Optional<RobotMap.Robot> robot = map.getById(robotId);
                    Optional<Direction> direction = Direction.ofString(args[1]);
                    robot.ifPresentOrElse(new Consumer<RobotMap.Robot>() {               
                        @Override                                              
                        public void accept(RobotMap.Robot robot) {                            
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
                });
            }
        
        private void initDeleteCommandHandler() {          // добавлена команда на удаление
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "delete";
                }
    
                @Override
                public void runCommand(String[] args) {
                    Long robotId = Long.parseLong(args[0]);           
                    Optional<RobotMap.Robot> robot = map.getById(robotId);               
                    robot.ifPresentOrElse(new Consumer<RobotMap.Robot>() {               
                        @Override                                              
                        public void accept(RobotMap.Robot robot) {           
                            robot.delete(robotId);                                               
                        }                                
                        
                    }, new Runnable() {                                       
                        @Override                                            
                        public void run() {                                                        
                            System.out.println("Робот с идентификатором " + robotId + " не найден");   
                        }            
                    });
                }                       
            });
        }    
               
        public void acceptCommand(String command) {
            String[] split = command.split(" ");
            String commandName = split[0];
            String[] commandArgs = Arrays.copyOfRange(split, 1, split.length);
          
            boolean found = false;
            for (CommandHandler handler : handlers) {                
                if (commandName.equals(handler.name())) {
                    found = true;
                    try {
                        handler.runCommand(commandArgs);
                    } catch (Exception e) {
                        System.err.println("Во время обработки команды \"" + commandName + "\" произошла ошибка: " + e.getMessage());
                    }
                }
            }

            if (!found) {
                System.out.println("Команда не найдена");
            }
        }

        private interface CommandHandler {
            String name();
            void runCommand(String[] args);
        }
    }

}
