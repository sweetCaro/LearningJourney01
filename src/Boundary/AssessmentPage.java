package Boundary;

import Controller.AssessmentUtil;
import Controller.ModuleUtil;
import entity.Module;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AssessmentPage extends JFrame implements ActionListener {
    public AssessmentPage(int indexOfStudentInformation) {
        //✔ 进度条后跟着培养方案的图标 可点击查看培养方案
        //✔ 进度条下方是gpa、均分等信息
        //✔ 添加表头标签：Title、credit、module、score
        //✔ 读文件 课程名和成绩 生成固定长度label（左右） 位置递增
        //✔ 已修课程数量除以课程总数得到百分比，显示进度条
        //✔ gpa和均分的计算
        setTitle("Assessment Page");
        setSize(450,750);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);
        setVisible(true);

        //加一个看成绩的panel，和currentModule类似
        DetailPanel detail=new DetailPanel(indexOfStudentInformation);
        detail.setBounds(10, 90, 410, 700);
        panel.add(detail);

        //读文件一系列操作，把课程相关信息及分数显示出来
        String s;
        //ArrayList<String> modules=new ArrayList<String>();
        ArrayList<Integer> scores=new ArrayList<Integer>();
        ArrayList<Integer> credit=new ArrayList<Integer>();
        //String moduleName;
        //String scoreNumber;
        int numbersOfPassedModules=0;
        int numbersOfAllModules=0;
        List<Module> allModules=new ModuleUtil().getModules(indexOfStudentInformation);
        List<Module> passedModules=new AssessmentUtil().getModules(indexOfStudentInformation);
        for(Module item:passedModules){
            numbersOfPassedModules++;
            JLabel moduleName = new JLabel(item.getModuleName());
            moduleName.setBounds(10, 25 + numbersOfPassedModules * 40, 150, 25);
            detail.add(moduleName);
            JLabel moduleCredits= new JLabel(String.valueOf(item.getCredit()));
            moduleCredits.setBounds(200, 25 + numbersOfPassedModules * 40, 150, 25);
            detail.add(moduleCredits);
            JLabel moduleIdentifier=new JLabel(item.getModuleId());
            moduleIdentifier.setBounds(270,25+numbersOfPassedModules*40,150,25);
            detail.add(moduleIdentifier);
            JLabel moduleScores = new JLabel(String.valueOf(item.getScore()));
            moduleScores.setBounds(380, 25 + numbersOfPassedModules * 40, 90, 25);
            detail.add(moduleScores);
        }
        for(Module item:allModules){
            numbersOfAllModules++;
        }

        //显示学业课程进度条
        int sumOfModules=0;
        int progressValue=numbersOfPassedModules*100/numbersOfAllModules;
        JProgressBar progressOfLearning=new JProgressBar(0,100);
        //progressOfLearning.setIndeterminate(false);
        progressOfLearning.setString("progress");
        progressOfLearning.setValue(progressValue);
        //progressOfLearning.setValue();
        panel.add(progressOfLearning);
        progressOfLearning.setBounds(10,20,360,25);


        //进度条之后跟着的培养方案标标可点击
        ImageIcon trainingProgramIcon=new ImageIcon("./trainingProgram.jpg");
        JButton trainingProgram=new JButton(trainingProgramIcon);
        trainingProgram.setBounds(380,15,35,35);
        panel.add(trainingProgram);
        trainingProgram.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TrainingProgramPage trainingProgramPage = new TrainingProgramPage();
                trainingProgramPage.setLocationRelativeTo(null);
                trainingProgramPage.setVisible(true);
                System.out.println("Training Program!");
            }
        });

        double weightedAverageGrade=new AssessmentUtil().getWeight(passedModules);
        double gpa=new AssessmentUtil().getGpa(weightedAverageGrade);

        //添加课程成绩等标签
        JLabel weightedAverage = new JLabel("Weighted Average Score: "+new java.text.DecimalFormat("#.00").format(weightedAverageGrade));
        weightedAverage.setBounds(15,50,210,25);
        panel.add(weightedAverage);
        JLabel GPA = new JLabel("GPA: "+gpa);
        GPA.setBounds(260,50,50,25);
        panel.add(GPA);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
