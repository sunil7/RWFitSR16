package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f5731a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5732b;

        /* renamed from: c, reason: collision with root package name */
        private final float f5733c;

        private b(int i3, int i10, float f2) {
            this.f5731a = i3;
            this.f5732b = i10;
            this.f5733c = f2;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    public int[] generateColorMap(double d5) {
        HashMap hashMap = new HashMap(32);
        int i3 = 0;
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new b(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0]));
        }
        for (int i10 = 1; i10 < this.mColors.length; i10++) {
            int i11 = i10 - 1;
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i11]));
            int[] iArr = this.mColors;
            int i12 = iArr[i11];
            int i13 = iArr[i10];
            float f2 = this.mColorMapSize;
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new b(i12, i13, (fArr[i10] - fArr[i11]) * f2));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int i14 = this.mColors[length];
            hashMap.put(valueOf2, new b(i14, i14, (1.0f - this.mStartPoints[length]) * this.mColorMapSize));
        }
        int[] iArr2 = new int[this.mColorMapSize];
        b bVar = (b) hashMap.get(0);
        int i15 = 0;
        int i16 = 0;
        while (i15 < this.mColorMapSize) {
            if (hashMap.containsKey(Integer.valueOf(i15))) {
                bVar = (b) hashMap.get(Integer.valueOf(i15));
                i16 = i15;
            }
            float f10 = (i15 - i16) / bVar.f5733c;
            int i17 = bVar.f5731a;
            int i18 = bVar.f5732b;
            int alpha = (int) (((Color.alpha(i18) - Color.alpha(i17)) * f10) + Color.alpha(i17));
            float[] fArr3 = new float[3];
            Color.RGBToHSV(Color.red(i17), Color.green(i17), Color.blue(i17), fArr3);
            float[] fArr4 = new float[3];
            Color.RGBToHSV(Color.red(i18), Color.green(i18), Color.blue(i18), fArr4);
            float f11 = fArr3[i3];
            float f12 = fArr4[i3];
            float f13 = 180;
            int i19 = i3;
            if (f11 - f12 > f13) {
                fArr4[i19] = f12 + 360;
            } else if (f12 - f11 > f13) {
                fArr3[i19] = f11 + 360;
            }
            float[] fArr5 = new float[3];
            for (int i20 = i19; i20 < 3; i20++) {
                float f14 = fArr4[i20];
                float f15 = fArr3[i20];
                fArr5[i20] = l0.a(f14, f15, f10, f15);
            }
            iArr2[i15] = Color.HSVToColor(alpha, fArr5);
            i15++;
            i3 = i19;
        }
        int i21 = i3;
        if (d5 != 1.0d) {
            for (int i22 = i21; i22 < this.mColorMapSize; i22++) {
                int i23 = iArr2[i22];
                iArr2[i22] = Color.argb((int) (Color.alpha(i23) * d5), Color.red(i23), Color.green(i23), Color.blue(i23));
            }
        }
        return iArr2;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    private Gradient(int[] iArr, float[] fArr, int i3) {
        this.isAvailable = true;
        try {
            if (iArr == null || fArr == null) {
                throw new AMapException("colors and startPoints should not be null");
            }
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            }
            if (iArr.length == 0) {
                throw new AMapException("No colors have been defined");
            }
            for (int i10 = 1; i10 < fArr.length; i10++) {
                if (fArr[i10] < fArr[i10 - 1]) {
                    throw new AMapException("startPoints should be in increasing order");
                }
            }
            this.mColorMapSize = i3;
            int[] iArr2 = new int[iArr.length];
            this.mColors = iArr2;
            this.mStartPoints = new float[fArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
            this.isAvailable = true;
        } catch (AMapException e) {
            this.isAvailable = false;
            Log.e(Const.STR_PUBLIC_TAG, e.getErrorMessage());
            e.printStackTrace();
        }
    }
}
