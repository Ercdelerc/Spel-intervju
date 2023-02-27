package characters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TommyGun extends Sprite {

 /* this is the main weapon you start out with. It draws itself and from the methods it inherits it has everything you need to check for hitboxes and to draw itself.
  * It's created in your current weapon.*/

	public TommyGun(int xc, int yc) {
		super(xc, yc);

		try {
			image = new Image(new FileInputStream("tommygun.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Image not found");
		}
		getDimensions();
	}

	@Override
	public void getDimensions() {
		width = image.getWidth();
		height = image.getHeight();
	}

	@Override
	public void delegate(int xa, int ya, Sprite gun1) {
		gun1.fire(gun1.clone(xa, ya));
	}

	@Override
	public void fire(Sprite gunner) {
		getGun().add(gunner);
	}

	@Override
	public void update() {
		y -= 20;

		if (y <= 0) {
			visible = false;
		}
	}

	@Override
	public TommyGun clone(int x, int y) {
		return new TommyGun(x, y);
	}

	@Override
	public void draw(GraphicsContext context) {
		context.drawImage(image, x + 30, y);
	}
}
