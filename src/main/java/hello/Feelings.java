package hello;

public class Feelings {
	private int id,year,month,day,niconico;


    public Feelings( int id,int year,int month,int day, int niconico) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.niconico = niconico;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getNiconico() {
		return niconico;
	}
	public void setNiconico(int niconico) {
		this.niconico = niconico;
	}




}
