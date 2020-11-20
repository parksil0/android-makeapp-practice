package practice.androidstudio.samplescrollview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import practice.androidstudio.samplescrollview.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageView01;
    ImageView imageView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView01 = findViewById(R.id.imageView4);
        imageView02 = findViewById(R.id.imageView6);

        Button button01 = findViewById(R.id.button4);
        button01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveImageUp();
            }
        });

        Button button02 = findViewById(R.id.button5);
        button02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveImageDown();
            }
        });

        moveImageUp();
    }

    private void moveImageDown() {
        imageView01.setImageResource(0);
        imageView02.setImageResource(R.drawable.image01);

        imageView01.invalidate();
        imageView02.invalidate();
    }

    private void moveImageUp() {
        imageView01.setImageResource(R.drawable.image01);
        imageView02.setImageResource(0);

        imageView01.invalidate();
        imageView02.invalidate();
    }

}