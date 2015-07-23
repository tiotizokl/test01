package test.libgdx.tizo.test01;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TestInicio extends Game {
	SpriteBatch batch;
	
	public Pantalla p_inicio;
			
	@Override
	public void create () {
		batch = new SpriteBatch();		
				
		p_inicio = new PantallaInicio(this);
		
		setScreen(p_inicio);
	}
}
