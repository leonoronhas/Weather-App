package leonoronhas.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String city = "unknown city";
    EditText cityName;
    public static TextView data;
    Button buttonTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = findViewById(R.id.editNameField);
        city = cityName.getText().toString();

        buttonTemp = findViewById(R.id.buttonCurrentW);
        data = findViewById(R.id.textView);


        buttonTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundRun br = new BackgroundRun(city);
                br.execute();
            }
        });
    }


//
//    public void onClick(View view){
//        // Get the input from the text field
//        cityName = findViewById(R.id.editNameField);
//
//        // Save the input to a string called city
//        city = cityName.getText().toString();
//
//        BackgroundRun br = new BackgroundRun(city);
//        br.run();
//    }
}
