package aroua.Command;

import aroua.Impl.MoteurMetronome;

public class Controller implements Command {
	
	private MoteurMetronome mot;
	
	public Controller(MoteurMetronome mot) {
		this.mot = mot;
	}

	
	public void execute() {
		mot.toc();
	}

}
