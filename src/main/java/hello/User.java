package hello;

public class User {
    private int id;
    private String user;

    public User(int id, String user) {
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

    public User(long long1, String string) {
		// TODO Auto-generated constructor stub
	}
	
	/*@Override
    public String toString() {
    	
        return String.format(
                "%s",
                name1);
        
    }*/

    // getters & setters omitted for brevity
}
