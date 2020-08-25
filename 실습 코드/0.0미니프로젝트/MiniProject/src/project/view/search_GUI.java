package project.view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.table.*;

import project.controller.*;

public class search_GUI  {

      private static final long serialVersionUID = 1L;
      ImageIcon icon;

      public search_GUI(LibraryManager lm, JFrame mf) {
         JFrame search = new JFrame();
         Font f = new Font("HY헤드라인", Font.PLAIN, 30);

         search.setTitle("조회 - 책&회원정보");
         search.setLayout(new GridLayout(2, 1));
         search.setLocation(500, 150);
         search.setSize(900, 850);
         try {
            search.setIconImage(ImageIO.read(new File("images/book.png")));
         } catch (IOException e) {
            e.printStackTrace();
         }
         icon = new ImageIcon("images/searchbook.jpg");
         JPanel panelimage = new JPanel() {
            public void paint(Graphics g) {
               // g.drawImage(icon.getImage(), 0, 0, null);
               Dimension d = getSize();
               g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);

               setOpaque(false);
               super.paintComponent(g);
            }
         };

         // 조회 첫 화면
         JPanel mainPanel = new JPanel();
         mainPanel.setLayout(new GridLayout(3, 1));
         JButton bookList = new JButton("조회-책정보");
         bookList.setFont(f);
         bookList.setBounds(30, 10, 50, 25);
         JButton numberList = new JButton("조회-회원정보");
         numberList.setFont(f);
         numberList.setBounds(50, 20, 50, 25);
         JButton returntoMain = new JButton("뒤로가기");
         returntoMain.setFont(f);
         returntoMain.setBounds(30, 10, 50, 25);

         
         mainPanel.add(bookList);
         mainPanel.add(numberList);
         mainPanel.add(returntoMain);

