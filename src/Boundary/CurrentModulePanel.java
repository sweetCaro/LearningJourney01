package Boundary;

import Controller.ModuleUtil;
import entity.Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class CurrentModulePanel extends JPanel {
    //主页的第一块面板
    public JLabel currentModule,title,credit,module;
    public JButton schedule;

    public CurrentModulePanel(String buttonText,int indexOfStudentInformation) {
        //设置面板背景和框的大小，其实也可以省略
        setLayout(null);
        //setPreferredSize(new Dimension(400, 300));
        //setBackground(new Color(225, 225, 225));
        //添加标签文字：current module
        currentModule=new JLabel("Current Module");
        currentModule.setBounds(10,10,150,30);
        add(currentModule);
        //添加表单头标签文字：title，credit，module
        title=new JLabel("Title");
        title.setBounds(75,40,150,30);
        add(title);
        credit=new JLabel("Credit");
        credit.setBounds(200,40,150,30);
        add(credit);
        module=new JLabel("Module");
        module.setBounds(320,40,150,30);
        add(module);

        //添加课程表按钮，点击之后可以跳转到课程表页面
        schedule = new JButton(buttonText);
        schedule.setForeground(Color.WHITE);
        schedule.setBackground(new Color(51, 102, 153));
        schedule.setFocusPainted(false);
        schedule.setBounds(300, 10, 90, 28);
        add(schedule);
        schedule.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SchedulePage schedulePage=new SchedulePage(indexOfStudentInformation);
                schedulePage.setLocationRelativeTo(null);
                schedulePage.setVisible(true);
                System.out.println("check schedule");
            }
        });


        //添加各个课程按钮，点击之后可以跳转到课程介绍页面，但是原页面就不用关闭了
        String moduleName=null;
        int credit=0;
        String moduleId;
        List<Module> moduleList= new ModuleUtil().getModules(indexOfStudentInformation);
        System.out.println(moduleList.get(0).getModuleName());
        int count=0;
        for(int i=0;i<moduleList.size();i++){
            if(Objects.equals(moduleList.get(i).getState(), "current")) {
                moduleName = moduleList.get(i).getModuleName();
                credit=moduleList.get(i).getCredit();
                moduleId=moduleList.get(i).getModuleId();
                JButton moduleButton = new JButton(moduleName);
                JLabel moduleCredit= new JLabel(String.valueOf(credit));
                JLabel moduleIdentity=new JLabel(moduleId);

                moduleButton.setForeground(Color.WHITE);
                moduleButton.setBackground(new Color(117, 163, 208));
                moduleButton.setFocusPainted(false);
                moduleButton.setBounds(10, 70 + 40 * count, 150, 25);
                moduleCredit.setBounds(210,70 + 40 * count,50,25);
                moduleIdentity.setBounds(315,70 + 40 * count,150,25);
                add(moduleButton);
                add(moduleCredit);
                add(moduleIdentity);
                count++;
                String finalModuleName = moduleName;
                moduleButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ModuleIntroductionPage moduleInfoPage = new ModuleIntroductionPage(indexOfStudentInformation, finalModuleName);
                        moduleInfoPage.setLocationRelativeTo(null);
                        moduleInfoPage.setVisible(true);
                        System.out.println(finalModuleName);
                    }
                });
            }
        }

    }
    @Override//设置渐变
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(5, 42, 400, 42);
        Graphics2D g2d = (Graphics2D) g.create();
        int height = getHeight() - 1;
        int width = getWidth() - 1;
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(149, 191, 238, 211),
                0, height, new Color(190, 217, 245));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(new Color(85, 143, 199));
        g2d.drawRect(0, 0, width, height);
        //g2d.dispose();
    }
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Shaded Rectangular Panel with Button");
//        Boundary.CurrentModulePanel shadedRectangularPanel = new Boundary.CurrentModulePanel("Schedule");
//        shadedRectangularPanel.setBounds(50, 50, 400, 300);
//        frame.add(shadedRectangularPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
}