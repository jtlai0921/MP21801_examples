package book.ray.mylottery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for( Sensor s : sensorList) {
            Log.d("sensor","Name=" + s.getName());
            Log.d("sensor","Vendor=" + s.getVendor());
            Log.d("sensor","Version=" + s.getVersion());
            Log.d("sensor","MaximumRange=" + s.getMaximumRange());
            Log.d("sensor","MinDelay=" + s.getMinDelay());
            Log.d("sensor","Power=" + s.getPower());
            Log.d("sensor","Type=" + s.getType());
        }
    }
}
