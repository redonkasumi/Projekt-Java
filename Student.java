
public class Student {
	private Key id_number;
	private String name;
	private String address;
	private String college;
	private int row;
	private BookDatabase books;
	
	
	public Student(Key k, String n, String a,String c, BookDatabase b)
	{
		id_number=k;
		name=n;
		address=a;
		books=b;
		college=c;
	}
	
	 public Key getKeyOfStudent() { return id_number; }
	 
	 public String getName() { return name; }
	 
	 public String getAddress() { return address; }
	 
	 public String getCollege() { return college; }
	 
	 public BookDatabase getBooks()  { return books;}
	 
	 public boolean takeBook(Book book)
	 {
		 boolean answer = books.insertBook(book);
		 System.out.println("The method answer: "+answer);
		 return answer;
	 }
	 public boolean returnBook(Key k)
	 {
		 boolean answer=books.deleteBook(k);
		 System.out.println("The method answer: "+answer);
		 return answer;
	 }
	 public Book findBook(Key k) {
		
		 return  books.findBook(k);
	 }
	 public void increaseNumOfRows() {
		 row=row+1;
	 }
     public int numOfRows() {
    	
    	return row;
     }
}
