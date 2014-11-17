import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Zad3 {

	/**
	 * @param args
	 *            Tworzy formatkę i eksperyment.
	 */
	public static void main(String[] args) {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel miniPanel = new JPanel(new FlowLayout());
		MyCanvas canvas = new MyCanvas(200, 200, 24);

		Experiment experiment = new Experiment(24, 5, 0.5f, 1.0f, canvas);

		JTextField textField = new JTextField(4);
		JLabel label = new JLabel();

		JButton button1 = new JButton();
		Action a = new MyAction1(experiment, label);
		button1.setAction(a);
		button1.setText("I don't see");

		JButton button2 = new JButton();
		Action b = new MyAction2(experiment, textField, label);
		button2.setAction(b);
		button2.setText("I see");

		miniPanel.add(button1);
		miniPanel.add(textField);
		miniPanel.add(button2);
		miniPanel.add(label);
		panel.add(canvas, BorderLayout.CENTER);
		panel.add(miniPanel, BorderLayout.SOUTH);

		JFrame mainFrame = new JFrame("Colors");
		mainFrame.getContentPane().add(panel);
		mainFrame.setSize(400, 224);
		mainFrame.setResizable(true);
		mainFrame.setLocation(400, 400);
		mainFrame.setVisible(true);
	}
}
