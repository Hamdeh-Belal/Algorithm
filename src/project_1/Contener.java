package project_1;

import javafx.scene.control.Label;

public class Contener {

	private static int tatal;
	private int index;
	private Label label;
	private String text;
	private int indexSwitch;

	/**
	 * @param index
	 * @param label
	 * @param text
	 */
	public Contener(int index, Label label, String text) {
		super();
		this.index = index;
		this.label = label;
		this.text = text;
	}
	/**
	 * @param index
	 * @param label
	 */
	public Contener(int index, Label label) {
		super();
		this.index = index;
		this.label = label;
	}
	/**
	 * @return the tatal
	 */
	public static int getTatal() {
		return tatal;
	}
	/**
	 * @param tatal the tatal to set
	 */
	public static void setTatal(int tatal) {
		Contener.tatal = tatal;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(Label label) {
		this.label = label;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	public int getToTalIndex () {
		return 0;
		}
	/**
	 * @return the indexSwitch
	 */
	public int getIndexSwitch() {
		return indexSwitch;
	}
	/**
	 * @param indexSwitch the indexSwitch to set
	 */
	public void setIndexSwitch(int indexSwitch) {
		this.indexSwitch = indexSwitch;
	}
	

}
