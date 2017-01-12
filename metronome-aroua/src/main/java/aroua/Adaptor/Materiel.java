package aroua.Adaptor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import aroua.Adaptor.Impl.AfficheurImpl;
import aroua.Adaptor.Impl.ClavierImpl;
import aroua.Adaptor.Impl.EmetteurSonoreImpl;
import aroua.Adaptor.Impl.HorlogeImpl;
import aroua.Adaptor.Impl.MoletteImpl;

public class Materiel extends JFrame implements Runnable {

	Thread thread = null;

	private static final long serialVersionUID = -5192156375496015580L;

	public static final int DEC = 0, INC = 1, START = 2, STOP = 3;

	private static Horloge horloge;
	private static Clavier clavier;
	private static Molette molette;
	private static Afficheur afficheur;
	private static EmetteurSonore emetteurSonore;

	public static void setEmetteurSonore(EmetteurSonore emetteurSonore) {
		Materiel.emetteurSonore = emetteurSonore;
	}

	public Materiel() {
		horloge = new HorlogeImpl();
		clavier = new ClavierImpl();
		molette = new MoletteImpl();
		afficheur = new AfficheurImpl(this);
		emetteurSonore = new EmetteurSonoreImpl();

		this.setPreferredSize(new Dimension(700, 300));
		this.setSize(getPreferredSize());

		this.setVisible(true);
		this.setLayout(new BorderLayout());

		this.add((Component) clavier, BorderLayout.SOUTH);
		this.add((Component) afficheur, BorderLayout.CENTER);
		this.add((Component) molette, BorderLayout.WEST);

		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});

		this.pack();
	}

	public Horloge getHorloge() {
		return horloge;
	}

	public Clavier getClavier() {
		return clavier;
	}

	public Molette getMolette() {
		return molette;
	}

	public EmetteurSonore getEmetteurSonore() {
		return emetteurSonore;
	}

	public Afficheur getAfficheur() {
		return afficheur;
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		thread = null;
	}

	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			repaint();
		}
		thread = null;
	}
}
