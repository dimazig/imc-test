package imc.game.engine;

import imc.game.model.Player;
import imc.game.model.Symbol;

import java.util.Optional;

import static java.util.Optional.empty;

public class WinnerDecisionMaker {

    public Optional<Player> winner(Player player1, Player player2) {
        if (player1.symbol == player2.symbol) return empty();

        return Optional.of(
                player2.symbol.ordinal() == (player1.symbol.ordinal() + 1) % Symbol.values().length
                        ? player1
                        : player2
        );
    }

}
