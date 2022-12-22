package org.example.exceptions;

import com.mailjet.client.resource.User;

import java.util.ArrayList;


public class RuntimeExceptions {

    public void throwsNullPointerException(){ //неверное использование пустой ссылки
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException(){ //выход индекса за границу массива
        int [] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[6] = 5;
        }
    }

    public void throwsNumberFormatException(){ //неверное преобразование строки в числовой формат
        int number = 234;
        String str = "run";
        number = Integer.parseInt(str);
    }

    public void throwsIllegalArgumentException(){ //неверный аргумент при вызове метода
        ArrayList<String> list = new ArrayList<>(-10);
        list.add("a");
        list.add("b");
        list.add("c");
    }

    public void throwsClassCastException() { //неверное приведение
        Object value = Integer.valueOf(5);
        String str = (String) value;
    }

}
