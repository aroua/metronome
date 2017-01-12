package aroua.Adaptor.Impl;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import aroua.Adaptor.Afficheur;
import aroua.Adaptor.Materiel;
import aroua.Impl.ihm.Led;

public class AfficheurImpl extends JPanel implements Afficheur {
	
	private static final long serialVersionUID = -5772820268148350176L;
	
	private JLabel tempo;
	private Led ledTemps, ledMesure;
	
	public AfficheurImpl(Materiel mat) {
		tempo = new JLabel("120", SwingConstants.CENTER);
		ledTemps = new Led(Color.GREEN, mat.getHorloge());
		ledMesure = new Led(Color.RED, mat.getHorloge());
		
		this.setLayout(new BorderLayout());
		JPanel buttons = new JPanel();
		
		buttons.add(ledTemps,BorderLayout.WEST);
		
		buttons.add(ledMesure, BorderLayout.EAST);
		
		this.add(tempo ,BorderLayout.CENTER);
		this.add(buttons ,BorderLayout.EAST);
	}

	public void allumerLed(int numLED) {
		if (numLED == Led.LEDMESURE)
			ledMesure.update(numLED);
		else
			ledTemps.update(numLED);
	}

	public void eteindreLed(int numLED) {
	}

	
	public void afficherTempo(int valeurTempo) {
		tempo.setText(valeurTempo + " bpm");
	}

}
