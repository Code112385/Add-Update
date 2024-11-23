/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acct;

/**
 *
 * @author senju
 */
import java.io.*;

public class FileManager {

    private String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    public void writeToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(user.getpic() + "," + user.getId() + "," + user.getFname() + "," + user.getLname() + ","
                    + user.getUsername() + "," + user.getgender() + "," + user.getRole() + "," + user.getEmail() + "\n"
            );
            System.out.println("sys");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public boolean checkCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[2].equals(username) && parts[5].equals(password)) {
                   
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        System.out.println("false");
        return false;

    }

    public boolean updateUserData(String userId, User updatedUser) {
        File tempFile = new File("C:\\Users\\senju\\Documents\\Java\\userrr");
        boolean userFound = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
               
                if (parts[1].equals(userId)) {
                    writer.write(updatedUser.getpic() + "," + updatedUser.getId() + "," + updatedUser.getFname() + "," + updatedUser.getLname() + "," + updatedUser.getUsername() 
                            + "," + updatedUser.getgender() + "," + updatedUser.getRole() + "," + updatedUser.getEmail() + "\n");
                    System.out.println("true");
                    userFound = true;
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
            return false;
        }
        if (userFound) {
            tempFile.renameTo(new File(filename));
        } else {
            tempFile.delete();
        }
        return userFound;
    }
}
