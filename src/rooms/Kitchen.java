package rooms;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import entities.Pet;
import main.Game;
import visuals.SpriteSheet;

public class Kitchen extends Room{
	
	private Pet gato;
	private BufferedImage kit_bg, casserole;
	
	public Kitchen(RoomManager rm, Pet gato) {
		this.rm = rm;
		this.gato = gato;
		init();
	}

	public void init() {
		
		SpriteSheet ss = new SpriteSheet(Game.kit_bg);		
		kit_bg = ss.grabImage(0, 0, 300, 300);
		
		SpriteSheet ss1 = new SpriteSheet(Game.casserole);		
		casserole = ss1.grabImage(0, 0, 50, 50);
		
	}

	public void update() {
		
	}

	public void draw(Graphics g) {
		
		g.drawImage(kit_bg, (int)0, (int)0, null);
		g.drawImage(casserole, 200, 71, null);
		gato.drawInKitchen(g);
		
		
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		//use casserole
		if(mx >= 200 && mx <= 250) {
			if(my >= 71 && my <= 121) {
				gato.feed();
				
			}
		}
		
	}

}