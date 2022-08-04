package print_odd_even_numbers;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.TreeMap;

public class Printer implements Runnable{

    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Map.Entry<Integer, Integer> floor = map.floorEntry(currentValue);

    public Printer(int step, State state, int currentValue, PrinterType currentPrinterType, PrinterType nextPrinterType, int maxValue) {
        this.step = step;
        this.state = state;
        this.currentValue = currentValue;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.maxValue = maxValue;
    }

    @SneakyThrows
    @Override
    public void run() {
           while(currentValue <= maxValue){
               synchronized (state){
                   while(this.currentPrinterType != state.getNextToPrint()){
                       try {
                           state.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   System.out.println(currentPrinterType.toString() + ": " + currentValue);
                   currentValue += step;
                   state.setNextToPrint(this.nextPrinterType);
                   state.notifyAll();
               }
           }
    }
}
