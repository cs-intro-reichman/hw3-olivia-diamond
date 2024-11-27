/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		System.out.println(randomAnagram("silent"));
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1= preProcess(str1).replace(" ","");
		str2 = preProcess(str2).replace(" ","");
		// remove spaces

		if (str1.length() != str2.length()){
			return false;
		}

		for(int i = 0; i<str1.length(); i++){
			for (int j = 0; j<str1.length(); j++){
				if (str1.charAt(i)==str2.charAt(j)) {
					str2 = str2.substring(0, j) + str2.substring(j + 1);// we check for every letter that occurs in both and if it does, we remove it and check the next varaible. After removiong all variables and going through i, ity must be equal to be anagram.
					break;
				}
				else if (j == (str2.length()-1)) { // length = 5 , so last position = 4
					return false; // if we gone thorugh all str 2, and no matches and no removes, then false.
				}

			}
		}


		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.toLowerCase();
		for (int i = 0; i<str.length(); i++){
			if( "abcdefghijklmnopqrstuvwxyz ".indexOf(str.charAt(i))==-1){
				str = str.substring(0, i) + str.substring(i + 1);
				i--;
			}
		}
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str= preProcess(str).replace(" ","");
		String anagram = "";
		while (str.length()>0){
			int index = (int)((Math.random())*(str.length()));
			anagram = anagram + str.charAt(index);
			str = str.substring(0, index) + str.substring(index + 1);
				}
		return anagram;
			}	
		}



