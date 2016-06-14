package finalprojectfinal;

import javalib.colors.*;
import javalib.worldimages.*;

public class Enemy {
	int x;
	int y;
	List<Missile> enemymissiles;
	boolean fire;
	boolean direction;
	int health;

	// ///////////////////////////////////////////
	// Drawing Stuff

	// draw: -> WorldImage
	// displays the alien in-game
	public WorldImage drawEnemy() {
		if (this.health == 2)
			return new RectangleImage(new Posn(this.x, this.y), 20, 20,
					new Green());
		return new RectangleImage(new Posn(this.x, this.y), 20, 20,
				new Yellow());

	}

	public WorldImage drawEnemyOn(WorldImage scn) {
		return new OverlayImages(scn, this.drawEnemy());
	}

	public WorldImage drawAllOn(WorldImage scn) {
		WorldImage missilesofar = scn;

		for (Missile m : this.enemymissiles) {

			missilesofar = m.drawon(missilesofar);
		}

		return this.drawEnemyOn(missilesofar);
	}

	public Enemy updateMissilesHittingShield(Shield s) {
		List<Missile> newMissiles = new Empty<Missile>();
		for (Missile m : enemymissiles) {
			if (!m.hitShield(s))
				newMissiles = newMissiles.cons(m);
		}

		this.enemymissiles = newMissiles;
		return this;
	}

	// /////////////////////////////////////////////
	Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		this.fire = false;
		this.enemymissiles = new Empty<Missile>();
		double chance = Math.random() * 100;
		if (chance < 50)
			this.health = 2;
		else
			this.health = 1;
	}

	Enemy(int x, int y, boolean f, boolean dir, List<Missile> l, int health) {
		this.x = x;
		this.y = y;
		this.fire = f;
		this.direction = dir;
		this.enemymissiles = l;
		this.health = health;
	}

	// Tested
	public Enemy moveHorizontal() {
		if (this.direction) {
			return new Enemy(this.x + 2, this.y, this.fire, this.direction,
					this.enemymissiles, this.health);
		} else
			return new Enemy(this.x - 2, this.y, this.fire, this.direction,
					this.enemymissiles, this.health);
	}

	// Tested
	public Enemy moveVertical() {
		return new Enemy(this.x + 5, this.y + 2, !this.fire, !this.direction,
				this.enemymissiles, this.health);
	}

	public Enemy moveVertical2() {
		return new Enemy(this.x - 5, this.y + 2, !this.fire, !this.direction,
				this.enemymissiles, this.health);
	}

	// I dont even know if I am using this

	public boolean attheedge() {
		return this.x < 3 || this.x > 480;
	}

	// / Random Function Kind of Tested
	public Enemy shallIshoot() {
		double chance = Math.random() * 100;

		if (chance <= 1) {
			return new Enemy(this.x, this.y, this.fire, this.direction,
					this.addMissile(), this.health);
		} else {
			return this;
		}
	}

	// Tested
	public List<Missile> addMissile() {
		Missile newbomb = new Missile(this.x, this.y, true);
		return this.enemymissiles.cons(newbomb);

	}

	// /////////////////////////////////////////////

	// Tested
	public boolean shotp(Ship s) {
		List<Missile> missiles = s.mymissiles;
		return missiles.shotany(this);
	}

	public Enemy movemissiles() {

		List<Missile> initial = new Empty<Missile>();
		for (Missile m : this.enemymissiles) {
			initial = initial.cons(m.move());

		}
		this.enemymissiles = initial;
		return this;

	}

	// Tested
	public boolean gotshot(Missile m) {
		return (this.x - 10 <= m.x && m.x <= this.x + 10)
				&& (this.y - 10 <= m.y && m.y <= this.y + 10);
	}

	// ////////////////////////////////////////
	// TESTED
	public boolean enemyShotShip(Ship s) {
		return this.enemymissiles.MissileShotShip(s);
	}

	public Enemy removeOffScreenMissiles() {
		List<Missile> newMissiles = new Empty<Missile>();
		for (Missile m : this.enemymissiles) {
			if (!m.isOffScreen())
				newMissiles = newMissiles.cons(m);
		}

		this.enemymissiles = newMissiles;
		return this;
	}
}
