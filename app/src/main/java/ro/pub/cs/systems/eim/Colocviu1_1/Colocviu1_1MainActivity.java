package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    private Button eastButton, westButton, northButton, southButton;
    private TextView buttonsTextView;

    private int numberOfClicks;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private void concatTextToTextView(String newText) {
        String currText = String.valueOf(buttonsTextView.getText());
        if (!currText.isEmpty()) {
            currText += ", ";
        }
        currText += newText;
        buttonsTextView.setText(currText);
    }
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            numberOfClicks++;
            System.out.println("Number of button clicks: " + numberOfClicks);
            switch (view.getId()) {
                case R.id.north_button:
                    concatTextToTextView(String.valueOf(northButton.getText()));
                    break;
                case R.id.south_button:
                    concatTextToTextView(String.valueOf(southButton.getText()));
                    break;
                case R.id.east_button:
                    concatTextToTextView(String.valueOf(eastButton.getText()));
                    break;
                case R.id.west_button:
                    concatTextToTextView(String.valueOf(westButton.getText()));
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numberOfClicks = 0;

        setContentView(R.layout.activity_colocviu1_1_main);

        eastButton = (Button)findViewById(R.id.east_button);
        westButton = (Button)findViewById(R.id.west_button);
        northButton = (Button)findViewById(R.id.north_button);
        southButton = (Button)findViewById(R.id.south_button);

        eastButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);
        northButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);

        buttonsTextView = (TextView)findViewById(R.id.buttonsTextView);
        System.out.println(buttonsTextView);

//        Intent intent = getIntent();
//        if (intent != null && intent.getExtras().containsKey(Constants.NUMBER_OF_CLICKS)) {
//            numberOfClicks = intent.getIntExtra(Constants.NUMBER_OF_CLICKS, -1);
//        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(Constants.NUMBER_OF_CLICKS, numberOfClicks);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.NUMBER_OF_CLICKS)) {
            numberOfClicks = savedInstanceState.getInt(Constants.NUMBER_OF_CLICKS);
        } else {
            numberOfClicks = 0;
        }
    }
}