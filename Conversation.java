import java.util.*;
import java.lang.StringBuilder;

class Conversation {
  /**
   * Converses with a user, either returning a pronoun-swapped reflection
   * of the user's input or a random selection of canned responses.
   * 
   * @param args The command line arguments (ignored)
   **/
  public static void main(String[] args) {
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
      // Reset mirror_on variable:
      Boolean mirror_on = false;
      // Initialize new String Builder to receive response
      StringBuilder mirror_response = new StringBuilder();

      // Get user statement
      String user_statement = sc.nextLine();

      // Add input to transcript:
      transcript.add("User: " + user_statement);

      String[] user_list = user_statement.split(" ");

      // Start response construction
      // Does user input contain a mirrorable word?
      for (String word : user_list) {
        if (word.contains("I") |
            word.contains("I'm") |
            word.contains("Me") |
            word.contains("me") |
            word.contains("am") |
            word.contains("You") |
            word.contains("you") |
            word.contains("my") |
            word.contains("My") |
            word.contains("Your") |
            word.contains("your") |
            word.contains("you're") |
            word.contains("You're")) {
          // Code inspo for checking string equality:
          // https://stackoverflow.com/questions/43760107/how-to-partial-match-with-a-string
          if (word.contains("I")) {
            // Switch the mirror_on variable to be true for response return later
            mirror_on = true;
            word = word.replace(word, "You");
          } else if (word.contains("Me")) {
            word = word.replace(word, "You");
          } else if (word.contains("me")) {
            word = word.replace(word, "you");
          } else if (word.contains("am")) {
            word = word.replace(word, "are");
          } else if (word.contains("You") | word.contains("you")) {
            word = word.replace(word, "I");
          } else if (word.contains("my")) {
            word = word.replace(word, "your");
          } else if (word.contains("My")) {
            word = word.replace(word, "Your");
          } else if (word.contains("your")) {
            word = word.replace(word, "my");
          } else if (word.contains("Your")) {
            word = word.replace(word, "My");
          } else if (word.contains("re")) {
            word = word.replace(word, "m");
          } else if (word.contains("m")) {
            word = word.replace(word, "re");
          } else if (word.contains("are")) {
            word = word.replace(word, "am");
          } else if (word.contains("Are")) {
            word = word.replace(word, "Am");
          }
        }
        // Code from a chatGPT question https://chat.openai.com/share/94798286-c33f-4725-885e-23be5dc7675f
        mirror_response.append(word).append(" ");
      }
      mirror_response.deleteCharAt(mirror_response.length() - 1).append("?");

      // If the input contained mirrorable words, return the mirrored statement
      if (mirror_on) {
        System.out.println(mirror_response);
        transcript.add("User: " + mirror_response);
      // Get random response if non-mirrorable response
      } else {
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
