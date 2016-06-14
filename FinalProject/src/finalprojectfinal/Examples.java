package finalprojectfinal;

import java.util.ArrayList;
import tester.*;

public class Examples {
     Missile mm1= new Missile(20, 30, false);
     Missile mm2=new Missile(230, 300, false);
     Missile mm3= new Missile(120,10, false);
     Missile em1= new Missile(20, 30, true);
     Missile em2= new Missile(230, 300, true);
     Missile em3= new Missile(120,10, true);
     List<Missile> lm1= new Empty<Missile>();
     List<Missile> lm2= new Cons<Missile>(mm1, new Cons<Missile>(mm2, new Cons<Missile> (mm3, new Empty<Missile>())));
     Ship ship1= new Ship(250, 480, false, 3, lm1);
     Ship ship2= new Ship(10, 460, false, 2, lm2);
     List<Missile> lm3= new Cons<Missile>(em1, new Cons<Missile>(em2, new Cons<Missile>(em3, new Empty<Missile>())));
     Enemy e1= new Enemy(20, 120, false, false, lm1, 2);
     Enemy e2= new Enemy(320, 12, false, false, lm3, 1);
     Enemy e3= new Enemy(5, 120, false, false, lm3, 1);
     Enemy e4= new Enemy(495, 148, false, true, lm1, 2);
     Enemy e6= new Enemy(5, 60, false, false, lm1, 2);
     Enemy e7= new Enemy(5, 142, false , false, lm3, 2);
     Enemy e8= new Enemy(320, 148, false, true, lm3,1);
     ArrayList<Enemy> al1= new ArrayList<Enemy>();
     ArrayList<Enemy> al2= new ArrayList<Enemy>();
     ArrayList<Enemy> al3= new ArrayList<Enemy>();
     ArrayList<Enemy> al4= new ArrayList<Enemy>();
     ArrayList<Enemy> al5= new ArrayList<Enemy>();
     
     public void Setup(){
    	 this.al1= new ArrayList<Enemy>();
    	 this.al1.add(0, e1);
    	 this.al1.add(1, e2);
    	 this.al2= new ArrayList<Enemy>();
    	 this.al2.add(0, e2);
    	 this.al3= new ArrayList<Enemy>();
    	 this.al3.add(0, e3);
    	 this.al3.add(1, e6);
    	 this.al3.add(2, e7);
    	 this.al4= new ArrayList<Enemy>();
    	 this.al4.add(0, e4);
  
     }
     
