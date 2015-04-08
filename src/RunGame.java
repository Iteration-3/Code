import java.awt.EventQueue;

import model.Model;

public class RunGame {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        Game game = new Game();
      }
    });
  }
}
