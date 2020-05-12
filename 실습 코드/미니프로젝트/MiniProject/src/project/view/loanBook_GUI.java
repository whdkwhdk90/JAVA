package project.view;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.Model.Member;
import project.controller.LibraryManager;

public class loanBook_GUI extends JFrame {

   private static final long serialVersionUID = 1L;
   ImageIcon icon;

   public loanBook_GUI(LibraryManager lm, JFrame mf) {
      this.setTitle("도서 대여 및 반납");
      this.setLayout(new GridLayout(2, 1));
      this.setLocation(300, 0);
      this.setSize(800, 750);
      this.setResizable(false);
      try {
         this.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }

      icon = new ImageIcon("images/loanbook.jpg");
      JPanel panel1 = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);

            setOpaque(false);
            super.paintComponent(g);
         }
      };
      this.add(panel1);

      Font f = new Font("HY헤드라인", Font.PLAIN, 30);
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new GridLayout(3, 1));
      JButton bookLoan = new JButton("도서 대여");
      bookLoan.setFont(f);
      JButton bookReturn = new JButton("도서 반납");
      bookReturn.setFont(f);
      JButton returntoMain = new JButton("뒤로 가기");
      returntoMain.setFont(f);

      mainPanel.add(bookLoan);
      mainPanel.add(bookReturn);
      mainPanel.add(returntoMain);

      // 도서 대여 버튼 누르면 이동하는 메소드
      bookLoan.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new loanbook(lm, mf);
         }
      });

      bookReturn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new returnBook(lm, mf);
         }
      });

      returntoMain.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            mf.setVisible(true);
            dispose();
         }
      });

      this.add(mainPanel);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      this.setResizable(false);
   }

}

class loanbook extends JFrame {

   private static final long serialVersionUID = 1L;
   Date date = new Date();
   Calendar cal = Calendar.getInstance();
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   Member member = new Member();
   ImageIcon icon;

