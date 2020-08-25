package project.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import project.controller.LibraryManager;

public class changeBook_GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	public changeBook_GUI(LibraryManager lm, JFrame mf) {

		 // 메인메뉴 기본 설정
	      this.setTitle("도서 삭제 및 수정");
	      this.setLayout(new GridLayout(2, 1));
	      this.setLocation(300, 0);
	      this.setSize(900, 850);
	      this.setResizable(false);

	      // 메인 메뉴 사진 설정
	      try {
	         this.setIconImage(ImageIO.read(new File("images/book.png")));
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
	            setOpaque(false);
	            super.paintComponent(g);
	         }
	      };
	      this.add(panel1);
	     
	      Font f = new Font("HY헤드라인", Font.PLAIN, 50);
	      JPanel panel2 = new JPanel();
	      panel2.setLayout(new GridLayout(3, 1));
	      JButton button1 = new JButton("도서 삭제");
	      button1.setFont(f);
	      JButton button2 = new JButton("도서 수정");
	      button2.setFont(f);
	      JButton button3 = new JButton("뒤로 가기");
	      button3.setFont(f);
	      
	      panel2.add(button1);
	      panel2.add(button2);
	      panel2.add(button3);
	      

	      button1.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	dispose();
	           new deleteBook(lm,mf).setVisible(true);
	           
	         }
	      });

	      button2.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e) {
	           dispose();
	           new reviseBook(lm,mf).setVisible(true);
	         }
	      });

	      button3.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e) { 
	        	 dispose();
	        	mf.setVisible(true);
	        	 
	         }
	      });

	      this.add(panel2);
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setVisible(true);
      
	   }
	
}

class deleteBook extends JFrame{

	private static final long serialVersionUID = 1L;
	ImageIcon icon;

	
	public deleteBook(LibraryManager lm,JFrame mf) {
		
		 
		  this.setTitle("도서 삭제");
	      this.setLayout(new GridLayout(3, 1, 0, 70));
	      this.setLocation(300, 0);
	      this.setSize(900, 850);
	      this.setResizable(false);
	    
	      
	     
	      
	      
	    try {
	        this.setIconImage(ImageIO.read(new File("images/book.png")));
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
	            setSize(900,279);   
	            setOpaque(false);
	            super.paintComponent(g);
	         }
	      };
	      this.add(panel1);
	    
   
	    JPanel panel3 = new JPanel();
	    panel3.setSize(900,300);
		//테이블만들기
		String header[]= {"책 제목","작가","가격"};
		String contents[][]=null;
	    contents = lm.bookList();
	    
	    Font f1 = new Font("신명조", Font.PLAIN, 15);

	   
	    DefaultTableModel dtm = new DefaultTableModel(contents,header) {
	    	@Override
	    	public boolean isCellEditable(int row, int column) {
	    		return false;
	    	}
	    };
	    
	    JTable table = new JTable(dtm);
	    table.setFont(f1);
	    
	    //헤더를 가운데정렬
	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);
	    table.getTableHeader().setDefaultRenderer(renderer);
	    
	    //테이블 내용을 가운데 정렬
	    DefaultTableCellRenderer contentsCenterP = new DefaultTableCellRenderer();
	    contentsCenterP.setHorizontalAlignment(SwingConstants.CENTER);
	    TableColumnModel tp = table.getColumnModel();
	    
	    
	    for(int i =0;i<tp.getColumnCount();i++) {
	    	tp.getColumn(i).setCellRenderer(contentsCenterP);
	    }
	    
	    
	    
	    //이동 불가
	    table.getTableHeader().setReorderingAllowed(false);
	    //크기 조정 불가
	    table.getTableHeader().setResizingAllowed(false);
	    
	    
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setPreferredSize(new Dimension(700,150));
	    panel3.add(scrollPane,"South");
	    this.add(panel3,"Center");
	   
 
	    Font f = new Font("HY헤드라인", Font.PLAIN, 20); 
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(null);
	    panel2.setSize(900,340);
	    
	    JLabel nameL = new JLabel("삭제하실 책이름를 입력하세요");
	    nameL.setBounds(100, 10, 700, 25);
	    nameL.setFont(f);
	    nameL.setHorizontalAlignment(JLabel.CENTER);
	    panel2.add(nameL);
	    
	    JTextField num = new JTextField();
	    num.setBounds(250, 60, 400, 25);
	    num.setHorizontalAlignment(JTextField.CENTER);
	    panel2.add(num);
	    
	    JButton backButton = new JButton("뒤로 가기");
	    backButton.setBounds(150,160,150,25);
	    backButton.setFont(f);
	    panel2.add(backButton);
	    
	    JButton resetButton = new JButton("Reset");
	    resetButton.setBounds(370,160,150,25);
	    resetButton.setFont(f);
	    panel2.add(resetButton);
	      
	    JButton searchButton = new JButton("검색");
	    searchButton.setBounds(600,160,150,25);
	    searchButton.setFont(f);
	    panel2.add(searchButton);
	    
    
	    this.addWindowListener(new WindowAdapter() {
	    	  @Override
	    	public void windowOpened(WindowEvent e) {
	    		num.requestFocus();
	    		super.windowOpened(e);
	    	}
		});
	    

	    
	    num.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {	
			}
				
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String title = num.getText();			
					if(lm.deleteBook(title) == 1) {
						dispose();
						mf.setVisible(true);
					}else {
						new deleteBook(lm,mf);
						num.requestFocus();
						num.setText("");
					}

					
				}
			}
		});
    
	    //검색버튼을 눌렀을 때 반응
	    searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = num.getText();
				if(lm.deleteBook(title) == 1) {
					dispose();
					mf.setVisible(true);
				}else {
					new deleteBook(lm,mf);				
					num.requestFocus();
					num.setText("");
				}
			}
		});
	    
	    resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				num.setText("");
				num.requestFocus();
			}
		});
	    
	    backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				mf.setVisible(true);
			}
		});  

	    this.add(panel2);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	 }
	
		
}

