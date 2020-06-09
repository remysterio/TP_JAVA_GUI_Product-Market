package test;
import java.util.ArrayList;
import java.util.Scanner;
import dao.ClientDao;
import metier.Client;

public class StudentDao {

	private static ArrayList<Client> list = new ArrayList<Client>();
	private static ClientDao dao = new ClientDao();
	private static String motcle;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		// On utilise la methode Dao createClient pour créer notre liste de client
		list = dao.createClient();

		System.out.println("Voici la liste des clients");
		
		// Boucle each parcourant le tableau de client
		for(Client cl : list) {
			System.out.println(cl.getNom()+" "+cl.getPrenom()+" "+cl.getAge()+"ans de "+cl.getVille());
		}
		
		System.out.println("Rentrez le mot clé");
		motcle = scan.nextLine();
		
		// On utilise la methode getClient qui renvoie soit le client trouvé soit NULL si rien trouver
		if(dao.getClientParMC(motcle, list)==null) {
			System.out.println("Pas de correspondance trouver");
		}
		
		else {
			System.out.println("Nous avons trouver un client avec le meme nom \n Nous allons donc supprimer ce client");
			list = dao.deleteClientParMC(motcle, list); // Methode supprimant le client MC de la list
			System.out.println("Voici la nouvelle liste des clients");
			for(Client cl : list) {
				System.out.println(cl.getNom()+" "+cl.getPrenom()+" "+cl.getAge()+"ans de "+cl.getVille());
			}
		}		
	}
}
