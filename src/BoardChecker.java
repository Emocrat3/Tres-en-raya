public class BoardChecker {
    final int MIN_AVAILABLE_INDEXES_FOR_DRAW = 2;

    public CheckStatus check(Board board) {
        return currentPlayerWins(board) ? CheckStatus.PLAYER_WIN :
                (isGameDraw(board) ? CheckStatus.GAME_DRAW : CheckStatus.KEEP_PLAYING);
    }

    private boolean currentPlayerWins(Board board) {
        // Suficientes jugadas
        // Si son igual es fila, columnas o vertical
        return haveAtLeastEnoughPlays(board) && (isSameCharInAllSameIndexes(board)||
                haveAtLeastARowWithSameCharInAllIndexes(board) ||
                isSameCharInAllStaggeredIndexes(board));
    }

    private  boolean haveAtLeastEnoughPlays(Board board) {
        return board.usedIndexesCount() >= board.size * 2 - 1;
    }

    private boolean haveAtLeastARowWithSameCharInAllIndexes (Board board){
        for (BoardFila fila : board.filas){
            if (fila.allIndexesHaveTheSameChar()) return true;
        }
        return false;
    }

    private boolean isSameCharInAllSameIndexes(Board board){
        for(int i = 0; i < board.size; i++) {
            String lastRowIndexValue = "";
            int matches = 0;

            for (int j = 0; j < board.filas.size(); j++){
                if (lastRowIndexValue.equals("")) lastRowIndexValue = board.filas.get(j).getIndexValue(i);

                if (board.filas.get(j).getIndexValue(i).equals(lastRowIndexValue)) matches += 1;

                if (matches == board.filas.size()) return true;
            }
        }
        return false;
    }

    private boolean isSameCharInAllStaggeredIndexesLeftRight(Board board){
        String lastRowIndexValue = "";
        int matches = 0;

        for (int i = 0; i < board.size; i++){
            if (lastRowIndexValue.equals("")) lastRowIndexValue = board.filas.get(i).getIndexValue(i);

            if (board.filas.get(i).getIndexValue(i).equals(lastRowIndexValue)) matches += 1;

            if (matches == board.size) return true;
        }
        return false;
    }

    private boolean isSameCharInAllStaggeredIndexesRightLeft(Board board){
        String lastRowIndexValue = "";
        int matches = 0;
        int j = board.size - 1;

        for (int i = 0; i < board.size; i++){
            if (lastRowIndexValue.equals("")) lastRowIndexValue = board.filas.get(i).getIndexValue(j);

            if (board.filas.get(i).getIndexValue(j).equals(lastRowIndexValue)) matches += 1;

            if (matches == board.size) return true;
            j -= 1;
        }
        return false;
    }

    private boolean isSameCharInAllStaggeredIndexes(Board board){
        return this.isSameCharInAllStaggeredIndexesRightLeft(board) ||
                this.isSameCharInAllStaggeredIndexesLeftRight(board);
    }

    private boolean isGameDraw(Board board) {
        if (!boardHasAvailableIndexes(board)) return true;

        return leftInBoardMinimumAvailableIndexesForDraw(board);
    }

    private boolean boardHasAvailableIndexes(Board board) {
        return board.availableIndexesCount() != 0;
    }

    private boolean leftInBoardMinimumAvailableIndexesForDraw(Board board) {
        return board.availableIndexesCount() <= this.MIN_AVAILABLE_INDEXES_FOR_DRAW;
    }
}
