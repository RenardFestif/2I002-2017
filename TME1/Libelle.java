public class Libelle{
    public static void main(String[] args){

        int number = 768;


        String units2Letters[] = {"", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit",
                                "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize",
                                "dix-sept", "dix-huit", "dix-neuf"};

        String tens2Letters[] = {"", "dix", "vingt", "trente", "quarante", "cinquante", "soixante",
                                "soixante", "quatre-vingt", "quatre-vingt"};


        int units = number % 10;
        int tens = (number % 100 - units) / 10;
        int hundreds = (number % 1000 - number % 100) / 100;

        String unitsOut, tensOut, hundredsOut;

        if (number == 0) {
            System.out.println("zéro");
        }

        else {

            // Traitement des unités

            unitsOut = (units == 1 && tens > 0 && tens != 8 ? "et-" : "") + units2Letters[units];

            // Traitement des dizaines

            if (tens == 1 && units > 0) {

                tensOut = units2Letters[10 + units];
                unitsOut = "";
            }

            else if (tens == 7 || tens == 9) {

            tensOut = tens2Letters[tens] + "-" + (tens == 7 && units == 1 ? "et-" : "") + units2Letters[10 + units];
            unitsOut = "";

            } 

            else {

            tensOut = tens2Letters[tens];
            
            }

            tensOut += (units == 0 && tens == 8 ? "s" : "");

            // Traitement des centaines

             hundredsOut = (hundreds > 1 ? units2Letters[hundreds] + "-" : "") + (hundreds > 0 ? "cent" : "") + (hundreds > 1 && tens == 0 && units == 0 ? "s" : "");

            // Retour du total

            System.out.println(hundredsOut +" "+ tensOut +" "+ unitsOut);

        }
    }
}




