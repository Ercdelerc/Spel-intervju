package states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


/* this class is the abstract class that the different game states inherit from. 
 * This class is used so that the game model can switch between states simply by letting the game model
 * have a current GameState. */

public abstract class GameState {

	protected GameModel model;

	public GameState(GameModel model) {
		this.model = model;
		
	}

	public abstract void update();

	public abstract void draw(GraphicsContext g);

	public abstract void keyPressed(KeyEvent key);

	public void drawBg(GraphicsContext g, Color color, String text, String texten, int x, int x1, int y) {
		// Here we can draw a background if we so desire.
		g.setFill(color);
	
		g.fillRect(0, 0, 1920, 1080);
		g.setStroke(Color.WHITE);

		g.strokeText(text, x, y / 3);
		g.strokeText(texten, x1, y / 2);
	}
}
