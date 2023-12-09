package org.example;

import com.google.gson.Gson;
import org.example.dto.User;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Task1_1 {

    public static void main(String[] args) {
        try {
            User newUser = new User();
            newUser.setId(11);
            newUser.setName("John Doe");
            newUser.setUsername("john.doe");
            newUser.setEmail("john@example.com");

            User.Address userAddress = new User.Address();
            userAddress.setStreet("123 Main St");
            userAddress.setSuite("Apt 456");
            userAddress.setCity("Cityville");
            userAddress.setZipcode("12345");

            User.Address.Geo geo = new User.Address.Geo();
            geo.setLat(12.345);
            geo.setLng(67.890);

            userAddress.setGeo(geo);

            newUser.setAddress(userAddress);

            newUser.setPhone("123-456-7890");
            newUser.setWebsite("example.com");

            User.Company userCompany = new User.Company();
            userCompany.setName("ABC Ltd.");
            userCompany.setCatchPhrase("Catchy phrase");
            userCompany.setBs("Business Stuff");

            newUser.setCompany(userCompany);


            User updateUser = new User();
            updateUser.setId(1);
            updateUser.setName("John Doe");
            updateUser.setUsername("john.doe");
            updateUser.setEmail("john@example.com");

            User.Address userUpdateAddress = new User.Address();
            userUpdateAddress.setStreet("123 Main St");
            userUpdateAddress.setSuite("Apt 456");
            userUpdateAddress.setCity("Cityville");
            userUpdateAddress.setZipcode("12345");

            User.Address.Geo updateGeo = new User.Address.Geo();
            updateGeo.setLat(12.345);
            updateGeo.setLng(67.890);

            userUpdateAddress.setGeo(updateGeo);

            updateUser.setAddress(userUpdateAddress);

            updateUser.setPhone("123-456-7890");
            updateUser.setWebsite("example.com");

            User.Company userUpdateCompany = new User.Company();
            userUpdateCompany.setName("ABC Ltd.");
            userUpdateCompany.setCatchPhrase("Catchy phrase");
            userUpdateCompany.setBs("Business Stuff");

            updateUser.setCompany(userUpdateCompany);


            create(newUser);
            update(updateUser);
            delete(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void create(User user) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = new Gson().toJson(user).getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (Scanner scanner = new Scanner(connection.getInputStream())) {
                String responseBody = scanner.useDelimiter("\\A").next();
                System.out.println("responseBody = " + responseBody);
            }
        } finally {
            connection.disconnect();
        }
    }

    public static void update(User user) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/users/" + user.getId());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = new Gson().toJson(user).getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try (Scanner scanner = new Scanner(connection.getInputStream())) {
                String responseBody = scanner.useDelimiter("\\A").next();
                System.out.println("Response from server:\n" + responseBody);
            }
        } finally {
            connection.disconnect();
        }

    }

    public static void delete(int userId) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/users/" + userId);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json");

            System.out.println("connection.getResponseCode() = " + connection.getResponseCode());
        } finally {
            connection.disconnect();
        }
    }

}
