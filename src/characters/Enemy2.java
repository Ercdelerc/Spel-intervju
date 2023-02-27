package characters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Enemy2 extends Sprite {

	/* this is another enemy without a gun. Easy peasy.
	 * 
	 */
	
	public Enemy2(int xc, int yc) {
		super(xc, yc);

		try {
			image = new Image(new FileInputStream("Enemy.png"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		getDimensions();
	}

	public void draw(GraphicsContext context) {
		context.drawImage(image, x, y);
	}

	public void update() {
		y += 2;

		if (y >= 1080) {
			visible = false;
		}
	}

	public void delegate(GraphicsContext context) {
		if (context != null) {
			draw(context);
		}
	}

	@Override
	public Sprite clone(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fire(Sprite gunner) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delegate(int xa, int ya, Sprite gun1) {
		// TODO Auto-generated method stub
	}
}