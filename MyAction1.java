import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;

/**
 * @author luke
 * Akcja odpowiedzialna za przycisk "Nie widzę"
 */
public class MyAction1 extends AbstractAction {
	private Experiment experiment;
	private JLabel label;
	private static final long serialVersionUID = -8318172731883116472L;

	public MyAction1(Experiment experiment, JLabel label) {
		this.experiment = experiment;
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.label.setText("");
		this.experiment.doesntKnow();
	}
}
