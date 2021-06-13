import javax.swing.*;
public class LibraryReader {
	private String input_line;
 public String readText(String message)
 {    
	 input_line=JOptionPane.showInputDialog(message);
	 if (input_line==null) 
	 {System.exit(0);}

		
	 return  input_line.trim();
  }
 public void readMessage(String message) {
	 JOptionPane.showMessageDialog(null, message);
	 
 }
 public String readLetterBookKey(String input)
 {
	 return input.charAt(0)+"";
 }
 
 public double readNoBookKey(String input) {
	 double answer = 0.0;
	// extract substring of input line that forgets the initial character:
	String s = input.substring(1, input.length());
	s = s.trim(); // trim leading blanks from substring
	if ( s.length() > 0 ) // is there a number to return?
	{ answer = new Double(s).doubleValue();
	
	}
	else { JOptionPane.showMessageDialog(null,
	"BankReader error: no number for transaction---zero used");
	}
	return answer;
 }
 public boolean checkInput(String input) {
   boolean not_ok=false;
		if(input_line.equals(""))
		{JOptionPane.showMessageDialog(null, "Input is required");
		not_ok=true;}
   return not_ok;
 }
}
