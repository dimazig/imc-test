package imc.game.engine;

import imc.game.engine.GameEngine;
import imc.game.engine.PlayerTurnFactory;
import imc.game.engine.VictoryRegister;
import imc.game.engine.WinnerDecisionMaker;
import imc.game.model.Player;
import imc.game.model.Symbol;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class GameEngineTest {

    private final WinnerDecisionMaker decisionMaker = mock(WinnerDecisionMaker.class);
    private final PlayerTurnFactory playerTurnFactory1 = mock(PlayerTurnFactory.class);
    private final PlayerTurnFactory playerTurnFactory2 = mock(PlayerTurnFactory.class);
    private final VictoryRegister victoryRegister = mock(VictoryRegister.class);

    private final GameEngine gameEngine = new GameEngine(
            decisionMaker,
            playerTurnFactory1,
            playerTurnFactory2
    );

    @Test
    void should_run_game_3_times() {
        // given
        var player1 = new Player("player1", Symbol.random());
        var player2 = new Player("player2", Symbol.random());

        given(playerTurnFactory1.turn()).willReturn(player1);
        given(playerTurnFactory2.turn()).willReturn(player2);
        given(decisionMaker.winner(player1, player2))
                .willReturn(Optional.of(player1))
                .willReturn(Optional.of(player2))
                .willReturn(empty());

        // when
        gameEngine.play(3, victoryRegister);

        // then
        then(playerTurnFactory1).should(times(3)).turn();
        then(playerTurnFactory2).should(times(3)).turn();
        then(decisionMaker).should(times(3)).winner(player1, player2);

        then(victoryRegister).should().victory(player1, player2);
        then(victoryRegister).should().victory(player2, player1);
        then(victoryRegister).should().deuce();
        then(victoryRegister).shouldHaveNoMoreInteractions();
    }

}