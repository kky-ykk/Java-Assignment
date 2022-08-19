
public class Q8SpecialChar {
	
	public static void main(String[] argu){
		String str="kishan123#$().>";
		int special=0;
		for(int i=0;i<str.length();i++) {
			if( (('a'>str.charAt(i)) || ('z'<str.charAt(i))) && (('A'>str.charAt(i)) || ('Z'<str.charAt(i))) && (('0'>str.charAt(i)) || ('9'<str.charAt(i)))) {
				special++;
			}
		}
		System.out.println("special="+special);
	}
}

