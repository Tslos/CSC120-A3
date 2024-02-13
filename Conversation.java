import java.util.*;

class Conversation {
/**
   * Converses with a user, either returning a pronoun-swapped reflection 
   * of the user's input or a random selection of canned responses. 
   * @param args The command line arguments (ignored)
   **/
  public static void main() {
    // Create scanner
    Scanner sc = new Scanner(System.in);

    // Initialize the random class
    Random rnd = new Random();

    // Create list of pre-determined responses
    List<String> responses = new ArrayList<String>();
    responses.add("Interesting...");
    responses.add("Tell me more about that.");
    responses.add("Why do you think that?");
    responses.add("This is a fascinating conversation.");
    responses.add("huh?");
    responses.add("Fascinating...");
    responses.add("Really??");
    responses.add("Hrmmm...");
    responses.add("Coolio");
    // Set default random response so it can be edited later
    String rand_response = "";

    // Initialize Transcript
    List<String> transcript = new ArrayList<String>();
    transcript.add("\n\nTRANSCRIPT: ");
    // Get the number of conversation rounds
    System.out.println("Please enter how many rounds of conversation you are up to today.");
    int rounds = sc.nextInt();
    // clear scanner input so that there is no newline drama - removing this makes
    // it zoom through the 2+ responses without waiting for input
    sc.nextLine();

    // Print welcome statement
    System.out.println("Hi there!  What's on your mind?");

    // make general loop for conversation
    for (int i = 0; i < rounds; i++) {
      // Get user statement
      String user_statement = sc.nextLine();
      // Add input to transcript:
      transcript.add("User: " + user_statement);

      // Start response construction
      // Does user input contain a mirrorable word?
      String response = user_statement;
      if (user_statement.contains("I") |
          user_statement.contains("I'm") |
          user_statement.contains("Me") |
          user_statement.contains("me") |
          user_statement.contains("am") |
          user_statement.contains("You") |
          user_statement.contains("you") |
          user_statement.contains("my") |
          user_statement.contains("My") |
          user_statement.contains("Your") |
          user_statement.contains("your") |
          user_statement.contains("you're") |
          user_statement.contains("You're")) {
        // Searches each word in statement, defining a word by splitting
        // the string along every non-word character in regex terms
        // Code inspo: https://stackoverflow.com/questions/15480811/for-loop-to-search-for-word-in-string
        for (String word : user_statement.split("[^\\w]+")) {
          System.out.println(word);
          // Check word equality inspo: https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
          if (word.equals("I")) {
            response = response.replaceFirst(word,"You");
          } else if (word.equals("Me")) {
            response = response.replaceFirst(word, "You");
          } else if (word.equals("me")) {
            response = response.replaceFirst(word, "you");
          } else if (word.equals("am")) {
            response = response.replaceFirst(word, "are");
          } else if (word.equals("You") | word.equals("you")) {
            response = response.replaceFirst(word, "I");
          } else if (word.equals("my")) {
            response = response.replaceFirst(word, "your");
          } else if (word.equals("My")) {
            response = response.replaceFirst(word, "Your");
          } else if (word.equals("your")) {
            response = response.replaceFirst(word, "my");
          } else if (word.equals("Your")) {
            response = response.replaceFirst(word, "My");
          } else if (word.equals("re")) {
            response = response.replaceFirst(word, "m");
          } else if (word.equals("m")) {
            response = response.replaceFirst(word, "re");
          } else if (word.equals("are")) {
            response = response.replaceFirst(word, "am");
          } else if (word.equals("Are")) {
            response = response.replaceFirst(word, "Am");
          }
          
        }
        System.out.println(response + "?");
        // Add the response to the transcipt
        transcript.add("Bot: " + response + "?");

      } else {
        // Get random response if non-mirrorable response
        rand_response = responses.get(rnd.nextInt(9));
        // Add the response to the transcipt
        transcript.add("Bot: " + rand_response);
        System.out.println(rand_response);
      }
    }
    for (int line = 0; line < transcript.size(); line++) {
      System.out.println(transcript.get(line));
    }
    sc.close();
  }
}
