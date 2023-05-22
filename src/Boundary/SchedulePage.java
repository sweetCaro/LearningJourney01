package Boundary;

import Controller.ScheduleUtil;
import entity.Module;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class SchedulePage extends JFrame {
    private JPanel panel;
    private JLabel header;
    private JTable table;
    private String[] columnNames = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private Object[][] data = new Object[15][6];

    public SchedulePage(int indexOfStudentInformation) {
        // Set up the frame
        setTitle("Schedule Page");
        setSize(700, 400);

        // Create a panel to add components to
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create the header
        header = new JLabel("Class Schedule");
        header.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(header);

        // Load the data with module
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    data[i][j] = String.format("%02d:00", i + 7);
                }
            }
        }

        List<Module> currentModules = new ScheduleUtil().getModules(indexOfStudentInformation);
        for (Module currentModule : currentModules) {
            int[] index = new ScheduleUtil().getTimeAndDay(currentModule);
            data[index[0]][index[1]] = currentModule.getModuleName();
        }

        // Create the table
        table = new JTable(data, columnNames);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setSelectionBackground(new Color(171, 203, 239));
        table.setSelectionForeground(Color.WHITE);
        table.setShowGrid(true);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 15));
        header.setBackground(new Color(51, 102, 152));
        header.setForeground(Color.WHITE);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(new Color(237, 242, 248));
        table.getColumn("Monday").setCellRenderer(renderer);
        table.getColumn("Tuesday").setCellRenderer(renderer);
        table.getColumn("Wednesday").setCellRenderer(renderer);
        table.getColumn("Thursday").setCellRenderer(renderer);
        table.getColumn("Friday").setCellRenderer(renderer);

        table.setDefaultRenderer(Object.class, new ScheduleTableCellRenderer());
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.BOLD, 12));

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Add the panel to the frame
        add(panel);

        // Display the frame
        setVisible(true);
    }

    class ScheduleTableCellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, column) != null) {
                c.setBackground(new Color(98, 154, 208));
            } else {
                c.setBackground(Color.WHITE);
            }
            return c;
        }
    }
}
