public class TestSegment{
	public static void main(String[] args){
		Segment a = new Segment(6,8);
		Segment b = new Segment(12,5);

		if (a.longueur()>b.longueur()){
			System.out.println(a.toString());
		}
		else{
			System.out.println(b.toString());
		}
	}
}