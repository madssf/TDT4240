package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mads.tdt4240.ex0.Exercise_0;
import com.mads.tdt4240.ex0.sprites.Button;
import com.mads.tdt4240.ex0.sprites.Heli;



public class HeliTask1State extends State {


    private Texture background;
    private Heli heli1, heli2, heli3;
    private Button exit;



    public HeliTask1State(GameStateManagerSingleton gsm){
        super(gsm);
        background = new Texture("bg_heli.png");
        exit = new Button("exit.png");
        exit.setPosition(Exercise_0.WIDTH/2 - exit.getTexture().getWidth()/2 ,Exercise_0.HEIGHT - exit.getTexture().getHeight());        heli1 = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT - 100);
        heli2 = new Heli(Exercise_0.WIDTH / 2, Exercise_0.HEIGHT / 2);
        heli3 = new Heli(Exercise_0.WIDTH / 2, 100);
        heli1.setRandomVelocity();
        heli2.setRandomVelocity();
        heli3.setRandomVelocity();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touch);
            if (exit.getBounds().contains(touch.x, touch.y)) {
                gsm.set(new MenuState(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        checkCollision();
        heli1.update(dt);
        heli2.update(dt);
        heli3.update(dt);
    }

    private void doCollision(Heli heliA, Heli heliB) {
        Rectangle intersection = new Rectangle();
        Intersector.intersectRectangles(heliA.getBounds(), heliB.getBounds(), intersection);
        if (intersection.x > heliA.getBounds().getX() || (intersection.x + intersection.width < heliA.getBounds().getX() + heliA.getBounds().getWidth())) {
            heliA.collideVertical();
            heliB.collideVertical();
        }
        if (intersection.y > heliA.getBounds().getY() || (intersection.y + intersection.height < heliA.getBounds().getY() + heliA.getBounds().getHeight())) {
            heliA.collideHorizontal();
            heliB.collideHorizontal();
        }
    }


    private void checkCollision() {
        if(heli1.getBounds().overlaps(heli2.getBounds())) {
            doCollision(heli1, heli2);
        }
        if(heli1.getBounds().overlaps(heli3.getBounds())){
            doCollision(heli1, heli3);
        }
        if(heli2.getBounds().overlaps(heli3.getBounds())){
            doCollision(heli2, heli3);
        }
    }


    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        sb.draw(background, cam.position.x - cam.viewportWidth / 2, 0);
        sb.draw(heli1.getTexture(), heli1.getPosition().x, heli1.getPosition().y);
        sb.draw(heli2.getTexture(), heli2.getPosition().x, heli2.getPosition().y);
        sb.draw(heli3.getTexture(), heli3.getPosition().x, heli3.getPosition().y);
        sb.draw(exit.getTexture(), exit.getPosition().x, exit.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
