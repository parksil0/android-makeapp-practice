package practice.androidstudio.samplelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //XML 레이아웃에 추가한 뷰 참조
        Layout1 layout1 = findViewById(R.id.layout1);

        //뷰의 메서드 호출하여 데이터 설정
        layout1.setImage(R.drawable.ic_launcher_foreground);
        layout1.setName("김민수");
        layout1.setMobile("010-1000-1000");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            //버튼 클릭했을 때 이미지 설정
            layout1.setImage(R.drawable.profile1);
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            layout1.setImage(R.drawable.profile2);
        });
    }
}