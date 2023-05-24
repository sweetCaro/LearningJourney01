package Boundary;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainingProgramPage extends JFrame implements ActionListener {
    private JTextArea textArea;

    public TrainingProgramPage() {
        setTitle("Training Program");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300,600));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(5,70,400,600);
        textArea.setBackground(new Color(197, 221, 252, 250));

        add(scrollPane);

        setSize(400, 500);
        setLocationRelativeTo(null); // 将窗口置于屏幕中心
        setVisible(true);

        loadFileContent();
    }

    private void loadFileContent() {
        String filePath = "src/Data/TrainingProgram.txt";
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            String content = readFileContent(file);
            textArea.setText(content);
        } else {
            textArea.setText("File not found.");
        }
    }

    private String readFileContent(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


