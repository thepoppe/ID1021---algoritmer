public class Main {
    public static void main(String[] args) {
        StaticStack stack = new StaticStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());



        MathOperation[] expr1 = {
                MathOperation.Value(10),
                MathOperation.Value(2),
                MathOperation.Value(5),
                MathOperation.Mul(),
                MathOperation.Add()
        };

        MathOperation[] expr2 = {
                MathOperation.Value(1),
                MathOperation.Value(2),
                MathOperation.Value(3),
                MathOperation.Value(4),
                MathOperation.Value(5),
                MathOperation.Value(6),
                MathOperation.Value(7),
                MathOperation.Value(8),
                MathOperation.Value(9),
                MathOperation.Value(10),
                MathOperation.Value(11),
                MathOperation.Value(12),
                MathOperation.Value(13),
                MathOperation.Value(14),
                MathOperation.Value(15),
                MathOperation.Value(16),
                MathOperation.Add(),
                MathOperation.Mul(),
                MathOperation.Add(),
                MathOperation.Mul(),
                MathOperation.Add(),
                MathOperation.Mul(),
                MathOperation.Add(),
                MathOperation.Mul(),
                MathOperation.Add(),
                MathOperation.Mul(),
                MathOperation.Add(),
                MathOperation.Mul(),
                MathOperation.Add(),
                MathOperation.Mul(),
                MathOperation.Add()
        };



        Calculator calc = new Calculator(expr1, new DynamicStack(4));
        int result = calc.run();
        System.out.println(" Calculator with dynamic stack:\nresult = " + result);

        calc.setExpression(expr2);
        result = calc.run();
        System.out.println(" Calculator with dynamic stack:\nresult = " + result);

        calc.setStack(new StaticStack(100));
        calc.setExpression(expr2);
        result = calc.run();
        System.out.println(" Calculator with static stack:\nresult = " + result);
    }


}