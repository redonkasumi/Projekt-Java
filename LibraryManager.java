
public class LibraryManager {
	public static void main(String [] args)
	{   Key password=new Key("rea");
	    Admin admin=new Admin(password, "rea");
		LibraryReader reader=new LibraryReader();
		StudentDatabase students=new StudentDatabase(500);
	
		BookDatabase library=new BookDatabase(500);
		//BookDatabase studentdatabase=new BookDatabase(6);
		LibraryWriter writer=new LibraryWriter("Student tabel", students, library);
		
		LibraryController controller=new LibraryController(reader, library, students, writer,admin);
		controller.processLibrary();
		
	}

}
