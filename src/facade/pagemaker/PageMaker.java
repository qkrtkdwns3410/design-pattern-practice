package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * packageName    : facade.pagemaker
 * fileName       : PageMaker
 * author         : ipeac
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        ipeac       최초 생성
 */
public class PageMaker {
    private PageMaker() {
    }
    
    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph(username + "의 페이지에 오신 걸 환영합니다.");
            writer.paragraph("메일을 기다리고 있습니다.");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void makeLinkPage(String fileName) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            ArrayList<Object> objects = new ArrayList<>();
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Link page");
            
            for (Map.Entry<Object, Object> objectObjectEntry : mailprop.entrySet()) {
                writer.mailto((String) objectObjectEntry.getKey(), (String) objectObjectEntry.getValue());
            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}