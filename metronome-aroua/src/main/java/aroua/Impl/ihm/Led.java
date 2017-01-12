package aroua.Impl.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import aroua.Adaptor.Horloge;
import aroua.Impl.EteindreLed;

public class Led extends JPanel {

	private static final long serialVersionUID = -6091974581548617909L;
	
	public static final int LEDTEMPS = 0;
	
	public static final int LEDMESURE = 1;
	
	private Horloge h;
	private Color c;

	private Color activeColor;

	public Color getActiveColor() {
		return activeColor;
	}

	public void setActiveColor(Color activeColor) {
		this.activeColor = activeColor;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public Led(Color c, Horloge h) {
		super();
		this.h = h;
		this.c = c;
		Dimension dimension = new Dimension(50, 50);
		this.setPreferredSize(dimension);
		this.setSize(dimension);
		this.setVisible(true);
		this.setOpaque(true);
		this.activeColor = Color.LIGHT_GRAY;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(this.activeColor);
		g.fillOval(5, 5, 20, 20);
	}
	
	public void update(int i) {
		if (i == LEDTEMPS)
			h.desactiver();
		this.activeColor = c;
		this.repaint();
		h.activerApresDelai(new EteindreLed(this), 150);
	}
	
}
