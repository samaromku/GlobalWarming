package ru.andrey.savchenko.globalwarming.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.andrey.savchenko.globalwarming.App;
import ru.andrey.savchenko.globalwarming.R;
import ru.andrey.savchenko.globalwarming.activities.di.GlobalComponent;
import ru.andrey.savchenko.globalwarming.activities.di.GlobalModule;
import ru.andrey.savchenko.globalwarming.entities.Question;


import javax.inject.Inject;

public class GlobalActivity extends AppCompatActivity implements GlobalView {
    private static final String TAG = GlobalActivity.class.getSimpleName();
    @Inject
    GlobalPresenter presenter;
    private int count = 1;
    private List<Question> questions;
    @BindView(R.id.pgProgress)
    ProgressBar progressBar;
    @BindView(R.id.btnBad)
    Button btnBad;
    @BindView(R.id.btnGood)
    Button btnGood;
    @BindView(R.id.btnPlanet)
    Button btnPlanet;

    @OnClick(R.id.btnBad)
    void onBadClick() {
        btnPlanet.setBackgroundResource(R.drawable.round_shape_red);
        Toast.makeText(this, "Вы выбрали хуйню, планете пришел пиздец", Toast.LENGTH_SHORT).show();
        increaseCounter();
    }

    @OnClick(R.id.btnGood)
    void onGoodClick() {
        btnPlanet.setBackgroundResource(R.drawable.round_shape_green);
        Toast.makeText(this, "Вы выбрали светлое будущее, планета будет процветать", Toast.LENGTH_SHORT).show();
        increaseCounter();
    }

    private void increaseCounter(){
        if (questions.size() - 1 != count) {
            Log.i(TAG, "onGoodClick: " + questions.size() + " couint " + count);
            answerPlease(questions.get(++count));
        }else {
            Toast.makeText(this, "this is the end", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
        ((GlobalComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new GlobalModule(this))).inject(this);
        ButterKnife.bind(this);

        questions = new ArrayList<>();
        questions.add(new Question(1, "Использовать солнечную энергию", "Использовать нефть"));
        questions.add(new Question(2, "Продолжить вырубку лесов", "Перейти на другой вид топлива"));
        questions.add(new Question(3, "Продолжать питаться продуктами животного происхождения", "Перейти на вегитарианский рацион"));
        questions.add(new Question(4, "Продолжить пользоваться автомобилем", "Пересесть на велосипед"));
        questions.add(new Question(5, "Не делиться информацией", "Расскажите всем о проблеме глобального потепления"));
        questions.add(new Question(6, "Необдуманно тратить элктроэнергию", "Экономить элктричество"));
//        questions.add(new Question(7,"", ""));
//        questions.add(new Question(8,"", ""));
//        questions.add(new Question(9,"", ""));
//        questions.add(new Question(10,"", ""));
//        questions.add(new Question(11,"", ""));
//        questions.add(new Question(12,"", ""));

    }

    private void answerPlease(Question question) {
        btnBad.setText(question.getBad());
        btnGood.setText(question.getGood());
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 6; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setProgress(i * 20);
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getComponentManager().releaseComponent(getClass());
        }
    }

}
