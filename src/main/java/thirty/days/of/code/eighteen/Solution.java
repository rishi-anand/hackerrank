package thirty.days.of.code.eighteen;

import java.io.*;
import java.util.*;

public class Solution {

    private Queue<Character> characterQueue;

    private Stack<Character> characterStack;

    private char[] queue = new char[5];


    private void pushCharacter(char ch){
        if(characterStack == null){
            characterStack = new Stack<Character>();
        }
        characterStack.push(ch);
    }

    private void enqueueCharacter(char ch){
        if(characterQueue == null){
            characterQueue = new LinkedList<Character>();
        }
        characterQueue.add(ch);
    }

    private char popCharacter(){
        return characterStack.pop();
    }

    private char dequeueCharacter(){
        return characterQueue.poll();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {

                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}
