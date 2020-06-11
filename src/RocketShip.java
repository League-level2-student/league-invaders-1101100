import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	int speed;
	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	void update() {

	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
	 public void right() {
	        x += speed;
	    }
	 public void left() {
		 	x -= speed;
	    }
	 public void up() {
		 	y -= speed;
	    }
	 public void down() {
		 	y += speed;
	    }
	 public Projectile getProjectile() {
	        return new Projectile(x+width/2, y, 10, 10);
	} 
}
