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

		/*switch(keyCode) {

			case 37:
				System.out.println("Left");
					
				break;

			case 38:
				System.out.println("Up");
				break;

			case 39:
				System.out.println("Right");
				break;

			case 40:
				System.out.println("Down");
				break;
			
		} */
	}

	
	public void keyReleased(KeyEvent event) {

		//viewer.update();

	}

}