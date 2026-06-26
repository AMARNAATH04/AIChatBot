public class ChatBot {

    public String getResponse(String input) {

        input = input.toLowerCase();

        if(input.equals("hello")) {
            return "Hi!";
        }

        else if(input.equals("java")) {
            return "Java is a programming language.";
        }

        return "I don't understand.";
    }
}