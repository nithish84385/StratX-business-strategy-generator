package com.example.startx;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    Button sendButton;
    TextView chatDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.userInput);
        sendButton = findViewById(R.id.sendButton);
        chatDisplay = findViewById(R.id.chatDisplay);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = userInput.getText().toString().trim();
                if (!message.isEmpty()) {
                    displayMessage("You: " + message);
                    generateReply(message);
                    userInput.setText("");
                }
            }
        });
    }

    private void displayMessage(String msg) {
        String currentText = chatDisplay.getText().toString();
        chatDisplay.setText(currentText + "\n" + msg);
    }

    private void generateReply(String input) {
        String reply;
        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            reply = "StartX: Hello! How can I assist you today?";
        } else if (input.contains("business") || input.contains("startup")) {
            reply = "StartX: We help startups build AI-powered solutions.";
        } else if (input.contains("thank")) {
            reply = "StartX: You're welcome! Have a great day!";
        } else {
            reply = "StartX: I’m still learning! Please ask something else.";
        }

        displayMessage(reply);
    }
}
