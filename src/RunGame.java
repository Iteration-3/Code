import java.awt.EventQueue;

import model.Model;
import model.states.gamestates.GameplayState;

public class RunGame {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        Model gameModel = new Model();
        gameModel.pushState(new GameplayState(gameModel));
      }
    });
  }
}
