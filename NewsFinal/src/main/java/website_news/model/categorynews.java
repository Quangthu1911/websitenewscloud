package website_news.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="categorynews")
public class categorynews {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcategory;
	private String name;
	public int getIdcategory() {
		return idcategory;
	}
	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public categorynews(int idcategory, String name) {
		super();
		this.idcategory = idcategory;
		this.name = name;
	}
	public categorynews()
	{
		
	}
}
