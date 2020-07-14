import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	RocketShip rocketShip;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;
	int getScore() {
		return score;
	}
	public ObjectManager(RocketShip rocketShip) {
		this.rocketShip = rocketShip;
	}
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void addAlien() {
		Random random = new Random();
		aliens.add(new Alien(random.nextInt(450),0,50,50));
	}
	void update() {
		rocketShip.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		rocketShip.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
	}
	
	void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
	}
	void checkCollision() {
		for( int i = 0; i<aliens.size();i++) {
			for( int j = 0; j<projectiles.size();j++) {
				if(aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
					aliens.get(i).isActive = false;
					System.out.println("alien destroyed");
					projectiles.get(j).isActive = false;
					score++;
				}
			}
		}
		for(int i = 0; i<aliens.size(); i++) {
			if(rocketShip.collisionBox.intersects(aliens.get(i).collisionBox)) {
				rocketShip.isActive = false;
				System.out.println("rocket destroyed");
		
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
		System.out.println(aliens.size());
		
	}
}
