import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class resultsView extends JFrame {
	// Global Variables
	JFrame theFrame = new JFrame("Results");
	private JTextArea drinkByIng = new JTextArea();
	private JButton back = new JButton();
	
	// Constructor
	resultsView(){
		runResults(theFrame);
		displayResults(theFrame);
	}
	
	// The GUI for the window
	public void displayResults(JFrame frame){
		drinkByIng = new JTextArea();
		drinkByIng.setEditable(false);
		drinkByIng.setBounds(0, 0,100, 100);
		drinkByIng.setFont(new Font("Arial", Font.PLAIN, 14));
		
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
	    Image backImg = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	    back.setIcon(new ImageIcon(backImg));
	    
	    JPanel panel = new JPanel();
		panel.setSize(450,500);
		panel.add(drinkByIng);
		panel.add(back);
		
		JScrollPane scroll = new JScrollPane(drinkByIng);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(300, 300));
		panel.add(scroll);
		
		frame.getContentPane().add(panel);
		
	}
	
	// Making the JFrame
	public void runResults(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setSize(450, 500);
	    frame.setResizable(false);
	    frame.setVisible(true);
	}
	
	// Takes in the results, and adds it to the display
	void addResults(String[] resultArray){
		for(int i = 0; i < resultArray.length; i++){
			drinkByIng.append(resultArray[i] + "\n");
		}
	}
	
	// Get Method
	public JFrame getFrame(){
		return theFrame;
	}
	
	// Action Listener
	void backButtonListener(ActionListener backListenForHit){	// Event listener for exit button
		back.addActionListener(backListenForHit);
	}
    
}
