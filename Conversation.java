import java.util.*;
class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.
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


    // Get the number of conversation rounds
    System.out.println("Please enter how many rounds of conversation you are up to today.");
    int rounds = sc.nextInt();

    // Print welcome statement
    System.out.println("Hi there!  What's on your mind?");
    

    //make general loop for conversation
    for (int i = 0; i<rounds; i++){
      //Get user statement
      String user_statement = sc.nextLine();

                    // clear scanner input so that there is no newline drama - removing this makes it zoom through the 2+ responses without waiting for input
                   //sc.nextLine();


                   // Replacement attempt 1: __________
      // The I's
      /* String resp = user_statement;
      if (user_statement.matches(".*I.*")) {
        resp = user_statement.replace("I", "You");
        System.out.println(resp);
      }

      // The Me's
      if (user_statement.matches(".*me.*")) {
        resp = resp.replace("me", "you");
        System.out.println(resp);
      }
      if (user_statement.matches(".*Me.*")) {
         resp = resp.replace("Me", "You");
        System.out.println(resp);
      }
      // The You's
      if (user_statement.matches(".*you.*")) {
         resp = resp.replace("you", "I");
 System.out.println(resp);
      }
      if (user_statement.matches(".*You.*")) {
         resp = resp.replace("You", "I");
        System.out.println(resp);
      }
      // The My's
      if (user_statement.matches(".*my.*")) {
         resp = resp.replace("my", "your");
        System.out.println(resp);
      }
      if (user_statement.matches(".*My.*")) {
         resp = resp.replace("My", "Your");
        System.out.println(resp);
      }
       // The Your's
       if (user_statement.matches(".*your.*")) {
         resp = resp.replace("your", "my");
System.out.println(resp);
      }
      if (user_statement.matches(".*Your.*")) {
         resp = resp.replace("Your", "My");
        System.out.println(resp);
      }
      // The am's
      if (user_statement.matches(".*am.*")) {
         resp = resp.replace("am", "are");
        System.out.println(resp);
      }
      if (user_statement.matches(".*'m.*")) {
         resp = resp.replace("'m", "'re'");
        System.out.println(resp);
      }
      // The are's
      if (user_statement.matches(".*'re.*")) {
         resp = resp.replace("'re'", "'m'");
        System.out.println(resp);
      }

      System.out.println(resp);
       */
      
      



      // LIST APPROACH ________________________________
// Split along spaces so that there is a list with each word in the user input. 
// This does not take care of punctuation! I could do that by 
// swapping "\\s+" for  (\\s|[^\\w\\s])+, but I don't want to lose mid-sentence , or '
//String[] user_array = user_statement.split("\\s+");      

// print out the listified input
      //System.out.println(Arrays.toString(user_array));

      //List parts = Arrays.asList(user_array);

      //if (parts.contains("I")){
        //int pronoun_index = parts.indexOf("I");
       // parts.set(pronoun_index, "You");
       // System.out.println(parts);
       // System.out.println(Arrays.toString(parts.toArray()));
     // }
//Combine the list again
      //String response = Arrays.toString(parts);

      // END LIST APPROACH ________________________________




      //} else {
      // Get random response
      //System.out.println(responses.get(rnd.nextInt(9)));
      //}
    }

    sc.close();
  }
}
