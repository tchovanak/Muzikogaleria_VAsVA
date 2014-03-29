package fiit.stuba.sk.chovanak.DB_ENTITS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "label")
	private String label;
	
	@Column (name = "release_year")
	private String releaseYear;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "album_artist", joinColumns = { @JoinColumn(name = "id") }, 
			   inverseJoinColumns = { @JoinColumn(name = "id")})
	private List<Artist> artists = new ArrayList<Artist>();

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

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	} 

	
	 	
}
