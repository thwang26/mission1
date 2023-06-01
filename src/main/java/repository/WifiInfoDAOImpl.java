package repository;

import domain.NearWifiDTO;
import domain.WifiInfoDTO;
import domain.WifiRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class WifiInfoDAOImpl implements WifiInfoDAO {
    private SqlSessionFactory sqlSessionFactory;
    private static final WifiInfoDAOImpl wifiInfoDAOImpl = new WifiInfoDAOImpl();

    public static WifiInfoDAOImpl getInstance() {
        return wifiInfoDAOImpl;
    }

    public WifiInfoDAOImpl() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // 싱글톤으로 db생성

    @Override
    public int insertWifiInfo(List<WifiInfoDTO> wifiInfoDTOList) {
        delete();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int cnt = 0;
        int divisionNum = 1000;
        int listSize = wifiInfoDTOList.size();
        int div = (int) Math.ceil((double) listSize / divisionNum);

        for (int i = 0; i < div; i++) {
            int fromIndex = i * divisionNum;
            int toIndex = Math.min(fromIndex + divisionNum, listSize);
            cnt += sqlSession.insert("wifiInfoSQL.insertWifiInfo", wifiInfoDTOList.subList(fromIndex, toIndex));
        }

        sqlSession.commit();
        sqlSession.close();

        return cnt;
    }

    @Override
    public void delete() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("wifiInfoSQL.delete");
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<NearWifiDTO> selectNearWifi(WifiRequest wifiRequest) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<NearWifiDTO> list = sqlSession.selectList("wifiInfoSQL.selectNearWifi", wifiRequest);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}