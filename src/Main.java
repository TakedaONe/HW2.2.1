public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        try {
            while (true) {
                account.withDraw(6000);
                System.out.println("Успешно снято 6000 сом. Остаток: " + account.getAmount());
            }
        } catch (LimitException e) {
            try {
                account.withDraw((int) e.getRemainingAmount());
                System.out.println("Снято остаток: " + e.getRemainingAmount() + ". Остаток: " + account.getAmount());
            } catch (LimitException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Конечный остаток на счете: " + account.getAmount());
    }
}
