import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Viewer {
	
        private Canvas canvas;
	Controller controller;
	Model model;
	JFrame frame;	

	int level =2;

	Viewer() {

		controller = new Controller(this);
		
		model = controller.getModel();	
	
		canvas = new Canvas(model);
		
		frame = new JFrame("Sokoban level " + model.level);

		model.loadMap();
                
		frame.add("Center", canvas);
		frame.setVisible(true);
                frame.addKeyListener(controller);
	}

	public void setFrame() {

		frame.setSize(model.mapX *50 +20, model.mapY *50 +20);
		frame.setLocation(200, 0);
				
		System.out.println("setFrame: lvl=" + model.level);
	}

	public void update() {
		//System.out.println("viewer update: lvl=" + model.level);
		canvas.repaint();

	}	
}