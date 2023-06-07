package repository;

import domain.BookmarkRequest;

public interface BookmarkDAO {
    void saveBookmark(BookmarkRequest bookmarkRequest);
}