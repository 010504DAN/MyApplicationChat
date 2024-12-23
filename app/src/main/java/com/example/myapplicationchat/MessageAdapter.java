package com.example.myapplicationchat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private List<Message> messages;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.textView.setText(message.getText());
        if (message.isUserMessage()) {
            holder.textView.setBackgroundResource(R.drawable.bg_blue);
        } else {
            holder.textView.setBackgroundResource(R.drawable.bg_green);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}

class MessageViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public MessageViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textMessage);
    }
}
