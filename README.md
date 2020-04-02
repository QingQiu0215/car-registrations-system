# car-registrations-system

The General Automobile Registration Office (GARO) keeps records of car registrations. It
operates on multiple lists of n car registrations, where each registered car is identified by its unique
license plate that consists of alphanumeric characters (e.g. R4G5OO54TE). The composition of
license plates can be different for provinces and countries but their maximum length is restricted
to 12 alphanumeric characters. Some of the lists are local for cities and areas, where n counts a
few hundred properties. Others are at the provincial level, that is n counts tens of thousands or
more, or even at country levels, that is n counts millions or more. Furthermore, it is important to
have access to the history cars of that have been registered with the same license plate. Such a
historical record for a license plate should be kept in reverse chronological order.
GARO needs your help to design a smart “automobile registration listing” data structure called
SmartAR. Keys of SmartAR entries are strings composed of 6-12 alphanumeric characters, and
one can retrieve the key of a SmartAR or access a single element by its key. Furthermore, similar
to sequences, given a SmartAR element one can access its predecessor or successor (if it exists).
SmartAR adapts to its usage and keeps the balance between memory and runtime requirements.
For instance, if a SmartAR contains only a small number of entries (e.g., few hundreds), it might
use less memory overhead but slower (sorting) algorithms. On the other hand, if the number of
contained entries is large (greater than 1000 or even in the range of tens of thousands of elements
or more), it might have a higher memory requirement but faster (sorting) algorithms. SmartAR
might be almost constant in size or might grow and/or shrink dynamically. Ideally, operations
applicable to a single SmartAR entry should be between O(1) and O(log n) but never worse than
O(n). Operations applicable to a complete SmartAR should not exceed O(n2).
You are asked to design and implement SmartAR, a smart data structure which automatically
adapts to the dynamic content that it operates on. In other words, it accepts the size (total number
of n car registrations identified by their key, i.e., license plate) as a parameter and uses an
appropriate (set of) data structure(s) from the one(s) studied in class in order to perform the
operations below efficiently1.
The SmartAR must implement the following methods:

• setThreshold(Threshold): where 100 ≤ Threshold ≤ ~500,000 is an integer number
that defines when a listing should be implemented with a data structure such as a Tree,
Hash Table, AVL tree, binary tree, if its size is greater than or equal to value of
Threshold. Otherwise it is implemented as a Sequence.
• setKeyLength(Length): where 6 ≤ Length ≤ 12 is an integer number that defines the
fixed string length of keys.
• generate(n): randomly generates a sequence containing n new non-existing keys of
alphanumeric characters
• allKeys(): return all keys as a sorted sequence (lexicographic order)
• add(key,value2): add an entry for the given key and value
• remove(key): remove the entry for the given key
• getValues(key): return the values of the given key
• nextKey(key): return the key for the successor of key
• prevKey(key): return the key for the predecessor of key
• previousCars(key): returns a sequence (sorted in reverse chronological order) of cars
(previously) registered with the given key (license plate).
