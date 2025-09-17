

void main () {
    IO.println("Hello, World!");
    IO.println("Enter your name: ");
    String name = IO.readln(); // this reads a line of text from the keyboard and stores it in the variable name
    IO.println("Enter your age: ");
    Integer age = Integer.parseInt(IO.readln()); // parse convert the string to an integer and store it in the variable age
    int[] numbers = new int[3]; // declare array of integers. array numbers will have 3 elements

    for (int i = 0; i < numbers.length; i = i+1) { // start with the first element, and add 1 to it each time, as long as it is less than the length of the array, which is 3 in this case.
        IO.print("Enter favorite number " + (i + 1) + ": "); // ask the user to enter a favorite number, and store it in the element at index i of the array. It will keep asking for favorite numbers until the array is full.
        numbers[i] = Integer.parseInt(IO.readln()); // convert the string to an integer and store it in the element at index i of the array.
    }


    String message; //Declare variable message as string

    if (age < 18) {
        message = ("Hello, " + name + "! Your age is " + age + " and you're not an adult.");
    } else {
        message = ("Hello, " + name + "! Your age is " + age + " and you're an adult.");

    }

    IO.println(message); // print the message variable to the screen
    IO.println("Your favorite numbers are: " + numbers[0] + ", " + numbers[1] + ", and " + numbers[2]); // print the numbers array to the screen

    try {
        String filecontent = message + "\n" + "Your favorite numbers are: " + numbers[0] + ", " + numbers[1] + ", and " + numbers[2]; // store the message and numbers array in a single string
        Files.writeString(Paths.get("myfile.txt"), filecontent, StandardOpenOption.CREATE, StandardOpenOption.WRITE); // write the string to a file named myfile.txt. If the file already exists, it will be overwritten.
        IO.println("File written successfully and saved as myfile.txt"); // print a message to the screen to indicate that the file was written successfully
    } catch (Exception e) {
        IO.println("Error: " + e.getMessage()); // print an error message to the screen if there is an error

    }
}
