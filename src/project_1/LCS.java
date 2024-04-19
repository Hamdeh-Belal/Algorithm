/**
 * 
 */
package project_1;

/**
 * @author Belal Hamdeh
 *
 */
public class LCS {
	private  int x[];
	private  int y[];
	private  String result;

	/**
	 * @param y
	 */
	public LCS(int[] y) {
		setY(y);
		setX(y);
		result ="";
	}
	public LCS(String y) {
		if (y!=null) {
		String [] data = y.split(",");
		int [] temp= new int [data.length];
		for (int i =0 ;i<data.length;i++ ) {
			temp[i]=Integer.parseInt(data[i]);
		}
		setY(temp);
		setX(temp);
		result="";
	}
	}

	private void setX(int[] y) {
		if (y.length != 0 && y != null) {
			x = new int[y.length+1];
			x[0]=0;
			for (int i = 1; i < x.length; i++) {
				x[i] = i;
			}
		}
	}

	private void setY(int[] y) {
		if (y != null&&y.length!=0) {
			int t[] = new int[y.length + 1];
			t[0] = 0;
			for (int i = 1; i < t.length; i++)
				t[i] = y[i - 1];

			this.y = t;
		}
	}

	public void calculateAndPrint() {
		if (y != null && x != null && x.length != 0 && y.length != 0) {
			int m = x.length;
			int n = y.length;

			int c[][] = new int[m + 1][n + 1];
			// up and left = 0 | up =1 | left =2
			int b[][] = new int[m + 1][n + 1];

			for (int i = 1; i <= m; i++)
				c[i][0] = 0;

			for (int j = 1; j <= n; j++)
				c[0][j] = 0;

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {

					if (x[i] == y[j]) {
						c[i][j] = c[i - 1][j - 1] + 1;
						b[i][j] = 0;
					} else {
						if (c[i][j - 1] > c[i - 1][j]) {
							c[i][j] = c[i][j - 1];
							b[i][j] = 2;
						} else {
							c[i][j] = c[i - 1][j];
							b[i][j] = 1;
						}
					}
				}

			}
			print(b, x, m - 1, n - 1);
		} else {
			System.out.println("Error !!!!!!!!11");
		}
	}

	private void print(int b[][], int x[], int i, int j) {

		if ((i == 0) || (j == 0)) {
			return;
		} else {

			if (b[i][j] == 0) {

				print(b, x, i - 1, j - 1);
				System.out.print(x[i]+" ");
			} else {
				if (b[i][j] == 1)
					print(b, x, i - 1, j);
				else
					print(b, x, i, j - 1);
			}

		}

	}
	public int [][] getTable (){
		int [][] data=null;
		if (y != null && x != null && x.length != 0 && y.length != 0) {
			int m = x.length;
			int n = y.length;

			int c[][] = new int[m][n];
			// up and left = 0 | up =1 | left =2
			int b[][] = new int[m][n];
			for (int i = 1; i < m; i++)
				c[i][0] = 0;

			for (int j = 1; j <n; j++)
				c[0][j] = 0;

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {

					if (x[i] == y[j]) {
						c[i][j] = c[i - 1][j - 1] + 1;
						b[i][j] = 0;
					} else {
						if (c[i][j - 1] > c[i - 1][j]) {
							c[i][j] = c[i][j - 1];
							b[i][j] = 2;
						} else {
							c[i][j] = c[i - 1][j];
							b[i][j] = 1;
						}
					}
				}

			}
			data=c;
		} else {
			System.out.println("Error !!!!!!!!11");
		}
	
		
		return data;
	}
	public int [] calculated() {
		if (y != null && x != null && x.length != 0 && y.length != 0) {
			int m = x.length;
			int n = y.length;
			result="";
			int c[][] = new int[m ][n];
			// up and left = 0 | up =1 | left =2
			int b[][] = new int[m][n];

			for (int i = 1; i < m; i++)
				c[i][0] = 0;

			for (int j = 1; j < n; j++)
				c[0][j] = 0;

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {

					if (x[i] == y[j]) {
						c[i][j] = (c[i - 1][j - 1] )+ 1;
						b[i][j] = 0;
					} else {
						if (c[i][j - 1] > c[i - 1][j]) {
							c[i][j] = c[i][j - 1];
							b[i][j] = 2;
						} else {
							c[i][j] = c[i - 1][j];
							b[i][j] = 1;
						}
					}
				}

			}
			
			getData(b, x, m - 1, n - 1);
			result=result.substring(0, result.length()-1);
//			System.out.println(result+"***********");
		} 
		return toArray(result);
	}
	private void getData(int b[][], int x[], int i, int j) {

		if ((i == 0) || (j == 0)) {
			return;
		} else {

			if (b[i][j] == 0) {

				getData(b, x, i - 1, j - 1);
				result =result +x[i]+",";
			} else {
				if (b[i][j] == 1)
					getData(b, x, i - 1, j);
				else
					getData(b, x, i, j - 1);
			}

		}

	}
	private int [] toArray (String stringData) {
		
//		if (stringData!=null&&stringData.contains(",")) {
			String [] data = stringData.split(",");
			int [] temp= new int [data.length];
			for (int i =0 ;i<data.length;i++ ) {
				temp[i]=Integer.parseInt(data[i]);
			}
		
		
		return temp;
		

//	}return null;
	}
	/**
	 * @return the x
	 */
	public int[] getX() {
		return x;
	}
	/**
	 * @return the x
	 */
	public int[] getY() {
		return y;
	}
	
	public int getTrueLength() {
		return y.length-1;
	}
	public int [] getYss() {
		int []temp = new int [y.length-1];
		
		
		for (int i =0;i<temp.length;i++) {
			temp[i]=y[i+1];
		}
		return temp;
	}
}
