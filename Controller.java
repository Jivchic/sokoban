import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Controller implements KeyListener{

	private Model model;

	Controller(Viewer viewer) {

		model = new Model(viewer);

	}

	public Model getModel() {
		return model;
	}


	public void keyTyped(KeyEvent event) {

	}

	
	public void keyPressed(KeyEvent event) {

		int keyCode = event.getKeyCode();	
                
		model.move(keyCode);

	}

	
	public void keyReleased(KeyEvent event) {

		//viewer.update();

	}

}