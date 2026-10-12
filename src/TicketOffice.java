public class TicketOffice {

    private static int totalOrdersCount = 0;
    private static double totalRevenue = 0;

    // Регистрация оплаченного заказа
    public static void recordPayment(double amount) {

        if (amount > 0) {
            totalOrdersCount++;
            totalRevenue += amount;
        }
    }

    public static int getTotalOrdersCount() {
        return totalOrdersCount;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void printGlobalStats() {

        //System.out.println();
        System.out.println("==========================================");
        System.out.println("      СТАТИСТИКА КАССЫ");
        System.out.println("==========================================");
        System.out.println("Количество заказов: " + totalOrdersCount);
        System.out.println(
                "Общая выручка: " + totalRevenue + " руб."
        );
        System.out.println("==========================================");
    }

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       KANYE WEST - SAINT PETERSBURG");
        System.out.println("==========================================");
        System.out.println("Учебная система продажи билетов");
        System.out.println("Концерт: Санкт-Петербург");
        System.out.println();

        System.out.println("Категории билетов:");
        System.out.println("Танцпол       - базовая цена");
        System.out.println("Фан-зона      - +60%");
        System.out.println("VIP-ложа      - +250%");
        //System.out.println();

        // Дополнительная опция
        FanZonePass fanZonePass =
                new FanZonePass("Fan Zone Pass", 800);

        System.out.println(
                "Дополнительная опция: "
                        + fanZonePass.getName()
                        + " - "
                        + fanZonePass.getPrice()
                        + " руб."
        );

        //System.out.println();

        //создание билетов

        //осн (другой) конструктор
        ConcertTicket ticket1 =
                new ConcertTicket(
                        "Kanye West Concert",
                        3000,
                        "Танцпол"
                );

        //доп конструктор
        ConcertTicket ticket2 =
                new ConcertTicket(
                        "Kanye West Concert",
                        3000
                );

        //осн конструктор
        ConcertTicket ticket3 =
                new ConcertTicket(
                        "Kanye West Concert",
                        3000,
                        "VIP-ложа"
                );

        // 1. first option calculateFinalPrice()

        double price1 = ticket1.calculateFinalPrice();

        System.out.println("------------------------------------------");
        System.out.println("Билет №1");
        System.out.println("Категория: " + ticket1.getCategory());
        System.out.println("Стоимость: " + price1 + " руб.");

        TicketOffice.recordPayment(price1);

        // 2. second option calculateFinalPrice(option)

        double price2 =
                ticket2.calculateFinalPrice(fanZonePass);

        System.out.println("------------------------------------------");
        System.out.println("Билет №2");
        System.out.println("Категория: " + ticket2.getCategory());
        System.out.println("Fan Zone Pass применён");
        System.out.println("Стоимость: " + price2 + " руб.");

        TicketOffice.recordPayment(price2);

        // 3. upgradePass(pass)

        double price3 =
                ticket3.upgradePass(fanZonePass);

        System.out.println("------------------------------------------");
        System.out.println("Билет №3");
        System.out.println("Категория: " + ticket3.getCategory());
        System.out.println("Fan Zone Pass применён");
        System.out.println("Стоимость: " + price3 + " руб.");

        TicketOffice.recordPayment(price3);

        // 4. upgradePass(pass, true)

        double fastTrackPrice =
                ticket1.upgradePass(fanZonePass, true);

        System.out.println("------------------------------------------");
        System.out.println("Дополнительное улучшение билета №1");
        System.out.println("Fast Track: включён");
        System.out.println(
                "Стоимость с Fast Track: "
                        + fastTrackPrice
                        + " руб."
        );

        System.out.println();

        // Итоговая статистика
        printGlobalStats();

        System.out.println();
        System.out.println("Спасибо за использование системы!");
    }
}