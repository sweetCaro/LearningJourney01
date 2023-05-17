package Boundary;

import Controller.AwardUtil;
import Controller.RoleUtil;
import entity.Awards;
import entity.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PersonalDevelopmentPanel extends JPanel {
    //主页显示的第三个面板，个人发展相关（担任职位，获得奖项，产出作品）
    public JLabel roles,awards,portfolios;
    public JButton view;//跟在portfolio之后，点击课跳转到portfoliosPage
    public PersonalDevelopmentPanel(int indexOfStudentInformation){
        setLayout(null);
        //记录当过的职位
        awards=new JLabel("Awards & Prize");
        awards.setBounds(5,10,150,30);
        add(awards);


        String s1;
        int numberOfRoles=0;
        int numberOfAwards=0;
        List<Awards> awardsList=new AwardUtil().getAwards(indexOfStudentInformation);
        List<Role> roleList=new RoleUtil().getRoles(indexOfStudentInformation);
        for(int i=0;i<awardsList.size();i++){
            numberOfAwards++;
            String awardName=awardsList.get(i).getAwardName();
            JLabel awardNameLabel=new JLabel(awardName);
            awardNameLabel.setBounds(10,20+numberOfAwards*25,250,25);
            add(awardNameLabel);

            String awardTime=awardsList.get(i).getAwardTime();
            JLabel awardTimeLabel=new JLabel(awardTime);
            awardTimeLabel.setBounds(320,20+numberOfAwards*25,200,25);
            add(awardTimeLabel);
        }

        int lineOfRoleLabel=(numberOfAwards+1)*25+30;
        roles=new JLabel("Roles Taken");//记得换一下字体
        roles.setBounds(5,lineOfRoleLabel,250,25);
        add(roles);

        int lineOfDetailedRoleBegin=lineOfRoleLabel+10;
        for(int i=0;i<roleList.size();i++){
            numberOfRoles++;
            String roleName=roleList.get(i).getRoleName();
            JLabel roleNameLabel=new JLabel(roleName);
            roleNameLabel.setBounds(10,lineOfDetailedRoleBegin+numberOfRoles*25,250,25);
            add(roleNameLabel);
            String roleTime=roleList.get(i).getRoleTime();
            JLabel roleTimeLabel=new JLabel(roleTime);
            roleTimeLabel.setBounds(280,lineOfDetailedRoleBegin+numberOfRoles*25,200,25);
            add(roleTimeLabel);
        }
//        try{
//            BufferedReader reader=new BufferedReader(new FileReader("./Information.txt"));
//            while((s1=reader.readLine())!=null){
//                if(s1.substring(0,s1.indexOf(":")).equals("role")){
//                    numberOfRoles++;
//                    String role = s1.substring(s1.indexOf(":")+1,s1.indexOf("~"));
//                    JLabel rolesName=new JLabel(role);
//                    rolesName.setBounds(10,20+numberOfRoles*25,250,25);
//                    add(rolesName);
//                    String timeOfRole=s1.substring(s1.indexOf("~")+1);
//                    JLabel rolesTime=new JLabel(timeOfRole);
//                    rolesTime.setBounds(270,20+numberOfRoles*25,200,25);
//                    add(rolesTime);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //记录得过的奖项
//        int numberOfAwards=0;
        //int lineOfAwardsLabel=(numberOfRoles+1)*25+30;
        //String s2;
//        awards=new JLabel("Awards & Prize");
//        awards.setBounds(5,lineOfAwardsLabel,250,25);
//        add(awards);


//        try{
//            BufferedReader reader=new BufferedReader(new FileReader("./Information.txt"));
//            while((s2=reader.readLine())!=null){
//                if(s2.substring(0,s2.indexOf(":")).equals("awards")){
//                    numberOfAwards++;
//                    String award = s2.substring(s2.indexOf(":")+1,s2.indexOf("~"));
//                    JLabel awardName=new JLabel(award);
//                    awardName.setBounds(10,lineOfDetailedAwardsBegin+numberOfAwards*25,250,25);
//                    add(awardName);
//                    String timeOfAward=s2.substring(s2.indexOf("~")+1);
//                    JLabel awardTime=new JLabel(timeOfAward);
//                    awardTime.setBounds(320,lineOfDetailedAwardsBegin+numberOfAwards*25,200,25);
//                    add(awardTime);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //作品标签和view按钮，点击view可以跳转
        int lineOfPortfoliosLabel=lineOfRoleLabel+(numberOfRoles+1)*25+20;
        portfolios=new JLabel("Portfolios...");
        portfolios.setBounds(5,lineOfPortfoliosLabel,90,25);
        add(portfolios);
        view=new JButton("View");
        view.setBounds(300,lineOfPortfoliosLabel,90,25);
        add(view);
        view.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Portfolios");
                frame.getContentPane().add(new PortfoliosPage(indexOfStudentInformation));
                frame.pack();
                frame.setVisible(true);
                System.out.println("Portfolios!");
            }
        });

    }
    @Override//设置渐变
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(5, 42, 400, 42);
        Graphics2D g2d = (Graphics2D) g.create();
        int height = getHeight() - 1;
        int width = getWidth() - 1;
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(229, 234, 245, 255),
                0, height, new Color(190, 218, 248, 255));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(new Color(201, 214, 227));
        g2d.drawRect(0, 0, width, height);
        g2d.dispose();
    }
}
