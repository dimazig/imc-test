package imc.game.engine;

import imc.game.model.Player;

public interface VictoryRegister {
    void victory(Player winner, Player loser);

    void deuce();
}
