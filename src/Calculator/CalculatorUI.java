package Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame{
    JFrame rootFrame;
    JPanel rootPanel=new JPanel(new BorderLayout()),optPanel,opdPanel,resPanel;
    public CalculatorUI(){
        opdPanel=new JPanel(new GridLayout(2,1));
        optPanel=new JPanel(new GridLayout(2,2));
        resPanel=new JPanel();
        Font lblF=new Font("Mono scope",Font.ITALIC,30);
        Font tfF=new Font("Mono scope",Font.BOLD,25);
        Color btnBGC=new Color(51, 61, 68);
        Color btnFGC=new Color(212, 204, 204);


        JLabel resLabel = new JLabel();
        resLabel.setFont(lblF);
        resLabel.setPreferredSize(new Dimension(500,100));
        resPanel.add(resLabel);

        JTextField opd1=new JTextField();
        JTextField opd2=new JTextField();
        opd2.setFont(tfF);
        opd1.setFont(tfF);
        opd1.setColumns(25);
        opd2.setColumns(25);
        opdPanel.add(opd1);opdPanel.add(opd2);

        JButton addBtn=new JButton("+");
        JButton subBtn=new JButton("-");
        JButton mulBtn=new JButton("x");
        JButton divBtn=new JButton("/");
        Dimension btnD=new Dimension(100,100);
        addBtn.setPreferredSize(btnD);subBtn.setPreferredSize(btnD);
        mulBtn.setPreferredSize(btnD);divBtn.setPreferredSize(btnD);

        addBtn.addActionListener(e -> {
            try{
                double a,b;
                a=Double.parseDouble(opd1.getText());
                b=Double.parseDouble(opd2.getText());
                resLabel.setText(String.valueOf((a+b)));
            }catch (NumberFormatException n){
                resLabel.setText("Enter Numbers!");
            }
        });

        subBtn.addActionListener(e -> {
            try{
                double a,b;
                a=Double.parseDouble(opd1.getText());
                b=Double.parseDouble(opd2.getText());
                resLabel.setText(String.valueOf((a-b)));
            }catch (NumberFormatException n){
                resLabel.setText("Enter Numbers!");
            }
        });

        mulBtn.addActionListener(e -> {
            try{
                double a,b;
                a=Double.parseDouble(opd1.getText());
                b=Double.parseDouble(opd2.getText());
                resLabel.setText(String.valueOf((a*b)));
            }catch (NumberFormatException n){
                resLabel.setText("Enter Numbers!");
            }
        });

        divBtn.addActionListener(e -> {
            try{
                double a,b;
                a=Double.parseDouble(opd1.getText());
                b=Double.parseDouble(opd2.getText());
                resLabel.setText(String.valueOf((a/b)));
            }catch (NumberFormatException n){
                resLabel.setText("Enter Numbers!");
            }
        });

        addBtn.setBackground(btnBGC);
        subBtn.setBackground(btnBGC);
        mulBtn.setBackground(btnBGC);
        divBtn.setBackground(btnBGC);
        addBtn.setForeground(btnFGC);
        subBtn.setForeground(btnFGC);
        mulBtn.setForeground(btnFGC);
        divBtn.setForeground(btnFGC);
        optPanel.add(addBtn);
        optPanel.add(subBtn);
        optPanel.add(mulBtn);
        optPanel.add(divBtn);

        JPanel actPanel=new JPanel(new GridLayout(2,1));
        actPanel.add(opdPanel);
        actPanel.add(resPanel);

        rootPanel.add(optPanel,BorderLayout.EAST);
        rootPanel.add(actPanel,BorderLayout.WEST);
    }

    public void showWindow() {
        rootFrame=new JFrame("Simple calculator");
        rootFrame.setContentPane(rootPanel);
        rootFrame.setVisible(true);
        rootFrame.pack();
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
