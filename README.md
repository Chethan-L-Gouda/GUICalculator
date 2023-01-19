# GUICalculator
- basic calculator using swings from javax.swings package.
- performs addition ,subtraction,multiplication,division,and power.

## Classes
- [CalculatorUI](src/Calculator/CalculatorUI.java)
  - All the GUI Component are declared and their behaviour is defined in this class.
  - All the components are grouped in various Panels according to their function.
  - Then all the independent Panels are packed on a Frame.
  - All the values are pushed into a stack with their operator in infix form and passed to The <U>Expression Class</U>
- [Expression](src/Calculator/Expression.java)
  - The parameter passed through the constructor is a stack in infix order.
  - The infix stack is the converted into the postfix stack for easier evaluation of the expression.
  - Then the postfix stack is evaluated according to standard algorithm.