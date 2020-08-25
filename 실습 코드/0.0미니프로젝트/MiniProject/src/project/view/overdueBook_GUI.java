package project.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import project.controller.LibraryManager;

public class overdueBook_GUI extends JFrame {

   private static final long serialVersionUID = 1L;
   ImageIcon icon;
   GridBagConstraints gbc = new GridBagConstraints();
   GridBagLayout layout = new GridBagLayout();

   public overdueBook_GUI(LibraryManager lm, JFrame mf) {
      this.setTitle("연체 목록");
      this.setLocation(500, 150);
      this.setSize(900, 700);
      Font font = new Font("맑은 고딕", Font.PLAIN, 20);
      try {
         this.setIconImage(ImageIO.read(new File("images/book.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }
      JLabel labels = new JLabel("이름      전화번호       빌린책           반납기한        연체료");
      labels.setAlignmentX(JLabel.LEFT_ALIGNMENT);
      labels.setFont(font);
      icon = new ImageIcon("images/overdue.jpg");
      JPanel image_panel = new JPanel() {
         public void paint(Graphics g) {
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, 900, 250, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      JButton button_close = new JButton("닫기");
      button_close.setFont(font);
      button_close.setPreferredSize(new Dimension(138, 400));
      button_close.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            mf.setVisible(true);
         }
      });
      JPanel button_panel = new JPanel();
      button_panel.setSize(138, 400);
      button_panel.add(button_close);
      // 연체정보 보여줄 영역
      JTextArea list = new JTextArea(12, 38);
      list.setFont(font);
      // 스크롤 가능하게
      JScrollPane scroll = new JScrollPane(list);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      // 라벨들을 담을 패널
      JPanel label_panel = new JPanel();
      label_panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
      label_panel.add(labels);
      // 스크롤과 라벨패널을 담을 info 패널
      JPanel info_panel = new JPanel();
      info_panel.setLayout(layout);
      gbc.gridx = 0;
      gbc.gridy = 0;
      info_panel.add(label_panel, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      info_panel.add(scroll, gbc);
      JPanel comp_panel = new JPanel();
      comp_panel.setSize(900, 450);
      comp_panel.setLayout(layout);
      comp_panel.add(info_panel);
      comp_panel.add(button_panel);

      this.add(image_panel);
      this.add(comp_panel, "South");
      this.setVisible(true);
      this.setResizable(false);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      String str = lm.overdueBook();
      if (lm.getDelayList().isEmpty()) {
         list.setText("현재 연체 목록이 없습니다.");

      } else {
         list.setText(str);

      }

   }

}