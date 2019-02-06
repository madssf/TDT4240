package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mads.tdt4240.ex0.Exercise_0;
import com.mads.tdt4240.ex0.sprites.Button;
import com.mads.tdt4240.ex0.sprites.Heli;


public class HeliTask2State extends State {

    BitmapFont font = new BitmapFont();

    private Texture background;
    private Heli heli;
    private Button exit;



    public HeliTask2State(GameStateManagerSingleton gsm){
        super(gsm);
        background = new Texture("bg_heli.png");
        exit = new Button("exit.png");
        exit.setPosition(Exercise_0.WIDTH/2 - exit.getTexture().getWidth()/2 ,Exercise_0.HEIGHT - exit.getTexture().getHeight());
        heli = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT / 2);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touch);
            heli.touchControl(touch);
            if (exit.getBounds().contains(touch.x, touch.y)) {
                gsm.set(new MenuState(gsm));
            }
            }
    }



    @Override
    public void update(float dt) {
        handleInput();
        heli.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(heli.getTexture(), heli.getPosition().x, heli.getPosition().y);
        font.draw(sb, "x: "+heli.getPosition().x+"y:"+heli.getPosition().y,10, Exercise_0.HEIGHT-25);
        sb.draw(exit.getTexture(), exit.getPosition().x, exit.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
