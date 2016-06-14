package finalprojectfinal;

import javalib.colors.*;
import javalib.worldimages.*;

public class Shield {
	int x;
	int y;
	int health; 

	Shield(int x, int y){
		this.x=x;
		this.y=y;
		this.health=5;
	}
	

	public WorldImage draw() {
		return new RectangleImage(new Posn(this.x, this.y), 50, 10, new White());
	}
	
	public WorldImage drawon(WorldImage scn){
		return new OverlayImages(scn, this.draw());
	}

	
	//in onTick, this needs to be passed the x and y of the Ship
		public Shield moveTo(int x, int y){
			this.x = x;
			this.y = y-5;
			return this;
		}
		
		//lowers the health of the shield by 1 
		public Shield hit(){
			this.health = this.health - 1;
			return this;
		}
}

