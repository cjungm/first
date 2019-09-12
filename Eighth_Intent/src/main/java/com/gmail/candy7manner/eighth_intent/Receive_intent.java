package com.gmail.candy7manner.eighth_intent;

import java.io.Serializable;

// Intent 에 객체를 담아 보낼때는 Serializable 을 implement 한다
public class Receive_intent implements Serializable {
    String name;
    int age;

    public Receive_intent(){}
    public Receive_intent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}