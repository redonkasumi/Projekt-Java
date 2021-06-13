//PER MOMENTIN U KRY 
import javax.swing.*;
public class Key {
	private String letter_code;  // the letter code, e.g.,  "QA"
	  private double double_number_code;  // the number code, e.g.,  76.884
	  private int int_number_code;

	  /** Constructor Key constructs a catalog number
	    * @param letters - the letter code, e.g.,  "QA"
	    * @param num - the decimal number code, e.g.,  76.884 */
	  public Key(String letters, double double_number)
	  { 
	    letter_code = letters;
	    double_number_code = double_number;
	  }
	  
	  public Key(int int_number)
	  {
	    int_number_code=int_number;
	  }
	  
	  public Key(String letters)
	  {
	   letter_code=letters;
	  }

	  /** equals returns whether the catalog number held within this object
	    *  is identical to the catalog number held within  c
	    * @param c - the other catalog number
	    * @return true, if this catalog number equals  c; return false, otherwise */
	  public boolean equals(Key c)
	  { System.out.println("Stringu1 "+letter_code);
	    System.out.println("Double1 "+double_number_code);
	    System.out.println("Int1 "+int_number_code);
		String s = c.getLetterCode();
	    double d = c.getDoubleNumberCode();
	    int i=c.getIntNumberCode();
	    boolean k=false;
	    System.out.println("Stringu2: "+s);
	    System.out.println("Double2:" +d);
	    System.out.println("Int2 "+ i);
	    
	    if(s!=null && i==0 && d==0.0)
	    {
	    	k=s.equals(letter_code);
	    }
	    else
	    {
	    	if(s!=null && i==0 && d!=0.0)
	    	{
	    		k=(s.equals(letter_code)  &&  d == double_number_code);
	    	}
	    	
	    	else
	    	{
	    		if(s==null && i!=0 && d==0.0)
	    		{
	    			k= i==int_number_code;
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Error: Not a valid comparison(You may have written 0, 0.0 or null)");
	    		}
	    	}
	    	
	    }
	    	
	    
	    return k;
	 
}

	  /** getLetterCode returns the letter code part of this catalog number
	    * @return the letter code, e.g.,  "QA"  */
	  public String getLetterCode() { return letter_code; }
	  
	  /** getNumberCode returns the number code part of this catalog number
	    * @return the number code, e.g.,  "76.884"  */
	  public double getDoubleNumberCode() { return double_number_code; }
	   
	  public int getIntNumberCode() { return int_number_code; }
}
