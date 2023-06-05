package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationHistoryDTO {
    private int id;
    private double lnt;
    private double lat;
    private String search_date;
}
