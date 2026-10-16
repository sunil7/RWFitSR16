package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.amap.api.col.p0003sl.f4;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.aps.amapapi.config.Const;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import m0.e;

/* loaded from: classes.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 200;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private f4 mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private com.amap.api.maps.model.a mTree;

    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 12;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.data;
            if (collection != null && collection.size() != 0) {
                try {
                    return new HeatmapTileProvider(this);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return null;
                }
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e) {
                Log.e(Const.STR_PUBLIC_TAG, e.getErrorMessage());
                e.printStackTrace();
                return null;
            }
        }

        public Builder data(Collection<LatLng> collection) {
            int i3 = HeatmapTileProvider.DEFAULT_RADIUS;
            ArrayList arrayList = new ArrayList();
            Iterator<LatLng> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(new WeightedLatLng(it.next()));
            }
            return weightedData(arrayList);
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder radius(int i3) {
            this.radius = Math.max(10, Math.min(i3, 200));
            return this;
        }

        public Builder transparency(double d5) {
            this.opacity = Math.max(0.0d, Math.min(d5, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                double d5 = weightedLatLng.latLng.latitude;
                if (d5 < 85.0d && d5 > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            f4 a3 = a(arrayList);
            this.mBounds = a3;
            this.mTree = new com.amap.api.maps.model.a(a3);
            Iterator<WeightedLatLng> it = this.mData.iterator();
            while (it.hasNext()) {
                this.mTree.a(it.next());
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i3, int i10, int i11) {
        double d5;
        double pow = 1.0d / Math.pow(2.0d, i11);
        double d8 = (this.mRadius * pow) / 256.0d;
        int i12 = 2;
        double d10 = ((d8 * 2.0d) + pow) / ((r10 * 2) + 256);
        double d11 = (i3 * pow) - d8;
        boolean z5 = true;
        double d12 = ((i3 + 1) * pow) + d8;
        double d13 = (i10 * pow) - d8;
        double d14 = ((i10 + 1) * pow) + d8;
        Collection<WeightedLatLng> arrayList = new ArrayList<>();
        if (d11 < 0.0d) {
            arrayList = this.mTree.a(new f4(d11 + 1.0d, 1.0d, d13, d14));
            d5 = -1.0d;
        } else if (d12 > 1.0d) {
            arrayList = this.mTree.a(new f4(0.0d, d12 - 1.0d, d13, d14));
            d5 = 1.0d;
        } else {
            d5 = 0.0d;
        }
        f4 f4Var = new f4(d11, d12, d13, d14);
        f4 f4Var2 = this.mBounds;
        if (!f4Var.a(new f4(f4Var2.f4071a - d8, f4Var2.f4073c + d8, f4Var2.f4072b - d8, f4Var2.f4074d + d8))) {
            return TileProvider.NO_TILE;
        }
        ArrayList arrayList2 = (ArrayList) this.mTree.a(f4Var);
        if (arrayList2.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        int i13 = (this.mRadius * 2) + 256;
        int[] iArr = {i13, i13};
        int i14 = 0;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr);
        int size = arrayList2.size();
        int i15 = 0;
        while (i15 < size) {
            Object obj = arrayList2.get(i15);
            i15++;
            boolean z6 = z5;
            WeightedLatLng weightedLatLng = (WeightedLatLng) obj;
            int i16 = i14;
            DPoint point = weightedLatLng.getPoint();
            int i17 = (int) ((point.f6570x - d11) / d10);
            Collection<WeightedLatLng> collection = arrayList;
            ArrayList arrayList3 = arrayList2;
            int i18 = (int) ((point.f6571y - d13) / d10);
            double[] dArr2 = dArr[i17];
            dArr2[i18] = dArr2[i18] + weightedLatLng.intensity;
            arrayList = collection;
            i14 = i16;
            z5 = z6;
            arrayList2 = arrayList3;
        }
        boolean z8 = z5;
        int i19 = i14;
        for (Iterator<WeightedLatLng> it = arrayList.iterator(); it.hasNext(); it = it) {
            WeightedLatLng next = it.next();
            DPoint point2 = next.getPoint();
            int i20 = (int) (((point2.f6570x + d5) - d11) / d10);
            int i21 = (int) ((point2.f6571y - d13) / d10);
            double[] dArr3 = dArr[i20];
            dArr3[i21] = dArr3[i21] + next.intensity;
        }
        double[] dArr4 = this.mKernel;
        int floor = (int) Math.floor(dArr4.length / 2.0d);
        int length = dArr.length;
        int i22 = length - (floor * 2);
        int i23 = floor + i22;
        int i24 = i23 - 1;
        int[] iArr2 = new int[2];
        iArr2[z8 ? 1 : 0] = length;
        iArr2[i19] = length;
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        int i25 = i19;
        while (i25 < length) {
            for (int i26 = i19; i26 < length; i26++) {
                double d15 = dArr[i25][i26];
                if (d15 != 0.0d) {
                    int i27 = i25 + floor;
                    if (i24 < i27) {
                        i27 = i24;
                    }
                    int i28 = i27 + 1;
                    int i29 = i25 - floor;
                    for (int i30 = floor > i29 ? floor : i29; i30 < i28; i30++) {
                        double[] dArr6 = dArr5[i30];
                        dArr6[i26] = (dArr4[i30 - i29] * d15) + dArr6[i26];
                    }
                }
            }
            i25++;
            i12 = 2;
        }
        int[] iArr3 = new int[i12];
        iArr3[z8 ? 1 : 0] = i22;
        iArr3[i19] = i22;
        double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) cls, iArr3);
        for (int i31 = floor; i31 < i23; i31++) {
            for (int i32 = i19; i32 < length; i32++) {
                double d16 = dArr5[i31][i32];
                if (d16 != 0.0d) {
                    int i33 = i32 + floor;
                    if (i24 < i33) {
                        i33 = i24;
                    }
                    int i34 = i33 + 1;
                    int i35 = i32 - floor;
                    for (int i36 = floor > i35 ? floor : i35; i36 < i34; i36++) {
                        double[] dArr8 = dArr7[i31 - floor];
                        int i37 = i36 - floor;
                        dArr8[i37] = (dArr4[i36 - i35] * d16) + dArr8[i37];
                    }
                }
            }
        }
        int[] iArr4 = this.mColorMap;
        double d17 = this.mMaxIntensity[i11];
        int i38 = iArr4[iArr4.length - 1];
        double length2 = (iArr4.length - 1) / d17;
        int length3 = dArr7.length;
        int[] iArr5 = new int[length3 * length3];
        int i39 = i19;
        while (i39 < length3) {
            int i40 = i19;
            while (i40 < length3) {
                double d18 = dArr7[i40][i39];
                int i41 = (i39 * length3) + i40;
                int i42 = i38;
                int i43 = i39;
                int i44 = (int) (d18 * length2);
                if (d18 == 0.0d) {
                    iArr5[i41] = i19;
                } else if (i44 < iArr4.length) {
                    iArr5[i41] = iArr4[i44];
                } else {
                    iArr5[i41] = i42;
                }
                i40++;
                i38 = i42;
                i39 = i43;
            }
            i39++;
        }
        Bitmap createBitmap = Bitmap.createBitmap(length3, length3, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr5, 0, length3, 0, 0, length3, length3);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        Gradient gradient = builder.gradient;
        this.mGradient = gradient;
        if (gradient == null || !gradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i3 = this.mRadius;
        this.mKernel = a(i3, i3 / 3.0d);
        a(this.mGradient);
        b(this.mData);
    }

    private double[] a(int i3) {
        int i10;
        HeatmapTileProvider heatmapTileProvider = this;
        int i11 = 21;
        double[] dArr = new double[21];
        int i12 = 5;
        while (true) {
            if (i12 >= 11) {
                break;
            }
            Collection<WeightedLatLng> collection = heatmapTileProvider.mData;
            f4 f4Var = heatmapTileProvider.mBounds;
            int pow = (int) (Math.pow(2.0d, i12) * 1280.0d);
            double d5 = f4Var.f4071a;
            double d8 = f4Var.f4073c;
            double d10 = f4Var.f4072b;
            double d11 = d8 - d5;
            double d12 = f4Var.f4074d - d10;
            if (d11 <= d12) {
                d11 = d12;
            }
            double d13 = ((int) ((pow / (i3 * 2)) + 0.5d)) / d11;
            e eVar = new e();
            double d14 = 0.0d;
            for (WeightedLatLng weightedLatLng : collection) {
                double d15 = weightedLatLng.getPoint().f6570x;
                int i13 = i12;
                int i14 = (int) ((weightedLatLng.getPoint().f6571y - d10) * d13);
                long j4 = (int) ((d15 - d5) * d13);
                e eVar2 = (e) eVar.c(j4, null);
                if (eVar2 == null) {
                    eVar2 = new e();
                    eVar.d(j4, eVar2);
                }
                long j10 = i14;
                Double d16 = (Double) eVar2.c(j10, null);
                if (d16 == null) {
                    d16 = Double.valueOf(0.0d);
                }
                double doubleValue = d16.doubleValue() + weightedLatLng.intensity;
                eVar2.d(j10, Double.valueOf(doubleValue));
                if (doubleValue > d14) {
                    i12 = i13;
                    d14 = doubleValue;
                } else {
                    i12 = i13;
                }
            }
            int i15 = i12;
            dArr[i15] = d14;
            if (i15 == 5) {
                for (int i16 = 0; i16 < i15; i16++) {
                    dArr[i16] = dArr[i15];
                }
            }
            i12 = i15 + 1;
            heatmapTileProvider = this;
            i11 = 21;
        }
        int i17 = i11;
        for (i10 = 11; i10 < i17; i10++) {
            dArr[i10] = dArr[10];
        }
        return dArr;
    }

    public static f4 a(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d5 = next.getPoint().f6570x;
        double d8 = next.getPoint().f6570x;
        double d10 = d5;
        double d11 = d8;
        double d12 = next.getPoint().f6571y;
        double d13 = next.getPoint().f6571y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d14 = next2.getPoint().f6570x;
            double d15 = next2.getPoint().f6571y;
            if (d14 < d10) {
                d10 = d14;
            }
            if (d14 > d11) {
                d11 = d14;
            }
            if (d15 < d12) {
                d12 = d15;
            }
            if (d15 > d13) {
                d13 = d15;
            }
        }
        return new f4(d10, d11, d12, d13);
    }

    public static double[] a(int i3, double d5) {
        double[] dArr = new double[(i3 * 2) + 1];
        for (int i10 = -i3; i10 <= i3; i10++) {
            dArr[i10 + i3] = Math.exp(((-i10) * i10) / ((2.0d * d5) * d5));
        }
        return dArr;
    }
}
