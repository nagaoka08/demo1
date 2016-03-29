package hello;

public class Niconico {
	private long id,day;
	//private long id,day;
    private String niconico1,name2;

    public Niconico(long id,long day,String niconico1,String name2) {
      this.id = id;
      this.day = day;
        this.name2 = name2;
        this.niconico1 = niconico1;
        
    }

    /*public User(long long1, String string) {
		// TODO Auto-generated constructor stub
	}*/
	
	@Override
    public String toString() {
    	
        return String.format(
                "%s user=%s %s日",
                name2,niconico1,day);
        
    }

    // getters & setters omitted for brevity

}
