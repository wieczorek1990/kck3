import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * @author luke
 * Ramka w której rysujemy tło i literkę.
 */
public class MyCanvas extends JComponent {

	private static final long serialVersionUID = -6798318178076416332L;
	private Color backgroundColor;
	private Color letterColor;
	private int fontSize;

	public MyCanvas(int width, int height, int fontSize) {
		this.setSize(width, height);
		this.fontSize = fontSize;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setLetterColor(Color letterColor) {
		this.letterColor = letterColor;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(backgroundColor);
		g2.fill(new Rectangle2D.Float(0, 0, this.getWidth(), this.getHeight()));
		g2.setColor(letterColor);
		Font font = new Font("Arial", Font.PLAIN, fontSize);
		g2.setFont(font);
		g2.drawChars(
				MyRandom.getRandomChar(),
				0,
				1,
				MyRandom.random(font.getSize(),
						this.getWidth() - font.getSize()),
				MyRandom.random(font.getSize(),
						this.getHeight() - font.getSize()));
	}
}