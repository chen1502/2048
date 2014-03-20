import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class DisplayPanel extends JPanel {
    private JButton[][] bt;
    public DisplayPanel() {
    	setLayout(new GridLayout(4, 4));
    	bt = new JButton[4][4];
    	init();
    	setFocusable(false);
    	setPreferredSize(new Dimension(320, 320));
    	setMaximumSize(new Dimension(330, 330));
    }
    
    private final int BSIZE = 80;
    
    private void init() {
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			bt[i][j] = Util.createJButton("", i * BSIZE, j * BSIZE, BSIZE, 
    					Color.blue, new Font("Serif", Font.BOLD, 28), BorderFactory.createRaisedSoftBevelBorder());
    			add(bt[i][j]);
    		}
    	}
    }
    
    // set the value (1 << n) at (i, j) spot, with particular color
    private void set(int i, int j, int n) {
    	if(n < 1) bt[i][j].setText(""); 
    	else{
    		bt[i][j].setText("" + (1 << n));
    		if(n >= colors.length) n = colors.length - 1;
    		bt[i][j].setForeground(colors[n]);
    	}
    }
    
    
    private final Color c0 = new Color(255, 255, 255); // white
    private final Color c1 = new Color(127, 127, 127); // gray
    private final Color c2 = new Color(0, 255, 0);  // green
    private final Color c3 = new Color(0, 0, 255);  // blue
    private final Color c4 = new Color(255, 0, 255);  // purple
    private final Color c5 = new Color(255, 255, 0);  // gold
    private final Color c6 = new Color(255, 0, 0);  // red
    private final Color[] colors = {c0, c1, c1, c2, c2, c3, c3, c4, c4, c5, c5, c6, c6};
    
    public void updateText(Matrix m) {
    	for(int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			set(i, j, m.get(i, j));
    		}
    	}
    }
}
