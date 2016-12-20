package com.jasonxu.dialogfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jasonxu.dialogfragment.fragment.CenterFragmentDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnOne,btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = (Button)findViewById(R.id.btn_one);
        btnTwo = (Button)findViewById(R.id.btn_two);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment childFragment;
        switch (view.getId()){
            case R.id.btn_one:
                childFragment = new CenterFragmentDialog();
                ViewGroup viewGroup = (ViewGroup)getWindow().getDecorView();
                getSupportFragmentManager().beginTransaction().replace(android.R.id.content,childFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_two:

                break;
        }
    }
}
