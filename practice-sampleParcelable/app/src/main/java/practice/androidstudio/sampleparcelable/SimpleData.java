package practice.androidstudio.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;


public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int num, String msg) {
        number = num;
        message = msg;
    }

    //Parcel 객체에서 읽기
    public SimpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    // CREATER 상수 정의
    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {

        //SimpleData 생성자를 호출해 Parcel 객체에서 읽기
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //Parcel 객체로 쓰기
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
