package com.selen.hwpopularlibraries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher {

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
        editText.addTextChangedListener(this);
        textView = findViewById(R.id.text_view);
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
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        viewModel.setMyText(s.toString());
    }
}