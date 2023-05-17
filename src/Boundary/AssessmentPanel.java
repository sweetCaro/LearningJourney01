package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssessmentPanel extends JPanel {
    //主页的第二块面板
    public JLabel assessmentLabel;
    public JButton detail;
    public AssessmentPanel(int indexOfStudentInformation){
        setLayout(null);
        assessmentLabel =new JLabel("Assessment");
        assessmentLabel.setBounds(5,10,150,30);
        add(assessmentLabel);
        setVisible(true);

        detail = new JButton("Detail");
        detail.setBounds(300,10,90,28);
        add(detail);
        detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssessmentPage assessmentPage = new AssessmentPage(indexOfStudentInformation);
                assessmentPage.setLocationRelativeTo(null);
                assessmentPage.setVisible(true);
                //dispose();
                System.out.println("Assessment Page!");
            }
        });
    }
    @Override//设置渐变
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int height = getHeight() - 1;
        int width = getWidth() - 1;
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(109, 136, 241, 211),
                0, height, new Color(16, 122, 231));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(new Color(85, 143, 199));
        g2d.drawRect(0, 0, width, height);
        g2d.dispose();
    }

}
