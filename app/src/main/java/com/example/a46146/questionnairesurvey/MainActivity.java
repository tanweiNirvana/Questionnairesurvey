package com.example.a46146.questionnairesurvey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private CheckBox cbPrepare;
    private CheckBox cbStart;
    private CheckBox cbReset;
    private CheckBox cbRelease;
    private int score = 0;
    private boolean question_1;
    private boolean question_2;
    private boolean question_3;
    private boolean question_4_A;
    private boolean question_4_B;
    private boolean question_4_C;
    private boolean question_4_D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        etName = (EditText) findViewById(R.id.et_name);
        RadioGroup rgSystem = (RadioGroup) findViewById(R.id.rg_system);
        RadioGroup rgVirtual = (RadioGroup) findViewById(R.id.rg_virtual);
        RadioGroup rgSuffix = (RadioGroup) findViewById(R.id.rg_suffix);
        cbPrepare = (CheckBox) findViewById(R.id.cb_prepare);
        cbStart = (CheckBox) findViewById(R.id.cb_start);
        cbReset = (CheckBox) findViewById(R.id.cb_reset);
        cbRelease = (CheckBox) findViewById(R.id.cb_release);
        Button btnSubmit = (Button) findViewById(R.id.btn_submit);
        Button btnScore = (Button) findViewById(R.id.btn_score);
        RadioGroupListener radioGroupListener = new RadioGroupListener();
        rgSystem.setOnCheckedChangeListener(radioGroupListener);
        rgVirtual.setOnCheckedChangeListener(radioGroupListener);
        rgSuffix.setOnCheckedChangeListener(radioGroupListener);
        rgSystem.setOnCheckedChangeListener(radioGroupListener);
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        cbPrepare.setOnCheckedChangeListener(checkBoxListener);
        cbStart.setOnCheckedChangeListener(checkBoxListener);
        cbReset.setOnCheckedChangeListener(checkBoxListener);
        cbRelease.setOnCheckedChangeListener(checkBoxListener);
        ButtonListener buttonListener = new ButtonListener();
        btnSubmit.setOnClickListener(buttonListener);
        btnScore.setOnClickListener(buttonListener);
    }


    class RadioGroupListener implements OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_android:
                    question_1 = false;
                    break;
                case R.id.rb_ios:
                    question_1 = false;
                    break;
                case R.id.rb_vista:
                    question_1 = true;
                    break;
                case R.id.rb_ART:
                    question_2 = true;
                    break;
                case R.id.rb_JVM:
                    question_2 = false;
                    break;
                case R.id.rb_framework:
                    question_2 = false;
                    break;
                case R.id.rb_class:
                    question_3 = false;
                    break;
                case R.id.rb_apk:
                    question_3 = false;
                    break;
                case R.id.rb_dex:
                    question_3 = true;
                    break;
            }
        }
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            CheckBox cbBox = (CheckBox) buttonView;
            switch (cbBox.getId()) {
                case R.id.cb_prepare:
                    if (isChecked) {
                        question_4_A = true;
                    } else {
                        question_4_A = false;
                    }
                    break;
                case R.id.cb_start:
                    if (isChecked) {
                        question_4_B = true;
                    } else {
                        question_4_B = false;
                    }
                    break;
                case R.id.cb_reset:
                    if (isChecked) {
                        question_4_C = true;
                    } else {
                        question_4_C = false;
                    }
                    break;
                case R.id.cb_release:
                    if (isChecked) {
                        question_4_D = true;
                    } else {
                        question_4_D = false;
                    }
                    break;
            }
        }
    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_submit:
                    if (question_1 == true) {
                        score += 25;
                    }
                    if (question_2 == true) {
                        score += 25;
                    }
                    if (question_3 == true) {
                        score += 25;
                    }
                    if (question_4_C == false && question_4_D == false) {
                        if (question_4_A == true && question_4_B == true) {
                            score += 25;
                        } else {
                            if (question_4_A == true || question_4_B == true)
                                score += 10;
                        }
                    }
                    Toast.makeText(MainActivity.this, etName.getText() +
                            ",你的成绩是：" + score, Toast.LENGTH_SHORT).show();
                    score = 0;
                    break;
                case R.id.btn_score:
                    Toast.makeText(MainActivity.this, "正确答案是：\n" +
                            "1、C  2、A  3、C  4、AB", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}