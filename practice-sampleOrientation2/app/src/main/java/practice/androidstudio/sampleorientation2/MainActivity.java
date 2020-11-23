package practice.androidstudio.sampleorientation2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //가로 방향
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            showToast("방향 : ORIENTATION_LANDSCAPE");

        //세로 방향
        } else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            showToast("방향 : ORIENTATION_PORTRAIT");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        showToast("onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToast("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("onDestroy()");
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }


}