import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessIt {
	
	private static int rand = 0;
	private static int guess = 0;
	private static boolean win = false;
	private static JLabel labelAnswer;
	private static JTextField input;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		finishFrame();
		
		reset();
	}
	
	public static void result(int n) {
		
		switch(n) {
			
			case 0:
				labelAnswer.setText("Win!");
				break;
				
			case 1:
				labelAnswer.setText("Higher");
				break;
			
			case -1:
				labelAnswer.setText("Lower");
				break;
				
			default:
				labelAnswer.setText("Error");
		
		}
	}
	
	private static JTextField inputField() {
		
		JTextField textField = new JTextField();
		
		textField.setColumns(5);
		
		input = textField;
		
		return textField;
	}
	
	private static JButton submitGuessButton() {
		
		JButton button = new JButton("Submit");
				
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				submit();
			}
		});
		
		return button;
	}
	
	private static void submit() {
		
		if (win) return;
		
		String text = input.getText();
		
		if (!text.isEmpty() && text.matches("\\d*")) {
			guess = Integer.parseInt(text);
		} else {
			labelAnswer.setText("Wrong input, only digits!");
			return;
		}
		
		if (rand<guess) {
			
			labelAnswer.setText("Lower");
		} else if (rand>guess) {
			
			labelAnswer.setText("Higher");
		} else if (rand==guess) {
			
			labelAnswer.setText("You won! Reset to play again!");
			win = true;
		}
	}
	
	private static JButton resetButton() {
		
		JButton button = new JButton("Reset");
				
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				reset();
			}
		});
		
		return button;
	}
	
	private static void reset() {
		
		rand = (int)(Math.random()*100);
		win = false;
		labelAnswer.setText("");
	}
	
	private static JLabel label (String text) {
		
		JLabel label = new JLabel(text);
		
		return label;
	}
	
	private static JPanel combine (JComponent... components) {
		
		JPanel panel = new JPanel();
		
		for (int i = 0; i < components.length; i++) {
			
			panel.add(components[i]);
		}
		
		return panel;
	}
	
	private static JFrame mainFrame() {
		
		JFrame frame = new JFrame("GuessIt");
		
		frame.setLayout(new GridLayout(4,1));
		
		frame.setSize(400, 200);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false);
		
		return frame;
	}
	
	private static void finishFrame() {
		
		JFrame frame = mainFrame();
		
		frame.add(combine(label("Enter your guess:"),inputField()));
		
		frame.add(submitGuessButton());
		
		JLabel answer = new JLabel();
		
		labelAnswer = answer;
		
		frame.add(combine(label("Try this:"), answer));
		
		frame.add(resetButton());
		
		frame.setVisible(true);
	}
	
	private static void error(String e) {
		
		//TODO Tell the user about it with some fancy dialog box...
		System.out.println("Error at:" + e);
	}
}