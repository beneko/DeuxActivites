package com.afpa.deuxactivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "deuxActivite.extra.REPLY" ;
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // reception du message du main
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        mReply = findViewById(R.id.edit_text_reponse);
    }

    public void returnReply(View view) {
        // récupération de la réponse de l'utilisateur
        String reply = mReply.getText().toString();
        // Instanciation d'un nouvel intent
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        // mise à jour de l'état de la réponse
        setResult(RESULT_OK,replyIntent);
        // on termine l'activité 2
        finish();
    }
}