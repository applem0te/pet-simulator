package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import entities.Pet;
import entities.HUD;
import rooms.RoomManager;
import entities.GUI;
import visuals.BufferedImageLoader;

/**
 * @author applem0te
 *	
 *	A simple virtual pet game where you can care for a cat that has 4 needs: happiness (play to refill), hunger (feed to refill), hygiene (clean to refill) and energy (send to sleep to refill).
 *	Interact with the pet via mouse input. Every need can be interacted with in a room designed for it, aka living room to play, kitchen to feed, bathroom to clean and bedroom to sleep.
 *	Needs slowly go down overtime, but the pet cannot die.
 *
 **/

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private boolean isRunning = false;
	private Thread thread;
	private HUD hud;
	private GUI gui;
	private Pet gato;
	private RoomManager rm;
	
	private float petNeedsTimer;

	public static BufferedImage gato_image, gui_image, hud_image, sofa_icon, bowl_icon, bathtub_icon, bed_icon, lr_bg, kit_bg, bath_bg, bed_bg, casserole, sponge, box;
	
	public Game() {
		
		loadAllVisuals();
		
		new Window(300, 300, "Pet Simulator", this);
		start();
		
		gato = new Pet(148, 75);
		rm = new RoomManager(gato);
		gui = new GUI(0, 207, rm);
		hud = new HUD(gato);

		this.addMouseListener(gui);
		this.addMouseListener(rm);

	}
	
	public void start() {
		
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	private void stop() {
		
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void run() {
		
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double nanoSecondsPerSec = 1000000000 / amountOfTicks;
		double unprocessed = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nanoSecondsPerSec;
			lastTime = now;
			while(unprocessed >= 1) {
				tick();
				unprocessed--;
			}
			draw();
			frames++;
			
			petNeedsTimer++;
			
			if(petNeedsTimer == 1000) {
				gato.tick();
				petNeedsTimer = 0;
			}
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
			
		}
		
		stop();
	}
	
	public void tick() {
	
	}
	
	public void draw() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		rm.draw(g);
		gui.draw(g);
		hud.draw(g);


		g.dispose();
		bs.show();
		
	}
	
	public void loadAllVisuals() {
		
		BufferedImageLoader loader = new BufferedImageLoader();

		box = loader.loadImage("/box.png/");
		sponge = loader.loadImage("/sponge.png/");
		casserole = loader.loadImage("/casserole.png/");
		bed_bg = loader.loadImage("/bedroom.png/");
		bath_bg = loader.loadImage("/bathroom.png/");
		lr_bg = loader.loadImage("/lr_background.png");
		kit_bg = loader.loadImage("/kit_background.png");
		gato_image = loader.loadImage("/gato.png");
		gui_image = loader.loadImage("/interface.png");
		hud_image = loader.loadImage("/HUD1.png");
		sofa_icon = loader.loadImage("/sofa.png/");
		bowl_icon = loader.loadImage("/food_bowl.png/");
		bathtub_icon = loader.loadImage("/bath.png/");
		bed_icon = loader.loadImage("/bed.png/");
	}

	
	public static void main(String args[]) throws IOException {
		new Game();
	}
}
