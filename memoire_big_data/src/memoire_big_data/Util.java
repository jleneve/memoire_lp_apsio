package memoire_big_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Util {
	
	private Util() {
		
	}
	
	//lis un fichier et met chaque ligne dans une list
	//input : chemin du fichier
	//ouput : arrayList avec les lignes du fichier
	public static ArrayList<String> readWord(String path){
		
		ArrayList<String> mots = new ArrayList<String>();
		BufferedReader br = null;
		FileReader fr = null;
		
		try{
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			while((sCurrentLine = br.readLine()) !=null){
				mots.add(sCurrentLine);
			}
		}catch (IOException e){
			e.printStackTrace();
		}finally {
			try{
				if(br != null)
					br.close();
				
				if(fr != null)
					fr.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
		return mots;
	}
	
	//enregistre une liste de mots dans un fichier
	//input : liste de mots, chemin d'un fichier
	public static void saveWord(ArrayList<String> listeMots, String path){
		try (BufferedWriter br = new BufferedWriter(new FileWriter(new File(path)))) {
			for(String mots : listeMots){
				br.write(mots);
				br.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//initialise un BucketList à partir d'un fichier
	//input : chemin d'un fichier
	//output : BucketList initialisé
	public static BucketList initBucket(String path){
		BucketList bucketList = new BucketList();
		
		BufferedReader br = null;
		FileReader fr = null;
		double fileSize = 0;
		try{
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			List<String> lines = new ArrayList<>();
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				line = line.replace("½", "oe");
				line = line.replace("¼", "oe");
				lines.add(line);
			}
			int size = lines.size() / 10;
			int reste = lines.size() % 10;
			for(int i =0; i < 9;i++){
				Bucket bucket = new Bucket(lines.subList(i*size, i*size+size));
				bucketList.insertBucket(bucket);
			}
			Bucket bucket = new Bucket(lines.subList(9*size, 9*size+size+reste));
			bucketList.insertBucket(bucket);
		}catch (IOException e){
			e.printStackTrace();
		}finally {
			try{
				if(br != null)
					br.close();
				
				if(fr != null)
					fr.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return bucketList;
	}
	
	//retourne une liste d'occurence en fonction des liste d'occurence présente dans un bucketList
	//input : bucketList
	//ouput : map contenant la liste d'occurence
	public static Map<String,Integer> GroupOccurance(BucketList bucketList){
		ArrayList<String> alphabet = new ArrayList<String>();
		alphabet.add("a");
		alphabet.add("b");
		alphabet.add("c");
		alphabet.add("d");
		alphabet.add("e");
		alphabet.add("f");
		alphabet.add("g");
		alphabet.add("h");
		alphabet.add("i");
		alphabet.add("j");
		alphabet.add("k");
		alphabet.add("l");
		alphabet.add("m");
		alphabet.add("n");
		alphabet.add("o");
		alphabet.add("p");
		alphabet.add("q");
		alphabet.add("r");
		alphabet.add("s");
		alphabet.add("t");
		alphabet.add("u");
		alphabet.add("v");
		alphabet.add("w");
		alphabet.add("x");
		alphabet.add("y");
		alphabet.add("z");
		
		Map<String,Integer> listeOccurances = new HashMap<String,Integer>();
		for(String lettre : alphabet){
			listeOccurances.put(lettre, 0);
		}
		
		for(Bucket bucket : bucketList.getBucketList()){
			Map<String,Integer> bucketListeOccurances = bucket.getListeOccurances();
			for(String lettre : alphabet){
				Integer nbA = listeOccurances.get(lettre);
				Integer bucketNbA = bucketListeOccurances.get(lettre);
				if(nbA != null && bucketNbA !=null){
					listeOccurances.put(lettre, nbA+bucketNbA);
				}
			}
		}
		return listeOccurances;
	}
	
	public static void calculOccurances(Map<String,Integer> map){
		
	}
	
	
}
