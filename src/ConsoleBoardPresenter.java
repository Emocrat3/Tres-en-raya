public class ConsoleBoardPresenter implements BoardPresenter{

    @Override
    public void displayBoard(Board board) {
        String formatterBoard = "";

        for (int i= 0; i < board.size; i++){
            formatterBoard += String.join("|", board.filas.get(i).get());
            formatterBoard += "\n";
        }

        System.out.print(formatterBoard);
    }

    @Override
    public void displayWelcome(){
        System.out.println("Juego Tres en Raya");
        System.out.println("Escriba -1 para salir");
    }

    @Override
    public void displayPlayerTurn(Players player) {
        System.out.println("\n Turn: " + player.name);
        System.out.println("Selecciona un indice disponible: ");

    }

    @Override
    public void displayInvalidIndex() {
        System.out.println("Indice invalido");
    }

    @Override
    public void displayGameWinner(Players player) {
        System.out.println(player.name + " (" + player.identifyChar + ") Gana!");
    }

    @Override
    public void displayGameDraw() {
        System.out.println("Juego Empatado.\n");
    }
}
