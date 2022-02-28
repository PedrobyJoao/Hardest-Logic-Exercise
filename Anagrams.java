import java.util.Scanner;
import java.util.Arrays;


public class Anagrams {
    
    // Function to sort strings
    public static String sortString(String inputString){
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();
 
        // Sorting temp array using
        Arrays.sort(tempArray);
 
        // Returning new sorted string
        return new String(tempArray);
    }

    public static void main(String args[]){

        // Asking and reading user's input
        Scanner input = new Scanner(System.in);
        System.out.println("string: ");
        String string = input.next();

        // Closing scanner
        input.close();
        // Start couting
        int count, i, j;
        count = i = j = 0;
        int string_length = string.length();
        boolean first_k = true;

        for (int k = 0; k < string_length / 2; k++){ // K:  will change the initial char
            for (i = 0; i < string_length; i++){ // i: It is the index for the initial char
                for (j = i + 1; j < string_length; j++){  // J: it will change the length of each substring analised

                    // Solving seg fault problem (passing the limits of char array)
                    if (i + k < string_length && j + k < string_length){
                        // Initial pair which will be compared with all the others
                        String first_group = sortString(string.substring(i + k, j + k + 1));
                        for (int l = 1; j + l + k < string_length; l++){
                            String other_group = sortString(string.substring(i + l + k, j + l + k + 1));
                            if (first_group.equals(other_group) == true){
                                count++;
                            }
                        }
                    }
                }

                // For cases of ONE CHAR substring (corner cases, i.e.: ['a'], ['b'])
                if (first_k == true){ // first_k is used to do this corner case just one time, otherwise the values of "i", "j" will repeat when changing the value of k
                    if (j == string_length){ 
                        j -= 1;
                    }
                    if (string.charAt(i) == string.charAt(j)){
                        count++;
                    } 
                }
            }
            first_k = false;
        }
        System.out.println(count);
    }    
}
