package printoddeven2threads;

import lombok.SneakyThrows;

class PrintOddEven {

    int counter = 1;

    boolean printZero = true;

    void printOddNumber(int n){
        synchronized (this) {
            while(counter < n){
                while (counter % 2 == 0 || printZero) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread odd" + counter);

                printZero = !printZero;
                counter++;

                notifyAll();
            }
        }
    }

    void printEvenNumber(int n){
        synchronized (this){
            while(counter < n){
                while(counter % 2 == 1 || printZero){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread even" + counter);

                printZero = !printZero;
                counter++;

                notifyAll();
            }
        }
    }

    void printZero(int n){
        synchronized (this){
            while(counter < n){
                while(!printZero){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Zero thread " + "0");
                printZero = !printZero;

                notifyAll();
            }
        }
    }

    public static void main(String[] args){

        PrintOddEven obj = new PrintOddEven();
        int n = 10;
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                obj.printOddNumber(n);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                obj.printEvenNumber(n);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                obj.printZero(n);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
