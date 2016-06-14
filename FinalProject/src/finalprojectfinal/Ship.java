package finalprojectfinal;

import java.util.ArrayList;

import javalib.colors.*;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

public class Ship {
	int x;
	int y;
	List<Missile> mymissiles;
	boolean powerup;
	int lives;

	Ship() {
		this.x = 250;
		this.y = 780;
		this.powerup = false;
		this.lives = 3;
		this.mymissiles = new Empty<Missile>();
	}

	Ship(int x, int y, boolean powerup, int lives, List<Missile> m) {
		this.x = x;
		this.y = y;
		this.powerup = powerup;
		this.lives = lives;
		this.mymissiles = m;
	}

	// Shoot Missiles
	public Ship shootmissile() {
		return new Ship(this.x, this.y, this.powerup, this.lives,
				this.mymissiles.cons(new Missile(this.x, this.y, false)));
	}

	public WorldImage drawShip() {
		return new RectangleImage(new Posn(this.x, this.y), 30, 20, new Blue());
	}

	public WorldImage drawShipOn(WorldImage scn) {
		return new OverlayImages(scn, this.drawShip());
	}

	// draws the ship with missiles onto a blank image
	public WorldImage drawAllOn(WorldImage scn) {
		WorldImage missilesofar = scn; // blankimage
		for (Missile m : this.mymissiles) {
			missilesofar = m.drawon(missilesofar);
		}
		return this.drawShipOn(missilesofar);

	}

	
	// Side Effect Reverses the list :D Sorry
	// Tested
	public Ship movemissiles() {
		List<Missile> initial = new Empty<Missile>();
		for (Missile m : this.mymissiles) {
			initial = initial.cons(m.move());
		}
		return new Ship(this.x, this.y, this.powerup, this.lives, initial);

	}
	
	public Ship removeMissilesHittingEnemies(List<ArrayList<Enemy>> enemies){
		List<Missile> newMissiles = new Empty<Missile>();
		for(Missile m: this.mymissiles){
			if(!m.hitAnyEnemy(enemies))
				newMissiles = newMissiles.cons(m);
		}
		
		this.mymissiles = newMissiles;
		return this;
	}
	
	public Ship removeOffScreenMissiles(){
		List<Missile> newMissiles = new Empty<Missile>();
		for(Missile m:this.mymissiles){
			if(!m.isOffScreen())
				newMissiles = newMissiles.cons(m);
		}
		
		this.mymissiles = newMissiles;
		return this;
	}
}
