import java.awt.EventQueue;
// Class that initiates the program
public class starbucksMain {

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					// Connects the Controller to the View and Model
					starbucksView sV = new starbucksView();
					starbucksModel sM = new starbucksModel();
					starbucksController sC = new starbucksController(sV, sM);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}