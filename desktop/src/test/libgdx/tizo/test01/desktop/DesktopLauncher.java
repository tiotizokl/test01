package test.libgdx.tizo.test01.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import test.libgdx.tizo.test01.TestInicio;
import com.badlogic.gdx.Files.FileType;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width=800;
		config.height=600;
		
		config.title = " T120Soft App. ";
		
		config.resizable = false;
		
		config.addIcon("T120SOFT_01.ico", FileType.Internal);
		
		new LwjglApplication(new TestInicio(), config);
	}
}
