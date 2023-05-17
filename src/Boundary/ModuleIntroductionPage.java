package Boundary;

import Controller.ModuleIntroductionUtil;
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
        List<Module> moduleList = new ModuleIntroductionUtil().getModules(indexOfStudentInformation);
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
        JLabel courseDescriptionLabel = new JLabel("Description: " + moduleIntroduction);
        JLabel teacherNameLabel = new JLabel("Teacher Name: " + teacher);
        JLabel teacherEmailLabel = new JLabel("Teacher Email: " + teacherEmail);
        // Add the labels to the frame
        add(courseNameLabel);
        add(courseDescriptionLabel);
        add(teacherNameLabel);
        add(teacherEmailLabel);
        // Set the size and location of the frame
        setSize(400, 200);
        setLocationRelativeTo(null);
        // Show the frame
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
//import javax.swing.*;
//public class CourseDetailsPage extends JFrame {
//    public CourseDetailsPage(String moduleName, String intro,
//                             String teacher, String teacherEmail) {
//        // Create a new JFrame
//        super("Course Details");
//        // Set the layout
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//        // Create labels for the course name, description, teacher name and email
//        JLabel courseNameLabel = new JLabel("Course Name: " + moduleName);
//        JLabel courseDescriptionLabel = new JLabel("Course Description: " + intro);
//        JLabel teacherNameLabel = new JLabel("Teacher Name: " + teacher);
//        JLabel teacherEmailLabel = new JLabel("Teacher Email: " + teacherEmail);
//        // Add the labels to the frame
//        add(courseNameLabel);
//        add(courseDescriptionLabel);
//        add(teacherNameLabel);
//        add(teacherEmailLabel);
//        // Set the size and location of the frame
//        setSize(400, 300);
//        setLocationRelativeTo(null);
//        // Show the frame
//        setVisible(true);
//    }
//    public static void main(String[] args) {
//        // Create a new instance of the CourseDetailsPage
//        CourseDetailsPage courseDetailsPage = new CourseDetailsPage(
//                "Java Programming",
//                "This course teaches the basics of Java programming.",
//                "John Smith",
//                "john.smith@example.com");
//    }
//}