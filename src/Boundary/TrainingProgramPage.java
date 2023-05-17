package Boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainingProgramPage extends JFrame implements ActionListener {
    //点击成绩页面的培养方案标志后，显示培养方案页面
    public TrainingProgramPage(){
        setTitle("Training Program");
        setSize(400,500);
        String str="<html><body>" + "Program name: 2020 IoT engineering Training Program" +
                "<br>" + "Grade: 2020" +
                "<br>" + "Name of major: Internet of Things engineering" +
                "<br>" + "Degree: Bachelor" +
                "<br>" + "Length of schooling: general full-time" +
                "<br>" +
                "<br>" + "2020-2021 school year" +
                "<br>" + "First Semester (Autumn)" +
                "<br>" + "001   Advanced Mathematics A (Part 1)" +
                "<br>" + "002   Linear Algebra" +
                "<br>" + "003   Introduction to computers and Programming" +
                "<br>" + "004   Integrated English (1-2)" +
                "<br>" + "005   Fundamentals of Sports (1)" +
                "<br>" +
                "<br>" + "Second Semester (Spring)" +
                "<br>" + "006   Integrated English (3)" +
                "<br>" + "007   Advanced Mathematics A (Part 2)" +
                "<br>" + "008   College Physics C"+
                "<br>" + "009   Outline of Chinese Modern History"+
                "<br>" + "010   Physics Experiment C"+
                "<br>" +
                "<br>" + "2021-2022 school year"+
                "<br>" + "First Semester (Autumn)"+
                "<br>" + "011   Fundamentals of Sports (2)"+
                "<br>" + "012   Discrete Mathematics"+
                "<br>" + "013   Introduction to Internet of Things technology"+
                "<br>" + "014   Data Structure"+
                "<br>" + "015   Signals and Systems"+
                "<body></html>";
        JLabel label1 = new JLabel(str);
        label1.setBounds(5,5,400,450);
        JPanel panel = new JPanel();
        panel.add(label1);
        add(panel);
        panel.setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
