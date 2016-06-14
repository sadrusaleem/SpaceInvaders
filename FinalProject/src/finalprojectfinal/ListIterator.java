package finalprojectfinal;


import java.util.Iterator;

public class ListIterator<T> implements  Iterator<T>{

	List<T> Conslist;

	ListIterator(List<T> l){
		this.Conslist=l;

	}

	@Override
	public boolean hasNext() {
	      return !this.Conslist.endp();
	}

	//Tested 
	@Override
	public T next() {
	      List<T> result= this.Conslist;
	      this.Conslist= Conslist.getRest();
	      return result.getFirst();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}


}