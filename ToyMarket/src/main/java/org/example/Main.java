package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import org.example.FileSave;

public class Main implements rollable {
    public static void main(String[] args) throws Exception {
        ArrayList<Toy> toysList = new ArrayList<Toy>();
        ArrayList<String> wonToys = new ArrayList<String>();
        Toy constructor = new Toy(1, "Конструктор", 5, 11);
        Toy doll = new Toy(2, "Кукла", 2, 31);
        Toy robot = new Toy(3, "Робот", 5, 19);
        Toy car = new Toy(4, "Машинка", 25, 44);
        toysList.add(constructor);
        toysList.add(doll);
        toysList.add(robot);
        toysList.add(car);
//        controller.start(); todo хорошо бы в отдельный контроллер выделить, но пока ООП не проникся.
        String rolledToy = rollable.rollToy(toysList);// переменная для сохранения ролла.
        wonToys.add(rolledToy);
        pickUpToyFromList(rolledToy,toysList);
        rolledToy = rollable.rollToy(toysList);
        wonToys.add(rolledToy);
        pickUpToyFromList(rolledToy,toysList);
        rolledToy = rollable.rollToy(toysList);
        wonToys.add(rolledToy);
        pickUpToyFromList(rolledToy,toysList);
        FileSave.createFile(wonToys); //сохраняем в файл выигранные игрушки
        System.out.println(toysList); // смотрим что осталось
    }


    /**
     *  Принимает имя игрушки и список, так как ролить(разыгрывать) я решил возвращать имя игрушки
     * @param toyName Имя игрушки которую надо удалить
     * @param toysList Список игрушек
     * @return Модифицированный список
     */
    public static ArrayList<Toy> pickUpToyFromList(String toyName, ArrayList<Toy> toysList) {
        boolean flagToDeleteToy = false;
        String toyToDelete = "";
        int countToyToDelete = 0;
        for (int i = 0; i < toysList.size(); i++) {
            if (toysList.get(i).getName().equals(toyName)) {
                int howMuchToys = toysList.get(i).getCount();
                if (howMuchToys != 1) {
                    howMuchToys -= 1;
                    toysList.get(i).setCount(howMuchToys);
                } else {
                    flagToDeleteToy = true;
                    toyToDelete = toysList.get(i).getName();
                    countToyToDelete = i;
                }
            }
        }
        if (flagToDeleteToy) {
            System.out.println("Игрушка " + toyToDelete + " закончились");
            toysList.remove(countToyToDelete);
        }
        return toysList;
    }

    public void changePersentage (Toy toy){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новый вес");
        try{
            int percent = scanner.nextInt();
            toy.setPercentage(percent);
        }catch (Exception e){
            System.out.println("Вы ввели не число");
        }
    }
}