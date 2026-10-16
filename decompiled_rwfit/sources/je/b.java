package je;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: classes.dex */
public final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final SensorManager f15416a;

    /* renamed from: b, reason: collision with root package name */
    public final Sensor f15417b;

    /* renamed from: c, reason: collision with root package name */
    public long f15418c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15419d;
    public a e;

    public b(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f15416a = sensorManager;
        this.f15417b = sensorManager.getDefaultSensor(5);
        this.f15419d = true;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i3) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f15419d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f15418c < 150) {
                return;
            }
            this.f15418c = currentTimeMillis;
            a aVar = this.e;
            if (aVar != null) {
                float f2 = sensorEvent.values[0];
                if (f2 <= 45.0f) {
                    ((fe.b) aVar).a(true);
                } else if (f2 >= 100.0f) {
                    ((fe.b) aVar).a(false);
                }
            }
        }
    }

    public void setOnLightSensorEventListener(a aVar) {
        this.e = aVar;
    }
}
