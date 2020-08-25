package project.view;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.controller.LibraryManager;

public class addBook_GUI extends JFrame {
   
   private static final long serialVersionUID = 1L;
   
   ImageIcon icon;
   
   public addBook_GUI(LibraryManager lm, JFrame mf) {
         this.setSize(900, 750);
         this.setTitle("도서 추가");
         this.setLocation(500, 0);
         this.setLayout(new GridLayout(2, 1));
         try {
             this.setIconImage(ImageIO.read(new File("images/book.png")));
          } catch (IOException e) {
             e.printStackTrace();
          }
         
         icon = new ImageIcon("images/도서추가.jpg");
         
         JPanel panel1 = new JPanel() {
            public void paint(Graphics g) {
                  Dimension d = getSize();
                  g.drawImage(icon.getImage(), 0, 0, 900, 350, null);
                  setOpaque(false);
                  super.paintComponent(g);
               }
         };
         
         JPanel panel2 = new JPanel();
         panel2.setLayout(new GridLayout(4,2));
         Font f = new Font("HY헤드라인", Font.BOLD, 35);
         
         JTextField Title = new JTextField(25);
         Title.setFont(f);
         Title.setBounds(100,70,700,30);
         JLabel titleLabel = new JLabel("▶ 도서명 :");
         titleLabel.setFont(f);
         titleLabel.setHorizontalAlignment(JLabel.CENTER);
         panel2.add(titleLabel);
         panel2.add(Title);
         
         JLabel authorLabel = new JLabel("▶ 저자 :");
         JTextField Author = new JTextField(25);
         Author.setFont(f);
         authorLabel.setFont(f);
         Author.setBounds(100,70,700,30);
         authorLabel.setHorizontalAlignment(JLabel.CENTER);
         panel2.add(authorLabel);
         panel2.add(Author);
         
         JLabel priceLabel = new JLabel("▶ 가격 :");
         priceLabel.setHorizontalAlignment(JLabel.CENTER);
         priceLabel.setFont(f);
         panel2.add(priceLabel);
         
         JTextField Price = new JTextField(25);
         Price.setFont(f);
         Price.setBounds(100,70,700,30);
         panel2.add(Price);
         
         JButton button1 = new JButton("뒤로가기");
         button1.setFont(f);
         panel2.add(button1);
         button1.setBounds(300,500,200,200);
         
         JButton button2 = new JButton("추가");
         button2.setFont(f);
         panel2.add(button2);
         button1.setBounds(300,500,200,200);
         
            //마우스 위치 잡아버리기
            try {
            Robot robot = new Robot();
            robot.mouseMove(910, 480); 
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); //마우스 우클릭
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            
         } catch (AWTException e1) {
            e1.printStackTrace();
         }
         
         //뒤로가기 버튼을 눌렀을 때 반응
         button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               mf.setVisible(true);
            }
         });
         
         //추가 버튼을 눌렀을 때 반응
         button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String author = Author.getText();
              String title = Title.getText();
              String price = Price.getText();
              lm.addBook(author,title,price);
              JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다.");
               dispose();
               mf.setVisible(true);
            }
         });
         //메인프레임에 패널추가 및 종료 설정
         this.add(panel1);
         this.add(panel2);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
         this.setResizable(false);
      }
}