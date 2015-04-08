import javax.swing.JFrame;

public class Game extends JFrame {
	public Game() {
		setupFrame();
	}
	
	private void setupFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1024,768);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
