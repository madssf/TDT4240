package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mads.tdt4240.ex0.Exercise_0;
import com.mads.tdt4240.ex0.sprites.Heli;


public class HeliTask1State extends State {

    private Texture background;
    private Array<Heli> helis = new Array<Heli>();


    public HeliTask1State(GameStateManager gsm){
        super(gsm);
        background = new Texture("bg_heli.png");
        Heli heli1 = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT / 2);
        heli1.setRandomVelocity();
        helis.add(heli1);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            //Heli newHeli = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT / 2);
            //newHeli.setRandomVelocity();
            //helis.add(newHeli);

            gsm.set(new MenuState(gsm));
            //dispose();

        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        for (Heli heli : helis) {
            heli.checkCollision();
            heli.update(dt);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Exercise_0.WIDTH, Exercise_0.HEIGHT);
        for (Heli heli : helis) {
            sb.draw(heli.getTexture(), heli.getPosition().x, heli.getPosition().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
