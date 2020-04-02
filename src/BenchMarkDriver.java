import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class BenchMarkDriver 
{

	public static void main(String[] args) 
	{		
		Scanner inputF=null;
		SmartAR<String,String> ar=new SmartAR<String,String>(101,97);
		/*int lines=0;
		try
		{
			inputF=new Scanner(new FileInputStream("ar_test_file1.txt"));
			
		 	  //the while-loop check the end of a file.
		 	  while(inputF.hasNextLine())
		 	  {	      
		 	    lines++;
		 	  }
		       inputF.close();	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}*/
		//the above code can find the total items in the txt file.However, it slow down the execution time.
		//Here, set the totalEntries directly.
		ar.setTotalEntries(10000);
		ar.setThreshold(500);
		try
		{
			inputF=new Scanner(new FileInputStream("ar_test_file1.txt"));
			String line=null;
		 	  //the while-loop check the end of a file.
		 	  while(inputF.hasNextLine())
		 	  {	      
		 	    line=inputF.nextLine();
		 	    ar.add(line, "Ford");
		 	  }
		       inputF.close();	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		System.out.println("==========Get the size====================");
		System.out.println(ar.size());			
		System.out.println("==========nextKey==========================");
		System.out.println(ar.nextKey("QUV3EG"));
		System.out.println("==========prevKey==========================");
		System.out.println(ar.prevKey("QUV3EG"));
		System.out.println("==========previousCars=====================");
		ArrayList<Node<String,String>> arr=ar.previousCars("QUV3EG");
        for(int i=0;i<arr.size();i++)       
        	System.out.println(arr.get(i).key+" "+arr.get(i).value);       		
		System.out.println("==========allKeys==========================");
		ar.allKeys();
		int size=ar.getArrayKeys().size();
        for(int i=0;i<size;i++)       
        	System.out.println(ar.getArrayKeys().get(i));       		
	}

}
