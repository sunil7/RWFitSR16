package k9;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* loaded from: classes.dex */
public final class c implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f15529a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f15530b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f15531c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f15532d = new float[3];
    public final Display e;

    /* renamed from: f, reason: collision with root package name */
    public final b[] f15533f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15534g;

    public c(Display display, b... bVarArr) {
        this.e = display;
        this.f15533f = bVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i3) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i3;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f15529a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.e.getRotation();
        float[] fArr3 = this.f15530b;
        if (rotation != 0) {
            int i10 = 129;
            if (rotation != 1) {
                i3 = 130;
                if (rotation != 2) {
                    if (rotation != 3) {
                        throw new IllegalStateException();
                    }
                    i10 = 130;
                    i3 = 1;
                }
            } else {
                i3 = 129;
                i10 = 2;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i10, i3, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, 131, fArr3);
        float[] fArr4 = this.f15532d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f2 = fArr4[2];
        Matrix.rotateM(fArr2, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        boolean z5 = this.f15534g;
        float[] fArr5 = this.f15531c;
        if (!z5) {
            a2.g.e(fArr5, fArr2);
            this.f15534g = true;
        }
        System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr2, 0, fArr3, 0, fArr5, 0);
        b[] bVarArr = this.f15533f;
        for (int i11 = 0; i11 < 2; i11++) {
            bVarArr[i11].a(f2, fArr2);
        }
    }
}
