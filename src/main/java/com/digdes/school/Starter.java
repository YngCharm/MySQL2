package com.digdes.school;

import java.util.*;

public class Starter {
    public List<Map<String, Object>> list = new ArrayList<>();

    public Starter() {

    }

    public List<Map<String, Object>> execute(String request) {

        switch (readRequest(request)) {

            case "INSERT" -> insertListElement(request);
            case "UPDATE" -> updateListElement(request);
            case "DELETE" -> deleteListElement(request);
            case "SELECT" -> selectListElement(request);
            default -> throw new RuntimeException("Incorrect request.");
        }
        return list;
    }

    private String readRequest(String request) {
        if (request.startsWith("INSERT") || request.startsWith("UPDATE") || request.startsWith("DELETE") || request.startsWith("SELECT"))
            ;
        return request.substring(0, 6);
    }

    private void selectListElement(String request) {
    }

    private void deleteListElement(String request) {
        request = request.replaceAll("DELETE VALUES", "");
        request = request.replaceAll("‘", "");
        request = request.replaceAll("’", "");

        ArrayList<String> data = new ArrayList<>();

        String[] words = request.split("[=, ]");

        for (String word : words) {
            if (!word.isBlank()) {
                data.add(word.trim());
            }
        }
        //System.out.println(data);


        Map<String, Object> row = new HashMap<>();

        for (int i = 0; i < data.size(); i++) {
            if (i > 7) {
                break;
            }
            if (i == 0) {
                row.put(data.get(0), data.get(1));
            }
            if (i >= 2) {
                row.put(data.get(i), data.get(i + 1));
                i = i + 1;
            }
        }
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).containsKey(row) || list.get(i).containsValue(row)){
                list.remove(row);
            }
        }
        System.out.println(row);
        System.out.println(list);
    }

    private void updateListElement(String request) {
    }

    private void insertListElement(String request) {
        request = request.replaceAll("INSERT VALUES", "");
        request = request.replaceAll("‘", "");
        request = request.replaceAll("’", "");

        ArrayList<String> data = new ArrayList<>();

        String[] words = request.split("[=, ]");

        for (String word : words) {
            if (!word.isBlank()) {
                data.add(word.trim());
            }
        }

        Map<String, Object> row = new HashMap<>();
        //System.out.println(data);

        for (int i = 0; i < data.size(); i++) {
            if (i > 7) {
                break;
            }
            if (i == 0) {
                row.put(data.get(0), data.get(1));
            }
            if (i >= 2) {
                row.put(data.get(i), data.get(i + 1));
                i = i + 1;
            }
        }
        list.add(row);
        System.out.println(row);
        System.out.println("Вы добавили в таблицу: " + row);
        System.out.println(list + "лист до удаления");
    }
}