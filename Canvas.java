
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Canvas extends JPanel {

	private Model model;

	Canvas(Model model) {

		this.model = model;

		setSize(300, 800);
		setBackground(Color.black);
		setOpaque(true);

	}

	public void paint(Graphics pen) {

		super.paint(pen);

		pen.setColor(Color.white);
		pen.drawString("Frolov", model.x1, model.y1);
	
		int rx = model.x;
		int ry = model.y;
		
		pen.setColor(Color.blue);		

		if(rx <=0) {
			rx =0;
			pen.setColor(Color.red);	
		} 

		if(ry <=0) {
			ry =0;
			pen.setColor(Color.red);	
		}

		if(rx >=750) {
			rx =750;
			pen.setColor(Color.yellow);	
		} 

		if(ry >=750) {
			ry =750;
			pen.setColor(Color.yellow);	
		}
		
		pen.drawRect(rx, ry, 50, 50);
		//System.out.println("" + rx + ":" + ry);
	}
}
