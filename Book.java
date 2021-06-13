public class Book {
	// the names of the fields describe their contents:
		  private Key catalog_number;
		  private String title;
		  private String author;
		  private int amount;
		  //private String publication_date;

		  /** Constructor Record constructs the book.
		    * @param num - the book's catalog number
		    * @param a - the book's author
		    * @param t - the book's title   */
		  public Book(Key num, String t, String a, int z)
		  { catalog_number = num;
		    title = t;
		    author = a;
		    amount = z;
		    //publication_date = date;
		  }

		  /** getkey  returns the key that identifies the record
		    * @return the key  */
		  public Key getKey() { return catalog_number; }

		  /** getTitle returns the book's title 
		    * @return the title */
		  public String getTitle() { return title; }

		  /** getAuthor returns the book's author 
		    * @return the author */
		  public String getAuthor() { return author; }

		  /** getDate returns the book's publication date
		    * @return the date */
		 /* public int getDate() { return publication_date; }*/
		  public int getAmount() {
			  
			  
			  return amount;}
		  public int decreaseAmount() {
			 
			  if(amount> 0)
			  {
			  amount=amount-1;
			  }
			  else {amount=-1;} 
			  return amount;
		  }
	  public int increaseAmount() {
			  
			  amount=amount+1;
			  return amount;
		  }


}
