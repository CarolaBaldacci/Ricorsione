package it.polito.tdp.ricorsione.model;

public class Anagrammi {
	
//Riceve una stringa e stampa tutti i suoi l'anagramma
	public void anagramma(String s) {
		anagramma_ricorsiva("",0,s);
	}
	
//Data una soluzione parziale stampa turti gli anagrammi che iniziano con le lettere già fissate
	//@param parziale = Soluzione parziale,iniziale, del mio anagramma
	//@param livello = livello dellla ricorsione
	//@param rimanenti = caratteri ancora da sistemare
	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if(rimanenti.length()==0) {/*caso terminale*/
			System.out.println(parziale);
		}else {
			/*caso normale*/
			//es:parziale='AC', livello=2, rimanenti='BD'
			for(int pos=0; pos<rimanenti.length(); pos++) {
				String nuova_parziale=parziale+rimanenti.charAt(pos);
				String nuova_rimanenti= rimanenti.substring(0, pos)+rimanenti.substring(pos+1);
				anagramma_ricorsiva(nuova_parziale, livello+1, nuova_rimanenti);
			}
			
		}
	}

	public static void main(String[] args) {
		Anagrammi main= new Anagrammi();
		main.anagramma("ABCD");
     }
	
}
