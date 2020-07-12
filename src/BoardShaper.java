import java.util.ArrayList;

public class BoardShaper {
    int size;

    public BoardShaper(int size) {
        this.size = size;
    }

    public ArrayList<BoardFila> boardInitialValue(){
        ArrayList<BoardFila> filasValor = new ArrayList<>();

        for (int i =0; i< this.size; i++){
            ArrayList<String> filas = new ArrayList<>();

            for (int j = 0 ; j < this.size; j++){
                // Agregar los indices de cada fila
                filas.add(String.valueOf((i*size)+(j)));
            }
            // Agregar las filas del tablero
            filasValor.add(new BoardFila(filas));

        }
        return filasValor;
    }
}
