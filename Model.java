public class Model {

	private Viewer viewer;
	int x;
	int y;

	int x1;
	int y1;
	
	Model(Viewer viewer) {

		this.viewer = viewer;

		x = 150;
		y = 50;

		x1 = 50;
		y1 = 50;
	}

	public void move(int keyCode) {
                
		switch(keyCode) {

			case 37:
				if(x >0) {
					x = x -10;
				}					
				break;

			case 38:
				if(y >0) {
					y = y -10;
				}
				break;

			case 39:
				if(x < 750){
					x = x +10;
				}
				break;

			case 40:
				if(y < 750){
					y = y +10;
				}
				break;
		}
                
		viewer.update();
	
	}


}