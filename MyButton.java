import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


@SuppressWarnings("serial")
public class MyButton extends JButton implements MouseListener{
	private final Polygon p;
	public MyButton(Polygon p) {
		super();
		this.p = p;
		addMouseListener(this);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusable(false);
	}
    
    private final Color regularColor = new Color(200, 200, 200);
    private final Color focusColor = new Color(220, 220, 220);
    private final Color activeColor = new Color(255, 255, 0);
    private Color color = regularColor;
    
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setColor(color);
    	g2.fill(p);
    }
    
    
    public boolean contains(int x, int y) {
    	return p.contains(x, y);
    }
    
    
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		color = focusColor;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		color = regularColor;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		color = activeColor;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		color = focusColor;
		repaint();
	}
}
