package project_1;

public class test {
	public static void main(String[] args) {
		String s="11,10,9,8,7,6,5,4,3,2,1";
		LCS lcs = new LCS(s);
		lcs.calculated();
		int []x=lcs.getX();
		System.out.println("lengeth :"+x.length);
		for(int i =0;i<x.length;i++) {
			System.out.print(" "+x[i]+" ");
		}
		int []y=lcs.getY();
		System.out.println("lengeth :"+y.length);
		for(int i =0;i<y.length;i++) {
			System.out.print(" "+y[i]+" ");
		}
	}
}