   // 회원명 및 전화번호 4자리 입력 패널
   public loanbook(LibraryManager lm, JFrame mf) {
      int num = 1; // 회원명과 전화번호 비교 후 신규 회원이면 member에 추가
      int num2 = 1; // 입력받은 도서명 비교

      this.setTitle("대여");
      this.setLayout(new GridLayout(2, 1));
      this.setBounds(300, 0, 800, 750);
      this.setResizable(false);
      try {
         this.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }

      icon = new ImageIcon("images/lend.jpg");
      JPanel panel1 = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      this.add(panel1);

      Font f = new Font("HY헤드라인", Font.PLAIN, 35);
      JPanel panel = new JPanel();
      panel.setLayout(null);
      JLabel user = new JLabel("회원명");
      user.setBounds(100, 10, 130, 100);
      user.setFont(f);
      panel.add(user);

      JLabel pnumber = new JLabel("전화번호");
      pnumber.setBounds(100, 140, 200, 100);
      pnumber.setFont(f);
      panel.add(pnumber);

      JTextField IDText = new JTextField(20);
      IDText.setBounds(300, 35, 350, 50);
      IDText.setFont(f);
      panel.add(IDText);

      JTextField numText = new JTextField(20);
      numText.setBounds(300, 165, 350, 50);
      numText.setFont(f);
      panel.add(numText);

      JButton confirm = new JButton("확인");
      confirm.setBounds(450, 270, 200, 50);
      confirm.setFont(f);
      panel.add(confirm);

      JButton back = new JButton("돌아가기");
      back.setBounds(100, 270, 200, 50);
      back.setFont(f);
      panel.add(back);

      // 회원이름 과 전화번호 입력시 실행되는 JFrame
      // 대여 원하는 도서명 입력하는 패널
      JFrame secondMain = new JFrame("대여");
      secondMain.setLayout(new GridLayout(2, 1));
      secondMain.setBounds(300, 0, 800, 750);
      secondMain.setResizable(false);

      try {
         secondMain.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }

      JPanel search = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      secondMain.add(search);

      JPanel secondpanel = new JPanel();
      secondpanel.setLayout(null);

      JLabel bookName = new JLabel("대여를 원하시는 도서명을 입력해주세요");
      bookName.setBounds(85, 45, 800, 50);
      bookName.setFont(f);
      secondpanel.add(bookName);

      JTextField bookTitle = new JTextField(20);
      bookTitle.setBounds(155, 145, 500, 50);
      bookTitle.setFont(f);
      secondpanel.add(bookTitle);

      JButton searchConfirm = new JButton("검색");
      searchConfirm.setBounds(520, 250, 200, 50);
      searchConfirm.setFont(f);
      secondpanel.add(searchConfirm);

      JButton backto = new JButton("돌아가기");
      backto.setBounds(85, 250, 200, 50);
      backto.setFont(f);
      secondpanel.add(backto);

      secondMain.add(secondpanel);

      /// 대여 원하는 도서명 입력 받고 bookList에 도서가 있을경우 확인 창 띄우기
      JFrame result = new JFrame("대여 및 반납");
      String loantime = sdf.format(cal.getTime());
      cal.setTime(date);
      cal.add(Calendar.DATE, 3);
      String returntime = sdf.format(cal.getTime());
      result.setBounds(300, 0, 800, 750);
      result.setLayout(new GridLayout(2, 1));
      result.setResizable(false);
      try {
         result.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }
      JPanel resultLoan = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      result.add(resultLoan);
      ////////////////////////////////////////////////
      // 도서대여날짜 및 반납날짜 띄어주는 패널
      JPanel resultPanel = new JPanel(null);
      JLabel message = new JLabel("도서 대여가 완료되었습니다.");
      message.setBounds(200, 20, 600, 50);
      message.setFont(f);
      resultPanel.add(message);

      JLabel loanDayMsg = new JLabel("도서 대여 날짜");
      loanDayMsg.setBounds(300, 80, 600, 50);
      loanDayMsg.setFont(f);
      resultPanel.add(loanDayMsg);

      JLabel loanDay = new JLabel(loantime);
      loanDay.setBounds(320, 130, 600, 50);
      loanDay.setFont(f);
      resultPanel.add(loanDay);

      JLabel rentDayMsg = new JLabel("반납 예정일");
      rentDayMsg.setBounds(320, 180, 600, 50);
      rentDayMsg.setFont(f);
      resultPanel.add(rentDayMsg);

      JLabel returnDay = new JLabel(returntime);
      returnDay.setBounds(320, 230, 600, 50);
      returnDay.setFont(f);
      resultPanel.add(returnDay);

      JButton confirmLoan = new JButton("확인");
      confirmLoan.setBounds(305, 290, 200, 50);
      confirmLoan.setFont(f);
      resultPanel.add(confirmLoan);

      result.add(resultPanel);
      result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // 회원명 , 전번 입력 후 확인 버튼누르면 도서명 입력으로 넘어가는 확인 버튼
      confirm.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String name = IDText.getText();
            String pnum = numText.getText();
            int res = lm.loanBook(num, name, pnum);
            if(res == 1 || res == 2 ) {
               secondMain.setVisible(true);
               dispose();
            }
         };
      });
      // 회원명 전번 입력 후 엔터치면 넘어감
      numText.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               String name = IDText.getText();
               String pnum = numText.getText();
               int res = lm.loanBook(num, name, pnum);
               if(res == 1 || res == 2 ) {
                  secondMain.setVisible(true);
                  dispose();
               }

            }

         }
      });
      back.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new loanBook_GUI(lm, mf);
         }

      });
      bookTitle.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               String title = bookTitle.getText();
               if (lm.loanBook2(num2, title) == 1) {
                  result.setVisible(true);
                  secondMain.dispose();
               } else {
                  JOptionPane.showMessageDialog(null, "찾으시는 도서가 없습니다. 다시 검색해주세요");
                  bookTitle.setText("");
               }

            }

         }
      });

      // 대여 원하는 도서명 입력 후 검색하는 버튼누를때 발생하는 action
      searchConfirm.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String title = bookTitle.getText();
            if (lm.loanBook2(num2, title) == 1) {
               result.setVisible(true);
               secondMain.dispose();
            } else {
               JOptionPane.showMessageDialog(null, "찾으시는 도서가 없습니다. 다시 검색해주세요");
               bookTitle.setText("");
            }
         }
      });
      backto.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            secondMain.dispose();
            new loanbook(lm, mf);
         }
      });

      confirmLoan.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            result.dispose();
            new loanBook_GUI(lm, mf);
         }
      });
      this.add(panel);
      this.setVisible(true);
   }

}

class returnBook extends JFrame {
   private static final long serialVersionUID = 1L;
   ImageIcon icon;

