package service;

import domain.BookmarkDTO;
import domain.BookmarkRequest;
import repository.BookmarkDAO;
import repository.BookmarkDAOImpl;

import java.util.List;

public class BookmarkService {
    BookmarkDAO bookmarkDAO = BookmarkDAOImpl.getInstance();

    public void saveBookmark(BookmarkRequest bookmarkRequest) {
        bookmarkDAO.saveBookmark(bookmarkRequest);
    }
    public List<BookmarkDTO> loadBookmarkList() {
        return bookmarkDAO.loadBookmarkList();
    }

    public BookmarkDTO loadBookmark(int id) {
        return bookmarkDAO.loadBookmark(id);
    }

    public void deleteBookmark(int id) {
        bookmarkDAO.deleteBookmark(id);
    }

    public void deleteDeletedBookmarkGroup(int id) {
        bookmarkDAO.deleteDeletedBookmarkGroup(id);
    }
}
