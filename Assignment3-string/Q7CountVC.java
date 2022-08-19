
public class Q7CountVC {
	
	public static void main(String[] argu){
		String str="hello from Earth";
		
		int v=0,c=0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u' || str.charAt(i)=='A'|| str.charAt(i)=='E' || str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U')
				v++;
			else
				c++;
		}
		
		System.out.println("v="+v);
		System.out.println("c="+c);
	}
}

