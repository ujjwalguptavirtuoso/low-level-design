package splitwise;

public class Transaction {
      int payer;
      int payee;
      int amount;

    public Transaction(int payer, int payee, int amount) {
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
    }

    // for simplicity avoiding getter setter
    // we can add later
}
