/*
The program reads the contents of the file, 
which user can select using button Open file or 
inserting the path into the field File name
*/
package fileread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class PrintFile extends JFrame {

    PrintFile() {

        JFrame okno = new JFrame();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEADING));

        JTextField field_dir = new JTextField("File name", 30);
        container.add(field_dir);

        JButton opendir = new JButton("Open file");
        container.add(opendir);

        JTextArea textarea = new JTextArea(40, 50);
        container.add(textarea);
        textarea.setLineWrap(true);

        JFileChooser fileChooser = new JFileChooser();

        opendir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fileChooser.setDialogTitle("Directory");

                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(PrintFile.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                        textarea.read(input, "Reading file");
                        field_dir.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    } catch (Exception e1) {
                        System.out.println("File isn't readable");
                    }
                } else {
                    System.out.println("Operation is Canceled");

                }
            }
        });

        field_dir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                
                fileChooser.setDialogTitle("Directory");
                
              
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(PrintFile.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                        textarea.read(input, "Reading file");
                        field_dir.setText(fileChooser.getSelectedFile().getAbsolutePath());
                        fileChooser.setCurrentDirectory(file);
                    } catch (Exception e1) {
                        System.out.println("File isn't readable");
                    }
                } else {
                    System.out.println("Operation is Canceled");

                }
            }

        });

    }
}

public class FileRead {

    public static void main(String[] args) {
        PrintFile okno = new PrintFile();
        okno.pack();
        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
        okno.setSize(700, 800);
        okno.setTitle("Reader file");

    }

}
