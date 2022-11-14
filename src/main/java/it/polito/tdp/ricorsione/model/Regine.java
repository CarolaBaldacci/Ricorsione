package it.polito.tdp.ricorsione.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	public void cercaRegine(int N) {
		List<Integer> parziale = new ArrayList<Integer>();
		regine_ricorsiva(parziale,0,N);
	}
	
	private void regine_ricorsiva(List <Integer> parziale, int livello, int N) {
		if(livello==N) {//caso terminale
			System.out.println(parziale);
		}else {//caso generico
			// ho già da parziale[0] a parziale [livello-1]
			//devo decidere parziale[livello]
			
			for(int col=0; col<N ;col++) {
				if(compatibile(livello, col, parziale)==true) {//se col è compatibile con parziale faccio la ricorsione
					parziale.add(col);
					regine_ricorsiva(parziale,livello+1,N);
					parziale.remove(parziale.size()-1); //backtracking
				}
			}
		}
	}
	
	private boolean compatibile(int livello, Integer col,List<Integer> parziale) {
		if (parziale.indexOf(col)!= -1) 
			return false;
		for(int riga=0; riga<parziale.size();riga++) {
			//regina alle coordinate (riga, parziale.get(riga))
			//confronto con (R,C) =(livello,col)
			if(riga+parziale.get(riga)==livello+col)
				return false;
			if(riga-parziale.get(riga)==livello-col)
				return false;
		}
		return true;
			
	}
	

}
