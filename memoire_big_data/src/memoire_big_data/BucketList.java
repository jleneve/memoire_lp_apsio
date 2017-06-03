package memoire_big_data;

import java.util.ArrayList;

public class BucketList {

	private int size;
	private ArrayList<Bucket> bucketList;

	public BucketList(){
		bucketList = new ArrayList<Bucket>();
	}
	public void insertBucket(Bucket bucket){
		this.size ++;
		bucketList.add(bucket);
	}

	public int getSize() {
		return size;
	}
	public ArrayList<Bucket> getBucketList() {
		return bucketList;
	}
	
}
