
public class LibraryController {
	
	private Admin admin;
	private LibraryReader reader;
	private BookDatabase library;
	private StudentDatabase students;
	private LibraryWriter writer;
	private int count_students;
	private int count_books;
	private Student found_student;
	
	
public LibraryController(LibraryReader r, BookDatabase l,StudentDatabase s, LibraryWriter w, Admin a) 
{   admin=a;
	reader=r;
	library=l;
	students=s;
	writer=w;
}

public void processLibrary()
{   
	String input1=reader.readText("Log in \n 1. Admin  Account \n 2. Student Account");
	theOkButton(input1);
	
	if(input1.equals("1"))
	{   
		String admin_username=reader.readText("Username: ");
		theOkButton(admin_username);
	    //System.out.println("Username"+username.equals(admin.getName()));
	    //System.out.println("Password"+admin.getKeyOfAdmin().getLetterCode());
	    String admin_password=reader.readText("Password: ");
	    theOkButton(admin_password);
	    if(admin_username.equals(admin.getName()) && admin_password.equals(admin.getKeyOfAdmin().getLetterCode()))
	    {
		this.processAdmin();
		}
	    else
	    {
	    	reader.readMessage("Error: the password or username you entered is incorrect");
	    }
	 }
	else
	{
		if(input1.equals("2"))
		{ 
			//System.out.println("WE ARE INSIDE STUDENT ACCOUNT");  
		    String student_username=reader.readText("Username: ");
		    theOkButton(student_username);
	        String student_id=reader.readText("ID: ");
	        theOkButton(student_id);
	        int student_id_no=new Integer(student_id).intValue();
	        Key student_id_string=new Key(student_id_no);
	        found_student=students.findStudent(student_id_string);
	        //System.out.println("Emri i studentit"+found_student.getName());
	        System.out.println("The student is found"+ found_student!=null);
	        if(found_student!=null && found_student.getName().equals(student_username))
	    {    
	    	this.processStudent();
	    }
	    else
	    {
	    	reader.readMessage("Error: the password or username you entered is incorrect");
	    }
	
		}
		else
		{
			reader.readMessage("Error: you've entered the wrong command");
		}
	}

  	this.processLibrary();


}

private void processAdmin() {
	
	String input2=reader.readText(" Admin: \n What do you want to do? Choose a number: \n 1. Add a new student \n 2. Delete a student \n 3. View students"
			+ "\n 4. Add a new book \n 5. Delete Book \n 6. View Books \n 7. Back");
	theAdminOkButton(input2);
	int no_input2=new Integer(input2).intValue();
	
	switch (no_input2)
	{
	case 1: {
		        String name=reader.readText("Name: ");
		        theAdminOkButton(name);
		        String id=reader.readText("Id: ");
		        theAdminOkButton(id);
		        int id_no=new Integer(id).intValue();
		        String address=reader.readText("Address: ");
		        theAdminOkButton(address);
		        String college=reader.readText("College: ");
		        theAdminOkButton(college);
                Key objID= new Key(id_no);
                BookDatabase studentbooks=new BookDatabase(6);
		        Student student=new Student(objID, name, address, college,  studentbooks);
		     
		        
		        boolean inserted=students.insertStudent(student);//studentet e ri 
		        if(inserted==true) 
		        {
		           System.out.println("The student is inserted"+inserted+" successfully");
		           count_students++;
		        }
		        else
		        {
		        	reader.readMessage("The student is not inserted, \n The id number you entered already exists");
		        }
		        
		        //System.out.println("CASE 1 students count"+ count_students);
		        
		        break;
	         }
	
	case 2:  {
		        String id_to_delete=reader.readText("Id: ");
		        theAdminOkButton(id_to_delete);
		        int id_no_to_delete=new Integer(id_to_delete).intValue();
		        Key objIDtoDelete=new Key(id_no_to_delete);
		        boolean deleted=students.deleteStudent(objIDtoDelete);
		      
		        if(deleted==true)
		        {
		        	System.out.println("The student is deleted"+deleted+"successfully");
		        }
		        else
		        {
		        	reader.readMessage("The student is not deleted, \nThe id number you entered doesn't exists");
		        }
		        
		        //System.out.println("CASE 2 students count"+count_students);
		        break;
	         }
	case 3: {
		        writer.drawStudents(count_students);
		       //writer.drawHeader( "Name", "Address", "College", "ID"); 
		        break;
		
	        }
	case 4: {
		        String book_name=reader.readText("Book name: ");
		        theAdminOkButton(book_name);
		        String author=reader.readText("Author: ");
		        theAdminOkButton(author);
	            String book_id=reader.readText("Catalog No. : ");
	            theAdminOkButton(book_id);
	            //Key obj_bookID= new Key(reader.readLetterBookKey(book_id),reader.readNoBookKey(book_id));
	            int book_no_id=new Integer(book_id);
	            Key obj_bookID= new Key(book_no_id);
	          
	            String amount=reader.readText("Amount: ");
	            theAdminOkButton(amount);
	            int amount_no=new Integer(amount).intValue();
	            
	          
	            Book book=new Book(obj_bookID, book_name, author,amount_no);
	           
	            boolean book_inserted= library.insertBook(book);
	            if(book_inserted==true)
	            {
	            System.out.println("The book is inserted "+book_inserted);
	            count_books++;
	            }
	            else
	            {
	             reader.readMessage("Error: \nThe book is not inserted");
	            }
	          
	            //System.out.println("Case 4:"+count_books);
	            break;
	        }
	case 5: {
		        String bookID_to_delete=reader.readText("Catalog No. : ");
		        theAdminOkButton(bookID_to_delete);
		        int bookID_to_delete_no=new Integer(bookID_to_delete).intValue();
                Key obj_bookID_to_Delete=new Key(bookID_to_delete_no);
                boolean deleted_book=library.deleteBook(obj_bookID_to_Delete);
                if(deleted_book==true)
                {
                System.out.println("The book is deleted "+deleted_book);
                }
                else
                {
                	reader.readMessage("Error: \nThe catalog number you entered does not exist");
                }
                //System.out.println("Case 5"+ count_books);
                break; 
	        }
	case 6: {
		
		      writer.drawBooks(count_books);
		      break;
	        }
	case 7: {
		       this.processLibrary();
		       break;
	        }
	}
	this.processAdmin();
}
private void processStudent() {
	String input3=reader.readText(" Student: \n What do you want to do? Choose a number: \n 1. View books \n 2. Take a book "
			+ "\n 3. View the books you haven't returned yet  \n 4. Return a book  \n 5. Back");
	theStudentOkButton(input3); 
	int no_input3=new Integer(input3).intValue();
	switch(no_input3)
	{
	case 1: {
		       writer.drawBooks(count_books);
		       break;
	        }
	case 2: {
		       String book_id2=reader.readText("Catalog No. : ");
		       theStudentOkButton(book_id2); 
               int book_no_id2=new Integer(book_id2);
               Key obj_bookID2= new Key(book_no_id2);
               Book found=library.findBook(obj_bookID2);
               //System.out.println("The before amount"+found.getAmount());
                if(found!= null)
                {
                	boolean inserted2=found_student.takeBook(found);
                	//System.out.println("The after amount"+found.decreaseAmount());
                	//System.out.println("The book is inserted to the student account "+ inserted2);
                	//Book base[]=found_student.getBooks().viewBooks();
                	//System.out.println("The name of the book that the student choose"+base[0].getTitle());
                	if(inserted2==true)
                	{
                		System.out.println("The book is inserted "+ inserted2);
                		found_student.increaseNumOfRows();
                		int k=found.decreaseAmount();
                		boolean l=k ==-1;
                		
                		if(  l   )
                		{    System.out.println("INSIDEEE");
                    	     library.deleteBook(found.getKey());
                    	     reader.readMessage("We don't have anymore books of this kind");
                		}
                		//found.decreaseAmount();
                	}
                	else
                	{
                		reader.readMessage("Error: \n The book was not inserted into the student account");
                	}
                	
                	//System.out.println("THE NUMBER OF ROWS "+found_student.numOfRows());
                	
                }
                break;
	        }
	case 3: {
		     //System.out.println("Name of the student inside case 3: "+found_student.getName());
	         writer.drawStudentsBooks(found_student.numOfRows(), found_student) ;
	         break;
	        
	        }
	case 4: {
		       String book_id3=reader.readText("Catalog No. : ");
		       theStudentOkButton(book_id3); 
               //Key obj_bookID= new Key(reader.readLetterBookKey(book_id),reader.readNoBookKey(book_id));
               int book_no_id3=new Integer(book_id3);
               Key obj_bookID3= new Key(book_no_id3);
               Book found2= found_student.findBook(obj_bookID3);
               System.out.println("Before SBamout"+found2.getAmount());
               if(found2!=null)
               {
            	   boolean deleted=found_student.returnBook(obj_bookID3);
            	   if(deleted==true)
            	   {  
            		  System.out.println("The book is deleted");
            	     found2.increaseAmount();
            	   //System.out.println("The amount is increased"+increas);
            	   //System.out.println("The book in studentaccount is deleted"+deleted);
            	   }
            	   else
            	   {
            		   reader.readMessage("Error");
            	   }
            	   
                }
               break;
	        }
	case 5: {
		       processLibrary();
		       break;
	        }
	
	}
	this.processStudent();
} 

private void theOkButton(String input) {
	   boolean no_command= reader.checkInput(input);
	   if(no_command==true)
	   {this.processLibrary();}
}
private void theAdminOkButton(String input) {
	   boolean no_command= reader.checkInput(input);
	   if(no_command==true)
	   {this.processAdmin();}
}
private void theStudentOkButton(String input) {
	   boolean no_command= reader.checkInput(input);
	   if(no_command==true)
	   {this.processStudent();}
}
}




