package com.Jeshna;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JeshnaKanduri
 * @date 11/06/2024 
 * A program that reverses the order of the string and the letters in the word using STACKS
 */
public class StringReverser {
	/**
	 * Main method
	 * @param args Command line arguments
	 * @throws Exception Cannot look at front of empty list
	 */
	public static void main(String[] args) throws Exception {

		//TO REVERSE ORDER OF WORDS AND LETTERS IN THE WORDS ---> OUTPUT: emocleW dna ,olleH
		
		// Getting String input from user
		Scanner input = new Scanner(System.in);
		String userString = input.nextLine(); //ex. Hello, and Welcome

		// Spiltting and placing each word and additional characters into an array 
		String[] eachWord = userString.split(" "); // [Hello,, and, Welcome]

		// Creating new stack to reverse the order of words and letters ---> OUTPUT: emocleW dna ,olleH
		StringStack ReverseLettersWords= new StringStack(); // a new empty list is created

		// Looping through eachWord to access each word
		for (int i = 0; i < eachWord.length; i++) { 
			// Getting length of each word one at a time
			for (int j = 0; j < eachWord[i].length(); j++) { 
				// kind of like array of arrays
				// now this new for (j) accesses each word and uses its length to convert each word into a character
				
				// Using length of each word, converts each letter into a character 
				char eachL = eachWord[i].charAt(j);
				
				// ex. lets access eachWord[0] - "Hello"
				// the length of it is 6 which the for(j) finds
				// now this length is used to loop from 0 - 5 which to access and turn each
				// letter of the word into its own character
				// ex. Hello, - H e l l o 
				// then each character(converted to string) is added (aka pushed) onto the stack

				//Converting each character back to string and pushing it onto stack ---> olleH
				// o - last added, H - first added
				ReverseLettersWords.push(Character.toString(eachL));
				
			}
			
			// Adding space between the reversed letter words (in j loop)
			if(i != eachWord.length - 1) { 
				ReverseLettersWords.push(" "); //----> from chatgpt
			}
			// Adding no space between letters in word (in i loop)
			else {
				ReverseLettersWords.push("");
			}

			// the j for loop functions on the i for loop bc i have to access the actual
			// word to access it length and letters
			// thus we start with acessing the [i] the word, and then the [j] the letters
			// and then we go back out to [i] for the next word
			// but because we want to add a space between each word we use letter.push(" ")
			// ex. i for loop to get a word eachW[0] = Hello,
			// entering the j for loop for each letter
			// eachW[0].charAt[0] = H
			// eachW[0].charAt[1] = e
			// eachW[0].charAt[2] = l
			// eachW[0].charAt[3] = l
			// eachW[0].charAt[4] = o
			// eachW[0].charAt[5] = ,
			// letters.push(Character.toString(eachL)) = [,olleH}
			// now we're out of the j for loop to get next word BUT BEFORE THAT WE WANT A SPACE
			// so letters.push(" ") = [,olleH }
			// restart the process
		}
		
		// Removes and displays reverse letterd word starting from the front for as long as stack is not empty
		while (!ReverseLettersWords.isEmpty()) {
			System.out.print(ReverseLettersWords.pop());
		}

		System.out.println(); //places outputs on different lines

//--------------------- TO REVERSE ORDER OF WORD ONLY ---> OUTPUT: Welcome and Hello, ------------------------------
		
		//Creating new stack to reverse the words only 
		StringStack ReverseWordOrder = new StringStack(); 

		//Using the same split array of user string input, pushing each word onto stack
		for (int i = 0; i < eachWord.length; i++) {
			ReverseWordOrder.push(eachWord[i]);
		} 
		
		//Removing and displaying words starting from the front for as long as stack is not empty
		while (!ReverseWordOrder.isEmpty()) {
			System.out.print(ReverseWordOrder.pop() + " ");
		}
	}
}

