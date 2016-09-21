package tw.org.iii.mylistv2;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;

public class List1Activity extends AppCompatActivity {
    private ListView list1;
    private MyAdapter adapter;

    private String[] dataset = {"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);


        list1 = (ListView)findViewById(R.id.list1);
        adapter = new MyAdapter();
        list1.setAdapter(adapter);

    }
    public  class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public MyAdapter() {
            inflater = LayoutInflater.from(List1Activity.this);

        }

        @Override
        public int getCount() {
            return dataset.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.layout_itemv1, parent, false);
            }

            TextView title = (TextView) convertView.findViewById(R.id.itemv1_title);
            if (position % 2 == 0) {
                convertView.setBackgroundColor(Color.YELLOW);
                title.setTextColor(Color.BLUE);
            } else {
                convertView.setBackgroundColor(Color.GRAY);
                title.setTextColor(Color.RED);
            }
            title.setText(dataset[position]);

            return convertView;
        }
    }
}
