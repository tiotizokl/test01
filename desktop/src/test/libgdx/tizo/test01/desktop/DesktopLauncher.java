package test.libgdx.tizo.test01.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import test.libgdx.tizo.test01.TestInicio;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width=800;
		config.height=600;
		
		new LwjglApplication(new TestInicio(), config);
	}
}
