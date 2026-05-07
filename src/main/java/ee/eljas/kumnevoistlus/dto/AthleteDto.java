package ee.eljas.kumnevoistlus.dto;

public class AthleteDto {
    private Long id;
    private String name;
    private String country;
    private Long totalPoints;

    public AthleteDto(Long id, String name, String country, Long totalPoints) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.totalPoints = totalPoints;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public Long getTotalPoints() { return totalPoints; }
}