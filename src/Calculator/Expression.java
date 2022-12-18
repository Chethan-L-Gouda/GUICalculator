package Calculator;

import java.util.EmptyStackException;
import java.util.Stack;

public class Expression {
    private final Stack<String> postfix = new Stack<>();

    public Expression(Stack<String> ExpInfix){
        Stack<Double> items = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(String ent:ExpInfix){
            try{
                double cur = Double.parseDouble(ent);
                items.push(cur);
            } catch(NumberFormatException n){
                if((ent.charAt(0) == '+')||(ent.charAt(0) == '-')||(ent.charAt(0) == '*')||(ent.charAt(0) == '/')||(ent.charAt(0) == '^')) {
                    postfix.push(String.valueOf(items.pop()));
                    if (operator.isEmpty())
                        operator.push(ent.charAt(0));
                    else {
                        try {
                            while (!highPrecedence(ent.charAt(0), operator.peek()) || samePrecedence(ent.charAt(0), operator.peek()))
                                postfix.push(String.valueOf(operator.pop()));
                        } catch (EmptyStackException ignored) {
                        }
                        operator.push(ent.charAt(0));
                    }
                }
            }
        }
        int n = items.size();
        int m = operator.size();
        for(int i=0;i<n;i++) postfix.push(String.valueOf(items.pop()));
        for (int i=0;i<m;i++) postfix.push(String.valueOf(operator.pop()));
    }
    private int getPrecedence(char op){
        if(op=='+'||op=='-')
            return 1;
        if(op=='*'||op=='/')
            return 2;
        if (op=='^')
            return 3;
        return 0;
    }
    private boolean samePrecedence(char op1,char op2){
        return getPrecedence(op1) == getPrecedence(op2);
    }
    private boolean highPrecedence(char op1, char op2){
        return getPrecedence(op1) > getPrecedence(op2);
    }
    public double solve(){
        double result,opd2,opd1;
        Stack<Double> eval = new Stack<>();
        for(String ent : postfix){
            try {
                eval.push(Double.parseDouble(ent));
            }catch (NumberFormatException e){
                opd2=eval.pop();
                opd1=eval.pop();
                switch (ent.charAt(0)){
                    case '+'-> eval.push(opd1+opd2);
                    case '-'-> eval.push(opd1-opd2);
                    case '*'-> eval.push(opd1*opd2);
                    case '/'-> eval.push(opd1/opd2);
                    case '^'-> eval.push(Math.pow(opd1,opd2));
                }
            }
        }
        result=eval.pop();
        return result;
    }
    public void displayPostfix(){
        System.out.println();
        for (String s : postfix){
            System.out.print(s+"\t");
        }
        System.out.println();
    }
}
