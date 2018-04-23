package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		
		this.voti = new ArrayList<>();	//creo lista con generics - voto nel <> non c'è 
		
	}
	
	public Libretto(List<Voto> voti) {
		
		//this.voti = voti; Copia riferimenti e non contenuto lista
		
		//this.voti = new ArrayList<Voto>(voti); Errata anche questa. Libretti diversi ma gli oggetti voto no
		
		this.voti = new ArrayList<Voto>();
		for(Voto v : voti) {
			this.voti.add(new Voto(v.getEsame(), v.getVoto()));
		}
		
	}

	public void add(Voto v) {
		
		if (this.voti.contains(v)) {
			
			System.out.println("Errore: il voto esiste già");
			return;
			
		}
		
		for (Voto voto : this.voti) {
			
			if (voto.getEsame().equals(v.getEsame())) {
				
				System.out.println("Trovato lo stesso esame (aggiorno il voto)");
				voto.setVoto(v.getVoto());
				return;
				
			}
		
			
		}
		
		this.voti.add(v);
		
	}
	
	public void stampa() {
		
		System.out.println("Ci sono " + voti.size() + " voti");
		
		for (Voto v: this.voti) {
			System.out.println(v.toString());
		}
		
	}

	public void stampa25() {

		for (Voto v : this.voti) {
			
			if (v.getVoto() == 25) {
				System.out.println(v.toString());
			}
			
		}
		
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Ci sono " + voti.size() + " voti\n");
		
		for (Voto v: this.voti) {
			sb.append(v.toString() +"\n");
		}
		
		return sb.toString();
		
	}

	public String getMarkfromClass(String nomeCorso) {

		for (Voto v : this.voti) {
			
		//	if (v.getEsame() == nomeCorso) {  //confronto tra string mai utilizzare == ma equals
				
		//		return String.valueOf(v.getVoto());
				
		//	}
			
			if (v.getEsame().toLowerCase().equals(nomeCorso.toLowerCase())) {
				
				return String.valueOf(v.getVoto());
				
			}
			
		}
		
		return "Nome corso non trovato";
		
	}

	public List<Voto> getVoti() {
		
		return this.voti;
		
	}

	public void alzaVoti() {

		for (Voto v : this.voti) {
			
			if (v.getVoto() >= 24) {
				
				v.setVoto(v.getVoto() + 2);
				
			} else if (v.getVoto() >= 18) {
				
				v.setVoto(v.getVoto() + 1);
				
			}
			
		}
		
	}	
	
}
