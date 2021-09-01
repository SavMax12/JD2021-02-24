package by.it._classwork_.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {



    Var evaluate(String expression) throws CalcException {
        ArrayList<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        ArrayList<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = oneOperation(left, operation, right);
            operands.add(index, result.toString());
        }

        return VarCreator.build(operands.get(0));
    }

    public Var calc(String expression) throws CalcException {
        //A=2+2*2-9
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression.replace(" ", ""));
        ArrayList<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());

        }
        while (operations.size() > 0){
            int index = getIndex(operations);
        String left = operands.remove(index);
        String right = operands.remove(index);
        String operation = operations.remove(index);
        Var result = oneOperation(left, operation, right);
        operands.add(index, result.toString());
    }
        return VarCreator.build(operands.get(0));
}

    private Var oneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var right = VarCreator.build(rightStr);
        if (operation.equals("=")) {
            return Var.save(leftStr, right);
        }
        Var leftVar = VarCreator.build(leftStr);


        switch (operation) {
            case "+":
                return leftVar.add(right);
            case "-":
                return leftVar.sub(right);
            case "*":
                return leftVar.mul(right);
            case "/":
                return leftVar.div(right);
        }
        throw new CalcException("aaa "); //stub
    }

    private static final Map<String, Integer> pr = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    private int getIndex(ArrayList<String> operations) {
        int index = -1;
        int best = -1;
        for (int i = 0; i < operations.size(); i++) {
            int currentPr = pr.get(operations.get(i));
            if (currentPr > best) {
                index = i;
                best = currentPr;
            }
        }
        return index;
    }
}
