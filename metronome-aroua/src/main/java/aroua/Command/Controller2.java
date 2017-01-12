package aroua.Command;

import aroua.Impl.Controller;

public class Controller2 implements Command {
	private Controller ctl;
	
	public Controller2(Controller ctl) {
		this.ctl = ctl;
	}

	
	public void execute() {
		ctl.tocTemps();
	}

}
