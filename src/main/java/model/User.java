package model;

public class User {
	private Long id;
	private String nom;
	private String prenom;
	private String mail;

	public User(Long id, String mail,String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
