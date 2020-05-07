package project.controller;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import project.Model.Book;
import project.Model.BookSorting;
import project.Model.Member;

public class LibraryManager {

   private ArrayList<Book> bookList = new ArrayList<>();
   private ArrayList<Member> memberList = new ArrayList<>();
   private ArrayList<Member> delayList = new ArrayList<>();
   private Date date = null;
   private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   private String name, pnum;

   public LibraryManager() {
      memberList.add(new Member("홍길동", "8405"));
      memberList.add(new Member("아무개", "4333"));
      bookList.add(new Book("이순신", "거북선", "13000"));
      bookList.add(new Book("이우진", "노인과 바다", "17000"));
      bookList.add(new Book("김승진" , "황금독수리 세상을 놀라게하다" , "17000"));
   }

   public void addBook(String author, String title, String price) {
      bookList.add(new Book(author, title, price));
   }

   public int deleteBook(String title) {    
    for(int i=0;i<bookList.size();i++) {
       if(bookList.get(i).getTitle().equals(title)) {
          bookList.remove(i);       
          JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
          return 1;
       }
    }
    JOptionPane.showMessageDialog(null, "잘못된 책이름이거나 책이 없습니다. 다시 입력해주세요.");
    return 0;

 }

   public int reviseBook(String title, JFrame mf) {
    for(int i=0;i<bookList.size();i++) {
       if(bookList.get(i).getTitle().equals(title)) {               
             reviseBook2(i,mf);
             return 1;
       }
    }
    JOptionPane.showMessageDialog(null, "잘못된 책이름이거나 책이 없습니다. 다시 입력해주세요.");
      	return 0;
 }
 
