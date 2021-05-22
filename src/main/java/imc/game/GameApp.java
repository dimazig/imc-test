package imc.game;

import imc.game.engine.GameEngine;
import imc.game.engine.RandomTurnPlayerFactory;
import imc.game.engine.WinnerDecisionMaker;
import imc.game.engine.console.ConsoleInputTurnPlayerFactory;
import imc.game.engine.console.ConsoleOutputVictoryRegister;

import java.util.Scanner;

public class GameApp {
    private static final String COMPUTER_PLAYER_NAME = "Computer";

    public static void main(String[] args) {
        final var playerName = getName();
        final var gamesToPlay = getGamesToPlay();

        final var engine = new GameEngine(
                new WinnerDecisionMaker(),
                new ConsoleInputTurnPlayerFactory(playerName),
                new RandomTurnPlayerFactory(COMPUTER_PLAYER_NAME)
        );

        engine.play(gamesToPlay, new ConsoleOutputVictoryRegister());
    }

    private static int getGamesToPlay() {
        final var scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Please input number of games: ");
                int games = Integer.parseInt(scanner.nextLine());
                if (games > 0) return games;

                System.out.println("Error: number of games should be positive");
            } catch (Exception e) {
                System.out.println("Error: not a number");
            }

        }
    }

    private static String getName() {
        final var scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please input your name: ");
            final var name = scanner.nextLine();
            if (!name.isBlank()) return name.trim();
        }
    }
}
