package book.ray.mybilling;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> str;
    public ArrayAdapter adapter;
    public int clickitem = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File dir = this.getExternalFilesDir(null);;
        File outFile = new File(dir, "test.txt");
        String content = "this is an outer storage test";
        try{
            FileOutputStream os = new FileOutputStream(outFile);
            os.write(content.getBytes());
            os.flush();
            os.close();
        } catch (Exception e) {}


        ListView listview = findViewById(R.id.listview);
        str = new ArrayList<String>();
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, str);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickitem = position;
            }
        });
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText item = findViewById(R.id.item);
                EditText price = findViewById(R.id.price);
                if(!item.getText().toString().equals("") && !price.getText().toString().equals(""))
                {
                    str.add(item.getText().toString() + ":" + price.getText().toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });
        Button del = findViewById(R.id.del);
        del.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickitem >= 0) {
                    str.remove(clickitem);
                    adapter.notifyDataSetChanged();
                }
                clickitem = -1;
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        switch (item_id){
            case R.id.quit:
                System.exit(0);
                break;
            default: return false;
        }
        return true;
    }
}