         // 책조회 눌렀을때
         bookList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               search.dispose();
               new Bs(lm,mf,search);
            }
         });

         // 회원조회 눌렀을때
         numberList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               search.dispose();
               new Ms(lm,mf,search);
            }
         });

         // 뒤로가기 눌렀을때
         returntoMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               search.dispose();
               mf.setVisible(true);

            }
         });

         search.add(panelimage);
         search.add(mainPanel);
         search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         search.setVisible(true);
         search.setResizable(false);
      }

   }

   class Bs extends JFrame {

      protected static final TableColumnModel TableColumModel = null;
      ImageIcon icon;
      
      public Bs(LibraryManager lm,JFrame mf,JFrame search) {
         Font f = new Font("HY헤드라인", Font.PLAIN, 20);

         this.setTitle("책 조회");
         this.setLocation(500, 150);
         this.setLayout(null);
         this.setSize(900, 850);
         try {
            this.setIconImage(ImageIO.read(new File("images/book.png")));
         } catch (IOException e) {
            e.printStackTrace();
         }
         icon = new ImageIcon("images/booksearch.jpg");
         JPanel panelimage = new JPanel() {
            public void paint(Graphics g) {
               // g.drawImage(icon.getImage(), 0, 0, null);
               Dimension d = getSize();
               g.drawImage(icon.getImage(), 0, 0, 900, 200, null);

               setOpaque(false);
               super.paintComponent(g);
            }
         };
         panelimage.setBounds(0, 0, 900, 200);

         // 책조회 첫화면
         JPanel panel = new JPanel();

         String[] name = { "책제목" };
         JComboBox cb = new JComboBox(name);
         cb.setFont(f);
         JTextField text = new JTextField(30);
         text.setFont(f);
         JButton button = new JButton("확인");
         button.setFont(f);

         JPanel panel1 = new JPanel(new BorderLayout());

         // 테이블만들기
         String header[] = { "책 제목", "작가", "가격" };
         String contents[][] = null;
         contents = lm.bookList();    
         
         Font tf = new Font("신명조", Font.PLAIN, 15);
         //테이블 내용수정 불가
          DefaultTableModel dtm = new DefaultTableModel(contents ,header){  
               @Override
               public boolean isCellEditable(int row, int column)      
               {
                   return false;       
               }
           };
         JTable table = new JTable(dtm);         
         table.setFont(tf);
         table.setRowHeight(25);
         table.getTableHeader().setReorderingAllowed(false);   //이동불가         
         JScrollPane scrollPane = new JScrollPane(table);
         scrollPane.setPreferredSize(new Dimension(700, 380));
         scrollPane.setBorder(null);
         
      // 뒤로가기
         JButton bb = new JButton("뒤로가기");      
         bb.setFont(f);

         bb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               search.setVisible(true);
              ;
            }
         });

         // 책제목 검색으로 일치하는 책목록
         button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               String titleb = text.getText();
               if (lm.search(1, titleb) != null) {
                  String contentsP[][] = lm.search(1, titleb);
                  //내용수정 불가
                  DefaultTableModel dtmP = new DefaultTableModel(contentsP ,header){  
                     @Override
                     public boolean isCellEditable(int row, int column)      
                     {
                         return false;       // 편집이 안되도록 한다.
                     }
                 };
                  JTable tableP = new JTable(dtmP);
                  tableP.setFont(tf);
                  tableP.getTableHeader().setReorderingAllowed(false);   //이동불가
                  tableP.setRowHeight(25);
                  JScrollPane scrollPaneP = new JScrollPane(tableP);
                  scrollPaneP.setPreferredSize(new Dimension(700, 380));
                  panel1.removeAll();
                 panel1.setLayout(new BorderLayout());
                 panel1.add(scrollPaneP,"Center");
                  text.setText("");
                  //테이블 헤더 가운데정렬
                 DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tableP.getTableHeader().getDefaultRenderer();
                 renderer.setHorizontalAlignment(SwingConstants.CENTER);
                 tableP.getTableHeader().setDefaultRenderer(renderer);
                  // 검색테이블 가운데정렬
                  DefaultTableCellRenderer contentsCenterP = new DefaultTableCellRenderer();
                  contentsCenterP.setHorizontalAlignment(SwingConstants.CENTER);
                  TableColumnModel tp = tableP.getColumnModel();
                  for (int i = 0; i < tp.getColumnCount(); i++) {
                     tp.getColumn(i).setCellRenderer(contentsCenterP);
                  }
                  
               }
               JButton bpanelP = new JButton("뒤로가기");
              bpanelP.setFont(f);
                     
              bpanelP.addActionListener(new ActionListener() {
                 @Override
                   public void actionPerformed(ActionEvent e) {
                    dispose();
                    search.setVisible(true);
                   }
               });
              panel1.revalidate();
              panel1.repaint();
              panel1.add(bpanelP,"South");
              panel1.setBounds(100,250,700,550);        
            }
         });

         text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == e.VK_ENTER) {
                  String titleb = text.getText();
                  if (lm.search(1, titleb) != null) {
                     String contentsP[][] = lm.search(1, titleb);
                     //내용수정 불가
                    DefaultTableModel dtmP = new DefaultTableModel(contentsP ,header){  
                        @Override
                        public boolean isCellEditable(int row, int column)      
                        {
                            return false;       // 편집이 안되도록 한다.
                        }
                     };
                    JTable tableP = new JTable(dtmP);
                     tableP.setFont(tf);
                     tableP.getTableHeader().setReorderingAllowed(false);   //이동불가
                     tableP.setRowHeight(25);
                     JScrollPane scrollPaneP = new JScrollPane(tableP);
                     scrollPaneP.setPreferredSize(new Dimension(700, 380));
                     panel1.removeAll();
                     panel1.setLayout(new BorderLayout());
                     panel1.add(scrollPaneP,"Center");
                     panel1.revalidate();
                     panel1.repaint();
                     text.setText("");
                     //테이블 헤더 가운데정렬
                    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tableP.getTableHeader().getDefaultRenderer();
                    renderer.setHorizontalAlignment(SwingConstants.CENTER);
                    tableP.getTableHeader().setDefaultRenderer(renderer);
                     // 검색테이블 가운데정렬
                     DefaultTableCellRenderer contentsCenterP = new DefaultTableCellRenderer();
                     contentsCenterP.setHorizontalAlignment(SwingConstants.CENTER);
                     TableColumnModel tp = tableP.getColumnModel();
                     for (int i = 0; i < tp.getColumnCount(); i++) {
                        tp.getColumn(i).setCellRenderer(contentsCenterP);
                     }
                  }
                  JButton bpanelP = new JButton("뒤로가기");
                 bpanelP.setFont(f);
                        
                 bpanelP.addActionListener(new ActionListener() {
                    @Override
                      public void actionPerformed(ActionEvent e) {
                        dispose();
                        search.setVisible(true);
                      }
                  });
                 panel1.revalidate();
                 panel1.repaint();
                 panel1.add(bpanelP,"South");
                 panel1.setBounds(100,250,700,550);
               }
            }
         });
         //테이블 헤더 가운데정렬
         DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
         renderer.setHorizontalAlignment(SwingConstants.CENTER);
         table.getTableHeader().setDefaultRenderer(renderer);
         // 테이블 내용 가운데 정렬
         DefaultTableCellRenderer contentsCenter = new DefaultTableCellRenderer();
         contentsCenter.setHorizontalAlignment(SwingConstants.CENTER);
         TableColumnModel t = table.getColumnModel();
         for (int i = 0; i < t.getColumnCount(); i++) {
            t.getColumn(i).setCellRenderer(contentsCenter);
         }
             
          panel.add(cb,"West");
          panel.add(text,"Center");
          panel.add(button,"East");            
          panel.setBounds(0,200,900,50);
            
          panel1.add(scrollPane,"Center");
          panel1.add(bb,"South");
          panel1.setBounds(100,250,700,550);
            
          this.add(panelimage);
          this.add(panel);
          this.add(panel1);
               
          this.setVisible(true);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setResizable(false);
      }
}

