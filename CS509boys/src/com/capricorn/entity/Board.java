package com.capricorn.entity;

import java.util.ArrayList;

/**As defined, the size of the board is should be 4-letters'-long and 4-letters'-wide.
  *Applying cell to generate a 4*4 board with 16 letters in it.
  */
public class Board {
public Cell cells[][] = new Cell[4][4];
private ArrayList<Cell> chosenCells;
private Word word=new Word();
private int globalStartingCol;
private int globalStartingRow;
private Integer requestColChange;
private Integer requestRowChange;
private String bonusCell;
public String getBonusCell() {
	return bonusCell;
}

public void setBonusCell(String bonusCell) {
	this.bonusCell = bonusCell;
}

public Integer getRequestColChange() {
	return requestColChange;
}

public void setRequestColChange(Integer requestColChange) {
	this.requestColChange = requestColChange;
}

public Integer getRequestRowChange() {
	return requestRowChange;
}

public void setRequestRowChange(Integer requestRowChange) {
	this.requestRowChange = requestRowChange;
}

/**SetLetter method to fill in the cell with different word*/
public void setcellArrayForPractice(){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			cells[i][j] = new Cell();
			cells[i][j].setLetterForPractice();
		}
	}
}

public Board(){
	globalStartingCol=0;
	globalStartingRow=0;
	chosenCells = new ArrayList<Cell>();
	word = new Word();
	
	for(int i = 1; i < 5 ; i++){
		for(int j = 1; j < 5; j++){
			
		    Coordinate localCoordinate=new Coordinate(i,j);
		    Coordinate globalCoordinate=new Coordinate(i,j);
			Cell cell = new Cell();
			cell.setLocalCoordinate(localCoordinate);
			cell.setGlobalCoordinate(globalCoordinate);
			
			this.cells[i-1][j-1]=cell;
		}
	}
}

public void updateBoard(int newStartingCol, int newStaringRow, String NewBoardInfo){
	this.globalStartingCol = newStartingCol;
	this.globalStartingRow = newStaringRow;
	
	for(int i=0;i<4;i++){
		for (int j=0;j<4;j++){
           int x=globalStartingCol+i;
           int y=globalStartingRow+j;
           Coordinate globalCoordinate=new Coordinate(x,y);
           cells[i][j].setGlobalCoordinate(globalCoordinate);
	}
		}
	
	

	updateBoardByAllLetters(NewBoardInfo);
}

private void updateBoardByAllLetters(String cellsLetters){
	
	char[] cellInforList = cellsLetters.toCharArray();
	System.out.println(cellInforList.length);
	for(int i = 0; i < 16; i++){
		int row=i/4;
		int col=i%4;
		if(cellInforList[i]=='Q'){
			
		cells[row][col].setLetter("QU");
		}
		else{
			cells[row][col].setLetter(String.valueOf(cellInforList[i]));
	}
}
}

public String getBoardInfo(){
	String allCellLetters = "";
	for(int i=0;i<4;i++){
		for (int j=0;j<4;j++){
			if (cells[i][j].getLetter().equals("QU")){
				allCellLetters+="Q";
			}
			else{
			allCellLetters+=cells[i][j].getLetter();
			}
	}
		}
	return allCellLetters;
}

public ArrayList<Cell> getChosenCells() {
	return chosenCells;
}

public void setChosenCells(ArrayList<Cell> chosenCells) {
	this.chosenCells = chosenCells;
}

public Word getWord() {
	return word;
}

public void setWord(Word word) {
	this.word = word;
}

public int getGlobalStartingCol() {
	return globalStartingCol;
}

public void setGlobalStartingCol(int globalStartingCol) {
	this.globalStartingCol = globalStartingCol;
}

public int getGlobalStartingRow() {
	return globalStartingRow;
}

public void setGlobalStartingRow(int globalStartingRow) {
	this.globalStartingRow = globalStartingRow;
}

public Cell[][] getCells() {
	return cells;
}
public String getChosenCellsXMLString(){
	String chosenCellsString = "";
	for(int i=0;i<4;i++){
		for (int j=0;j<4;j++){
			chosenCellsString += String.format("<cell position='%s,%s' letter='%s'/>", 
					String.valueOf(cells[i][j].getGlobalCoordinate().row), 
					String.valueOf(cells[i][j].getGlobalCoordinate().col), 
					cells[i][j].getLetter());			
	}
		}
	return chosenCellsString;
}
public void addToChosenCellsByIndex(int ChosenCellIndex){
	
		int row=ChosenCellIndex/4;
		int col=ChosenCellIndex%4;
		chosenCells.add(cells[row][col]);
		cells[row][col].setSelected(true);
		word.setContent(getChosenCellsLetters());
		

}
public String getChosenCellsLetters(){
	String chosenLetters = "";
	for(Cell cell : chosenCells)
			chosenLetters += cell.getLetter(); 
	return chosenLetters;
}
public void clearChosenCells(){
	for(Cell cell : chosenCells){
		cell.setSelected(false);
	}
	chosenCells.removeAll(chosenCells);
}



}





	

