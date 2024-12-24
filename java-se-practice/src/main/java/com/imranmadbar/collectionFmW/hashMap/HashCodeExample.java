package com.imranmadbar.collectionFmW.hashMap;

import java.util.HashMap;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
//
//    @Override
//    public int hashCode() {
//        return name.hashCode() + age;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Person person = (Person) obj;
//        return age == person.age && name.equals(person.name);
//    }
}

public class HashCodeExample {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();

        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);

        map.put(p1, "Engineer");

        // Now p2 has the same hashCode and is equal to p1
        String result = map.get(p2);

        System.out.println("Result: " + result); // Will print: Engineer
    }
}

