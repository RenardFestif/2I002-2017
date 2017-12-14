public class TestMonde{
	public static void main(String[]args){
         int x = 300, y = 300;
         SimpleInterface ui = new SimpleInterface("JdV",x,y);
         Monde m = new Monde(x,y,0.6);
         ui.createArea(m.getX(),m.getY());
         ui.refresh();
         for (int t=0;t<1000;t++){
            ui.pause(10);
            m.etatSuivant();
            for (int i=0;i<m.getX();i++)
               for (int j=0;j<m.getY();j++)
                    ui.setRGB(i, j, m.get(i,j).getColor());
            ui.refresh();
         }
     }
}