   public returnBook(LibraryManager lm, JFrame mf) {

      int num = 2;
      int num2 = 2;

      this.setTitle("반납");
      this.setLayout(new GridLayout(2, 1));
      this.setBounds(300, 0, 800, 750);
      this.setResizable(false);
      try {
         this.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }

      icon = new ImageIcon("images/return.jpg");
      JPanel image = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      this.add(image);

      Font f = new Font("HY헤드라인", Font.PLAIN, 35);
      JPanel panel1 = new JPanel();
      panel1.setLayout(null);
      JLabel label1 = new JLabel("회원명");
      label1.setBounds(100, 10, 130, 100);
      label1.setFont(f);
      panel1.add(label1);

      JLabel label2 = new JLabel("전화번호");
      label2.setBounds(100, 140, 200, 100);
      label2.setFont(f);
      panel1.add(label2);

      JTextField name_text = new JTextField(20);
      name_text.setBounds(300, 35, 350, 50);
      name_text.setFont(f);
      panel1.add(name_text);

      JTextField pnum_text = new JTextField(20);
      pnum_text.setBounds(300, 165, 350, 50);
      pnum_text.setFont(f);
      panel1.add(pnum_text);

      JButton button1 = new JButton("확인");
      button1.setBounds(450, 270, 200, 50);
      button1.setFont(f);
      panel1.add(button1);

      JButton back = new JButton("돌아가기");
      back.setBounds(100, 270, 200, 50);
      back.setFont(f);
      panel1.add(back);

      this.add(panel1);

      // memberList에 입력받은 회원명과 전번이 일치할 경우 실행되는 패널
      // 반납 도서명 검색
      JFrame returnBook_2 = new JFrame("반납");
      returnBook_2.setLayout(new GridLayout(2, 1));
      returnBook_2.setBounds(300, 0, 800, 750);
      returnBook_2.setResizable(false);

      try {
         returnBook_2.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }

      JPanel search = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      returnBook_2.add(search);

      JPanel panel4 = new JPanel();
      panel4.setLayout(null);

      JLabel label3 = new JLabel("반납 하실 도서명을 입력해주세요");
      label3.setBounds(150, 45, 800, 50);
      label3.setFont(f);
      panel4.add(label3);

      JTextField title_text = new JTextField(20);
      title_text.setBounds(155, 145, 500, 50);
      title_text.setFont(f);
      panel4.add(title_text);

      JButton button2 = new JButton("반납");
      button2.setBounds(520, 250, 200, 50);
      button2.setFont(f);
      panel4.add(button2);

      JButton backto = new JButton("돌아가기");
      backto.setBounds(85, 250, 200, 50);
      backto.setFont(f);
      panel4.add(backto);

      returnBook_2.add(panel4);

      button1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String name = name_text.getText();
            String pnum = pnum_text.getText();
            if (lm.loanBook(num, name, pnum) == 1) {
               dispose();
               returnBook_2.setVisible(true);
            } else  {
               JOptionPane.showMessageDialog(null, "회원정보가 정확하지 않습니다. 다시 입력해주세요");
               name_text.setText("");
               pnum_text.setText("");
            }
         }
      });
      pnum_text.addKeyListener(new KeyListener() {

         @Override
         public void keyTyped(KeyEvent e) {
            
         }

         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               String name = name_text.getText();
               String pnum = pnum_text.getText();
               if (lm.loanBook(num, name, pnum) == 1) {
                  dispose();
                  returnBook_2.setVisible(true);
               } else  {
                  JOptionPane.showMessageDialog(null, "회원정보가 정확하지 않습니다. 다시 입력해주세요");
                  name_text.setText("");
                  pnum_text.setText("");
               }
            }
         }

         @Override
         public void keyReleased(KeyEvent e) {

         }

      });

      button2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String title = title_text.getText();
            if (lm.loanBook2(num2, title) == 3) {
               JOptionPane.showMessageDialog(null, "도서 반납이 완료 되었습니다.");
               returnBook_2.setVisible(false);
               new loanBook_GUI(lm, mf);
            } else {
               JOptionPane.showMessageDialog(null, "해당 도서는 대여 이력이 없으므로 반납이 불가합니다.");
               title_text.setText("");
            }
         }
      });
      button2.addKeyListener(new KeyListener() {
         @Override
         public void keyPressed(KeyEvent arg0) {
            String title = title_text.getText();
            if (lm.loanBook2(num2, title) == 3) {
               JOptionPane.showMessageDialog(null, "도서 반납이 완료 되었습니다.");
               returnBook_2.setVisible(false);
               new loanBook_GUI(lm, mf);
            } else {
               JOptionPane.showMessageDialog(null, "해당 도서는 대여 이력이 없으므로 반납이 불가합니다.");
               title_text.setText("");
            }
         }

         @Override
         public void keyTyped(KeyEvent e) {

         }

         @Override
         public void keyReleased(KeyEvent e) {

         }
      });

      pnum_text.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               String name = name_text.getText();
               String pnum = pnum_text.getText();
               if (lm.loanBook(num, name, pnum) == 1) {
                  returnBook_2.setVisible(true);
               } else  {
                  JOptionPane.showMessageDialog(null, "회원정보가 정확하지 않습니다. 다시 입력해주세요");
                  name_text.setText("");
                  pnum_text.setText("");
               }

            }

         }
      });

      title_text.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               String title = title_text.getText();
               if (lm.loanBook2(num2, title) == 3) {
                  JOptionPane.showMessageDialog(null, "도서 반납이 완료 되었습니다.");
                  returnBook_2.setVisible(false);
                  new loanBook_GUI(lm, mf);
               } else {
                  JOptionPane.showMessageDialog(null, "해당 도서는 대여 이력이 없으므로 반납이 불가합니다.");
                  title_text.setText("");
               }
            }
         }
      });

      back.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new loanBook_GUI(lm, mf);
         }

      });
      backto.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            returnBook_2.dispose();
            new returnBook(lm, mf);
         }
      });
      this.setVisible(true);
      this.add(panel1);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}