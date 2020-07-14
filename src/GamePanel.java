import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
public static BufferedImage alienImg;
public static BufferedImage rocketImg;
public static BufferedImage bulletImg;
public static BufferedImage spaceImg;
Timer alienSpawn;
boolean autofire = false;

	void startGame() {
		alienSpawn = new Timer(1500 , objectManager);
	    alienSpawn.start();
	}
	public GamePanel() {
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
		titleFont = new Font("Ubuntu", Font.BOLD, 56);
		normalFont = new Font("Ubuntu", Font.PLAIN, 24);
		try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
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
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);
		objectManager.draw(g);
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("You Lost!", (int) (LeagueInvaders.width/4.5), (int) (LeagueInvaders.height*0.375));
		g.drawString("You killed "+objectManager.getScore()+ " ", 100, 400);

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
		        alienSpawn.stop();
		    	rocketShip = new RocketShip(225, 700, 50, 50);
		    	objectManager = new ObjectManager(rocketShip);
		    } else {
		        currentState++;
		    }
		    if(currentState ==GAME) {
		    	startGame();
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			objectManager.addProjectile(rocketShip.getProjectile());
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
