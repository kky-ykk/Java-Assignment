
public class IneuronUsingPattern {

	public static void main(String[] args) {
		
		int n=10;
		
		//------------------I----------------------------
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if((i==1)||(i==n)||(j==((n%2==0)? n/2:n/2+1)))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//------------N------------------------------------
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if((j==1)||(j==n)||(j==i))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//---------------E------------------------------------
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if((i==1)||(i==n)||(i==((n%2==0)? n/2:n/2+1))||(j==1))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//------------------------U-----------------
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if((j==1 && i!=n) || (j==n && i!=n) || (i==n && j!=n && j!=1))
					System.out.print("*");
				else
					System.out.print(" ");
			}
				System.out.println();
		}
		
		System.out.println();
		
		//---------------------R--------------
		int k=2;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i<=n/2) {
					if((i==1) ||(j==1)|| (i==n/2) || (j==n))
						System.out.print("*");
					else
						System.out.print(" ");
				}
				else {
					if((j==1) || (k==j)) {
						System.out.print("*");
					}
					
					else
						System.out.print(" ");
				}
			}
			if(i>n/2)
				k+=2;
			System.out.println();
		}
		
		//---------------O------------------------
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if((i==1)||(i==n)||(j==1)||(j==n))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//-------------------------N------------------------
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if((j==1)||(j==n)||(j==i))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}

