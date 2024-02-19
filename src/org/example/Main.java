package org.example;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

public class Main {
    public static void main(String[] args) {
        String abecele = "aąbcčdeęėfghiįyjklmnoprsštuvųūvzž123456789";
        Scanner myObj = new Scanner(System.in);
        int a = 0;
        while (a != 9) {
            System.out.println("1.Užkodavimas Vigenere algoritmo");
            System.out.println("2.Atkodavimas Vigenere algoritmo");
            System.out.println("3.Užkodavimas Vigenere algoritmo naudojant ASCII");
            System.out.println("4.Atkodavimas Vigenere algoritmo naudojant ASCII");
            System.out.println("9.Uždaryti");
            System.out.print("Pasirinkite: ");
            a = Integer.parseInt(myObj.nextLine());
            if (a == 1 || a == 2 || a == 3 || a == 4) {
                String text = getText();
                String key = getKey();
                if(a == 1 || a == 2){
                    text = text.toLowerCase();
                    key = key.toLowerCase();
                }
                int textLength = text.length();
                int keyLength = key.length();
                char[] keyArray = key.toCharArray();
                char[] textArray = text.toCharArray();
                String[] codeArray = new String[textLength];
                if (a == 1) {
                    for (int i = 0; i < textLength; i++) {
                        int textIdx = abecele.indexOf(textArray[i]);
                        if (textIdx != -1) {
                            int keyIdx = abecele.indexOf(keyArray[i % keyLength]);
                            int codeIdx = (textIdx + keyIdx) % abecele.length();
                            char codeLetter = abecele.charAt(codeIdx);
                            codeArray[i] = String.valueOf(codeLetter);
                        } else {
                            codeArray[i] = String.valueOf(textArray[i]);
                        }
                    }
                }
                if (a == 2) {
                    for (int i = 0; i < textLength; i++) {
                        int textIdx = abecele.indexOf(textArray[i]);
                        if (textIdx != -1) {
                            int keyIdx = abecele.indexOf(keyArray[i % keyLength]);
                            int codeIdx = (textIdx - keyIdx + abecele.length()) % abecele.length();
                            char codeLetter = abecele.charAt(codeIdx);
                            codeArray[i] = String.valueOf(codeLetter);
                        } else {
                            codeArray[i] = String.valueOf(textArray[i]);
                        }
                    }
                }
                if (a == 3) {
                    for (int i = 0; i < textLength; i++) {
                            int textIdx = textArray[i] - ' ';
                            System.out.println("Skaicius: " + textIdx);
                            int keyIdx = keyArray[i % keyLength] - ' ';
                            System.out.println("Skaicius Key: " + keyIdx);
                            int codeIdx = ((textIdx + keyIdx) % 97) + ' ';
                            System.out.println("Skaicius code: " + codeIdx);
                            char codeLetter = (char) (codeIdx);
                            codeArray[i] = String.valueOf(codeLetter);
                    }
                }
                if (a == 4) {
                    for (int i = 0; i < textLength; i++) {
                        int textIdx = textArray[i] - ' ';
                        System.out.println("Skaicius text: " + textIdx);
                        int keyIdx = keyArray[i % keyLength] - ' ';
                        System.out.println("Skaicius Key: " + keyIdx);
                        int codeIdx = ((textIdx - keyIdx + 97) % 97) + ' ';
                        System.out.println("Skaicius code: " + codeIdx);
                        char codeLetter = (char) (codeIdx);
                        codeArray[i] = String.valueOf(codeLetter);
                    }
                }
                String code = String.join("",codeArray);
                System.out.println("Gautas tekstas: " + code);
            }
        }
    }

    public static String getText() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Iveskite teksta: ");
        return myObj.nextLine();
    }
    public static String getKey() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Iveskite rakta: ");
        return myObj.nextLine();
    }
}