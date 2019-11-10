import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        String command = scanner.nextLine();

        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        while (!command.equals("END")) {
            String[] temp = command.split("\\s+");
            String firstCommand = temp[0];


            if (firstCommand.equals("Change")) {
                if (numbers.contains(Integer.parseInt(temp[1]))) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == Integer.parseInt(temp[1])) {
                            numbers.set(i, Integer.parseInt(temp[2]));
                            break;
                        }
                    }
                }
            }

            if (firstCommand.equals("Hide")) {
                if (numbers.contains(Integer.parseInt(temp[1]))) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == Integer.parseInt(temp[1])) {
                            numbers.remove(numbers.get(i));
                        }
                    }
                }
            }

            if (firstCommand.equals("Switch")) {
                if (numbers.contains(Integer.parseInt(temp[1])) && numbers.contains(Integer.parseInt(temp[2]))) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == Integer.parseInt(temp[1])) {
                            numbers.set(i, Integer.parseInt(temp[2]));
                        } else if (numbers.get(i) == Integer.parseInt(temp[2])) {
                            numbers.set(i, Integer.parseInt(temp[1]));
                        }
                    }
                }
            }

            if (firstCommand.equals("Insert")) {
                if (Integer.parseInt(temp[1]) >= -1 && Integer.parseInt(temp[1]) <= numbers.size() - 1) {
                    numbers.add(Integer.parseInt(temp[1]) + 1, Integer.parseInt(temp[2]));
                }
            }

            if (firstCommand.equals("Reverse")) {
                Collections.reverse(numbers);
            }

            command = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }
}
