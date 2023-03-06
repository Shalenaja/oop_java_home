
// В проекте RobotMap сделать интерфейс для робота. Везде наружу (в метод #main) отдавать интерфейс. 
//Создание объекта конкретного класса должно быть ровно в одном месте внутри класса RobotMap.
//* При желании, сделать рефакторинг проекта RobotMap, описать проделанную работу и объяснить, какую пользу несут изменения.

package oop_java_home_6;

import java.util.*;

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

        // рефакторинг проекта RobotMap:
        // 1. Вынесен интерфейс CommandHandler в отдельный вайл
        // 2. Каждый обработчик вынесен в отдельный файл
        // 3. CommandManager выполняет свою прамую функцию
        // 4. Реализован выход из программы.
        // Польза изменений: Организована правильная структура программы.Т.о. код выглядит более простым, логика наглядная.
        // За счет интерфейсов с данными работа происходит быстрее. 

        CreateCommandHandler h1 = new CreateCommandHandler(map);
        ListCommandHandler h2 =  new ListCommandHandler(map);
        MoveCommandHandler h3 =  new MoveCommandHandler(map);
        DirectionCommandHandler h4 =  new DirectionCommandHandler(map);
        DeleteCommandHandler h5 =  new DeleteCommandHandler(map);

        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(h1);
        handlers.add(h2);
        handlers.add(h3);
        handlers.add(h4);
        handlers.add(h5);
        
        final CommandManager manager = new CommandManager(handlers);
        String exit = "exit";
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
            if (command.equals(exit)) {
                break; }
            else {          
            manager.acceptCommand(command);
            }
        }
    }
}
