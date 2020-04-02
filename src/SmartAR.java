import java.util.ArrayList;
import java.util.Random;
import java.util.Collection;

public class SmartAR<K extends Comparable<K>, V >
{
    private int prime; // prime factor
    private long scale, shift; // the shift and scaling factors   
    private ArrayList<Node<K, V>> bucketArray;// bucketArray is used to store array of chains   
    private ArrayList<Node2<K>> bucketArrayForgeneratedKeys;
    private int numBuckets;// Current capacity of array list 
    private int size;// Current size of array list
    private int sizeForGeneratedKeys;// Current size of array list
    private ArrayList<Node<K, V>> sequenceArray=new ArrayList<>(); 
    private ArrayList<K> arrayKeys=new ArrayList<>();//array for all the keys
    private ArrayList<Node<K, V>> preCarsArray=new ArrayList<>();//array for the keys of previous cars
    private ArrayList<V> valuesOfGivenKey=new ArrayList<>();//array for the keys of previous cars
    private ArrayList<K> keysGenerated=new ArrayList<>();//array for the keys of previous cars
    private int threshold;
	private int length;
	private int totalEntries;//the total number of entries the users will input
    public SmartAR()// Constructor (Initializes capacity, size and empty chains.
    {
        bucketArray = new ArrayList<>();  
        bucketArrayForgeneratedKeys= new ArrayList<>(); 
        numBuckets = 101;
        size = 0;
        prime=13;
        Random rand = new Random( );
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
        {
            bucketArray.add(null);
            bucketArrayForgeneratedKeys.add(null);
        }
    }
    public SmartAR(int capacity,int newPrime)
    {
        bucketArray = new ArrayList<>();
        bucketArrayForgeneratedKeys= new ArrayList<>();
        numBuckets = capacity;
        size = 0;
        prime=newPrime;
        Random rand = new Random( );
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
        {
            bucketArray.add(null);
            bucketArrayForgeneratedKeys.add(null);
        }
    }
    public void setThreshold(int newThreshold)
	{
		threshold=newThreshold;
	}
	public void setKeyLength(int newLength)
	{
		length=newLength;
	}
	public void setTotalEntries(int newTotalEntries)
	{
		totalEntries=newTotalEntries;
	}
	public int getTotalEntries()
	{
		return totalEntries;
	}
	public ArrayList<Node<K, V>> getPreCarsArray()
	{
		return preCarsArray;
	}
	public ArrayList<Node<K, V>> getSequenceArray()
	{
		return sequenceArray;
	}
	public ArrayList<K> getArrayKeys()
	{
		return arrayKeys;
	}
	public ArrayList<K> getKeysGenerated()
	{
		return keysGenerated;
	}
    public int size() 
    { 
    	return size; 
    }
    public boolean isEmpty() 
    { 
    	return size() == 0; 
    }
    private int getBucketIndex(K key)// This implements hash function to find index for a key
    {
        int hashCode = key.hashCode();
        int index = (int) ((Math.abs(key.hashCode( )*scale + shift) % prime) % numBuckets);
        return index;
    }    
    public Node<K,V> remove(K key)// Method to remove a given key
    {  
    	if(totalEntries>threshold)//use hash table
    	{
            int bucketIndex = getBucketIndex(key);// Apply hash function to find index for given key       
            Node<K, V> head = bucketArray.get(bucketIndex);// Get head of chain       
            Node<K, V> prev = null;// Search for key in its chain
            while (head != null)
            {           
                if (head.key.compareTo(key)==0)// If Key found
                    break;             
                prev = head;// Else keep moving in chain
                head = head.next;
            }        
            if (head == null)// If key was not there
                return null;       
            size--;// Reduce size   
            arrayKeys.remove(head.key);//remove a key in arrayKeys
            if (prev != null)// Remove key           	
                prev.next = head.next;
            else
                bucketArray.set(bucketIndex, head.next);
            
            return head;
    	}
    	else//use ArrayList
    	{
    		for(int i=0;i<sequenceArray.size();i++)
    		{
    			if(sequenceArray.get(i).key.compareTo(key)==0)
    			{
    				Node<K,V> temp=sequenceArray.get(i);
    				sequenceArray.remove(i);
    				size--;
    				arrayKeys.remove(sequenceArray.get(i).key);//remove a key in arrayKeys
    				return temp;
    			}
    		}
    		return null;
    	}
    }
    
