package com.digdes.school;


public class Main {
    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.execute("INSERT VALUES ‘lastName’ = ‘Федоров’ , ‘id’=3, ‘age’=40, ‘active’=true");
        starter.execute("DELETE VALUES ‘id’=3");
    }
}