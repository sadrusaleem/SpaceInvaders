package finalprojectfinal;

import java.util.ArrayList;


public interface List<T> extends Iterable<T>{
     List<T> cons(T e);
     T getFirst();
     List<T> getRest();
     List<T> append(List<T> l);
     int length();
     boolean shotany(Enemy e);
     boolean endp();
     List<ArrayList<Enemy>> filtercolumn();
     T getLast();
     boolean shotTheBastard(Ship s);
     boolean MissileShotShip(Ship s);
     boolean allempty();
}