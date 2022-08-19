
public class Q1StringReverse {

	public static void main(String[] argu){
		String str1="iNeuron",str2="";
		
		for(int i=str1.length()-1;i>=0;i--) {
			str2+=str1.charAt(i);
		}
		
		System.out.println(str2);
		
	
	
	}
}

