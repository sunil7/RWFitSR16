package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;

/* loaded from: classes.dex */
public class AmapSensorManager implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private Context f6659a;

    /* renamed from: b, reason: collision with root package name */
    SensorManager f6660b;

    /* renamed from: c, reason: collision with root package name */
    Sensor f6661c;

    /* renamed from: d, reason: collision with root package name */
    Sensor f6662d;
    Sensor e;
    public boolean isRegisterSensorEventListener = false;
    public double mAltitude = 0.0d;
    public float mPressure = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f6663f = 1013.25f;

    /* renamed from: g, reason: collision with root package name */
    private float f6664g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    Handler f6665h = new Handler();

    /* renamed from: i, reason: collision with root package name */
    double f6666i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    double f6667j = 0.0d;

    /* renamed from: k, reason: collision with root package name */
    double f6668k = 0.0d;

    /* renamed from: l, reason: collision with root package name */
    double f6669l = 0.0d;

    /* renamed from: m, reason: collision with root package name */
    double[] f6670m = new double[3];

    /* renamed from: n, reason: collision with root package name */
    volatile double f6671n = 0.0d;

    /* renamed from: o, reason: collision with root package name */
    long f6672o = 0;

    /* renamed from: p, reason: collision with root package name */
    long f6673p = 0;

    public AmapSensorManager(Context context) {
        this.f6659a = null;
        this.f6660b = null;
        this.f6661c = null;
        this.f6662d = null;
        this.e = null;
        try {
            this.f6659a = context;
            if (this.f6660b == null) {
                this.f6660b = (SensorManager) context.getSystemService("sensor");
            }
            try {
                this.f6661c = this.f6660b.getDefaultSensor(6);
            } catch (Throwable unused) {
            }
            try {
                this.f6662d = this.f6660b.getDefaultSensor(11);
            } catch (Throwable unused2) {
            }
            try {
                this.e = this.f6660b.getDefaultSensor(1);
            } catch (Throwable unused3) {
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapSensorManager", "<init>");
        }
    }

    private void a(float[] fArr) {
        double[] dArr = this.f6670m;
        double d5 = dArr[0] * 0.800000011920929d;
        float f2 = fArr[0];
        double d8 = d5 + (f2 * 0.19999999f);
        dArr[0] = d8;
        double d10 = dArr[1] * 0.800000011920929d;
        float f10 = fArr[1];
        double d11 = d10 + (f10 * 0.19999999f);
        dArr[1] = d11;
        double d12 = dArr[2] * 0.800000011920929d;
        float f11 = fArr[2];
        double d13 = d12 + (0.19999999f * f11);
        dArr[2] = d13;
        this.f6666i = f2 - d8;
        this.f6667j = f10 - d11;
        this.f6668k = f11 - d13;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6672o < 100) {
            return;
        }
        double d14 = this.f6666i;
        double d15 = this.f6667j;
        double d16 = (d15 * d15) + (d14 * d14);
        double d17 = this.f6668k;
        double sqrt = Math.sqrt((d17 * d17) + d16);
        this.f6673p++;
        this.f6672o = currentTimeMillis;
        this.f6671n += sqrt;
        if (this.f6673p >= 30) {
            this.f6669l = this.f6671n / this.f6673p;
            this.f6671n = 0.0d;
            this.f6673p = 0L;
        }
    }

    public void destroy() {
        try {
            stopListener();
            this.f6661c = null;
            this.f6662d = null;
            this.f6660b = null;
            this.e = null;
            this.isRegisterSensorEventListener = false;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapSensorManager", "destroy");
        }
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.f6664g;
    }

    public float getPressure() {
        return this.mPressure;
    }

    public double getSpeed() {
        return this.f6669l;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (this.e != null) {
                    a((float[]) sensorEvent.values.clone());
                    return;
                }
                return;
            }
            if (type == 6) {
                if (this.f6661c != null) {
                    this.mPressure = ((float[]) sensorEvent.values.clone())[0];
                    this.mAltitude = Utils.formatFloatKeep2Point(SensorManager.getAltitude(this.f6663f, r4));
                    return;
                }
                return;
            }
            if (type == 11 && this.f6662d != null) {
                float[] fArr = new float[9];
                SensorManager.getRotationMatrixFromVector(fArr, (float[]) sensorEvent.values.clone());
                SensorManager.getOrientation(fArr, new float[3]);
                float degrees = (float) Math.toDegrees(r4[0]);
                this.f6664g = degrees;
                if (degrees <= 0.0f) {
                    degrees += 360.0f;
                }
                this.f6664g = (float) Math.floor(degrees);
            }
        } catch (Throwable unused) {
        }
    }

    public void startListener() {
        SensorManager sensorManager = this.f6660b;
        if (sensorManager == null || this.isRegisterSensorEventListener) {
            return;
        }
        this.isRegisterSensorEventListener = true;
        try {
            Sensor sensor = this.f6661c;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3, this.f6665h);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapSensorManager", "registerListener mPressure");
        }
        try {
            Sensor sensor2 = this.f6662d;
            if (sensor2 != null) {
                this.f6660b.registerListener(this, sensor2, 3, this.f6665h);
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "AMapSensorManager", "registerListener mRotationVector");
        }
        try {
            Sensor sensor3 = this.e;
            if (sensor3 != null) {
                this.f6660b.registerListener(this, sensor3, 3, this.f6665h);
            }
        } catch (Throwable th4) {
            CoreUtil.reportError(th4, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        }
    }

    public void stopListener() {
        SensorManager sensorManager = this.f6660b;
        if (sensorManager == null || !this.isRegisterSensorEventListener) {
            return;
        }
        this.isRegisterSensorEventListener = false;
        try {
            Sensor sensor = this.f6661c;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
        } catch (Throwable unused) {
        }
        try {
            Sensor sensor2 = this.f6662d;
            if (sensor2 != null) {
                this.f6660b.unregisterListener(this, sensor2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Sensor sensor3 = this.e;
            if (sensor3 != null) {
                this.f6660b.unregisterListener(this, sensor3);
            }
        } catch (Throwable unused3) {
        }
    }
}
