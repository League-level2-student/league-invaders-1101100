import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
Timer frameDraw;
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
Font titleFont;
Font normalFont;
RocketShip rocketShip = new RocketShip(225, 700, 50, 50);
ObjectManager objectManager = new ObjectManager(rocketShip);
	
	public GamePanel() {
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
		titleFont = new Font("Ubuntu", Font.BOLD, 56);
		normalFont = new Font("Ubuntu", Font.PLAIN, 24);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		} 	
	}

	void updateMenuState() {  
		
	}
	
	void updateGameState() { 
		objectManager.update();
		
	}
	
	void updateEndState()  {  
		
		
			
	}
	void drawMenuState(Graphics g) {  
		g.setColor(Color.BLUE);	
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("League Invaders", LeagueInvaders.width / 28, (int) (LeagueInvaders.height * 0.25));
		g.setFont(normalFont);
		g.drawString("Press ENTER To Start", LeagueInvaders.width / 4, (int) (LeagueInvaders.height * 0.625));
		g.drawString("Press SPACE For Instructions", LeagueInvaders.width / 6, (int) (LeagueInvaders.height * 0.75));
	}
	void drawGameState(Graphics g) {  
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		objectManager.draw(g);
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("You Lost!", (int) (LeagueInvaders.width/4.5), (int) (LeagueInvaders.height*0.375));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		} 
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				rocketShip.up();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				rocketShip.down();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rocketShip.right();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				rocketShip.left();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
