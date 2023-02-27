package characters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/* this class represents the gun that the enemy has.
 * 
 */

public class EnemyGun extends Sprite {

	public EnemyGun(int xc, int yc) {
		super(xc, yc);

		try {
			image = new Image(new FileInputStream("enemy.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Image not found");
		}
		getDimensions();
	}

	@Override
	public void fire(Sprite gunner) {
		this.getGun().add(gunner);
	}

	public void update() {
		y += 20;

		if (y >= 0) {
			visible = false;
		}
	}

	public EnemyGun clone(int x, int y) {
		return new EnemyGun(x, y);
	}

	public void draw(GraphicsContext context) {
		context.drawImage(image, x + 30, y);
	}

	@Override
	public void delegate(int xa, int ya, Sprite gun1) {
	}
}
