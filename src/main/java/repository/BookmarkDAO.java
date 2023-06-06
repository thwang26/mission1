package repository;

import domain.BookmarkRequest;

public interface BookmarkDAO {
    int saveBookmarkGroup(BookmarkRequest bookmarkRequest);
}
