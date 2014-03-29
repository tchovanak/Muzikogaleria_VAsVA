package fiit.stuba.sk.chovanak.DB_ENTITS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "song")
public class Song {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "filesystem_path")
	private String filesystem_path;
	
	@Column(name = "num_of_plays")
	private int number_of_plays;
	
	@Column(name = "popularity")
	private int popularity;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Mood mood;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Popularity popularity;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Album album;

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

	public String getFilesystem_path() {
		return filesystem_path;
	}

	public void setFilesystem_path(String filesystem_path) {
		this.filesystem_path = filesystem_path;
	}

	public int getNumber_of_plays() {
		return number_of_plays;
	}

	public void setNumber_of_plays(int number_of_plays) {
		this.number_of_plays = number_of_plays;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Popularity getPopularity() {
		return popularity;
	}

	public void setPopularity(Popularity popularity) {
		this.popularity = popularity;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
		
}
