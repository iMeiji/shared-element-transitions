package com.mikescamell.sharedelementtransitions.simple_activity_to_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.R;

public class SimpleActivityA extends AppCompatActivity {

    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在您的代码中启用窗口内容转换
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//            getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.simple_fragment_transition));
//            getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.simple_fragment_transition));
//        }

        setContentView(R.layout.activity_a);

        imageView = findViewById(R.id.simple_activity_a_imageView);

        button = findViewById(R.id.simple_activity_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleActivityA.this, SimpleActivityB.class);
                // 以多个共享元素启动一个操作行为
                Pair p1 = Pair.create(imageView, ViewCompat.getTransitionName(imageView));
                Pair p2 = Pair.create(button, ViewCompat.getTransitionName(button));

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        SimpleActivityA.this,
                        p1, p2);
                startActivity(intent, options.toBundle());
            }
        });
    }
}
