package aroua.Command;

import aroua.Impl.Controller;

public class Controller1 implements Command {
	private Controller ctl;
	
	public Controller1(Controller ctl) {
		this.ctl = ctl;
	}

	
	public void execute() {
		ctl.tocMesure();
	}

}
