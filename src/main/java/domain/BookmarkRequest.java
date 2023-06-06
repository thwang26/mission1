package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkRequest {
    private String bookmarkName;
    private int orderNum;
}
