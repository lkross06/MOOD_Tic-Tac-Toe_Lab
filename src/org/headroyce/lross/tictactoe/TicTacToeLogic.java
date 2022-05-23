package org.headroyce.lross.tictactoe;

public class TicTacToeLogic {

    private int[] board;
    private int turn;           // 1 = X, -1 = O
    private boolean gameOver;

    public TicTacToeLogic() {
        board = new int[numRows()*numRows()];

        reset();
    }

    /**
     * Resets the board to starting positions
     */
    public void reset() {

        turn = 1;

        int i = 0;
        while (i < board.length) {
            board[i] = 0;
            i++;
        }
    }

    /**
     * Attempts to make a move on the board
     *
     * @param spot the location to move [0, (numRows^2)]
     * @return true if a valid is made, false otherwise
     */
    public boolean makeMove(int spot) {
        if (board[spot] == turn||(board[spot] == turn*-1)) {
            return false;
        }
        this.board[spot] = turn;
        turn *=  -1;
        return true;
    }

    /**
     * Checks for a winner
     *
     * @return the Winner, "TIE" if a tie occurs, or empty string if there is no winner but the game is not over
     */
    public String checkWinner() {

        // rows
        if (board[0] == board[1] && board[0] == board[2]) {
            if (board[0] == -1) {
                return "O";
            } else if (board[0] == 1) {
                return "X";
            }
        } else if (board[3] == board[4] && board[3] == board[5]) {
            if (board[3] == -1) {
                return "O";
            } else if (board[3] == 1) {
                return "X";
            }
        } else if (board[6] == board[7] && board[6] == board[8]) {
            if (board[6] == -1) {
                return "O";
            } else if (board[6] == 1) {
                return "X";
            }
        }
        //cols
        if (board[0] == board[3] && board[0] == board[6]) {
            if (board[0] == -1) {
                return "O";
            } else if (board[0] == 1) {
                return "X";
            }
        } else if (board[1] == board[4] && board[1] == board[7]) {
            if (board[1] == -1) {
                return "O";
            } else if (board[1] == 1) {
                return "X";
            }
        } else if (board[2] == board[5] && board[2] == board[8]) {
            if (board[2] == -1) {
                return "O";
            } else if (board[2] == 1) {
                return "X";
            }
        }
        //diagonals
        // rows
        if (board[0] == board[1] && board[0] == board[2]) {
            if (board[0] == -1) {
                return "O";
            } else if (board[0] == 1) {
                return "X";
            }
        } else if (board[3] == board[4] && board[3] == board[5]) {
            if (board[3] == -1) {
                return "O";
            } else if (board[3] == 1) {
                return "X";
            }
        } else if (board[6] == board[7] && board[6] == board[8]) {
            if (board[6] == -1) {
                return "O";
            } else if (board[6] == 1) {
                return "X";
            }
        }
        //cols
        if (board[0] == board[4] && board[0] == board[8]) {
            if (board[0] == -1) {
                return "O";
            } else if (board[0] == 1) {
                return "X";
            }
        } else if (board[2] == board[4] && board[2] == board[6]) {
            if (board[2] == -1) {
                return "O";
            } else if (board[2] == 1) {
                return "X";
            }
        }

        //no tie?
        int i = 0;
        while (i < board.length) {
            if (board[i] == 0) {
                return "";
            }
            i++;
        }


        return "TIE";
    }

    /**
     * Gets the player name of the spot asked
     *
     * @param spot the spot to check
     * @return the name of the player, empty string is the space is not occupied, or null for invalid locations
     */
    public String getPlayer(int spot) {
        if (spot < 0 || spot >= board.length) {
            return null;
        }

        int player = board[spot];
        if (player == -1) {
            return "O";
        } else if (player == 1) {
            return "X";
        }
        return "";
    }

    public int numRows() {
        return 3;
    }

    /**
     * Is the game over?
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }

    public String whoseTurn() {
        if (turn == 1) {
            return "X";
        } else if (turn == -1) {
            return "O";
        }
        return "";
    }
}
