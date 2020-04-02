import java.util.ArrayList;
import java.util.Random;
public class HashMap<K, V>
{
    private int prime; // prime factor
    private long scale, shift; // the shift and scaling factors   
    private ArrayList<Node<K, V>> bucketArray;// bucketArray is used to store array of chains   
    private int numBuckets;// Current capacity of array list 
    private int size;// Current size of array list
    private ArrayList<Node<K, V>> sequenceArray=new ArrayList<>(); ;
    public HashMap()// Constructor (Initializes capacity, size and empty chains.
    {
        bucketArray = new ArrayList<>();       
        numBuckets = 10;
        size = 0;
        prime=13;
        Random rand = new Random( );
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }
    public HashMap(int capacity,int newPrime)
    {
        bucketArray = new ArrayList<>();
        numBuckets = capacity;
        size = 0;
        prime=newPrime;
        Random rand = new Random( );
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
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
    public void setKeyLength(int Length)
    {
    	String str=4+"";
    }
    public V remove(K key)// Method to remove a given key
    {       
        int bucketIndex = getBucketIndex(key);// Apply hash function to find index for given key       
        Node<K, V> head = bucketArray.get(bucketIndex);// Get head of chain       
        Node<K, V> prev = null;// Search for key in its chain
        while (head != null)
        {           
            if (head.key.equals(key))// If Key found
                break;             
            prev = head;// Else keep moving in chain
            head = head.next;
        }        
        if (head == null)// If key was not there
            return null;       
        size--;// Reduce size       
        if (prev != null)// Remove key
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);
 
        return head.value;
    }   
    public V getValue(K key)// Returns value for a key
    {      
    	// Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(bucketIndex);        
        while (head != null)// Search key in chain
        {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }        
        return null;// If key not found
    }   
    public void add(K key, V value)// Adds a key value pair to hash
    {   
    	// Find head of chain for given key    
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(bucketIndex);  
        Node<K, V> prev = null;
        while (head != null)// Check if key is already present
        {
            if (head.key.equals(key)&&prev==null)
            {
            	Node<K, V> newNode1 = new Node<K, V>(key, value);
            	newNode1.next=head;
            	bucketArray.set(bucketIndex, newNode1);
            	size++;
            	sequenceArray.add(newNode1);
            	return;
            }
            if (head.key.equals(key)&&prev!=null)
            {
            	Node<K, V> newNode2 = new Node<K, V>(key, value);
            	newNode2.next=head;
            	prev.next=newNode2;
            	size++;
            	sequenceArray.add(newNode2);
            	return;
            }
            prev=head;
            head = head.next;
        }       
        size++;// Insert key in chain
        head = bucketArray.get(bucketIndex);
        Node<K, V> newNode = new Node<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        sequenceArray.add(newNode);
        
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
    public K nextKey(K key)
    {
    	for(int i=0;i<sequenceArray.size();i++)
    	{
    		if(sequenceArray.get(i).key==key)
    		{
    			if(i==sequenceArray.size()-1)
    				return null;
    			else
    				return sequenceArray.get(i+1).key;
    		}
    	}
    	return null;
    }
    public K preKey(K key)
    {
    	for(int i=0;i<sequenceArray.size();i++)
    	{
    		if(sequenceArray.get(i).key==key)
    		{
    			if(i==0)
    				return null;
    			else
    				return sequenceArray.get(i-1).key;
    		}
    	}
    	return null;
    }
    /*public K nextKey(K key)
    {
    	// Find head of chain for given key
    	int bucketIndex = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(bucketIndex);
        if(head==null)
        	return null;
        while(head.next!=null)
        {
        	if(head.next.key.equals(key))
        		return head.next.key;
        	head=head.next;
        }
        return null;
    }
    public K preKey(K key)
    {
    	// Find head of chain for given key
    	int bucketIndex = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(bucketIndex);
        Node<K, V> prev=null;
        while(head!=null)
        {
        	if(head.key.equals(key))
        		break;
        	prev=head;
        	head=head.next;
        }
        if(head==null)//not found the key
        	return null;
        else if(prev==null)
        	return null;
        else
        	return prev.key;
    }*/
    public static void generate(int n)
	{
		
	}
 }