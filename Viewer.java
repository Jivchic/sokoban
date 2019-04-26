import javax.swing.JFrame;

public class Viewer {
	
        private Canvas canvas;	

	Viewer() {

		Controller controller = new Controller(this);
		
		Model model = controller.getModel();	
	
		canvas = new Canvas(model);

		JFrame frame = new JFrame("Sokoban");
		frame.setSize(800, 800);
		frame.setLocation(200, 0);
		
		frame.add("Center", canvas);

		frame.setVisible(true);

		frame.addKeyListener(controller);		
	}


	public void update() {
		canvas.repaint();

	}	
}