package src.Association;

public class Movies {
	private String Name;
	private String Language;
	private String duration;
	private String genre;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
