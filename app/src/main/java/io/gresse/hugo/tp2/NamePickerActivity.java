package io.gresse.hugo.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kykyl on 04/12/2017.
 */

public class NamePickerActivity extends AppCompatActivity {

    public static final String TAG = NamePickerActivity.class.getSimpleName();

    EditText mNameEditText;
    EditText mEmailEditText;
    Button   mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namepicker);

        mNameEditText = findViewById(R.id.nom);
        mEmailEditText = findViewById(R.id.email);
        mSubmitButton = findViewById(R.id.buttonSend);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserStorage.saveUserInfo(NamePickerActivity.this, mNameEditText.getText().toString(), mEmailEditText.getText().toString());
                Intent intent = new Intent(NamePickerActivity.this, MainActivity.class);
                NamePickerActivity.this.startActivity(intent);

            }
        });

    }
}

