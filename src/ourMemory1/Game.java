package ourMemory1;

import java.util.Random;

public class Game {
	
	String[] c = {"�ѱ�","�߱�","�Ϻ�"};
	String[] s = {"�ǰ�","��Ű","���ǵ彺������","��ƮƮ��","���̷���"};
	int[] �ѱ� = new int[5];	//�� ����
	int[] �߱� = new int[5];
	int[] �Ϻ� = new int[5];
	
	String[][] sr = new String[3][5];	//���� ��ŷ	����*����
	int[][] m = new int[3][3];	//�޴ް��� / �� �� �� /�� �� ��	����*�޴ް���
	int[] r = new int[3];	//�ѱ�, �߱�, �Ϻ� / 1�� 0��, 2�� 1��, 3�� 2��
	
	String[] result = new String[3];	//�������
	
	Random rd = new Random();
	
	public Game() {
		gameStart();
		gameResult();
	}
	
	public void gameStart() {	//���� ����, ��ŷ ����
		for (int i = 0; i < s.length; i++) {
			�ѱ�[i] = scoreSet(i);
			�߱�[i] = scoreSet(i);
			�Ϻ�[i] = scoreSet(i);
			if(�ѱ�[i]==�߱�[i] || �߱�[i]==�Ϻ�[i] || �Ϻ�[i]==�ѱ�[i]) {
				i--;
			}
			if (�ѱ�[i] > �߱�[i] && �ѱ�[i] > �Ϻ�[i]) {
				medalSet(0, 0);
				if (�߱�[i] > �Ϻ�[i]) {
					sportsRankSet(i, "�ѱ�", "�߱�", "�Ϻ�");
					rankSet(3, 2, 1);
					medalSet(1, 1);
					medalSet(2, 2);
					
				} else {
					sportsRankSet(i, "�ѱ�", "�Ϻ�", "�߱�");
					rankSet(3, 1, 2);
					medalSet(1, 2);
					medalSet(2, 1);
				}
			} else if (�߱�[i] > �ѱ�[i] && �߱�[i] > �Ϻ�[i]) {
				medalSet(1, 0);
				if (�ѱ�[i] > �Ϻ�[i]) {
					sportsRankSet(i, "�߱�", "�ѱ�", "�Ϻ�");
					rankSet(2, 3, 1);
					medalSet(0, 1);
					medalSet(2, 2);
				} else {
					sportsRankSet(i, "�߱�", "�Ϻ�", "�ѱ�");
					rankSet(1, 3, 2);
					medalSet(0, 2);
					medalSet(2, 1);
				}
			} else {
				medalSet(2, 0);
				if (�ѱ�[i] > �߱�[i]) {
					sportsRankSet(i, "�Ϻ�", "�ѱ�", "�߱�");
					rankSet(2, 1, 3);
					medalSet(0, 1);
					medalSet(1, 2);
				} else {
					sportsRankSet(i, "�Ϻ�", "�߱�", "�ѱ�");
					rankSet(1, 2, 3);
					medalSet(0, 2);
					medalSet(1, 1);
				} // end innerIF()
			} // end outerIF()
		} // end FOR()
	}//end gameStart();
	
	public int scoreSet(int i) {
		return rd.nextInt(35)+rd.nextInt(30)+rd.nextInt(30);
	}
	
	public void sportsRankSet(int i,String gold, String silver, String bronze) {
		sr[0][i]=gold;
		sr[1][i]=silver;
		sr[2][i]=bronze;
	}
	
	public void rankSet(int a, int b, int c) {
		r[0]+=a;
		r[1]+=b;
		r[2]+=c;
	}
	
	public void medalSet(int a, int b) {
		m[a][b]+=1;
	}
	
	public void gameResult() {
		System.out.println("������ ���� ���");
		rankPrint();
		
		System.out.println("\n������ �޴� �� ���");	
		medalCount();
		
		System.out.println("\n���� ��� ���");	
		rankFinal();
	}
	
	public void rankPrint() {
		System.out.println("����");
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]+":"+r[i]+"��");
		}
		result[0] = c[0];
		if(r[0]<r[1]) {
			result[1]=result[0];
			result[0]=c[1];
			if(r[1]<r[2]) {
				result[2]=result[1];
				result[1]=result[0];
				result[0]=c[2];
			}else {
				if(r[2]>r[0]) {
					result[2]=result[1];
					result[1]=c[2];
				}else {
					result[2]=c[2];
				}
			}
		}else {
			result[1]=c[1];
			if(r[1]<r[2]) {
				result[2]=result[1];
				result[1]=c[2];
			}else {
				result[2]=c[2];
			}
		}
	}
	
	public void medalCount() {
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]+":�� "+m[i][0]+"��\t");
			System.out.print(c[i]+":�� "+m[i][1]+"��\t");
			System.out.print(c[i]+":�� "+m[i][2]+"��\t=");
			System.out.println(m[i][0]*3+m[i][1]*2+m[i][2]*1);
		}
	}
	
	public void rankFinal() {
		System.out.println("1�� : "+result[0]+"\t\t2�� : "+result[1]+"\t\t3�� : "+result[2]);
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
