package com.example.arithmetci;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AddDialog.Add
        ,SubtractDialog.Subtract,MultiplyDialog.Multiply,DivideDailog.Divide{
      private TextView outPutview;
    private TextView addOperation;
    private TextView subtraction;
    private TextView multiply;
    private TextView divide;
    private Button aboutdeveloperBnt;
         TextView id;
    int output,firstno,secondno;
    float divideOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         outPutview=findViewById(R.id.outputview);
          aboutdeveloperBnt=findViewById(R.id.about_developer_btn);
        addOperation = findViewById(R.id.add_operation);
        subtraction = findViewById(R.id.subtract_operation);
        multiply = findViewById(R.id.multiply_operation);
        divide = findViewById(R.id.divide_operation);
       aboutdeveloperBnt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,ContactActivity.class);
               startActivity(intent);
           }
       });
        addOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddDialog();


            }
        });
             subtraction.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     openSubtractDialog();


                 }
             });
              multiply.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      openmultiplyDialog();
                  }
              });

              divide.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      divideopenDialog();
                  }
              });
    }

    private void divideopenDialog() {

       DivideDailog divideDailog=new DivideDailog();
       divideDailog.show(getSupportFragmentManager(),"divide dialog");


    }

    private void openmultiplyDialog() {

             MultiplyDialog multiplyDialog=new MultiplyDialog();
             multiplyDialog.show(getSupportFragmentManager(),"multiply dialog");


    }

    private void openSubtractDialog() {

           SubtractDialog subtractDialog=new SubtractDialog();
           subtractDialog.show(getSupportFragmentManager(),"subtract dialog");



    }


    private void openAddDialog() {
         AddDialog addDialog=new AddDialog();
         addDialog.show(getSupportFragmentManager(),"add dialog");



    }


    @Override
    public void addNumber(String first, String second) {
        firstno=Integer.parseInt(first);
        secondno=Integer.parseInt(second);

        output=firstno+secondno;
        outPutview.setText(String.valueOf(output));


    }

    @Override
    public void subtractno(String first, String second) {

        firstno=Integer.parseInt(first);
        secondno=Integer.parseInt(second);
        if(firstno>=secondno)
        {
            output=firstno-secondno;
        }
        else {
            output=secondno-firstno;
        }
        outPutview.setText(String.valueOf(output));
    }

    @Override
    public void multiply(String first, String second) {

        firstno=Integer.parseInt(first);
        secondno=Integer.parseInt(second);

        output=firstno*secondno;
        outPutview.setText(String.valueOf(output));

    }

    @Override
    public void divideno(String first, String second) {
        firstno=Integer.parseInt(first);
        secondno=Integer.parseInt(second);

      divideOutput=(float)firstno / secondno;
        outPutview.setText(String.valueOf(divideOutput));

    }
}
