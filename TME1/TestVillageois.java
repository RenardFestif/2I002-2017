public class TestVillageois{
	public static void main(String[] args){
		Villageois a = new Villageois("Pierre");
		Villageois b = new Villageois("Paul");
		Villageois c = new Villageois("Jacob");
		Villageois d = new Villageois("Jean");

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		/* Le nom est : TestVillageois.java */

		double x = a.poidsSouleve()+b.poidsSouleve()+c.poidsSouleve()+d.poidsSouleve();
		if(x>100){
			System.out.println("BRAVO !");
		}
		else{
			System.out.println("FAIL !");
		}
	}
}