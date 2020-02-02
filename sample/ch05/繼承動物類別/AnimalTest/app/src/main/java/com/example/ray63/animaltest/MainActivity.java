package com.example.ray63.animaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Animal animal = new Dog("Tony");
    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = this.findViewById(R.id.status);
        Button grow = this.findViewById(R.id.grow);
        Button eat = this.findViewById(R.id.eat);
        Button sleep = this.findViewById(R.id.sleep);
        grow.setOnClickListener(this);
        eat.setOnClickListener(this);
        sleep.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.grow:
                this.status.setText(animal.name + " grow to " + animal.grow() + " years old");
                break;
            case R.id.eat:
                this.status.setText(animal.name + " " + animal.eat());
                break;
            case R.id.sleep:
                this.status.setText(animal.name + " " + animal.sleep());
                break;
        }
    }
}
