package com.mads.tdt4240.ex0.AI;


import com.mads.tdt4240.ex0.sprites.Ball;
import com.mads.tdt4240.ex0.sprites.Paddle;

public interface AIState {

    public void update(Paddle paddle, Ball ball);
}
