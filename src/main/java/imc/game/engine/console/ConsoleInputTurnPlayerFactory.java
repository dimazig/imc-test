package imc.game.engine.console;

import imc.game.engine.PlayerTurnFactory;
import imc.game.model.Player;
import imc.game.model.Symbol;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputTurnPlayerFactory implements PlayerTurnFactory {

    private final String name;

    public ConsoleInputTurnPlayerFactory(String name) {
        this.name = name;
    }

    @Override
    public Player turn() {

        final var scanner = new Scanner(System.in);
        while (true) {
            try {
                printPrompt(name);
                var symbol = Symbol.values()[Integer.parseInt(scanner.nextLine()) - 1];
                return new Player(name, symbol);
            } catch (Exception e) {
                printError();
            }
        }
    }

    private void printError() {
        System.out.println("Error: wrong input");
    }

    private void printPrompt(String name) {
        final var variants = Arrays.stream(Symbol.values())
                .map(symbol -> (symbol.ordinal() + 1) + " - " +symbol.name())
                .collect(Collectors.joining(", "));

        System.out.printf("%s please choose between: %s: ", name, variants);

    }
}
