package practice.androidstudio.recyclerview2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//어댑터 클래스가 새로 정의한 리스너 인터페이스 구현하도록 하기
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
    implements OnPersonItemClickListener{

    ArrayList<Person> items = new ArrayList<>();
    OnPersonItemClickListener listener;

    //뷰 홀더 객체가 만들어 질 때 메서드가 실행된다
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //인플레이션을 통해 뷰 객체 만들기
        View itemView = inflater.inflate(R.layout.person_item, viewGroup, false);

        //뷰 홀더 객체를 생성하면서 뷰 객체를 전달하고 그 뷰홀더 객체를 반환하기기
        return new ViewHolder(itemView,this);
    }

    //뷰 홀더 객체가 재사용 될 때
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Person item = items.get(position);
        viewHolder.setItem(item);
    }

    //리사이클러 뷰에서 어댑터가 관리하는 아이템의 개수를 알아야 할 때 사용된다.
    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(@NonNull View itemView, final OnPersonItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            //아이템 뷰에 OnClickListener 설정하기
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();

                //아이템 뷰 클릭 시 미리 정의한 다른 리스너의 메서드 호출하기
                if(listener != null) {
                    listener.onItemClick(ViewHolder.this, view, position);
                }
            });
        }

        public void setItem(Person item) {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }

    //외부에서 리스너를 설정할 수 있도록 메서드 추가하기
    public void setOnItemClickListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void addItem(Person item) {
        items.add(item);
    }

    public void setItems(ArrayList<Person> items) {
        this.items = items;
    }

    public Person getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Person item) {
        items.set(position, item);
    }
}
