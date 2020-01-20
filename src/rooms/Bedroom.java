package rooms;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import entities.Pet;
import main.Game;
import visuals.SpriteSheet;

public class Bedroom extends Room{
	
	private BufferedImage bed_bg, lamp;
	private Pet gato;
	
	public Bedroom(RoomManager rm, Pet gato) {
		this.rm = rm;
		this.gato = gato;
		init();
	}

	public void init() {
		
		SpriteSheet ss4 = new SpriteSheet(Game.bed_bg);		
		bed_bg = ss4.grabImage(0, 0, 300, 300);
		
		SpriteSheet ss5 = new SpriteSheet(Game.box);
		lamp = ss5.grabImage(0, 0, 50, 50);
		
	}

	public void update() {
		
	}

	public void draw(Graphics g) {
		
		g.drawImage(bed_bg, (int)0, (int)0, null);
		g.drawImage(lamp, (int)0, (int)145, null);
		gato.drawInBedroom(g);
		
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		//use lamp
		if(mx >= 0 && mx <= 50) {
			if(my >= 145 && my <= 195) {
				gato.sleep();
				
			}
		}
		
	}

}