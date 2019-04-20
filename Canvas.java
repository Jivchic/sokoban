
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Canvas extends JPanel {

	private Model model;

	Canvas(Model model) {

		this.model = model;

		setBackground(Color.black);
		setOpaque(true);

	}

	public void paint(Graphics pen) {

		super.paint(pen);

		pen.setColor(Color.white);
		pen.drawString("Frolov", model.x, model.y);
	
		pen.setColor(Color.blue);
		pen.drawRect(model.x1, model.y1, 50, 50);
	}
}
