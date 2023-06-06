import domain.BookmarkRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.BookmarkService;

public class BookmarkServiceTest {
    BookmarkRequest bookmarkRequest = new BookmarkRequest();
    BookmarkService bookmarkService = new BookmarkService();

    @DisplayName("북마크 그룹 추가 테스트")
    @Test
    public void saveHistory() {
        // given
        String bookmarkName = "북마크 테스트";
        int orderNum = 1;
        bookmarkRequest.setBookmarkName(bookmarkName);
        bookmarkRequest.setOrderNum(orderNum);

        // when
        int num = bookmarkService.saveBookmarkGroup(bookmarkRequest);

        // then
        Assertions.assertEquals(1, num);
    }
}
