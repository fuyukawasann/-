package P7569;

import java.io.*;
import java.util.*;

public class Main {

	static int M, N, H; // M: ����, N: ����, H: ����
	
	static int[][][] box;
	static ArrayDeque<tomato> queue;
	
	// ������ - ��, ��, ��, ��, ��ĭ, �Ʒ�ĭ
	static int[] dn = {-1, 1, 0, 0, 0, 0}, dm = {0, 0, -1, 1, 0, 0}, dh = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		// ���� �����
		System.setIn(new FileInputStream("src/P7569/input.txt"));
		
		// ���̺귯��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// M, N, H�� �޴´�.
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// �迭 ����
		box = new int[H][N][M];
		queue = new ArrayDeque<>();
		
		// ���ڸ� ä���.
		boolean isAlreadyRoten = true;
		
		for(int h = 0; h < H; h++)
		{
			for(int n = 0; n < N; n++)
			{
				st = new StringTokenizer(br.readLine());
				
				for(int m = 0; m < M; m++)
				{
					box[h][n][m] = Integer.parseInt(st.nextToken());
					
					// 0�̶�� �� ���� �� �����Ƿ� isAlreadyRoten�� false
					if(box[h][n][m] == 0) isAlreadyRoten = false;
					
					// 1�̶�� ť�� �ִ´�.
					if(box[h][n][m] == 1) queue.offer(new tomato(m, n, h, 0));
				}
			}
		}
		
		
		// ���� �� ���� �丶�䰡 ���� ���� bfs�� ����
		StringBuilder sb = new StringBuilder();
		if(isAlreadyRoten) {
			sb.append(0).append("\n");
		}
		else
		{
			int result = bfs();
			
			// ���ڵ��� ���鼭 ���� �� ���� ���� �ִ��� Ȯ��
			boolean isntRoten = false;
			for(int h = 0; h < H; h++)
			{
				for(int n = 0; n < N; n++)
				{
					for(int m = 0; m < M; m++)
					{
						if(box[h][n][m] == 0)
						{
							isntRoten = true;
							break;
						}
					}
					
					if(isntRoten) break;
				}
				
				if(isntRoten) break;
			}
			
			// �� ������ ������ -1�� ���
			if(isntRoten) sb.append(-1).append("\n");
			else sb.append(result).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		// �ڿ� ��ȯ
		bw.close();
		br.close();	

	}
	
	static int bfs()
	{
		int day = 0;
		
		
		while(!queue.isEmpty())
		{
			// 1. ť���� ������.
			tomato t = queue.poll();
			day = t.day;
			
			// 2. ������ �ΰ�?
			// 3. ��ȸ�Ѵ�.
			for(int i = 0; i < 6; i++)
			{
				int nn = t.n + dn[i], nm = t.m + dm[i], nh = t.h + dh[i];
				// 4. �� �� �ִ°�?
				if(0 <= nn && nn < N && 0 <= nm && nm < M && 0 <= nh && nh < H)
				{
					if(box[nh][nn][nm] == 0)
					{
						// 5. üũ��
						box[nh][nn][nm] = 1;
						// 6. ť�� �ִ´�.
						queue.offer(new tomato(nm, nn, nh, day + 1));
					}
				}
				
			}
			
		}
		
		
		
		return day;
	}

}

class tomato
{
	int m, n, h, day;
	
	public tomato(int m, int n, int h, int day)
	{
		this.m = m;
		this.n = n;
		this.h = h;
		this.day = day;
	}
}