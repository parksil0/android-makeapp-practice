package practice.androidstudio.samplelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

//LinearLayout 클래스 상속하여 새로운 클래스 정의
public class Layout1 extends LinearLayout {
    ImageView imageView;
    TextView textView;
    TextView textView2;

    public Layout1(Context context) {
        super(context);
        init(context);
    }

    public Layout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /*
        두 개의 생성자가 추가되면 객체가 생성될 때 호출될 수 있도록 init() 메서드 추가
        init() 메서드에는 Context 객체가 전달되며 그 안에서 XML 레이아웃 파일을 인플레이션하여
        소스 파일과 매칭될 수 있도록 한다.
    */
    private void init(Context context) {
        //인플레이션 진행
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout1, this, true);

        //XML 레이아웃에서 정의했던 뷰 참조
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
    }

    //뷰에 데이터 설정

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }
}
