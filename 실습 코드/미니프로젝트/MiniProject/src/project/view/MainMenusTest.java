package project.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import project.controller.LibraryManager;

public class MainMenusTest extends JFrame {
   private static final long serialVersionUID = 1L;
   LibraryManager lm = new LibraryManager();
   ImageIcon icon;

   public MainMenusTest() {
      try {
         this.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception useDefault) {
      }
      this.setTitle("도서 관리 프로그램");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationByPlatform(true);
      this.setSize(1200, 750);
      this.setVisible(true);

      JComponent UI = new JPanel(new BorderLayout(4, 4));
      UI.setBorder(new TitledBorder("e-Book Manager"));

      CardLayout cardLayout = new CardLayout();
      icon = new ImageIcon("images/bookMain.png");
      JPanel cards = new JPanel(cardLayout) {
         private static final long serialVersionUID = 1L;
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 45, 20, 900, 650, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };

      cards.setBorder(new TitledBorder("Main Frame"));
      cards.setSize(700, 500);
      UI.add(cards);

      JPanel lineStart = new JPanel(new GridBagLayout());

      JPanel buttonsCentered = new JPanel(new GridLayout(0, 1, 60, 55));
      buttonsCentered.setBorder(new TitledBorder("메뉴 화면"));
      lineStart.add(buttonsCentered);

      UI.add(lineStart, BorderLayout.LINE_START);
      Font f = new Font("HY헤드라인", Font.PLAIN, 17);
      JButton button1 = new JButton("도서 추가");
      buttonsCentered.add(button1);
      JButton button2 = new JButton("도서 삭제 및 수정");
      buttonsCentered.add(button2);
      JButton button3 = new JButton("도서 대여 및 반납");
      buttonsCentered.add(button3);
      JButton button4 = new JButton("조회(책,회원)");
      buttonsCentered.add(button4);
      JButton button5 = new JButton("금주의 책");
      buttonsCentered.add(button5);
      JButton button6 = new JButton("연체 관리");
      buttonsCentered.add(button6);
      JButton button7 = new JButton("로그인 화면으로");
      buttonsCentered.add(button7);
      JButton button8 = new JButton("프로그램 종료");
      button1.setFont(f);
      button2.setFont(f);
      button3.setFont(f);
      button4.setFont(f);
      button5.setFont(f);
      button6.setFont(f);
      button7.setFont(f);
      button8.setFont(f);
      buttonsCentered.add(button8);

      button1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
          }
       });
      
      button2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
          }
       });
      
      button3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
          }
       });
      
      button4.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
          }
       });
      
      button5.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
          }
       });
      
      button6.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
          }
       });
      
      button7.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            
          }
       });
      
      button8.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	 System.exit(0);
         }
      });

      this.add(UI);
      this.setResizable(false);
   }
}