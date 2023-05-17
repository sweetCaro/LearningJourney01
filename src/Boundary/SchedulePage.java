package Boundary;

import Controller.ScheduleUtil;
import entity.Module;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SchedulePage extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel header;
    private JTable table;
    private String[] columnNames = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private Object[][] data = new Object[15][6];

    public SchedulePage(int indexOfStudentInformation) {
        // Set up the frame
        setTitle("Schedule Page");
        //setTitle("Class Schedule");
        setSize(600, 400);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a panel to add components to
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // Create the header
        header = new JLabel("Class Schedule");
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(header);
        // load the data with module



        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    data[i][j] = String.format("%02d:00", i + 7);
                } else {

                }
            }
        }
        //data[2][3] = "123";
        List<Module> currentModules = new ScheduleUtil().getModules(indexOfStudentInformation);
        for(Module currentModule : currentModules){
            int[] index=new ScheduleUtil().getTimeAndDay(currentModule);
            data[index[0]][index[1]] = currentModule.getModuleName();
        }

        // Create the table
        table = new JTable(data, columnNames);
        table.setDefaultRenderer(Object.class, new ScheduleTableCellRenderer());
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        // Add the panel to the frame
        add(panel);
        // Display the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
//    public static void main(String[] args) {
//        SchedulePage schedule = new SchedulePage(indexOfStudentInformation);
//    }

    class ScheduleTableCellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, column) != null) {
                c.setBackground(Color.CYAN);
            } else {
                c.setBackground(Color.WHITE);
            }
            return c;
        }

    }
}

//public class SchedulePage extends JFrame implements ActionListener{
//    //课程表页面
//    public SchedulePage(int indexOfStudentInformation){
//        setTitle("Schedule Page");
//        setSize(350,500);
//        JPanel panel = new JPanel();
//        add(panel);
//        JLabel schedule = new JLabel();
//
//        //ImageIcon scheduleImage = new ImageIcon("./schedule");
//
//        panel.add(schedule);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}
