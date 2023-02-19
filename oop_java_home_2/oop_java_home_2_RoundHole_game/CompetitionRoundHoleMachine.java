
// 3. *Есть интерфейс RoundHole - описание круглое отверстия (имеет радиус) double getRadius()
        // Есть интерфейс RoundPeg - описание круглого колышка (тоже есть радиус)
        // Есть класс RoundHoleMachine, у которой метод, принмает RoundPeg, возвращает RoundHole
        // Есть интерфейс SquarePeg - описание квадратного колышка (имеет длину стороны кварата)
        // Реализовать адаптер для SquarePeg в RoundHoleMachine

package oop_java_home_2_RoundHole_game;

public class CompetitionRoundHoleMachine {
    public static void main(String[] args) {

        RoundHole enter = new RoundHoleMachineAdapter(new RoundHoleMachine(20));
        Stakes[] stakess = createStakes();
        for (Stakes stakes : stakess) {
                   boolean result = enter.pass(stakes);
                   if (result) {
                    System.out.println("Peg" + stakes.getName() + " подходит для " + enter.getRadius());
                } else {
                    System.out.println("Peg" + stakes.getName() + " НЕ подходит для " + enter.getRadius());
                }
            }
        }

    private static Stakes[] createStakes() {
        return new Stakes[] {
                new RP("RP", 18),               
                new RP("RP", 25),
                new SP("SP", 3),
                new SP("SP", 6),
        };
    }
}