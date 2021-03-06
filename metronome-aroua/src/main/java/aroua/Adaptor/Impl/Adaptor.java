package aroua.Adaptor.Impl;

import aroua.Adaptor.Clavier;
import aroua.Adaptor.Materiel;
import aroua.Command.Command;
import aroua.Impl.Controller;
import aroua.Impl.ihm.Led;

public class Adaptor implements Command {

	private Materiel mat;
	private Controller ctl;
	private int oldTempo;

	public Adaptor(Materiel mat, Controller ctl) {
		this.mat = mat;
		this.ctl = ctl;
		oldTempo = 120;
	}

	public void execute() {
		Clavier cl = mat.getClavier();
		if (cl.touchePressee(Materiel.DEC))
			ctl.dec();
		if (cl.touchePressee(Materiel.INC))
			ctl.inc();
		if (cl.touchePressee(Materiel.START))
			ctl.start();
		if (cl.touchePressee(Materiel.STOP))
			ctl.stop();

		int newTempo = (int) mat.getMolette().position();
		if (oldTempo != newTempo) {
			ctl.setTempo(newTempo);
			mat.getAfficheur().afficherTempo(newTempo);
			oldTempo = newTempo;
		}
	}

	public void notifyTemps() {
		mat.getAfficheur().allumerLed(Led.LEDTEMPS);
		mat.getEmetteurSonore().emettreClic(Led.LEDTEMPS);
	}

	public void notifyMesure() {
		mat.getAfficheur().allumerLed(Led.LEDMESURE);
		mat.getEmetteurSonore().emettreClic(Led.LEDMESURE);
	}
}
