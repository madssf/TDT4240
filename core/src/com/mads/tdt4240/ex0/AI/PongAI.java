package com.mads.tdt4240.ex0.AI;

import com.mads.tdt4240.ex0.sprites.Ball;
import com.mads.tdt4240.ex0.sprites.Paddle;

public class PongAI {

    private Paddle paddle, opponent;
    private Ball ball;
    private AIState state;

    //Sets the point lead for different states
    private final static int EASY_LEVEL = 3;


    public PongAI(Paddle paddle, Paddle opponent, Ball ball) {

        this.paddle = paddle;
        this.ball = ball;
        this.opponent = opponent;

    }

    private void checkState() {
        if (this.paddle.getPoints() > opponent.getPoints() - EASY_LEVEL) {
            this.state = new AIEasyState();
        } else {
            this.state = new AIHardState();
        }
    }


    public void update() {

        checkState();
        state.update(paddle, ball);
    }
}

