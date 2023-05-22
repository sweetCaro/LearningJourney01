package Boundary;

import Controller.BulletinUtil;
import entity.Bulletin;
import entity.TodoList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BulletinPage extends JFrame implements ActionListener{
    //点击主页的bulletin按钮后，显示课程通知页面
    JList<String> itemList;
    DefaultListModel<String> listModel;
    public BulletinPage(int indexOfStudentInformation) {
        setTitle("Bulletin");
        setSize(373,450);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        panel.setBackground(new Color(98, 154, 208));
        panel.setLayout(null);

        listModel = new DefaultListModel<String>();
        List<Bulletin> bulletin = new ArrayList<Bulletin>();
        bulletin=new BulletinUtil().getBulletin(indexOfStudentInformation);
        for(int i=0;i<bulletin.size();i++){
            listModel.addElement(bulletin.get(i).getNotice());
        }
        itemList = new JList<String>(listModel);
        JScrollPane listScrollPane = new JScrollPane(itemList);
        panel.add(listScrollPane);
        listScrollPane.setBounds(5,5,350,400);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
