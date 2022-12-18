package Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class CalculatorUI extends JFrame{
    JFrame rootFrame;
    JPanel rootPanel=new JPanel(new BorderLayout()),optPanel,opdPanel,resPanel;
    String expression="";
    String number =null;
    String answer=null;
    Stack<String> exp=new Stack<>();

    public CalculatorUI(){
        opdPanel=new JPanel();
        optPanel=new JPanel(new GridBagLayout());
        resPanel=new JPanel();
        Font lblF=new Font("Mono scope",Font.ITALIC,30);
        Font tfF=new Font("Mono scope",Font.BOLD,25);
        Color btnBGC=new Color(51, 61, 68);
        Color btnFGC=new Color(212, 204, 204);
        Color lblBGC=new Color(75, 83, 100, 160);


        JLabel resLabel = new JLabel();
        resLabel.setFont(lblF);
        resLabel.setOpaque(true);
        resLabel.setBackground(lblBGC);
        resLabel.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        resLabel.setPreferredSize(new Dimension(500,100));
        resPanel.add(resLabel);

        JTextField opd1=new JTextField();
        opd1.setFont(tfF);
        opd1.setColumns(20);
        opdPanel.add(opd1);

        JButton addBtn=new JButton("+");
        JButton subBtn=new JButton("-");
        JButton mulBtn=new JButton("x");
        JButton divBtn=new JButton("/");
        JButton powBtn = new JButton("^");
        JButton ansBtn=new JButton("ANS");
        JButton eqlBtn = new JButton("=");
        Dimension btnD=new Dimension(100,50);
        addBtn.setPreferredSize(btnD);subBtn.setPreferredSize(btnD);
        mulBtn.setPreferredSize(btnD);divBtn.setPreferredSize(btnD);
        powBtn.setPreferredSize(btnD);ansBtn.setPreferredSize(btnD);
        eqlBtn.setPreferredSize(btnD);

        addBtn.addActionListener(e -> {
            if(number !=null)
                exp.push(number);
            exp.push("+");
            this.number=null;
            expression=expression.concat("+");
            opd1.setText(expression);
        });

        subBtn.addActionListener(e -> {
            if(number != null)
                exp.push(number);
            exp.push("-");
            this.number=null;
            expression=expression.concat("-");
            opd1.setText(expression);
        });

        mulBtn.addActionListener(e -> {
            if(number != null)
                exp.push(number);
            exp.push("*");
            this.number=null;
            expression=expression.concat("*");
            opd1.setText(expression);
        });

        divBtn.addActionListener(e -> {
            if(number != null)
                exp.push(number);
            exp.push("/");
            this.number=null;
            expression=expression.concat("/");
            opd1.setText(expression);
        });
        eqlBtn.addActionListener(e->{
            try {
                if (number != null)
                    exp.push(number);
                resPanel.repaint();
                Expression expr = new Expression(exp);
                answer = String.valueOf(expr.solve());
                resLabel.setText(answer);
                number = null;
                exp.clear();
                expression = "";
            }catch (Exception er){
                resPanel.repaint();
                resLabel.setText("ERROR");
            }
        });

        ansBtn.addActionListener(e->{
            if(answer != null){
                exp.push(answer);
                expression=expression.concat(answer);
            }
            opd1.setText(expression);
        });

        powBtn.addActionListener(e -> {
            if(number != null)
                exp.push(number);
            exp.push("^");
            this.number=null;
            expression=expression.concat("^");
            opd1.setText(expression);
        });

        addBtn.setBackground(btnBGC);subBtn.setBackground(btnBGC);
        mulBtn.setBackground(btnBGC);divBtn.setBackground(btnBGC);
        powBtn.setBackground(btnBGC);ansBtn.setBackground(btnBGC);
        addBtn.setForeground(btnFGC);subBtn.setForeground(btnFGC);
        mulBtn.setForeground(btnFGC);divBtn.setForeground(btnFGC);
        powBtn.setForeground(btnFGC);ansBtn.setForeground(btnFGC);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;gbc.gridy=0;
        optPanel.add(addBtn,gbc);
        gbc.gridx=1;gbc.gridy=0;
        optPanel.add(subBtn,gbc);
        gbc.gridx=0;gbc.gridy=1;
        optPanel.add(mulBtn,gbc);
        gbc.gridx=1;gbc.gridy=1;
        optPanel.add(divBtn,gbc);
        gbc.gridx=0;gbc.gridy=2;
        optPanel.add(powBtn,gbc);
        gbc.gridx=1;gbc.gridy=2;
        optPanel.add(ansBtn,gbc);
        gbc.gridx=0;gbc.gridy=3;
        gbc.gridwidth=2;
        optPanel.add(eqlBtn,gbc);

        JPanel numPanel = new JPanel(new GridLayout(4,3));
        JButton [] num = new  JButton[10];

        for (int i=1;i<10;i++){
            num[i]=new JButton(String.valueOf(i));
            num[i].setPreferredSize(btnD);
            int finalI = i;
            num[i].addActionListener(e->{
                try {
                    this.number = number.concat(num[finalI].getText());
                }catch (NullPointerException n){
                    number="";
                    number=number.concat(num[finalI].getText());
                }
                expression = expression.concat(num[finalI].getText());
                opd1.setText(expression);
            });
            numPanel.add(num[i]);
        }
        num[0]=new JButton("0");
        num[0].addActionListener(e->{
            try {
                this.number = number.concat("0");
            }catch (NullPointerException n){
                number="0";
            }
            expression = expression.concat("0");
            opd1.setText(expression);
        });
        numPanel.add(num[0]);
        JButton dotBtn=new JButton(".");
        dotBtn.addActionListener(e->{
            this.number =number.concat(".");
            expression = expression.concat(".");
            opd1.setText(expression);
        });
        numPanel.add(dotBtn);
        JButton clrBtn=new JButton("clr");
        clrBtn.addActionListener(e->{
            expression="";
            number=null;
            exp.clear();
            answer=null;
            resLabel.setText("");
            opd1.setText(expression);
        });
        numPanel.add(clrBtn);

        JPanel actPanel=new JPanel(new BorderLayout());
        actPanel.add(opdPanel,BorderLayout.NORTH);
        actPanel.add(resPanel,BorderLayout.SOUTH);

        JPanel btnPanel=new JPanel(new FlowLayout());
        btnPanel.add(numPanel);btnPanel.add(optPanel);

        rootPanel.add(btnPanel,BorderLayout.SOUTH);
        rootPanel.add(actPanel,BorderLayout.NORTH);
    }

    public void showWindow() {
        rootFrame=new JFrame("Simple calculator");
        rootFrame.setContentPane(rootPanel);
        rootFrame.setVisible(true);
        rootFrame.pack();
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
