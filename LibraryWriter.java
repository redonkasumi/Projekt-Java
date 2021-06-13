import javax.swing.*;
import java.awt.*;
public class LibraryWriter extends JPanel
{ 
	private int WIDTH = 500;
    private int DEPTH = 500;
  
    private StudentDatabase students;
    private Student student;
    private BookDatabase library;

    private Book book;
	private int row,col;
	private String[][] student_table; 
	private String[][] book_table;
	private String[][] studentbooks_table;
	//private String [][] header_table;
	private int answer;
    
    public LibraryWriter( String title, StudentDatabase s, BookDatabase l) 
    {   students=s;
        library=l;
   
        JFrame my_frame = new JFrame();
    	my_frame.getContentPane().add(this);
    	my_frame.setTitle(title);
    	my_frame.setSize(WIDTH, DEPTH);
    	my_frame.setVisible(true);
     }
    
    public void paintComponent(Graphics g) {
    	g.setColor(Color.gray);
    	g.fillRect(0, 0, WIDTH, DEPTH); // paint the background
    	g.setColor(Color.black);
    	
    for(int i=0; i!=row; i++)
    	{
    		for(int j=0; j!=col; j++)
    		{
    			//System.out.println("INSIDE THE PAINTCOMPONENT LOOP"+"i="+i+"j="+j);
    			//System.out.println(student_table[i][j]);
    			switch (answer)
    			{
    			case 1: {
    				//paintTabel(g, header_table[0][j], 0,j,80 );
    				paintTabel(g,student_table[i][j],i,j,80);
    			         break;}
    			case 2: {paintTabel(g,book_table[i][j],i,j,80); 
    			         break;}
    			case 3: {paintTabel(g,studentbooks_table[i][j],i,j,80);
    			         break;}
    			}
    			//paintTabel(g,student_table[i][j],i,j,80);
    			//paintTabel(g,book_table[i][j],i,j,80);
    			
    		}
    	}

    }
    
    public void paintTabel(Graphics g, String t, int i,int j, int piece_size)
    {
    	int initial_offset = piece_size;
    	int x_pos = initial_offset + (piece_size * j);
    	int y_pos = initial_offset + ((piece_size-30) * i);
    	if ( t != null )
    	{ g.setColor(Color.white);
    	g.fillRect(x_pos, y_pos, piece_size, piece_size-30);
    	g.setColor(Color.black);
    	g.drawRect(x_pos, y_pos, piece_size, piece_size-30);
    	g.drawString(t, x_pos + 10, y_pos + 20);
    	}
    	else { 
    	g.setColor(Color.black);
    	g.fillRect(x_pos, y_pos, piece_size, piece_size-30);
    	}
    }
    
    public void drawStudents(int r)
    {   answer=1;
    	Student base[]=students.viewStudents();
        row=r;
        System.out.println("ROW"+r);
        col=4;
        student_table=new String[row][col];
        /*student_table[0][0]="Name";
        student_table[0][1]="Adress";
        student_table[0][2]="College";
        student_table[0][3]="ID";*/
    	for(int i=0; i<row; i++)
    	{   System.out.println("We are inside the loop");
    	     if(base[i]==null)
    	     {
    	    	 for(int j=0; j!=col; j++)
    	    	 {
    	    		 student_table[i][j]=null;
    	    	 }
    	    	 
    	     }
    	     else{
    		student_table[i][0]=base[i].getName();
    		System.out.println("Emri"+student_table[i][0]);
    		//System.out.println("Row"+row);
    		student_table[i][1]=base[i].getAddress();
    		student_table[i][2]=base[i].getCollege();
    		student_table[i][3]=base[i].getKeyOfStudent().getIntNumberCode()+"";
    		//System.out.println("id"+student_table[i][3]);
    		//System.out.println("U kry");
    		//System.out.println("i"+i);
    		}
    	     System.out.println("i "+i);
    	}
    	//System.out.println("JAsht lloopes");
    this.repaint();	
    
    }
    
  public void drawBooks(int r) {
	  answer=2;
	  //System.out.println("Brenda metodes");
	  Book base[]=library.viewBooks();
	  //System.out.println("e kaloj pragun");
      row=r;
      System.out.println("Row"+row);
      col=4;
      book_table=new String[row][col];
     /* book_table[0][0]="Title";
      book_table[0][1]="Author";
      book_table[0][2]="Amount";
      book_table[0][3]="Catalog no.";*/
      
  	for(int i=0; i<row; i++)
  	{   //System.out.println("We are inside the loop");
  		
  	    if(base[i]==null)
  	    {    for(int j=0; j<col; j++)
  	    {book_table[i][j]=null;}
  	    }
  	    else {
  		book_table[i][0]=base[i].getTitle();
  		//System.out.println("Emri"+book_table[i][0]);
  		//System.out.println("Row"+row);
  		book_table[i][1]=base[i].getAuthor();
  		//System.out.println("Autor"+book_table[i][1]);
  		book_table[i][2]=base[i].getAmount()+"";
  		//System.out.println("Amount"+book_table[i][2]);
  		//System.out.println("Key"+base[i].getKey().getIntNumberCode()+"");
  		book_table[i][3]=base[i].getKey().getIntNumberCode()+"";
  		//System.out.println("id"+book_table[i][3]);
  		//System.out.println("U kry");
  		//System.out.println("i"+i);
  	    }
  	}
  	//System.out.println("JAsht lloopes");
  	
  this.repaint();	
  }
  public void drawStudentsBooks(int r, Student the_student) {
	  answer=3;
	  System.out.println("Brenda metodes");
	  Book base[]=the_student.getBooks().viewBooks();
	  System.out.println("e kaloj pragun");
	  //System.out.println("Book name inside method draw "+base[0].getTitle());
      row=r;
      col=3;
      studentbooks_table=new String[row][col];
      /*studentbooks_table[0][0]="Title";
      studentbooks_table[0][1]="Author";
      studentbooks_table[0][2]="Catalog no.";*/
      
  	for(int i=0; i<row; i++)
  		
  	{   //System.out.println("We are inside the loop");
  	    //System.out.println("Book name inside method draw i"+base[i].getTitle());
  	      if(base[i]==null)
  	      {
  	    	  for(int j=0; j!=col; j++)
  	    	  {
  	    	studentbooks_table[i][j]=null;
  	    	  }
  	      }
  	      else {
  		studentbooks_table[i][0]=base[i].getTitle();
  		//System.out.println("Emri"+studentbooks_table[i][0]);
  		//System.out.println("Row"+row);
  		studentbooks_table[i][1]=base[i].getAuthor();
  		//System.out.println("Autor"+studentbooks_table[i][1]);
  		
  		//System.out.println("Key"+base[i].getKey().getIntNumberCode()+"");
  		studentbooks_table[i][2]=base[i].getKey().getIntNumberCode()+"";
  		//System.out.println("id"+studentbooks_table[i][3]);
  		//System.out.println("U kry");
  		//System.out.println("i"+i);
  	       }
  	    }
  	//System.out.println("JAsht lloopes");
  	
  this.repaint();	
  }
  
 /* public void drawHeader( String s1, String s2, String s3, String s4) 
  {   header_table=new  String[1][4];
	  header_table[0][0]=s1;
      header_table[0][1]=s2;
      header_table[0][2]=s3;
      header_table[0][3]=s4;
      
      this.repaint();
  }*/
}
