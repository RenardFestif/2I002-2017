public class Histo{

	private final static int NBNOTE = 21;
	private int[] hist;

	public Histo(){
		hist = new int[NBNOTE];
		for(int i=0;i<NBNOTE;i++){
			hist[i]=0;
		}
	}

	public void ajoutNote(int note){
		hist[note]++;
	}

	public Histo(int[] note){
		this();
		for(int i=0; i<NBNOTE; i++){
			this.ajoutNote(note[i]);
		}
	}

	public void afficheHistogrammeTableau(){
		for(int i=0;i<NBNOTE;i++){
			System.out.print(hist[i]+" | ");
		}
	}

	public void afficheHistogramme(){
		int tmp = 0;
		for(int i=0;i<NBNOTE;i++){
			System.out.print(i+" | ");
			while(tmp<hist[i]){
				System.out.print("*");
				tmp++;	
			}
			System.out.println();
			tmp =0 ;
		}
	}

}