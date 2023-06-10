import domain.BookmarkGroupDTO;
import domain.BookmarkGroupRequest;
import domain.BookmarkRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.BookmarkService;

import java.awt.print.Book;

public class BookmarkServiceTest {
    BookmarkService bookmarkService = new BookmarkService();

    @DisplayName("북마크 추가 테스트")
    @Test
    public void saveBookmark() {
        // given
        BookmarkRequest bookmarkRequest = new BookmarkRequest();
        bookmarkRequest.setId(1);
        bookmarkRequest.setMgrNo("test");

        // when
        bookmarkService.saveBookmark(bookmarkRequest);

        // then
    }

    @DisplayName("북마크 가져오기 테스트")
    @Test
    public void loadBookmark() {
        // given
        int id = 1;

        // when
        bookmarkService.loadBookmark(id);
    }
}
