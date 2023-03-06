package oop_java_home_6;

import java.util.Optional;

public enum Direction {

    TOP, RIGHT, BOTTOM, LEFT;

    public static Optional<Direction> ofString(String str) {   // использован класс Optiona
        Direction[] values = values();
        for (Direction value : values) {
            if (str.equals(value.name())) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
