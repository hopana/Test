package collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String args[]) {
        Comparator<Man> OrderIsdn = new Comparator<Man>() {
            public int compare(Man o1, Man o2) {
                int numbera = o1.getPopulation();
                int numberb = o2.getPopulation();
                if (numberb > numbera) {
                    return 1;
                } else if (numberb < numbera) {
                    return -1;
                } else {
                    return 0;
                }

            }

        };
        Queue<Man> priorityQueue = new PriorityQueue<Man>(11, OrderIsdn);

        Man t1 = new Man("t1", 1);
        Man t3 = new Man("t3", 3);
        Man t2 = new Man("t2", 2);
        Man t4 = new Man("t4", 0);
        priorityQueue.add(t1);
        priorityQueue.add(t3);
        priorityQueue.add(t2);
        priorityQueue.add(t4);

        System.out.println(priorityQueue.poll().toString());
        System.out.println(priorityQueue.poll().toString());
    }
}

class Man {

    private String name;
    private int population;

    public Man(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public String toString() {
        return getName() + " - " + getPopulation();
    }
}