    public ArrayList<Node<K, V>> previousCars(K key)
    {
    	if(totalEntries>threshold)//use hash table
    	{
    		int bucketIndex = getBucketIndex(key);// Apply hash function to find index for given key       
            Node<K, V> head = bucketArray.get(bucketIndex);// Get head of chain            
            while (head != null)
            {           
                if (head.key.compareTo(key)==0)// If Key found
                	preCarsArray.add(0,head); //keep reverse chronological order                            
                head = head.next;
            } 
            if(head==null)
            	return null;
            preCarsArray.remove(0);
            return preCarsArray;
    	}
    	else//use ArrayList
    	{
    		if(!existKey(key))
    			return null;   		
    		for(int i=0;i<sequenceArray.size();i++)
    		{
    			if(sequenceArray.get(i).key.equals(key))
    				preCarsArray.add(0,sequenceArray.get(i));//keep reverse chronological order
    		}
    		preCarsArray.remove(0);
    		return preCarsArray;
    	}
    }
    public ArrayList<V> getValues(K key)// Returns value for a key
    {     
    	if(totalEntries>threshold)//use hash table
    	{    		
    	    // Find head of chain for given key
            int bucketIndex = getBucketIndex(key);
            Node<K, V> head = bucketArray.get(bucketIndex);                
            while (head != null)// Search key in chain
            {
                if (head.key.equals(key))
                	valuesOfGivenKey.add(head.value);
                head = head.next;
            } 
            if (head==null)
            	return null;
            return valuesOfGivenKey;// If key not found
    	}
    	else//use ArrayList
    	{
    		int count=0;//to trace the total number of for loop
    		for(int i=0;i<sequenceArray.size();i++)
    		{
    			if(sequenceArray.get(i).key.compareTo(key)==0)
    			{   				
    				valuesOfGivenKey.add(sequenceArray.get(i).value); 
    				count++;
    			}
    		}
    		if(count==0)
    		    return null;
    		else
    			return valuesOfGivenKey;//return an ArrayList for values of the given keys
    	}
    }   
    public void add(K key, V value)// Adds a key value pair to hash
    {  
    	if(totalEntries>threshold)//use hash table
    	{   	 
    	    // Find head of chain for given key    
            int bucketIndex = getBucketIndex(key);
            Node<K, V> head = bucketArray.get(bucketIndex);           
            size++;// Insert key in chain    
            if(head==null)
            {
                Node<K, V> newNode = new Node<K, V>(key, value);
                newNode.next = head;
                bucketArray.set(bucketIndex, newNode);               
                sequenceArray.add(newNode);   //add all the entries in an ArrayList
                arrayKeys.add(newNode.key);//add all the keys in an ArrayList             
            }                     
            else
            { 
            	Node<K, V> tail=head;
            	while(tail.next!=null)//tail to point to the last node
            	{
            		tail=tail.next;
            	}
            	Node<K, V> newNode1 = new Node<K, V>(key, value);
            	tail.next=newNode1;
            	tail=newNode1;
            	sequenceArray.add(newNode1);           	
            	arrayKeys.add(newNode1.key);            	
            }
        
            if ((1.0*size)/numBuckets >= 0.7)// If load factor goes beyond threshold, then double hash table size
            {
                ArrayList<Node<K, V>> temp = bucketArray;
                bucketArray = new ArrayList<>();
                numBuckets = 2 * numBuckets;
                size = 0;
                for (int i = 0; i < numBuckets; i++)
                    bucketArray.add(null);
 
                for (Node<K, V> headNode : temp)
                {
                    while (headNode != null)
                    {
                        add(headNode.key, headNode.value);
                        headNode = headNode.next;
                    }
                }
            }
    	}
    	else//use ArrayList
    	{
    		Node<K, V> newNode=new Node<K,V>(key,value);
    		sequenceArray.add(newNode);
    		arrayKeys.add(newNode.key);
    		size++;
    	}
    }
    //return the next key of the given key
    public K nextKey(K key)
    { 
    	int size=arrayKeys.size();
    	for(int i=0;i<arrayKeys.size();i++)
    	{ 
    	    if(arrayKeys.get(i).compareTo(key)==0)
    		{    	    	
    			if(i==arrayKeys.size()-1)
    			   return null;
    			else
    			{    				
    			   return arrayKeys.get(i+1);
    			}
    		}
    	}
    	return null;   	
    }
    //return the previous key of the given key
    public K prevKey(K key)
    {
    	for(int i=0;i<arrayKeys.size();i++)
    	{
    		if(arrayKeys.get(i).compareTo(key)==0)
    		{
    			if(i==0)
    				return null;
    			else
    				return arrayKeys.get(i-1);
    		}
    	}
    	return null;
    }
    //check if the key exist in the data set or not
    private boolean existKey(K key)
    {
    	if(totalEntries>threshold)//use hash table
    	{   	 
    	    // Find head of chain for given key    
            int bucketIndex = getBucketIndex(key);
            Node<K, V> head = bucketArray.get(bucketIndex); 
            while (head != null)
            {           
                if (head.key.compareTo(key)==0)// If Key found
                    return true;                             
                head = head.next;
            }        
            if (head == null)// If key was not there
                return false;
    	}
    	else
    	{
    	    for(int i=0;i<sequenceArray.size();i++)
    	    {
    		    if(sequenceArray.get(i).key==key)
    		       return true; 			
    	    }  	
    	}
    	return false;
    }
    //generate n keys according to the given length
    public void generate(int n)
	{
    	if(n<threshold)//if the user want to generate the number of keys does not exceed the threshold
    	{
    	    String str="";
		    for(int i=0;i<n;i++)
		    {
			    str=getRandomKey(length);
			    K aKey=(K) str;
			    if(!existKey(aKey))
			    	keysGenerated.add(aKey);
			    else
			    	i--;//make sure to generate exact n keys.
		    }
    	}
    	else//otherwise,use hash table
    	{   
    		String str="";
		    for(int i=0;i<n;i++)
		    {
			    str=getRandomKey(length);
			    K aKey=(K) str;
			    if(!existKey(aKey))
			    {
			    	int bucketIndex2 = getBucketIndex(aKey);
		            Node2<K> head = bucketArrayForgeneratedKeys.get(bucketIndex2);           
		            sizeForGeneratedKeys++;// Insert key in chain    
		            if(head==null)
		            {
		                Node2<K> newNode = new Node2<K>(aKey);
		                newNode.next = head;
		                bucketArrayForgeneratedKeys.set(bucketIndex2, newNode);               
		                       
		            }                     
		            else
		            { 
		            	Node2<K> tail=head;
		            	while(tail.next!=null)
		            	{
		            		tail=tail.next;
		            	}
		            	Node2<K> newNode1 = new Node2<K>(aKey);
		            	tail.next=newNode1;
		            	tail=newNode1;
		            	keysGenerated.add(aKey);           			            	     	
		            }
			    }
			    else
			    	i--;//make sure to generate exact n keys.
		    }    	    
    	}
	}
    //generate a random key
    public String getRandomKey(int length)
	{
	     String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++)
	     {
	       int number=random.nextInt(36);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
    //sort all keys
    public void allKeys()
    {   	
    	for(int i=0;i<arrayKeys.size();i++)
    		for(int j=1;j<arrayKeys.size()-i;j++)
    		{
    			  int comparision=arrayKeys.get(j-1).compareTo(arrayKeys.get(j));
    			  if(comparision>0)
    			  {  
                      //swap elements  
                      K temp = arrayKeys.get(j-1);  
                      arrayKeys.set(j-1, arrayKeys.get(j));
                      arrayKeys.set(j, temp);                  
    			  }
    		}
    }   
 }