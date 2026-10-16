package t0;

import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.pf;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public pf f18462a;

    /* renamed from: b, reason: collision with root package name */
    public String f18463b;

    /* renamed from: c, reason: collision with root package name */
    public float[] f18464c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18465d;
    public long e;

    /* renamed from: f, reason: collision with root package name */
    public float f18466f;

    public p() {
        this.f18464c = new float[3];
        this.f18465d = false;
        this.f18466f = Float.NaN;
    }

    public final float a(float f2, long j4, View view, p0.e eVar) {
        float[] fArr = this.f18464c;
        this.f18462a.d(f2, fArr);
        boolean z5 = true;
        float f10 = fArr[1];
        if (f10 == 0.0f) {
            this.f18465d = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f18466f)) {
            float c9 = eVar.c(view, this.f18463b);
            this.f18466f = c9;
            if (Float.isNaN(c9)) {
                this.f18466f = 0.0f;
            }
        }
        float f11 = (float) (((((j4 - this.e) * 1.0E-9d) * f10) + this.f18466f) % 1.0d);
        this.f18466f = f11;
        String str = this.f18463b;
        HashMap hashMap = (HashMap) eVar.f17314b;
        if (hashMap.containsKey(view)) {
            HashMap hashMap2 = (HashMap) hashMap.get(view);
            if (hashMap2 == null) {
                hashMap2 = new HashMap();
            }
            if (hashMap2.containsKey(str)) {
                float[] fArr2 = (float[]) hashMap2.get(str);
                if (fArr2 == null) {
                    fArr2 = new float[0];
                }
                if (fArr2.length <= 0) {
                    fArr2 = Arrays.copyOf(fArr2, 1);
                }
                fArr2[0] = f11;
                hashMap2.put(str, fArr2);
            } else {
                hashMap2.put(str, new float[]{f11});
                hashMap.put(view, hashMap2);
            }
        } else {
            HashMap hashMap3 = new HashMap();
            hashMap3.put(str, new float[]{f11});
            hashMap.put(view, hashMap3);
        }
        this.e = j4;
        float f12 = fArr[0];
        float sin = (((float) Math.sin(this.f18466f * 6.2831855f)) * f12) + fArr[2];
        if (f12 == 0.0f && f10 == 0.0f) {
            z5 = false;
        }
        this.f18465d = z5;
        return sin;
    }

    public abstract boolean b(float f2, long j4, View view, p0.e eVar);

    public void c(int i3) {
        System.err.println("Error no points added to " + this.f18463b);
    }

    public final String toString() {
        String str = this.f18463b;
        new DecimalFormat("##.##");
        return str;
    }
}
