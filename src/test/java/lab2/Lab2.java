import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() {
    try {
        var avatarStream = getRandomAvatarStream(); //avatarStream is a variable that will receive a random avatar.
        showAvatar(avatarStream);
    } catch (IOException | InterruptedException e) {
        e.printStackTrace(); //instance method on Throwable object. This will print where the exception occurred.
    }

}

InputStream getRandomAvatarStream() throws IOException, InterruptedException {
    // Pick a random style
    String[] styles = { "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral", "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps", "personas", "pixel-art", "pixel-art-neutral" }; //styles is a variable that will receive an array of strings, which are the possible avatar styles.
    var style = styles[(int)(Math.random() * styles.length)];  //random() is class method of Math, this returns a double type random number. styles.length is instance variable. When I hover over the length, it has "public final int length" it means it cannot be changed. style is a variable that will receive a random style from the array.

    // Generate a random seed
    var seed = (int)(Math.random() * 10000); //random() is class method of Math, this returns a double type random number. seed is a variable that will receive a random integer.
    // Create an HTTP request for a random avatar
    var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));//create is a class method of URI, it parse or convert a string to URI object. And .formatted is an instance method. uri is a variable that will receive the parsed string or the URI object.
    var request = HttpRequest.newBuilder(uri).build(); //HttpRequest is a class. newBuilder is a class method. build is an instance method. request is a variable that will receive the HttpRequest object.

    // Send the request
    try (var client = HttpClient.newHttpClient()) { //HttpClient is a class. newHttpClient is a class method. client is a variable that will receive the HttpClient object.
        var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream()); //send is an instance method. Hovering over the ofInputStream() shows "public static", which means it is a class method. response is a variable that will hold the HttpResponse.
        return response.body(); //response.body() is an instance method of HttpResponse.
    }
}

void showAvatar(InputStream imageStream) {
    JFrame frame = new JFrame("PNG Viewer"); //JFrame is a class. frame is a variable that will receive the JFrame object.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// setDefaultCloseOperation is an instance method. JFrame is a class and EXIT_ON_CLOSE is a constant. This sets the default close operation to exit on close.
    frame.setResizable(false); // instance method assigning a value to resizable which is false, which means the frame cannot be resized.
    frame.setSize(200, 200); // instance method assigning a value to width and height.
    frame.getContentPane().setBackground(Color.BLACK);// getContentPane() is an instance method, returning contentPane for object frame. setBackground is an instance method assigning a value black to background.

    try {
        // Load the PNG image
        Image image = ImageIO.read(imageStream); //ImageIO.read is a class method. Image is a type and image is a variable of Image.

        // Create a JLabel to display the image
        JLabel imageLabel = new JLabel(new ImageIcon(image)); //JLabel is a class. new ImageIcon is a class method. ImageIcon is a class.
        frame.add(imageLabel, BorderLayout.CENTER); //frame.add is an instance method. BorderLayout.CENTER is a class variable, CENTER being a constant.

    } catch (IOException e) {
        e.printStackTrace(); //instance method on Throwable object. This will print where the exception occurred.
    }

    frame.setVisible(true); //setVisible is an instance method.
}
