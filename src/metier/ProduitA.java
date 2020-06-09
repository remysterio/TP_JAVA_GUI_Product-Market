package metier;

public class ProduitA implements IProduit {
	
	private String nom;
	private String ville;
	private String qualite;
	private int prixUnitaire;
	private int quantite;

	public int calculPrix(int quantite, int prix) {

		return (quantite * prix);
	}

	public int calculPrix(int quantite, int prix, int txReduction) {
		return (0);
	}

	public ProduitA(String nom, String ville, String qualite, int prixUnitaire, int quantite) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.qualite = qualite;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
	}

	public String getNom() {
		return nom;
	}

	public String getVille() {
		return ville;
	}

	public String getQualite() {
		return qualite;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public int getQuantite() {
		return quantite;
	}
}