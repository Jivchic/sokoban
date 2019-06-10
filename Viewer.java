import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Viewer {
	
    private Canvas canvas;
	Controller controller;
	Model model;
	JFrame frame;	

	int level =0;

	Viewer() {

		controller = new Controller(this);
		
		model = controller.getModel();	
		canvas = new Canvas(model);
		
		frame = new JFrame("Sokoban Hello level");
		frame.setLocationRelativeTo(null);       
		
		JMenuBar jMenuBar = new JMenuBar();
		
		JMenu jMenuLevel = new JMenu("Levels");
		
		JMenuItem jMenuItemL1 = new JMenuItem(" * Level 1");
		jMenuItemL1.addActionListener(controller);
		jMenuLevel.add(jMenuItemL1);
		
		JMenuItem jMenuItemL2 = new JMenuItem(" * Level 2");
		jMenuItemL2.addActionListener(controller);
		jMenuLevel.add(jMenuItemL2);
		
		JMenuItem jMenuItemL3 = new JMenuItem(" * Level 3");
		jMenuItemL3.addActionListener(controller);
		jMenuLevel.add(jMenuItemL3);
		
		JMenuItem jMenuItemL4 = new JMenuItem(" * Level 4");
		jMenuItemL4.addActionListener(controller);
		jMenuLevel.add(jMenuItemL4);
		
		JMenuItem jMenuItemL5 = new JMenuItem(" * Level 5");
		jMenuItemL5.addActionListener(controller);
		jMenuLevel.add(jMenuItemL5);

		JMenuItem jMenuItemL10 = new JMenuItem(" * Level 10");
		jMenuItemL10.addActionListener(controller);
		jMenuLevel.add(jMenuItemL10);
		
		jMenuBar.add(jMenuLevel);
		
		frame.add("North", jMenuBar);
		
		frame.add("Center", canvas);
		frame.setVisible(true);
	        frame.addKeyListener(controller);
		
		model.loadMap();
	}

	public void setFrame() {

		frame.setSize(model.mapX *50 +20, model.mapY *50 +60);
		frame.setLocation(200, 0);
		frame.setTitle("Sokoban level " + model.level + " (Backspace to cancel 1 move)");
	}

	public void update() {
		//System.out.println("viewer update: lvl=" + model.level);
		canvas.repaint();

	}	
}