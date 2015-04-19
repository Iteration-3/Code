import java.awt.EventQueue;

import model.Model;
import model.states.gamestates.MainMenuState;
import view.EntitySpriteFactory;

public class RunGame {
  public static void main(String[] args) {
	final Model gameModel = new Model();
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        gameModel.pushState(new MainMenuState());
      }
    });
  }
}
