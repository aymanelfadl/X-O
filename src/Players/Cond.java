package Players;

public class Cond {
	
	String[][] tab = new String[5][5];
	int index = 0 ;
	
	public boolean isCellEmpty(int row, int col) {
	    return tab[row][col] == null;
	}

	public boolean checkForWin() {
	    for (int i = 0; i < tab.length; i++) {
	        if (tab[i][0] != null && tab[i][0].equals(tab[i][1]) && tab[i][0].equals(tab[i][2])) {
	            return true;
	        }
	    }
	    return false;
	}

	public boolean checkForDraw() {
	    for (int i = 0; i < tab.length; i++) {
	        for (int j = 0; j < tab[i].length; j++) {
	            if (tab[i][j] == null) {
	                return false; 
	            }
	        }
	    }
	    return true; 
	}

	

}
