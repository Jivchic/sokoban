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
		
		frame = new JFrame("Sokoban Hello level");
		frame.setLocationRelativeTo(null);       
		
		JMenuBar jMenuBar = new JMenuBar();
		
		JMenu jMenuLevel = new JMenu("Levels");
		
		JMenuItem jMenuItemL1 = new JMenuItem("Level 1");
		jMenuLevel.add(jMenuItemL1);
		
		JMenuItem jMenuItemL2 = new JMenuItem("Level 2");
		jMenuLevel.add(jMenuItemL2);
		
		
		jMenuBar.add(jMenuLevel);
		
		frame.add(jMenuBar);
		
		frame.add("Center", canvas);
		frame.setVisible(true);
        frame.addKeyListener(controller);
		
		model.loadMap();
	}

	public void setFrame() {

		frame.setSize(model.mapX *50 +20, model.mapY *50 +20);
		frame.setLocation(200, 0);
		frame.setTitle("Sokoban level " + model.level);
				
		System.out.println("setFrame: lvl=" + model.level);
	}

	public void update() {
		//System.out.println("viewer update: lvl=" + model.level);
		canvas.repaint();

	}	
}