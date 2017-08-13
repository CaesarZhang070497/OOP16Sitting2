import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Fermat {                               // threadmaker({[]}, {red,green},2)
	public static Set<ArrayList<String>> threadmaker(Set<ArrayList<String>> result ,Set<String> set,int n){
		if(n ==0){
			return result;
		}
		
		Set<ArrayList<String>> result1 = new HashSet<ArrayList<String>>();
		
		for(ArrayList<String> arr : result){
			
			for(String str :set){
				
				ArrayList<String> arr1 = new ArrayList<String>(arr);
				
				arr1.add(str);
				result1.add(arr1);
			}
		}
		
		return threadmaker(result1,set,n-1);
	}
	
                          // threadings(0, {red,green})
	public static Set<ArrayList<String>> threadings(int n,Set<String> set){
		Set<ArrayList<String>> result = new HashSet<ArrayList<String>>();
		ArrayList<String> arr = new ArrayList<String>();
		result.add(arr);
		return threadmaker(result,set,n);
	}
	
	
	public static boolean isEquiv ( ArrayList < String > st1 ,ArrayList <String > st2 ){
		boolean result = false ;
		String [] str1 = st1. toArray ( new String [ st1. size () ]);
		String [] str2 = st2. toArray ( new String [ st2. size () ]);
	    int len = str1 . length ;
			
	    for(int i = 0; i < len ; i ++) {
	    	boolean temp = true ;
	    	for (int sub = 0; sub < len ; sub ++) {
	    		if( str1 [i] != str2 [( sub+ i)% len ]){
	    			temp = false ;
	    		}
	    	}
		 result = result || temp ;
		}
	    
		for(int con = 0; con < len ; con ++) {
			 boolean temp = true ;
			 for (int sub = 0; sub < len ; sub ++) {
				 if( str1 [con] != str2 [( len+ len+len -1 -( sub+ con))% len ]){
					 temp = false ;
				 }
			 }
					 result = result || temp ;
				 }
			 return result;
			 }
	          
	public static void analyse(Set<ArrayList<String>> set){
		
		for(ArrayList<String> arr :set){
			Set<ArrayList<String>> set1 = new HashSet<ArrayList<String>>(set);
			
			set1.remove(arr);
			
			int index = 0;
			
			for(ArrayList<String> arr1:set1){
				if(isEquiv(arr,arr1)){
					
					index++;
					
				}
			}
			if(index ==0){
				System.out.println(arr + " is a singleton");
			}
		}
	}
	
	public static void main(String[] args) {
		Set<ArrayList<String>> set = new HashSet<ArrayList<String>>();
		ArrayList<String> a = new ArrayList<String>();
		a.add("red");
		a.add("red");
//		a.add("blue");
//		a.add("pink");
		
		ArrayList<String> b = new ArrayList<String>();
		
		
		b.add("red");
		b.add("green");
//		b.add("green");
//		b.add("red");
		
		ArrayList<String> c = new ArrayList<String>();
		
		c.add("green");
		c.add("red");
//		c.add("green");
//		c.add("red");
		
		set.add(a);
		set.add(b);
		set.add(c);
		analyse(set);
//		System.out.println(set);
		System.out.println(isEquiv(a,b));
		
	}
}
