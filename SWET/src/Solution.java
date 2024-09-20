package P1979;

import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		// ���� �б�
		System.setIn(new FileInputStream("src/P1979/input.txt"));
		// ���̺귯��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// ���� ó��
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			// N�� K�� �޴´�.
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
			
			// ��ĭ�� �޴´�.
			int[][] blank = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					blank[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1�� ���� Ž���� �Ѵ�.
			int result = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 0�� ���� �ǳʶڴ�.
					if(blank[i][j] == 0) continue;
					
					// 1�� ���� Ž���Ѵ�.
					// 1. ������ Ž��
					// 1) ���� �������� �� �� �ִٸ� �� ������ �ܾ� �������� �ƴ�
					// ������ �� ���� ��
					boolean rightValid = true;
					if(0 <= j - 1 && j - 1 < N) {
						// 1�̸� ��ȿ���� ����
						if(blank[i][j - 1] == 1) rightValid = false;
					}
					// 2) �ƴϸ� ���������� 1�� �� �� �ִ��� Ž��
					int count = 1;
					if(rightValid) {
						// ������ �� ������ ���ų� 0�� ���� ������ ����.
						int x = j + 1;
						while(x < N) {
							// 0���� Ȯ���ϰ� 0�̸� break
							if(blank[i][x] == 0) break;
							// 1�̸� count�� �ø��� x ������Ʈ
							count++;
							x++;
						}
					}
					// count�� k�� ���ٸ� result�� �ø�
					if(count == K) result++;
					// 2. �Ʒ��� Ž��
					// 1) ���� �������� �� �� �ֵ��� �� ������ �ܾ� �������� �ƴ�
					boolean underValid = true;
					// ������ �� ���� ��
					if(0 <= i - 1 && i - 1 < N) {
						// 1�̸� ��ȿ���� ����
						if(blank[i - 1][j] == 1) underValid = false;
					}
					// 2) �ƴϸ� �Ʒ������� 1�� �� �� �ִ��� Ž��
					count = 1;
					if(underValid) {
						// �Ʒ������� ������ ���ų� 0�� ���� ������ ����.
						int y = i + 1;
						while(y < N) {
							// 0���� Ȯ���ϰ� 0�̸� break
							if(blank[y][j] == 0) break;
							// 1�̸� count�� �ø��� y ������Ʈ
							count++;
							y++;
						}
					}
					// count�� K�� ���ٸ� result�� �ø�
					if(count == K) result++;
				}
			}
			
			// ���� �Է�
			sb.append(result).append("\n");
			
			// ���� ���
			bw.write(sb.toString());
			bw.flush();
			
		}
		
		// �ڿ� ��ȯ
		bw.close();
		br.close();

	}

}
