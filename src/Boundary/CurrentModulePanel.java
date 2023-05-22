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
    //The first panel of the home page
    public JLabel currentModule, title, credit, module;
    public JButton schedule;
    public CurrentModulePanel(String buttonText, int indexOfStudentInformation) {
        setLayout(null);
        currentModule = new JLabel("Current Module");
        currentModule.setBounds(10, 10, 150, 30);
        add(currentModule);
        //Set the form table headers: title，credit，module
        title = new JLabel("Title");
        title.setBounds(75, 40, 150, 30);
        add(title);
        credit = new JLabel("Credit");
        credit.setBounds(200, 40, 150, 30);
        add(credit);
        module = new JLabel("Module");
        module.setBounds(320, 40, 150, 30);
        add(module);
        schedule = new JButton(buttonText);
        schedule.setForeground(Color.WHITE);
        schedule.setBackground(new Color(51, 102, 153));
        schedule.setFocusPainted(false);
        schedule.setBounds(300, 10, 90, 28);
        add(schedule);
        schedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SchedulePage schedulePage = new SchedulePage(indexOfStudentInformation);
                schedulePage.setLocationRelativeTo(null);
                schedulePage.setVisible(true);
                System.out.println("check schedule");
            }
        });
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        String moduleName = null;
        int credit = 0;
        String moduleId;
        List<Module> moduleList = new ModuleUtil().getModules(indexOfStudentInformation);
        System.out.println(moduleList.get(0).getModuleName());
        int count = 0;
        for (int i = 0; i < moduleList.size(); i++) {
            if (Objects.equals(moduleList.get(i).getState(), "current")) {
                moduleName = moduleList.get(i).getModuleName();
                credit = moduleList.get(i).getCredit();
                moduleId = moduleList.get(i).getModuleId();
                JButton moduleButton = new JButton(moduleName);
                JLabel moduleCredit = new JLabel(String.valueOf(credit));
                JLabel moduleIdentity = new JLabel(moduleId);
                moduleButton.setForeground(Color.WHITE);
                moduleButton.setBackground(new Color(117, 163, 208));
                moduleButton.setFocusPainted(false);
                moduleButton.setBounds(10,  10+40 * count, 150, 25);
                moduleCredit.setBounds(210, 10+40 * count, 50, 25);
                moduleIdentity.setBounds(315, 10+40 * count, 150, 25);
                contentPanel.add(moduleButton);
                contentPanel.add(moduleCredit);
                contentPanel.add(moduleIdentity);
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
        contentPanel.setPreferredSize(new Dimension(300, 100+40*count));
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(5, 70, 400, 190);
        contentPanel.setBackground(new Color(152, 194, 246));
        add(scrollPane);

    }
    @Override
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
    }
}