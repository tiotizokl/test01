package test.libgdx.tizo.test01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PantallaJuego extends Pantalla {
	
	Texture img_ini01;
	
	private OrthographicCamera camara;
	
	private BitmapFont fuente;
	
	GlyphLayout layout;
	
	CharSequence[] str_inicio = new CharSequence[2];
	
	int p_width;
	int p_height;
    
	int count;
	
	public PantallaJuego(TestInicio game) {
		
		
		
		super(game);
		// TODO Auto-generated constructor stub
	
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		img_ini01  = new Texture("T120SOFT_01.png");
		p_width  = Gdx.graphics.getWidth();
		p_height = Gdx.graphics.getHeight();
		
		camara = new OrthographicCamera(p_width,p_height);
		
		layout = new GlyphLayout();
		
		fuente = new BitmapFont(Gdx.files.internal("font000.fnt"),false);
		str_inicio[0] = " T120 Soft Apps ";
		str_inicio[1] = "Pulsa para continuar";
		count = 0;

	}

	@Override
	public void render(float delta) {
		
						
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.setProjectionMatrix(camara.combined);
		
		int img_width = img_ini01.getWidth();
		int img_height = img_ini01.getHeight();
		
		game.batch.begin();
	
		game.batch.draw(img_ini01, (p_width/2)-(img_width/2), (p_height/2)-(img_height/2) );

		
		layout.setText(fuente, str_inicio[0]);		
		fuente.draw( game.batch, str_inicio[0], (p_width/2) - (layout.width/2), (p_height/2)+(img_height/2)+20+layout.height );
		
		count = count +1;
		if (count<15){
			layout.setText(fuente, str_inicio[1]);
			fuente.draw( game.batch, str_inicio[1], (p_width/2) - (layout.width/2), (p_height/2)-(img_height/2)-layout.height );
		}else{
			if (count>19){
				count = 0;
			}
		}
	
		game.batch.end();
		
		// comprobamos si se tocado la pantalla
		if (Gdx.input.isTouched()){
			game.setScreen(game.p_menu);
		}
		if (Gdx.input.justTouched()){
						
		}
	
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		p_width = width;
		p_height= height;
		
		camara.setToOrtho(false, width, height);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		img_ini01.dispose();
		fuente.dispose();
		
	}

}
