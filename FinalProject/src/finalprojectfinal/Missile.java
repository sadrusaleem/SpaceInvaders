package finalprojectfinal;

import java.util.ArrayList;

import javalib.colors.*;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

public class Missile {
	int x;
	int y;
	boolean dir;

	Missile(int x, int y, boolean dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	// /////////////////////////////////////////
	// Drawing stuff
	// ///////////////////////////////////
	// white going up, red going down
	public WorldImage draw() {
		
		if (!dir) {
			return new RectangleImage(new Posn(this.x, this.y), 10, 10,
					new Red	());
		} else {
			return new RectangleImage(new Posn(this.x, this.y), 10, 10,
					new White());
		}

	}

	public WorldImage drawon(WorldImage scn) {
		return new OverlayImages(scn, this.draw());
	}

	// ///////////////////
	// On-tick related
	// ///////////////////

	// TESTED
	public Missile move() {
		if (this.dir) {
			return new Missile(this.x, this.y + 20, this.dir);
		} else {
			return new Missile(this.x, this.y - 20, this.dir);
		}
	}

	// tested
	public boolean collidedwithShip(Ship s) {
		return (((this.x < s.x + 20) && (this.x > s.x - 20)) && ((this.y < s.y + 20) && (this.y > s.y - 20)));
	}

	// returns true if this missile has hit the given shield
	boolean hitShield(Shield s) {
		return (Math.abs(this.x - s.x) < 30) && (Math.abs(this.y - s.y) < 30);
	}
	
	boolean hitEnemy(Enemy s){
		return (Math.abs(this.x - s.x) < 10) && (Math.abs(this.y - s.y) < 10);
	}
	
	boolean hitAnyEnemy(List<ArrayList<Enemy>> enemies){
		for (ArrayList<Enemy> l : enemies) {
			for (Enemy e : l) {
				if(this.hitEnemy(e))
					return true;
			}
		}

		return false;
	}
	
	boolean isOffScreen(){
		return this.y < 0 || this.y>800;
	}

}