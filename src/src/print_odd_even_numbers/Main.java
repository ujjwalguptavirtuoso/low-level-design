package print_odd_even_numbers;

public class Main {

    public static void main(String[] args) {

        final State state = new State(PrinterType.ODD);
        final Printer oddPrinter = new Printer(2, state, 1, PrinterType.ODD, PrinterType.EVEN, 50);
        final Printer evenPrinter = new Printer(2, state, 2, PrinterType.EVEN, PrinterType.ODD, 50);

        final Thread oddThread = new Thread(oddPrinter);
        final Thread evenThread = new Thread(evenPrinter);

        oddThread.start();
        evenThread.start();
    }


}
