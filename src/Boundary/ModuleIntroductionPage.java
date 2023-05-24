package Boundary;

import Controller.CurrentModuleUtil;
import entity.Module;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class ModuleIntroductionPage extends JFrame implements ActionListener {
    //点击主页的课程介绍后显示课程介绍页面
    //可以按照点击的内容选择文件进行读取
    public ModuleIntroductionPage(int indexOfStudentInformation, String moduleName) {
        setTitle(moduleName);

        List<Module> moduleList = new CurrentModuleUtil().getModules(indexOfStudentInformation);
        String teacher = null;
        String teacherEmail = null;
        String moduleIntroduction = null;
        for (Module module : moduleList) {
            if (Objects.equals(module.getModuleName(), moduleName)) {
                moduleIntroduction = module.getIntro();
                teacher = module.getTeacher();
                teacherEmail = module.getTeacherEmail();
            }
        }
        //setSize(350, 500);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        // Create labels for the course name, description, teacher name and email
        JLabel courseNameLabel = new JLabel("Course Name: " + moduleName);
        JLabel courseDescriptionLabel = new JLabel("<html>Description: " + moduleIntroduction+"</html>");
        courseDescriptionLabel.setSize(100,200);
        JLabel teacherNameLabel = new JLabel("Teacher Name: " + teacher);
        JLabel teacherEmailLabel = new JLabel("Teacher Email: " + teacherEmail);

        // Add the labels to the frame
        add(courseNameLabel);
        add(new JLabel("\n"));
        add(courseDescriptionLabel);
        add(new JLabel("\n"));
        add(teacherNameLabel);
        add(new JLabel("\n"));
        add(teacherEmailLabel);
        // Set the size and location of the frame
        setBounds(5,70,400, 400);

        setLocationRelativeTo(null);
        // Show the frame
        //setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //JPanel panel = new JPanel();
        //add(panel);
        //panel.setLayout(null);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
