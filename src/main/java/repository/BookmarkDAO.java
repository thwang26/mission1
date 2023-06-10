package repository;

import domain.BookmarkDTO;
import domain.BookmarkRequest;

import java.util.List;

public interface BookmarkDAO {
    void saveBookmark(BookmarkRequest bookmarkRequest);

    List<BookmarkDTO> loadBookmarkList();

    BookmarkDTO loadBookmark(int id);

    void deleteBookmark(int id);

    void deleteDeletedBookmarkGroup(int id);
}