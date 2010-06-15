package example.data;

import java.io.Serializable;

public class PlayResults extends Object implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8808259418494243920L;
	private Word selectedWord;
	private int score;
	private String scrambledWord;
	private int numWrong;
	private int numCorrect;
	private String message;
	public PlayResults (Word aWord) {
		init(aWord);
	}
	private void init(Word aWord) {
		score = 0;
		selectedWord = aWord;
		scrambledWord = selectedWord.scrambled();
		numCorrect = 0;
		numWrong   = 0;
		message = "" ;
	}
	public Word getSelectedWord() {
		return selectedWord;
	}
	public void setSelectedWord(Word selectedWord) {
		this.selectedWord = selectedWord;
		this.scrambledWord = selectedWord.scrambled();
		this.message = "";
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getScrambledWord() {
		return scrambledWord;
	}
	public void setScrambledWord(String scrambledWord) {
		this.scrambledWord = scrambledWord;
	}
	public int getNumWrong() {
		return numWrong;
	}
	public void setNumWrong(int numWrong) {
		this.numWrong = numWrong;
	}
	public int getNumCorrect() {
		return numCorrect;
	}
	public void setNumCorrect(int numCorrect) {
		this.numCorrect = numCorrect;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void correct() {
		++numCorrect;
		setMessage("You are correct !!");
		setScore(getScore()+getSelectedWord().getPoints().intValue());
	}
	public void wrong() {
		++numWrong;
		setMessage("You are incorrect !!");
	}
	
}
