package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkGroupRequest {
    private int id;
    private String bookmarkName;
    private int orderNum;
}
