public class TestEquipeVillageois {
    public static void main (String [] args){
	Equipe e1 = new Equipe("rouge");
	Equipe e2 = new Equipe("bleu");

	

	Villageois v1 = new Villageois("Pier");
	Villageois v2 = new Villageois("Piere");
	Villageois v3 = new Villageois("Pierre");
	Villageois v4 = new Villageois("Pierre");
	Villageois v5 = new Villageois("Pierrre");

	e1.embaucher(v1);
	e1.embaucher(v2);
	e2.embaucher(v3);
	e1.embaucher(v1);
	e2.embaucher(v1);


	System.out.println(e1.toString());
	
	
    }
}

	    
