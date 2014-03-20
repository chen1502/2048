import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;

import javax.swing.JButton;
import javax.swing.border.Border;


public class Util {
    
	public static JButton createJButton(String text, int x, int y, int sz, Color c, Font f, Border border) {
		JButton b = new JButton(text);
		b.setBounds(x, y, sz, sz);
		b.setContentAreaFilled(false);
		b.setFocusable(false);
		b.setBackground(new Color(240, 240, 240));
		
		if(border != null) b.setBorder(border);
		if(f != null) b.setFont(f);
		if(c != null) b.setForeground(c);
		
		return b;
	}
	
	
	public static Polygon getLeftTriangle() {
		int[] X = {30, 60, 60};
		int[] Y = {30, 0, 60};
		return new Polygon(X, Y, 3);
	}
	
	public static Polygon getRightTriangle() {
		int[] X = {30, 0, 0};
		int[] Y = {30, 0, 60};
		return new Polygon(X, Y, 3);
	}
	
	public static Polygon getUpTriangle() {
		int[] X = {0, 30, 60};
		int[] Y = {60, 30, 60};
		return new Polygon(X, Y, 3);
	}
	
	public static Polygon getDownTriangle() {
		int[] X = {0, 30, 60};
		int[] Y = {0, 30, 0};
		return new Polygon(X, Y, 3);
	}
	
	public static Polygon getSquare() {
		int[] X = {0, 60, 60, 0};
		int[] Y = {0, 0, 60, 60};
		return new Polygon(X, Y, 4);
	}
}
