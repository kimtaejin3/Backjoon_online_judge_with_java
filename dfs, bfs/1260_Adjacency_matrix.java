import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	/*인접행렬로 구현*/
	private static int[][] array;
	private static int[] check;
	private static int n, m, v;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		int x,y=-1;
		
		array = new int[n+1][n+1];
		check = new int[n+1];
		
		for(int i=0; i<m; i++) {
			String edge = br.readLine();
			StringTokenizer st1 = new StringTokenizer(edge, " ");
			x = Integer.parseInt(st1.nextToken());
			y = Integer.parseInt(st1.nextToken());
			
			array[x][y]=1;
			array[y][x]=1;
		}
		dfs(v);
		System.out.println();
		Arrays.fill(check, 0);
		bfs(v);
	}
	
	private static void dfs(int s) {
		
		check[s] = 1;
		System.out.print(s+" ");
		for(int i=1; i<=n; i++)
		{
			if(array[s][i]==1&&check[i]!=1) {
				dfs(i);
			}
		}
		
	}
	
	private static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		check[s]=1;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			
			System.out.print(temp+" ");
			for(int k=1; k<=n; k++) {
				if(array[temp][k]==1 && check[k]!=1) {
					q.offer(k);
					check[k] = 1;
				}
			}
		}
		
	}
} 
















