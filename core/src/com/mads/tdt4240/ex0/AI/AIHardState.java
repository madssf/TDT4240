package com.mads.tdt4240.ex0.AI;

import com.mads.tdt4240.ex0.sprites.Ball;
import com.mads.tdt4240.ex0.sprites.Paddle;


public class AIHardState implements AIState {

    private static final float SPEED = 0.8f;


    public AIHardState() {
    }

    @Override
    public void update(Paddle paddle, Ball ball) {
        if(paddle.getPosition().y > ball.getPosition().y) {
            paddle.setVelocity(false, this.SPEED);
        } else {
            paddle.setVelocity(true, this.SPEED);
        }
    }
}

