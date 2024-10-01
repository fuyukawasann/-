package P2252;

import java.io.*;
import java.util.*;

public class Main {

	static int[] indegree;
	static ArrayList<Integer>[] arrList;
	
	public static void main(String[] args) throws Exception {
		// ���� �б�
		System.setIn(new FileInputStream("src/P2252/input.txt"));
		
		// ���̺귯��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// N, M
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// indegree�� arrList ����
		indegree = new int[N + 1];
		arrList = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arrList[i] = new ArrayList<>();
		}
		
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			indegree[B]++;
			arrList[A].add(B);
		}
		
		bw.write(topologicalSort(N));
		bw.flush();
		bw.close();
		br.close();

	}
	
	static String topologicalSort(int num) {
		StringBuilder sb = new StringBuilder();
		
		// ť�� �����Ѵ�.
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		// indegree�� 0�� �͵��� ��´�.
		for(int i = 1; i <= num; i++) {
			if(indegree[i] == 0) queue.offer(i);
		}
		
		
		while(!queue.isEmpty()) {
			// 1. ť���� ������.
			int now = queue.poll();
			// 2. ��Ʈ�� ������ �ִ´�.
			sb.append(now).append(" ");
			// 3. ���� ����Ʈ�� ��ȸ�Ѵ�.
			for(int next : arrList[now]) {
				// 4. ���� ����Ʈ�� indegree�� �����Ѵ�.
				indegree[next]--;
				// 5. indegree�� 0�̸� ť�� �ִ´�.
				if(indegree[next] == 0) {
					queue.offer(next);
				}
			}
			
		}
		
		// ������ ��ȯ�Ѵ�.
		sb.append("\n");
		return sb.toString();
	}

}
