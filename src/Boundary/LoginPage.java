package Boundary;

import Controller.Login;
import entity.Student;

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

public class LoginPage extends JFrame implements ActionListener{
    //创建JFrame实例
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage longin = new LoginPage();
                    longin.setLocationRelativeTo(null);
                    longin.setVisible(true);
                }  catch (Exception e) {
                e.printStackTrace();
            }
        }
        });
    }
    public LoginPage() {
        //JFrame frame = new JFrame("Boundary.LoginPage");
        setTitle("Login Page");
        setSize(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*创建面板，类似于HTML中的div标签
          可以创建多个面板并在JFrame中指定位置
          面板中我们可以添加文本字段，按钮，以及其它组件
        */
        JPanel panel =  new JPanel();
        //添加面板
        add(panel);//把panel装进frame中
        /*
         *调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);//placeComponents()就是用户定义的方法
        setVisible(true);//这个JFrame一开始就是可见的
    }
    public void placeComponents(JPanel panel){
        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);


        //创建JLabel，创建一个新的标签，之后可能还有创建新的按钮、输入框啥的
        JLabel userLabel = new JLabel("User:");
        /*这个方法定义组件的位置
          setBounds(x,y,width,height)
          x和y指定左上角的新位置，由width和height指定组件大小
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);//在传进来的这个面板上添加这个标签

        //创建文本框 用于输入，和刚才创建标签类似
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 密码标签 password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        //创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(100,80,80,25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //new Boundary.HomePage();
                int indexOfStudentInformation = new Login().checkValid(userText.getText(),passwordText.getText());
                if(userText.getText().isEmpty()&&passwordText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Empty input!","Warn",JOptionPane.WARNING_MESSAGE);
                }
                else if(userText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Empty username!","Warn",JOptionPane.WARNING_MESSAGE);
                }
                else if(passwordText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Empty password!","Warn",JOptionPane.WARNING_MESSAGE);
                }
                else {
                        if(indexOfStudentInformation!=-1){
                            HomePage homePage = new HomePage(indexOfStudentInformation);//把student信息传到homepage里头
                            homePage.setLocationRelativeTo(null);//在屏幕中间显示
                            homePage.setVisible(true);
                            dispose();//点击了login之后就跳转到首页
                            System.out.println("success!");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Wrong password or invalid account!","Warn",JOptionPane.WARNING_MESSAGE);
                        }

                }
//


            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
