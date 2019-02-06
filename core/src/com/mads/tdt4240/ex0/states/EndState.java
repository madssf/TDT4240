package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mads.tdt4240.ex0.Exercise_0;

public class EndState extends State{
    private Texture bg;
    BitmapFont font = new BitmapFont();
    private String winner;


    public EndState(GameStateManagerSingleton gsm, String paddle) {
        super(gsm);
        bg = new Texture("bg.png");
        this.winner = paddle;
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));

        }
    }


    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, 0, 0,(Exercise_0.WIDTH),(Exercise_0.HEIGHT));
        font.draw(sb, winner + " won!", Exercise_0.WIDTH/ 2, Exercise_0.HEIGHT / 2);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
