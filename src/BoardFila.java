import java.lang.reflect.Array;
import java.util.ArrayList;

public class BoardFila {
    ArrayList<String> fila;

    public BoardFila(ArrayList<String>fila){
        this.fila = fila;
    }

    public ArrayList<String> get(){
        return fila;
    }
    // Ingresar un valor en un indice

    public void setCharInIndex(int index, String identifyChar) {
        fila.set(index, identifyChar);
    }

    //Obtener el valor de un indice

    public String getIndexValue(int index) {
        return  fila.get(index);
    }

    //Tamaño

    public int size() {
        return this.fila.size();
    }

    //Indices disponibles

    public ArrayList<Integer> availableIndexes() {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0;i < this.fila.size(); i++){
            if (this.fila.get(i).equals("X") || this.fila.get(i).equals("O")) continue;

            indexes.add(i);
        }

        return indexes;
    }

    //Si todos los indices son del mismo caracter que representa al jugador

    public boolean allIndexesHaveTheSameChar(){
        if(availableIndicesCount() != 0) return false;

        String lastChar = this.fila.get(0);

        for (String r : this.fila){
            if (!r.equals(lastChar)) return false;
        }

        return true;
    }

    public int availableIndicesCount() {
        int availableIndices = 0;

        for(String r : this.fila) {
            availableIndices += r.equals("X") || r.equals("O") ? 0 : 1;
        }
        return availableIndices;
    }


}
