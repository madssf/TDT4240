package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mads.tdt4240.ex0.Exercise_0;
import com.mads.tdt4240.ex0.sprites.Heli;


public class HeliTask1State extends State {

    private Texture background;
    private Heli heli1, heli2, heli3;


    public HeliTask1State(GameStateManager gsm){
        super(gsm);
        background = new Texture("bg_heli.png");
        heli1 = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT - 100);
        heli2 = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT / 2);
        heli3 = new Heli(Exercise_0.WIDTH / 2, 100);
        heli1.setRandomVelocity();
        heli2.setRandomVelocity();
        heli3.setRandomVelocity();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new MenuState(gsm));
//            dispose();

        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        if (heli1.collides(heli2.getBounds())) {
            System.out.println("Collision 1 and 2");
        }
        if (heli1.collides(heli3.getBounds())) {
            System.out.println("Collision 1 and 3");
        }
        if (heli2.collides(heli3.getBounds())) {
            System.out.println("Collision 2 and 3");
        }
        heli1.update(dt);
        heli2.update(dt);
        heli3.update(dt);
    }




    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Exercise_0.WIDTH, Exercise_0.HEIGHT);
        sb.draw(heli1.getTexture(), heli1.getPosition().x, heli1.getPosition().y);
        sb.draw(heli2.getTexture(), heli2.getPosition().x, heli3.getPosition().y);
        sb.draw(heli3.getTexture(), heli3.getPosition().x, heli3.getPosition().y);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
