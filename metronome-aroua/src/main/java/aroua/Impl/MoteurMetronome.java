package aroua.Impl;

import aroua.Adaptor.Horloge;
import aroua.Adaptor.Impl.HorlogeImpl;
import aroua.Command.Command;
import aroua.Command.Controller;

public class MoteurMetronome {

	private Horloge timer;
	private Command tocTemps, tocMesure;
	private boolean enMarche;
	private int mesure, t;
	private float tempo;

	public MoteurMetronome() {
		timer = new HorlogeImpl();

		enMarche = false;
		mesure = 4;
		t = 0;
	}

	public void setTocTemps(Command tocTemps) {
		this.tocTemps = tocTemps;
	}

	public void setTocMesure(Command tocMesure) {
		this.tocMesure = tocMesure;
	}

	public void toc() {
		t++;
		calcMesure();
	}

	private void calcMesure() {
		tocTemps.execute();
		if (t >= mesure) {
			tocMesure.execute();
			t = 0;
		}
	}

	public boolean getEtatMarche() {
		return enMarche;
	}

	public void setEnMarche(boolean actif) {
		enMarche = actif;

		if (enMarche) {
			float delay = 1000 / (tempo / 60);
			timer.activerPeriodiquement(new Controller(this), delay);
		} else {
			timer.desactiver();
			t = 0;
		}
	}

	public void inc() {
		if (mesure < Constantes.MAX_MESURE)
			mesure++;
	}

	public void dec() {
		if (mesure > Constantes.MIN_MESURE)
			mesure--;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
		if (enMarche) {
			timer.desactiver();
			float delay = 1000 / (tempo / 60);
			timer.activerPeriodiquement(new Controller(this), delay);
		}
	}

	public float getTempo() {
		return tempo;
	}

	public void setMesure(int mesure) {
		if (mesure >= Constantes.MIN_MESURE && mesure <= Constantes.MAX_MESURE)
			this.mesure = mesure;
	}

	public int getMesure() {
		return mesure;
	}
}
