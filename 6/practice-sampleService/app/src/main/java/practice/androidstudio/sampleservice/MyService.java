package practice.androidstudio.sampleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG  = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreated() 호출 됨");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() 호출됨");

        if(intent == null) {
            //서비스가 비정상으로 종료되었음
            return Service.START_STICKY;
        } else {
            //해당 메서드에 많은 코드를 넣으면 가독성이 안좋아져 새로운 메서드 생성
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG, "command : " + command + ", name : " + name);

        //5초동안 1초에 한 번씩 로그 출력
       for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {};
            Log.d(TAG, "Wating " + i + " seconds.");
        }

       //액티비티를 띄우기 위한 인텐트 객체 만들기
       Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);

       //인텐트에 플래그 추가하기
       showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP
                            | Intent.FLAG_ACTIVITY_CLEAR_TOP);
       showIntent.putExtra("command", "show");
       showIntent.putExtra("name", name + " from service");
       startActivity(showIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}