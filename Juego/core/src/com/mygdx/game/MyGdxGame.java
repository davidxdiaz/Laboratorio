package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture img2;
	Texture img3;
	Texture img4;
	Texture img5;
	Texture mario;
	Texture sun;
	Texture marioo,tvoladora,nube,hongo;
	Texture tortuga,moneda,letrero;

	int moverMario=0;
	int saltarMario=123;
	int nx=300,ny=350,tx=500,ty=230;

	Animation animMario , animSun;

	float tiempopasado = 0f;

	@Override
	public void create () {
		batch = new SpriteBatch();

		hongo=new Texture("hongo.png");
		img = new Texture("FondoBueno.jpg");
		img2= new Texture("ladrillosma.png");
		img3= new Texture("Elmario.png");
		img4= new Texture("GT.png");
		mario= new Texture("mario.png");
		marioo= new Texture ("Mario_HUD.png");
		sun= new Texture("sun.png");
		tvoladora= new Texture("img7.png");
		nube=new Texture("img8.png");
		tortuga = new Texture("t.png");
		moneda=new Texture("moneda.png");
		letrero=new Texture("letras.png");


		TextureRegion mariotmp[][]=TextureRegion.split(mario, mario.getWidth()/20,mario.getHeight()/1);
		TextureRegion suntmp[][]=TextureRegion.split(sun, sun.getWidth()/6,sun.getHeight()/1);

		TextureRegion marioTR[]=new TextureRegion[20];
		marioTR[0]=mariotmp[0][0];
		marioTR[1]=mariotmp[0][1];
		marioTR[2]=mariotmp[0][2];
		marioTR[3]=mariotmp[0][3];
		marioTR[4]=mariotmp[0][4];
		marioTR[5]=mariotmp[0][5];
		marioTR[6]=mariotmp[0][6];
		marioTR[7]=mariotmp[0][7];
		marioTR[8]=mariotmp[0][8];
		marioTR[9]=mariotmp[0][9];
		marioTR[10]=mariotmp[0][10];
		marioTR[11]=mariotmp[0][11];
		marioTR[12]=mariotmp[0][12];
		marioTR[13]=mariotmp[0][13];
		marioTR[14]=mariotmp[0][14];
		marioTR[15]=mariotmp[0][15];
		marioTR[16]=mariotmp[0][16];
		marioTR[17]=mariotmp[0][17];
		marioTR[18]=mariotmp[0][18];
		marioTR[19]=mariotmp[0][19];

		TextureRegion sunTR[]=new TextureRegion[6];
		sunTR[0]=suntmp[0][0];
		sunTR[1]=suntmp[0][1];
		sunTR[2]=suntmp[0][2];
		sunTR[3]=suntmp[0][3];
		sunTR[4]=suntmp[0][4];
		sunTR[5]=suntmp[0][5];

		animMario=new Animation(0.1f,marioTR);
		animMario.setPlayMode(Animation.PlayMode.LOOP);

		animSun=new Animation(0.1f,sunTR);
		animSun.setPlayMode(Animation.PlayMode.LOOP);




	}

	@Override
	public void render () {
		tiempopasado+=Gdx.graphics.getDeltaTime();
		TextureRegion frameMario= animMario.getKeyFrame(tiempopasado);
		TextureRegion frameSun= animSun.getKeyFrame(tiempopasado);
		//Tortuga voladora

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			moverMario++;
		}else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			moverMario--;
		}

		//SALDAR MARIO
		if(saltarMario<148){
			if(Gdx.input.isKeyPressed(Input.Keys.UP)){
				saltarMario+=25;

			}
		}

		if (saltarMario>=124){
			saltarMario-=2;
		}
		//animacion toruga
		tx-=2;
		if(ty<260){
			ty++;
		}
		if(ty==260){
			ty=230;
		}
		if(tx<-5){
			tx=600;
		}
		//Animacion nube
		nx--;
		if(nx<-5){
			nx=600;
		}
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 90);
		batch.draw(img2, 0, 1);
		batch.draw(frameMario, moverMario, saltarMario);
		batch.draw(img4, 350, 120);
		batch.draw(frameSun, 0, 375,100,100);
		batch.draw(marioo,400, 375);
		batch.draw(tvoladora,tx,ty);
		batch.draw(nube,nx,ny);
		batch.draw(tortuga,90,123);
		batch.draw(letrero,250,0);
		batch.draw(moneda,300,300);
		batch.draw(hongo,200,123);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
