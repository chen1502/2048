import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Game {
    private JFrame f;
    private DisplayPanel dp;
    private ControlPanel cp;
    private Matrix m;
    private JButton scoreBoard;
    
    public Game() {
    	setFrame();
    	
    	m = new Matrix();
    	
    	dp = new DisplayPanel();
    	dp.updateText(m);
    	f.getContentPane().add(dp);
    	
    	cp = new ControlPanel();
    	f.getContentPane().add(cp);
    	setupActions(); 
    	
    	setupMenuBar();
    	
    	f.setVisible(true);
    }
    
    private void setupMenuBar() {
    	JMenuBar b = new JMenuBar();
    	b.setFocusable(false);
    	b.setPreferredSize(new Dimension(550, 25));
    	f.setJMenuBar(b);
    	
    	JButton help = new JButton("Help");
    	help.setFocusable(false);
        help.setContentAreaFilled(false);
    	help.setBorderPainted(false);
    	b.add(help);
    	
    	help.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				f.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				f.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Helper();
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

    		
    	});
    	
    	
    	scoreBoard = new JButton("Score : " + m.getScore());
    	scoreBoard.setContentAreaFilled(false);
    	scoreBoard.setFocusable(false);
    	scoreBoard.setBorderPainted(false);
    	b.add(scoreBoard);
    }
    
    private void setFrame() {
    	f = new JFrame();
    	f.setSize(550, 385);
    	f.setResizable(false);
    	f.setTitle("2048 by Yongqiang Chen");
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setLayout(new FlowLayout());
    	f.addKeyListener(ka);
    }
    
    private void updateInfo() {
        if (m.isAlive() ) {
        	m.addNumber();
        	dp.updateText(m);
        	scoreBoard.setText("Score : " + m.getScore());
        }
    }
    
    private KeyAdapter ka = new KeyAdapter(){
    	
    	public void keyPressed(KeyEvent e) {
    		
    		String keyText = KeyEvent.getKeyText(e.getKeyCode());
    		if (keyText.equals("Enter")) {
    			m = new Matrix();
    			dp.updateText(m);
    			scoreBoard.setText("Score : " + m.getScore());
    		}
    		else if (keyText.equals("Up") || keyText.equals("W")) {
    			m.moveUp();
    			updateInfo();
    		}
    		else if (keyText.equals("Down") || keyText.equals("S")) {
    			m.moveDown();
    			updateInfo();
    		}
    		else if (keyText.equals("Left") || keyText.equals("A")) {
    			m.moveLeft();
    			updateInfo();
    		}
    		else if (keyText.equals("Right") || keyText.equals("D")) {
    			m.moveRight();
    			updateInfo();
    		}
    		else return;
    	}
    };
      
    private void setupActions() {
    	cp.getLeftButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m.moveLeft();
        		updateInfo();
        	}
    	});
    	cp.getRightButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m.moveRight();
        		updateInfo();
        	}
        });
    	cp.getUpButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m.moveUp();
        		updateInfo();
        	}
        });
    	cp.getDownButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m.moveDown();
        		updateInfo();
        	}
        });
    	cp.getCentralButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m = new Matrix();
        		dp.updateText(m);
        		scoreBoard.setText("Score : " + m.getScore());
        	}
        });
    }
    
    private static void test() {
    	new Game();
    }
    
    public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			test();
    		}
    	});
    }
}
