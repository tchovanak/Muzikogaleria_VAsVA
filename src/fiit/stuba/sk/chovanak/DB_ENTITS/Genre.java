package fiit.stuba.sk.chovanak.DB_ENTITS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@Column(name = "id")
	@OneToMany(mappedBy = "genre")
	private int id; 
	
	@Column(name = "label")
	private String label;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