    /* public void testIterator (Tester t){
    	 ListIterator<Missile> it= new ListIterator<Missile>(lm2);
    	 it.next();
    	 t.checkExpect(it.Conslist, new Cons<Missile>(mm2, new Cons<Missile> (mm3, new Empty<Missile>())));
     }
     public void testMoveMissile(Tester t){
    	 t.checkExpect(this.mm1.move(), new Missile(20, 28, false));
    	 t.checkExpect(this.mm2.move(), new Missile(230, 298, false));
     t.checkExpect(this.mm3.move(), new Missile(120, 8, false));
    	 t.checkExpect(this.em1.move(), new Missile(20, 32, true));
    	t.checkExpect(this.em2.move(), new Missile(230, 302, true));
    	t.checkExpect(this.em3.move(), new Missile(120, 12, true));
    	 t.checkExpect(this.ship1.movemissiles(), new Ship(250, 480, false, 3, new Empty<Missile>()));
    	 t.checkExpect(this.ship2.movemissiles(), new Ship(10, 460, false,2, new Cons<Missile>(new Missile(120, 8, false) , new Cons<Missile>(
    		 new Missile(230, 298, false), new Cons<Missile>(new Missile(20, 28, false) , new Empty<Missile>())))));
     }
     
     public void testEnemyFilter(Tester t){
    	 this.Setup();
    	List<ArrayList<Enemy>> elist1=new Cons<ArrayList<Enemy>>( new ArrayList<Enemy>(), new Cons<ArrayList<Enemy>>(this.al1, new Cons<ArrayList<Enemy>>(new ArrayList<Enemy>(),
    			new Cons<ArrayList<Enemy>>(this.al2, new Empty<ArrayList<Enemy>>()))));
    	
    	List<ArrayList<Enemy>> elist2= new Cons<ArrayList<Enemy>>(this.al1, new Cons<ArrayList<Enemy>>(this.al2, new Empty<ArrayList<Enemy>>()));
    	
    	 t.checkExpect(elist1.filtercolumn(), elist2 );
     }
     
     public void testAtTheEdge(Tester t){
    	 this.Setup();
        t.checkExpect(ArrayUtils.firstorlastattheedge(this.al1), false);
        t.checkExpect(ArrayUtils.firstorlastattheedge(this.al3), true);
    	t.checkExpect(ArrayUtils.firstorlastattheedge(this.al4), true);
    	 
     }
     
     
     public void testMoveDownEnemy(Tester t){
    	 this.Setup();
    	 ArrayList<Enemy> finalarray= new ArrayList<Enemy>();
    	 finalarray.add(0, new Enemy(5, 122, false, true, lm3));
    	 finalarray.add(1, new Enemy(5, 62, false, true, lm1));
    	 finalarray.add(2, new Enemy(5, 144, false , true, lm3));
    	 
    	 ArrayList<Enemy> finalarray2= new ArrayList<Enemy>();
    	 finalarray2.add(0, new Enemy(20, 122, false, true, lm1));
    	 finalarray2.add(1, new Enemy(320, 14, false, true, lm3));
    	 
    	 t.checkExpect(ArrayUtils.movedown(this.al3), finalarray);
    	 t.checkExpect(ArrayUtils.movedown(this.al1), finalarray2);
     }
     
     public void testMoveHorEnemy(Tester  t){
    	 this.Setup();
    	 this.al4.add(1, e8);
    	 
    	 ArrayList<Enemy> finalarray= new ArrayList<Enemy>();
    	 finalarray.add(0, new Enemy(3, 120, false, false, lm3));
    	 finalarray.add(1, new Enemy(3, 60, false, false, lm1));
    	 finalarray.add(2, new Enemy(3, 142, false , false, lm3));
    	 
    	 ArrayList<Enemy> finalarray2= new ArrayList<Enemy>();
    	 finalarray2.add(0, new Enemy(18, 120, false, false, lm1));
    	 finalarray2.add(1, new Enemy(318, 12, false, false, lm3));
    	 
    	 ArrayList<Enemy> finalarray3= new ArrayList<Enemy>();
    	 finalarray3.add(0, new Enemy(497, 148, false, true, lm1));
    	 finalarray3.add(1, new Enemy(322, 148, false, true, lm3));
    	 
    	t.checkExpect(ArrayUtils.movehorizontal(this.al3), finalarray);
    	t.checkExpect(ArrayUtils.movehorizontal(this.al1), finalarray2);
    	t.checkExpect(ArrayUtils.movehorizontal(this.al4), finalarray3);	 
     }
     
     public void testGeneralEnemyMover(Tester t){
    	 this.Setup();
    	 //ADD TEST WITH FILTER 
    	 List<ArrayList<Enemy>> generall1= new Empty<ArrayList<Enemy>>();
    	 List<ArrayList<Enemy>> generall2= new Cons<ArrayList<Enemy>>(this.al3, new Cons<ArrayList<Enemy>>(this.al1 , new Empty<ArrayList<Enemy>>()));
    	 List<ArrayList<Enemy>> generall3=  new Cons<ArrayList<Enemy>>(this.al1, new Cons<ArrayList<Enemy>>(this.al4 , new Empty<ArrayList<Enemy>>()));
    	 List<ArrayList<Enemy>> generall4=  new Cons<ArrayList<Enemy>>(this.al1, new Cons<ArrayList<Enemy>>(this.al2 , new Empty<ArrayList<Enemy>>()));
    	 
    	 //Array al3 movedown
    	 ArrayList<Enemy> finalarray= new ArrayList<Enemy>();
    	 finalarray.add(0, new Enemy(5, 122, false, true, lm3));
    	 finalarray.add(1, new Enemy(5, 62, false, true, lm1));
    	 finalarray.add(2, new Enemy(5, 144, false , true, lm3));
    	 
    	 //Array al1 movedown
    	 ArrayList<Enemy> finalarray2= new ArrayList<Enemy>();
    	 finalarray2.add(0, new Enemy(20, 122, false, true, lm1));
    	 finalarray2.add(1, new Enemy(320, 14, false, true, lm3));
    	 
    	 //Array al3 moveside
    	 ArrayList<Enemy> finalarray3= new ArrayList<Enemy>();
    	 finalarray3.add(0, new Enemy(3, 120, false, false, lm3));
    	 finalarray3.add(1, new Enemy(3, 60, false, false, lm1));
    	 finalarray3.add(2, new Enemy(3, 142, false , false, lm3));
    	 
    	 //Array al1 moveside
    	 ArrayList<Enemy> finalarray4= new ArrayList<Enemy>();
    	 finalarray4.add(0, new Enemy(18, 120, false, false, lm1));
    	 finalarray4.add(1, new Enemy(318, 12, false, false, lm3));
    	 
    	 //Array al4 moveside 
    	 ArrayList<Enemy> finalarray5= new ArrayList<Enemy>();
    	 finalarray5.add(0, new Enemy(497, 148, false, true, lm1));
    	 
    	 //Array al4 movedown
    	 ArrayList<Enemy> finalarray6= new ArrayList<Enemy>();
    	 finalarray6.add(0, new Enemy(495, 150, false, false, lm1));
    	//Array al2 moveside
    	 ArrayList<Enemy> finalarray7= new ArrayList<Enemy>();
    	 finalarray7.add(0, new Enemy(318, 12, false, false, lm3));
    	 
    	 SpaceInvaders world1= new SpaceInvaders(this.ship1, generall1, 0, new Empty<Shield>(), new Empty<Ufo>(), 2);
    	 SpaceInvaders world2= new SpaceInvaders(this.ship1, generall2, 0, new Empty<Shield>(), new Empty<Ufo>(), 2);
    	 SpaceInvaders world3= new SpaceInvaders(this.ship1, generall3, 0, new Empty<Shield>(), new Empty<Ufo>(), 2);
    	 SpaceInvaders world4= new SpaceInvaders(this.ship1, generall4, 0, new Empty<Shield>(), new Empty<Ufo>(), 2);
    	 
    	t.checkExpect(world1.moveEn(), world1.enemies);
    	t.checkExpect(world2.moveEn(), new Cons<ArrayList<Enemy>>(finalarray2, new Cons<ArrayList<Enemy>>(finalarray , new Empty<ArrayList<Enemy>>())));
    	t.checkExpect(world3.moveEn(), new Cons<ArrayList<Enemy>>(finalarray6, new Cons<ArrayList<Enemy>>(finalarray2, new Empty<ArrayList<Enemy>>())));
    	t.checkExpect(world4.moveEn(), new Cons<ArrayList<Enemy>>(finalarray7 , new Cons<ArrayList<Enemy>>(finalarray4 , new Empty<ArrayList<Enemy>>())));
    	 
     }
     
     public void testenemyaddMissile(Tester t){
    	 Enemy enemy1= new Enemy(20, 120, false, false, lm1);
         Enemy enemy2= new Enemy(320, 12, false, false, lm3);
         t.checkExpect(enemy1.addMissile(), lm1.cons(new Missile(20, 120, true)));
         t.checkExpect(enemy2.addMissile(), lm3.cons(new Missile(320, 12, true)));
     }
     
     
     // ATTENTION, THIS IS A TEST ON A RANDOM METHOD, HOPE IT IS SUFFICIENT 
     public void testShallIshoot(Tester t){
    	 Enemy enemy3= new Enemy(5, 120, false, false, lm3);
    	 
         t.checkExpect(enemy3.shallIshoot().enemymissiles.length() - 1 == enemy3.enemymissiles.length() || enemy3.shallIshoot().enemymissiles.length()== enemy3.enemymissiles.length(), true);
     }
     
     
     public void testShootMaybe(Tester t){
    	 Enemy enemy1= new Enemy(20, 120, false, false, lm1);
         Enemy enemy2= new Enemy(320, 12, false, false, lm3);
    	 Enemy enemy3= new Enemy(5, 120, false, false, lm3);
    	 ArrayList<Enemy> arrayenemy1= new ArrayList<Enemy>();
    	 arrayenemy1.add(0, enemy1);
    	 arrayenemy1.add(1,enemy2);
    	 arrayenemy1.add(2,enemy3);
    	 
    	 t.checkExpect((ArrayUtils.shootMaybe(arrayenemy1).get(0).enemymissiles.length() - 1 == enemy1.enemymissiles.length() ||
    			       ArrayUtils.shootMaybe(arrayenemy1).get(0).enemymissiles.length() == enemy1.enemymissiles.length()) &&
    			       (ArrayUtils.shootMaybe(arrayenemy1).get(1).enemymissiles.length() - 1 == enemy2.enemymissiles.length() ||
    			       ArrayUtils.shootMaybe(arrayenemy1).get(1).enemymissiles.length() == enemy2.enemymissiles.length()) &&
    			       (ArrayUtils.shootMaybe(arrayenemy1).get(2).enemymissiles.length() - 1 == enemy3.enemymissiles.length() ||
    			       ArrayUtils.shootMaybe(arrayenemy1).get(2).enemymissiles.length() == enemy3.enemymissiles.length())
    			       , true);
     }
     
     public void testShootEn(Tester t){
    	 Enemy enemy1= new Enemy(20, 120, false, false, lm1);
         Enemy enemy2= new Enemy(320, 12, false, false, lm3);
    	 Enemy enemy3= new Enemy(5, 120, false, false, lm3);
    	 Enemy enemy4= new Enemy(320, 148, false, true, lm3);
    	 ArrayList<Enemy> arrayenemy1= new ArrayList<Enemy>();
    	 arrayenemy1.add(0, enemy1);
    	 arrayenemy1.add(1,enemy2);
    	ArrayList<Enemy> arrayenemy2= new ArrayList<Enemy>();
    	arrayenemy2.add(0, enemy3);
    	arrayenemy2.add(0, enemy4);
    	List<ArrayList<Enemy>> ael1= new Empty<ArrayList<Enemy>>();
    	List<ArrayList<Enemy>> ael2= new Cons<ArrayList<Enemy>>(arrayenemy1, new Cons<ArrayList<Enemy>>(arrayenemy2, ael1));
    	SpaceInvaders exworld1= new SpaceInvaders(this.ship1, ael1, 0, new Empty<Shield>(), new Empty<Ufo>(), 2);
    	SpaceInvaders exworld2= new SpaceInvaders(this.ship1, ael2, 0, new Empty<Shield>(), new Empty<Ufo>(), 2);
    	
    	t.checkExpect(exworld1.shootEn(), ael1);
    	
    	t.checkExpect((exworld2.shootEn().getFirst().get(0).enemymissiles.length() - 1 == enemy1.enemymissiles.length() ||
    			exworld2.shootEn().getFirst().get(0).enemymissiles.length() == enemy1.enemymissiles.length()) &&
    			(exworld2.shootEn().getFirst().get(1).enemymissiles.length() - 1 == enemy2.enemymissiles.length() ||
    			exworld2.shootEn().getFirst().get(1).enemymissiles.length() == enemy2.enemymissiles.length()) &&
    			(exworld2.shootEn().getLast().get(0).enemymissiles.length() - 1 == enemy3.enemymissiles.length() ||
    			exworld2.shootEn().getLast().get(0).enemymissiles.length() == enemy3.enemymissiles.length()) ||
    			(exworld2.shootEn().getLast().get(1).enemymissiles.length() - 1 == enemy4.enemymissiles.length() ||
    			exworld2.shootEn().getLast().get(1).enemymissiles.length() == enemy4.enemymissiles.length()), true);	
     }
     
     public void testMoveSauc(Tester t){
    	 Ufo u1= new Ufo(350, 20, false);
    	 Ufo u2= new Ufo(100, 15, false);
    	 Ufo u3= new Ufo(100, 15, true);
    	 Ufo u4= new Ufo(200 , 17, true);
    	
    	 SpaceInvaders ufoworld1= new SpaceInvaders(this.ship1, new Empty<ArrayList<Enemy>>(), 0, new Empty<Shield>(), new Empty<Ufo>(), 2);
    	 SpaceInvaders ufoworld2= new SpaceInvaders(this.ship1, new Empty<ArrayList<Enemy>>(), 0, new Empty<Shield>(), new Cons<Ufo>(u3, new Empty<Ufo>()), 2);
    	 SpaceInvaders ufoworld3= new SpaceInvaders(this.ship1, new Empty<ArrayList<Enemy>>(), 0, new Empty<Shield>(), new Cons<Ufo>(u2, new Empty<Ufo>()), 2);
    	 t.checkExpect(u1.moveSauc(), new Ufo(348, 20, false));
    	 t.checkExpect(u2.moveSauc(), new Ufo(100, 15, true));
    	 t.checkExpect(u3.moveSauc(), new Ufo(102, 15, true));
    	 t.checkExpect(u4.moveSauc(), new Ufo(202, 17, true));
    	 t.checkExpect(ufoworld1.moveSaucer(), new Empty<Ufo>());
    	 t.checkExpect(ufoworld2.moveSaucer(), new Cons<Ufo>(new Ufo(102, 15, true) , new Empty<Ufo>()));
    	 t.checkExpect(ufoworld3.moveSaucer(),  new Cons<Ufo>(new Ufo(100, 15, true) , new Empty<Ufo>()));
     }
     
     
     public void testGotShot(Tester t){
    	 Missile mymissile1= new Missile(20, 30, false);
    	 Enemy en1= new Enemy(18, 27, false, false, lm1);
    	 Missile mymissile2= new Missile(20, 30, false);
    	 Enemy en2= new Enemy(18, 270, false, false, lm1);
    	 
    	 t.checkExpect(en1.gotshot(mymissile1), true);
    	 t.checkExpect(en2.gotshot(mymissile2), false);
     }
     
     public void testShotany(Tester t){
    	 Missile mymissile1= new Missile(20, 30, false);
    	 Missile mymissile2= new Missile(224, 7, false);
    	 Missile mymissile3= new Missile(108, 330, false);
    	 Missile mymissile4= new Missile(50, 80, false);
    	List<Missile> lmissiles1= new Empty<Missile>();
    	List<Missile> lmissile2= new Cons<Missile>(mymissile1, new Cons<Missile>(mymissile2 , lmissiles1));
    	List<Missile> lmissile3= new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile4 , lmissiles1));
    	List<Missile> lmissile4= new Cons<Missile>(mymissile2, new Cons<Missile>(mymissile4 , lmissiles1));
    	List<Missile> lmissile5= new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile1 , lmissiles1));
    	 Enemy shotenemy= new Enemy(220,11, false, true, lmissiles1);
    	 
    	 t.checkExpect(lmissiles1.shotany(shotenemy), false);
    	 t.checkExpect(lmissile2.shotany(shotenemy), true);
    	 t.checkExpect(lmissile3.shotany(shotenemy), false);
    	 t.checkExpect(lmissile4.shotany(shotenemy), true);
    	 t.checkExpect(lmissile5.shotany(shotenemy), false);
     }
     
     public void testShotp(Tester t){
    	 Missile mymissile1= new Missile(20, 30, false);
    	 Missile mymissile2= new Missile(224, 7, false);
    	 Missile mymissile3= new Missile(108, 330, false);
    	 Missile mymissile4= new Missile(50, 80, false);
    	List<Missile> lmissiles1= new Empty<Missile>();
    	List<Missile> lmissile2= new Cons<Missile>(mymissile1, new Cons<Missile>(mymissile2 , lmissiles1));
    	List<Missile> lmissile3= new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile4 , lmissiles1));
    	List<Missile> lmissile4= new Cons<Missile>(mymissile2, new Cons<Missile>(mymissile4 , lmissiles1));
    	List<Missile> lmissile5= new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile1 , lmissiles1));
    	Ship ss1= new Ship(250, 480, false, 3, lmissiles1);
    	Ship ss2= new Ship(250, 480, false, 3, lmissile2);
    	Ship ss3= new Ship(250, 480, false, 3, lmissile3);
    	Ship ss4= new Ship(250, 480, false, 3, lmissile4);
    	Ship ss5= new Ship(250, 480, false, 3, lmissile5);
    	 Enemy shotenemy= new Enemy(220,11, false, true, lmissiles1);
    	 
    	t.checkExpect(shotenemy.shotp(ss1), false);
    	t.checkExpect(shotenemy.shotp(ss2), true);
    	t.checkExpect(shotenemy.shotp(ss3), false);
    	t.checkExpect(shotenemy.shotp(ss4), true);
    	t.checkExpect(shotenemy.shotp(ss5), false);
    	
     }
     
     public void testRemoveShot(Tester t){
    	 Missile mymissile1= new Missile(20, 30, false);
    	 Missile mymissile2= new Missile(224, 7, false);
    	 Missile mymissile3= new Missile(108, 330, false);
    	 Missile mymissile4= new Missile(50, 80, false);
    	List<Missile> lmissiles1= new Empty<Missile>();
    	List<Missile> lmissile2= new Cons<Missile>(mymissile1, new Cons<Missile>(mymissile2 , lmissiles1));
    	List<Missile> lmissile3= new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile4 , lmissiles1));
    	List<Missile> lmissile4= new Cons<Missile>(mymissile2, new Cons<Missile>(mymissile4 , lmissiles1));
    	List<Missile> lmissile5= new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile1 , lmissiles1));
    	Ship ss2= new Ship(250, 480, false, 3, lmissile2);
    	Ship ss3= new Ship(250, 480, false, 3, lmissile3);
    	Ship ss4= new Ship(250, 480, false, 3, lmissile4);
    	Ship ss5= new Ship(250, 480, false, 3, lmissile5);
    	 Enemy shotenemy= new Enemy(220,11, false, true, lmissiles1); // shot
    	 Enemy shotenemy2= new Enemy(107,326, false, true, lmissiles1); // shot
    	 Enemy shotenemy3= new Enemy(66,77, false, true, lmissiles1);
    	 Enemy shotenemy4= new Enemy(100,102, false, true, lmissiles1);
    	 Enemy shotenemy5= new Enemy(400,111, false, true, lmissiles1);
    	 Enemy shotenemy6= new Enemy(46,83, false, true, lmissiles1); // shot
    	 ArrayList<Enemy> ael1= new ArrayList<Enemy>();
    	 ArrayList<Enemy> ael2= new ArrayList<Enemy>(); // empty
    	 ArrayList<Enemy> ael3= new ArrayList<Enemy>();
    	 ArrayList<Enemy> ael4= new ArrayList<Enemy>();
    	 ArrayList<Enemy> ael5= new ArrayList<Enemy>();
    	 
    	 ael1.add(0, shotenemy);
    	 ael1.add(1, shotenemy3);
    	 ael3.add(0,shotenemy2);
    	 ael3.add(1, shotenemy4);
    	 ael4.add(0, shotenemy6);
    	 ael4.add(1,shotenemy5);
    	 ael5.add(0, shotenemy4);
    	 ael5.add(1, shotenemy5);
    	 
    	 ArrayList<Enemy> res1= new ArrayList<Enemy>();
    	 ArrayList<Enemy> res3= new ArrayList<Enemy>();
    	 ArrayList<Enemy> res4= new ArrayList<Enemy>();
    	 ArrayList<Enemy> res5= new ArrayList<Enemy>();
    	 
    	 res1.add(0, shotenemy3);
    	 res3.add(0, shotenemy4);
    	 res4.add(0,shotenemy5);
    	 res5.add(0, shotenemy4);
    	 res5.add(1, shotenemy5);
    	 
    	 t.checkExpect(ArrayUtils.removeShot(ss2, ael1), res1);
    	 t.checkExpect(ArrayUtils.removeShot(ss3, ael3), res3);
    	 t.checkExpect(ArrayUtils.removeShot(ss4, ael4), res4);
    	 t.checkExpect(ArrayUtils.removeShot(ss5,ael5), res5);
    	 t.checkExpect(ArrayUtils.removeShot(ss2, ael2), ael2);
    	 
    	 
     }
     
     public void testRemoveDead(Tester t){
    	 Missile mymissile1= new Missile(20, 30, false);
    	 Missile mymissile2= new Missile(224, 7, false);
    	 Missile mymissile3= new Missile(108, 330, false);
    	 Missile mymissile4= new Missile(50, 80, false);
    	List<Missile> lmissiles1= new Empty<Missile>();
    	List<Missile> lmissile2= new Cons<Missile>(mymissile1, new Cons<Missile>(mymissile2 , lmissiles1));
    	List<Missile> lmissile3= new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile4 , lmissiles1));
    	List<Missile> lmissile4= new Cons<Missile>(mymissile2, new Cons<Missile>(mymissile4 , lmissiles1));
    	List<Missile> lmissile5= new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile1 , lmissiles1));
    	Ship ss2= new Ship(250, 480, false, 3, lmissile2);
    	Ship ss3= new Ship(250, 480, false, 3, lmissile3);
    	Ship ss4= new Ship(250, 480, false, 3, lmissile4);
    	Ship ss5= new Ship(250, 480, false, 3, lmissile5);
    	 Enemy shotenemy= new Enemy(220,11, false, true, lmissiles1); // shot
    	 Enemy shotenemy2= new Enemy(107,326, false, true, lmissiles1); // shot
    	 Enemy shotenemy3= new Enemy(66,77, false, true, lmissiles1);
    	 Enemy shotenemy4= new Enemy(100,102, false, true, lmissiles1);
    	 Enemy shotenemy5= new Enemy(400,111, false, true, lmissiles1);
    	 Enemy shotenemy6= new Enemy(46,83, false, true, lmissiles1); // shot
    	 ArrayList<Enemy> ael1= new ArrayList<Enemy>();
    	 ArrayList<Enemy> ael3= new ArrayList<Enemy>();
    	 ArrayList<Enemy> ael4= new ArrayList<Enemy>();
    	 ArrayList<Enemy> ael5= new ArrayList<Enemy>();
    	 
    	 ael1.add(0, shotenemy);
    	 ael1.add(1, shotenemy3);
    	 ael3.add(0,shotenemy2);
    	 ael3.add(1, shotenemy4);
    	 ael4.add(0, shotenemy6);
    	 ael4.add(1,shotenemy5);
    	 ael5.add(0, shotenemy4);
    	 ael5.add(1, shotenemy5);
    	 
    	 ArrayList<Enemy> res1= new ArrayList<Enemy>();
    	 ArrayList<Enemy> res3= new ArrayList<Enemy>();
    	 ArrayList<Enemy> res4= new ArrayList<Enemy>();
    	 ArrayList<Enemy> res5= new ArrayList<Enemy>();
    	 
    	 res1.add(0, shotenemy3);
    	 res3.add(0, shotenemy4);
    	 res4.add(0,shotenemy5);
    	 res5.add(0, shotenemy4);
    	 res5.add(1, shotenemy5);
     
    	 List<ArrayList<Enemy>> ll1= new Empty<ArrayList<Enemy>>();
    	 List<ArrayList<Enemy>> ll2= new Cons<ArrayList<Enemy>>(ael1, new Cons<ArrayList<Enemy>>(ael3, ll1));
    	 List<ArrayList<Enemy>> ll3= new Cons<ArrayList<Enemy>>(ael1, new Cons<ArrayList<Enemy>>(ael3, ll1));
    	 List<ArrayList<Enemy>> ll4= new Cons<ArrayList<Enemy>>(ael4, new Cons<ArrayList<Enemy>>(ael3, ll1));
    	 List<ArrayList<Enemy>> ll5= new Cons<ArrayList<Enemy>>(ael1, new Cons<ArrayList<Enemy>>(ael5, ll1));
    	 
    	 SpaceInvaders sworld1= new SpaceInvaders (ss2, ll2, 0, new Empty<Shield>(), new Empty<Ufo>(), 1);
    	 SpaceInvaders sworld2= new SpaceInvaders (ss3, ll3, 0, new Empty<Shield>(), new Empty<Ufo>(), 1);
    	 SpaceInvaders sworld3= new SpaceInvaders (ss4, ll4, 0, new Empty<Shield>(), new Empty<Ufo>(), 1);
    	 SpaceInvaders sworld4= new SpaceInvaders (ss5, ll5, 0, new Empty<Shield>(), new Empty<Ufo>(), 1);
    	 
    	 t.checkExpect(sworld1.removeDead(), new Cons<ArrayList<Enemy>>(ael3, new Cons<ArrayList<Enemy>>(res1, ll1)));
    	 t.checkExpect(sworld2.removeDead(), new Cons<ArrayList<Enemy>>(res3, new Cons<ArrayList<Enemy>>(ael1, ll1)));
    	 t.checkExpect(sworld3.removeDead(), new Cons<ArrayList<Enemy>>(ael3, new Cons<ArrayList<Enemy>>(res4, ll1)));
    	 t.checkExpect(sworld4.removeDead(), new Cons<ArrayList<Enemy>>(ael5, new Cons<ArrayList<Enemy>>(ael1, ll1)));
     }
     
     public void testCollidewithship(Tester t){
    	Ship ss2= new Ship(250, 480, false, 3, new Empty<Missile>());
     	Ship ss3= new Ship(12, 480, false, 3, new Empty<Missile>());
     	Ship ss4= new Ship(413, 480, false, 3, new Empty<Missile>());
     	Ship ss5= new Ship(48, 480, false, 3, new Empty<Missile>());
     	 Missile mymissile1= new Missile(251, 476, true);
    	 Missile mymissile2= new Missile(249, 7, true);
    	 Missile mymissile3= new Missile(410, 483, true);
    	 Missile mymissile4= new Missile(5, 481, true);
    	 
    	 t.checkExpect(mymissile1.collidedwithShip(ss2), true);
    	 t.checkExpect(mymissile3.collidedwithShip(ss4), true);
    	 t.checkExpect(mymissile2.collidedwithShip(ss3), false);
    	 t.checkExpect(mymissile4.collidedwithShip(ss5), false);
    	 
     }
     
     public void testMissileshotShip(Tester t){
    	 	Ship ss2= new Ship(250, 480, false, 3, new Empty<Missile>());
         	Ship ss3= new Ship(12, 480, false, 3, new Empty<Missile>());
         	Ship ss4= new Ship(413, 480, false, 3, new Empty<Missile>());
         	Ship ss5= new Ship(48, 480, false, 3, new Empty<Missile>());
         	 Missile mymissile1= new Missile(251, 476, true);
        	 Missile mymissile2= new Missile(249, 7, true);
        	 Missile mymissile3= new Missile(410, 483, true);
        	 Missile mymissile4= new Missile(5, 481, true);
        	 List<Missile> mlist= new Cons<Missile>(mymissile1, new Cons<Missile>( mymissile2, new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile4, new Empty<Missile>()))));
        	 t.checkExpect(mlist.MissileShotShip(ss2), true);
        	 t.checkExpect(mlist.MissileShotShip(ss4), true);
        	 t.checkExpect(mlist.MissileShotShip(ss3), false);
        	 t.checkExpect(mlist.MissileShotShip(ss5), false);   	 
     }
     public void testEnemyshotShip(Tester t){
    	 Ship ss2= new Ship(250, 480, false, 3, new Empty<Missile>());
      	Ship ss3= new Ship(12, 480, false, 3, new Empty<Missile>());
      	Ship ss4= new Ship(413, 480, false, 3, new Empty<Missile>());
      	Ship ss5= new Ship(48, 480, false, 3, new Empty<Missile>());
      	 Missile mymissile1= new Missile(251, 476, true);
     	 Missile mymissile2= new Missile(249, 7, true);
     	 Missile mymissile3= new Missile(410, 483, true);
     	 Missile mymissile4= new Missile(5, 481, true);
     	 List<Missile> mlist= new Cons<Missile>(mymissile1, new Cons<Missile>( mymissile2, new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile4, new Empty<Missile>()))));
     	 Enemy e= new Enemy(250, 470, false, false, mlist);
     	 t.checkExpect(e.enemyShotShip(ss2), true);
    	 t.checkExpect(e.enemyShotShip(ss4), true);
    	 t.checkExpect(e.enemyShotShip(ss3), false);
         t.checkExpect(e.enemyShotShip(ss5), false);   
     }
     
     public void testShotTheShip(Tester t){
    	 Ship ss2= new Ship(250, 480, false, 3, new Empty<Missile>());
       	Ship ss3= new Ship(12, 480, false, 3, new Empty<Missile>());
       	Ship ss4= new Ship(413, 480, false, 3, new Empty<Missile>());
       	Ship ss5= new Ship(48, 480, false, 3, new Empty<Missile>());
       	 Missile mymissile1= new Missile(251, 476, true);
      	 Missile mymissile2= new Missile(249, 7, true);
      	 Missile mymissile3= new Missile(410, 483, true);
      	 Missile mymissile4= new Missile(5, 481, true);
      	 Missile fakem= new Missile(500,500, true);
      	 Missile fakem2= new Missile(1,2, true);
      	 Missile fakem3= new Missile(20,30, true);
      	 List<Missile> mlist= new Cons<Missile>(mymissile1, new Cons<Missile>( mymissile2, new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile4, new Empty<Missile>()))));
      	 List<Missile> fmlist= new Cons<Missile>( fakem , new Cons<Missile>(fakem2, new Cons<Missile>(fakem3, new Empty<Missile>())));
      	 Enemy e= new Enemy(250, 470, false, false, mlist);
      	 Enemy e2= new Enemy(240,330, false, true, fmlist);
      	 Enemy e3= new Enemy(20, 32, false, false, new Cons<Missile>(fakem3, new Cons<Missile>(mymissile1, new Cons<Missile>(fakem, new Empty<Missile>()))));
      	 ArrayList<Enemy> ar1= new ArrayList<Enemy>();
      	ArrayList<Enemy> ar2= new ArrayList<Enemy>();
      	ArrayList<Enemy> ar3= new ArrayList<Enemy>();
      	ar1.add(0, e2);
      	ar1.add(1, e);
      	ar2.add(0,e2);
      	ar3.add(0,e2);
      	ar3.add(1,e3);
      	ar3.add(2, e);
      	
      	t.checkExpect(ArrayUtils.shotTheShip(ss2, ar1), true);
      	t.checkExpect(ArrayUtils.shotTheShip(ss3, ar1), false);
      	t.checkExpect(ArrayUtils.shotTheShip(ss2, ar2), false);
      	t.checkExpect(ArrayUtils.shotTheShip(ss3, ar2), false);
      	t.checkExpect(ArrayUtils.shotTheShip(ss4, ar2), false);
      	t.checkExpect(ArrayUtils.shotTheShip(ss5, ar2), false);
      	t.checkExpect(ArrayUtils.shotTheShip(ss2, ar3), true);
     }
     
     public void testShotTheBastard(Tester t){
    	 Ship ss2= new Ship(250, 480, false, 3, new Empty<Missile>());
       	Ship ss5= new Ship(48, 480, false, 3, new Empty<Missile>());
       	 Missile mymissile1= new Missile(251, 476, true);
      	 Missile mymissile2= new Missile(249, 7, true);
      	 Missile mymissile3= new Missile(410, 483, true);
      	 Missile mymissile4= new Missile(5, 481, true);
      	 Missile fakem= new Missile(500,500, true);
      	 Missile fakem2= new Missile(1,2, true);
      	 Missile fakem3= new Missile(20,30, true);
      	 List<Missile> mlist= new Cons<Missile>(mymissile1, new Cons<Missile>( mymissile2, new Cons<Missile>(mymissile3, new Cons<Missile>(mymissile4, new Empty<Missile>()))));
      	 List<Missile> fmlist= new Cons<Missile>( fakem , new Cons<Missile>(fakem2, new Cons<Missile>(fakem3, new Empty<Missile>())));
      	 Enemy e= new Enemy(250, 470, false, false, mlist);
      	 Enemy e2= new Enemy(240,330, false, true, fmlist);
      	 Enemy e3= new Enemy(20, 32, false, false, new Cons<Missile>(fakem3, new Cons<Missile>(mymissile1, new Cons<Missile>(fakem, new Empty<Missile>()))));
      	 ArrayList<Enemy> ar1= new ArrayList<Enemy>();
      	ArrayList<Enemy> ar2= new ArrayList<Enemy>();
      	ArrayList<Enemy> ar3= new ArrayList<Enemy>();
      	ar1.add(0, e2);
      	ar1.add(1, e);
      	ar2.add(0,e2);
      	ar3.add(0,e2);
      	ar3.add(1,e3);
      	ar3.add(2, e);
      	List<ArrayList<Enemy>> ale1= new Cons<ArrayList<Enemy>>(ar1, new Cons<ArrayList<Enemy>>(ar2, new Cons<ArrayList<Enemy>>(ar3, new Empty<ArrayList<Enemy>>())));
      
      	t.checkExpect(ale1.shotTheBastard(ss2), true);
      	t.checkExpect(ale1.shotTheBastard(ss5), false);
     }
     
     
     public void testCountShot(Tester t){
    	 Enemy e1= new Enemy(231, 32, false, false, new Empty<Missile>());
    	 Enemy e2= new Enemy(29, 324, false, false, new Empty<Missile>());
    	 Enemy e3= new Enemy(127, 98, false, false, new Empty<Missile>());
    	 List<Missile> nml= new Cons<Missile>(new Missile(229, 35, false), new Cons <Missile>(new Missile(25, 325, false), new Cons<Missile>(new Missile(10,2,false), new Empty<Missile>())));
    	 Ship s1= new Ship(250, 480, false, 3, nml);
    	 ArrayList<Enemy> ael1= new ArrayList<Enemy>();
    	 ael1.add(0, e1);
    	 ael1.add(1, e3);
    	 ael1.add(2, e2);
    	 t.checkExpect(ArrayUtils.countShot(s1, ael1), 2);
     }
     
     public void testIncrementScore(Tester t){
    	 Enemy e1= new Enemy(231, 32, false, false, new Empty<Missile>()); // shot
    	 Enemy e2= new Enemy(29, 324, false, false, new Empty<Missile>()); // shot 
    	 Enemy e3= new Enemy(127, 98, false, false, new Empty<Missile>());
     	 Enemy e4= new Enemy(10, 32, false, false, new Empty<Missile>()); 
    	 Enemy e5= new Enemy(145, 146, false, false, new Empty<Missile>());// shot
    	 Enemy e6= new Enemy(12, 98, false, false, new Empty<Missile>());
    	 List<Missile> nml= new Cons<Missile>(new Missile(229, 35, false), new Cons <Missile>(new Missile(25, 325, false), new Cons<Missile>(new Missile(10,2,false),
    			 new Cons<Missile>(new Missile(146, 144, false), new Empty<Missile>()))));
    	 Ship s1= new Ship(250, 480, false, 3, nml);
    	 ArrayList<Enemy> ael1= new ArrayList<Enemy>();
    	 ArrayList<Enemy> ael2= new ArrayList<Enemy>();
         ArrayList<Enemy> ael3= new ArrayList<Enemy>();
    	 ael1.add(0, e1);
    	 ael1.add(1, e3);
    	 ael2.add(e4);
    	 ael2.add(e2);
    	 ael3.add(e6);
    	 ael3.add(e5);
    	 List<ArrayList<Enemy>> listofen= new Cons<ArrayList<Enemy>>(ael1, new Cons<ArrayList<Enemy>>(ael2, new Cons<ArrayList<Enemy>>(ael3, new Empty<ArrayList<Enemy>>())));
    	SpaceInvaders world= new SpaceInvaders(s1, listofen, 3, new Empty<Shield>(), new Empty<Ufo>(), 2);
    	
    	t.checkExpect(world.IncrementScore(), 6);
 
     }
     */
     public void testInitializers(Tester t){
    	 t.checkExpect(w1,3);
     }
 	SpaceInvaders w1 = new SpaceInvaders();

 	boolean runAnimation = this.w1.bigBang(500, 800, 0.1);

}

