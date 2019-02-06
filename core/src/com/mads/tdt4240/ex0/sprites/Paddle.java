package com.mads.tdt4240.ex0.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mads.tdt4240.ex0.Exercise_0;

import static java.lang.Math.abs;


public class Paddle {

    private Texture paddle;
    private static final float MOVEMENT = 5.0f;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private int points;

    public Paddle (int x, int y) {
        position = new Vector3(x, y, 0);
        paddle = new Texture("paddle.jpg");
        points = 0;
        velocity = new Vector3(0, 0,0);
        bounds = new Rectangle(x, y, paddle.getWidth(), paddle.getHeight());
    }

    public void update(float dt){
        if(position.y < 0) {
            position.y = 0 ;
        } else if (position.y + paddle.getHeight() > Exercise_0.HEIGHT) {
            position.y = Exercise_0.HEIGHT - paddle.getHeight();
        } else {
            position.y += velocity.y;
        }
        bounds.setPosition(position.x, position.y);

    }

    public void touchControl(Vector3 touch_position) {
        if(bounds.contains(touch_position.x, touch_position.y)){
            velocity.y = 0;
        } else if(touch_position.y > position.y) {
            velocity.y = MOVEMENT;
        } else if (touch_position.y < position.y) {
            velocity.y = -MOVEMENT;


        }
    }

    public void setVelocity(boolean direction, float speed) {
        if (direction) {
            velocity.y = speed * MOVEMENT;
        } else {
            velocity.y = -speed * MOVEMENT;
        }


    }

    public void addPoint() {
        points +=1;
    }

    public int getPoints(){
        return points;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void resetPos() {
        position.y = Exercise_0.HEIGHT/2 - 50;
        velocity.y = 0;
    }

    public Texture getTexture() {
        return paddle;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        paddle.dispose();
    }
}
