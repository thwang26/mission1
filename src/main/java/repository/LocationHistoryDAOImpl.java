package repository;

import domain.WifiRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class LocationHistoryDAOImpl implements LocationHistoryDAO {
    private SqlSessionFactory sqlSessionFactory;
    private static final LocationHistoryDAOImpl locationHistoryDAOImpl = new LocationHistoryDAOImpl();

    public static LocationHistoryDAOImpl getInstance() {
        return locationHistoryDAOImpl;
    }

    public LocationHistoryDAOImpl() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // 싱글톤으로 db생성

    @Override
    public void saveHistory(WifiRequest wifiRequest) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("locationHistorySQL.saveHistory", wifiRequest);
        sqlSession.commit();
        sqlSession.close();
    }

    public int saveHistoryTest(WifiRequest wifiRequest) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int cnt = sqlSession.insert("locationHistorySQL.saveHistory", wifiRequest);
        sqlSession.commit();
        sqlSession.close();
        return cnt;
    }
}
