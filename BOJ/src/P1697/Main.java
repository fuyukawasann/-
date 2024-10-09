package P1697;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	public int position;		// ���� ����
	public int time;			// �Һ� �ð�

	public Node (int position, int time) {
		this.position = position;
		this.time = time;
	}

	public int compareTo(Node n) {
		return this.time - n.time;
	}
}

public class Main {
	static int n, k;				// �������� ���� ���� n, ��ǥ ���� ���� k
	static int minTime;				// ���, �ּ� �ð�

	static final int MAX_POSITION = 100_000;
	static final int INF = 100_000;
	static int[] time = new int[MAX_POSITION + 1];
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	static void dijkstra() {
		// ��� �迭, �켱���� ť �ʱ�ȭ
		Arrays.fill(time, INF);
		time[n] = 0;
		pq.add(new Node(n, 0));

		while (!pq.isEmpty()) {
			Node current = pq.remove();

			// �̹� ���ŵ� time[] �� ����
			if (time[current.position] < current.time)
				continue;

			int np1 = current.position - 1;
			// ������� ���ŵ� ���� ��η� ���� ���� ���� �ּ� �ð� time[np1]
			// > ���� ���� Ž���ϴ� ��η� ���� ���� ���� �ð� current.time + 1
			if (isValid(np1) && time[np1] > current.time + 1) {
				time[np1] = current.time + 1;
				pq.add(new Node(np1, time[np1]));
			}

			int np2 = current.position + 1;
			if (isValid(np2) && time[np2] > current.time + 1) {
				time[np2] = current.time + 1;
				pq.add(new Node(np2, time[np2]));
			}

			int np3 = current.position * 2;
			if (isValid(np3) && time[np3] > current.time) {
				time[np3] = current.time;			// x 2 ���� �̵��� �ð� �״��
				pq.add(new Node(np3, time[np3]));
			}
		}
	}

	static boolean isValid(int position) {
		return 0 <= position && position <= MAX_POSITION;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n >= k)
			minTime = n - k;	// -1 ĭ�� n-k �� �̵��ϴ� �� ����
		else {
			dijkstra();
			minTime = time[k];
		}

		System.out.println(minTime);
	}
}