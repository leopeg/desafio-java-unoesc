package br.edu.unoesc.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RandomFact implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("source")
	private String source;
	
	@JsonProperty("source_url")
	private String source_url;
	
	@JsonProperty("language")
	private String language;
	
	@JsonProperty("permalink")
	private String permalink;
	
	public RandomFact() {}
	
	public RandomFact(String id, String text, String source, String source_url, String language, String permalink) {
		super();
		this.id = id;
		this.text = text;
		this.source = source;
		this.source_url = source_url;
		this.language = language;
		this.permalink = permalink;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getSource_url() {
		return source_url;
	}
	
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getPermalink() {
		return permalink;
	}
	
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RandomFact other = (RandomFact) obj;
		return Objects.equals(id, other.id);
	}	
}