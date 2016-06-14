package finalprojectfinal;

import java.util.ArrayList;

import javalib.funworld.World;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

import tester.*;
import javalib.funworld.*;
import javalib.colors.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;

class SpaceInvaders extends World {

	int height = 800;
	int width = 500;
	List<ArrayList<Enemy>> enemies;
	Ship ship;
	int score;
	List<Shield> shields;
	List<Ufo> saucer;
	int level;
	Posn center = new Posn(this.width / 2, this.height / 2);
	// public WorldImage background = new RectangleImage(this.center, 500, 500,
	// new White());

	public WorldImage background = new FromFileImage(this.center, "space2.jpg");

	// ////////////////////////////////////////////////////////////

	// ////////////////////
	// Constructors
	// ////////////////////

	// Initial Game Starter
	SpaceInvaders() {
		super();
		this.enemies = this.genEnemiesNew(1);
		this.level = 1;
		this.ship = new Ship();
		this.score = 0;
		this.shields = new Cons<Shield>(new Shield(250, 750),
				new Empty<Shield>());
		this.saucer = new Empty<Ufo>().cons(new Ufo());
	}

	SpaceInvaders(int i) {
		super();
		this.enemies = this.genEnemiesNew(i);
		this.level = i;
		this.ship = new Ship();
		this.score = 0;
		this.shields = new Cons<Shield>(new Shield(250, 750),
				new Empty<Shield>());
		this.saucer = new Empty<Ufo>().cons(new Ufo());
	}

	SpaceInvaders(int lvl, int score) {
		super();
		this.enemies = this.genEnemiesNew(lvl);
		this.level = lvl;
		this.ship = new Ship();
		this.score = score;
		this.shields = new Cons<Shield>(new Shield(250, 750),
				new Empty<Shield>());
		this.saucer = new Empty<Ufo>().cons(new Ufo());
	}

	// To change the world, User should never have access to this
	SpaceInvaders(Ship s, List<ArrayList<Enemy>> e, int sc, List<Shield> shil,
			List<Ufo> saucer, int level) {
		this.enemies = e;
		this.ship = s;
		this.score = sc;
		this.shields = shil;
		this.saucer = saucer;
		this.level = level;
	}

	// /////////////////////////////
	// Initializers, and creators
	// /////////////////////////////

	
	List<ArrayList<Enemy>> genEnemiesNew(int rows) {
		List<ArrayList<Enemy>> listOfColumns = new Empty<ArrayList<Enemy>>();

		for (int i = 0; i < rows; i++) {
			ArrayList<Enemy> currList = new ArrayList<Enemy>();
			for (int j = 0; j < 5; j++) {
				int margin = 100;
				int width = 500;
				int as = width - 2 * margin;
				int rat = as / 5;
				int x = rat * j + margin;
				currList.add(new Enemy(x, i * 50 + 50));
			}
			listOfColumns = listOfColumns.cons(currList);
		}

		return listOfColumns;
	}

	

	// Generate A missile shot by the player
	World shoot() {
		return new SpaceInvaders(this.ship.shootmissile(), this.enemies,
				this.score, this.shields, this.saucer, this.level);
	}

	// Generate an saucer
	List<Ufo> generateSaucer() {
		List<Ufo> initial = new Empty<Ufo>();

		if (this.score == 10 || this.score == 30 || this.score == 40
				|| this.score == 50) {
			return initial.cons(new Ufo());
		} else {
			return initial;
		}
	}

	// //////////////////////
	// Bigbang Functions
	// //////////////////////

	// draw everything in the world

	public WorldImage makeImage() {
		if (this.ship.lives == 0) {
			return this.endgamelost();
		}
		if (this.level == 5) {
			return this.endgamewon();
		}
		return this.drawWorld();
	}

	public WorldImage endgamelost() {
		return new OverlayImages(background, new TextImage(new Posn(250, 250),
				"You Lost. " + "" + " Your Score:" + this.score, 40, 1,
				new Red()));
	}

