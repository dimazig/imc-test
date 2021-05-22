package imc.game.model;

import java.util.Random;

public enum Symbol {
    SCISSORS, PAPER, ROCK;

    private static final Random RANDOM = new Random();

    public static Symbol random() {
        return values()[RANDOM.nextInt(Symbol.values().length)];
    }
}
