import java.io.Serializable;

public class TestClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3903685094607563439L;


	public TestClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestClass(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	private int id;
	private String name;
	private String city;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}
