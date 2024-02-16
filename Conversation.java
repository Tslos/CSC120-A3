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
        if (word.matches("\\bI[^A-Z,a-z]*") |
            word.matches("\\bI'm[^A-Z,a-z]*") |
            word.matches("\\bMe[^A-Z,a-z]*") |
            word.matches("\\bme[^A-Z,a-z]*") |
            word.matches("\\bam[^A-Z,a-z]*") |
            word.matches("\\bYou[^A-Z,a-z]*") |
            word.matches("\\byou[^A-Z,a-z]*") |
            word.matches("\\bare[^A-Z,a-z]*") |
            word.matches("\\bAre[^A-Z,a-z]*") |
            word.matches("\\bmy[^A-Z,a-z]*") |
            word.matches("\\bMy[^A-Z,a-z]*") |
            word.matches("\\bYour[^A-Z,a-z]*") |
            word.matches("\\byour[^A-Z,a-z]*") |
            word.matches("\\byou're[^A-Z,a-z]*") |
            word.matches("\\bYou're[^A-Z,a-z]*")) {
          // Switch the mirror_on variable to be true for response return later
          mirror_on = true;
          // Code inspo for checking string equality:
          // https://stackoverflow.com/questions/43760107/how-to-partial-match-with-a-string
          if (word.matches("\\bI[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bI[^A-Z,a-z]*", "You");

          } else if (word.matches("\\bMe[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bMe", "You");

          } else if (word.matches("\\bme[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bme", "you");

          } else if (word.matches("\\bam[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bam", "are");

          } else if (word.matches("\\bAm[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bAm", "Are");

          } else if (word.matches("(?i)\\bYou[^A-Z,a-z]*")) {
            word = word.replaceAll("(?i)\\bYou", "I");

          } else if (word.matches("\\bmy[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bmy\\b", "your");

          } else if (word.matches("\\bMy[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bMy", "Your");

          } else if (word.matches("\\byour[^A-Z,a-z]*")) {
            word = word.replaceAll("\\byour", "my");

          } else if (word.matches("\\bYour[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bYour", "My");

          } else if (word.matches("(?i)\\byou're[^A-Z,a-z]*")) {
            word = word.replaceAll("(?i)\\byou're", "I'm");

          } else if (word.matches("\\bI'm[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bI'm", "You're");

          } else if (word.matches("\\bare[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bare", "am");

          } else if (word.matches("\\bAre[^A-Z,a-z]*")) {
            word = word.replaceAll("\\bAre", "Am");
          }
        }
        // Code from a chatGPT question
        // https://chat.openai.com/share/94798286-c33f-4725-885e-23be5dc7675f
        mirror_response.append(word).append(" ");
      }
      mirror_response.deleteCharAt(mirror_response.length() - 1).append("?");

      // If the input contained mirrorable words, return the mirrored statement
      if (mirror_on) {
        System.out.println(mirror_response);
        transcript.add("Bot: " + mirror_response);
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
