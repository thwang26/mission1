package service;

import domain.BookmarkRequest;
import repository.BookmarkDAO;
import repository.BookmarkDAOImpl;

public class BookmarkService {
    BookmarkDAO bookmarkDAO = BookmarkDAOImpl.getInstance();
    public int saveBookmarkGroup(BookmarkRequest bookmarkRequest) {
        return bookmarkDAO.saveBookmarkGroup(bookmarkRequest);
    }
}
