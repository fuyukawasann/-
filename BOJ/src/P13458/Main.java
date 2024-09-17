package P13458;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// �Է� ���� -> �ݵ�� �ּ� ó��
		System.setIn(new FileInputStream("src/P13458/input.txt"));
		// �б�, ���� ���̺귯�� �ҷ�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N�� �޴´�.
		int N = Integer.parseInt(br.readLine());
		// �� ������ �� �ο��� �о��
		StringTokenizer A = new StringTokenizer(br.readLine());
		// B, C�� �̸� �о��
		StringTokenizer BC = new StringTokenizer(br.readLine());
		
		// B, C ����
		int B = Integer.parseInt(BC.nextToken());
		int C = Integer.parseInt(BC.nextToken());
		
		long count = 0;
		
		// A�� ���̻� ���� ������ ������
		while(A.hasMoreTokens()) {
			// A�� ������
			int Ai = Integer.parseInt(A.nextToken());
			// �ϴ� Ai - B�� ����( Ai�� ����)
			Ai -= B;
			// count�� 1 �ø�(�Ѱ�����)
			count++;
			// Ai�� 0���� �۰ų� ���� -> �Ѱ��������� �ذ�� -> �������� �ǳʶ�
			if(Ai <= 0) continue;
			// (double)Ai / C�� �� �� ceil ����� �ݿ� -> �ΰ����� ���� �ݿ�
			count += (long) Math.ceil((double)Ai / C);
		}
		
		// count�� �����
		System.out.println(count);

	}

}
