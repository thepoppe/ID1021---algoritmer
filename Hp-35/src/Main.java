public class Main {
    public static void main(String[] args) {
        StaticStack stack = new StaticStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());



        mathOperation[] expr1 = {
                mathOperation.Value(10),
                mathOperation.Value(2),
                mathOperation.Value(5),
                mathOperation.Mul(),
                mathOperation.Add()
        };

        mathOperation[] expr2 = {
                mathOperation.Value(1),
                mathOperation.Value(2),
                mathOperation.Value(3),
                mathOperation.Value(4),
                mathOperation.Value(5),
                mathOperation.Value(6),
                mathOperation.Value(7),
                mathOperation.Value(8),
                mathOperation.Value(9),
                mathOperation.Value(10),
                mathOperation.Value(11),
                mathOperation.Value(12),
                mathOperation.Value(13),
                mathOperation.Value(14),
                mathOperation.Value(15),
                mathOperation.Value(16),
                mathOperation.Add(),
                mathOperation.Mul(),
                mathOperation.Add(),
                mathOperation.Mul(),
                mathOperation.Add(),
                mathOperation.Mul(),
                mathOperation.Add(),
                mathOperation.Mul(),
                mathOperation.Add(),
                mathOperation.Mul(),
                mathOperation.Add(),
                mathOperation.Mul(),
                mathOperation.Add(),
                mathOperation.Mul(),
                mathOperation.Add()
        };



        Calculator calc = new Calculator(expr1, new DynamicStack(4));
        int result = calc.run();
        System.out.println(" Calculator with dynamic stack:\nresult = " + result);

        calc.setExpression(expr2);
        result = calc.run();
        System.out.println(" Calculator with dynamic stack:\result = " + result);

        calc.setStack(new StaticStack(100));
        calc.setExpression(expr2);
        result = calc.run();
        System.out.println(" Calculator with static stack:\nresult = " + result);
    }


}