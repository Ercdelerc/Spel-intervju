package characters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/* This is the class enemy. It has a gun to fire and it's not afraid to use it. It works just like the other Sprite classes, but it's
 * defined how it interacts with other objects in the stage states.
 */
public class Enemy extends Sprite {

	private EnemyGun antitom;

	public Enemy(int xc, int yc) {
		super(xc, yc);
		antitom = new EnemyGun(x, y);
		try {
			image = new Image(new FileInputStream("Enemy.png"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		getDimensions();
	}

	public void draw(GraphicsContext context) {
		context.drawImage(image, x, y);
		for (Sprite shot : antitom.getGun()) {
			shot.draw(context);
		}
	}

	public void update() {
		y += 2;
		antitom.fire(antitom.clone(x, y));
		for (Sprite shot : antitom.getGun()) {
			shot.update();
		}

		if (y >= 1080) {
			visible = false;
		}
	}

	public void delegate(GraphicsContext context) {
		if (context != null) {
			draw(context);
		}
	}
	
	public EnemyGun gun() {
		return antitom;
	}

	@Override
	public Sprite clone(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delegate(int xa, int ya, Sprite gun1) {
		// TODO Auto-generated method stub
		
	}
}