import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

public class Controller implements KeyListener, ActionListener{

	private Model model;

	Controller(Viewer viewer) {

		model = new Model(viewer);
	}

	public Model getModel() {
		return model;
	}

	// KeyListener
	public void keyTyped(KeyEvent event) {
	}

	
	public void keyPressed(KeyEvent event) {

		int keyCode = event.getKeyCode();	
                
		model.move(keyCode);
		//System.out.println(keyCode);
	}

	
	public void keyReleased(KeyEvent event) {
	}


	// ActionListener
	public void actionPerformed(ActionEvent event) {

		//System.out.println("" + event);
		String command = event.getActionCommand();
		int numLevel = 0;


		if(command.compareToIgnoreCase("* Level") <0) {
			
			numLevel = Integer.parseInt(command.replace(" * Level ", ""));
			
			model.level = numLevel;
                        model.loadMap();
			//System.out.println("" + numLevel); 	
		
		} else if(command.compareToIgnoreCase("Load from File") == 0) {
			
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file with Level", "txt");
        		fileChooser.setFileFilter(filter);
        
			int ret = fileChooser.showDialog(null, "������� ����");
        		if (ret == JFileChooser.APPROVE_OPTION) {

            			File file = fileChooser.getSelectedFile();
            			
				model.loadLevelFromFile(file);
			}

			//model.loadLevelFromFile(file);
		}
	
	}	

}