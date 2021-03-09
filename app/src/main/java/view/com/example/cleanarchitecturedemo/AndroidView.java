package view.com.example.cleanarchitecturedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cleanarchitecturedemo.R;

import java.util.Observable;
import java.util.Observer;

import model.Model;

public class AndroidView extends AppCompatActivity {

    private Model model = new Model();




    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof Model) {
                    String data = ((Model) o).getData();
                    TextView outputView = (TextView) findViewById(R.id.textView);
                    outputView.setText(data);
                }            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button updateButton = (Button) findViewById(R.id.button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userinput = (EditText) findViewById(R.id.editTextTextPersonName);
                TextView saveText = (TextView) findViewById(R.id.textView);
                saveText.setText(userinput.getText());
            }
        });

}
}


