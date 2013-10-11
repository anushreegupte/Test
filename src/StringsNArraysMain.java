/*
 * Author: anushree Gupte
 * Desc: Crackin the coding questions*/
public class StringsNArraysMain {

	public static void main (String[] args){
		
		StringsNArrays s = new StringsNArrays();
		
		if(s.isUnique1("annu")){   // if function returns true
			System.out.println("Unique");
		}else{
			System.out.println("Not Unique");
		}
		
		
		if (s.isUnique2("annu")){
			System.out.println("Unique");
		}
		else{
			System.out.println("Not unique");
		}
		
		
		if (s.isUnique3("abcdea")){
			System.out.println("Unique");
		}
		else{
			System.out.println("Not unique");
		}
		
		
		//-------------------------------------------------------
		
		System.out.println(s.reverse1("Anushree"));
		System.out.println("Permutation: " +s.permutation2("aba", "abb"));
		
		System.out.println("Replaced string: " +s.replace1("a b c    ",5));
		
		System.out.println("Compressed string:"+s.compression("aabb") );
		
			
		
	}
}
