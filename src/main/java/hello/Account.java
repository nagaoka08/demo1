package hello;

public class Account {
	private int id;
    private String username;

    public Account( int id,String username) {
		super();
		this.id = id;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}


}

