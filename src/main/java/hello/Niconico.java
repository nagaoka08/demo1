package hello;

public class Niconico {
	private long id;
	//private long id,day;
    private String niconico1;

    public Niconico(long id,long day, String niconico1) {
      this.id = id;
        //this.id = day;
        this.niconico1 = niconico1;
        
    }

    /*public User(long long1, String string) {
		// TODO Auto-generated constructor stub
	}*/
	
	@Override
    public String toString() {
    	
        return String.format(
                "%s",
                niconico1);
        
    }

    // getters & setters omitted for brevity

}
