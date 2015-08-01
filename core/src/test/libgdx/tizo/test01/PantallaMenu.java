package test.libgdx.tizo.test01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PantallaMenu extends Pantalla {
	
	Texture img_ini01;
	
	private OrthographicCamera camara;
	
	private BitmapFont fuente;
	
	GlyphLayout layout;
	
	int[] text_x = new int[4];
	int[] text_y = new int[4];
	
	CharSequence[] str_inicio = new CharSequence[4];
	
	int p_width;
	int p_height;
	
	int pos_x_graf=0;
	int dir_graf = 1;
    
	int count;
	
	int saliendo=0;
	
	public PantallaMenu(TestInicio game) {
		
		
		
		super(game);
		// TODO Auto-generated constructor stub
	
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		img_ini01  = new Texture("T120SOFT_02.png");
		p_width  = Gdx.graphics.getWidth();
		p_height = Gdx.graphics.getHeight();
		
		camara = new OrthographicCamera(p_width,p_height);
		
		layout = new GlyphLayout();
		
		fuente = new BitmapFont(Gdx.files.internal("font001.fnt"),false);
		str_inicio[0] = " T120 Soft Apps ";
		str_inicio[1] = "EMPEZAR";
		str_inicio[2] = "OPCIONES";
		str_inicio[3] = "SALIR";
		count = 0;

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.setProjectionMatrix(camara.combined);
		
		int img_width = img_ini01.getWidth();
		//int img_height = img_ini01.getHeight();
		
		
		
		game.batch.begin();
		if (saliendo==0){
			
		
			game.batch.draw(img_ini01, pos_x_graf, 0);
	
			pos_x_graf = pos_x_graf + dir_graf;		
			if (pos_x_graf> p_width - img_width) {
				dir_graf = -1;
			}else{
				if (pos_x_graf < 0){
					dir_graf = 1;
				}
				
			}
				
			
	
			if (count<10){
				fuente.setColor(1, 1, 1, 1);
			}else{
				fuente.setColor(0, 0, 0, 1);
				if (count>19){
					
					count = 0;
				}
			}
			
			
			layout.setText(fuente, str_inicio[0]);		
			text_x[0]= (int) layout.width;
			text_y[0]= (int) layout.height;
			fuente.draw( game.batch, str_inicio[0], (p_width/2) - (text_x[0]/2), (p_height) );
			
			count = count +1;
			
			fuente.setColor(1, 1, 1, 1);
			
			layout.setText(fuente, str_inicio[1]);		
			text_x[1]= (int) layout.width;
			text_y[1]= (int) layout.height;
			fuente.draw( game.batch, str_inicio[1], (p_width/2) - (text_x[1]/2), (p_height/2) + (text_y[1]*2) );
			
			layout.setText(fuente, str_inicio[2]);		
			text_x[2]= (int) layout.width;
			text_y[2]= (int) layout.height;
			fuente.draw( game.batch, str_inicio[2], (p_width/2) - (text_x[2]/2), (p_height/2)  );
			
			layout.setText(fuente, str_inicio[3]);
			text_x[3]= (int) layout.width;
			text_y[3]= (int) layout.height;
			fuente.draw( game.batch, str_inicio[3], (p_width/2) - (text_x[3]/2), (p_height/2) - (text_y[3]*2) );
			
			// comprobamos si se tocado la pantalla
			if (Gdx.input.isTouched()){
				
				// encima de jugar
				if ( Gdx.input.getX() > ((p_width/2) - (text_x[1]/2)) && Gdx.input.getX() < ((p_width/2) + (text_x[1]/2) ) 
					 && (p_height-Gdx.input.getY()) < ((p_height/2) + (text_y[1]*2)) && (p_height-Gdx.input.getY()) > ((p_height/2) + (text_y[1]*2) - text_y[1])	){
					fuente.setColor(0, 0, 0, 1);
					fuente.draw( game.batch, str_inicio[1], (p_width/2) - (text_x[1]/2), (p_height/2) + (text_y[1]*2) );				
				}
	
				// encima de opciones
				if ( Gdx.input.getX() > ((p_width/2) - (text_x[2]/2)) && Gdx.input.getX() < ( (p_width/2) + (text_x[2]/2) ) 
					 && (p_height-Gdx.input.getY()) > ( (p_height/2) - text_y[2] ) && (p_height-Gdx.input.getY()) < ((p_height/2) )	){
					fuente.setColor(0, 0, 0, 1);
					fuente.draw( game.batch, str_inicio[2], (p_width/2) - (text_x[2]/2), (p_height/2)  );
				}
				
				// encima de salir
				if ( Gdx.input.getX() > ((p_width/2) - (text_x[3]/2)) && Gdx.input.getX() < ((p_width/2) + (text_x[3]/2) ) 
					 && (p_height-Gdx.input.getY()) > ((p_height/2) - (text_y[3]*2) - text_y[3] ) && (p_height-Gdx.input.getY()) < ((p_height/2) - (text_y[3]*2))	){
					fuente.setColor(0, 0, 0, 1);
					fuente.draw( game.batch, str_inicio[3], (p_width/2) - (text_x[3]/2), (p_height/2) - (text_y[3]*2) );				
				}
				
			}
		}else{
			
			// saliendo 
			
		}
			
		game.batch.end();
		
		// cuando soltamos
		if (Gdx.input.justTouched()){
			// encima de jugar
			if ( Gdx.input.getX() > ((p_width/2) - (text_x[1]/2)) && Gdx.input.getX() < ((p_width/2) + (text_x[1]/2) ) 
				 && (p_height-Gdx.input.getY()) < ((p_height/2) + (text_y[1]*2)) && (p_height-Gdx.input.getY()) > ((p_height/2) + (text_y[1]*2) - text_y[1])	){
				
				
			}

			// encima de opciones
			if ( Gdx.input.getX() > ((p_width/2) - (text_x[2]/2)) && Gdx.input.getX() < ( (p_width/2) + (text_x[2]/2) ) 
				&& (p_height-Gdx.input.getY()) > ( (p_height/2) - text_y[2] ) && (p_height-Gdx.input.getY()) < ((p_height/2) )	){

				game.setScreen(game.p_opcion);
			
			}
			
			// encima de salir
			if ( Gdx.input.getX() > ((p_width/2) - (text_x[3]/2)) && Gdx.input.getX() < ((p_width/2) + (text_x[3]/2) ) 
				 && (p_height-Gdx.input.getY()) > ((p_height/2) - (text_y[3]*2) - text_y[3] ) && (p_height-Gdx.input.getY()) < ((p_height/2) - (text_y[3]*2))	){
							
			}		
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
