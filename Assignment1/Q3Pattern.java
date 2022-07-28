
public class Q3Pattern {

	public static void main(String[] args) {
		
		int n=15;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(n/2>=i) {
					if(j>n/2-i+1 && j<n/2+i-1) {
						System.out.print(" ");
					}
					else
						System.out.print("*");
				}
				else {
					if(j==1 || j==n || i==n)
						System.out.print("*");
					else
						System.out.print(" ");
				}
					
			}
			System.out.println();
		}

	}

}

