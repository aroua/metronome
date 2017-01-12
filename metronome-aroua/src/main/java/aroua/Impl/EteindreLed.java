package aroua.Impl;

import java.awt.Color;

import aroua.Command.Command;
import aroua.Impl.ihm.Led;

public class EteindreLed implements Command {
	
	private Led led;
	
	public EteindreLed(Led led) {
		this.led = led;
	}

	
	public void execute() {
		led.setActiveColor(Color.LIGHT_GRAY);
	}

}
