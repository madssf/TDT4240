package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mads.tdt4240.ex0.Exercise_0;
import com.mads.tdt4240.ex0.sprites.Button;
import com.mads.tdt4240.ex0.sprites.Paddle;

public class MenuState extends State {

    private Texture background;
    private Button task1_3;
    private Button task2;
    private Button task4;



    public MenuState(GameStateManagerSingleton gsm){
        super(gsm);
        background = new Texture("bg.png");
        task1_3 = new Button("task1+3.png");
        task2 = new Button("task2.png");
        task4 = new Button("task4.png");
        task1_3.setPosition(Exercise_0.WIDTH / 2 - task1_3.getTexture().getWidth() /2, Exercise_0.HEIGHT - (3/2)* task1_3.getTexture().getHeight());
        task2.setPosition(Exercise_0.WIDTH / 2 - task2.getTexture().getWidth() /2, Exercise_0.HEIGHT / 2 - task2.getTexture().getHeight()/2);
        task4.setPosition(Exercise_0.WIDTH / 2 - task4.getTexture().getWidth() /2, task4.getTexture().getHeight()/3);
    }

    @Override
    public void handleInput() {

        if(Gdx.input.justTouched()) {
            Vector3 touchPosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPosition);
            if(task1_3.getBounds().contains(touchPosition.x, touchPosition.y)){
                gsm.set(new HeliTask1State(gsm));
            }
            if(task2.getBounds().contains(touchPosition.x, touchPosition.y)){
                gsm.set(new HeliTask2State(gsm));
            }
            if(task4.getBounds().contains(touchPosition.x, touchPosition.y)){
                Paddle paddleL = new Paddle(0 , Exercise_0.HEIGHT/2 + 50);
                Paddle paddleR = new Paddle(Exercise_0.WIDTH-paddleL.getTexture().getWidth(), Exercise_0.HEIGHT/2 + 50);
                gsm.set(new PongState(gsm, paddleL, paddleR));
            }

        }
    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(task1_3.getTexture(), task1_3.getPosition().x, task1_3.getPosition().y);
        sb.draw(task2.getTexture(), task2.getPosition().x, task2.getPosition().y);
        sb.draw(task4.getTexture(), task4.getPosition().x, task4.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        task1_3.getTexture().dispose();
        task2.getTexture().dispose();
        task4.getTexture().dispose();
    }
}
