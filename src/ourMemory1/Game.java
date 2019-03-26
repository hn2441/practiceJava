package ourMemory1;

import java.util.Random;

public class Game {
	
	String[] c = {"한국","중국","일본"};
	String[] s = {"피겨","스키","스피드스케이팅","쇼트트랙","스켈레톤"};
	int[] 한국 = new int[5];	//각 점수
	int[] 중국 = new int[5];
	int[] 일본 = new int[5];
	
	String[][] sr = new String[3][5];	//종목별 랭킹	국가*종목
	int[][] m = new int[3][3];	//메달개수 / 한 중 일 /금 은 동	국가*메달개수
	int[] r = new int[3];	//한국, 중국, 일본 / 1등 0점, 2등 1점, 3등 2점
	
	String[] result = new String[3];	//최종등수
	
	Random rd = new Random();
	
	public Game() {
		gameStart();
		gameResult();
	}
	
	public void gameStart() {	//점수 배점, 랭킹 세팅
		for (int i = 0; i < s.length; i++) {
			한국[i] = scoreSet(i);
			중국[i] = scoreSet(i);
			일본[i] = scoreSet(i);
			if(한국[i]==중국[i] || 중국[i]==일본[i] || 일본[i]==한국[i]) {
				i--;
			}
			if (한국[i] > 중국[i] && 한국[i] > 일본[i]) {
				medalSet(0, 0);
				if (중국[i] > 일본[i]) {
					sportsRankSet(i, "한국", "중국", "일본");
					rankSet(3, 2, 1);
					medalSet(1, 1);
					medalSet(2, 2);
					
				} else {
					sportsRankSet(i, "한국", "일본", "중국");
					rankSet(3, 1, 2);
					medalSet(1, 2);
					medalSet(2, 1);
				}
			} else if (중국[i] > 한국[i] && 중국[i] > 일본[i]) {
				medalSet(1, 0);
				if (한국[i] > 일본[i]) {
					sportsRankSet(i, "중국", "한국", "일본");
					rankSet(2, 3, 1);
					medalSet(0, 1);
					medalSet(2, 2);
				} else {
					sportsRankSet(i, "중국", "일본", "한국");
					rankSet(1, 3, 2);
					medalSet(0, 2);
					medalSet(2, 1);
				}
			} else {
				medalSet(2, 0);
				if (한국[i] > 중국[i]) {
					sportsRankSet(i, "일본", "한국", "중국");
					rankSet(2, 1, 3);
					medalSet(0, 1);
					medalSet(1, 2);
				} else {
					sportsRankSet(i, "일본", "중국", "한국");
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
		System.out.println("국가별 순위 출력");
		rankPrint();
		
		System.out.println("\n국가별 메달 수 출력");	
		medalCount();
		
		System.out.println("\n최종 등수 출력");	
		rankFinal();
	}
	
	public void rankPrint() {
		System.out.println("점수");
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]+":"+r[i]+"점");
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
			System.out.print(c[i]+":금 "+m[i][0]+"개\t");
			System.out.print(c[i]+":은 "+m[i][1]+"개\t");
			System.out.print(c[i]+":동 "+m[i][2]+"개\t=");
			System.out.println(m[i][0]*3+m[i][1]*2+m[i][2]*1);
		}
	}
	
	public void rankFinal() {
		System.out.println("1등 : "+result[0]+"\t\t2등 : "+result[1]+"\t\t3등 : "+result[2]);
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
