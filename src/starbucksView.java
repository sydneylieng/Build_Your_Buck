import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class starbucksView extends JFrame {
	
	//----------------------Global Variables--------------------------//
	JFrame theFrame = new JFrame("Build Your Buck!");

	private String[] temperatures = { "Hot", "Cold"};
	private String[] bases = { "None", "Coffee", "Creme", "Tea"};
	private String[] flavours = { "None", "Vanilla", "Cinnamon Dolce", "White Mocha", "Mocha", "Hazelnut", "Raspberry", "Caramel", "Toffee Nut", "Peppermint"};
	private String[] milks = { "None", "1%", "2%", "Nonfat", "Lactose Free", "Soy", "Cream", "Whole Milk"};
	private String[] items = {"Hot","None","None","None"};
	
	private JTextField t = new JTextField(15);
	
	private JTextField t1 = new JTextField(12);
	private JTextField t2 = new JTextField(12);
	private JTextField t3 = new JTextField(12);
	private JTextField t4 = new JTextField(12);
	
	private JTextField drink = new JTextField(12);
	private JTextField typeIn = new JTextField(12);
		
	private JComboBox<String> c1 = new JComboBox<String>(temperatures);
	private JComboBox<String> c2 = new JComboBox<String>(bases);
	private JComboBox<String> c3 = new JComboBox<String>(flavours);
	private JComboBox<String> c4 = new JComboBox<String>(milks);
	
	private JButton b = new JButton("Build Your Buck!");
	private JButton findDrink = new JButton("Find Drink");
	
	private JLabel starbucks = new JLabel();
	private JLabel or = new JLabel();
	private JLabel byb = new JLabel();
	
	//public Container cp;
	public Image bybImg;
	public Image orImg;
	public Image sbImg;
	
	//-----------------------------Constructor-------------------------------//
	starbucksView(){
		getFrame(theFrame);
		init(theFrame);
	}
	
	//-------------------------GUI for the JFrame---------------------------//
	public void getFrame(JFrame frame){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    frame.setSize(470, 700);
	    frame.setBackground(Color.WHITE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,3,3));
	    frame.setResizable(false);
	    frame.setVisible(true);
	}
	
	public void init(JFrame frame) {
		t.setEditable(false);
		t1.setEditable(false);
		t1.setText("Pick a Temperature");
		t2.setEditable(false);
		t2.setText("Pick a Base");
		t3.setEditable(false);
		t3.setText("Pick a Flavour");
		t4.setEditable(false);
		t4.setText("Pick a Milk");
		
		drink.setEditable(false);
		drink.setText("Search for a Drink");
		drink.setFont(new Font("Arial", Font.PLAIN, 20));
		
		typeIn.setEditable(true);
		drink.setFont(new Font("Arial", Font.PLAIN, 20));
		
		t1.setFont(new Font("Arial", Font.PLAIN, 20));
		t2.setFont(new Font("Arial", Font.PLAIN, 20));
		t3.setFont(new Font("Arial", Font.PLAIN, 20));
		t4.setFont(new Font("Arial", Font.PLAIN, 20));
		c1.setFont(new Font("Arial", Font.BOLD, 20));
		c2.setFont(new Font("Arial", Font.BOLD, 20));
		c3.setFont(new Font("Arial", Font.BOLD, 20));
		c4.setFont(new Font("Arial", Font.BOLD, 20));
	    
        sbImg = new ImageIcon(this.getClass().getResource("/Starbucks.png")).getImage();
        sbImg.getScaledInstance(300, 315, Image.SCALE_DEFAULT);
        starbucks.setIcon(new ImageIcon(sbImg));
        
        orImg = new ImageIcon(this.getClass().getResource("/OR.png")).getImage();
        orImg.getScaledInstance(300, 315, Image.SCALE_DEFAULT);
        or.setIcon(new ImageIcon(orImg));
        
        bybImg = new ImageIcon(this.getClass().getResource("/buildYourBuck.png")).getImage();
        bybImg.getScaledInstance(300, 315, Image.SCALE_DEFAULT);
        byb.setIcon(new ImageIcon(bybImg));
        
        frame.getContentPane().add(starbucks);
        frame.getContentPane().add(byb);
        frame.getContentPane().add(drink);
        frame.getContentPane().add(typeIn);
        frame.getContentPane().add(findDrink);
        frame.getContentPane().add(or);
        frame.getContentPane().add(t1);
        frame.getContentPane().add(c1);
        frame.getContentPane().add(t2);
        frame.getContentPane().add(c2);
        frame.getContentPane().add(t3);
        frame.getContentPane().add(c3);
        frame.getContentPane().add(t4);
        frame.getContentPane().add(c4);
        frame.getContentPane().add(b);
	}
	
	//----------------------Action Listeners for Buttons--------------------------//
	void buildButtonListener(ActionListener buildListenForHit){ // "Build Your Buck!" Button
		b.addActionListener(buildListenForHit);
	}
	
	void findButtonListener(ActionListener findListenForHit){ // "Find a Drink" Button
		findDrink.addActionListener(findListenForHit);
	}
	
	void comboBoxListenerC1(ActionListener comboBoxSelect){ // Temperature Box
		c1.addActionListener(comboBoxSelect);
	}
	
	void comboBoxListenerC2(ActionListener comboBoxSelect){ // Base Box
		c2.addActionListener(comboBoxSelect);
	}
	
	void comboBoxListenerC3(ActionListener comboBoxSelect){ // Flavour Box
		c3.addActionListener(comboBoxSelect);
	}
	
	void comboBoxListenerC4(ActionListener comboBoxSelect){ // Milk Box
		c4.addActionListener(comboBoxSelect);
	}
	
	//---------------------------Get Methods----------------------------//
	String getIndexValueC1(){  // Temperature Box
		items[0] = temperatures[c1.getSelectedIndex()];
		return items[0];
	}
	
	String getIndexValueC2(){ // Base Box
		items[1] = bases[c2.getSelectedIndex()];
		return items[1];
	}
	
	String getIndexValueC3(){ // Flavour Box
		items[2] = flavours[c3.getSelectedIndex()];
		return items[2];
	}
	
	String getIndexValueC4(){ // Milk Box
		items[3] = milks[c4.getSelectedIndex()];
		return items[3];
	}
	
	String getFindValue(){ // Search by Drink Box
		return typeIn.getText();
	}
	
	String[] getTokens(){ 
		return typeIn.getText().split("\\s");
	}
	
	String[] getItems(){
    	return items;
	}
}