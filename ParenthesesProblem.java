// Jeronimo Martinez Barragan
// CSC 300
// Assignment 4
// Stack and Map implementation to check if user input of parenthesis is properly balanced
// Implemented information and API's about Map in java 
// Source: https://www.geeksforgeeks.org/map-interface-java-examples/#

import java.util.*;
public class ParenthesesProblem {
    public static void main(String[]args){
        
        Scanner stdIn = new Scanner(System.in);
        Stack<Character>stack = new Stack<>();
        // Map of matching parentheses  to compare
        Map<Character, Character>matchingPairs = Map.of(')', '(', ']', '[', '}', '{');
        String userInput;

        // User input
        System.out.println("Enter set of parentheses: ");
        userInput = stdIn.nextLine();
        
        // Iterate through each char of user input
        for (int i = 0; i < userInput.length(); i++) {

            // Check if it's an opening parenthesis
            if (matchingPairs.containsValue(userInput.charAt(i))) {
                stack.push(userInput.charAt(i));
            // Check if it's a closing parenthesis
            } else if (matchingPairs.containsKey(userInput.charAt(i))) {
                // Check if last element in the stack coincides with the current parenthesis
                if (stack.isEmpty() || matchingPairs.get(userInput.charAt(i)) != stack.pop()) {
                    break;
                }
            } else {
                // Input validation
                System.out.println("Invalid syntax!");
                return;
            }
        }
        // If stack is empty, means they are properly balanced
        if (stack.isEmpty()) {
            System.out.println("Parentheses are properly balanced!");
        } else{
            System.out.println("Parentheses are NOT balanced");
        } 
    }
}
