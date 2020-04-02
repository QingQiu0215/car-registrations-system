import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class HashDriver 
{
	public static void main(String[] args)
    {
		System.out.println("##################1st data set########################");
        SmartAR<String,String> ar=new SmartAR<String,String>(23,17);
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries=keyboard.nextInt();
        ar.setThreshold(500);       
        ar.setTotalEntries(totalEntries);
        System.out.println("==============add=================================");
        ar.add("QKY34SV", "Ford1");       
        ar.add("QKY3XSV", "Ford2");       
        ar.add("04MZRCD", "Ford3");
        ar.add("8TYCJM8", "Ford4");
        ar.add("THO2N8N", "Ford5");
        ar.add("QGSZ5PZ", "Ford6");
        ar.add("QKY3XSV", "Ford7");
        ar.add("3EB6OWN", "Ford8");       
        ar.add("THO2N8N", "Ford9");
        ar.add("QKY3XSV", "Ford10");
        ar.add("QKY3XS2", "Ford11");
        ar.add("QKY3XS3", "Ford12");
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys=new ArrayList<String>();
        valuesOfGivenKeys=ar.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys.size();i++)
            System.out.println(valuesOfGivenKeys.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar.size();i++)
        	System.out.println(ar.getSequenceArray().get(i).key+"  "+ar.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr=ar.previousCars("QKY3XSV");
        for(int i=0;i<arr.size();i++)
        	System.out.println(arr.get(i).key+" "+arr.get(i).value);       
        System.out.println("==============remove=============================");
        ar.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar.size());
        System.out.println("==============allKeys============================");
        ar.allKeys();
        for(int i=0;i<ar.getArrayKeys().size();i++)
        	System.out.println(ar.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar.setKeyLength(7);
        ar.generate(501);
        int l=ar.getKeysGenerated().size();
        for(int i=0;i<l;i++)
        	System.out.println(ar.getKeysGenerated().get(i));
        
        System.out.println("##################2nd data set########################");
        SmartAR<String,String> ar2=new SmartAR<String,String>(17,13);
        Scanner keyboard2=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries2=keyboard2.nextInt();
        ar2.setThreshold(20);       
        ar2.setTotalEntries(totalEntries2);
        System.out.println("==============add=================================");
        ar2.add("QKY34SV", "Ford1");       
        ar2.add("QKY3XSV", "Ford2");       
        ar2.add("04MZRCD", "Ford3");
        ar2.add("8TYCJM8", "Ford4");
        ar2.add("THO2N8N", "Ford5");
        ar2.add("QGSZ5PZ", "Ford6");
        ar2.add("QKY3XSV", "Ford7");
        ar2.add("3EB6OWN", "Ford8");       
        ar2.add("THO2N8N", "Ford9");
        ar2.add("QKY3XSV", "Ford10");
        ar2.add("QKY3XS2", "Ford11");
        ar2.add("QKY3XS3", "Ford12");
        ar2.add("QKY34SV", "Ford12");       
        ar2.add("QKY3XSV", "Ford14");       
        ar2.add("04MZRCD", "Ford15");
        ar2.add("8TYCJM8", "Ford16");
        ar2.add("THO2N8N", "Ford17");
        ar2.add("QGSZ5PZ", "Ford18");
        ar2.add("QKY3XSV", "Ford19");
        ar2.add("3EB6OWN", "Ford20");       
        ar2.add("THO2N8N", "Ford21");
        ar2.add("QKY3XSV", "Ford22");
        ar2.add("QKY3XS2", "Ford23");
        ar2.add("QKY3XS3", "Ford24");
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys2=new ArrayList<String>();
        valuesOfGivenKeys2=ar2.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys2.size();i++)
            System.out.println(valuesOfGivenKeys2.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar2.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar2.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar2.size();i++)
        	System.out.println(ar2.getSequenceArray().get(i).key+"  "+ar2.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr2=ar2.previousCars("QKY3XSV");
        for(int i=0;i<arr2.size();i++)
        	System.out.println(arr2.get(i).key+" "+arr2.get(i).value);       
        System.out.println("==============remove=============================");
        ar2.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar2.size());
        System.out.println("==============allKeys============================");
        ar2.allKeys();
        for(int i=0;i<ar2.getArrayKeys().size();i++)
        	System.out.println(ar2.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar2.setKeyLength(7);
        ar2.generate(30);
        int l2=ar2.getKeysGenerated().size();
        for(int i=0;i<l2;i++)
        	System.out.println(ar2.getKeysGenerated().get(i));
        
        System.out.println("##################3rd data set########################");
        SmartAR<String,String> ar3=new SmartAR<String,String>(17,13);
        Scanner keyboard3=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries3=keyboard3.nextInt();
        ar3.setThreshold(25);       
        ar3.setTotalEntries(totalEntries3);
        System.out.println("==============add=================================");
        ar3.add("QKY34SV", "Ford1");       
        ar3.add("QKY3XSV", "Ford2");       
        ar3.add("04MZRCD", "Ford3");
        ar3.add("8TYCJM8", "Ford4");
        ar3.add("THO2N8N", "Ford5");
        ar3.add("QGSZ5PZ", "Ford6");
        ar3.add("QKY3XSV", "Ford7");
        ar3.add("3EB6OWN", "Ford8");       
        ar3.add("THO2N8N", "Ford9");
        ar3.add("QKY3XSV", "Ford10");
        ar3.add("QKY3XS2", "Ford11");
        ar3.add("QKY3XS3", "Ford12");
        ar3.add("QKY34SV", "Ford12");       
        ar3.add("QKY3XSV", "Ford14");       
        ar3.add("04MZRCD", "Ford15");
        ar3.add("8TYCJM8", "Ford16");
        ar3.add("THO2N8N", "Ford17");
        ar3.add("QGSZ5PZ", "Ford18");
        ar3.add("QKY3XSV", "Ford19");
        ar3.add("3EB6OWN", "Ford20");       
        ar3.add("THO2N8N", "Ford21");
        ar3.add("QKY3XSV", "Ford22");
        ar3.add("QKY3XS2", "Ford23");
        ar3.add("QKY3XS3", "Ford24");
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys3=new ArrayList<String>();
        valuesOfGivenKeys3=ar3.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys3.size();i++)
            System.out.println(valuesOfGivenKeys3.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar3.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar3.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar3.size();i++)
        	System.out.println(ar3.getSequenceArray().get(i).key+"  "+ar3.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr3=ar3.previousCars("QKY3XSV");
        for(int i=0;i<arr3.size();i++)
        	System.out.println(arr3.get(i).key+" "+arr3.get(i).value);       
        System.out.println("==============remove=============================");
        ar3.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar3.size());
        System.out.println("==============allKeys============================");
        ar3.allKeys();
        for(int i=0;i<ar3.getArrayKeys().size();i++)
        	System.out.println(ar3.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar3.setKeyLength(7);
        ar3.generate(10);
        int l3=ar3.getKeysGenerated().size();
        for(int i=0;i<l3;i++)
        	System.out.println(ar3.getKeysGenerated().get(i));
        System.out.println("##################4th data set########################");
        SmartAR<String,String> ar4=new SmartAR<String,String>(9,7);
        Scanner keyboard4=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries4=keyboard4.nextInt();
        ar4.setThreshold(10);       
        ar4.setTotalEntries(totalEntries4);
        System.out.println("==============add=================================");
        ar4.add("QKY34SV", "Ford1");       
        ar4.add("QKY3XSV", "Ford2");       
        ar4.add("04MZRCD", "Ford3");
        ar4.add("8TYCJM8", "Ford4");
        ar4.add("THO2N8N", "Ford5");
        ar4.add("QGSZ5PZ", "Ford6");
        ar4.add("QKY3XSV", "Ford7");
        ar4.add("3EB6OWN", "Ford8");       
        ar4.add("THO2N8N", "Ford9");
        ar4.add("QKY3XSV", "Ford10");
        
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys4=new ArrayList<String>();
        valuesOfGivenKeys4=ar4.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys4.size();i++)
            System.out.println(valuesOfGivenKeys4.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar4.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar4.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar4.size();i++)
        	System.out.println(ar4.getSequenceArray().get(i).key+"  "+ar4.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr4=ar4.previousCars("QKY3XSV");
        for(int i=0;i<arr4.size();i++)
        	System.out.println(arr4.get(i).key+" "+arr4.get(i).value);       
        System.out.println("==============remove=============================");
        ar4.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar3.size());
        System.out.println("==============allKeys============================");
        ar4.allKeys();
        for(int i=0;i<ar4.getArrayKeys().size();i++)
        	System.out.println(ar4.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar4.setKeyLength(7);
        ar4.generate(10);
        int l4=ar4.getKeysGenerated().size();
        for(int i=0;i<l4;i++)
        	System.out.println(ar4.getKeysGenerated().get(i));
        
        System.out.println("##################5th data set########################");
        SmartAR<String,String> ar5=new SmartAR<String,String>(57,23);
        Scanner keyboard5=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries5=keyboard5.nextInt();
        ar5.setThreshold(100);       
        ar5.setTotalEntries(totalEntries5);
        System.out.println("==============add=================================");
        ar5.add("QKY34SV", "Ford1");       
        ar5.add("QKY3XSV", "Ford2");       
        ar5.add("04MZRCD", "Ford3");
        ar5.add("8TYCJM8", "Ford4");
        ar5.add("THO2N8N", "Ford5");
        ar5.add("QGSZ5PZ", "Ford6");
        ar5.add("QKY3XSV", "Ford7");
        ar5.add("3EB6OWN", "Ford8");       
        ar5.add("THO2N8N", "Ford9");
        ar5.add("QKY3XSV", "Ford10");
        ar5.add("QKY34SV", "Ford11");       
        ar5.add("QKY3XSV", "Ford12");       
        ar5.add("04MZRCD", "Ford13");
        ar5.add("8TYCJM8", "Ford14");
        ar5.add("THO2N8N", "Ford15");
        ar5.add("QGSZ5PZ", "Ford16");
        ar5.add("QKY3XSV", "Ford17");
        ar5.add("3EB6OWN", "Ford18");       
        ar5.add("THO2N8N", "Ford19");
        ar5.add("QKY3XSV", "Ford20");
        ar5.add("QKY34SV", "Ford21");       
        ar5.add("QKY3XSV", "Ford22");       
        ar5.add("04MZRCD", "Ford23");
        ar5.add("8TYCJM8", "Ford24");
        ar5.add("THO2N8N", "Ford25");
        ar5.add("QGSZ5PZ", "Ford26");
        ar5.add("QKY3XSV", "Ford27");
        ar5.add("3EB6OWN", "Ford28");       
        ar5.add("THO2N8N", "Ford29");
        ar5.add("QKY3XSV", "Ford30");
        ar5.add("QKY34SV", "Ford31");       
        ar5.add("QKY3XSV", "Ford32");       
        ar5.add("04MZRCD", "Ford33");
        ar5.add("8TYCJM8", "Ford34");
        ar5.add("THO2N8N", "Ford35");
        ar5.add("QGSZ5PZ", "Ford36");
        ar5.add("QKY3XSV", "Ford37");
        ar5.add("3EB6OWN", "Ford38");       
        ar5.add("THO2N8N", "Ford39");
        ar5.add("QKY3XSV", "Ford40");
        ar5.add("QKY34SV", "Ford41");       
        ar5.add("QKY3XSV", "Ford42");       
        ar5.add("04MZRCD", "Ford43");
        ar5.add("8TYCJM8", "Ford44");
        ar5.add("THO2N8N", "Ford45");
        ar5.add("QGSZ5PZ", "Ford46");
        ar5.add("QKY3XSV", "Ford47");
        ar5.add("3EB6OWN", "Ford48");       
        ar5.add("THO2N8N", "Ford49");
        ar5.add("QKY3XSV", "Ford50");
        ar5.add("QKY34SV", "Ford51");       
        ar5.add("QKY3XSV", "Ford52");       
        ar5.add("04MZRCD", "Ford53");
        ar5.add("8TYCJM8", "Ford54");
        ar5.add("THO2N8N", "Ford55");
        ar5.add("QGSZ5PZ", "Ford56");
        ar5.add("QKY3XSV", "Ford57");
        ar5.add("3EB6OWN", "Ford58");       
        ar5.add("THO2N8N", "Ford59");
        ar5.add("QKY3XSV", "Ford60");
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys5=new ArrayList<String>();
        valuesOfGivenKeys5=ar5.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys5.size();i++)
            System.out.println(valuesOfGivenKeys5.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar5.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar5.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar5.size();i++)
        	System.out.println(ar5.getSequenceArray().get(i).key+"  "+ar5.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr5=ar5.previousCars("QKY3XSV");
        for(int i=0;i<arr5.size();i++)
        	System.out.println(arr5.get(i).key+" "+arr5.get(i).value);       
        System.out.println("==============remove=============================");
        ar5.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar5.size());
        System.out.println("==============allKeys============================");
        ar5.allKeys();
        for(int i=0;i<ar5.getArrayKeys().size();i++)
        	System.out.println(ar5.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar5.setKeyLength(7);
        ar5.generate(10);
        int l5=ar5.getKeysGenerated().size();
        for(int i=0;i<l5;i++)
        	System.out.println(ar5.getKeysGenerated().get(i)); 
        
        System.out.println("##################6th data set########################");
        SmartAR<String,String> ar6=new SmartAR<String,String>(23,17);
        Scanner keyboard6=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries6=keyboard6.nextInt();
        ar6.setThreshold(500);       
        ar6.setTotalEntries(totalEntries6);
        System.out.println("==============add=================================");
        ar6.add("QKY34SV", "Ford1");       
        ar6.add("QKY3XSV", "Ford2");       
        ar6.add("04MZRCD", "Ford3");
        ar6.add("8TYCJM8", "Ford4");
        ar6.add("THO2N8N", "Ford5");
        ar6.add("QGSZ5PZ", "Ford6");
        ar6.add("QKY3XSV", "Ford7");
        ar6.add("3EB6OWN", "Ford8");       
        ar6.add("THO2N8N", "Ford9");
        ar6.add("QKY3XSV", "Ford10");
        ar6.add("QKY3XS2", "Ford11");
        ar6.add("QKY3XS3", "Ford12");
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys6=new ArrayList<String>();
        valuesOfGivenKeys6=ar6.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys6.size();i++)
            System.out.println(valuesOfGivenKeys6.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar6.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar6.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar6.size();i++)
        	System.out.println(ar6.getSequenceArray().get(i).key+"  "+ar6.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr6=ar6.previousCars("QKY3XSV");
        for(int i=0;i<arr6.size();i++)
        	System.out.println(arr6.get(i).key+" "+arr6.get(i).value);       
        System.out.println("==============remove=============================");
        ar6.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar6.size());
        System.out.println("==============allKeys============================");
        ar6.allKeys();
        for(int i=0;i<ar6.getArrayKeys().size();i++)
        	System.out.println(ar6.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar6.setKeyLength(7);
        ar6.generate(501);
        int l6=ar6.getKeysGenerated().size();
        for(int i=0;i<l6;i++)
        	System.out.println(ar6.getKeysGenerated().get(i));
        
        System.out.println("##################7th data set########################");
        SmartAR<String,String> ar7=new SmartAR<String,String>(17,13);
        Scanner keyboard7=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries7=keyboard7.nextInt();
        ar7.setThreshold(20);       
        ar7.setTotalEntries(totalEntries7);
        System.out.println("==============add=================================");
        ar7.add("QKY34SV", "Ford1");       
        ar7.add("QKY3XSV", "Ford2");       
        ar7.add("04MZRCD", "Ford3");
        ar7.add("8TYCJM8", "Ford4");
        ar7.add("THO2N8N", "Ford5");
        ar7.add("QGSZ5PZ", "Ford6");
        ar7.add("QKY3XSV", "Ford7");
        ar7.add("3EB6OWN", "Ford8");       
        ar7.add("THO2N8N", "Ford9");
        ar7.add("QKY3XSV", "Ford10");
        ar7.add("QKY3XS2", "Ford11");
        ar7.add("QKY3XS3", "Ford12");
        ar7.add("QKY34SV", "Ford12");       
        ar7.add("QKY3XSV", "Ford14");       
        ar7.add("04MZRCD", "Ford15");
        ar7.add("8TYCJM8", "Ford16");
        ar7.add("THO2N8N", "Ford17");
        ar7.add("QGSZ5PZ", "Ford18");
        ar7.add("QKY3XSV", "Ford19");
        ar7.add("3EB6OWN", "Ford20");       
        ar7.add("THO2N8N", "Ford21");
        ar7.add("QKY3XSV", "Ford22");
        ar7.add("QKY3XS2", "Ford23");
        ar7.add("QKY3XS3", "Ford24");
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys7=new ArrayList<String>();
        valuesOfGivenKeys7=ar7.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys7.size();i++)
            System.out.println(valuesOfGivenKeys7.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar7.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar7.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar7.size();i++)
        	System.out.println(ar7.getSequenceArray().get(i).key+"  "+ar7.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr7=ar7.previousCars("QKY3XSV");
        for(int i=0;i<arr7.size();i++)
        	System.out.println(arr7.get(i).key+" "+arr7.get(i).value);       
        System.out.println("==============remove=============================");
        ar7.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar7.size());
        System.out.println("==============allKeys============================");
        ar7.allKeys();
        for(int i=0;i<ar7.getArrayKeys().size();i++)
        	System.out.println(ar7.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar7.setKeyLength(7);
        ar7.generate(30);
        int l7=ar7.getKeysGenerated().size();
        for(int i=0;i<l7;i++)
        	System.out.println(ar7.getKeysGenerated().get(i));
        
        System.out.println("##################8th data set########################");
        SmartAR<String,String> ar8=new SmartAR<String,String>(17,13);
        Scanner keyboard8=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries8=keyboard8.nextInt();
        ar8.setThreshold(25);       
        ar8.setTotalEntries(totalEntries8);
        System.out.println("==============add=================================");
        ar8.add("QKY34SV", "Ford1");       
        ar8.add("QKY3XSV", "Ford2");       
        ar8.add("04MZRCD", "Ford3");
        ar8.add("8TYCJM8", "Ford4");
        ar8.add("THO2N8N", "Ford5");
        ar8.add("QGSZ5PZ", "Ford6");
        ar8.add("QKY3XSV", "Ford7");
        ar8.add("3EB6OWN", "Ford8");       
        ar8.add("THO2N8N", "Ford9");
        ar8.add("QKY3XSV", "Ford10");
        ar8.add("QKY3XS2", "Ford11");
        ar8.add("QKY3XS3", "Ford12");
        ar8.add("QKY34SV", "Ford12");       
        ar8.add("QKY3XSV", "Ford14");       
        ar8.add("04MZRCD", "Ford15");
        ar8.add("8TYCJM8", "Ford16");
        ar8.add("THO2N8N", "Ford17");
        ar8.add("QGSZ5PZ", "Ford18");
        ar8.add("QKY3XSV", "Ford19");
        ar8.add("3EB6OWN", "Ford20");       
        ar8.add("THO2N8N", "Ford21");
        ar8.add("QKY3XSV", "Ford22");
        ar8.add("QKY3XS2", "Ford23");
        ar8.add("QKY3XS3", "Ford24");
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys8=new ArrayList<String>();
        valuesOfGivenKeys8=ar8.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys8.size();i++)
            System.out.println(valuesOfGivenKeys8.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar8.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar8.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar8.size();i++)
        	System.out.println(ar8.getSequenceArray().get(i).key+"  "+ar8.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr8=ar8.previousCars("QKY3XSV");
        for(int i=0;i<arr8.size();i++)
        	System.out.println(arr8.get(i).key+" "+arr8.get(i).value);       
        System.out.println("==============remove=============================");
        ar8.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar8.size());
        System.out.println("==============allKeys============================");
        ar8.allKeys();
        for(int i=0;i<ar8.getArrayKeys().size();i++)
        	System.out.println(ar8.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar8.setKeyLength(7);
        ar8.generate(10);
        int l8=ar8.getKeysGenerated().size();
        for(int i=0;i<l8;i++)
        	System.out.println(ar8.getKeysGenerated().get(i));
        System.out.println("##################9th data set########################");
        SmartAR<String,String> ar9=new SmartAR<String,String>(9,7);
        Scanner keyboard9=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries9=keyboard9.nextInt();
        ar9.setThreshold(10);       
        ar9.setTotalEntries(totalEntries9);
        System.out.println("==============add=================================");
        ar9.add("QKY34SV", "Ford1");       
        ar9.add("QKY3XSV", "Ford2");       
        ar9.add("04MZRCD", "Ford3");
        ar9.add("8TYCJM8", "Ford4");
        ar9.add("THO2N8N", "Ford5");
        ar9.add("QGSZ5PZ", "Ford6");
        ar9.add("QKY3XSV", "Ford7");
        ar9.add("3EB6OWN", "Ford8");       
        ar9.add("THO2N8N", "Ford9");
        ar9.add("QKY3XSV", "Ford10");
        
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys9=new ArrayList<String>();
        valuesOfGivenKeys9=ar9.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys9.size();i++)
            System.out.println(valuesOfGivenKeys9.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar9.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar9.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar9.size();i++)
        	System.out.println(ar9.getSequenceArray().get(i).key+"  "+ar9.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr9=ar9.previousCars("QKY3XSV");
        for(int i=0;i<arr9.size();i++)
        	System.out.println(arr9.get(i).key+" "+arr9.get(i).value);       
        System.out.println("==============remove=============================");
        ar9.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar3.size());
        System.out.println("==============allKeys============================");
        ar9.allKeys();
        for(int i=0;i<ar9.getArrayKeys().size();i++)
        	System.out.println(ar9.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar9.setKeyLength(7);
        ar9.generate(10);
        int l9=ar9.getKeysGenerated().size();
        for(int i=0;i<l9;i++)
        	System.out.println(ar9.getKeysGenerated().get(i));
        
        System.out.println("##################10th data set########################");
        SmartAR<String,String> ar10=new SmartAR<String,String>(57,23);
        Scanner keyboard10=new Scanner(System.in);
        System.out.println("Enter the quantity of keys in GARO: ");
        int totalEntries10=keyboard10.nextInt();
        ar10.setThreshold(100);       
        ar10.setTotalEntries(totalEntries10);
        System.out.println("==============add=================================");
        ar10.add("QKY34SV", "Ford1");       
        ar10.add("QKY3XSV", "Ford2");       
        ar10.add("04MZRCD", "Ford3");
        ar10.add("8TYCJM8", "Ford4");
        ar10.add("THO2N8N", "Ford5");
        ar10.add("QGSZ5PZ", "Ford6");
        ar10.add("QKY3XSV", "Ford7");
        ar10.add("3EB6OWN", "Ford8");       
        ar10.add("THO2N8N", "Ford9");
        ar10.add("QKY3XSV", "Ford10");
        ar10.add("QKY34SV", "Ford11");       
        ar10.add("QKY3XSV", "Ford12");       
        ar10.add("04MZRCD", "Ford13");
        ar10.add("8TYCJM8", "Ford14");
        ar10.add("THO2N8N", "Ford15");
        ar10.add("QGSZ5PZ", "Ford16");
        ar10.add("QKY3XSV", "Ford17");
        ar10.add("3EB6OWN", "Ford18");       
        ar10.add("THO2N8N", "Ford19");
        ar10.add("QKY3XSV", "Ford20");
        ar10.add("QKY34SV", "Ford21");       
        ar10.add("QKY3XSV", "Ford22");       
        ar10.add("04MZRCD", "Ford23");
        ar10.add("8TYCJM8", "Ford24");
        ar10.add("THO2N8N", "Ford25");
        ar10.add("QGSZ5PZ", "Ford26");
        ar10.add("QKY3XSV", "Ford27");
        ar10.add("3EB6OWN", "Ford28");       
        ar10.add("THO2N8N", "Ford29");
        ar10.add("QKY3XSV", "Ford30");
        ar10.add("QKY34SV", "Ford31");       
        ar10.add("QKY3XSV", "Ford32");       
        ar10.add("04MZRCD", "Ford33");
        ar10.add("8TYCJM8", "Ford34");
        ar10.add("THO2N8N", "Ford35");
        ar10.add("QGSZ5PZ", "Ford36");
        ar10.add("QKY3XSV", "Ford37");
        ar10.add("3EB6OWN", "Ford38");       
        ar10.add("THO2N8N", "Ford39");
        ar10.add("QKY3XSV", "Ford40");
        ar10.add("QKY34SV", "Ford41");       
        ar10.add("QKY3XSV", "Ford42");       
        ar10.add("04MZRCD", "Ford43");
        ar10.add("8TYCJM8", "Ford44");
        ar10.add("THO2N8N", "Ford45");
        ar10.add("QGSZ5PZ", "Ford46");
        ar10.add("QKY3XSV", "Ford47");
        ar10.add("3EB6OWN", "Ford48");       
        ar10.add("THO2N8N", "Ford49");
        ar10.add("QKY3XSV", "Ford50");
        ar10.add("QKY34SV", "Ford51");       
        ar10.add("QKY3XSV", "Ford52");       
        ar10.add("04MZRCD", "Ford53");
        ar10.add("8TYCJM8", "Ford54");
        ar10.add("THO2N8N", "Ford55");
        ar10.add("QGSZ5PZ", "Ford56");
        ar10.add("QKY3XSV", "Ford57");
        ar10.add("3EB6OWN", "Ford58");       
        ar10.add("THO2N8N", "Ford59");
        ar10.add("QKY3XSV", "Ford60");
        System.out.println("==============getValues==========================");
        ArrayList<String> valuesOfGivenKeys10=new ArrayList<String>();
        valuesOfGivenKeys10=ar5.getValues("QKY3XSV");
        for(int i=0;i<valuesOfGivenKeys10.size();i++)
            System.out.println(valuesOfGivenKeys10.get(i));
        System.out.println("==============nextKey============================");
        System.out.println(ar10.nextKey("QKY34SV"));
        System.out.println("==============prevKey============================");
        System.out.println(ar10.prevKey("QKY3XSV"));
        System.out.println("==============output all the keys and values=====");
        for(int i=0;i<ar10.size();i++)
        	System.out.println(ar10.getSequenceArray().get(i).key+"  "+ar10.getSequenceArray().get(i).value); 
        System.out.println("==============previousCars=======================");
        ArrayList<Node<String,String>> arr10=ar10.previousCars("QKY3XSV");
        for(int i=0;i<arr10.size();i++)
        	System.out.println(arr10.get(i).key+" "+arr10.get(i).value);       
        System.out.println("==============remove=============================");
        ar10.remove("THO2N8N");
        System.out.println("==============size===============================");        
        System.out.println(ar10.size());
        System.out.println("==============allKeys============================");
        ar10.allKeys();
        for(int i=0;i<ar10.getArrayKeys().size();i++)
        	System.out.println(ar10.getArrayKeys().get(i));   
        System.out.println("==============generate============================");
        ar10.setKeyLength(7);
        ar10.generate(10);
        int l10=ar10.getKeysGenerated().size();
        for(int i=0;i<l10;i++)
        	System.out.println(ar10.getKeysGenerated().get(i)); 
    }
}
