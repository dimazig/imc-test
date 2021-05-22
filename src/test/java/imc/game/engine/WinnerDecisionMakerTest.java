package imc.game.engine;

import imc.game.engine.WinnerDecisionMaker;
import imc.game.model.Player;
import imc.game.model.Symbol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static imc.game.model.Symbol.PAPER;
import static imc.game.model.Symbol.ROCK;
import static imc.game.model.Symbol.SCISSORS;
import static org.assertj.core.api.Assertions.assertThat;

class WinnerDecisionMakerTest {

    private final WinnerDecisionMaker decisionMaker = new WinnerDecisionMaker();

    @Test
    void scissors_beat_paper() {
        // given
        var player1 = new Player("player1", PAPER);
        var player2 = new Player("player2", SCISSORS);

        // when / then
        assertThat(decisionMaker.winner(player1, player2)).hasValue(player2);
        assertThat(decisionMaker.winner(player2, player1)).hasValue(player2);
    }

    @Test
    void paper_beats_rock() {
        // given
        var player1 = new Player("player1", PAPER);
        var player2 = new Player("player2", ROCK);

        // when / then
        assertThat(decisionMaker.winner(player1, player2)).hasValue(player1);
        assertThat(decisionMaker.winner(player2, player1)).hasValue(player1);
    }

    @Test
    void rock_beats_scissors() {
        // given
        var player1 = new Player("player1", SCISSORS);
        var player2 = new Player("player2", ROCK);

        // when / then
        assertThat(decisionMaker.winner(player1, player2)).hasValue(player2);
        assertThat(decisionMaker.winner(player2, player1)).hasValue(player2);
    }

    @ParameterizedTest
    @EnumSource(Symbol.class)
    void should_be_no_winner__when_symbols_are_equal(Symbol symbol) {
        // given
        var player1 = new Player("player1", symbol);
        var player2 = new Player("player2", symbol);

        // when / then
        assertThat(decisionMaker.winner(player1, player2)).isEmpty();
        assertThat(decisionMaker.winner(player2, player1)).isEmpty();

    }
}