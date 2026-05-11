public class CoinChangePakistan {

    public static void main(String[] args) {

        int amount = 1988;

        int[] coins = {5000, 1000, 500, 100, 50, 20, 10, 5, 1};

        System.out.println("Amount: " + amount);
        System.out.println("Denominations required:");

        for (int coin : coins) {

            int count = amount / coin;

            if (count != 0) {
                System.out.println(coin + " x " + count);
            }

            amount = amount % coin;
        }
    }
}