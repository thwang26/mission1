package repository;

import domain.BookmarkGroupDTO;
import domain.BookmarkGroupRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BookmarkGroupDAOImpl implements BookmarkGroupDAO {
    private SqlSessionFactory sqlSessionFactory;
    private static final BookmarkGroupDAOImpl bookmarkGroupDAOImpl = new BookmarkGroupDAOImpl();

    public static BookmarkGroupDAOImpl getInstance() {
        return bookmarkGroupDAOImpl;
    }

    public BookmarkGroupDAOImpl() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // 싱글톤으로 db생성

    @Override
    public int saveBookmarkGroup(BookmarkGroupRequest bookmarkGroupRequest) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int num = sqlSession.insert("bookmarkGroupSQL.saveBookmarkGroup", bookmarkGroupRequest);
        sqlSession.commit();
        sqlSession.close();

        return num;
    }

    @Override
    public List<BookmarkGroupDTO> loadBookmarkGroupList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<BookmarkGroupDTO> list = sqlSession.selectList("bookmarkGroupSQL.loadBookmarkGroupList");
        sqlSession.commit();
        sqlSession.close();

        return list;
    }

    @Override
    public void deleteBookmarkGroup(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("bookmarkGroupSQL.deleteBookmarkGroup", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public BookmarkGroupDTO loadBookmarkGroup(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookmarkGroupDTO bookmarkGroupDTO = sqlSession.selectOne("bookmarkGroupSQL.loadBookmarkGroup", id);
        sqlSession.commit();
        sqlSession.close();

        return bookmarkGroupDTO;
    }

    @Override
    public int updateBookmarkGroup(BookmarkGroupRequest bookmarkGroupRequest) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int num = sqlSession
                .update("bookmarkGroupSQL.updateBookmarkGroup", bookmarkGroupRequest);
        sqlSession.commit();
        sqlSession.close();

        return num;
    }
}
