package hello;

public class User {
    private long id;
    private String name1;

    public User(long id, String name1) {
        this.id = id;
        this.name1 = name1;
        
    }

    /*public User(long long1, String string) {
		// TODO Auto-generated constructor stub
	}*/
	
	@Override
    public String toString() {
    	
        return String.format(
                "%s",
                name1);
        
    }

    // getters & setters omitted for brevity
}
