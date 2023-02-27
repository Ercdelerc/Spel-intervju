package states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import highScore.Score;

/* this class is also a state that displays the all time high score of the game.*/

public class HighScoreMenu extends GameState {

	private Score highScore;
	private String infoText;
	private Color bgColor;

	public HighScoreMenu(GameModel model) {
		super(model);
		bgColor = Color.BLACK;
		highScore = new Score(0);
		infoText = "Press enter to return to the menu." + System.getProperty("line.separator") + "   The current highscore:";
	}

	@Override
	public void draw(GraphicsContext context) {
		drawBg(context, bgColor, infoText, highScore.getHighScore(), 800, 1040, 1080);
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
