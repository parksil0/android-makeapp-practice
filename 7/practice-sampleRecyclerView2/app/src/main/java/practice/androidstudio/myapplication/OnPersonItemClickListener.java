package practice.androidstudio.myapplication;

import android.view.View;

public interface OnPersonItemClickListener {
    void onItemClick(PersonAdapter.ViewHolder holder, View view, int position);

}
