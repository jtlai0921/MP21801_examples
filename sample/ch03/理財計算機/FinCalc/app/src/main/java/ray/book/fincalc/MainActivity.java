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
                double s;
                double n;
                double r;
                double a;
                EditText principal = MainActivity.this.findViewById(R.id.principal);
                EditText profitRate = MainActivity.this.findViewById(R.id.profitRate);
                EditText investYears = MainActivity.this.findViewById(R.id.investYears);
                a = Double.parseDouble(principal.getText().toString());
                r = Double.parseDouble(profitRate.getText().toString());
                n = Double.parseDouble(investYears.getText().toString());
                s = a * Math.pow(1+r,n);
                TextView investTotal = MainActivity.this.findViewById(R.id.investTotal);
                investTotal.setText(""+Math.round(s));
            }
        });

        Button calcLoan = this.findViewById(R.id.calcLoan);
        calcLoan.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                double m;
                double s;
                double n;
                double r;
                EditText loan = MainActivity.this.findViewById(R.id.loan);
                EditText interest = MainActivity.this.findViewById(R.id.interest);
                EditText loanYears = MainActivity.this.findViewById(R.id.loanYears);
                s = Double.parseDouble(loan.getText().toString());
                r = Double.parseDouble(interest.getText().toString());
                n = Double.parseDouble(loanYears.getText().toString());
                m = s * ( Math.pow( ( 1 + r / 12 ) , ( n * 12 ) ) * (r / 12) ) / ( Math.pow( ( 1 + r / 12 ) , ( n * 12 ) ) -1 ) ;
                TextView repayment = MainActivity.this.findViewById(R.id.repayment);
                repayment.setText(""+Math.round(m));
            }
        });

    }
}
