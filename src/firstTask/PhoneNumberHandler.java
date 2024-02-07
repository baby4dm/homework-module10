package firstTask;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberHandler {
    private static String readNumber(){
        StringBuilder numbers = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("files/numbers.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
              numbers.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return numbers.toString();
    }


    public static String getValidNumber(){
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(readNumber());

        while (matcher.find()){
            result.append(matcher.group());
            result.append("\n");
        }
        return result.toString();
    }

}
