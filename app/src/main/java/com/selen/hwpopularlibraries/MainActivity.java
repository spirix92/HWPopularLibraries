package com.selen.hwpopularlibraries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.selen.hwpopularlibraries.model.User;
import com.selen.hwpopularlibraries.view_model.MainViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText editText;
    private TextView textView;
    private Button button;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initViewModel();
    }

    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.request.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for (User user : users) {
                    textView.append(user.toString());
                }
            }
        });
    }

    private void initView() {
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mainViewModel.requestAll();
    }

}