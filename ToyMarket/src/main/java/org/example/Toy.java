package org.example;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int percentage;

    public Toy(int id, String name, int count, int percentage) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + count + " " + percentage;
    }
}
