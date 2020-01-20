package rooms;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import entities.Pet;

public abstract class Room {
	
	protected RoomManager rm;
	protected Pet gato;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void mousePressed(MouseEvent e);

}
