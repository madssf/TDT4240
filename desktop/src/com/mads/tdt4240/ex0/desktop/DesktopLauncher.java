package com.mads.tdt4240.ex0.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mads.tdt4240.ex0.Exercise_0;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Exercise_0.WIDTH;
		config.height = Exercise_0.HEIGHT;
		config.title = Exercise_0.TITLE;
		new LwjglApplication(new Exercise_0(), config);
	}
}
