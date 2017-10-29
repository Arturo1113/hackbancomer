package codeanddestroy.retoliga;

import android.app.Activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import android.content.Context;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaración de variables
    EditText inputText;
    TextView outputText;
    Button passButton;
    String numberString;
    TelephonyManager mTelephonyManager;
    Random randomGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicialización de variables
        inputText = (EditText) findViewById(R.id.et);
        outputText = (TextView) findViewById(R.id.tv);
        passButton = (Button) findViewById(R.id.btn);
        randomGenerator = new Random();
        numberString = "";

        numberString += randomGenerator.nextInt(10000000);
        WriteBtn(numberString);


        //Método del botón
        passButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //numberString = inputText.getText().toString();
                outputText.setText(numberString);

                //ReadBtn();
            }
        });

    }

    public void WriteBtn(String randomNumber) {
        // add-write text into file
        try {
            FileOutputStream fileout = openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(randomNumber);
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "Archivo guardado satisfactoriamente",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public String ReadBtn() {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[256];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();

            return s;

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }*/
}


