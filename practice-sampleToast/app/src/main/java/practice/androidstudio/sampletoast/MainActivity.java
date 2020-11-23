package practice.androidstudio.sampletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
    }

    public void onButton1Clicked(View v) {
        Toast toastView = Toast.makeText(this, "위치가 바뀐 토스트 메시지입니다.", Toast.LENGTH_LONG);

        int xOffset = Integer.parseInt(editText.getText().toString());
        int yOffset = Integer.parseInt(editText2.getText().toString());

        toastView.setGravity(Gravity.TOP|Gravity.TOP, xOffset, yOffset);
        toastView.show();
    }

    public void onButton2Clicked(View v) {
        LayoutInflater inflater = getLayoutInflater(); //레이아웃 인플레이터 객체 참조

        View layout = inflater.inflate(
                R.layout.toastborder,
                (ViewGroup)findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewsWithText(R.id.text);

        Toast toast = new Toast(this);
        text.setText("모얄 바꾼 텍스트");
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}