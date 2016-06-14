package finalprojectfinal;

import java.util.ArrayList;
import java.util.Iterator;

public class Cons<T> implements List<T>{
	T first;
	List<T> rest;

	Cons(T f, List<T> r){
		this.first=f;
		this.rest=r;
	}

	@Override
	public List<T> cons(T e) {
		return new Cons<T>(e, this);
	}

	@Override
	public T getFirst() {
		return this.first;
	}

	@Override
	public List<T> getRest() {
		return this.rest;
	}

	@Override
	public List<T> append(List<T> l) {
		return null;
		/// TO DO 
	}

	@Override
	public int length() {
		return 1 + this.rest.length();
	}

	@Override
	public Iterator<T> iterator() {
	   return new ListIterator<T>(this);
	}
 // Tested 
   public boolean shotany(Enemy e){
        return e.gotshot((Missile) this.first) || this.rest.shotany(e);
}
   
   public boolean endp(){
	   return false;
   }
   
   /// TESTED 
   @SuppressWarnings("unchecked")
public List<ArrayList<Enemy>> filtercolumn(){
	   if(((ArrayList<Enemy>)this.first).size() == 0){
		 return  this.rest.filtercolumn();
	   }else {
		   return new Cons<ArrayList<Enemy>>((ArrayList<Enemy>)this.first, this.rest.filtercolumn());
	   }
   }
   
   public T getLast(){
	   if(this.rest.endp()){
		   return this.first;
	   }else{
		   return this.rest.getLast();
	   }
   }
   
   //TESTED
   @SuppressWarnings("unchecked")
public boolean shotTheBastard(Ship s){
	   return ArrayUtils.shotTheShip(s, (ArrayList<Enemy>) this.first) || this.rest.shotTheBastard(s);
   }

@Override
//Tested
public boolean MissileShotShip(Ship s) {
	return ((Missile) this.first).collidedwithShip(s) || this.rest.MissileShotShip(s);
}

public boolean allempty(){
	return ((ArrayList<Enemy>) this.first).size()==0 && this.rest.allempty();
}
}
