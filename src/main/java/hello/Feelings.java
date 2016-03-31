package hello;

public class Feelings {
	private int id,day;
    private String niconico;
    
    public Feelings( int id,String niconico) {
		super();
		this.id = id;
		this.niconico = niconico;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getNiconico() {
		return niconico;
	}
	public void setNiconico(String niconico) {
		this.niconico = niconico;
	}
    
    
}