   public void reviseBook2(int i,JFrame mf) {
	   int countnumber = 0;
	   ImageIcon icon;
	   JFrame mf1 = new JFrame();
	      mf1.setTitle("수정할 도서 정보");
	      mf1.setLayout(new GridLayout(2,1));
	      mf1.setLocation(300, 0);
	      mf1.setSize(900, 850);
	      mf1.setResizable(false);
	   
	   try {
	        mf1.setIconImage(ImageIO.read(new File("images/book.png")));
	     } catch (IOException e) {
	        e.printStackTrace();
	     }
	    
	    icon = new ImageIcon("images/deletebook.jpg");
	      JPanel panel1 = new JPanel() {
	         public void paint(Graphics g) {
	            Dimension d = getSize();
	            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	            // drawimage(img, x,y, width, height, observer);
	            // 투명하게
	            setSize(900,450);   
	            setOpaque(false);
	            super.paintComponent(g);
	         }
	      };
	      mf1.add(panel1);
 
	   Font f = new Font("HY헤드라인", Font.PLAIN, 30);
    
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setSize(500,450);
       
    JLabel Ltitle = new JLabel("책 제목을 입력해주세요");
    Ltitle.setBounds(200, 50, 500, 25);
    Ltitle.setHorizontalAlignment(JLabel.CENTER);
    Ltitle.setFont(f);
    panel.add(Ltitle);
       
    JLabel Lauthor = new JLabel("저자를 입력해주세요");
    Lauthor.setBounds(200, 150, 500, 25);       
    Lauthor.setHorizontalAlignment(JLabel.CENTER);
    Lauthor.setFont(f);
    panel.add(Lauthor);
       
    JLabel Lprice = new JLabel("가격을 입력해주세요");
    Lprice.setBounds(200, 250, 500, 25);
    Lprice.setHorizontalAlignment(JLabel.CENTER);
    Lprice.setFont(f);
    panel.add(Lprice);
     
    JTextField tit = new JTextField(20);
    tit.setBounds(200, 100, 500, 25);
    tit.setHorizontalAlignment(JTextField.CENTER);
    panel.add(tit);
       
    JTextField aut = new JTextField(20);
    aut.setBounds(200, 200, 500, 25);
    aut.setHorizontalAlignment(JTextField.CENTER);
    panel.add(aut);
    
    JTextField pri = new JTextField(20);
    pri.setBounds(200, 300, 500, 25);
    pri.setHorizontalAlignment(JTextField.CENTER);
    panel.add(pri);
    
    JButton resetButton = new JButton("Reset");
    resetButton.setBounds(250,370,150,25);
    resetButton.setFont(f);
    panel.add(resetButton);
       
    JButton searchButton = new JButton("확인");
    searchButton.setBounds(550,370,150,25);  
    searchButton.setFont(f);
    panel.add(searchButton);
     

    pri.addKeyListener(new KeyListener() {
       
       @Override
       public void keyTyped(KeyEvent e) {
       }
       
       @Override
       public void keyReleased(KeyEvent e) {
       }
       
       @Override
       public void keyPressed(KeyEvent e) {
          if(e.getKeyCode() == KeyEvent.VK_ENTER) {
             String title = tit.getText();
             String author = aut.getText();
             String price = pri.getText();
             
             bookList.set(i, new Book(author,title,price));
             JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
             mf1.setVisible(false);   
             mf.setVisible(true);
          }
          
       }
    });
     
    searchButton.addActionListener(new ActionListener() {
       
       @Override
       public void actionPerformed(ActionEvent e) {
          String title = tit.getText();
          String author = aut.getText();
          String price = pri.getText();
          
          bookList.set(i, new Book(author,title,price));
          JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
          mf1.setVisible(false);     
          mf.setVisible(true);
       }
    });
     
    
    resetButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tit.setText("");
			aut.setText("");
			pri.setText("");
			tit.requestFocus();
		}
	});

    mf1.add(panel);
    mf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mf1.setVisible(true);
 }

   public int loanBook(int num, String name, String pnum) {
     int res = 0;
     Member member = null;
     date = new Date();
     // 대여 및 반납창에서
     // num == 1 이면 대여창
     if (num == 1) {
        for (int i = 0; i < memberList.size(); i++) {
           if (!(memberList.get(i).getName().equals(name) && memberList.get(i).getPnum().equals(pnum))) {
              res = 1;
           } else {
              res = 2;
           }
        }
        // num2 == 2이면 반납창.
     } else if (num == 2) {
        for (int i = 0; i < memberList.size(); i++) {
           if (memberList.get(i).getName().equals(name) && memberList.get(i).getPnum().equals(pnum)) {
              member = memberList.get(i);
           }
        }
        if (member != null) {
           res = 1;
        } else
           res = 0;
     }
     this.name = name;
     this.pnum = pnum;
     return res;
  }

   public int loanBook2(int num2, String title) {
     ArrayList<String> lendTime = new ArrayList<>();
     ArrayList<Book> bArr = new ArrayList<Book>();
     Calendar cal = Calendar.getInstance();
     Member member = null;
     Book book = null;
     String returntime = "";
     int res2 = 0;

     if (num2 == 1) {
        for (int i = 0; i < bookList.size(); i++) {
           if (bookList.get(i).getTitle().equals(title)) {
              book = bookList.get(i);
              bookList.get(i).setCount(book.getCount() + 1);
              bArr.add(book);
           }
        }
        res2 = 1;
        if (book == null) {
           res2 = 0;
        }
        cal.setTime(date);
        cal.add(Calendar.DATE, 3);
        returntime = sdf.format(cal.getTime());
        lendTime.add(returntime);

        for (int i = 0; i < memberList.size(); i++) {
           if ((memberList.get(i).getName().equals(this.name) && memberList.get(i).getPnum().equals(this.pnum))) {
              member = memberList.get(i);
           }
        }
        if (member != null) {
           for (int i = 0; i < memberList.size(); i++) {
              if ((memberList.get(i).getName().equals(this.name)
                    && memberList.get(i).getPnum().equals(this.pnum))) {
                 memberList.get(i).setTitleList(bArr);
                 memberList.get(i).setLendTime(lendTime);
              }
           }
        } else {
           memberList.add(new Member(this.name, lendTime, this.pnum, bArr));
        }

     } else if (num2 == 2) {
        for (int i = 0; i < memberList.size(); i++) {
           for (int j = 0; j < memberList.get(i).getTitleList().size(); j++) {
              if (memberList.get(i).getTitleList().get(j).getTitle().equals(title)) {
                 book = memberList.get(i).getTitleList().get(j);
              }
           }
        }
        if (book != null) {
           for (int i = 0; i < memberList.size(); i++) {
              for (int j = 0; j < memberList.get(i).getTitleList().size(); j++) {
                 if (memberList.get(i).getName().equals(this.name) && memberList.get(i).getPnum().equals(this.pnum)) {
                    if (memberList.get(i).getTitleList().get(j).getTitle().equals(title)) {
                       memberList.get(i).getTitleList().remove(j);
                       memberList.get(i).getLendTime().remove(j);
                    }
                 }
              }
           }
           res2 = 3;
        } else
           res2 = 4;
     }
     return res2;
  }

   public String weekBook() {
	      ArrayList<Book> list = bookList;

	      list.sort(new BookSorting());

	      String str = "<html>동률 시 가나다 순<br>";

	      for (int i = 0; i < list.size(); i++) {
	         if (i < 3) {
	            if (list.get(i).getCount() > 0) {
	               str += (i+1) + "위 : " + list.get(i).getTitle() + " " + list.get(i).getCount() + "회<br>";
	            }
	         }

	      }
	      str += "</html>";
	      if (str.equals("<html>동률 시 가나다 순<br></html>")) {
	         return "빌린책이 없습니다.";
	      }
	      return str;
	   }

   public String overdueBook() {

      // 연체도서 목록
      String str = "";
      String temp = "";
      int fee = 0;
      Calendar cal = Calendar.getInstance();
      temp = sdf.format(cal.getTime());
      try {

         // 현재 날짜
         for (int i = 0; i < memberList.size(); i++) {
            if (!memberList.get(i).getTitleList().isEmpty() && !memberList.get(i).getLendTime().isEmpty()) {
               for (int j = 0; j < memberList.get(i).getLendTime().size(); j++) {
                  Date lendTime = sdf.parse(memberList.get(i).getLendTime().get(j));
                  Date currentTime = sdf.parse(temp);
                  // 현재 날짜의 +3일
                  long DateSub = lendTime.getTime() - currentTime.getTime();
                  long DateSubDays = DateSub / (1000 * 60 * 60 * 24);
                  if (lendTime.getTime() > currentTime.getTime()) {
                     // 반납 예정일이 현재 날짜보다 작으면 연체임(<)
                     fee = (int) Math.abs(DateSubDays) * 100;
                     str += "           " + memberList.get(i).getName() + "      " + memberList.get(i).getPnum()
                           + "\t" + memberList.get(i).getTitleList().get(j).getTitle() + "\t"
                           + sdf.format(lendTime) + "\t" + fee + "\n";

                     memberList.get(i).setFee(fee);
                     delayList.add(memberList.get(i));
                  }
               }
            }
         }
//         System.out.println("delayList: " + delayList);
      } catch (ParseException e) {
         e.printStackTrace();
      }
      return str;
   }

   public String[][] bookList() {

      String[][] contents = new String[bookList.size()][3];

      for (int i = 0; i < contents.length; i++) {
         contents[i][0] = bookList.get(i).getTitle();
         contents[i][1] = bookList.get(i).getAuthor();
         contents[i][2] = bookList.get(i).getPrice();
      }
      return contents;
   }

   public String[][] memberList() {
      // 고객정보 출력
      String[][] contents = new String[memberList.size()][4];

      String fee = "X";

      for (int i = 0; i < memberList.size(); i++) {
         if (memberList.get(i).getFee() != 0) {
            fee = "O";
         }
         contents[i][0] = memberList.get(i).getName();
         contents[i][1] = memberList.get(i).getPnum();
         contents[i][2] = fee;
         for (int j = 0; j < memberList.get(i).getTitleList().size(); j++) {
            contents[i][3] += memberList.get(i).getTitleList().get(j).getTitle()+" ";
         }

      }

      return contents;
   }

   public String[][] search(int num, String name) {

      String[][] contents = null;

      if (num == 1) {
         // 책제목으로 검색
         contents = new String[bookList.size()][3];
         for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equals(name)) {
               contents[0][0] = bookList.get(i).getTitle();
               contents[0][1] = bookList.get(i).getAuthor();
               contents[0][2] = bookList.get(i).getPrice();
            }
         }

      } else if (num == 2) {
         contents = new String[memberList.size()][4];
         // 고객 검색 후 고객정보,대여중인 책
         String fee = "X";
         for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getName().equals(name)) {
               if (memberList.get(i).getFee() != 0) {
                  fee = "O";
               }
               contents[0][0] = memberList.get(i).getName();
               contents[0][1] = memberList.get(i).getPnum();
               contents[0][2] = fee;
               for (int j = 0; j < memberList.get(i).getTitleList().size(); j++) {
                  contents[0][3] = memberList.get(i).getTitleList().get(j).getTitle()+" ";
               }
            }
         }
      }
      return contents;
   }

   public ArrayList<Member> getDelayList() {
      return delayList;
   }

   public void setDelayList(ArrayList<Member> delayList) {
      this.delayList = delayList;
   }

}