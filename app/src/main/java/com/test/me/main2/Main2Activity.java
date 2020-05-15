package com.test.me.main2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.me.R;
import com.test.me.main2.presenter.Main2Presenter;
import com.test.me.main2.view.Main2View;

public class Main2Activity extends AppCompatActivity {

    private Main2Presenter main2Presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        main2Presenter = new Main2Presenter(new Main2View(findViewById(R.id.ll_container)));

        main2Presenter.start();
    }

    @Override
    protected void onDestroy() {

        main2Presenter.destroy();

        super.onDestroy();
    }
}
