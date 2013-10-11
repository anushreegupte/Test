import java.util.ArrayList;
import java.util.Arrays;


public class StringsNArrays {
	
	//------------------------------------------------------------------------------------
	// Desc: Write a program to determine if the string contains all unique characters 
	//------------------------------------------------------------------------------------
	
	//SOLUTION 1: 
	public boolean isUnique1(String str){
		
		// loop through string and take one char at a time
		for (int i=0; i< str.length(); i++){
			// loop through rest of the characters in string
			for (int j=i+1; j< str.length(); j++){
				// compare the charAt(i) with all the remaining chars in string 
				if (str.charAt(i) == str.charAt(j)){
					return false;
				}
			}
		}
		
		return true;
	}
	
	//SOLUTION 2: Using additional data structure   
	public boolean isUnique2(String str){
		
		ArrayList<String> list = new ArrayList<String>();
		// loop through string and take one char at a time
		for (int i=0; i< str.length(); i++){
			
			String temp = String.valueOf(str.charAt(i));
			// check if the list already contains that character
			if (list.contains(temp)){   
				return false;
			}else{ 
				list.add(temp);
			}
		}
		return true;
	}
	
	
	//SOLUTION 3: Using sorting technique
	public boolean isUnique3(String str){
		
		// copy the str contents to char[] array
		char[] cArray= str.toCharArray();
		// sort the char[] array
		Arrays.sort(cArray);
		str= String.valueOf(cArray);
		
		// loop through string and take one char at a time
		for(int i=0; i< str.length()-1; i++){
			// compare the char with char at consecutive(i+1) position
			if (str.charAt(i) == str.charAt(i+1)){
				return false;
			}
		}
		return true;
	}
	
	
	//------------------------------------------------------------------------------------
	// Desc: Write a program to reverse a string
	//------------------------------------------------------------------------------------
	
	//SOLUTION 1: 
	public String reverse1(String str){
		
		// create char array of length str.length+1 (+1 to store \0 at the end)
		char[] temp= new char[str.length()+1]; 
		int j=0;
		
		// loop through string in opposite direction and take one char at a time
		for (int i= str.length()-1; i>=0; i--){
			//add char to temp array
			temp[j++]= str.charAt(i);
		}
		temp[j]='\0';	
		str= String.valueOf(temp);
		return str;
	}
	
	
	//SOLUTION 2:
	public String reverse2(String str){
		
		// copy the string t char array
		char[] cArray = str.toCharArray();
		char temp;
		// loop through string 
		for(int i=0, j=cArray.length-1;  i< cArray.length/2;  i++, j--){
			
			temp= cArray[j];
			cArray[j] = cArray[i];      // swap the characters
			cArray[i] = temp;
		}
		// copy the char array contents to string
		String revStr = String.valueOf(cArray);
		return revStr;
	}
	
	
	//-----------------------------------------------------------------------------------
	// Desc: Determine if the given string is permutation of another string
	//------------------------------------------------------------------------------------
	
	
	//SOLUTION 1:
	public boolean permutation1(String str1, String str2){
		
		int count=0;
		// condition 1: check if the length of 2 strings is equal
		if (str1.length() == str2.length()){
			// loop through string1 and take one char at a time
			for (int i=0; i<str1.length(); i++){
				// inner loop for string2
				for(int j=0; j<str2.length(); j++){
					// compare the charAt(i) with all the characters of string2 
					if (str1.charAt(i)==str2.charAt(j)){
						count++;
						break;
					}
				}
			}
			// repeat same by comparing char at a time of string2 with all the characters of string1 
			for (int i=0; i<str2.length(); i++){
				
				for(int j=0; j<str1.length(); j++){
					
					if (str2.charAt(i)==str1.charAt(j)){
						count--;
						break;
					}
				}
			}
			if (count==0){
				return true;
			}
		}	
		return false;
	}
	
	
	//SOLUTION 2:
	public boolean permutation2(String str1, String str2){
		
		if(str1.length()== str2.length()){
			ArrayList<String> list = new ArrayList<String>();
			
			// copy the contents of string2 to array list
			for (int i=0; i<str2.length(); i++){
				list.add(String.valueOf(str2.charAt(i)));
			}
			
			// loop through string1 and take one char at a time
			for(int i=0; i<str1.length(); i++){
				// check if the list contains the character
				if (!(list.contains(String.valueOf(str1.charAt(i))))){
					list.remove(String.valueOf(str1.charAt(i)));
				}
			}
			if(list.isEmpty()){
				return true;
			}
			else{
				return false;
			}
		}else{
			return false;
		}			
	}
		
	
	//-----------------------------------------------------------------------------------
	// Desc: Write a method to replace all the spaces in the string with %20		
	//------------------------------------------------------------------------------------
	
	// SOLUTION 1:
	public String replace1(String str, int maxLen){
		
		// copy string contents to char[] array
		char[] cArray = str.toCharArray();  	
		
		// loop through string
		for(int i=0, j=0; i<maxLen; i++){	
			
			// if find ' ' then add %20 in char[] in consecutive 3 locations
			if (str.charAt(i)== ' '){			
				cArray[j++]='%';
				cArray[j++]='2';
				cArray[j++]='0';
			}else{
				// else just add the str.charAt(i);
				cArray[j++]=str.charAt(i);
			}
		}
		str = String.valueOf(cArray);
		return str;
	}
	
	
	// SOLUTION 2: In place replacement
	public String replace2(String str, int maxLen){
		
		char[] cArray = str.toCharArray();
		
		// loop through string
		for(int i=0, j=maxLen-1; i<maxLen; i++){
			// if find ' ' then add %20 in char[] in consecutive 3 locations in opposite direction
			if(cArray[i]==' '){
				cArray[j--]='%';
				cArray[j--]='2';
				cArray[j--]='0';
			}
			else{
				cArray[j--]=cArray[i];
			}
		}
		str = String.valueOf(cArray);
		return str;
	}
	
	
	//------------------------------------------------------------------------------------
	// Desc: Implement a method to perform basic string compression
	//------------------------------------------------------------------------------------
	
	// SOLUTION 1:
	public String compression(String str){
		
		// take 1st char of string into variable
		char last= str.charAt(0);
		
		// create a new StringBuffer
		StringBuffer strBuffer= new StringBuffer();
		int count= 1;
		
		// loop through string
		for (int i=1; i<str.length(); i++){
			
			// check if repeated char is found at consecutive location
			if(str.charAt(i)==last){
				count++;
				
			}else{
				// else add the last char and count at consecutive locations 
				strBuffer.append(last);
				strBuffer.append(count);
				// update last to to hold charAt(i)th location
				last=str.charAt(i);
				count=1;
			}
		}
		// append the values of last and count to the strBuffer 
		strBuffer.append(last);
		strBuffer.append(count);
		
		if(strBuffer.length() > str.length()){
			return str;
		}else{
			// convert StringBuffer to string 
			str= strBuffer.toString();
			return str;
		}
		
	}
	
	
}
