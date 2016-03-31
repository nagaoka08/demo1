package hello;

public class Account {
	private int id;
    private String user;
    
    public Account( int id,String user) {
		super();
		this.id = id;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
    
    
}

