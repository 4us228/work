package company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Read read = new Read();
        try {
            read.checkIP();
        } catch (IOException e) {
            System.out.println("blacklist not found");
        }
    }
}
