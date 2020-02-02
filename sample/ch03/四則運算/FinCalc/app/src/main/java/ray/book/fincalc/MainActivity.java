package ray.book.fincalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calcInvest = this.findViewById(R.id.calcInvest);
        calcInvest.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                int a;
                int b;
                int c;
                EditText principal = MainActivity.this.findViewById(R.id.principal);
                EditText profitRate = MainActivity.this.findViewById(R.id.profitRate);
                a = Integer.parseInt(principal.getText().toString());
                b = Integer.parseInt(profitRate.getText().toString());
                c = a + b;
                TextView investTotal = MainActivity.this.findViewById(R.id.investTotal);
                investTotal.setText("a+b="+c);
            }
        });

    }
}
