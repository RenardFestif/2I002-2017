public class Bonjour{
	public void main(String[] args){
		System.out.println("Bonjour !");
	}
}

/*
Pour compiler : javac Bonjour.java
Le fichier est : Bonjour.class
Pour executer : java Bonjour

Non la classe ne s'execute pas.
Erreur : impossible de trouver ou charger la classe principale Bonjour

Bonjour.java:2: error: ';' expected
	public sta tic void main(String[] args){
	              ^
1 error
L'erreur est ligne 2 et est détecté ligne 2.


Bonjour.java:3: error: unclosed string literal
		System.out.println("Bonjour !);
		                   ^
Bonjour.java:3: error: ';' expected
		System.out.println("Bonjour !);
		                               ^
Bonjour.java:5: error: reached end of file while parsing
}
 ^
3 errors

error: Class names, 'Bonjour', are only accepted if annotation processing is explicitly requested
1 error
La compilation a échouée, on ne peut pas éxécuter le programme, le compilateur n'a pas trouvé le point d'entrée.

Bonjour.java:2: error: ';' expected
	public static void main(String[] args)
	                                      ^
Bonjour.java:5: error: class, interface, or enum expected
}
^
2 errors

Bonjour.java:2: error: ';' expected
	public static void main(String[] args)
	                                      ^
Bonjour.java:5: error: class, interface, or enum expected
}
^
2 errors
La compilation à échouée, on ne peut pas éxécuter le programme.

Bonjour.java:6: error: class, interface, or enum expected
}
^
1 error
La compilation à échouée, on ne peut pas éxécuter le programme.
*/
