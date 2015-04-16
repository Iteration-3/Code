package menuactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitGame implements ActionListener {

    public ExitGame() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);

    }

}