	public WorldImage endgamewon() {
		return new OverlayImages(background, new TextImage(new Posn(250, 250),
				"You Won!. " + "" + "Your Score:" + this.score, 40, 1,
				new Green()));
	}

	public WorldImage drawWorld() {
		WorldImage soFar = new RectangleImage(new Posn(0, 0), 30, 20,
				new Blue());
		if (this.shields.length() != 0) {
			soFar = this.scoreImageOn(this.levelImageOn(this.ship
					.drawAllOn(this.shields.getFirst().drawon(
							this.drawEnemiesOn(this.livesImageOn(background))))));
		}
		if (this.shields.length() == 0) {
			soFar = this.scoreImageOn(this.levelImageOn(this.ship
					.drawAllOn(this.drawEnemiesOn(this.livesImageOn(background)))));
		}
		if (this.saucer.length() != 0)
			return this.saucer.getFirst().drawOn(soFar);
		return soFar;
	}

	public WorldImage drawEnemiesOn(WorldImage scn) {
		WorldImage result = scn;
		for (ArrayList<Enemy> l : this.enemies) {
			for (Enemy e : l) {
				result = e.drawAllOn(result);
			}
		}

		return result;
	}

	public WorldImage scoreImageOn(WorldImage scn) {
		return new OverlayImages(scn, new TextImage(new Posn(35, 15), "Score: "
				+ this.score, 18, 1, Color.white));
	}

	public WorldImage levelImageOn(WorldImage scn) {
		return new OverlayImages(scn, new TextImage(new Posn(35, 35), "Level: "
				+ this.level, 18, 1, Color.white));
	}
	
	public WorldImage livesImageOn(WorldImage scn) {
		return new OverlayImages(scn, new TextImage(new Posn(35, 55), "Lives: "
				+ this.ship.lives, 18, 1, Color.white));
	}

	// //////////////////////////////////////////////////////////

	// move the ship, or fire a missile
	public World onKeyEvent(String ke) {

		Ship shipleft = new Ship(this.ship.x - 10, this.ship.y,
				this.ship.powerup, this.ship.lives, this.ship.mymissiles);
		Ship shipright = new Ship(this.ship.x + 10, this.ship.y,
				this.ship.powerup, this.ship.lives, this.ship.mymissiles);
		Ship shipup = new Ship(this.ship.x, this.ship.y - 10, this.ship.powerup,
				this.ship.lives, this.ship.mymissiles);
		Ship shipdown = new Ship(this.ship.x, this.ship.y + 10,
				this.ship.powerup, this.ship.lives, this.ship.mymissiles);
		if (ke.equals("left")) {
			return new SpaceInvaders(shipleft, this.enemies, this.score,
					this.shields, this.saucer, this.level);
		} else if (ke.equals("right")) {
			return new SpaceInvaders(shipright, this.enemies, this.score,
					this.shields, this.saucer, this.level);
		} else if (ke.equals("up")) {
			return new SpaceInvaders(shipup, this.enemies, this.score,
					this.shields, this.saucer, this.level);
		} else if (ke.equals("down")) {
			return new SpaceInvaders(shipdown, this.enemies, this.score,
					this.shields, this.saucer, this.level);
		} else if (ke.equals(" ")) {
			if (this.ship.powerup == false) {
				if (this.ship.mymissiles.length() >= 3) {
					return this;
				}

			}
			return this.shoot();
		}
		return this;

	}

	// ///////////////////////
	// On Tick
	// /////////////////////////

	// 1) Move the missiles of the ship => move.missiles on ship DONE
	// ///////////////
	// 2) Move the enemies => Done moveEn//////////////////////
	// 2.5) Make enemies shoot => done shootEN //////////////////
	// 3) Move the saucer ==> Done moveSauc();///////////////////////////
	// 4) Check if any enemies is hit, if yes remove it =>
	// Done//////////////////////
	// 6) Check if we are hit => DONE ///////////////////////////////////////
	// 9) Increment Score => Done IncrementScore
	// //////////////////////////////////
	// 5) Check if any shield is hit, if yes remove it => Done/////////////////
	// 11) THIS SHOULD BE DONE AFTER EVERYTHING IS WORKING => level system
	// implementation => Done ///////////
	// 8) initiate a saucer (Do with level sytem) => Done
	// ///////////////////////////////
	// Check If the saucer is hit ?? => Done ///////////////////////////
	// 7) Remove bullets that hit enemies (SAADI)
	// 10) Define endgame
	// 12) Power Ups

