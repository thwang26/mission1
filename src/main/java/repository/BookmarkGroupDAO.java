package repository;

import domain.BookmarkGroupDTO;
import domain.BookmarkGroupRequest;

import java.util.List;

public interface BookmarkGroupDAO {
    int saveBookmarkGroup(BookmarkGroupRequest bookmarkGroupRequest);

    List<BookmarkGroupDTO> loadBookmarkGroupList();

    void deleteBookmarkGroup(int id);

    BookmarkGroupDTO loadBookmarkGroup(int id);

    int updateBookmarkGroup(BookmarkGroupRequest bookmarkGroupRequest);
}
