package com.selen.hwpopularlibraries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel viewModel;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        observeViewModel();
    }

    private void initView() {
        editText = findViewById(R.id.text_input_edit_text);
        textView = findViewById(R.id.text_view);
        Button button = findViewById(R.id.button_send);
        button.setOnClickListener(this);
    }

    private void observeViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.changeText.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
    }

    @Override
    public void onClick(View v) {
        viewModel.setText(editText.getText().toString());
    }
}