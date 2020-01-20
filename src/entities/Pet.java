package entities;

import java.awt.Graphics;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.Game;
import visuals.SpriteSheet;


public class Pet{
	
	private float happiness;
	private float hunger;
	private float hygiene;
	private float energy;
	
	public int maxValue = 100;
	public int minValue = 1;
	
	private int x, y, coins;

	private BufferedImage gato_image;
	
	public Pet(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(Game.gato_image);		
		gato_image = ss.grabImage(0, 0, 100, 100);
		
		happiness = 70;
		hunger = 50;
		hygiene = 20;
		energy = 30;
		coins = 1;
		
	}

	public void tick(){
		
		doEvent();
	}

	public void doEvent() {
		
		setHappiness(getHappiness() - 0.02f);
		setHunger(getHunger() - 0.02f);
		setHygyiene(getHygiene() - 0.02f);
		setEnergy(getEnergy() - 0.02f);

	}
	
	
	// room positions

	public void drawInLivingRoom(Graphics g) {
		
		g.drawImage(gato_image, (int)x, (int)y, null);
		
	}
	
	public void drawInKitchen(Graphics g) {
		
		g.drawImage(gato_image, (int)75, (int)20, null);
		
	}
	
	public void drawInBathroom(Graphics g) {
		
		g.drawImage(gato_image, (int)5, (int)55, null);
		
	}
	
	public void drawInBedroom(Graphics g) {
		
		g.drawImage(gato_image, (int)120, (int)22, null);
		
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 100, 100);
	}
	
	// interactions
	
	public void feed() {
		setHunger(getHunger() + 10);
		
		if(this.hunger > this.maxValue) {
			this.hunger = this.maxValue;
		}
		else if(this.hunger < this.minValue) {
			this.hunger = this.minValue;
		}
	}
	
	public void clean() {
		setHygyiene(getHygiene() + 5);
		
		if(this.hygiene > this.maxValue) {
			this.hygiene = this.maxValue;
		}
		else if(this.hygiene < this.minValue) {
			this.hygiene = this.minValue;
		}
	}

	public void sleep() {
		
		setEnergy(maxValue);
		
	}
	
	public void play() {
		setHappiness(getHappiness() + 1);
		
		if(this.happiness > this.maxValue) {
			this.happiness = this.maxValue;
		}
		else if(this.happiness < this.minValue) {
			this.happiness = this.minValue;
		}
	}

	//getters and setters
	
	public static float clamp(float var, float min, float max) {
		
		if (var >= max) 
			return (var = max);	
		else if (var <= min)
			return (var = min);
		else 
			return var;
		
	}
	
	public float getHappiness() {
		return happiness;
	}

	public void setHappiness(float happiness) {
		this.happiness = clamp(happiness, minValue, maxValue);
		
	}

	public float getHunger() {
		return hunger;
	}

	public void setHunger(float hunger) {
		this.hunger = clamp(hunger, minValue, maxValue);
	}

	public float getHygiene() {
		return hygiene;
	}

	public void setHygyiene(float hygiene) {
		this.hygiene = clamp(hygiene, minValue, maxValue);
	}

	public float getEnergy() {
		return energy;
	}

	public void setEnergy(float energy) {
		this.energy =  clamp(energy, minValue, maxValue);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}


}
