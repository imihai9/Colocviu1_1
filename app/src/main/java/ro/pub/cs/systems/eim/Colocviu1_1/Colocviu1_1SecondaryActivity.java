package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_1SecondaryActivity extends AppCompatActivity {
    private TextView textView;
    private Colocviu1_1SecondaryActivity.ButtonClickListener buttonClickListener = new ButtonClickListener();
    private Button register, cancel;

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //TODO: TOAST
            switch (view.getId()) {
                case R.id.register_button:
                case R.id.cancel_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_1SecondaryActivity.class);
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_secondary);
        register = (Button)findViewById(R.id.register_button);
        cancel = (Button)findViewById(R.id.cancel_button);
        textView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.BUTTONS_PRESSED)) {
            String buttonsPressed = intent.getStringExtra(Constants.BUTTONS_PRESSED);
            textView.setText(String.valueOf(buttonsPressed));
        }

        register.setOnClickListener(buttonClickListener);
        cancel.setOnClickListener(buttonClickListener);

    }
}