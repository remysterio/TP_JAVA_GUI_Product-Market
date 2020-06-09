package metier;
public interface IProduit {
	public int calculPrix(int quantite, int prix);
	public int calculPrix(int quantite, int prix, int txReduction);
}
