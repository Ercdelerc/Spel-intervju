package highScore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/* this class represents the current score. It also has the ability to create new text files if there are none for the high score.
 * It can also read from the text file what the high score is and has some methods to print itself out.
*/

public class Score {

	private int score = 0;
	private String highScore = "0";

	public Score(int score1) {
		this.score = score1;
		highScore = getHighScore();
	}

	public int getScore() {
		return score;
	}

	public void drawScore(GraphicsContext context) {
		context.setFill(Color.WHITE);
		context.fillText("Score:  " + score + "", 0, 970.0);
	}
	
	public void drawHighScore(GraphicsContext context) {
		context.fillText("Highscore: " + highScore, 0, 1000);
	}

	public void addScore() {
		score += 100;
	}

	public void compareScores() {

		if (score >= Integer.parseInt(highScore)) {
			highScore = "" + score;

			File score = new File("highscore.txt");
			if (!score.exists()) {
				try {
					score.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FileWriter send = null;
			BufferedWriter writer = null;
			try {
				try {
					send = new FileWriter(score);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				writer = new BufferedWriter(send);
				try {
					writer.write(highScore);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public String getHighScore() {
		FileReader reader = null;
		BufferedReader read = null;
		try {
			reader = new FileReader("highscore.txt");
			read = new BufferedReader(reader);
			try {
				return read.readLine();
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			return "0";
		}
	}
}