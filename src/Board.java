import java.util.ArrayList;
import java.util.stream.Collectors;

public class Board {
    int size;
    ArrayList<BoardFila> filas;

    public Board(int size, ArrayList<BoardFila> filas) {
        this.size = size;
        this.filas = filas;
    }

    public int availableIndexesCount() {
        int availableIndexes = 0;

        for (BoardFila fila : this.filas) {
            availableIndexes += fila.availableIndicesCount();
        }

        return availableIndexes;
    }

    public int usedIndexesCount() {
        return (this.size * this.size) - this.availableIndexesCount();
    }

    public ArrayList<Integer> availableIndexes() {
        ArrayList<Integer> availableIndexes = new ArrayList<>();

        for (int i = 0; i < this.filas.size(); i++){
            int finalI = i;

            availableIndexes.addAll(this.filas.get(i).availableIndexes().stream().map(n -> n + (this.size * finalI)).collect(Collectors.toList()));
        }
        return availableIndexes;
    }

    public void setCharToIndex(int index, String identifyChar) {

        if(!this.isValidIndex(index)){
            throw new IllegalArgumentException();
        }
        int filaIndex = (int) Math.floor((double) index / this.size);
        int subFilaIndex = index - (filaIndex * this.size);

        this.filas.get(filaIndex).setCharInIndex(subFilaIndex, identifyChar);
    }
    private boolean isValidIndex(int index) {
        return this.indexIsInBoardRange(index) && !this.indexIsAlreadyTaken(index);
    }

    private boolean indexIsInBoardRange(int index){
        return index >= 0 && index <= (this.size * this.size);
    }

    public boolean indexIsAlreadyTaken(int index){
        int filaIndex = (int) Math.floor((double) index / this.size);
        int subFilaIndex = index - (filaIndex * this.size);

        return this.filas.get(filaIndex).getIndexValue(subFilaIndex).equals("X")
                ||  this.filas.get(filaIndex).getIndexValue(subFilaIndex).equals("O");
    }
}
