import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * @author luke Eksperyment z liczbą faz i sprawdzeń na fazę. Zapisuje wyniki do
 *         pliku results.txt. Ważne metody: doesKnow doesntKnow next
 */
public class Experiment {
	private int phazesCount;
	private int checksCount;
	private int phazeCurrent;
	private int checkCurrent;
	private int dontKnowCurrent;
	private List<Integer> dontKnow;
	private MyCanvas canvas;
	private float backgroundColorX;
	private float letterColorX;
	private float checkDistance;
	private float distanceMultiplier;

	public Experiment(int phazes, int checksPerPhaze, float checkDistance, float distanceMultiplier,
			MyCanvas canvas) {
		super();
		this.phazesCount = phazes;
		this.checksCount = checksPerPhaze;
		this.checkDistance = checkDistance;
		this.distanceMultiplier = distanceMultiplier;
		this.canvas = canvas;
		this.initialize();
	}

	public void setLetterColor() {
		letterColorX = (float) phazeCurrent / (float) phazesCount
				+ ((float) checkCurrent + checkDistance) * distanceMultiplier
				/ (float) (checksCount * phazesCount);
		canvas.setLetterColor(Colors.getColor2(letterColorX));
	}

	public void setBackgroundColor() {
		backgroundColorX = (float) phazeCurrent / (float) phazesCount;
		canvas.setBackgroundColor(Colors.getColor2(backgroundColorX));
	}

	public void doesKnow() {
		this.checkCurrent = checksCount - 1;
		this.next();
	}

	public void doesntKnow() {
		this.dontKnowCurrent++;
		this.next();
	}

	public void next() {
		this.checkCurrent++;
		if (this.checkCurrent == this.checksCount) {
			this.phazeCurrent++;
			this.checkCurrent = 0;
			this.dontKnow.add(this.dontKnowCurrent);
			this.dontKnowCurrent = 0;
			if (this.phazeCurrent == this.phazesCount) {
				this.save();
				JOptionPane.showMessageDialog(canvas,
						"Congratulations, your score is: " + countDontKnow()
								+ " didn't know.");
				this.initialize();
				return;
			}
			setBackgroundColor();
		}
		setLetterColor();
		this.canvas.repaint();

		// System.out.println((phazeCurrent + 1) + "/" + phazesCount + " "
		// + (checkCurrent + 1) + "/" + checksCount);
		// System.out.println("letterColor = "
		// + Colors.getColor2(letterColorX).toString());
		// System.out.println("backgroundColor = "
		// + Colors.getColor2(backgroundColorX).toString());
		// System.out.println("letterColorX = " + letterColorX);
		// System.out.println("backgroundColorX = " + backgroundColorX);
	}

	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public int countDontKnow() {
		int sum = 0;
		for (int i : dontKnow) {
			sum += i;
		}
		return sum;
	}

	public List<Integer> getResults() {
		List<Integer> result = new ArrayList<>();
		for (int i : dontKnow) {
			result.add(checksCount - i);
		}
		return result;
	}

	public void save() {
		try {
			FileWriter fstream = new FileWriter("results.txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(getDateTime() + " " + countDontKnow() + '\n'
					+ getResults().toString() + '\n');
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		this.dontKnowCurrent = 0;
		this.checkCurrent = 0;
		this.phazeCurrent = 0;
		this.dontKnow = new ArrayList<>();
		setBackgroundColor();
		setLetterColor();
		// System.out.println("letterColor = "
		// + Colors.getColor2(letterColorX).toString());
		// System.out.println("backgroundColor = "
		// + Colors.getColor2(backgroundColorX).toString());
		canvas.repaint();
	}
}
