package com.example.nrike.modelpresenterviewer1.Viewer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nrike.modelpresenterviewer1.Presenter.Presenter;
import com.example.nrike.modelpresenterviewer1.R;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivityView extends AppCompatActivity implements  MainActivityInterfice{

    Presenter presenter = new Presenter();
    Context context;

    RelativeLayout correct;
    RelativeLayout incorrect;
    TextView lb1;
    TextView lb2;
    EditText txtresult;
    Button check;

    public void setUI(){
        correct = (RelativeLayout) findViewById(R.id.Correcto);
        incorrect = (RelativeLayout) findViewById(R.id.Incorrecto);
        check = (Button) findViewById(R.id.btcheck);
        txtresult = (EditText) findViewById(R.id.txtresult);
        lb1 = (TextView) findViewById(R.id.lb1);
        lb2 = (TextView) findViewById(R.id.lb2);

        context = this;

        setTitle("Simple MVP");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = lb1.getText().toString();
                String b = lb2.getText().toString();
                String result = txtresult.getText().toString();

                presenter.check((MainActivityInterfice) context,a,b,result);

                Random rand = new Random();

                int n1 = rand.nextInt(10);
                int n2 = rand.nextInt(10);
                System.out.println(n1);

                lb1.setText(String.valueOf(n1));
                lb2.setText(String.valueOf(n2));

            }
        });
    }


    //Methods
    @Override
    public void showCorrect() {
        correct.setVisibility(View.VISIBLE);
        incorrect.setVisibility(View.GONE);

    }

    @Override
    public void showIncorrect() {
        correct.setVisibility(View.GONE);
        incorrect.setVisibility(View.VISIBLE);
    }
}
