import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class ChatGUI extends JFrame {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;
    JButton clearButton;

    ChatBot bot = new ChatBot();
    FAQData faq = new FAQData();

    public ChatGUI() {

        setTitle("AI ChatBot");

        setSize(600, 500);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setFont(
                new Font("Arial",
                        Font.PLAIN,
                        16));

        JScrollPane scrollPane =
                new JScrollPane(chatArea);

        inputField = new JTextField();

        sendButton =
                new JButton("Send");

        clearButton =
                new JButton("Clear");

        JPanel panel =
                new JPanel(new BorderLayout());

        JPanel buttonPanel =
                new JPanel(new GridLayout(1,2));

        buttonPanel.add(sendButton);

        buttonPanel.add(clearButton);

        panel.add(inputField,
                BorderLayout.CENTER);

        panel.add(buttonPanel,
                BorderLayout.EAST);

        add(scrollPane,
                BorderLayout.CENTER);

        add(panel,
                BorderLayout.SOUTH);

        sendButton.addActionListener(
                e -> sendMessage());

        inputField.addActionListener(
                e -> sendMessage());

        clearButton.addActionListener(
                e -> chatArea.setText(""));

        setVisible(true);
    }

    private void sendMessage() {

        String userInput =
                inputField.getText();

        String time =
                LocalTime.now()
                        .withNano(0)
                        .toString();

        chatArea.append(
                "[" + time + "] You: "
                        + userInput + "\n");

        String response =
                bot.getResponse(userInput);
        if(response.equals("I don't understand.")) {

            String faqAnswer =
                faq.getFAQAnswer(userInput);

            if(faqAnswer != null) {

                response = faqAnswer;
            }
        }

        if(response.equals(
                "I don't understand.")) {

            String faqAnswer =
                    faq.getFAQAnswer(userInput);

            if(faqAnswer != null) {

                response = faqAnswer;
            }
        }

        chatArea.append(
                "[" + time + "] Bot: "
                        + response + "\n\n");

        inputField.setText("");

        chatArea.setCaretPosition(
                chatArea.getDocument()
                        .getLength());
    }
}