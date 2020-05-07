package project.view;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import project.controller.LibraryManager;


public class LoginMenu extends JFrame{
   private static final long serialVersionUID = 1L;
  
   ImageIcon icon;
   LibraryManager lm = new LibraryManager();
   
   public LoginMenu() {
	   
      try {
         this.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception useDefault) {
      }
      
    
      
      
      
      CardLayout cards = new CardLayout();  
	  this.setLayout(cards); 
      this.setTitle("관리자 로그인");
      this.setSize(900, 850);
      this.setVisible(true);
      this.setLocation(300,000);
      
      JPanel fpanel = new JPanel();
      fpanel.setLayout(new GridLayout(2,1));
      fpanel.setSize(900, 850);
      fpanel.setVisible(true);
      
      JPanel spanel = new JPanel();
      spanel.setLayout(new GridLayout(2,1));
      spanel.setSize(900, 850);
      spanel.setVisible(true);
      
      
     
      
      
      //아이콘 이미지 바꾸기
      try {
          this.setIconImage(ImageIO.read(new File("images/book.png")));
       } catch (IOException e) {
          e.printStackTrace();
       }
      
      //패널에 그림 추가
      icon = new ImageIcon("images/bookMain.png");
      JPanel panel1 = new JPanel(){
    	  public void paint(Graphics g) {
    		  Dimension d = getSize();
    		  setLayout(null);
            g.drawImage(icon.getImage(), 0, 0, d.width,d.height, null);
            setSize(900,550);
            //투명하게
            setOpaque(false);
            super.paintComponent(g);
         }
      };
     
      

     JPanel panel2 = new JPanel();
     panel2.setLayout(null);
     panel2.setSize(900,300);
     Font f = new Font("HY헤드라인", Font.PLAIN, 30);
     
     JLabel user = new JLabel("아이디");
     user.setFont(f);
     user.setHorizontalAlignment(JLabel.RIGHT);
     user.setBounds(180, 170, 130, 50);
     panel2.add(user);
     
     JLabel pass = new JLabel("비밀번호");
     pass.setFont(f);
     pass.setHorizontalAlignment(JLabel.RIGHT);
     pass.setBounds(170, 250, 130, 50);
     panel2.add(pass);
     
     JTextField ID = new JTextField(20);
     ID.setFont(f);
     ID.setBounds(350, 170, 350, 50);
     panel2.add(ID);
     
    
     this.addWindowFocusListener(new WindowAdapter() {
   	  @Override
   	public void windowOpened(WindowEvent e) {
   		
   		super.windowOpened(e);
   	}
	});
     
     
     JPasswordField PW = new JPasswordField(20);
     PW.setFont(f);
     PW.setBounds(350, 250, 350, 50);
     panel2.add(PW);
         
     JButton resetButton = new JButton("Reset");
     resetButton.setFont(f);
     resetButton.setBounds(170 , 330 , 200 , 50);
     panel2.add(resetButton);
     
     
     
     resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           ID.setText("");
           PW.setText("");
           ID.requestFocus();
        }
     });
     
     //로그인 버튼 설정
     JButton loginButton = new JButton("Login");
     loginButton.setBounds(500, 330, 200, 50);
     loginButton.setFont(f);
     panel2.add(loginButton);  
     fpanel.add(panel1); 
     fpanel.add(panel2);
	    
	    //로그인버튼 눌렀을 때 반응
	    loginButton.addActionListener(new ActionListener() {
	       @SuppressWarnings("deprecation")
			@Override
	       public void actionPerformed(ActionEvent e) {
	          if(ID.getText().equals("user1") && PW.getText().equals("user11")) {
	           
	             dispose();
	             new mainMenu();
	          } else {
	        	    getContentPane().removeAll(); // 등록된 모든 컨테이너 삭제
	            	getContentPane().add(spanel, BorderLayout.CENTER); // 다시 등록
	            	setContentPane(getContentPane()); // 프레임에 설정 (this : Frame )
	            	spanel.requestFocus();
	        	 
	          }
	       }

	  });  
	
	     JPanel panel3 = new JPanel();
    	  panel3.setLayout(null);
          panel3.setSize(900,300);
		
	      JLabel checkInfo = new JLabel("잘못입력하셨습니다. 다시입력해주세요");
	      checkInfo.setFont(f);
	      checkInfo.setHorizontalAlignment(JLabel.CENTER);
	      checkInfo.setBounds(10, 180, 850, 50);
	      panel3.add(checkInfo);
	      	          
	      JButton checkButton = new JButton("확인");
	      checkButton.setFont(f);
	      checkButton.setBounds(330, 280, 200, 50);
	      panel3.add(checkButton);
	      
  
	      icon = new ImageIcon("images/bookMain.png");
	      JPanel panel4 = new JPanel(){
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
	    		  Dimension d = getSize();
	    		  setLayout(null);
	            g.drawImage(icon.getImage(), 0, 0, d.width,d.height, null);
	            setSize(900,550);
	            //투명하게
	            setOpaque(false);
	            super.paintComponent(g);
	         }
	      };
	      
	     
     
	    //확인버튼 눌렀을 때 반응
	    checkButton.addActionListener(new ActionListener() {
			@Override
	       public void actionPerformed(ActionEvent e) {		
				 getContentPane().removeAll(); // 등록된 모든 컨테이너 삭제
	             getContentPane().add(fpanel, BorderLayout.CENTER); // 다시 등록
	             setContentPane(getContentPane()); // 프레임에 설정 (this : Frame )
	             ID.setText("");
	             PW.setText("");
	             ID.requestFocus();
	       }

	  });  
   
	    
	    //id 텍스트필드에서 엔터 눌렀을 때 반응
	    ID.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(ID.getText().equals("user1") && PW.getText().equals("user11")) {		              
							dispose();
			              new mainMenu();
			            } else {			            	
			            	getContentPane().removeAll(); // 등록된 모든 컨테이너 삭제
			            	getContentPane().add(spanel, BorderLayout.CENTER); // 다시 등록
			            	setContentPane(getContentPane()); // 프레임에 설정 (this : Frame )
			            	spanel.requestFocus();
			            }
					
				}
				
			}
		});
	    
	    //pw 텍스트필드에서 엔터 눌렀을 때 반응
	    PW.addKeyListener(new KeyListener() {
	  		
	  		@Override
	  		public void keyTyped(KeyEvent e) {
	  		}
	  		
	  		@Override
	  		public void keyReleased(KeyEvent e) {
	  		}
	  		
	  		@SuppressWarnings("deprecation")
				@Override
	  		public void keyPressed(KeyEvent e) {
	  			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	  				if(ID.getText().equals("user1") && PW.getText().equals("user11")) {   
	  		               //로그인 성공 시 띄울 JFrame 메인 화면
	  		             dispose();
	  		               new mainMenu();
	  		            } else {
	  		            	getContentPane().removeAll(); // 등록된 모든 컨테이너 삭제
			            	getContentPane().add(spanel, BorderLayout.CENTER); // 다시 등록
			            	setContentPane(getContentPane()); // 프레임에 설정 (this : Frame ) 
			            	spanel.requestFocus();
	  		            }	  				
	  			}	  			
	  		}
	  	});
	    
	
	    
	    spanel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					getContentPane().removeAll(); // 등록된 모든 컨테이너 삭제
	            	getContentPane().add(fpanel, BorderLayout.CENTER); // 다시 등록
	            	setContentPane(getContentPane()); // 프레임에 설정 (this : Frame ) 
	            	ID.setText("");
	            	PW.setText("");
	            	ID.requestFocus();
				}
			}
		});
	    	    
	  spanel.add(panel4);
	  spanel.add(panel3);
  
	  cards.addLayoutComponent(fpanel, "1");
	  cards.addLayoutComponent(spanel, "2");
	         	  
	  this.add(fpanel);
	  this.add(spanel);
	        
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }

  
   public static void main(String[] args) {
	   new LoginMenu();
	   
	   
	   //마우스 위치 잡기
	   try {
			Robot robot = new Robot();
			robot.mouseMove(700, 620);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); //마우스 우클릭
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	   
   	}


}
	
