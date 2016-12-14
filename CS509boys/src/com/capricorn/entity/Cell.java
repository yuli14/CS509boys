package com.capricorn.entity;


import java.util.Random;

import com.capricorn.entity.Coordinate;
// TODO: Auto-generated Javadoc
/**
 * Define the cell with two attributes with letters and point.
 * Each cell should consisted with letters and potentially score('point').
 * The only method get is necessary, and ignore the set method which is generated by random algorithm.
 *@author Dongsheng Wang, Chen Li, Yu Li, Tianyu Wu, Bowen Sun
 */
public class Cell {

/** The letter. */
private String letter;               

/** The points. */
private String points;               

/** The local coordinate. */
private Coordinate localCoordinate; 

/** The global coordinate. */
private Coordinate globalCoordinate;

/** The is selected. */
private boolean isSelected;               

/** The is bonus. */
private boolean isBonus;                    
/**Construct Cell object to use default port number.*/
public Cell(){
	localCoordinate=new Coordinate();
	globalCoordinate=new Coordinate();
	letter = "";                  
	isBonus = false;               
	isSelected = false;            
}


/**
 * Gets the local coordinate.
 *
 * @return the local coordinate
 */

public Coordinate getLocalCoordinate() {
	return localCoordinate;
}

/**
 * Sets the local coordinate.
 *
 * @param localCoordinate the new local coordinate
 */
public void setLocalCoordinate(Coordinate localCoordinate) {
	this.localCoordinate = localCoordinate;
}

/**
 * Gets the global coordinate.
 *
 * @return the global coordinate
 */
public Coordinate getGlobalCoordinate() {
	return globalCoordinate;
}

/**
 * Sets the global coordinate.
 *
 * @param globalCoordinate the new global coordinate
 */
public void setGlobalCoordinate(Coordinate globalCoordinate) {
	this.globalCoordinate = globalCoordinate;
}

/**
 * Checks if is selected.
 *
 * @return true, if is selected
 */
public boolean isSelected() {
	return isSelected;
}

/**
 * Sets the selected.
 *
 * @param isSelected boolean is selected
 */
public void setSelected(boolean isSelected) {
	this.isSelected = isSelected;
}

/**
 * Checks if is bonus.
 *
 * @return true, if is bonus
 */
public boolean isBonus() {
	return isBonus;
}

/**
 * Sets the bonus.
 *
 * @param isBonus the new bonus
 */
public void setBonus(boolean isBonus) {
	this.isBonus = isBonus;
}

/**
 * Sets the letter.
 *
 * @param letter the new letter
 */
public void setLetter(String letter) {
	this.letter = letter;
}

/**
 * Gets the letter.
 *
 * @return the letter
 */

public String getLetter() {
	return letter;
}

/**
 * Gets the points.
 *
 * @return the points
 */
public String getPoints() {
	return points;
}

/** Setletter replace the set method. The Letter should be define among English letter with unique posibility. */
public void setLetterForPractice() {
	String[] c = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V","W","X","Y","Z","Qu"};  
    
	int k=0;
    int m=0;
    /** Here is the possibility each word will appear in the game according to a big data analyze.
     *  810 means the value 8.1% and sum the value up is 10000.
     */
	int[] pro={810,149,278,425,1270,223,202,609,697,15,77,403,241,675,751,193,599,633,906,276,98,236,15,197,7,10};
    for(int i=0;i<=25;i++){
    	m+=pro[i];
    	}
    
    int[] w= new int[m];
    for(int i=0; i<=25;i++){
    	for(int j=1; j<=pro[i];j++){
    		w[k]=i;
    		k++;
    	}
    };
    /** Here is the points for each word correspond to the order from A to Z and Qu.*/
	String[] p = {"2","4","3","3","1","4","4","2","2","7","5","3","3","2","2","4","2","2","1","3","5","3","7","4","8","11"};
	Random random = new Random();  

	int rand = random.nextInt(w.length);
	int q = w[rand];
    this.letter = c[q];
    this.points = p[q];
    
	}  

}


