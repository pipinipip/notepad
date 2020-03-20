import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class test {
    private JPanel panel1;
    private JButton sparaButton;
    private JButton öppnaButton;
    private JButton button3;
    private JTextArea textArea1;

    public test() {
        sparaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String aktuellMapp = System.getProperty("user.dir");
                JFileChooser fc = new JFileChooser((aktuellMapp));
                int resultat = fc.showSaveDialog(null);
                if (resultat != JFileChooser.APPROVE_OPTION) {
                    System.out.println("ingen fil valdes");
                    System.exit(0);
                }
                String filnamn = fc.getSelectedFile().getAbsolutePath();
                try {
                    PrintWriter inström = new PrintWriter(new BufferedWriter(new FileWriter(filnamn)));
                    inström.print(textArea1.getText());
                    inström.close();




                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        öppnaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                int resultat = fc.showOpenDialog(null);
                if (resultat != JFileChooser.APPROVE_OPTION) {
                    System.out.println("ingen fil valdes");
                    System.exit(0);
                }
                String filnamn = fc.getSelectedFile().getAbsolutePath();
                try {
                    BufferedReader inström = new BufferedReader
                            (new FileReader(filnamn));
                    while (true) {
                        String rad = inström.readLine();
                        if (rad == null)
                            break;
                        textArea1.append(rad);


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setContentPane(new test().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
