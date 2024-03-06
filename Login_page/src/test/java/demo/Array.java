package demo;

public class Array {

	public static void main(String[] args) 
	{
		int []arr = {1,2,3,4,5,6,7,8,9,10,11};
		int []arr2 = new int[arr.length];
		int k=0;
		for(int i=0;i<arr.length-1;i++)
		{
			int count=0;
			for(int j=1;j<=arr[i];j++)
			{
				if(arr[i]%j==0)
				{
					count++;
				}
			}
			if(count==2)
			{
				arr2[k]=arr[i];
				k++;
			}
		}
		for(int i=0;i<arr2.length;i++)
		{
			if(arr2[i]==0)
				continue;
			else
			System.out.print(arr2[i] + " ");
		}
	}
}
