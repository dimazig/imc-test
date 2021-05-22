package imc.game.engine.console;

import imc.game.engine.VictoryRegister;
import imc.game.model.Player;

public class ConsoleOutputVictoryRegister implements VictoryRegister {
    @Override
    public void victory(Player winner, Player loser) {
        System.out.println(winner.name + " wins : " + winner.symbol);
        System.out.println(loser.name + " loses : " + loser.symbol);
    }

    @Override
    public void deuce() {
        System.out.println("Deuce");
    }
}
