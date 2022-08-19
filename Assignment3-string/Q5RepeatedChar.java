
public class Q5RepeatedChar {
	
	public static void main(String[] argu){
		String str="aabbcccd";
		
		char c[]=new char[125];
		
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<str.length();j++) {
				 if(str.charAt(i)==str.charAt(j)) {
					 c[str.charAt(i)]=str.charAt(i);
				 }	
			}
		}
		
		for(int i=0;i<125;i++) {
			if(c[i]!='\u0000')
				System.out.println(c[i]);
		}
	}
}		
