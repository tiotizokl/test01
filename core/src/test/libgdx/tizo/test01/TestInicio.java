package test.libgdx.tizo.test01;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TestInicio extends Game {
	SpriteBatch batch;
	
	public Pantalla p_inicio;
	public Pantalla p_menu;
	public Pantalla p_juego;
	public Pantalla p_opcion;
	public Pantalla p_creditos;
	
	@Override
	public void create () {
		batch = new SpriteBatch();		
				
		p_inicio = new PantallaInicio(this);
		p_menu = new PantallaMenu(this);
		p_juego = new PantallaJuego(this);
		p_opcion = new PantallaOpcion(this);
		p_creditos = new PantallaCreditos(this);
		
		setScreen(p_inicio);
	}
}
