package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import visuals.SpriteSheet;

public class HUD {
	
	private Pet gato;
	private BufferedImage hud_image;
	
	public HUD(Pet gato) {
		this.gato = gato;
		
		SpriteSheet ss = new SpriteSheet(Game.hud_image);		
		hud_image = ss.grabImage(0, 0, 16, 64);
	}

	public void draw(Graphics g) {
		
		float red, green, blue = 0;
		
		g.drawImage(hud_image, 2, 0, null);
		
		// happy stat
		green = (255 * gato.getHappiness()) / 100;
		red = (255 * (100 - gato.getHappiness())) / 100;
		g.setColor(new Color((int)red, (int)green, (int)blue));
		g.fillRect(20, 4, (int) (gato.getHappiness()/2), 10);
		
		// hunger stat
		green = (255 * gato.getHunger()) / 100;
		red = (255 * (100 - gato.getHunger())) / 100;
		g.setColor(new Color((int)red, (int)green, (int)blue));
		g.fillRect(20, 20, (int) (gato.getHunger()/2), 10);
		
		// clean stat
		green = (255 * gato.getHygiene()) / 100;
		red = (255 * (100 - gato.getHygiene())) / 100;
		g.setColor(new Color((int)red, (int)green, (int)blue));
		g.fillRect(20, 36, (int) (gato.getHygiene()/2), 10);
		
		// energy stat
		green = (255 * gato.getEnergy()) / 100;
		red = (255 * (100 - gato.getEnergy())) / 100;
		g.setColor(new Color((int)red, (int)green, (int)blue));
		g.fillRect(20, 52, (int) (gato.getEnergy()/2), 10);
		
	}
	
	public void tick() {
		
	}
}