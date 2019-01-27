package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 480);
        mouse = new Vector3();

    }

    protected abstract void handleInput();
    protected abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}