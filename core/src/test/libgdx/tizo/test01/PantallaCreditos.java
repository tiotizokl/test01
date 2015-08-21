package test.libgdx.tizo.test01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PantallaCreditos extends Pantalla {
	
	Texture img_ini01;
	
	TextureRegion texture_fondo;
	TextureRegion texture_logo;
	
	private OrthographicCamera camara;
	
	private BitmapFont fuente;
	
	GlyphLayout layout;
	
	CharSequence[] str_inicio = new CharSequence[8];
	
	int p_width;
	int p_height;
	
	float propor_xWidth;
	float propor_yheight;
    
	int count;
	
	public PantallaCreditos(TestInicio game) {
		
		
		
		super(game);
		// TODO Auto-generated constructor stub
	
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		img_ini01  = new Texture("fondocreditos01.png");
		p_width  = Gdx.graphics.getWidth();
		p_height = Gdx.graphics.getHeight();
		
		propor_xWidth = (float) (p_width) / 800;
		propor_yheight = (float) (p_height) / 600;
		
		texture_fondo = new TextureRegion(img_ini01, 0, 0, 800, 600);
		texture_logo = new TextureRegion(img_ini01, 0, 600, 256, 256);
		
		camara = new OrthographicCamera(p_width,p_height);
		
		layout = new GlyphLayout();
		
		fuente = new BitmapFont(Gdx.files.internal("font002.fnt"),false);
		str_inicio[0] = "Creditos:";
		str_inicio[1] = " ( cc ) 2015 T120 Soft ";
		str_inicio[2] = "Programacion:";
		str_inicio[3] = " Tizo A. Marchal";
		str_inicio[4] = "Graficos y sonido:";
		str_inicio[5] = " Tizo A. Marchal";
		str_inicio[6] = "------------------";
		str_inicio[7] = " tiotizo.kl@gmail.com";
		count = 0;

	}

	@Override
	public void render(float delta) {
		
						
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.setProjectionMatrix(camara.combined);
		
		int img_width = texture_logo.getRegionWidth();
		int img_height = texture_logo.getRegionHeight();
		
		game.batch.begin();
	
		game.batch.draw(texture_fondo, 0, 0, p_width, p_height );
	
		game.batch.draw(texture_logo, convert_Xwidth(p_width-(img_width+10)), convert_Yheight(p_height-(img_height+10)), convert_Xwidth(img_width), convert_Yheight(img_height) );
		
		
		layout.setText(fuente, str_inicio[0]);
		
		fuente.setColor(0, 0, 0, 1);
		fuente.draw( game.batch, str_inicio[0], 22, 8+count );
		fuente.setColor(0, 1, 1, 1);
		fuente.draw( game.batch, str_inicio[0], 20, 10+count );
		fuente.setColor(0, 0, 0, 1);
		fuente.draw( game.batch, str_inicio[1], 22, 8+count-(layout.height+4) );
		fuente.setColor(0, 1, 1, 1);
		fuente.draw( game.batch, str_inicio[1], 20, 10+count-(layout.height+4) );

		fuente.setColor(0, 0, 0, 1);
		fuente.draw( game.batch, str_inicio[2], 22, 8+count-((layout.height+4)*2)-10 );
		fuente.setColor(0, 1, 0, 1);
		fuente.draw( game.batch, str_inicio[2], 20, 10+count-((layout.height+4)*2)-10 );
		fuente.setColor(0, 0, 0, 1);
		fuente.draw( game.batch, str_inicio[3], 22, 8+count-((layout.height+4)*3)-10 );
		fuente.setColor(0, 1, 0, 1);
		fuente.draw( game.batch, str_inicio[3], 20, 10+count-((layout.height+4)*3)-10 );

		fuente.setColor(0, 0, 0, 1);
		fuente.draw( game.batch, str_inicio[4], 22, 8+count-((layout.height+4)*4)-20 );
		fuente.setColor(0, 1, 0, 1);
		fuente.draw( game.batch, str_inicio[4], 20, 10+count-((layout.height+4)*4)-20 );
		fuente.setColor(0, 0, 0, 1);
		fuente.draw( game.batch, str_inicio[5], 22, 8+count-((layout.height+4)*5)-20 );
		fuente.setColor(0, 1, 0, 1);
		fuente.draw( game.batch, str_inicio[5], 20, 10+count-((layout.height+4)*5)-20 );
		
		fuente.setColor(0, 0, 0, 1);
		fuente.draw( game.batch, str_inicio[6], 22, 8+count-((layout.height+4)*6)-35 );
		fuente.setColor(1, 1, 0, 1);
		fuente.draw( game.batch, str_inicio[6], 20, 10+count-((layout.height+4)*6)-35 );

		fuente.setColor(0, 0, 0, 1);
		fuente.draw( game.batch, str_inicio[7], 22, 8+count-((layout.height+4)*7)-45 );
		fuente.setColor(1, 1, 0, 1);
		fuente.draw( game.batch, str_inicio[7], 20, 10+count-((layout.height+4)*7)-45 );
		
		count = count +1;
		
		if (count> p_height+10+((layout.height+4)*8)+55){
			count = 0;
		}

	
		game.batch.end();
		
		// comprobamos si se tocado la pantalla
		if (Gdx.input.isTouched()){
		
		}
		if (Gdx.input.justTouched()){
			if (Gdx.input.getX() > convert_Xwidth(p_width-320) && Gdx.input.getX() < convert_Xwidth(p_width) &&
				Gdx.input.getY() > convert_Yheight(p_height-60) && Gdx.input.getY() < convert_Yheight(p_height))
			    game.setScreen(game.p_opcion);
		
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

	
	public int convert_Xwidth( int x ) {
		float result;
		int vfinal;
		float x_f;
		
		x_f = x;
		
		result =  x_f * propor_xWidth;
		
		vfinal = (int) result;
		
		
		
		return(vfinal);
	}
	
	public int convert_Yheight( int y){
		float  result;
		int vfinal;
		float y_f;
		
		y_f = y;
		
		result =   y_f * propor_yheight;
		
		vfinal = (int) result;
		
		return(vfinal);
	}
	
}
