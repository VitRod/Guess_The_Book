import java.util.Scanner;
import java.util.regex.Pattern;


public class GuessingABook {

	private int numGuess = 0;
	private int numLoops = 0;
	private  Boolean alreadyGuessedThatLetter = false;
	
	
	public  void  Start(String selectedBook) {
		String hidden = new String(new char[selectedBook.length()]).replace('\0', '_');
		String lettersGuessed = "";
		String fixedBook = selectedBook;
		
		// �������� ��������� �����
		System.out.println("Can you guess a book?");
		
		
		
		// ��������� �������� �����, ����� ������� ���������, ������� � �.� ...
		char[] unwantedCharacters =  {':', ' '};
		fixedBook =  fixedBook.replace(":", "_");
		fixedBook =  fixedBook.replace(" ", "_");
		fixedBook =  fixedBook.replace(", ", "_");
		
		
		Scanner scanner = new  Scanner(System.in);
		
		// ���� ������� �������������� ���� ���������� �����
		for(int  i = 30; i > 0; i--) {
			System.out.println("You have " + i + " guess(es) left. Choose again: ");
            System.out.println("Type a letter into the box. The console will only count the first letter you type.");
            System.out.println("So far you have guessed " + lettersGuessed);
            System.out.println("You have made a total of " + numGuess + " guesses.");
            System.out.println("Current word " + hidden);
            
//            System.out.println(selectedBook);
//            System.out.println("Fixed Book " + fixedBook);
            
            String findALetter = scanner.nextLine();
            char currentGuess = findALetter.charAt(0);
            
            	
            if(Pattern.matches("[a-zA-Z]+", findALetter)) {
            	// ���� �� ������� �����
            	// ����� ��������� ��  �������� �� ���  ��� �� �����
            	
            	for(int x = 1; x <=numLoops; x++) {
            		if(currentGuess == lettersGuessed.charAt(x - 1)) {
            			System.out.println("You have already found the  correct letter " + currentGuess);
            			i++;
            			numGuess++;
            			alreadyGuessedThatLetter = true;
            			break;
            		}else {
            			alreadyGuessedThatLetter = false;
            		}
            	}
            	
            // ����  ��� �� �� ����� ������� ��� ���� �������
            //	��������� ������, ����� �������, ��� ��� ���������, � ��������� ����� � �����
            	if(!alreadyGuessedThatLetter) {
            		
            		
            		for(int r = 0; r <=selectedBook.length() - 1; r++) {
            			char current  = selectedBook.charAt(r);
            			
            			
            			//�������������� ����� � ������ �������
            			currentGuess = Character.toLowerCase(currentGuess);
            			if(current == currentGuess) {
            				System.out.println(" You have  guessed a  correct letter");
            				char[] charHidden = hidden.toCharArray();
            				charHidden[r] = current;
            				hidden = String.valueOf(charHidden);
            				
            			}
            			
            			// �������������� ����� � ������� �������
            			currentGuess = Character.toUpperCase(currentGuess);
                    			if(current == currentGuess) {
                    				System.out.println(" You have  guessed a  correct letter");
                    				char[] charHidden = hidden.toCharArray();
                    				charHidden[r] = current;
                    				hidden = String.valueOf(charHidden);
            		}
                    			
                    			
            	}
            	 
            	lettersGuessed =  lettersGuessed + currentGuess + ", ";
            	numGuess++;
            	numLoops++;
            
            }
             
           if(fixedBook.equals(hidden)) {
        	   System.out.println("YOU WIN!!!");
        	   System.out.println("The book was " + selectedBook);
        	   break;
           }
           } else {
        	   System.out.println("Would you  be  so kind  to enter an alphabetical character. ");
        	   i++;
           }
		}
		
		if(!fixedBook.equals(hidden)) {
			System.out.println("You lose .... :(");
		}
		
	}
}
