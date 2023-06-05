package repository;

import domain.NearWifiDTO;
import domain.WifiInfoDTO;
import domain.WifiRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
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
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        // 배치 모드로 SqlSession 생성
        int cnt = 0;
        int divisionNum = 1000;
        int listSize = wifiInfoDTOList.size();
        int div = (int) Math.ceil((double) listSize / divisionNum);

        try {
            for (int i = 0; i < div; i++) {
                int fromIndex = i * divisionNum;
                int toIndex = Math.min(fromIndex + divisionNum, listSize);
                List<WifiInfoDTO> subList = wifiInfoDTOList.subList(fromIndex, toIndex);
                sqlSession.insert("wifiInfoSQL.insertWifiInfo", subList);
                cnt += subList.size();
            }

            sqlSession.flushStatements(); // 배치 실행
            sqlSession.commit();
        } finally {
            sqlSession.clearCache(); // 캐시 클리어
            sqlSession.close(); // SqlSession 닫기
        }

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
    public List<NearWifiDTO> loadNearWifi(WifiRequest wifiRequest) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<NearWifiDTO> list = sqlSession.selectList("wifiInfoSQL.loadNearWifi", wifiRequest);
        sqlSession.commit();
        sqlSession.close();

        return list;
    }

    @Override
    public WifiInfoDTO loadDetail(String mgrNo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        WifiInfoDTO wifiInfoDTO = sqlSession.selectOne("wifiInfoSQL.loadDetail", mgrNo);
        sqlSession.commit();
        sqlSession.close();

        return wifiInfoDTO;
    }
}