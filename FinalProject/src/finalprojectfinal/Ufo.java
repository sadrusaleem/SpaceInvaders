package finalprojectfinal;

import javalib.colors.White;
import javalib.worldimages.CircleImage;
import javalib.worldimages.FromFileImage;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

public class Ufo {
	int x;
	int y;
	boolean dir; 

	Ufo(){
		this.x=490;
		this.y=20;
		this.dir=false;
	}
	
	Ufo(int x, int y, boolean dir){
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
	
	/// Tested 
	public Ufo moveSauc(){
		if(this.x == 100 && this.dir == false){
			return new Ufo(this.x, this.y, true);
		}else if(this.dir == false){
			return new Ufo(this.x - 2, this.y, this.dir);
		}else {
			return new Ufo(this.x + 2, this.y, this.dir);
		}
	}
	
	public boolean didIgetShot(List<Missile> l){
	  if (l.endp()){
		  return false;
	  }else {
		  return this.collidedwithMissile(l.getFirst()) || this.didIgetShot(l.getRest());
	  }
	}
	
	public boolean collidedwithMissile(Missile m){
		return ((m.x < this.x +10 ) && (m.x > this.x - 10)) &&  ((m.y < this.y +10 ) && (m.y > this.y - 10));
	}
	
	public WorldImage draw(){
		return new CircleImage(new Posn(this.x,this.y),10, new White());
	}
	
	public WorldImage drawOn(WorldImage scn){
		return new OverlayImages(scn, this.draw());
	}
}