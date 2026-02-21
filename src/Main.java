import fri.shapesge.Manazer;
import gameEnvironment.GameBoard;

public class Main {
    public static void main(String[] args) {
          GameBoard plocha = new GameBoard();

          Manazer manazer = new Manazer();
          manazer.spravujObjekt(plocha);
    }
}