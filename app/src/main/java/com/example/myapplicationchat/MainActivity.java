package com.example.myapplicationchat;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements InputFragment.OnMessageSendListener {
    private ChatFragment chatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatFragment = ChatFragment.newInstance();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_chat, chatFragment)
                    .replace(R.id.container_input, new InputFragment())
                    .commit();
        }
    }

    @Override
    public void onMessageSend(String message) {
        chatFragment.addMessage(new Message(message, true));  // Добавляем сообщение пользователя

        // Автоответчик добавляется с задержкой
        new Handler().postDelayed(() -> {
            chatFragment.addMessage(new Message("Auto reply to: " + message, false));  // Ответ от автоответчика
        }, 1000);
    }
}
