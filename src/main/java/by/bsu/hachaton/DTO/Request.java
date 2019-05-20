package by.bsu.hachaton.DTO;

public class Request {

    private String id;

    private String photo;

    private Double longitude;

    private Double latitude;

    private String description;

    private Double rank;

    public Request(String photo, Double longitude, Double latitude, String description, Double rank) {
        this.photo = photo;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.rank = rank;
    }

    public Request(String id, String photo, Double longitude, Double latitude, String description, Double rank) {
        this.id = id;
        this.photo = photo;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}
