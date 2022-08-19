
public class Q4PanagramString {
	
	public static void main(String[] argu){
		String str="the quick brown fox jumps over lazy dog";
		
		boolean b[]=new boolean[26];
		
		str=str.toLowerCase();
		for(int i=0;i<str.length();i++) {
			if('a'<=str.charAt(i) && str.charAt(i)<='z') {
				b[str.charAt(i)-'a']=true;
			}
			else
				continue;
		}
		
		int i;
		for(i=0;i<26;i++) {
			if(b[i]!=true) {
				System.out.println("not panagram!");
				break;
			}
		}
		if(i==26)
			System.out.println("String panagram!");	
	
	}
}