	public World onTick() {
		if (this.ship.lives == 0)
			this.stopWorld();
		return this.WorldMoveEn().WorldShootEn().WorldRemoveDead()
				.WorldMoveSauc().WorldbreakShield().updateShield()
				.WorldMoveShield().WorldMoveShipMissiles()
				.WorldMoveEnemyMissiles().removeOffScreenMissiles()
				.Skiptothenextlevel().ResetShip().poweredUp();
	}

	// //////////////////////////////
	// On-tick helpers
	// //////////////////////////////

	public SpaceInvaders removeOffScreenMissiles() {
		this.ship = this.ship.removeOffScreenMissiles();
		for (ArrayList<Enemy> l : this.enemies) {
			for (Enemy e : l) {
				e.removeOffScreenMissiles();
			}
		}

		return this;
	}

	// ////////////////
	// Moving Enemies
	// ////////////////

	public SpaceInvaders WorldMoveEn() {
		this.enemies = this.moveEn();
		return this;
	}

	// First filter the list for all dead columns
	// Then check either first or last is at the edge
	// Side Effect: Reverses the list sorry :D
	public List<ArrayList<Enemy>> moveEn() {
		List<ArrayList<Enemy>> initial = this.enemies.filtercolumn();
		List<ArrayList<Enemy>> setonthis = new Empty<ArrayList<Enemy>>();
		if (initial.endp()) {
			return this.enemies;
		} else {

			if (ArrayUtils.firstorlastattheedge(initial.getFirst())) {

				if (initial.getFirst().get(0).direction == false) {
					for (ArrayList<Enemy> al : initial) {
						setonthis = setonthis.cons(ArrayUtils.movedown(al));
					}
				} else {
					for (ArrayList<Enemy> al : initial) {
						setonthis = setonthis.cons(ArrayUtils.movedown2(al));
					}
				}
			} else {
				for (ArrayList<Enemy> al : initial) {
					setonthis = setonthis.cons(ArrayUtils.movehorizontal(al));
				}
			}
		}
		return setonthis;
	}

	// //////////////
	// Firing a missile for an enemy
	// ////////////////////////
	public SpaceInvaders WorldShootEn() {
		this.enemies = this.shootEn();
		return this;
	}

	// TESTED MIGHT BE REVERSING A LIST (ATTENTION: RANDOM METHOD)
	public List<ArrayList<Enemy>> shootEn() {
		List<ArrayList<Enemy>> initial = this.enemies.filtercolumn();
		List<ArrayList<Enemy>> setonthis = new Empty<ArrayList<Enemy>>();
		if (initial.endp()) {
			return this.enemies;
		} else {
			for (ArrayList<Enemy> al : initial) {
				setonthis = setonthis.cons(ArrayUtils.shootMaybe(al));
			}
		}
		return setonthis;
	}

	// ///////////////////////
	// Moving the saucer
	// ///////////////////////

	public SpaceInvaders WorldMoveSauc() {
		this.saucer = this.moveSaucer();
		return this;
	}

	// Tested ADDED CASE ADD MORE TESTS
	public List<Ufo> moveSaucer() {
		if (this.saucer.length() == 0) {
			return this.saucer;
		} else {
			if (this.ShotSaucer()) {
				return new Empty<Ufo>();
			} else {
				if (this.saucer.getFirst().x == 495
						&& this.saucer.getFirst().dir == true) {
					return new Empty<Ufo>();
				} else {
					return new Cons<Ufo>(this.saucer.getFirst().moveSauc(),
							new Empty<Ufo>());
				}
			}
		}
	}

