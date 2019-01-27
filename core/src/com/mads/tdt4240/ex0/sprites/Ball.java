package com.mads.tdt4240.ex0.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mads.tdt4240.ex0.Exercise_0;

import java.util.Random;

public class Ball {

    private final static int MOVEMENT = 3;
    private static final float MOVEMENT_MOD = 1.1f;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds; //ønsker bare grense på x grensene

    private Texture ball;



    public Ball() {
        position = new Vector3(0,0, 0);
        velocity = new Vector3(0, 0, 0);
        ball = new Texture("ball.png"); //foreløpig et heli
        bounds = new Rectangle(0, 0, ball.getWidth(), ball.getHeight());

    }

    public void setPosition(int x, int y) {
        position.set(x, y, 0);
    }

    public void update(float dt) {
        position.add(velocity);
        wall_collision();
        bounds.setPosition(position.x, position.y);

    }

    public void collide() {
        velocity.x = - velocity.x * MOVEMENT_MOD;
    }

    public void wall_collision() {
        if (position.y + ball.getHeight()  > Exercise_0.HEIGHT || position.y < 0) {
            velocity.y = -velocity.y;
        }

    }


    public void setRandomVelocity() {
        Random rand = new Random();
        velocity.add(rand.nextInt(MOVEMENT) + 1, rand.nextInt(MOVEMENT) + 1, 0);
        if (rand.nextBoolean()) {
            velocity.x = -velocity.x;
        }
        if (rand.nextBoolean()) {
            velocity.y = -velocity.y;
        }

    }

    public Rectangle getBounds(){
        return bounds;
    }



    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return ball;
    }

    public void dispose(){
        ball.dispose();

    }


}
