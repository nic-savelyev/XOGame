
public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        field.eraseField();
        char currentSymbol = ' ';

        for (int i = 0; i < 9; i++) {
            if ((i == 0) || (i % 2 == 0)) {                 //Change player moves
                currentSymbol = 'X';
            }
            else
                currentSymbol = '0';

            field.showField();

            field.characterInput(currentSymbol);
            if (field.checkWin(currentSymbol) != 0) {
                System.out.println("Gamer " + currentSymbol + " WIN!!!");
                field.showField();
                break;

            }

            if (i == 8) {
                System.out.println("Draw! Try again ;)");
                break;
            }
        }


    }
}