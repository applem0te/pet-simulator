package rooms;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import entities.Pet;

public class RoomManager implements MouseListener {
	
	private ArrayList<Room> rooms;
	private int currentRoom;
	
	public static final int LIVINGROOM = 0;
	public static final int KITCHEN = 1;
	public static final int BATHROOM = 2;
	public static final int BEDROOM = 3;
	
	@SuppressWarnings("unused")
	private Pet gato;
	
	public RoomManager(Pet gato) {
		
		this.gato = gato;
		
		rooms = new ArrayList<Room>();
		
		currentRoom = LIVINGROOM;
		rooms.add(new LivingRoom(this, gato));
		rooms.add(new Kitchen(this, gato));
		rooms.add(new Bathroom(this, gato));
		rooms.add(new Bedroom(this, gato));
	}

	
	public void setRoom(int room) {
		currentRoom = room;
		rooms.get(currentRoom).init();
	}
	
	public void update() {
		rooms.get(currentRoom).update();
	}
	
	public void draw(Graphics g) {
		rooms.get(currentRoom).draw(g);
	}
	
	public void mousePressed(MouseEvent e) {
		rooms.get(currentRoom).mousePressed(e);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

