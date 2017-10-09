//package tools;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleInterface extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private int nbCols, nbRows;
	private BufferedImage img;
	private Queue<Integer> lastKey;
	private Queue<MyMouseEvent> lastClicked;
	private MyPanel panel;
	public final static int[] BLACK = new int[]{0,0,0};
	public final static int[] WHITE = new int[]{255,255,255};
	public final static int[] RED = new int[]{255,0,0};
	public final static int[] BLUE = new int[]{0,0,255};
	public final static int[] GREEN = new int[]{0,255,0};
	public final static int[] YELLOW = new int[]{0,100,0};
	
	
	/**
	 * Create an interface
	 * @param name Name of the  window
	 */

	public SimpleInterface(String name){
		this(name,600,400);
	}	

	/**
	 * Create an interface with the given size
	 * @param name  Name of the window
	 * @param width  width of the window
	 * @param height  height of the window
	 */
	
	public SimpleInterface(String name, int width, int height){
		super(name);
		this.nbCols = this.nbRows = 1;
		lastKey=new LinkedList<Integer>();
		lastClicked = new LinkedList<MyMouseEvent>();
		panel = new MyPanel();
		panel.setPreferredSize(new Dimension(width, height));
		panel.addKeyListener(this);
		panel.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {lastClicked.add(new MyMouseEvent(e));}
		});
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.grabFocus();
		add(panel,BorderLayout.CENTER);
		pack();
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Redraw the window
	 */
	public void refresh(){
		repaint();
	}
	
	/**
	 * Create an area to draw with the given geometry
	 * 
	 * @param width
	 * @param height
	 */
	public void createArea(int sizeX, int sizeY){
		img=(BufferedImage)createImage(sizeX, sizeY);
	}
	
	/**
	 * Draw the given image
	 * @param image
	 */
	public void setImage(int[][][] image){
		int w=image.length;
		int h=image[0].length;
		if ((w!=panel.getWidth()) || (h!=panel.getHeight()))
			createArea(w,h);
		for (int i=0;i<w;i++)
			for (int j=0;j<h;j++)
				setRGB(i, j, image[i][j]);
		refresh();
	}
	
	/**
	 * Set the pixel (x,y) to the color (r,g,b)
	 * @param x 
	 * @param y
	 * @param r
	 * @param g
	 * @param b
	 */
	
	public void setRGB(int x, int y, int r, int g, int b){
		setRGB(x, y, rgbToInt(r,g,b));				
	}
	
	/**
	 * Set the pixel (x,y) to the color (r,g,b)
	 * @param x
	 * @param y
	 * @param color
	 */
	public void setRGB(int x, int y , int[] color){
		setRGB(x, y, rgbToInt(color));		
	}
	
	/**
	 *  Set the pixel (x,y) to the color 0xrrggbb
	 * @param x
	 * @param y
	 * @param color
	 */
	public void setRGB(int x, int y, int color){
		if ((x<0)||(x>=getWidth())||(y<0)||(y>=getHeight()))
			return;
		img.setRGB(x, y, color);
	}
	

	/**
	 * Draw an image into the rectangle (x,y) -> (x+width,y+height)
	 * @param img
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawImage(Image img, int x, int y, int width,int height){
		getGraphics2D().drawImage(img, x, y, width, height,null);
	}
	
	/**
	 * Fill the rectangle (x,y) -> (x+width,y+height) with given color
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
	public void fillRect(int x, int y, int width, int height,int[]color){
		Graphics2D  g= getGraphics2D();
		g.setColor(new Color(color[0],color[1],color[2]));
		g.fillRect(x, y, width, height);
	}
	
	/**
	 * Draw the rectangle of coords (x,y)->(x+width,y+height)
	 * @param xdeb
	 * @param ydeb
	 * @param xfin
	 * @param yfin
	 * @param color
	 */
	
	
	public void drawRect(int x, int y, int width, int height, int[]color){
		Graphics2D  g= getGraphics2D();
		g.setColor(new Color(color[0],color[1],color[2]));
		g.drawRect(x, y, width,height);
	}
	
	/**
	 * fill the window with the given color
	 * @param color
	 */
	public void fill(int[]color){
		fillRect(0,0,panel.getWidth(),panel.getHeight(),color);
	}
	
	/**
	 * Draw a String to a given position with a given color
	 * @param str
	 * @param x
	 * @param y
	 * @param color
	 */
	public void drawString(String str, int x , int y,int[]color){
		Graphics2D g=getGraphics2D();
		g.setColor(new Color(color[0],color[1],color[2]));
		g.drawString(str, x, y);
	}

	public void drawString(String str, int x , int y,int size, int[]color){
		Graphics2D g=getGraphics2D();
		g.setColor(new Color(color[0],color[1],color[2]));
		Font font = new Font("Arial", Font.PLAIN, size);
	    g.setFont(font);
		g.drawString(str, x, y);
	}

	/**
	 * Clear the rectangle of coords (x,y) -> (x+width, y +height)
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */

	public void clearRect(int x, int y, int width, int height){
		fillRect(x,y,width,height,BLACK);
	}
	
	/** Clear the window (fill black)
	 * 
	 */
	public void clear(){
		clearRect(0,0,panel.getWidth(),panel.getHeight());
	}

	/**
	 *  Set the grid to (nbCols, nbRows)
	 * @param nbCols
	 * @param nbRows
	 */
	public void setGrid(int nbCols, int nbRows){
		if (img==null)
			createArea(panel.getWidth(),panel.getHeight());
		this.nbCols=nbCols;
		this.nbRows=nbRows;
	}
	/**
	 * get the width of a cell (in grid mode)
	 * @return
	 */
	public int cellWidth(){
		return (int) (img.getWidth()*1./nbCols);
	}
	
	/** get the height of a cell (in grid mode)
	 * 
	 * @return
	 */
	public int cellHeight(){
		return (int) (img.getHeight()*1./nbRows);
	}
	
	/**
	 * convert grid x coord to absolute x coord
	 * @param x
	 * @return
	 */
	public int gridToX(int x){
		return x*cellWidth();
	}
	/**
	 * convert grid y coord to absolute y coord
	 * @param y
	 * @return
	 */
	public int gridToY(int y){
		return y*cellHeight();
	}
	/**
	 * convert absolute x coord to grid x coord
	 * @param x
	 * @return
	 */
	public int xToGrid(int x){
		return x/cellWidth();
	}
	/**
	 * convert absolute y coord to grid y coord
	 * @param y
	 * @return
	 */
	public int yToGrid(int y){
		return y/cellHeight();
	}
	/**
	 * Draw an image inside the cell (x,y)
	 * @param x
	 * @param y
	 * @param img
	 */
	public void drawCell(int x, int y,Image img){
		drawImage(img,gridToX(x),gridToY(y),cellWidth(),cellHeight());
	}
	/**
	 * fill the cell (x,y) with color
	 * @param x
	 * @param y
	 * @param color
	 */
	public void fillCell(int x, int y,  int[]color){
		fillRect(gridToX(x),gridToY(y),cellWidth(),cellHeight(),color);
	}
	/**
	 * clear the cell (x,y)
	 * @param x
	 * @param y
	 * @param color
	 */
	public void clearCell(int x, int y){
		fillCell(x,y,BLACK);
	}
	/**
	 * draw a rect at the cell (x,y)
	 * @param x
	 * @param y
	 * @param color
	 */
	public void rectCell(int x, int y, int[]color){
		drawRect(gridToX(x),gridToY(y),cellWidth(),cellHeight(),color);
	}
	/**
	 * Draw String in the grid mode
	 * @param str
	 * @param x
	 * @param y
	 * @param color
	 * @param size
	 */
	public void drawStringCell(String str, int x, int y, int[]color){
		BufferedImage img = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		Font font = new Font("Arial", Font.PLAIN, 100);
	    g.setFont(font);
	    FontMetrics fm = g.getFontMetrics();
	    int width = fm.stringWidth(str);
	    int height = fm.getHeight();
	    g.dispose();
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = img.createGraphics();
        g.setFont(font);
        fm = g.getFontMetrics();
        g.setColor(new Color(color[0],color[1],color[2]));
        g.drawString(str, 0, fm.getAscent());
        g.dispose();
        drawCell(x, y, img);
	}
	
	public void toFile(String fn){
		try{ImageIO.write(img,"png",new File(fn));}catch(IOException e){e.printStackTrace();}
	}

	/******************************************************************
	 * key/mouse listener section
	 * 
	 *
	 ******************************************************************/
	
	
	/**
	 * Return the first key in queue
	 * @return	ascii code of the key
	 */
	public int popKey(){
		if (lastKey.size()==0)
			return -1;
		return lastKey.poll();
	}
	
	/**
	 * Return the first mouse click event in queue
	 * @return the array [x,y,id] containing the clicked pixel (x,y) and the id of the button
	 */
	public int[] popClick(){
		if (lastClicked.size()==0)
			return null;
		MyMouseEvent e = lastClicked.poll();
		return new int[]{e.x,e.y,e.but};
	}
		

	public int waitKey(){
		int k;
		while((k = popKey())<0){
			pause(10);
		}
		return k;
	}
	
	public int[] waitClick(){
		int[] e;
		while((e = popClick())==null){
			pause(10);
		}
		return e;
	}

	/******************************************************************
	 * static section
	 * 
	 *
	 ******************************************************************/
	
	/**
	 * pause for ms milliseconds
	 * @param ms
	 */
	public static void pause(int ms){
		try{Thread.sleep(ms);}catch(Exception e){};
	}

	/**
	 * Convert a hsl color to rgb
	 * @param h hue (0-360)
	 * @param s saturation (0-1)
	 * @param l lightness (0-1)
	 * @return
	 */
  	public static int []hslToRgb(double h, double s, double l) {
	    double c = (1-Math.abs(2*l-1))*s;
	    double x= c*(1-Math.abs( ((h/60.) %2  )-1));
	    double m = l-c/2;
	    double []res={m,m,m};        
	    if (h<60) {res[0]+=c; res[1]+=x;return toInt(res);}
	    if (h<120) {res[0]+=x; res[1]+=c;return toInt(res);}
	    if (h<180) {res[1]+=c; res[2]+=x;return toInt(res);}
	    if (h<240) {res[1]+=x; res[2]+=c;return toInt(res);}
	    if (h<300) {res[0]+=x; res[2]+=c;return toInt(res);}
	    res[0]+=c;
	    res[2]+=x;
	    return toInt(res);
  }
	/**
	 * Read image file 
	 * @param fn file path
	 * @return array [width][height][r,g,b] of the image
	 */
	public static BufferedImage loadImage(String fn){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(fn));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);}
		return img;
	}
	
	public static BufferedImage crop(BufferedImage src, Rectangle rect){
		return src.getSubimage(rect.x, rect.y, rect.width, rect.height);
	}
	public static BufferedImage[] getSprites(String fn, int width, int height){
		return getSprites(loadImage(fn),width,height);
	}
	public static BufferedImage[] getSprites(BufferedImage img, int width, int height){
		int nbw = img.getWidth()/width;
		int nbh = img.getHeight()/height;
		BufferedImage[] bmp = new BufferedImage[nbw*nbh];
		int i,j;
		for (j=0;j<nbh;j++)
			for (i=0;i<nbw;i++){
				bmp[j*nbw+i] = crop(img,new Rectangle(i*width,j*height,width,height));
			}
		return bmp;
	}

	
	/******************************************************************
	 * private section
	 * 
	 *
	 ******************************************************************/

	class MyPanel extends JPanel {
		public void paint(Graphics g){			 
			if (img==null)
				return;
			Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
	        g2.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		}		
	}
	private class MyMouseEvent{
		public final int x,y,but;
		MyMouseEvent(MouseEvent e){
			x=(int) (img.getWidth()*e.getX()*1./panel.getWidth());
			y=(int)(img.getHeight()*e.getY()*1./panel.getHeight());
			but = e.getButton();
			panel.grabFocus();
		}
	}

	private static int[] toInt(double[] tab){
        return new int[]{ (int)(256*tab[0]), (int)(256*tab[1]), (int)(255*tab[2])};
    }
	private Graphics2D getGraphics2D(){return this.img.createGraphics();}
	private int rgbToInt(int r, int g, int b){
	    return (r << 16) | (g <<8 )| b;
	}

	public void keyPressed(KeyEvent e){lastKey.add(new Integer(e.getKeyChar()));}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	private int rgbToInt(int[] tab){
		if (tab.length!=3)
			return 0;
		return rgbToInt(tab[0],tab[1],tab[2]);
	}
}