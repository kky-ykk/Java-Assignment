
public class Q6SortString {
	
	public static void main(String[] argu){
		String str="zxracrb";
		
		char c[]=str.toCharArray();
		
		for(int i=0;i<str.length()-1;i++) {
			for(int j=i+1;j<str.length();j++) {
				if(c[i]>c[j]) {
					char temp=c[i];
					c[i]=c[j];
					c[j]=temp;
				}
			}
		}
		System.out.println(new String(c));
	}
}

