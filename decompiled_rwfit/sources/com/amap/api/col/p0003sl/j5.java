package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.google.android.exoplayer2.PlaybackException;

/* loaded from: classes.dex */
public class j5 extends View {

    /* renamed from: a, reason: collision with root package name */
    private String f4320a;

    /* renamed from: b, reason: collision with root package name */
    private int f4321b;

    /* renamed from: c, reason: collision with root package name */
    private IAMapDelegate f4322c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f4323d;
    private Paint e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f4324f;

    /* renamed from: g, reason: collision with root package name */
    private IPoint f4325g;

    /* renamed from: h, reason: collision with root package name */
    private float f4326h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f4327i;

    public j5(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f4320a = "";
        this.f4321b = 0;
        this.f4326h = 0.0f;
        this.f4327i = new int[]{10000000, 5000000, 2000000, PlaybackException.CUSTOM_ERROR_CODE_BASE, 500000, 200000, 100000, 50000, Const.I_LOC_JUMP_DELAY, Const.I_CITY_TILE_LEN, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.f4322c = iAMapDelegate;
        this.f4323d = new Paint();
        this.f4324f = new Rect();
        this.f4323d.setAntiAlias(true);
        this.f4323d.setColor(-16777216);
        this.f4323d.setStrokeWidth(v0.f5167b * 2.0f);
        this.f4323d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(-16777216);
        this.e.setTextSize(v0.f5167b * 20.0f);
        this.f4326h = s4.a(context, 1.0f);
        this.f4325g = new IPoint();
    }

    public void a(boolean z5) {
        if (z5) {
            setVisibility(0);
            a();
        } else {
            this.f4320a = "";
            this.f4321b = 0;
            setVisibility(8);
        }
    }

    public void b() {
        this.f4323d = null;
        this.e = null;
        this.f4324f = null;
        this.f4320a = null;
        this.f4325g = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Point waterMarkerPositon;
        String str = this.f4320a;
        if (str == null || "".equals(str) || this.f4321b == 0 || (waterMarkerPositon = this.f4322c.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.e;
        String str2 = this.f4320a;
        paint.getTextBounds(str2, 0, str2.length(), this.f4324f);
        int i3 = waterMarkerPositon.x;
        int height = (waterMarkerPositon.y - this.f4324f.height()) + 5;
        canvas.drawText(this.f4320a, ((this.f4321b - this.f4324f.width()) / 2) + i3, height, this.e);
        float f2 = i3;
        float height2 = (this.f4324f.height() - 5) + height;
        canvas.drawLine(f2, height2 - (this.f4326h * 2.0f), f2, height2 + v0.f5167b, this.f4323d);
        canvas.drawLine(f2, height2, this.f4321b + i3, height2, this.f4323d);
        float f10 = i3 + this.f4321b;
        canvas.drawLine(f10, height2 - (this.f4326h * 2.0f), f10, height2 + v0.f5167b, this.f4323d);
    }

    public void a() {
        String str;
        IAMapDelegate iAMapDelegate = this.f4322c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.f4322c.getPreciseLevel(engineIDWithType);
            this.f4322c.getGeoCenter(engineIDWithType, this.f4325g);
            if (this.f4325g == null) {
                return;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) r0).x, ((Point) r0).y, 20);
            float mapZoomScale = this.f4322c.getMapZoomScale();
            double cos = (float) ((((Math.cos((pixelsToLatLong.f6571y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d));
            int i3 = this.f4327i[(int) preciseLevel];
            int i10 = (int) (i3 / (cos * mapZoomScale));
            int i11 = v4.f5181b;
            if (i3 < 1000) {
                str = i3 + "m";
            } else {
                str = (i3 / 1000) + "km";
            }
            this.f4321b = i10;
            this.f4320a = str;
            pixelsToLatLong.recycle();
            invalidate();
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th2.printStackTrace();
        }
    }
}
