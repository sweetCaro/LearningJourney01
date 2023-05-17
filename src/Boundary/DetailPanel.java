package Boundary;

import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel {
    public JLabel title,credit,module,score;
    public DetailPanel(int indexOfStudentInformation) {
        setLayout(null);
        setPreferredSize(new Dimension(400, 300));
        setBackground(new Color(225, 225, 225));
        //添加表单头标签文字：title，credit，module
        title =new JLabel("Title");
        title.setBounds(10,10,50,30);
        add(title);
        credit=new JLabel("credit");
        credit.setBounds(190,10,50,30);
        add(credit);
        module=new JLabel("module");
        module.setBounds(270,10,50,30);
        add(module);
        score=new JLabel("score");
        score.setBounds(370,10,50,30);
        add(score);
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
        g2d.dispose();
    }
}
