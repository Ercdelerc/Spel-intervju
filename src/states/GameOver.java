package states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/* this class lets you know when the game is over. It's another state which is called upon when certain events defined in the playstate occur.
 */

public class GameOver extends GameState {

	private String gameOver;
	private String infoText;
	private Color bgColor;

	public GameOver(GameModel model) {
		super(model);
		bgColor = Color.BLACK;
		gameOver = "GAME OVER";
		infoText = "Press enter to return to the main menu";
	}

	@Override
	public void draw(GraphicsContext context) {
		drawBg(context, bgColor, gameOver, infoText, 800, 600, 1080);
	}

	@Override
	public void update() {

	}

	@Override
	public void keyPressed(KeyEvent key) {
		if (key.getCode() == KeyCode.ENTER) {
			model.switchState(new MenuState(model));
		}
	}
}
