package aroua.Impl;

import aroua.Adaptor.Materiel;
import aroua.Adaptor.Impl.Adaptor;
import aroua.Adaptor.Impl.HorlogeImpl;
import aroua.Command.Command;
import aroua.Command.Controller1;
import aroua.Command.Controller2;

public class Metronome {
	
	static Controller ctl = new Controller();
	static MoteurMetronome mot = new MoteurMetronome();
	static Materiel mat = new Materiel();
	
	public static void main(String[] args) {
		Adaptor adapt = new Adaptor(mat, ctl);
		
		ctl.setMoteur(mot);
		ctl.setAdaptor(adapt);
		
		Command tocTemps = new Controller2(ctl);
		Command tocMesure = new Controller1(ctl);
		
		mot.setTocTemps(tocTemps);
		mot.setTocMesure(tocMesure);
		mot.setTempo(120);
		mot.setMesure(4);
		mot.setEnMarche(false);
		mat.start();
		(new HorlogeImpl()).activerPeriodiquement(adapt, 100);
	}

}
