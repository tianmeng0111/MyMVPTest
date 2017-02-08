package com.tm.example.mymvptest.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tm.example.mymvptest.presenter.GetStringPresenter;
import com.tm.example.mymvptest.view.IGetStringView;
import com.tm.example.mymvptest.R;

public class MainActivity extends AppCompatActivity {

    private static Context mContext;

    private IGetStringView iGetStringView;
    private GetStringPresenter getStringPresenter;

    private EditText etName;
    private Button btnSaveName;
    private TextView tvShowName;
    private Button btnGetName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        initView();

        iGetStringView = new IGetStringView() {
            @Override
            public void showName(String name) {
                tvShowName.setText(name);
            }

            @Override
            public String getName() {
                return etName.getText().toString();
            }
        };

        getStringPresenter = new GetStringPresenter(iGetStringView);

    }

    private void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        btnSaveName = (Button) findViewById(R.id.btn_save_name);
        tvShowName = (TextView) findViewById(R.id.tv_show_name);
        btnGetName = (Button) findViewById(R.id.btn_get_name);

        btnSaveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStringPresenter.saveName();
            }
        });

        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStringPresenter.showName();
            }
        });
    }

    public static Context getContext() {
        return mContext;
    }

    public void goLoginActivity(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
