package imc.game.engine;

import imc.game.model.Player;
import imc.game.model.Symbol;

public class RandomTurnPlayerFactory implements PlayerTurnFactory {

    private final String name;

    public RandomTurnPlayerFactory(String name) {
        this.name = name;
    }

    @Override
    public Player turn() {
        return new Player(name, Symbol.random());
    }
}
