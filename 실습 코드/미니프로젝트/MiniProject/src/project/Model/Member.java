package project.Model;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Member {

	private String name;
	private String pnum;
	private int fee;
	private ArrayList<String> lendTime = new ArrayList<>();
	private ArrayList<Book> titleList = new ArrayList<>();
	
	public Member() {}
	
	public Member(String name, String pnum) {
		this.name = name;
		this.pnum = pnum;
	}
	
	public Member(String name, String pnum, ArrayList<Book> titleList) {
		super();
		this.name = name;
		this.pnum = pnum;
		this.titleList = titleList;
	}
	
	public Member(String name, ArrayList<String> lendTime, String pnum, ArrayList<Book> titleList) {
		this.lendTime.addAll(lendTime);
		this.name = name;
		this.pnum = pnum;
		this.titleList = titleList;
		
	}
	
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee += fee;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	
	public ArrayList<String> getLendTime() {
		return lendTime;
	}
	public void setLendTime(ArrayList<String> lendTime) {
		this.lendTime.addAll(lendTime);
	}
	
	public ArrayList<Book> getTitleList() {
		return titleList;
	}
	public void setTitleList(ArrayList<Book> titleList) {
		this.titleList.addAll(titleList);
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", pnum=" + pnum + ", fee=" + fee + ", lendTime=" + lendTime + ", titleList="
				+ titleList + "]";
	}
	
}












