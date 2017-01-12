package aroua.Adaptor.Impl;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import aroua.Adaptor.EmetteurSonore;
import aroua.Impl.ihm.Led;

public class EmetteurSonoreImpl implements EmetteurSonore {

	public EmetteurSonoreImpl() {}

	@Override
	public void emettreClic(int i) {
		String soundName = null;
		if (i == Led.LEDMESURE) {
			soundName = "src/main/resources/beep-03.wav";
		}
		else {
			soundName = "src/main/resources/beep-07.wav";
		}
		try {
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    stream = AudioSystem.getAudioInputStream(new File(soundName));
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
}
