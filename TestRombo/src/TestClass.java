
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class TestClass
{
	
	public static void main(String[] args)
	{
//		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> alA = new ArrayList<Integer>(), alB = new ArrayList<Integer>();
//		al.add(new Integer(-1));
		alB.add(new Integer(-1));
		alA.add(new Integer(-1));
//		int ind = -1;
		int lastMed = 10000;
		
		Scanner scan = new Scanner(System.in);
		int N;
		N = Integer.parseInt(scan.nextLine());
		int i=1;
		for(; i<=N;i++)
		{
			String t = scan.nextLine().split(" ")[0];
			int num = Integer.parseInt(t);
			if(num < lastMed)
			{
				if(alA.size() == alB.size()+1)
				{
					alA.set(1,alA.get(alA.size()-1));
					alA.remove(alA.size()-1);
					heapifyDown(alA, 1, false);
					
					alB.add(lastMed);
					heapifyUp(alB,alB.size()-1,true);
				}
				alA.add(new Integer(num));
				heapifyUp(alA,alA.size()-1,false);
			}
			else
			{
				if(alB.size() == alA.size()+1)
				{
					alB.set(1,alB.get(alB.size()-1));
					alB.remove(alB.size()-1);
					heapifyDown(alB,1,true);
					
					alA.add(lastMed);
					heapifyUp(alA,alA.size()-1,false);
				}
				alB.add(new Integer(num));
				heapifyUp(alB,alB.size()-1,true);
			}
			if(alA.size() == alB.size())
			{
				System.out.println( 0.5*(alA.get(1) + alB.get(1)) );
			}
			else 
			{
				if(alA.size() > alB.size())
					lastMed = alA.get(1);
				else
					lastMed = alB.get(1);
				
				System.out.println(String.format(Locale.US,"%.1f",lastMed*1.0f));
			}
			
			
			
		}
//		
//		
		
	}
	
	public static void heapifyDown(ArrayList<Integer> al,int i,boolean minHeap)
	{
		if(i > 0.5 * (al.size()-1)  )
			return;
		int iMax =i, max = al.get(i);
		
		if( (!minHeap && al.get(2*i) > al.get(i)) || (minHeap && al.get(2*i) < al.get(i))  )
		{
			iMax = 2*i;
			max = al.get(2*i);
		}
		if(2*i+1 < al.size() && ((!minHeap && al.get(2*i+1) > max) ||  (minHeap && al.get(2*i+1) < max)))
		{
			iMax = 2*i+1;
			max = al.get(2*i+1);
		}
		if(al.get(i) != max)
		{
			Integer t = al.get(i);
			al.set(i,al.get(iMax));
			al.set(iMax,t);
			heapifyDown(al,iMax,minHeap);
		}
		
	}
	
	public static void heapifyUp(ArrayList<Integer> al,int i,boolean minHeap) //se minheap è true 
	{
		
		if(i==1)
			return;
		int iMax=i,max = al.get(i);
		
		if( (minHeap && al.get((int)(0.5*i)) > max) || (!minHeap && al.get((int)(0.5*i)) < max ))
		{
			Integer t = al.get(i);
			al.set(i,al.get((int)(0.5 * i)));
			al.set((int)(0.5 * i),t);
			heapifyUp(al,(int)(0.5*i),minHeap);
		}
		
	}
	
}













