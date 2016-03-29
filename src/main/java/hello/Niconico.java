package hello;

public class Niconico {
	private long id,day;
    private String niconico;

    public Niconico(long id,long day, String niconico) {
        this.id = id;
        this.id = day;
        this.niconico = niconico;
        
    }

    /*public User(long long1, String string) {
		// TODO Auto-generated constructor stub
	}*/
	
	@Override
    public String toString() {
    	
        return String.format(
                "%s","%s","%s",
                id,day,niconico);
        
    }

    // getters & setters omitted for brevity

}
