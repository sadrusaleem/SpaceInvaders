package finalprojectfinal;

import java.util.ArrayList;

public class ArrayUtils{


	/// Tested 
	static ArrayList<Enemy> movedown(ArrayList<Enemy> l){
		ArrayList<Enemy> initial= new ArrayList<Enemy>();
		for(int i=0; i<l.size(); i++){
			initial.add(l.get(i).moveVertical());
		} return initial;
	}
	
	static ArrayList<Enemy> movedown2(ArrayList<Enemy> l){
		ArrayList<Enemy> initial= new ArrayList<Enemy>();
		for(int i=0; i<l.size(); i++){
			initial.add(l.get(i).moveVertical2());
		} return initial;
	}
    //tested 	
	static ArrayList<Enemy> movehorizontal(ArrayList<Enemy> l){
		ArrayList<Enemy> initial= new ArrayList<Enemy>();
		for(int i=0; i<l.size(); i++){
			initial.add(l.get(i).moveHorizontal());
		} return initial;
	}
     
	// TESTED MIGHT BE REVERSING THE LIST NO IDEA !!!! 
     static ArrayList<Enemy> shootMaybe(ArrayList<Enemy> l){
    	 ArrayList<Enemy> initial= new ArrayList<Enemy>();
    	 
    	 for(int i=0; i<l.size(); i++){
    		 initial.add(l.get(i).shallIshoot());
    	 } return initial;	
     }

     ////////////////////////////////
     //TESTED 
     static ArrayList<Enemy> removeShot(Ship s, ArrayList<Enemy> l){
    	 ArrayList<Enemy> initial= new ArrayList<Enemy>();
    	 
    	 for(int i=0; i<l.size(); i++){
    		 
    		 if  (!l.get(i).shotp(s)){
    			 initial.add(l.get(i));
    		 }else if(l.get(i).health == 2){
    			 Enemy e = l.get(i);
    			 e.health = 1;
    			 initial.add(e);
    		 }
    		 
    		 else{
    		 
    	 }
     } return initial;   
}
     
     // Do I need to check If all is at the edge? 
     // TESTED 
     static boolean firstorlastattheedge(ArrayList<Enemy> l){
     return (l.get(0).x <= 30 || l.get(0).x >= 480) ||  (l.get(l.size() - 1).x <= 30 || l.get(l.size() - 1).x >= 480);	
}
     
     //TESTED
    static boolean shotTheShip(Ship s, ArrayList<Enemy> ale){
    	 boolean result = false;
    	 boolean accresult= false;
    	
    	 for(Enemy e: ale){
    		 result = e.enemyShotShip(s) || accresult;
    		 accresult= result;
    	 } return result;	 
     }
    
    
    // Tested
    static int countShot(Ship s, ArrayList<Enemy> l){
    	int initial=0;
    			for(int i= 0; i< l.size(); i++){
    				if(l.get(i).shotp(s)){
    					initial= initial + 1;
    				}else {
    			}
    } return initial;
}
    
}
