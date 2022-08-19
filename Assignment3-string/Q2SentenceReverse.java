
public class Q2SentenceReverse {

	static String rev(String str) {
		char c[]=str.toCharArray();
		for(int i=0,j=str.length()-1;i<str.length()/2;i++,j--) {
			char temp=c[i];
			c[i]=c[j];
			c[j]=temp;
		}
		return new String(c);
	}

	public static void main(String[] argu){
		String str="Think Twice",s1="",s2="";
		
		for(int i=0;i<str.length();i++) {
			s1+=str.charAt(i);
			
			if(str.charAt(i)==' ') {
				s2+=rev(s1)+" ";
				s1="";
			}
			if( i==str.length()-1) {
				s2+=rev(s1);
			}
		}
		System.out.println(s2);
	
	
	}
}

