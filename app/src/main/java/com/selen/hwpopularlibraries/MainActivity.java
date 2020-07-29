package com.selen.hwpopularlibraries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyViewModel viewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.push).setOnClickListener(this);
        textView = findViewById(R.id.result);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.third.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
    }

    @Override
    public void onClick(View v) {
        viewModel.addText(999L);
    }

}