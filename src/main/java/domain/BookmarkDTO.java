package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkDTO {
    private int id;
    private String bookmarkName;
    private int orderNum;
    private String registerDate;
    private String updateDate;
}
