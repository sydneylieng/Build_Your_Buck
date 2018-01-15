import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class findController {
	//Global Variables
	private findView fV;
	private findModel fM;
	
	// Constructor
	findController(findView fV, findModel fM){
		this.fV = fV;
		this.fM = fM;
		
		this.fV.backButtonListener(new backListenForHit());
	}
	
	// Action Listener for the back button
	class backListenForHit implements ActionListener{		
		public void actionPerformed(ActionEvent e) {
			
			try{
				fM.removeFrame(fV.getFrame());				// Closes the frame when back is hit
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}

}