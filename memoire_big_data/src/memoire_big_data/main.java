package memoire_big_data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		
		System.out.println("coucou");
		//initialise une liste de lignes à l'aide d'un fichier
		//ArrayList<String> listeMots = Util.readWord("D:/fr.dic");
		
		//mélange la liste
		//Collections.shuffle(listeMots);
		
		//sauvegarde une arraylist dans un fichier
		//Util.saveWord(listeMots, "D:/unsortFr.dic");
		
		BucketList bucketList = Util.initBucket("D:/unsortFr.dic");
		int i = 0;
		for(Bucket bucket : bucketList.getBucketList()){
			bucket.initOccurances();
		/*	for(String mots : bucket.getListeMots()){
				i++;
			}
			Map<String,Integer> map = bucket.getListeOccurances();
			Set<String> cles = map.keySet();
			Iterator<String> it = cles.iterator();
			while(it.hasNext()){
				String cle = it.next();
				Integer valeur = map.get(cle);
				System.out.println( "key : "+cle);
				System.out.println( " ; valeur : "+valeur);
			}*/
		}
		Map<String,Integer> map = Util.GroupOccurance(bucketList);
		Set<String> cles = map.keySet();
		Iterator<String> it = cles.iterator();
		while(it.hasNext()){
			String cle = it.next();
			Integer valeur = map.get(cle);
			System.out.println( "key : "+cle);
			System.out.println( " ; valeur : "+valeur);
		}
	}
}
