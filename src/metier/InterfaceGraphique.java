package metier;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceGraphique extends JFrame implements ActionListener {
	/*
	 * La classe Moteur Graphique va contenir tout notre programme hormis les
	 * Produits Nous heritons de la classe mère JFrame pour concevoir notre fenetre
	 * principal Nous héritons aussi des fonctionnalités de la classe ActionListener
	 * Donc travail sur 1 seul classe principal -> toute nos variables sont declarer
	 * en private On a enlevé tout les setter des classes Produits car on ne les
	 * utilisaient pas
	 */

	private boolean flag = true;
	// Flag permettant de savoir si on ajoute un produitA ou B sur la 1ere fenetre

	private static final long serialVersionUID = 1L;
	// Permet de conserver son programme meme si modification

	private JTextField text1 = new JTextField("");
	private JTextField text2 = new JTextField("");
	private JTextField text3 = new JTextField("");
	private JTextField text4 = new JTextField("");
	private JTextField text5 = new JTextField("");
	// Les JTextFiels sont les champs de texte permettant d'ecrire

	private JLabel label1 = new JLabel("Nom");
	private JLabel label2 = new JLabel("Ville");
	private JLabel label3 = new JLabel("Qualite");
	private JLabel label4 = new JLabel("PrixUnitaire");
	private JLabel label5 = new JLabel("Quantite");
	// Nous utilisons les labels comme des images contenant des mots pouvant etre
	// afficher

	private JButton bouton1 = new JButton("Ajouter");
	// Ajoute le produit rentrer a la liste des resultats

	private JButton bouton2 = new JButton("Finish");
	// Affiche le resultat

	private JButton bouton3 = new JButton("Changer");
	// Change l'affichage pour rentrer un Produit B

	private JButton bouton4 = new JButton("Quitter");
	// Quitte le programme

	private ArrayList<ProduitA> listA = new ArrayList<ProduitA>();
	private ArrayList<ProduitB> listB = new ArrayList<ProduitB>();
	// Nos 2 tableaux dynamiques contenant les produits rentrés

	private JPanel panneau = new JPanel();
	private JFrame fen = new JFrame();
	// Fenetre et panneau que nous utiliserons pour le resultat
	// Car nouys n'avons pas reussi a contruire 2 fenetre differente a partir d'1
	// seul constructeur

	public InterfaceGraphique() {

		this.setTitle("Fenetre Produit A"); // Titre de la fenetre
		this.setSize(300, 350); // Taille de la fenetre
		this.setLocationRelativeTo(null); // Centre la fenetre sur l'ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ferme l'appli quand on appuie sur la croix

		// this.getContentPane() permet de faire référence au panneau par défaut attaché
		// à notre fenetre constructeur
		this.getContentPane().setLayout(new GridLayout(7, 2));
		// Fenetre repartie en 7 lignes et 2 colonnes (1 pour le label d'info et l'autre
		// le champs texte

		this.getContentPane().add(label1);
		this.getContentPane().add(text1);
		this.getContentPane().add(label2);
		this.getContentPane().add(text2);
		this.getContentPane().add(label3);
		this.getContentPane().add(text3);
		this.getContentPane().add(label4);
		this.getContentPane().add(text4);
		this.getContentPane().add(label5);
		this.getContentPane().add(text5);
		this.getContentPane().add(bouton1);
		this.getContentPane().add(bouton2);
		this.getContentPane().add(bouton3);
		this.getContentPane().add(bouton4);
		// Ajout des différents objets selon l'ordre du GridLayout

		bouton1.addActionListener(this);
		bouton2.addActionListener(this);
		bouton3.addActionListener(this);
		bouton4.addActionListener(this);
		// Ajout des listener sur les boutons

		this.setVisible(true);
		// Rend la fenetre visible
		// Nous n'utilisons pas pack() car sinon la fenetre est petite par defaut malgre
		// le dimmensionnement
	}

	public void actionPerformed(ActionEvent evenement) {
		// Notre methode listener

		JButton boutonClique = (JButton) evenement.getSource();
		String texteEcrit = boutonClique.getText();
		// Recuperation de l'info du bouton cliqué

		if (texteEcrit.equals("Ajouter")) {
			// On ajoute le Produit correspondant dans son tableau dynamique
			// dont les valeurs sont prélevé dans les textFields

			if (flag == true) {//

				listA.add(new ProduitA(text1.getText(), text2.getText(), text3.getText(),Integer.parseInt(text4.getText()), Integer.parseInt(text5.getText())));
			}

			else {
				listB.add(new ProduitB(text1.getText(), text2.getText(), Integer.parseInt(text3.getText()),Integer.parseInt(text4.getText()), Integer.parseInt(text5.getText())));
			}

			text1.setText(""); // Vide les TextField
			text2.setText("");
			text3.setText("");
			text4.setText("");
			text5.setText("");
		}

		else if (texteEcrit.equals("Finish")) {
			// On lance la 2e interface graphique comportant les résultats
			resultat();
		}

		else if (texteEcrit.equals("Changer")) {
			// On change le type de produit à rentré

			if (flag == true) { // ProduitA to ProduitB
				this.setTitle("Fenetre Produit B");
				this.label3.setText("TxReduction");
				flag = false;

			}

			else { // ProduitB to ProduitA
				this.setTitle("Fenetre Produit A");
				this.label3.setText("Qualite");
				flag = true;
			}
		}

		else if (texteEcrit.equals("Quitter")) {
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		// Constructeur sans parametre instanciant notre JFrame de depart
		new InterfaceGraphique();
	}

	public void resultat() {

		// Configuration initial de la nouvelle fenetre
		fen.setTitle("Resultat");
		fen.setSize(400, 500);
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Activation du panneau sur la fenetre
		fen.setContentPane(panneau);

		panneau.setLayout(new GridLayout(listA.size() + listB.size() + 1, 7));
		panneau.add(new JLabel("Nom"));
		panneau.add(new JLabel("Ville"));
		panneau.add(new JLabel("Qualite"));
		panneau.add(new JLabel("TxReduction"));
		panneau.add(new JLabel("Prix_Unitaire"));
		panneau.add(new JLabel("Quantite"));
		panneau.add(new JLabel("PrixTotale"));

		int i = 0;

		for (i = 0; i < listA.size(); i++) {
			// On ajoute sur le panneau des labels qui correspondent à des cases qui
			// contiennent des informations
			// 6 labels pour 6 parametres par ligne
			// On utilise les Getters et String.valueOF pour un affichage en String

			panneau.add(new JLabel(listA.get(i).getNom()));
			panneau.add(new JLabel(listA.get(i).getVille()));
			panneau.add(new JLabel(listA.get(i).getQualite()));
			panneau.add(new JLabel(" "));
			panneau.add(new JLabel(String.valueOf(listA.get(i).getPrixUnitaire())));
			panneau.add(new JLabel(String.valueOf(listA.get(i).getQuantite())));
			panneau.add(new JLabel(String.valueOf(listA.get(i).calculPrix(listA.get(i).getQuantite(), listA.get(i).getPrixUnitaire()))));
		}

		for (i = 0; i < listB.size(); i++) {

			panneau.add(new JLabel(listB.get(i).getNom()));
			panneau.add(new JLabel(listB.get(i).getVille()));
			panneau.add(new JLabel(" "));
			panneau.add(new JLabel(String.valueOf(listB.get(i).getTxReduction())));
			panneau.add(new JLabel(String.valueOf(listB.get(i).getPrixUnitaire())));
			panneau.add(new JLabel(String.valueOf(listB.get(i).getQuantite())));
			panneau.add(new JLabel(String.valueOf(listB.get(i).calculPrix(listB.get(i).getQuantite(),listB.get(i).getPrixUnitaire(), listB.get(i).getTxReduction()))));
		}

		fen.setVisible(true);
		this.setVisible(false);
		fen.pack();
	}
}