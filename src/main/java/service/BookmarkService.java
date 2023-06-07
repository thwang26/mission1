package service;

import domain.BookmarkRequest;
import repository.BookmarkDAO;
import repository.BookmarkDAOImpl;

public class BookmarkService {
    BookmarkDAO bookmarkDAO = BookmarkDAOImpl.getInstance();

    public void saveBookmark(BookmarkRequest bookmarkRequest) {
        bookmarkDAO.saveBookmark(bookmarkRequest);
    }
}
