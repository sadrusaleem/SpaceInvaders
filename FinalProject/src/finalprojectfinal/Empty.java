package finalprojectfinal;

import java.util.ArrayList;
import java.util.Iterator;

public class Empty<T> implements List<T>{

	@Override
	public List<T> cons(T e) {
		return new Cons<T>(e, this);
	}

	@Override
	public T getFirst() {
		throw new RuntimeException("Empty: First doesn't exist");
	}

	@Override
	public List<T> getRest() {
		throw new RuntimeException("Empty: Rest doesn't exist");
	}

	@Override
	public List<T> append(List<T> l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		return 0;
	}

    public boolean shotany(Enemy e){
    	return false;
    }

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}

	public boolean endp(){
		return true;
	}

	//TESTED
	public List<ArrayList<Enemy>> filtercolumn(){
		return new Empty<ArrayList<Enemy>>();
	}

    public T getLast(){
    	throw new RuntimeException("Empty has no last");
    }

	@Override
	public boolean shotTheBastard(Ship s) {
		return false;
	}

	@Override
	public boolean MissileShotShip(Ship s) {
		return false;
	}
	
	public boolean allempty(){
		return true;
	}
}
