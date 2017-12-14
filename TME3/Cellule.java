public class Cellule{
	private int age;
	public Cellule(){
		this.age = 0;
	}
	public Cellule(boolean b){
		if(b==true){
			this.age = 0;
		}
		else{
			age = -1;
		}
	}
	public void vieillir(boolean b){
		if(b == false){
			this.mourir();
		}
		else{
			age++;
		}
	}
	public boolean vivante(){
		if(age == -1){
			return false;
		}
		return true;
	}
	public void mourir(){
		age = -1;
	}
	public void naitre(){
		this.age = 0;
	}
	public String toString(){
		if(age == -1){
			return ".";
		}
		return "*";
	}
	public int getAge(){
		return age;
	}
	public int[] getColor(){
		
		int tab[] = new int [3];

		if(this.vivante()){
			tab[0]=255;
			tab[1]=255;
			tab[2]=255;
			return tab; 
		}
		else{
			tab[0]=0;
			tab[1]=0;
			tab[2]=0;
			return tab;
		}
	}
}