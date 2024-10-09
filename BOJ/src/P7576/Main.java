package P7576;

import java.io.*;
import java.util.*;

public class Main {
	
	static int W, H;
	

	static int[][] map;
	static ArrayDeque<Roten> queue;
	
	// ������ - ��, ��, ��, ��
	static int[] dw = {0, 0, -1, 1}, dh = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		// ���� �б�
		System.setIn(new FileInputStream("src/P7576/input.txt"));
		
		// ���̺귯��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// W, H�� �޴´�.
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// �迭 ����
		map = new int[H][W];
		queue = new ArrayDeque<>();
		
		// ������ �޴´�.
		// �̹� �丶�䰡 �;����� Ȯ���ؾ� ��;;
		boolean isAlreadyRoten = true;
		for(int h = 0; h < H; h++)
		{
			st = new StringTokenizer(br.readLine());
			for(int w = 0; w < W; w++)
			{
				map[h][w] = Integer.parseInt(st.nextToken());
				
				// ���� 1�̸� tomato�� �ִ´�.
				if(map[h][w] == 1) queue.offer(new Roten(w, h, 0));
				
				// ���� 0�̶�� ���� ���� �丶�䰡 �ִ� ���̴�.
				if(map[h][w] == 0) isAlreadyRoten = false;
			}
		}
		
		// ���� �丶�� ��ġ���� ���� �� �ִ� �͵��� �Ǵ��Ѵ�.
		int result = bfs();
		
		// ������ ��ȸ�ϸ� ���� ū ���� ã�´�
		// �ٵ� 0�� ���� �ִٸ� �װ͵� üũ�Ѵ�.
		boolean isntRoten = false;
		for(int h = 0; h < H; h++)
		{
			for(int w = 0; w < W; w++)
			{
				if(map[h][w] == 0) isntRoten = true;
			}
		}
		
		// �̹� ����ä�� �����ߴٸ� 0�� ����Ѵ�.
		StringBuilder sb = new StringBuilder();
		if(isAlreadyRoten) sb.append(0).append("\n");
		// Ž�� �� �� ���� ���� �ִٸ� -1�� ����Ѵ�.
		else if(isntRoten) sb.append(-1).append("\n");
		// �� �ܿ��� �� ���� �Ŵϱ� �ִ� -1�� ����Ѵ�.(��¥�� ����)
		else sb.append(result).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		
		
		// �ڿ� ��ȯ
		bw.close();
		br.close();

	}
	
	static int bfs()
	{
		int day = 0;
		
		// ť�� �� ������ �����Ѵ�.
		while(!queue.isEmpty())
		{
			// 1. ť���� ������.
			Roten now = queue.poll();
			day = now.day;
			// 2. �������ΰ�? - ���⼭�� �������� ����.
			// 3. ��ȸ�Ѵ�.
			for(int i = 0; i < 4; i++)
			{
				int nw = now.w + dw[i];
				int nh = now.h + dh[i];
				// 4. �� �� �ִ°�? - ���� �ȿ� �ְ� �湮���� �ʾҴ���
				if(0 <= nw && nw < W && 0 <= nh && nh < H)
				{
					if(map[nh][nw] == 0)
					{
						// 5. üũ��
						map[nh][nw] = 1;
						// 6. ť�� �ִ´�
						queue.offer(new Roten(nw, nh, now.day + 1));
						
					}
				}
				
			}
			
		}
		
		return day;
	}

}

class Roten
{
	int w, h, day;
	
	public Roten(int w, int h, int day)
	{
		this.w = w;
		this.h = h;
		this.day = day;
	}
}
