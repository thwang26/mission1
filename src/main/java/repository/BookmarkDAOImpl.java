package repository;

import domain.BookmarkRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

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
    public int saveBookmarkGroup(BookmarkRequest bookmarkRequest) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int num = sqlSession.insert("bookmarkSQL.saveBookmarkGroup", bookmarkRequest);
        sqlSession.commit();
        sqlSession.close();

        return num;
    }
}
