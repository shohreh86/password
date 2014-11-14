package MainPackage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import java.util.Arrays;

public class Pass extends JPanel implements ActionListener {
	
	
	private static final long serialVersionUID = 1L;

	private static String OK = "ok";
	

	private JFrame controllingFrame; 
	
	private JPasswordField passwordField;

	public Pass(JFrame Box) {
		
		
		
		controllingFrame = Box;
		
		passwordField = new JPasswordField(24);
		
		passwordField.addActionListener(this);
		
		
		passwordField.setActionCommand(OK);
		
		
		
		
		JComponent buttonPane = createButtonPanel();
		
		JLabel label = new JLabel("Type your Pass: ");
		
		label.setLabelFor(passwordField);
		
		
		JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		
		
		textPane.add(label);
		
		
		textPane.add(passwordField);
		
		
		add(textPane);
		
		
		add(buttonPane);
	}

	protected JComponent createButtonPanel() {
		JPanel picture = new JPanel(new GridLayout(6,6));
		
		
		
		JButton okButton = new JButton("OK");
		
		
		
		JButton helpButton = new JButton("Help");
		
		
		
		okButton.setActionCommand(OK);
	
		
		picture.add(okButton);
		
		
		picture.add(helpButton);
		
		
		return picture;
	}

	public void actionPerformed(ActionEvent e) {
		
		
		
		String cmd = e.getActionCommand();
		
		
		
		if (OK.equals(cmd)) { 
			
			
			
			char[] input = passwordField.getPassword();
			if (isPasswordCorrect(input)) {
				JOptionPane.showMessageDialog(controllingFrame,"your pass is correct");
			} else {
				JOptionPane.showMessageDialog(controllingFrame,"oops Try again.", "Error!",JOptionPane.ERROR_MESSAGE);
			}
			
			
		} 
		}
	

	
	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = { 'b', 'u', 'g', 'a', 'b', 'o', 'o'};
		
		
		if (input.length != correctPassword.length) {
			
			
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(input, correctPassword);
		}
		
		
		return isCorrect;
	}

	
	protected void resetFocus() {
		passwordField.requestFocusInWindow();
	}

	private static void createAndShowGUI() {
		
		JFrame frame = new JFrame("Pass");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final Pass newContentPane = new Pass(frame);
		newContentPane.setOpaque(true); 
		frame.setContentPane(newContentPane);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				newContentPane.resetFocus();
			}
		});
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}