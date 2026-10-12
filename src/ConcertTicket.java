public class ConcertTicket {

    private final String name;
    private double basePrice;
    private String category;
    private FanZonePass appliedOption = null;

    //осн конструктор
    public ConcertTicket(String name, double basePrice, String category) {
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
    }

    //доп
    //по умолчанию танцпол
    public ConcertTicket(String name, double basePrice) {
        this(name, basePrice, "Танцпол");
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }

        this.basePrice = basePrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public FanZonePass getAppliedOption() {
        return appliedOption;
    }
    //стоимость
    //обычная
    public double calculateFinalPrice() {

        double coefficient = switch (category) {
            case "Танцпол" -> 1.0;
            case "Фан-зона" -> 1.6;
            case "VIP-ложа" -> 3.5;
            default -> throw new IllegalArgumentException(
                    "Неизвестная категория билета"
            );
        };

        return basePrice * coefficient;
    }

    //доп опция
    public double calculateFinalPrice(FanZonePass option) {

        appliedOption = option;

        return calculateFinalPrice() + option.getPrice();
    }

    //улучшения
    public double upgradePass(FanZonePass pass) {

        appliedOption = pass;

        return calculateFinalPrice() + pass.getPrice();
    }

    //улучшение + пропуск
    public double upgradePass(FanZonePass pass, boolean fastTrack) {

        appliedOption = pass;

        double price = calculateFinalPrice() + pass.getPrice();

        if (fastTrack) {
            price += 500;
        }

        return price;
    }
}
