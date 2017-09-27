public class TestVecteur{
	public static void main(String[] args){
		Vecteur v1 = new Vecteur(1.0,2.0);
		Vecteur v2 = new Vecteur(0.0,0.0);
		Vecteur v3 = new Vecteur(10.0,1.0);

		System.out.println(v1.toString());

		Vecteur res1 = new Vecteur();
		res1.addition(v1,v2);
		System.out.println(res1.toString());

		Vecteur res2 = new Vecteur();
		res2.addition(v1,v3);
		System.out.println(res2.toString());

		Vecteur v4 = new Vecteur(0.0, 1.0);
		v4.rotation(Math.PI/2);
		System.out.println(v4.toString());

		Vecteur v5 = new Vecteur(1.0, 1.0);
		v5.rotation(Math.PI/2);
		System.out.println(v5.toString());
	}
}