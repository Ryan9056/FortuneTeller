import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel iconPnl;  // Top
    JPanel displayPnl; // Center
    JPanel controlPnl; // Bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton fortuneBtn;
    JButton quitBtn;

    ArrayList<String> fortunes = new ArrayList<>();
    boolean dupe = true;
    int num;
    int past = 12;

    Random rnd = new Random();

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createFortunes();

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(810, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createFortunes() {
        fortunes.add("You will have good luck today");
        fortunes.add("Keep your hopes for there is light at the end of tunnel");
        fortunes.add("You will make a new friend today");
        fortunes.add("Misfortune will fall upon you");
        fortunes.add("You will do something triumphant today");
        fortunes.add("An exciting opportunity lies ahead of you");
        fortunes.add("Your life will be happy and peaceful");
        fortunes.add("Move in the direction of your dreams");
        fortunes.add("Happy news is on its way");
        fortunes.add("Plan for many pleasures ahead");
        fortunes.add("A routine task will turn into an enchanting adventure");
        fortunes.add("You will receive money from an unexpected source");

    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("D:\\Comp Prog 2 Projects\\FortuneTeller\\src\\Teller.jpg");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        // Obscure code to align the text to the Icon!
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setFont(new Font("Impact", Font.PLAIN, 36));

        iconPnl.add(titleLbl);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 35);
        displayTA.setFont(new Font("Georgia", Font.PLAIN, 14));
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        fortuneBtn = new JButton("Read My Fortune");
        fortuneBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            while (dupe) {
                num = rnd.nextInt(fortunes.size());
                if (num != past) {
                    past = num;
                    dupe = false;
                }

            }
            dupe = true;
            displayTA.append(fortunes.get(num) + "\n");

        });


        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

    }



}
