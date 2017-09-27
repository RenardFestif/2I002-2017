import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Tortue{

	private Vecteur pos;
	private Vecteur dir;
	private boolean draw;
	private Graphics g;

	public Tortue(Graphics g){

		this.g 		= g;
		this.dir 	= new Vecteur(1.0,0.0);
		this.pos 	= new Vecteur(200.0,200.0);
		this.draw 	= true;

	}

	public void leverStylo(){
		this.draw	= false;
	}

	public void baisserStylo(){
		this.draw	= true;
	}
 	
 	public void avance (int lg){

 		for(int i = 1; i<= lg; i++){
 			pos.addition(pos,dir);
 			if(draw){
 				g.drawLine((int) pos.getX(), (int) pos.getY(), (int) pos.getX(), (int) pos.getY()); 
 			}
 		}
 	}

 	public void rotation(double theta){
 		dir.rotation(theta);
 	}
 

 
}