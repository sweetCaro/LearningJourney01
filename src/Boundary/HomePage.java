package Boundary;

import entity.Student;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener{
    //首页的主面板，其他面板在此基础上添加，这个大面板下包括三个小面板和三个功能按钮
    //三个小面板：1.课程currentModulePanel 2.Boundary.AssessmentPanel 3.Boundary.PersonalDevelopmentPanel
    //三个功能按钮：1.to-do list 2.bulletin 3.exit
    public HomePage(int indexOfStudentInformation){
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭当前窗口，整个程序都关闭了
        setSize(450,750);
        JPanel mainPanel =  new JPanel();
        //添加面板
        add(mainPanel);//把panel装进frame中
        mainPanel.setLayout(null);
        /*
         *调用用户定义的方法并添加组件到面板
         */

        ImageIcon icon=new ImageIcon("./picture.png");
        JLabel picture=new JLabel(icon);
        JButton todoList=new JButton("to-do list");
        JButton bulletin=new JButton("bulletin");
        //JButton trainingProgram=new JButton(new ImageIcon("./trainingProgram.jpg"));
        JButton exit=new JButton(new ImageIcon("./exit.png"));
        JLabel welcomeWord=new JLabel("Welcome to learning journey!");
        welcomeWord.setBounds(15,45,200,20);


        picture.setBounds(10,10,30,35);
        todoList.setBounds(50,10,100,35);
        bulletin.setBounds(160,10,90,35);
        //trainingProgram.setBounds(350,10,35,35);
        exit.setBounds(390,10,35,35);
        mainPanel.add(picture);
        mainPanel.add(todoList);
        mainPanel.add(bulletin);
        //panel1.add(trainingProgram);
        mainPanel.add(exit);
        mainPanel.add(welcomeWord);
        //点击退出按钮
        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.setLocationRelativeTo(null);
                loginPage.setVisible(true);
                dispose();
                System.out.println("log out!");
            }
        });
        //点击to-do list按钮
        todoList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TodoListPage todoListPage = new TodoListPage(indexOfStudentInformation);
                todoListPage.setLocationRelativeTo(null);
                todoListPage.setVisible(true);
                //dispose();
                System.out.println("to-do list!");
            }
        });
        //点击bulletin按钮
        bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BulletinPage bulletinPage = new BulletinPage(indexOfStudentInformation);
                bulletinPage.setLocationRelativeTo(null);
                bulletinPage.setVisible(true);
                //dispose();
                System.out.println("bulletin Page!");
            }
        });
        //在mainPanel的基础上添加新的panel显示在修课程
        CurrentModulePanel currentModule=new CurrentModulePanel("Schedule",indexOfStudentInformation);
        currentModule.setBounds(10, 70, 410, 700);
        mainPanel.add(currentModule);

        //由于新的currentModulePanel把mainPanel覆盖了
        //所以加新的panel要在新的panel上添加
        //在currentModulePanel中传一个行数回来，让Assessment的纵坐标可以随之变化
        AssessmentPanel assessmentPanel=new AssessmentPanel(indexOfStudentInformation);
        currentModule.add(assessmentPanel);
        assessmentPanel.setBounds(5,270,400,50);

        PersonalDevelopmentPanel personalDevelopmentPanel=new PersonalDevelopmentPanel(indexOfStudentInformation);
        personalDevelopmentPanel.setPreferredSize(new Dimension(300,400));
        JScrollPane scrollPane=new JScrollPane(personalDevelopmentPanel);
        scrollPane.setBounds(5,330,400,250);
        currentModule.add(scrollPane);
        //currentModule.add(personalDevelopmentPanel);
        //personalDevelopmentPanel.setBounds(5,330,400,250);



        setVisible(true);//这个JFrame一开始就是可见的
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
