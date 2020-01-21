package cl.manuelcarok.model;

public class Poemas {
	
	private String title;
	private String content;
	private String url;
	private Autor poet;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Autor getPoet() {
		return poet;
	}
	public void setPoet(Autor poet) {
		this.poet = poet;
	}
	
	
}