	public SpaceInvaders WorldMoveShipMissiles() {
		this.ship = this.ship.movemissiles();
		return this;
	}

	// //////////////////////
	// Collision Detector
	// //////////////////////

	// ////////////
	// Shot Enemies
	// ////////////

	// Tested
	// SIDE EFFECT REVERSE LISTS

	public SpaceInvaders WorldRemoveDead() {
		List<ArrayList<Enemy>> oldEn = this.enemies;
		int oldLen = this.countEnemies();
		this.enemies = this.removeDead();
		int newLen = this.countEnemies();
		this.ship = this.ship.removeMissilesHittingEnemies(oldEn);
		this.score = this.score + (oldLen - newLen);
		;
		return this;
	}

	public int countEnemies() {
		int count = 0;
		for (ArrayList<Enemy> l : this.enemies) {
			for (Enemy e : l) {
				count++;
			}
		}
		return count;
	}

	public List<ArrayList<Enemy>> removeDead() {
		List<ArrayList<Enemy>> initial = this.enemies;
		List<ArrayList<Enemy>> setonthis = new Empty<ArrayList<Enemy>>();

		for (ArrayList<Enemy> al : initial) {
			setonthis = setonthis.cons(ArrayUtils.removeShot(this.ship, al));
		}
		return setonthis;
	}

	// //////////////
	// ShotShip
	// /////////////
	// NOT TESTED BUT WORKS
	public boolean AreweDeadYet() {
		return this.enemies.shotTheBastard(this.ship);
	}

	// ////////////
	// Shot Shield
	// ////////////////

	public SpaceInvaders WorldbreakShield() {
		this.shields = this.breakshields();
		return this;
	}

	public List<Shield> breakshields() {
		if (this.shields.length() == 0)
			return this.shields;
		if (this.shields.getFirst().health == 0)
			return new Empty<Shield>();
		return this.shields;
	}

	public SpaceInvaders WorldMoveShield() {
		if (this.shields.length() != 0) {
			this.shields.getFirst().moveTo(this.ship.x, this.ship.y - 30);
		}

		return this;
	}

	public SpaceInvaders WorldMoveEnemyMissiles() {
		for (ArrayList<Enemy> l : this.enemies) {
			for (Enemy e : l) {
				e = e.movemissiles();
			}
		}

		return this;
	}

	// the reason this has to return a world is because the shields and the
	// missiles have to be updated at the same time
	public SpaceInvaders updateShield() {
		for (ArrayList<Enemy> l : this.enemies) {
			for (Enemy e : l) {
				if (this.shields.length() != 0) {
					int oldLen = e.enemymissiles.length();
					e.updateMissilesHittingShield(this.shields.getFirst());
					if (e.enemymissiles.length() < oldLen) {
						this.shields.getFirst().hit();
					}
				}
			}
		}

		return this;
	}

	// ////////////////////////
	// Shot Saucer
	// ////////////////////////

	boolean ShotSaucer() {
		if (this.saucer.endp()) {
			return false;
		} else {
			return this.saucer.getFirst().didIgetShot(this.ship.mymissiles);
		}
	}

	SpaceInvaders poweredUp() {
		if (this.ShotSaucer()) {
			this.ship.powerup = true;
		}
		return this;
	}

	// ///////////////////
	// Increment Score
	// //////////////////

	// //////////////////////
	// Updating Level
	// ///////////////////////
	public SpaceInvaders Skiptothenextlevel() {

		if (this.enemies.allempty()) {
			return new SpaceInvaders(this.level + 1, this.score);
		} else {
			return this;
		}
	}

	public SpaceInvaders ResetShip() {
		if (this.AreweDeadYet()) {
			int oldLives = this.ship.lives;
			boolean powerup = this.ship.powerup;
			this.ship = new Ship();
			this.ship.lives = oldLives - 1;
			this.ship.powerup = powerup;
		}

		return this;
	}

}
