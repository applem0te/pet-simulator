package rooms;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import entities.Pet;
import main.Game;
import visuals.SpriteSheet;

public class LivingRoom extends Room{
	
	private BufferedImage lr_bg;
	private Pet gato;
	
	public LivingRoom(RoomManager rm, Pet gato) {
		this.gato = gato;
		this.rm = rm;
		init();
	}

	public void init() {
		
		SpriteSheet ss = new SpriteSheet(Game.lr_bg);		
		lr_bg = ss.grabImage(0, 0, 300, 300);
		
	}

	public void update() {
		
	}

	public void draw(Graphics g) {

		g.drawImage(lr_bg, (int)0, (int)0, null);
		gato.drawInLivingRoom(g);

	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		//playing with pet sprite
		if(mx >= gato.getX() && mx <= gato.getX()+100) {
			if(my >= gato.getY() && my <= gato.getY()+100) {
				gato.play();
			}
		}
		
	}

}
