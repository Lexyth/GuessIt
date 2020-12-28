import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GroupPanel {
	
	JPanel panel;
	JLabel label;
	JTextField textField;
	
	GroupPanel (String text, int cols) {
		
		JLabel l = new JLabel(text);
		label = l;
		
		JTextField tF = new JTextField();
		tF.setColumns(cols);
		textField = tF;
		
		JPanel p = new JPanel();
		p.add(l);
		p.add(tF);
		panel = p;
	}
	
	public JLabel getLabel() {
		
		return label;
	}
	
	public JTextField getTextField() {
		
		return textField;
	}
	
	public JPanel getPanel() {
		
		return panel;
	}
}
