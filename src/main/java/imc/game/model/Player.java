package imc.game.model;

import static java.util.Objects.requireNonNull;

public class Player {
    public final String name;
    public final Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = requireNonNull(name, "name");
        this.symbol = requireNonNull(symbol, "symbol");
    }
}
