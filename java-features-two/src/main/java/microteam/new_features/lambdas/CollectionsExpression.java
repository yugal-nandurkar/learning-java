package microteam.new_features.lambdas;

import java.util.ArrayList;
import java.util.List;

public class CollectionsExpression {

    public static void main(String args[]) {

        // prepare a list of strings
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("html");
        list.add("python");

        // print the list using a lambda expression
        // here we're passing a lambda expression to forEach
        // method of list object
        list.forEach(i -> System.out.println(i));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        System.out.println(numbers);

        // filter the list using a lambda expression
        // here we're passing a lambda expression to removeIf
        // method of list object where we can checking
        // if number is divisible by 2 or not
        numbers.removeIf( n -> n%2 != 0);
        System.out.println(numbers);
    }
}
