import java.awt.MouseInfo;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Helper {
    private JFrame f;
    
    public Helper() {
    	f = new JFrame("Help");
    	JTextArea inst = new JTextArea();
    	inst.append("  Use triangular buttons to choose the direction...\n");
    	inst.append("  Use the square button to retart a new game...\n");
    	inst.append("  You can also use keyboard to control:\n");
    	inst.append("  \"A\" or \"LEFT\" to go left...\n  \"D\" or \"RIGHT\" to go right...\n"
    			+ "  \"W\" or \"UP\" to go up...\n  \"S\" or \"Down\" to go down...\n  \"Enter\" to restart...");
    	
    	inst.setEditable(false);
    	
    	//f.setPreferredSize(new Dimension(300, 200));
    	f.setResizable(false);
    	
    	f.setLocation(MouseInfo.getPointerInfo().getLocation());
    	f.getContentPane().add(inst);
    	
    	
    	
    	f.pack();
    	f.setVisible(true);
    }
    
    
}
