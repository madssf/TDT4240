package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.mads.tdt4240.ex0.Exercise_0;

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm){
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");

    }

    @Override
    public void handleInput() {

        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
            gsm.set(new HeliTask1State(gsm));
        } else if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            gsm.set(new HeliTask2State(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Exercise_0.WIDTH, Exercise_0.HEIGHT);
        sb.draw(playBtn, (Exercise_0.WIDTH / 2) - (playBtn.getWidth() / 2), Exercise_0.HEIGHT / 2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
