package characters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/* this class is used to represent the player and the actions the player take in order to progress in the game.
 * It draws itself and knows what to do when actions are executed.
 */

public class Player extends Sprite {

	public Player(int xc, int yc) {
		super(xc, yc);
		try {
			image = new Image(new FileInputStream("tom.png"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		getDimensions();
	}

	public void move(KeyEvent key) {
		if (key.getCode() == KeyCode.RIGHT) {
			x += 100;
		} else if (key.getCode() == KeyCode.LEFT) {
			x -= 100;
		} else if (key.getCode() == KeyCode.DOWN) {
			y += 100;
		} else if (key.getCode() == KeyCode.UP) {
			y -= 100;
		}
	}

	public void delegate(GraphicsContext context) {
		if (context != null) {
			draw(context);
		}
	}

	public void ifHit(int x1, int width1, int y1, int height1) {
		if ((x1 - width1 / 2) < (x + width / 2) && (x1 + width1 / 2) > (x - width / 2)
				&& (y1 - height1 / 2) < (y + height / 2) && (y1 + height1 / 2) > (y - height / 2)) {
		}
	}

	public void draw(GraphicsContext context) {
		if (x >= 1800) {
			x = 1799;
		} else if (y >= 900) {
			y = 899;
		} else if (y <= 700) {
			y = 701;
		} else if (x <= 0) {
			x = 1;
		}
		context.drawImage(image, x, y);
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}