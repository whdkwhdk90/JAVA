package project.view;

import java.awt.Color;
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.controller.LibraryManager;

public class weekBook_GUI extends JFrame {
   ImageIcon icon;

   public weekBook_GUI(LibraryManager lm, JFrame mf) {
      this.setTitle("금주의 책");
      this.setLocation(300, 0);
      this.setSize(800, 750);
      this.setLayout(new GridLayout(2, 1));
      try {
         this.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();

      }
      icon = new ImageIcon("images/Bestseller.jpg");
      JPanel panelimages = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };

      JPanel panel1 = new JPanel();
      JLabel label1 = new JLabel();
      label1.setText(lm.weekBook());
      if (lm.weekBook().equals("빌린책이 없습니다.")) {
         label1.setFont(new Font("배달의민족 한나는 열한살", Font.TYPE1_FONT, 40));
         label1.setBounds(220, 100, 800, 100);
      } else {
         label1.setFont(new Font("배달의민족 한나는 열한살", Font.TYPE1_FONT, 15));
         label1.setBounds(200, 90, 800, 120);
      }
      panel1.setLayout(null);
      panel1.setSize(800, 200);

      panel1.add(label1);
      panel1.setBackground(Color.WHITE);

      JButton button1 = new JButton("닫기");
      button1.setFont(new Font("배달의민족 한나는 열한살", Font.TYPE1_FONT, 15));
      panel1.add(button1);
      button1.setBounds(270, 220, 250, 50);

      button1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.setVisible(true);
            dispose();
         }
      });

      button1.addKeyListener(new KeyListener() {

         @Override
         public void keyTyped(KeyEvent e) {

         }

         @Override
         public void keyReleased(KeyEvent e) {

         }

         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               mf.setVisible(true);
               dispose();
            }
         }
      });
      this.add(panelimages);
      this.add(panel1);
      this.setVisible(true);

   }
}