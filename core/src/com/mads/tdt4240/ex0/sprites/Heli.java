package com.mads.tdt4240.ex0.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mads.tdt4240.ex0.Exercise_0;

import java.util.Random;

public class Heli {

    private static final float MOVEMENT = 0.5f;
    private static final float FRAME_DURATION = 0.1f;

    private float timePassed = 0;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;

    private Texture heli;


    public Heli(int x, int y){

        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0 ,0);
        heli = new Texture("heliL_1.png");
        bounds =  new Rectangle(x, y, heli.getWidth(), heli.getHeight());
    }

    public void update(Float dt) {
        position.add(velocity);
        checkWallCollision();
        setTexture();
        bounds.setPosition(position.x, position.y);
    }

    public void setRandomVelocity() {
        Random rand = new Random();
        velocity.add(rand.nextInt(3)+1, rand.nextInt(3)+1, 0);
        if (rand.nextBoolean()) {
            velocity.x = -velocity.x;
        }
        if (rand.nextBoolean()) {
            velocity.y = -velocity.y;
        }
        velocity.scl(MOVEMENT);
        setTexture();
    }

    public void checkWallCollision() {

        if(position.x > Exercise_0.WIDTH - heli.getWidth() || position.x < 0) {
            velocity.x = -velocity.x;
        }

        if(position.y > Exercise_0.HEIGHT - heli.getHeight() || position.y < 0) {
            velocity.y = -velocity.y;
        }

    }

    public void setTexture() {

        String heliString;

        if (velocity.x > 0) { heliString = "heliR_"; } else { heliString = "heliL_"; }
        if (timePassed > FRAME_DURATION*3) {
            timePassed = 0;
            heli = new Texture(heliString+"4.png");
        } else if (timePassed > FRAME_DURATION*2) {
            timePassed += Gdx.graphics.getDeltaTime();
            heli = new Texture(heliString+"3.png");
        } else if (timePassed > FRAME_DURATION) {
            timePassed += Gdx.graphics.getDeltaTime();
            heli = new Texture(heliString + "2.png");
        } else {
            timePassed += Gdx.graphics.getDeltaTime();
            heli = new Texture(heliString + "1.png");
        }

    }

    public Texture getTexture() {
        return heli;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void touchControl(Vector3 touch_position) {
        velocity.set(touch_position).sub(position).nor();
        //velocity.y = -velocity.y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void collideHorizontal() {
        velocity.y = -velocity.y;
    }

    public void collideVertical() {
        velocity.x = -velocity.x;
    }
}
