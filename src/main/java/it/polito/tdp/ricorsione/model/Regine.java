package it.polito.tdp.ricorsione.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	List<Integer> soluzione;
	public List<Integer> cercaRegine(int N) {

		this.soluzione=null;
		List<Integer> parziale = new ArrayList<Integer>();
		regine_ricorsiva(parziale,0,N);
		return this.soluzione;
	}
	
	private boolean regine_ricorsiva(List <Integer> parziale, int livello, int N) {
		if(livello==N) {//caso terminale
			System.out.println(parziale);
			this.soluzione=new ArrayList <Integer>(parziale);
			return false; // non continua
		}else {//caso generico
			// ho già da parziale[0] a parziale [livello-1]
			//devo decidere parziale[livello]
			
			for(int col=0; col<N ;col++) {
				if(compatibile(livello, col, parziale)==true) {//se col è compatibile con parziale faccio la ricorsione
					parziale.add(col);
					boolean continua=regine_ricorsiva(parziale,livello+1,N);
					if(!continua)
						return false; // non continua
					parziale.remove(parziale.size()-1); //backtracking
				}
			}
			return true;
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
