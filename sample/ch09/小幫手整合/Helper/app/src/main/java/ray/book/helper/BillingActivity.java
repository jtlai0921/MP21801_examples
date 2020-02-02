package ray.book.helper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class BillingActivity extends AppCompatActivity {
    public ArrayList<String> str;
    public ArrayAdapter adapter;
    public int clickitem = -1;

    void writeFile()
    {
        File dir = this.getFilesDir();
        File outFile = new File(dir, "billing.txt");
        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"utf-8"));
            for(int i=0;i<str.size();i++) {
                writer.write(str.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {}
    }

    void readFile()
    {
        File dir = this.getFilesDir();
        File inFile = new File(dir, "billing.txt");
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "utf-8"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                str.add(line);
            }
            reader.close();
        } catch (Exception e){}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        ListView listview = findViewById(R.id.listview);
        str = new ArrayList<String>();
        readFile();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, str);
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
                    writeFile();
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
                    writeFile();
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
