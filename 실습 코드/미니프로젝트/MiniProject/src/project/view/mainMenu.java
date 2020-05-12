package project.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project.controller.LibraryManager;

public class mainMenu {


   ImageIcon icon;
   LibraryManager lm = new LibraryManager();
   JFrame mf = new JFrame();

   public mainMenu() {
	   
      // 메인메뉴 기본 설정
      mf.setTitle("도서 관리 프로그램");
      mf.setLayout(new GridLayout(2, 1));
      mf.setLocation(300, 0);
      mf.setSize(900, 850);
      mf.setResizable(false);
      
      // 메인 메뉴 사진 설정
      try {
         mf.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }

      icon = new ImageIcon("images/bookMain.png");
      JPanel panel1 = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            // drawimage(img, x,y, width, height, observer);
            // 투명하게
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      mf.add(panel1);

      // 버튼 추가 및 설정
      Font f = new Font("HY헤드라인", Font.PLAIN, 30);
      JPanel panel2 = new JPanel();
      panel2.setLayout(new GridLayout(8, 1));
      JButton button1 = new JButton("도서 추가");
      JButton button2 = new JButton("도서 삭제 및 수정");
      JButton button3 = new JButton("도서 대여 및 반납");
      JButton button4 = new JButton("조회 책 - 연체 금액");
      JButton button5 = new JButton("금주의 책");
      JButton button6 = new JButton("연체 관리");
      JButton button7 = new JButton("로그인 화면으로");
      JButton button8 = new JButton("프로그램 종료");
      button1.setFont(f);
      button2.setFont(f);
      button3.setFont(f);
      button4.setFont(f);
      button5.setFont(f);
      button6.setFont(f);
      button7.setFont(f);
      button8.setFont(f);
      panel2.add(button1);
      panel2.add(button2);
      panel2.add(button3);
      panel2.add(button4);
      panel2.add(button5);
      panel2.add(button6);
      panel2.add(button7);
      panel2.add(button8);

      // 버튼에 따른 클래스 동작
      button1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            mf.dispose();
           new addBook_GUI(lm,mf);
         }
      });

      button2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.dispose();
            new changeBook_GUI(lm,mf);
         }
      });

      button3.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            new loanBook_GUI(lm,mf);
            mf.dispose();
         }
      });

      button4.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.dispose();
            new search_GUI(lm,mf);
         }
      });

      button5.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.dispose();
           new weekBook_GUI(lm,mf);
         }
      });

      button6.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.dispose();
            new overdueBook_GUI(lm,mf);
         }
      });

      button7.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.dispose();
            new LoginMenu();
         }
      });

      button8.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });

      // 패널2를 mf에 추가
      mf.add(panel2);
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mf.setVisible(true);

   }
}