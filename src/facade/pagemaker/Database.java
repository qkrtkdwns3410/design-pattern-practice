package facade.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * packageName    : facade.pagemaker
 * fileName       : Database
 * author         : ipeac
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        ipeac       최초 생성
 */
public class Database {
    //생성자를 private 으로 선언하여 인스턴스 생성을 방지한다.
    private Database() {
    }
    
    //DB 이름에서 Properties 를 얻는다.
    public static Properties getProperties(String dbName) throws IOException {
        String fileName = dbName + ".txt";
        Properties prop = new Properties();
        prop.load(new FileReader(fileName));
        return prop;
    }
}