class Ms extends JFrame {

   ImageIcon icon;
   
      public Ms(LibraryManager lm,JFrame mf,JFrame search) {
        Font f = new Font("HY헤드라인", Font.PLAIN, 20);

         this.setTitle("고객 조회");
         this.setLocation(500, 150);
         this.setSize(900, 850);
         this.setLayout(null);
         try {
            this.setIconImage(ImageIO.read(new File("images/book.png")));
         } catch (IOException e) {
            e.printStackTrace();
         }
         icon = new ImageIcon("images/membersearch.jpg");
         JPanel panelimage = new JPanel() {
            public void paint(Graphics g) {
               // g.drawImage(icon.getImage(), 0, 0, null);
               Dimension d = getSize();
               g.drawImage(icon.getImage(), 0, 0, 900, 200, null);

               setOpaque(false);
               super.paintComponent(g);
            }
         };
         panelimage.setBounds(0, 0, 900, 200);

         // 회원 조회 첫화면
         JPanel panel = new JPanel();
         String[] name = { "회원이름" };
         JComboBox cb = new JComboBox(name);
         cb.setFont(f);
         JTextField text = new JTextField(30);
         text.setFont(f);
         JButton button = new JButton("확인");
         button.setFont(f);

         JPanel panel1 = new JPanel(new BorderLayout());
         // 테이블만들기
         String header[] = { "이름", "번호", "연체", "빌린 책" };
         String contents[][] = null;
         contents = lm.memberList();

         Font tf = new Font("신명조", Font.PLAIN, 15);
        //내용수정 불가
          DefaultTableModel dtm = new DefaultTableModel(contents ,header){  
               @Override
               public boolean isCellEditable(int row, int column)      
               {
                   return false;       // 편집이 안되도록 한다.
               }
           };
          JTable table = new JTable(dtm);         
         table.setFont(tf);
         table.setRowHeight(25);
         table.getTableHeader().setReorderingAllowed(false);   //이동불가
         JScrollPane scrollPane = new JScrollPane(table);
         scrollPane.setPreferredSize(new Dimension(700, 380));
        
         // 책제목 검색으로 일치하는 책목록
         button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               String mname = text.getText();
               if (lm.search(2, mname) != null) {
                  String contentsP[][] = lm.search(2, mname);
                //내용수정 불가
                  DefaultTableModel dtmP = new DefaultTableModel(contentsP ,header){  
                     @Override
                     public boolean isCellEditable(int row, int column)      
                     {
                         return false;       // 편집이 안되도록 한다.
                     }
                 };
                  JTable tableP = new JTable(dtmP);
                  tableP.setFont(tf);
                  tableP.getTableHeader().setReorderingAllowed(false);   //이동불가
                  JScrollPane scrollPaneP = new JScrollPane(tableP);
                  tableP.setRowHeight(25);
                  scrollPaneP.setPreferredSize(new Dimension(700, 380));
                  panel1.removeAll();
                  panel1.add(scrollPaneP);
                  panel1.revalidate();
                  panel1.repaint();
                  text.setText("");
                  //테이블 헤더 가운데정렬
                 DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tableP.getTableHeader().getDefaultRenderer();
                 renderer.setHorizontalAlignment(SwingConstants.CENTER);
                 tableP.getTableHeader().setDefaultRenderer(renderer);
                  // 검색테이블 가운데정렬
                  DefaultTableCellRenderer contentsCenterP = new DefaultTableCellRenderer();
                  contentsCenterP.setHorizontalAlignment(SwingConstants.CENTER);
                  TableColumnModel tp = tableP.getColumnModel();
                  for (int i = 0; i < tp.getColumnCount(); i++) {
                     tp.getColumn(i).setCellRenderer(contentsCenterP);
                  }
               }
               JButton bpanelP = new JButton("뒤로가기");
              bpanelP.setFont(f);
                     
              bpanelP.addActionListener(new ActionListener() {
                 @Override
                   public void actionPerformed(ActionEvent e) {
                    dispose();
                      search.setVisible(true);
                   }
               });
              panel1.revalidate();
              panel1.repaint();
              panel1.add(bpanelP,"South");
              panel1.setBounds(100,250,700,550);
            }
         });

         text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == e.VK_ENTER) {
                  String mname = text.getText();
                  if (lm.search(2, mname) != null) {
                     String contentsP[][] = lm.search(2, mname);
                   //내용수정 불가
                     DefaultTableModel dtmP = new DefaultTableModel(contentsP ,header){  
                        @Override
                        public boolean isCellEditable(int row, int column)      
                        {
                            return false;       // 편집이 안되도록 한다.
                        }
                    };
                     JTable tableP = new JTable(dtmP);
                     tableP.setFont(tf);
                     tableP.getTableHeader().setReorderingAllowed(false);   //이동불가
                     JScrollPane scrollPaneP = new JScrollPane(tableP);
                     tableP.setRowHeight(25);
                     scrollPaneP.setPreferredSize(new Dimension(700, 380));
                     panel1.removeAll();
                     panel1.add(scrollPaneP);
                     panel1.revalidate();
                     panel1.repaint();
                     text.setText("");
                     //테이블 헤더 가운데정렬
                    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tableP.getTableHeader().getDefaultRenderer();
                    renderer.setHorizontalAlignment(SwingConstants.CENTER);
                    tableP.getTableHeader().setDefaultRenderer(renderer);
                     //검색테이블 가운데정렬
                     DefaultTableCellRenderer contentsCenterP = new DefaultTableCellRenderer();
                     contentsCenterP.setHorizontalAlignment(SwingConstants.CENTER);
                     TableColumnModel tp = tableP.getColumnModel();
                     for (int i = 0; i < tp.getColumnCount(); i++) {
                        tp.getColumn(i).setCellRenderer(contentsCenterP);
                     }
                  }
                  JButton bpanelP = new JButton("뒤로가기");
                  bpanelP.setFont(f);
                        
                  bpanelP.addActionListener(new ActionListener() {
                    @Override
                      public void actionPerformed(ActionEvent e) {
                       dispose();
                         search.setVisible(true);
                      }
                  });
                panel1.revalidate();
                panel1.repaint();
                panel1.add(bpanelP,"South");
                panel1.setBounds(100,250,700,550);
               }
            }
         });

         //테이블 헤더 가운데정렬
         DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
         renderer.setHorizontalAlignment(SwingConstants.CENTER);
         table.getTableHeader().setDefaultRenderer(renderer);
         // 테이블 가운데 정렬
         DefaultTableCellRenderer contentsCenter = new DefaultTableCellRenderer();
         contentsCenter.setHorizontalAlignment(SwingConstants.CENTER);
         TableColumnModel t = table.getColumnModel();
         for (int i = 0; i < t.getColumnCount(); i++) {
            t.getColumn(i).setCellRenderer(contentsCenter);
         }

         // 뒤로가기
         JPanel bpanel = new JPanel();
         JButton bb = new JButton("뒤로가기");    
         bb.setFont(f);

         bb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
                 search.setVisible(true);     
            }
         });
         
         panel.add(cb,"West");
         panel.add(text,"Center");
         panel.add(button,"East");            
         panel.setBounds(0,200,900,50);
            
         panel1.add(scrollPane,"Center");
         panel1.add(bb,"South");
         panel1.setBounds(100,250,700,550);
            
         this.add(panelimage);
         this.add(panel);
         this.add(panel1);
          
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);
      }   
}