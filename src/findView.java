import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class findView extends JFrame {
	// Global Variables 
	JFrame theFrame = new JFrame("You did not enter anything!");
	private JButton back = new JButton();
	
	// Constructor
	findView(){
		makeFrame(theFrame);
		displayWindow(theFrame);
	}
	
	// The GUI for the window
	public void displayWindow(JFrame frame){	
		JTextField textfield = new JTextField("You did not enter anything!");
		textfield.setEditable(false);
		textfield.setFont(new Font("Arial", Font.PLAIN, 20));
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
	    Image backImg = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	    back.setIcon(new ImageIcon(backImg));
	    
		JPanel panel = new JPanel();
		panel.add(textfield);
		panel.add(back);
		
		frame.getContentPane().add(panel); // Add the panel to the JFrame
		
	}
	
	// Making the JFrame
	public void makeFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(450, 200);
	    frame.setResizable(false);
	    frame.setVisible(true);
	}
	
	//Get Methods
	public JFrame getFrame(){
		return theFrame;
	}
	
	// Event Listener
	void backButtonListener(ActionListener backListenForHit){	// Event listener for exit button
		back.addActionListener(backListenForHit);
	}
    
}