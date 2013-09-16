
public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        field.eraseField();
        char currentSymbol = ' ';

        for (int i = 0; i < 10; i++) {
            if ((i == 0) || (i % 2 == 0)) {                 //Change player moves
                currentSymbol = 'X';
            }
            else
                currentSymbol = '0';

            field.showField();

            field.characterInput(currentSymbol);
            field.checkWin(currentSymbol);


        }

    }
}