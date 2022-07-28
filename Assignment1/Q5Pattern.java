
public class Q5Pattern {

	public static void main(String[] args) {
		
		int n=14,k=2;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==1 || i==n)
					System.out.print("*");
				else {
					if(i<=n/2) {
						if(j<=n/2+1-i) 
							System.out.print("*");
						else
							System.out.print(" ");
					}else {
						if(j<=k) {
							System.out.print("*");
						}
						else
							System.out.print(" ");
						
					}
				}
			}
			if(n/2<i)
				
				k++;
			System.out.println();
		}

	}

}

