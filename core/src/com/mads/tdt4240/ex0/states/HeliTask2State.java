package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mads.tdt4240.ex0.Exercise_0;
import com.mads.tdt4240.ex0.sprites.Heli;


public class HeliTask2State extends State {

    BitmapFont font = new BitmapFont();

    private Texture background;
    private Heli heli;


    public HeliTask2State(GameStateManager gsm){
        super(gsm);
        background = new Texture("bg_heli.png");
        heli = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT / 2);
        heli.setRandomVelocity();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 touchPosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            heli.touchControl(touchPosition);
            }
            //Heli newHeli = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT / 2);
            //newHeli.setRandomVelocity();
            //helis.add(newHeli);

            //gsm.set(new MenuState(gsm));
            //dispose();

    }



    @Override
    public void update(float dt) {
        handleInput();
        heli.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Exercise_0.WIDTH, Exercise_0.HEIGHT);
        sb.draw(heli.getTexture(), heli.getPosition().x, heli.getPosition().y);
        font.draw(sb, "x: "+heli.getPosition().x+"y:"+heli.getPosition().y,10, Exercise_0.HEIGHT-25);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
