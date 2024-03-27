package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

/**
 * packageName    : facade.pagemaker
 * fileName       : HtmlWriter
 * author         : ipeac
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        ipeac       최초 생성
 */
class HtmlWriter {
    private Writer writer;
    
    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }
    
    //타이틀 출력
    public void title(String title) throws IOException {
        //제목 출력
        writer.write("<!DOCTYPE html>\n");
        writer.write("<html>\n");
        writer.write("<head>\n");
        writer.write("<title>" + title + "</title>\n");
        writer.write("</head>\n");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }
    
    //단락 출력
    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }
    
    //링크 출력
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }
    
    //메일 주소 출력
    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto:" + mailaddr, username);
    }
    
    //클로즈
    public void close() throws IOException {
        writer.write("</body>\n");
        writer.write("</html>\n");
        writer.close();
    }
}