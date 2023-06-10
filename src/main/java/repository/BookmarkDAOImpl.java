package repository;

import domain.BookmarkDTO;
import domain.BookmarkRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BookmarkDAOImpl implements BookmarkDAO{
    private SqlSessionFactory sqlSessionFactory;
    private static final BookmarkDAOImpl bookmarkDAOImpl = new BookmarkDAOImpl();

    public static BookmarkDAOImpl getInstance() {
        return bookmarkDAOImpl;
    }

    public BookmarkDAOImpl() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // 싱글톤으로 db생성

    @Override
    public void saveBookmark(BookmarkRequest bookmarkRequest) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("bookmarkSQL.saveBookmark", bookmarkRequest);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<BookmarkDTO> loadBookmarkList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<BookmarkDTO> list = sqlSession.selectList("bookmarkSQL.loadBookmarkList");
        sqlSession.commit();
        sqlSession.close();

        return list;
    }

    @Override
    public BookmarkDTO loadBookmark(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookmarkDTO bookmarkDTO = sqlSession.selectOne("bookmarkSQL.loadBookmark", id);
        sqlSession.commit();
        sqlSession.close();

        return bookmarkDTO;
    }

    @Override
    public void deleteBookmark(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("bookmarkSQL.deleteBookmark", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteDeletedBookmarkGroup(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("bookmarkSQL.deleteDeletedBookmarkGroup", id);
        sqlSession.commit();
        sqlSession.close();
    }
}