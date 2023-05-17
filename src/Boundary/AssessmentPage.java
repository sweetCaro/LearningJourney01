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
/***
 *                    JLabel moduleName = new JLabel(nameOfModule);
*                     moduleName.setBounds(10, 25 + numbersOfPassedModules * 40, 150, 25);
*                     detail.add(moduleName);
*                     JLabel moduleCredits= new JLabel(stringOfCredit);
*                     moduleCredits.setBounds(200, 25 + numbersOfPassedModules * 40, 150, 25);
*                     detail.add(moduleCredits);
*                     JLabel moduleIdentifier=new JLabel(stringOfIdentifier);
*                     moduleIdentifier.setBounds(270,25+numbersOfPassedModules*40,150,25);
*                     detail.add(moduleIdentifier);
*                     JLabel moduleScores = new JLabel(stringOfScore);
*                     moduleScores.setBounds(380, 25 + numbersOfPassedModules * 40, 90, 25);
*                     detail.add(moduleScores);
         */
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("./Information.txt"));
//            while((s=reader.readLine())!=null){
//                if(s.substring(0, s.indexOf(":")).equals("passedModule")) {
//                    numbersOfPassedModules++;
//                    //先存着，待会用于计算
//                    //课程名字
//                    String nameOfModule = s.substring(s.indexOf(":") + 1, s.indexOf("$"));
//                    //modules.add(nameOfModule);
//                    //课程所占学分
//                    String stringOfCredit = s.substring(s.indexOf("$") + 1, s.indexOf("%"));//StringOfCredit用来显示
//                    int moduleCredit = Integer.parseInt(stringOfCredit);//intOfCredit用来计算
//                    credit.add(moduleCredit);
//                    //课程标识
//                    String stringOfIdentifier=s.substring(s.indexOf("%")+1,s.indexOf("~"));
//                    //课程成绩
//                    String stringOfScore = s.substring(s.indexOf("~") + 1);//stringOfScore用来显示
//                    int scoresOfModule= Integer.parseInt(stringOfScore);//intOfScore用来计算
//                    scores.add(scoresOfModule);
//
//                    JLabel moduleName = new JLabel(nameOfModule);
//                    moduleName.setBounds(10, 25 + numbersOfPassedModules * 40, 150, 25);
//                    detail.add(moduleName);
//                    JLabel moduleCredits= new JLabel(stringOfCredit);
//                    moduleCredits.setBounds(200, 25 + numbersOfPassedModules * 40, 150, 25);
//                    detail.add(moduleCredits);
//                    JLabel moduleIdentifier=new JLabel(stringOfIdentifier);
//                    moduleIdentifier.setBounds(270,25+numbersOfPassedModules*40,150,25);
//                    detail.add(moduleIdentifier);
//                    JLabel moduleScores = new JLabel(stringOfScore);
//                    moduleScores.setBounds(380, 25 + numbersOfPassedModules * 40, 90, 25);
//                    detail.add(moduleScores);
//                }
//                if(s.substring(0,s.indexOf(":")).equals("futureModule")){
//                    numbersOfAllModules++;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //显示学业课程进度条
        int sumOfModules=0;
//        sumOfModules=numbersOfAllModules+numbersOfPassedModules;
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
        //计算加权平均分和gpa
        double weightedAverageGrade=0,gpa=0;
        int gotGrade=0,totalGrade=0;//获得分数和获得总分
        System.out.println(totalGrade);
        for(int i=0;i<passedModules.size();i++){
            gotGrade+=passedModules.get(i).getScore()*passedModules.get(i).getCredit();//各科成绩*各课程权重
            totalGrade+=100*passedModules.get(i).getCredit();
        }
        weightedAverageGrade=gotGrade*100.0/totalGrade;//加权分数

        if(weightedAverageGrade>89&&weightedAverageGrade<=100)  gpa=4.0;
        if(weightedAverageGrade>84&&weightedAverageGrade<=89)  gpa=3.7;
        if(weightedAverageGrade>81&&weightedAverageGrade<=84)  gpa=3.3;
        if(weightedAverageGrade>77&&weightedAverageGrade<=81)  gpa=3.0;
        if(weightedAverageGrade>74&&weightedAverageGrade<=77)  gpa=2.7;
        if(weightedAverageGrade>71&&weightedAverageGrade<=74)  gpa=2.3;
        if(weightedAverageGrade>67&&weightedAverageGrade<=71)  gpa=2.0;
        if(weightedAverageGrade>63&&weightedAverageGrade<=67)  gpa=1.7;
        if(weightedAverageGrade>59&&weightedAverageGrade<=63)  gpa=1.0;
        if(weightedAverageGrade>0&&weightedAverageGrade<=59)  gpa=0;

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
