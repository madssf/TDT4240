package com.mads.tdt4240.ex0;

import com.mads.tdt4240.ex0.sprites.Ball;
import com.mads.tdt4240.ex0.sprites.Paddle;

public class PongCPU {

    private Paddle paddle;
    private Ball ball;

    public PongCPU(Paddle paddle, Ball ball) {

        this.paddle = paddle;
        this.ball = ball;
    }

    public void update() {
        if(paddle.getPosition().y > ball.getPosition().y) {
            paddle.setVelocity(false);
        } else {
            paddle.setVelocity(true);
        }
    }

}
