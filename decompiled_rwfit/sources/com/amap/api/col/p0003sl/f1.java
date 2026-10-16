package com.amap.api.col.p0003sl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
public class f1 implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f4053a;

    /* renamed from: b, reason: collision with root package name */
    private Sensor f4054b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f4055c;

    /* renamed from: d, reason: collision with root package name */
    private Sensor f4056d;
    private Context e;

    /* renamed from: f, reason: collision with root package name */
    private IAMapDelegate f4057f;

    /* renamed from: g, reason: collision with root package name */
    private Marker f4058g;

    /* renamed from: h, reason: collision with root package name */
    private float f4059h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f4060i = new float[3];

    /* renamed from: j, reason: collision with root package name */
    private float[] f4061j = new float[3];

    /* renamed from: k, reason: collision with root package name */
    private float[] f4062k = new float[3];

    /* renamed from: l, reason: collision with root package name */
    private float[] f4063l = new float[9];

    /* renamed from: m, reason: collision with root package name */
    private boolean f4064m = true;

    /* renamed from: n, reason: collision with root package name */
    private int f4065n = 0;

    public f1(Context context, IAMapDelegate iAMapDelegate) {
        this.e = context.getApplicationContext();
        this.f4057f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f4053a = sensorManager;
            if (sensorManager != null && a()) {
                this.f4054b = this.f4053a.getDefaultSensor(3);
            } else {
                this.f4055c = this.f4053a.getDefaultSensor(1);
                this.f4056d = this.f4053a.getDefaultSensor(2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private boolean a() {
        SensorManager sensorManager = this.f4053a;
        if (sensorManager == null) {
            return false;
        }
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            int type = sensor.getType();
            sensor.getStringType();
            if (type == 3) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f4053a;
        if (sensorManager != null && (sensor2 = this.f4054b) != null) {
            sensorManager.registerListener(this, sensor2, 2);
        }
        SensorManager sensorManager2 = this.f4053a;
        if (sensorManager2 == null || (sensor = this.f4055c) == null || this.f4056d == null) {
            return;
        }
        sensorManager2.registerListener(this, sensor, 2);
        this.f4053a.registerListener(this, this.f4056d, 2);
    }

    public void c() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f4053a;
        if (sensorManager != null && (sensor2 = this.f4054b) != null) {
            sensorManager.unregisterListener(this, sensor2);
        }
        SensorManager sensorManager2 = this.f4053a;
        if (sensorManager2 == null || (sensor = this.f4055c) == null || this.f4056d == null) {
            return;
        }
        sensorManager2.unregisterListener(this, sensor);
        this.f4053a.unregisterListener(this, this.f4056d);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (this.f4057f.getGLMapEngine() == null || this.f4057f.getGLMapEngine().getAnimateionsCount() <= 0) {
                int type = sensorEvent.sensor.getType();
                float f2 = 0.0f;
                int i3 = 0;
                if (type != 3) {
                    if (type == 1) {
                        this.f4060i = (float[]) sensorEvent.values.clone();
                    } else if (type == 2) {
                        this.f4061j = (float[]) sensorEvent.values.clone();
                    }
                    if (SensorManager.getRotationMatrix(this.f4063l, null, this.f4060i, this.f4061j)) {
                        SensorManager.getOrientation(this.f4063l, this.f4062k);
                        this.f4062k[0] = (float) Math.toDegrees(r8[0]);
                        f2 = this.f4062k[0];
                    }
                    if (Math.abs(this.f4059h - f2) < 3.0f) {
                        return;
                    }
                    this.f4059h = f2;
                    a(f2);
                    return;
                }
                float f10 = sensorEvent.values[0];
                try {
                    int i10 = this.f4065n;
                    if (i10 == 1) {
                        i3 = 90;
                    } else if (i10 == 2) {
                        i3 = 180;
                    } else if (i10 == 3) {
                        i3 = -90;
                    }
                } catch (Throwable unused) {
                }
                float f11 = (i3 + f10) % 360.0f;
                if (f11 > 180.0f) {
                    f11 -= 360.0f;
                } else if (f11 < -180.0f) {
                    f11 += 360.0f;
                }
                if (!Float.isNaN(f11)) {
                    f2 = f11;
                }
                if (Math.abs(this.f4059h - f10) < 3.0f) {
                    return;
                }
                this.f4059h = f2;
                a(f2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(Marker marker) {
        this.f4058g = marker;
    }

    public void a(boolean z5) {
        this.f4064m = z5;
    }

    private void a(float f2) {
        Marker marker = this.f4058g;
        if (marker != null) {
            try {
                if (this.f4064m) {
                    this.f4057f.moveCamera(x.a(f2));
                    this.f4058g.setRotateAngle(-f2);
                } else {
                    marker.setRotateAngle(360.0f - f2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void a(int i3) {
        this.f4065n = i3;
    }
}
