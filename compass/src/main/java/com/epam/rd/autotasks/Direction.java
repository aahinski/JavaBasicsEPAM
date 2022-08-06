package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        for(Direction direction : Direction.values()) {
            if((degrees - direction.degrees) % 360 == 0)
                return direction;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        if(degrees >= 0) {
            int normalDegrees = degrees % 360;
            for (int i = 1; i < 8; i++) {
                if (normalDegrees >= 45.0 * i - 22.5 && normalDegrees <= 45.0 * i + 22.5)
                    return ofDegrees(45 * i);
            }
            return N;
        } else {
            int tmp = Math.abs(degrees) % 360;
            int normalDegrees = 360 - tmp;
            for (int i = 1; i < 8; i++) {
                if (normalDegrees >= 45.0 * i - 22.5 && normalDegrees <= 45.0 * i + 22.5)
                    return ofDegrees(45 * i);
            }
            return N;
        }
    }

    public Direction opposite() {
        return ofDegrees(this.degrees - 180);
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(this.degrees - direction.degrees);
        if(difference > 180)
            return 360 - difference;
        else
            return difference;
    }
}
