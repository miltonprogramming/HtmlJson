import java.net.*;
import java.io.*;
/*
    This is an example of reading a url from the web
 */
public class HtmlRead {
    public String test="test";
    public static void main(String[] args) {
        HtmlRead htmlRead= new HtmlRead();
        
    }

    public HtmlRead(){



        try{
            System.out.println();
            URL url = new URL("https://espn.com/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.contains("href")) {
                    System.out.println(line);
                }

          //      if(line.contains("href")) {
           //         System.out.println(line);
           //     }
            }
            reader.close();
        } catch (MalformedURLException ex){
            System.out.println("run with a diffrent url");
        } catch(Exception ex){
            System.out.println(ex);
        }
    }



}
