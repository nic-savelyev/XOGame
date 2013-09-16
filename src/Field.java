import java.util.Scanner;

public class Field {

    private static final int FIELD_SIZE = 3;

    private static final char DEFAULT_CEll_VALUE = ' ';

    int winScore = 0;

    private char[][] field = new char[FIELD_SIZE][FIELD_SIZE];


    public char checkWin(char inputSymbol) {
        for (int i = 0; i < 3; i++) {               //Checking the vertical and horizontal lines
            winScore = 0;
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == inputSymbol){
                    winScore++;
                }
            }

            if (winScore == 3) {
                return inputSymbol;
            }
        }

        for (int i = 0; i < 3; i++) {               //Checking the horizontal lines
            winScore = 0;
            for (int j = 0; j < 3; j++) {
                if (field[j][i] == inputSymbol){
                    winScore++;
                }
            }

            if (winScore == 3) {
                return inputSymbol;
            }
        }

        winScore = 0;
        for (int i = 0; i < 3; i++) {               //Checking the main diagonal
            if (field[i][i] == inputSymbol){
                winScore++;
            }
        }
        if (winScore == 3) {
            return inputSymbol;
        }

        winScore = 0;
        for (int i = 0; i < 3; i++) {               //Checking the secondary diagonal
            for (int j = 0; j < 3; j++) {
                if (i + j == 2) {
                    if (field[i][j] == inputSymbol) {
                        winScore++;
                    }
                }
            }
        }

        if (winScore == 3) {
            return inputSymbol;
        }
        return 0;
    }

    public void characterInput(char inputSymbol) {
        System.out.println(inputSymbol + " gamer, please enter the XY coordinates ");

        int ordX = 0;
        int ordY = 0;

        Scanner s = new Scanner(System.in);
        for (;;) {

            ordX = s.nextInt();
            ordY = s.nextInt();//считывание двух интов

            if (field[ordX][ordY] == ' ') {
                field[ordX][ordY] = inputSymbol;
                break;
            }
            else {
                System.out.println("Enter the other coordinates, these are busy");
            }
        }
    }

    public void eraseField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            eraseLine(i);
        }
    }

    public void showField() {
        System.out.println();

        showColumnNumbers();
        System.out.println();
        for (int i = 0; i < FIELD_SIZE; i++) {
            showLine(i);
            System.out.println();
        }
    }

    private void eraseLine (int lineNumber) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            field [i][lineNumber] = DEFAULT_CEll_VALUE;
        }
    }

    private void showLine(int lineNumber) {
        System.out.print(" " + lineNumber + " ");
        for (int i = 0; i < FIELD_SIZE; i++) {
            showCell(i, lineNumber);
        }
    }

    private void showColumnNumbers() {
        System.out.print("   ");
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print(" " + i + " ");
        }
    }

    private void showCell(int x, int y) {
        System.out.print("[" + field[x][y] + "]");
    }

}
