package com.Chynchenko.model;

import java.util.Random;

public enum Color {
    BLUE,
    RED,
    ORANGE,
    PURPLE,
    GREEN,
    GRAY,
    PINK,
    YELLOW;

    private static final Random RANDOM = new Random();

    public static Color getRandomColor(final Color color) {
        Color randomColor;
        do {
            randomColor = getColor();
        } while (randomColor == color);
        return randomColor;
    }

    private static Color getColor() {
        final Color[] values = Color.values();
        final int randomIndex = RANDOM.nextInt(values.length);
        return values[randomIndex];
    }
}