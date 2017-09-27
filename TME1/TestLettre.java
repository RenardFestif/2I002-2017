public class TestLettre {
	public static void main (String[] args){
		for (char i = 'a'; i<='z'; i++){
			Lettre l = new Lettre(i);
			System.out.println(l.getCodeAscii());
		} 

		for(char i = 'a'; i<='z'; i++){
			if (i%5-1 == 0){
				System.out.println(i);
			}
			else{
				System.out.print(i);
			}
		}
	}
}