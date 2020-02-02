package book.ray.mytemperature;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SensorManager mSensorManager;
    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.number);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    final SensorEventListener myAccelerometerListener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent sensorEvent) {
            number.setText(""+sensorEvent.values[0]);
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public void onPause(){
        mSensorManager.unregisterListener(myAccelerometerListener);
        super.onPause();
    }

    public void onResume() {
        mSensorManager.registerListener(myAccelerometerListener,mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }
}


