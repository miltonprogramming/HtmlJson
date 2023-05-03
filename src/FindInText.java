import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    This is an example of using a file chooser to find a file on hardrive
 */

public class FindInText extends JFrame{

    File selectedFile=null;
    String data;

    public static void main(String[] args) {
        FindInText findInText= new FindInText();
    }



    public FindInText(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
             selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
        read();
    }
    public void read(){
        System.out.println("reading.....");
        try {

            Scanner myReader = new Scanner(selectedFile);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if(data.contains(" int ")){
                    System.out.println("BOOOOOOOOOOOOOOOOMMMMMM");
                    System.out.println(data);
                }
              //  System.out.println(data);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
