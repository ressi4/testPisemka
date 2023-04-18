import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Form extends JFrame{
    private JTextField textField1;
    private JButton btnErase;
    private JTextArea textArea1;
    private JPanel mainPanel;



    JFileChooser vyberSoubor = new JFileChooser();

    public Form() {
        List<CykloVylet> polozky = new ArrayList<>();

        setContentPane(mainPanel);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu soubor = new JMenu("Soubor");
        menuBar.add(soubor);
        JMenuItem nacti = new JMenuItem("Načti");
        soubor.add(nacti);
        JMenuItem refresh = new JMenuItem("Refresh");
        soubor.add(refresh);

        btnErase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nacti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vypis(vyberSoubor());
            }
        });
    }
    private File vyberSoubor(){
        int vysledek = vyberSoubor.showSaveDialog(mainPanel);
        if(vysledek == vyberSoubor.APPROVE_OPTION){
            return vyberSoubor.getSelectedFile();
        }


        return null;
    }
    private void vypis(File soubor){
        try {
            Scanner scanner = new Scanner(soubor);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
                

            }
        } catch (IOException e) {
            chyba();
        }
    }
private void chyba(){
        JOptionPane.showMessageDialog(mainPanel,"Nastala chyba při výpisu dat ze souboru.");
}

    public static void zeRadku(String text){
        List<CykloVylet> polozky = new ArrayList<>();
        String[] splitRadku = text.split(",");
        String cil = splitRadku[0];
        int delka = Integer.parseInt(splitRadku[1]);
        Date datum = new Date(Long.parseLong(splitRadku[2]));
        polozky.add(new CykloVylet(cil,delka,datum));

    }
}
