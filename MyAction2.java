import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

/**
 * @author luke
 * Akcja odpowiedzialna za przycisk "I see"
 */
public class MyAction2 extends AbstractAction {
	private static final long serialVersionUID = -8318172731883116472L;
	private Experiment experiment;
	private JTextField textField;
	private JLabel label;

	public MyAction2(Experiment experiment, JTextField textField, JLabel label) {
		this.experiment = experiment;
		this.textField = textField;
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (textField.getText(0, 1).equals(
					Character.toString(MyRandom.lastChar))) {
				this.label.setText("Correct!");
				this.experiment.doesKnow();
			} else {
				this.label.setText("Incorrect!");
				this.experiment.doesntKnow();
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		textField.setText("");
	}
}
