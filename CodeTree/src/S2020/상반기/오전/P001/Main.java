package S2020.��ݱ�.����.P001;

import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		// ���� �б�
		System.setIn(new FileInputStream("src/S2020/��ݱ�/����/P001/input.txt"));
		
		// ���̺귯��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// k�� �޴´�.
		int K = Integer.parseInt(br.readLine());
		
		// ��Ʈ���� ����
		map = new boolean[10][10];
		
		
		// ������ �����Ѵ�.
		int result = 0;
		
		for(int k = 0; k < K; k++) {
			// ������ �޴´�.
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			// ������� ���� ó���Ѵ�.
			// 1. Ÿ���� ��ġ�Ѵ�. - X�� 4���� 9�� Ȯ���ϰ� ���ʷ� true�� ������ �������� ���� ������ ��ǥ�� true�� ����� break�Ѵ�.
			// 1-1. Type 1�� ��
			if(T == 1) {
				boolean isFilled = false;
				for(int i = 5; i <= 9; i++) {
					if(map[i][Y]) {
						map[i - 1][Y] = true;
						isFilled = true;
						break;
					}
				}
				// ���� �� ���Ҵµ��� ä������ �ʾҴٸ� 9�� row�� ä�� ����
				if(!isFilled) map[9][Y] = true;
			}
			// 1-2. Type 2�� ��
			else if(T == 2) {
				boolean isFilled = false;
				for(int i = 5; i <= 9; i++) {
					if(map[i][Y] || map[i][Y + 1]) {
						map[i - 1][Y] = true;
						map[i - 1][Y + 1] = true;
						isFilled = true;
						break;
					}
				}
				// ���� �� ���Ҵµ��� ä������ �ʾҴٸ� 9�� row�� ä�� ����
				if(!isFilled) {
					map[9][Y] = true;
					map[9][Y + 1] = true;
				}
			}
			// 1-3. Type 3�� ��
			else {
				boolean isFilled = false;
				for(int i = 5; i <= 9; i++) {
					if(map[i][Y]) {
						map[i - 2][Y] = true;
						map[i - 1][Y] = true;
						isFilled = true;
						break;
					}
				}
				// ���� �� ���Ҵµ��� ä������ �ʾҴٸ� 9��, 8�� row�� ä�� ����
				if(!isFilled) {
					map[9][Y] = true;
					map[8][Y] = true;
				}
			}
			// 2. ��� �κе��� Ȯ���ϸ� ���� ���� �ִٸ� result�� �����ϰ� ������ �Ʒ��ٷ� ������.
			for(int x = 9; x >= 4; x--) {
				// 2-1. �� á���� result�� ������Ų��.
				while(map[x][0] && map[x][1] && map[x][2] && map[x][3]) {
					result++;
					// 2-1-1. map�� �Ʒ��� ����.
					for(int i = x - 1; i >= 3; i--) {
						for(int j = 0; j < 4; j++) {
							map[i + 1][j] = map[i][j];
						}
					}
				}
			}
			// 3. ���� �κп� Ÿ���� �ִٸ� Ÿ�� ������ ������ �̷�
			while(map[5][0] || map[5][1] || map[5][2] || map[5][3]) {
				for(int i = 8; i >= 3; i--) {
					for(int j = 0; j < 4; j++) {
						map[i + 1][j] = map[i][j];
					}
				}
			}
			
			// �������� ó���Ѵ�.
			// 1. Ÿ���� ��ġ�Ѵ�.
			// 1-1. Type 1�� ��
			if(T == 1) {
				boolean isFilled = false;
				for(int i = 5; i <= 9; i++) {
					if(map[X][i]) {
						map[X][i - 1] = true;
						isFilled = true;
						break;
					}
				}
				// ���� �� ���Ҵµ��� ä������ �ʾҴٸ� 9�� row�� ä�� ����
				if(!isFilled) map[X][9] = true;
			}
			// 1-2. Type 2�� ��
			else if(T == 2) {
				boolean isFilled = false;
				for(int i = 5; i <= 9; i++) {
					if(map[X][i]) {
						map[X][i - 2] = true;
						map[X][i - 1] = true;
						isFilled = true;
						break;
					}
				}
				// ���� �� ���Ҵµ��� ä������ �ʾҴٸ� 9��, 8�� column�� ä�� ����
				if(!isFilled) {
					map[X][9] = true;
					map[X][8] = true;
				}
			}
			// 1-3. Type 3�� ��
			else {
				boolean isFilled = false;
				for(int i = 5; i <= 9; i++) {
					if(map[X][i] || map[X + 1][i]) {
						map[X][i - 1] = true;
						map[X + 1][i - 1] = true;
						isFilled = true;
						break;
					}
				}
				// ���� �� ���Ҵµ��� ä������ �ʾҴٸ� 9�� column�� ä�� ����
				if(!isFilled) {
					map[X][9] = true;
					map[X + 1][9] = true;
				}
			}
			// 2. ���� �κе��� Ȯ���ϸ� ���� column�� �ִٸ� result�� �����ϰ� �������� �������ٷ� �ű��.
			for(int y = 9; y >= 4; y--) {
				// 2-1. �� á���� result�� ������Ų��.
				while(map[0][y] && map[1][y] && map[2][y] && map[3][y]) {
					result++;
					// 2-1-1. map�� �Ʒ��� ����.
					for(int i = y - 1; i >= 3; i--) {
						for(int j = 0; j < 4; j++) {
							map[j][i + 1] = map[j][i];
						}
					}
				}
			}
			// 3. ���� �κп� Ÿ���� �ִٸ� Ÿ�� ������ ������ �̷�
			while(map[0][5] || map[1][5] || map[2][5] || map[3][5]) {
				for(int i = 8; i >= 3; i--) {
					for(int j = 0; j < 4; j++) {
						map[j][i + 1] = map[j][i];
					}
				}
			}
			
			// map ���
//			System.out.println("Query #" + k);
//			System.out.println("result: " + result);
//			printMap();
		}
		
		// ����� �Է��Ѵ�.
		StringBuilder sb = new StringBuilder();
		// ���� �Է�
		sb.append(result).append("\n");
		// Ÿ�� ���� �Է�
		// ��� �� + ������ Ÿ�� �� �Է�
		int tile = 0;
		for(int i = 6; i < 10; i++) {
			for(int j = 0; j < 4; j++) {
				if(map[i][j]) tile++;
				if(map[j][i]) tile++;
			}
		}
		sb.append(tile).append("\n");
		
		// ��� ���
		bw.write(sb.toString());
		bw.flush();
		
		
		// �ڿ� ��ȯ
		bw.close();
		br.close();
	}
	
	static void printMap() {
		// x 0 ~ 3
		
		StringBuilder printout = new StringBuilder();
		
		// x: 0 ~ 3
		for(int i = 0; i <= 3; i++) {
			for(int j = 0; j <= 9; j++) {
				if(map[i][j]) printout.append(1).append(" ");
				else printout.append(0).append(" ");
			}
			printout.append("\n");
		}
		
		// x: 4 ~ 9
		for(int i = 4; i <= 9; i++) {
			for(int j = 0; j <= 3; j++) {
				if(map[i][j]) printout.append(1).append(" ");
				else printout.append(0).append(" ");
			}
			printout.append("\n");
		}
		
		System.out.println(printout.toString());
	}

}
