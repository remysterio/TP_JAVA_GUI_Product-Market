package dao;
import java.util.ArrayList;
import java.util.Scanner;
import metier.Client;
public class ClientDao {
	
	private Scanner scan = new Scanner(System.in);
	//private Client cli = new Client();
	private ArrayList<Client> tab = new ArrayList<Client>(); 
	
	public ArrayList<Client> createClient() {
		/* Nous sommes restés confus sur cette methode. En effet elle s'appelle createClient et non createClientS ou createTabClient
		 * Logiquement elle devraient renvoyé un client . Cependant la consigne demande de retourner un tableau.
		 * Cette fonction retourne donc le tableau de client que nous avons crée
		*/	
			System.out.println("Rentrez le Nombre de client");
			int i=0, indice;
			indice = scan.nextInt();
			for(i=0;i<indice;i++) {
		
				Client cli = new Client();
				// On crée une nouvelle instance a chaque rebouclage car si on instancie dans la classe
				// chaque valeur rentrer vas écraser toute les anciennes
				
				System.out.println("Rentrez le Nom du "+(i+1)+"e client");
				cli.setNom(scan.next());
				System.out.println("Rentrez le Prénom");
				cli.setPrenom(scan.next());
				System.out.println("Rentrez l'age");
				cli.setAge(scan.nextInt());
				System.out.println("Rentrez la ville");
				cli.setVille(scan.next());
			
				tab.add(cli);
				}
		return(tab);
	}
	
	public Client getClientParMC(String mc, ArrayList<Client> list) {
		// Fonction cherchant le MC dans la liste
		// Renvoi Null si rien trouver, sinon renvoie le client
		for(Client cli : list) {
			if(cli.getNom().equals(mc)) {
				return(cli);
			}
		}
		return(null);
	}
	
	public ArrayList<Client >deleteClientParMC(String mc, ArrayList<Client> list) {
		// Fonction supprimant le MC de la list puis la renvoie
		for(Client cli : list) {
			if(cli.getNom().equals(mc)) {
				list.remove(cli);
			}
		}
		return(list);
	}
}
