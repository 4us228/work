package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    public static String userInput;
    public static String cancel = "no";


    public void checkIP() throws FileNotFoundException {
        String filename = "blacklist.txt";
        File file = new File(filename);

        Scanner scanner = new Scanner(file);
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();


        System.out.println("Enter IP or quit:");


        while (true) {

            userInput = scanner1.nextLine();
            if (userInput.equals("quit")) break;
            userInput = checkInt(userInput);


            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
            }


            if (userInput.equals(cancel)) {
                System.out.println("invalid IP");
                System.out.println("Enter IP or quit:");
                continue;

            }
            if (arrayList.contains(userInput)) {
                System.out.println("Access disallowed");
                System.out.println("Enter IP or quit:");
                continue;

            }
            if (!arrayList.contains(userInput)) {
                System.out.println("Access allowed");
                System.out.println("Enter IP or quit:");
            }

            arrayList.clear();
        }
    }

    public String checkInt(String x) {
        String[] check = x.split("\\.");
        int[] ints = {0, 0, 0, 0};
        if (check.length == 4) {
            try {
                for (int i = 0; i < check.length; i++) {
                    ints[i] = Integer.parseInt(check[i]);

                    if (ints[i] < 0 || ints[i] > 255) {
                        x = cancel;
                    } else {
                        check[i] = String.valueOf(ints[i]);
                        x = String.join(".", check);
                    }

                }
            } catch (NumberFormatException ex) {
                x = cancel;
            }


        } else return x = cancel;


        return x;
    }
}

