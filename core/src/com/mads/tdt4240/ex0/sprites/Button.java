package com.mads.tdt4240.ex0.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Button {

    private Texture button;
    private Rectangle bounds;
    private Vector3 position;

    public Button (String filePath) {
        button = new Texture(filePath);
        position = new Vector3(0, 0, 0);
        bounds =  new Rectangle(0, 0, button.getWidth(), button.getHeight());
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public Texture getTexture(){
        return button;
    }

    public void setPosition(int x, int y) {
        position.set(x, y, 0);
        bounds.set(x, y, button.getWidth(), button.getHeight());
    }

    public Vector3 getPosition() {
        return position;
    }
}
