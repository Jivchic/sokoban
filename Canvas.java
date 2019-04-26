
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Canvas extends JPanel {

	private Model model;
	
	private Image imaGamerS;
	private Image imaGamerL;
	private Image imaGamerU;
	private Image imaGamerR;
	private Image imaGamerD;
	private Image imaGamerP;
	private Image imaWall;
	private Image imaBox;
	private Image imaBoxDone;
	

	Canvas(Model model) {

		this.model = model;

		//setSize(300, 800);
		setBackground(Color.gray);
		setOpaque(true);

		File fileGamerS = new File("images/gamerS.png");
		File fileGamerL = new File("images/gamerL.png");
		File fileGamerU = new File("images/gamerU.png");
		File fileGamerR = new File("images/gamerR.png");
		File fileGamerD = new File("images/gamerD.png");
		File fileGamerP = new File("images/gamerP.png");
                
		File fileWall  = new File("images/wall.png");
		File fileBox   = new File("images/box.png");
		File fileBoxDone   = new File("images/boxDone.png");

		try {
			imaGamerS = ImageIO.read(fileGamerS);
			imaGamerL = ImageIO.read(fileGamerL);
			imaGamerU = ImageIO.read(fileGamerU);
			imaGamerR = ImageIO.read(fileGamerR);
			imaGamerD = ImageIO.read(fileGamerD);
			imaGamerP = ImageIO.read(fileGamerP);
			imaWall  = ImageIO.read(fileWall);
			imaBox   = ImageIO.read(fileBox);
			imaBoxDone  = ImageIO.read(fileBoxDone);
		} catch(IOException e) {
			System.out.println(e);
		}
	}

	public void paint(Graphics pen) {

		super.paint(pen);
                                                             	
		int start = 0;
		int x = start;
		int y = start;
		
		int width  = 50;
		int heigth = 50;
		int offset = 0;

		int cursor;

		pen.setColor(Color.white);
		pen.fillRect(x, y, width *model.desktop.length, heigth *model.desktop[0].length);

		for(int i =0; i < model.desktop.length; i++) {
			for(int j =0; j <model.desktop[i].length; j++) {

				cursor = model.desktop[i][j];
				if(cursor ==1) {
					
					if(model.dir =='L') {
						pen.drawImage(imaGamerL, x, y, null);
					} else if(model.dir =='U') {
						pen.drawImage(imaGamerU, x, y, null);
					} else if(model.dir =='R') {
						pen.drawImage(imaGamerR, x, y, null);
					} else if(model.dir =='D') {
						pen.drawImage(imaGamerD, x, y, null);
					} else { 
						pen.drawImage(imaGamerS, x, y, null);
					}	
				
				} else if(cursor ==2) {
					/*pen.setColor(Color.blue);
					pen.fillRect(x, y, width, heigth);
					pen.setColor(Color.white);
					pen.drawRect(x, y, width, heigth);*/

					pen.drawImage(imaWall, x, y, null);
				
				} else if(cursor ==3) {
					/*pen.setColor(Color.blue);
					pen.fillRect(x, y, width, heigth);
					pen.setColor(Color.white);
					pen.drawRect(x, y, width, heigth);*/

					pen.drawImage(imaBox, x, y, null);	

				} else if(cursor ==4) {
					pen.setColor(Color.green);
					pen.fillRect(x, y, width, heigth);
					/*pen.setColor(Color.white);
					pen.drawRect(x, y, width, heigth);*/

					//pen.drawImage(imaWall, x, y, null);

				} else if(cursor ==5) {
					/*pen.setColor(Color.blue);
					pen.fillRect(x, y, width, heigth);*/
					pen.setColor(Color.yellow);
					pen.drawRect(x, y, width, heigth);

					pen.drawImage(imaBoxDone, x, y, null);

				} else if(cursor ==6) {
					pen.setColor(Color.green);
					pen.drawRect(x, y, width, heigth);

					pen.drawImage(imaGamerP, x, y, null);
				
				} else {
					//pen.setColor(Color.white);
					//pen.drawRect(x, y, width, heigth);
				}

				x = x + width + offset;
			}
		
		        x = start;
			y = y + heigth + offset;
		}
	}
}
