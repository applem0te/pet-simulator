package entities;

import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import main.Game;
import rooms.RoomManager;
import visuals.SpriteSheet;

public class GUI extends MouseAdapter{

	private RoomManager rm;
	private BufferedImage gui_image, feed_icon, bath_icon, sleep_icon, sofa_icon;
	
	public GUI(int x, int y, RoomManager rm) {
		this.rm = rm;
		
		SpriteSheet ss = new SpriteSheet(Game.gui_image);		
		gui_image = ss.grabImage(0, 0, 300, 64);
		
		SpriteSheet ss1 = new SpriteSheet(Game.bowl_icon);
		feed_icon = ss1.grabImage(0, 0, 32, 32);
		
		SpriteSheet ss2 = new SpriteSheet(Game.bathtub_icon);
		bath_icon = ss2.grabImage(0, 0, 32, 32);
		
		SpriteSheet ss3 = new SpriteSheet(Game.bed_icon);
		sleep_icon = ss3.grabImage(0, 0, 32, 32);
		
		SpriteSheet ss4 = new SpriteSheet(Game.sofa_icon);
		sofa_icon = ss4.grabImage(0, 0, 32, 32);
		
	}

	public void init() {
		
	}

	public void draw(Graphics g) {
		
		//interface background
		g.drawImage(gui_image, (int)-3, (int)208, null);
		//button 1
		g.drawImage(sofa_icon, (int)20, (int)225, null);
		//button 2	
		g.drawImage(feed_icon, (int)60, (int)225, null);			
		//button 3	
		g.drawImage(bath_icon, (int)100, (int)225, null);
		//button 4
		g.drawImage(sleep_icon, (int)140, (int)225, null);
		
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();

		//button 1
		if(mx >= 20 && mx <= 52) {
			if(my >= 225 && my <= 257) {
				rm.setRoom(0);
				
			}
		}
		//button 2
		if(mx >= 60 && mx <= 92) {
			if(my >= 225 && my <= 257) {	
				rm.setRoom(1);
			}
		}
		//button 3
		if(mx >= 100 && mx <= 132) {
			if(my >= 225 && my <= 257) {
				rm.setRoom(2);
			}
		}
		
		//button 4
		if(mx >= 140 && mx <= 172) {
			if(my >= 225 && my <= 257) {
				rm.setRoom(3);
			}
		}
	}

}

