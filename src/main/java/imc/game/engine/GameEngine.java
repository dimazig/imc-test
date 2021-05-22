package imc.game.engine;

public class GameEngine {
    private final WinnerDecisionMaker decisionMaker;
    private final PlayerTurnFactory playerTurnFactory1;
    private final PlayerTurnFactory playerTurnFactory2;

    public GameEngine(
            WinnerDecisionMaker decisionMaker,
            PlayerTurnFactory playerTurnFactory1,
            PlayerTurnFactory playerTurnFactory2
    ) {
        this.decisionMaker = decisionMaker;
        this.playerTurnFactory1 = playerTurnFactory1;
        this.playerTurnFactory2 = playerTurnFactory2;
    }

    public void play(int numberOfGames, VictoryRegister victoryRegister) {
        for (int i = 0; i < numberOfGames; i++) {
            final var player1 = playerTurnFactory1.turn();
            final var player2 = playerTurnFactory2.turn();

            final var winner = decisionMaker.winner(player1, player2);

            winner.ifPresentOrElse(
                    player -> victoryRegister.victory(player, player == player1 ? player2 : player1),
                    victoryRegister::deuce
            );
        }
    }

}
