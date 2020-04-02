class Node<K, V>
{
    K key;
    V value;
 
    // Reference to next node
    Node<K, V> next;
 
    // Constructor
    public Node(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}
 