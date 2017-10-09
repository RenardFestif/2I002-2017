public class TestTracteur{
    public static void main (String [] args){

	Roue r1 = new Roue (120);
	Roue r2 = new Roue (120);
	Roue r3 = new Roue ();
	Roue r4 = new Roue ();

	System.out.println("Roue 1 : "+r1.toString());
	System.out.println("Roue 2 : "+r2.toString());
	System.out.println("Roue 3 : "+r3.toString());
	System.out.println("Roue 4 : "+r4.toString());

	Cabine c1 = new Cabine(3, "rouge");

	System.out.println(c1.toString());

	c1.setCouleur("bleu");

	System.out.println(c1.toString());

	Tracteur t1 = new Tracteur (r1,r2,r3,r4,c1);

	t1.peindre("rouge");
	
	System.out.println (t1.toString());

	Tracteur t2 = t1;
	Tracteur t3 = new Tracteur (r1,r2,r3,r4,c1);

	t2.peindre("ORENJE");
	t3.peindre("BLOUHHJE");

	System.out.println (t1.toString()+"\n");
	System.out.println (t2.toString()+"\n");
	System.out.println (t3.toString()+"\n");
	
    }
}
