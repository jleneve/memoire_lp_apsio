package memoire_big_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bucket {
	
	private int nbMots;
	private List<String> listeMots;
	private Map<String,Integer> listeOccurances;
	
	public Bucket(List<String> list){
		this.listeMots = list;
		this.nbMots = list.size();
	}
	
	public int getNbMots() {
		return nbMots;
	}
	public void setNbMots(int nbMots) {
		this.nbMots = nbMots;
	}
	public List<String> getListeMots() {
		return listeMots;
	}
	public void setListeMots(List<String> listeMots) {
		this.listeMots = listeMots;
	}
	public Map<String, Integer> getListeOccurances() {
		return listeOccurances;
	}
	public void setListeOccurances(Map<String, Integer> listeOccurances) {
		this.listeOccurances = listeOccurances;
	}
	
	public boolean initOccurances(){
		if(listeMots.isEmpty()){
			return false;
		}
		if(listeOccurances == null){
			listeOccurances = new HashMap<String,Integer>();
		}
		listeOccurances.put("a", 0);
		listeOccurances.put("b", 0);
		listeOccurances.put("c", 0);
		listeOccurances.put("d", 0);
		listeOccurances.put("e", 0);
		listeOccurances.put("f", 0);
		listeOccurances.put("g", 0);
		listeOccurances.put("h", 0);
		listeOccurances.put("i", 0);
		listeOccurances.put("j", 0);
		listeOccurances.put("k", 0);
		listeOccurances.put("l", 0);
		listeOccurances.put("m", 0);
		listeOccurances.put("n", 0);
		listeOccurances.put("o", 0);
		listeOccurances.put("p", 0);
		listeOccurances.put("q", 0);
		listeOccurances.put("r", 0);
		listeOccurances.put("s", 0);
		listeOccurances.put("t", 0);
		listeOccurances.put("u", 0);
		listeOccurances.put("v", 0);
		listeOccurances.put("w", 0);
		listeOccurances.put("x", 0);
		listeOccurances.put("y", 0);
		listeOccurances.put("z", 0);
		
		for(String mots : listeMots){
			mots = mots.toLowerCase();
			String lettre = mots.substring(0, 1);
			lettre = cleanLetter(lettre);
			Integer nb = listeOccurances.get(lettre);
			if(nb != null){
				nb += 1;
				listeOccurances.put(lettre, nb);
			}
		}
		return true;
	}

	private String cleanLetter(String letter){
		if(letter.equals("é")
				|| letter.equals("è")
				|| letter.equals("ë")
				|| letter.equals("ê")){
			letter = "e";
		}else if(letter.equals("à")
				|| letter.equals("ã")
				|| letter.equals("á")
				|| letter.equals("â")
				|| letter.equals("ä")){
			letter = "a";
		}else if(letter.equals("ô")
				|| letter.equals("ó")
				|| letter.equals("ò")
				|| letter.equals("ö")){
			letter = "o";
		}else if(letter.equals("ù")
				|| letter.equals("û")){
			letter = "u";
		}else if(letter.equals("î")
				|| letter.equals("ï")){
			letter = "i";
		}else if(letter.equals("ç")){
			letter = "c";
		}
		return letter;
	}
}
