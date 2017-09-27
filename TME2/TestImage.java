import java.awt.Graphics;
 import java.awt.image.BufferedImage;
 import java.io.*;
 import javax.imageio.ImageIO;

 public class TestImage {
    public static void main(String[] args) {        
        // Construction d'une image 600x800
        int nColonnes = 800;
        int nLignes = 600;
        BufferedImage im = // objet image en mémoire
                new BufferedImage(nColonnes, nLignes, BufferedImage.TYPE_INT_ARGB);

        // récupération d'un stylo pour écrire dans l'image
        Graphics g = im.getGraphics();

        // tracer une ligne entre le point (10,10) et le point (100, 50)
        g.drawLine(10, 10, 100, 50);

        // Sauver l'image dans un fichier
        try {
            File outputfile = new File("saved.png");
            ImageIO.write(im, "png", outputfile);
         } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde");
         }
    }
}
