import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class resultsController {
	// Global Variables
	private resultsView rV;
	private resultsModel rM;
	
	// Constructor
	resultsController(resultsView rV, resultsModel rM){
		this.rV = rV;
		this.rM = rM;
		
		this.rV.backButtonListener(new backListenForHit());
	}
	
	// ActionListener for the back button
	class backListenForHit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			try{
				rM.removeFrame(rV.getFrame()); // Closes the frame when back is hit
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}

}
