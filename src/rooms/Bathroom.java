package rooms;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import entities.Pet;
import main.Game;
import visuals.SpriteSheet;

public class Bathroom extends Room{
	
	private BufferedImage bath_bg, sponge;
	private Pet gato;
	
	public Bathroom(RoomManager rm, Pet gato) {
		this.rm = rm;
		this.gato = gato;
		init();
	}

	public void init() {
		
		SpriteSheet ss3 = new SpriteSheet(Game.bath_bg);		
		bath_bg = ss3.grabImage(0, 0, 300, 300);
		
		SpriteSheet ss6 = new SpriteSheet(Game.sponge);		
		sponge = ss6.grabImage(0, 0, 50, 50);
		
	}

	public void update() {
		
	}

	public void draw(Graphics g) {
		
		g.drawImage(bath_bg, (int)0, (int)0, null);
		g.drawImage(sponge, (int)110, (int)70, null);
		gato.drawInBathroom(g);
		
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();

		
		//use sponge
		if(mx >= 110 && mx <= 160) {
			if(my >= 70 && my <= 120) {
				gato.clean();
				
			}
		}
		
	}

}