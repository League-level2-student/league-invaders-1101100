import java.awt.Color;
import java.awt.Graphics;

public class Earth extends GameObject{

	public Earth(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update(){
		super.update();
	}
	
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 790, 500, 200);
		
	}

}
