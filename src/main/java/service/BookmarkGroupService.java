package service;

import domain.BookmarkGroupDTO;
import domain.BookmarkGroupRequest;
import repository.BookmarkGroupDAO;
import repository.BookmarkGroupDAOImpl;

import java.util.List;

public class BookmarkGroupService {
    BookmarkGroupDAO bookmarkGroupDAO = BookmarkGroupDAOImpl.getInstance();
    public int saveBookmarkGroup(BookmarkGroupRequest bookmarkGroupRequest) {
        return bookmarkGroupDAO.saveBookmarkGroup(bookmarkGroupRequest);
    }

    public List<BookmarkGroupDTO> loadBookmarkGroupList() {
        return bookmarkGroupDAO.loadBookmarkGroupList();
    }

    public BookmarkGroupDTO loadBookmarkGroup(int id) {
        return bookmarkGroupDAO.loadBookmarkGroup(id);
    }

    public void deleteBookmarkGroup(int id) {
        bookmarkGroupDAO.deleteBookmarkGroup(id);
    }

    public int updateBookmarkGroup(BookmarkGroupRequest bookmarkGroupRequest) {
        return bookmarkGroupDAO.updateBookmarkGroup(bookmarkGroupRequest);
    }
}
