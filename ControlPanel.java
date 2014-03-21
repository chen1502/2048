import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
    

	JButton upButton;
    JButton leftButton;
    JButton centralButton;
    JButton rightButton;
    JButton downButton;
    
    
    public ControlPanel() {
        
    	upButton = new MyButton(Util.getUpTriangle());
    	leftButton = new MyButton(Util.getLeftTriangle());
    	centralButton = new MyButton(Util.getSquare());
        rightButton = new MyButton(Util.getRightTriangle());
        downButton = new MyButton(Util.getDownTriangle());
        
       
    	
    	int s = 68;
    	
    	GroupLayout layout = new GroupLayout(this);
    	this.setLayout(layout);
    	layout.setAutoCreateGaps(true);
    	layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(leftButton, s, s, s)
                .addGroup(layout.createParallelGroup()
                		.addComponent(upButton, s, s, s)
                		.addComponent(centralButton, s, s, s)
                		.addComponent(downButton, s, s, s))
                .addComponent(rightButton, s, s, s));
    	
    	layout.setVerticalGroup(
    		layout.createSequentialGroup()
    		    .addComponent(upButton, s, s, s)
    		    .addGroup(layout.createParallelGroup()
    		    		.addComponent(leftButton, s, s, s)
    		    		.addComponent(centralButton, s, s, s)
    		    		.addComponent(rightButton, s, s, s))
    		    .addComponent(downButton, s, s, s));
    	
    	
    	setPreferredSize(new Dimension(3*s, 3*s));
    	setFocusable(false);
    }
    
    
    public JButton getLeftButton() { return leftButton; }
    public JButton getRightButton() { return rightButton; }
    public JButton getUpButton() { return upButton; }
    public JButton getDownButton() { return downButton; }
    public JButton getCentralButton() { return centralButton; }
    
}
