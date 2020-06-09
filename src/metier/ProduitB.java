package metier;

public class ProduitB implements IProduit {

	private String nom;
	private String ville;
	private int prixUnitaire;
	private int quantite;
	private int txReduction;

	public int calculPrix(int quantite, int prix, int txReduction) {

		return (int) (quantite * prixUnitaire * (1 - ((float) txReduction / 100)));

	}

	public int calculPrix(int quantite, int prix) {
		return (0);
	}

	public ProduitB(String nom, String ville, int txReduction, int prixUnitaire, int quantite) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.txReduction = txReduction;
	}

	public String getNom() {
		return nom;
	}

	public String getVille() {
		return ville;
	}

	public int getTxReduction() {
		return txReduction;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public int getQuantite() {
		return quantite;
	}
}
