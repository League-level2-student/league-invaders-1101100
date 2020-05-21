import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	static int width = 500;
	static int height = 800;
	GamePanel gPanel = new GamePanel();
	
	JFrame frame = new JFrame();
	
	
	public static void main(String[] args) {
		LeagueInvaders game = new LeagueInvaders();
		
		game.setup();
		
	}
	void setup() {
		frame.add(gPanel);
		frame.addKeyListener(gPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		
	}
	
}
