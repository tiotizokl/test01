package test.libgdx.tizo.test01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PantallaOpcion extends Pantalla {
	
	Texture img_ini01;
	
	TextureRegion img_fondo01;
	TextureRegion img_led01;
	
	TextureRegion [] cartel_menu = new TextureRegion [4];
	
	CharSequence[] str_inicio = new CharSequence[2];
	
	private OrthographicCamera camara;	
	
	int p_width;
	int p_height;
	
	float propor_xWidth;
	float propor_yheight;
    

	
	public PantallaOpcion(TestInicio game) {
		
		
		
		super(game);
		// TODO Auto-generated constructor stub
	
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		img_ini01  = new Texture("cuadricula001.png");
		p_width  = Gdx.graphics.getWidth();
		p_height = Gdx.graphics.getHeight();
		
		propor_xWidth = (float) (p_width) / 800;
		propor_yheight = (float) (p_height) / 600;
		
		
		img_fondo01 = new TextureRegion(img_ini01, 0, 0, 800, 600);
		
		img_led01 = new TextureRegion(img_ini01, 0, 600, 80, 60);
		
		camara = new OrthographicCamera(p_width,p_height);
		
		
		cartel_menu[0] = new TextureRegion(img_ini01, 80, 600, 320, 60);
		cartel_menu[1] = new TextureRegion(img_ini01, 80, 660, 320, 60);
		cartel_menu[2] = new TextureRegion(img_ini01, 80, 720, 320, 60);
		cartel_menu[3] = new TextureRegion(img_ini01, 400, 600, 320, 60);
		
	}

	@Override
	public void render(float delta) {
		int valorx, valory;
		int count_val;
						
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.setProjectionMatrix(camara.combined);
		
		
		game.batch.begin();
	
		game.batch.draw(img_fondo01, 0 , 0 , p_width, p_height);
		
		for (count_val=0; count_val<3; count_val++ ){
			
			valorx = (int) (Math.random()*10);
			valory = (int) (Math.random()*10);
			game.batch.draw(img_led01, convert_Xwidth(80)*valorx , convert_Yheight(60)*valory , convert_Xwidth(80) , convert_Yheight(60));
		}
		
		
		game.batch.draw( cartel_menu[0],(p_width/2)-convert_Xwidth(160), (p_height/2)+convert_Yheight(90), convert_Xwidth(320) , convert_Yheight(60));
		game.batch.draw( cartel_menu[1],(p_width/2)-convert_Xwidth(160), (p_height/2)-convert_Yheight(30), convert_Xwidth(320) , convert_Yheight(60));
		game.batch.draw( cartel_menu[2],(p_width/2)-convert_Xwidth(160), (p_height/2)-convert_Yheight(150), convert_Xwidth(320) , convert_Yheight(60));
		
		game.batch.end();
		
		// comprobamos si se tocado la pantalla
		if (Gdx.input.isTouched()){
	
		}
		
		// comprobamos si se ha "soltado" la pantalla
		if (Gdx.input.justTouched()){
			
			// volver atras
			if (Gdx.input.getX()>(p_width/2)-convert_Xwidth(160) && Gdx.input.getX()<(p_width/2)+convert_Xwidth(160) &&
				(p_height-Gdx.input.getY())>(p_height/2)-convert_Yheight(150) && (p_height-Gdx.input.getY())<(p_height/2)-convert_Yheight(90) ){
				game.setScreen(game.p_menu);
				
			}
			
			// a pantalla de creditos
			if (Gdx.input.getX()>(p_width/2)-convert_Xwidth(160) && Gdx.input.getX()<(p_width/2)+convert_Xwidth(160) &&
					(p_height-Gdx.input.getY())>(p_height/2)-convert_Yheight(30) && (p_height-Gdx.input.getY())<(p_height/2)+convert_Yheight(30) ){
					game.setScreen(game.p_creditos);
					
			}
			
						
		}
	
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		//p_width = width;
		//p_height= height;
		
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
