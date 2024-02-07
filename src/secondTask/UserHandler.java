package secondTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserHandler {

        private static List<User> readUser() {
            List<User> users = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("files/users.txt")))
            {
                String line;
                while((line = bufferedReader.readLine()) != null){
                    String[] user = line.split("\\s+");
                    users.add(new User(user[0], Integer.valueOf(user[1])));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return users;
        }



    public static void convertToJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("files/user.json");
            fileOutputStream.write(gson.toJson(readUser()).getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