class reviseBook extends JFrame{

	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	
	public reviseBook(LibraryManager lm,JFrame mf) {
		
		
		  this.setTitle("도서 수정");
	      this.setLayout(new GridLayout(3, 1, 0, 70));
	      this.setLocation(300, 0);
	      this.setSize(900, 850);
	      this.setResizable(false);
	    
	    try {
	        this.setIconImage(ImageIO.read(new File("images/book.png")));
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
	            setSize(900,280);   
	            setOpaque(false);
	            super.paintComponent(g);
	         }
	      };
	      this.add(panel1);
	    
   
	    JPanel panel3 = new JPanel();	   
	    panel3.setSize(900,200);    
	    //테이블만들기
	  		String header[]= {"책 제목","작가","가격"};
	  		String contents[][]=null;
	  	    contents = lm.bookList();
	  	    
	  	    Font f1 = new Font("신명조", Font.PLAIN, 15);
	  	    
	  	    JTable table = new JTable(contents,header);
	  	    table.setFont(f1);
	  	    
	  	    //헤더를 가운데정렬
	  	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
	  	    renderer.setHorizontalAlignment(SwingConstants.CENTER);
	  	    table.getTableHeader().setDefaultRenderer(renderer);
	  	    
	  	    //테이블 내용을 가운데 정렬
	  	    DefaultTableCellRenderer contentsCenterP = new DefaultTableCellRenderer();
	  	    contentsCenterP.setHorizontalAlignment(SwingConstants.CENTER);
	  	    TableColumnModel tp = table.getColumnModel();
	  	    for(int i =0;i<tp.getColumnCount();i++) {
	  	    	tp.getColumn(i).setCellRenderer(contentsCenterP);
	  	    }
	  	    
	  	    JScrollPane scrollPane = new JScrollPane(table);
	  	    scrollPane.setPreferredSize(new Dimension(700,150));
	  	    panel3.add(scrollPane,"South");
	  	    this.add(panel3);
	   
 
	    Font f = new Font("HY헤드라인", Font.PLAIN, 20); 
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(null);
	    panel2.setSize(900,340);
	    
	    JLabel nameL = new JLabel("수정하실 책이름를 입력하세요");
	    nameL.setBounds(100, 10, 700, 25);
	    nameL.setFont(f);
	    nameL.setHorizontalAlignment(JLabel.CENTER);
	    panel2.add(nameL);
	    
	    JTextField num = new JTextField();
	    num.setBounds(250, 60, 400, 25);
	    num.setHorizontalAlignment(JTextField.CENTER);
	    panel2.add(num);
	    
	    JButton backButton = new JButton("뒤로 가기");
	    backButton.setBounds(150,160,150,25);
	    backButton.setFont(f);
	    panel2.add(backButton);
	    
	    JButton resetButton = new JButton("Reset");
	    resetButton.setBounds(370,160,150,25);
	    resetButton.setFont(f);
	    panel2.add(resetButton);
	      
	    JButton searchButton = new JButton("검색");
	    searchButton.setBounds(600,160,150,25);
	    searchButton.setFont(f);
	    panel2.add(searchButton);
	    
	    this.addWindowListener(new WindowAdapter() {
	    	  @Override
	    	public void windowOpened(WindowEvent e) {
	    		num.requestFocus();
	    		super.windowOpened(e);
	    	}
		});
	    
	    num.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {	
			}
				
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String title = num.getText();
					if(lm.reviseBook(title,mf) == 1) {
						dispose();
						
					}else {
						new reviseBook(lm,mf);				
						num.requestFocus();
						num.setText("");
					}
				}
			}
		});
	    
	    
	    
	    //검색버튼을 눌렀을 때 반응
	    searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				String title = num.getText();
				if(lm.reviseBook(title,mf) == 1) {
					dispose();		
				}else {
					new reviseBook(lm,mf);			
					num.requestFocus();
					num.setText("");
				}
			}
		});
	    
	    resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				num.setText("");
				num.requestFocus();
			}
		});
	    
	    backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
				mf.setVisible(true);
			}
		});  
	    
    

	    this.add(panel2);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	 }
	

}
