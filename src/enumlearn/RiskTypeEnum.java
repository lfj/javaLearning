package enumlearn;

public enum RiskTypeEnum {

    China("China", "the most powerful country in the world"),

    Japan("Japan", "famous for its unqiue cultural"),

    USA("USA", "the most developed country in the world");

    private final String country;

    private final String description;

    RiskTypeEnum(String country, String description) {
        this.country = country;
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }
}
