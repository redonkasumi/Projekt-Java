
public class Admin {
	private Key password;
	private String name;
	
	
	public Admin(Key k, String n)
	{
		password=k;
		name=n;
	}
	
	 public Key getKeyOfAdmin() { return password; }
	 
	 public String getName() { return name; }
	 
}
