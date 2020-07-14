import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	int speed;
	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 40;
	}

	void update() {
		super.update();
		
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
	 public void right() {
	        x += speed;

		 	if(x>450) {
		 		x=450;
		 	}
	    }
	 public void left(){
	    	x -= speed;
		    if(x<=0){
	        	x=0;
	        }
	    }
	 public void up(){
		 	y -= speed;
	    }
	 public void down(){
		 	y += speed;
		 	if(y>=700) {
		 		y=700;
		 	}
	    }
	 public Projectile getProjectile() {
	        return new Projectile(x+width/2, y, 10, 10);
	} 
}
