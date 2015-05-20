/**
 * Created by Артем on 20.05.2015.
 */
package Lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab3 {

    static List<String> lines;

    public static void main(String[] args) {

        File testFile = new File("test.txt");
        lines = new ArrayList<String>();
        GetContents(testFile);
        write("out.txt", lines);

    }


    static public void GetContents(File file)
    {

        try
        {
            if (file == null)
            {
                throw new IllegalArgumentException("File should not be null.");
            }

            if (!file.exists())
            {
                throw new FileNotFoundException();
            }

            if (!file.canRead())

            {
                throw new IllegalArgumentException("File cannot be written:" + file);
            }

                if (!file.isFile())
                {
                throw new IllegalArgumentException("Should not be a directory: " + file);
            }

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fis);
            BufferedReader input = new BufferedReader(in);

            String line = null;
            try{
                while ((line = input.readLine()) != null)
                {
                    String[] test =  line.trim().split("[,;:!?\\s]+");
                    for(int i =0; i < test.length; i++)
                    {

                    }

                }
            }
            finally{
                input.close();
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File does not exist: " + file);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
    public static void write(String fileName, List<String> list) {
        File file = new File(fileName);
        String [] linesAsArray = list.toArray(new String[list.size()]);
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                for(int i = 0; i < list.size(); i++)
                {
                    out.print(linesAsArray[i] + "\n");
                }
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}