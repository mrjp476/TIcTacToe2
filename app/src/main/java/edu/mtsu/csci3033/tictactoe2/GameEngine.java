package edu.mtsu.csci3033.tictactoe2;

import java.util.Random;

public class GameEngine {
    private static final Random RANDOM = new Random();
    private char[] Char;
    private char currentPlayer;
    private boolean ended;

    public GameEngine() {
        Char = new char[9];
        newGame();
    }

    public boolean isEnded() {
        return ended;
    }

    public char play(int x, int y) {
        if (!ended && Char[3 * y + x] == ' ') {
            Char[3 * y + x] = currentPlayer;
            changePlayer();
        }
        return checkEnd();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }

    public char getChar(int x, int y) {
        return Char[3 * y + x];
    }

    public void newGame() {
        for (int i = 0; i < Char.length; i++) {
            Char[i] = ' ';
        }
        currentPlayer = 'X';
        ended = false;
    }

    public char checkEnd() {
        for (int i = 0; i < 3; i++) {
            if (getChar(i, 0) != ' ' && getChar(i, 0) == getChar(i, 1) && getChar(i, 1) == getChar(i, 2)) {
                ended = true;
                return getChar(i, 0);
            }

            if (getChar(0, i) != ' ' && getChar(0, i) == getChar(1, i) && getChar(1, i) == getChar(2, i)) {
                ended = true;
                return getChar(0, i);
            }
        }

        if (getChar(0, 0) != ' ' && getChar(0, 0) == getChar(1, 1) && getChar(1, 1) == getChar(2, 2)) {
            ended = true;
            return getChar(0, 0);
        }

        if (getChar(2, 0) != ' ' && getChar(2, 0) == getChar(1, 1) && getChar(1, 1) == getChar(0, 2)) {
            ended = true;
            return getChar(2, 0);
        }
        for (int i = 0; i < 9; i++) {
            if (Char[i] == ' ') {
                return ' ';
            }
        }
        return 'T'; // Tie
    }
     public char computer(){
        if(!ended){
            int position = -1;

            do{
                position=RANDOM.nextInt(9);
            } while(Char[position] != ' ');

            Char[position] = currentPlayer;
            changePlayer();
        }
        return checkEnd();
     }
}
