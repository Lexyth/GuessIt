import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserView {

	private Game game;

	private JFrame frameMain;
	private GroupPanel groupPanel;
	private JLabel labelHint;
	private JLabel labelComment;
		
	UserView () {
		
		game = new Game(this);
		setupMainFrame();
	}
	
	public void init() {
		
		game.init();
		labelHint.setText("Hint");
		labelComment.setText("Comment");
	}
	
	private void setupMainFrame() {
		
		frameMain = new JFrame("GuessIt");
		frameMain.setSize(400, 300);
		frameMain.setLayout(new GridLayout(5,1));
		
		frameMain.add(setupGroupPanel());
		frameMain.add(guessButton());
		frameMain.add(answerLabel());
		frameMain.add(commentLabel());
		frameMain.add(resetButton());
		
		frameMain.setResizable(false);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frameMain.setVisible(true);
	}
	
	private JPanel setupGroupPanel() {
		
		groupPanel = new GroupPanel("Enter number:", 5);
		
		return groupPanel.getPanel();
	}
	
	private JButton guessButton() {
		
		JButton button = new JButton("Guess");
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				game.guess();
			}
		});
		
		return button;
	}
	
	private JButton resetButton() {
		
		JButton button = new JButton("Reset");
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				game.reset();
			}
		});
		
		return button;
	}
	
	private JLabel answerLabel() {
		
		labelHint = new JLabel("Answers:");
		
		return labelHint;
	}
	
	private JLabel commentLabel() {
		
		labelComment = new JLabel("Comments:");
		
		return labelComment;
	}
	
	public int getGuess() {
		
		String input = groupPanel.getTextField().getText();
		
		System.out.println(input);
		
		if (!input.isEmpty() && input.matches("\\d*")) {
			
			return Integer.parseInt(input);
		} else {
			
			return -1;
		}
	}
	
	public void answer (String message) {
		
		labelHint.setText(message);
	}
	
	public void comment (String message) {
		
		labelComment.setText(message);
	}
}
