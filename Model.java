public class Model {

	private Viewer viewer;
	
	int x;
	int y;
	int h;
	int w;

	int xBigR;
	int yBigR;
        int hBigR;
	int wBigR;
	
	Model(Viewer viewer) {

		this.viewer = viewer;

		x = 150;
		y = 50;
		h = 50;
		w = 50;

		xBigR = 200;
		yBigR = 200;
        	hBigR = 200;
		wBigR = 200;
	}

	public void move(int keyCode) {
                
		switch(keyCode) {

			case 37:
				moveLeft();					
				break;

			case 38:
				moveUp();
				break;

			case 39:
				moveRight();
				break;

			case 40:
				moveDown();
				break;
		}
                check();
		viewer.update();
	
	}

	private void moveLeft() {
		if(x >0) {
			x = x -10;
		}	
	}

	private void moveUp() {
		if(y >0) {
			y = y -10;
		}
        }

	private void moveRight() {
                if(x < 750){
			x = x +10;
		}
       	}

	private void moveDown() {
		if(y < 750){
			y = y +10;
		}
       	}

	private void check() {
		if(
			x >= xBigR
			&&
			y >= yBigR
			&&
			(x + w)	<= (xBigR + wBigR)
			&&
			(y + h) <= (yBigR + hBigR)

		) {
			System.out.print('*');
		}
        }


}







