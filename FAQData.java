import java.util.HashMap;

public class FAQData {

    HashMap<String, String> faq =
            new HashMap<>();

    public FAQData() {

        faq.put("what is ai",
                "AI means Artificial Intelligence.");

        faq.put("what is java",
                "Java is an object-oriented programming language.");

        faq.put("who developed java",
                "Java was developed by James Gosling.");

        faq.put("what is chatbot",
                "A chatbot is a software that communicates with users.");

        faq.put("bye",
                "Goodbye! Have a nice day.");
    }

    public String getFAQAnswer(String input) {

        return faq.get(input.toLowerCase());
    }
}