import domain.BookmarkGroupDTO;
import domain.BookmarkGroupRequest;
import domain.BookmarkRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.BookmarkService;

public class BookmarkServiceTest {
    @DisplayName("북마크 추가 테스트")
    @Test
    public void saveBookmark() {
        // given
        BookmarkService bookmarkService = new BookmarkService();
        BookmarkRequest bookmarkRequest = new BookmarkRequest();
        bookmarkRequest.setId(1);
        bookmarkRequest.setMgrNo("test");

        // when
        bookmarkService.saveBookmark(bookmarkRequest);

        // then
    }
}
