package book.ray.mybilling;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> str;
    public ArrayAdapter adapter;
    public int clickitem = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File dir = this.getFilesDir();
        File inFile = new File(dir, "test.txt");
        StringBuilder data = new StringBuilder();
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "utf-8"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                data.append(line);
            }
        } catch (Exception e){}
        Toast.makeText(this,data.toString(),Toast.LENGTH_SHORT).show();

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
