package silver;

import java.util.Scanner;

public class B24060S {
	static int tmp[] = new int[500000];
	
	static void mergeSort(int[] arr, int p, int r, int[] ret)
	{
		if(p < r)
		{
			int q = (p + r) / 2;
			mergeSort(arr, p, q, ret);
			mergeSort(arr, q + 1, r, ret);
			merge(arr, p, q, r, ret);
		}
		return;
	}
	
	static void merge(int[] arr, int p, int q, int r, int[] ret)
	{
		int i = p, j = q + 1, t = 0;
		
		while(i <= q && j <= r)
		{
			if(arr[i] <= arr[j])
				tmp[t++] = arr[i++];
			else
				tmp[t++] = arr[j++];
		}
		while(i <= q)
			tmp[t++] = arr[i++];
		while(j <= r)
			tmp[t++] = arr[j++];
		i = p;
		t = 0;
		while(i <= r)
		{
			arr[i++] = tmp[t++];
			ret[1]++; //저장될 때마다 횟수 세기
			if(ret[1] == ret[0]) ret[2] = arr[i - 1];
			// 찾으려는 k번째의 경우임. 이 때 저장된 값 ret[2]에 저장
		}
		return ;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		int ret[] = new int[3]; //ret[0]에 k, ret[1]에서는 저장 횟수 세기, ret[2]에서는 저장 횟수와 k 비교하여 같은 경우 리턴 값 저장
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		ret[0] = k;
		mergeSort(arr, 0, n - 1, ret);
		if(ret[0] > ret[1]) System.out.println("-1");
		else System.out.println(ret[2]);
		sc.close();
	}
}
