import java.util.ArrayList;

public class Main {
    public static void main(String[] args){


        ConsoleBoardPresenter presenter = new ConsoleBoardPresenter();
        TicTacToeGame game = new TicTacToeGame(3, presenter);

        game.initGame();
    }
}
