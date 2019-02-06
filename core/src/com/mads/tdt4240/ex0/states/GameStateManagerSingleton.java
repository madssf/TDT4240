package com.mads.tdt4240.ex0.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManagerSingleton {
    private static final GameStateManagerSingleton ourInstance = new GameStateManagerSingleton();

    public static GameStateManagerSingleton getInstance() {
        return ourInstance;
    }

    private Stack<State> states;

    private GameStateManagerSingleton() {

        states = new Stack<State>();

    }
    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
