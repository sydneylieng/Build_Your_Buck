import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class starbucksController {
	//  Global Variables
	private starbucksView sV;
	private starbucksModel sM;
	
	// Constructor
	starbucksController(starbucksView sV, starbucksModel sM){
		this.sV = sV;
		this.sM = sM;
		
		this.sV.buildButtonListener(new buildListenForHit());
		this.sV.findButtonListener(new findListenForHit());
		this.sV.comboBoxListenerC1(new comboBoxSelectC1());
		this.sV.comboBoxListenerC2(new comboBoxSelectC2());
		this.sV.comboBoxListenerC3(new comboBoxSelectC3());
		this.sV.comboBoxListenerC4(new comboBoxSelectC4());
	}
	
//----------------------Classes for Action Listeners--------------------------//
	
	// Action Listener for "Build Your Buck!" or Button
	class buildListenForHit implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try{
				sM.buildBuck(sV.getItems());
				resultsModel rM2 = new resultsModel();
				resultsView rV2 = new resultsView();
				resultsController rC2 = new resultsController(rV2, rM2);
				rV2.addResults(sM.getResultArray());
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}
	
	// Action Listener for "Find Drink" Button 
	class findListenForHit implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try{
				if(sV.getFindValue().equals("")){ // When there is no text entered 
					findModel rM2 = new findModel();
					findView rV2 = new findView();
					findController rC2 = new findController(rV2, rM2);
				}
				else{
					sM.findValue(sV.getTokens());
					resultsModel rM2 = new resultsModel();
					resultsView rV2 = new resultsView();
					resultsController rC2 = new resultsController(rV2, rM2);
					rV2.addResults(sM.getResultArray());
				}
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}

	// Action Listener for Temperature Box
	class comboBoxSelectC1 implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try{
				sV.getIndexValueC1();
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}
	
	// Action Listener for Base Box
	class comboBoxSelectC2 implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try{
				sV.getIndexValueC2();
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}
	
	// Action Listener for Flavour Box
	class comboBoxSelectC3 implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try{
				sV.getIndexValueC3();
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}
	
	// Action Listener for Milk Box
	class comboBoxSelectC4 implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try{
				sV.getIndexValueC4();
			}
			catch(Exception ex){                 
				ex.printStackTrace();
			}
		}
	}

}
