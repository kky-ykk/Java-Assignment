
public class Q3AnagramString {
	
	static String srt(String str) {
		
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
		
		return new String(c);
	}
	
	public static void main(String[] argu){
		String str1="triangle",str2="integral";
		int i;
		
		str1=srt(str1);
		str2=srt(str2);
		
		if(str1.length()!=str2.length())
			System.out.println("Not anagram string!");
		else {
			
			for(i=0;i<str1.length();i++) {
				if(str1.charAt(i)!=str2.charAt(i)) {
					System.out.println("NOt anagram!");
					break;
				}
			}
			if(str1.length()==i)
				System.out.println("Anagram string!");
		}
	
	
	}
}

