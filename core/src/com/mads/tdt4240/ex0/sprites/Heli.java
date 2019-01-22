package com.mads.tdt4240.ex0.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mads.tdt4240.ex0.Exercise_0;

import java.util.Random;

public class Heli {

    private static final float MOVEMENT = (float) 0.2;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;

    private Texture heli;

    public Heli(int x, int y){

        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0 ,0);
        heli = new Texture("heli1_left.png");
        bounds =  new Rectangle(x, y, heli.getWidth(), heli.getHeight());

    }

    public void update(Float dt) {
        position.add(velocity);
        checkWallCollision();
        setTexture();
        bounds.setPosition(position.x, position.y);
        /*
        if(position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);
        if(position.y < 0)
            position.y = 0;


        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
        */
    }

    public void setRandomVelocity() {
        Random rand = new Random();
        velocity.add(rand.nextInt(3)+1, rand.nextInt(3)+1, 0);
        velocity.scl(MOVEMENT);
        setTexture();
    }

    public boolean collides(Rectangle otherHeli) {
        return otherHeli.overlaps(bounds);
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
        if (velocity.x > 0) {
            heli = new Texture("heli1_right.png");
        } else {
            heli = new Texture("heli1_left.png");
        }
    }

    public Texture getTexture() {
        return heli;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void touchControl(Vector3 touch_position) {
        touch_position.y = Exercise_0.HEIGHT - touch_position.y;
        velocity.set(touch_position).sub(position).nor();
        //velocity.y = -velocity.y;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
