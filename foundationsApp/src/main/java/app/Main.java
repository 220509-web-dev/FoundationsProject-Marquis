package app;

import utilities.ConnectionUtil;

public class Main {
    public static void main(String[] args) {
        // connection successful
        System.out.println(ConnectionUtil.getInstance().getConnection());
    }
}
