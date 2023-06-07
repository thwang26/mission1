import domain.BookmarkGroupDTO;
import domain.BookmarkGroupRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.BookmarkGroupService;

import java.util.List;

public class BookmarkGroupServiceTest {
    BookmarkGroupRequest bookmarkRequest = new BookmarkGroupRequest();
    BookmarkGroupService bookmarkService = new BookmarkGroupService();

    @DisplayName("북마크 그룹 추가 테스트")
    @Test
    public void saveBookmarkGroup() {
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

    @DisplayName("북마크 그룹리스트 가져오기 테스트")
    @Test
    public void loadBookmarkGroupList() {
        // given

        // when
        List<BookmarkGroupDTO> list = bookmarkService.loadBookmarkGroupList();

        // then
        Assertions.assertNotNull(list);
    }

    @DisplayName("북마크 그룹 가져오기 테스트")
    @Test
    public void loadBookmarkGroup() {
        // given
        int id = 10;

        // when
        BookmarkGroupDTO bookmarkGroupDTO = bookmarkService.loadBookmarkGroup(id);

        // then
        Assertions.assertEquals(10, bookmarkGroupDTO.getId());
    }

    @DisplayName("북마크 그룹 삭제 테스트")
    @Test
    public void deleteBookmarkGroup() {
        // given
        int id = 8;

        // when
        bookmarkService.deleteBookmarkGroup(id);

        // then
    }

    @DisplayName("북마크 그룹 수정 테스트")
    @Test
    public void updateBookmarkGroup() {
        // given
        int id = 1;
        String bookmarkName = "수정테스트";
        int orderNum = 5;
        BookmarkGroupRequest bookmarkGroupRequest = new BookmarkGroupRequest();
        bookmarkGroupRequest.setId(id);
        bookmarkGroupRequest.setBookmarkName(bookmarkName);
        bookmarkGroupRequest.setOrderNum(orderNum);

        // when
        int num = bookmarkService.updateBookmarkGroup(bookmarkGroupRequest);

        // then
        Assertions.assertEquals(1, num);
    }
}
