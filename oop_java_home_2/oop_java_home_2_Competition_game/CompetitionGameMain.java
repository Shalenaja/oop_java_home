package oop_java_home_2_Competition_game;

public class CompetitionGameMain {

    public static void main(String[] args) {
        // Реализуем соревнования
        // Должны быть участники и препятствия
        // У участника есть параметры: возможности бега (длина), прыжка (высота), плавание (длина)
        // 3 типа препятствия: беговая дорожка, стена и бассейн
        // 3 типа участников: обычный, кот, читер
        // Обычный участник умеет все в зависимости от параметров
        // Кот не умеет плавать
        // Читер всегда преодолевает препятствия, какими бы они не были

        Obstacle[] obstacles = createObstacles();
        Participant[] participants = createParticipants();
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                // participant.overcome(obstacle)
                // obstacle.pass(participant)
                boolean result = obstacle.pass(participant);
                if (result) {
                    System.out.println("Участник #" + participant.getName() + " преодолел препятствие");
                } else {
                    System.out.println("Участник #" + participant.getName() + " НЕ преодолел препятствие");
                }
            }
        }


        // Homework!!!
       
        // 1. Дописать адаптеры для бассейна
        // 2. *Придумать собственный тип препятствий и прикрутить его в проект по аналогии/

    }

    private static Obstacle[] createObstacles() {
        return new Obstacle[]{
                new WallObstacleAdapter(new Wall(40)),
                new RoadObstacleAdapter(new Road(100)),
                new RoadObstacleAdapter(new Road(45)),
                new SwimmingPollObstacleAdapter(new SwimmingPoll(20)),   // адаптер для бассейна
                new DiscusObstacleAdapter(new Discus(45))          // новое препятствие с адаптером
        };
    }

    private static Participant[] createParticipants() {
        return new Participant[] {
                new StandardParticipant("Igor", 50, 30, 20, 40),
                new Cat("Murzik", 60, 25, 48),
                new Cheater("Cheater")
        };
    }
}
