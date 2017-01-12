package aroua.Adaptor.Impl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;

import aroua.Adaptor.Molette;

public class MoletteImpl extends JSlider implements Molette {

	private static final int FPS_MIN = 10;

	private static final int FPS_MAX = 300;

	private static final long serialVersionUID = 8638819685686085952L;
	
	private int tempo;

	public MoletteImpl() {
		super(JSlider.VERTICAL);
		this.setName("Tempo");
		this.setMaximum(FPS_MAX);
		this.setMinimum(FPS_MIN);
		this.setValue(120);

		tempo = 120;

		this.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				tempo = getValue();
			}
		});
		
		this.setPaintTicks(true);
		
		this.setPaintLabels(true);
		
		this.setMajorTickSpacing(40);
		
	}

	
	public float position() {
		return tempo;
	}

}
