package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class l5 extends View {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f4446a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f4447b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f4448c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f4449d;
    private Bitmap e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f4450f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f4451g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4452h;

    /* renamed from: i, reason: collision with root package name */
    private int f4453i;

    /* renamed from: j, reason: collision with root package name */
    private int f4454j;

    /* renamed from: k, reason: collision with root package name */
    private int f4455k;

    /* renamed from: l, reason: collision with root package name */
    private int f4456l;

    /* renamed from: m, reason: collision with root package name */
    private int f4457m;

    /* renamed from: n, reason: collision with root package name */
    private int f4458n;

    /* renamed from: o, reason: collision with root package name */
    private int f4459o;

    /* renamed from: p, reason: collision with root package name */
    private int f4460p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f4461q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private Context f4462s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4463t;

    /* renamed from: u, reason: collision with root package name */
    private float f4464u;

    /* renamed from: v, reason: collision with root package name */
    private float f4465v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f4466w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f4467x;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x011b -> B:15:0x011e). Please report as a decompilation issue!!! */
    public l5(Context context) {
        super(context);
        InputStream inputStream;
        InputStream open;
        this.f4451g = new Paint();
        this.f4452h = false;
        this.f4453i = 0;
        this.f4454j = 0;
        this.f4455k = 0;
        this.f4456l = 10;
        this.f4457m = 0;
        this.f4458n = 0;
        this.f4459o = 10;
        this.f4460p = 8;
        this.f4461q = false;
        this.r = false;
        this.f4463t = true;
        this.f4464u = 0.0f;
        this.f4465v = 0.0f;
        this.f4466w = true;
        this.f4467x = false;
        InputStream inputStream2 = null;
        try {
            try {
                this.f4462s = context.getApplicationContext();
                open = MapsInitializer.getRegionLanguageType() != 0 ? s4.a(context).open("ap_en.data") : s4.a(context).open("ap.data");
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                this.e = decodeStream;
                this.f4446a = v4.a(decodeStream, v0.f5167b);
                open.close();
                inputStream2 = MapsInitializer.getRegionLanguageType() != 0 ? s4.a(context).open("ap1_en.data") : s4.a(context).open("ap1.data");
                Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream2);
                this.f4450f = decodeStream2;
                this.f4447b = v4.a(decodeStream2, v0.f5167b);
                inputStream2.close();
                this.f4454j = this.f4447b.getWidth();
                this.f4453i = this.f4447b.getHeight();
                this.f4451g.setAntiAlias(true);
                this.f4451g.setColor(-16777216);
                this.f4451g.setStyle(Paint.Style.STROKE);
                AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = context.getFilesDir() + "/icon_web_day.data";
                AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = context.getFilesDir() + "/icon_web_night.data";
                u4.b().a(new k5(this));
                try {
                    open.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                inputStream2.close();
            } catch (Throwable th4) {
                th = th4;
                inputStream = inputStream2;
                inputStream2 = open;
                try {
                    ka.a(th, "WaterMarkerView", "create");
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } finally {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
    }

    public void d(int i3) {
        this.f4458n = 0;
        this.f4455k = i3;
        e();
    }

    public void e() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        a();
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        try {
            if (this.f4463t && getWidth() != 0 && getHeight() != 0 && this.f4447b != null) {
                if (!this.f4461q) {
                    a();
                    this.f4461q = true;
                }
                if (this.f4452h) {
                    if (!this.r || (bitmap = this.f4449d) == null) {
                        bitmap = this.f4447b;
                    }
                } else if (!this.r || (bitmap = this.f4448c) == null) {
                    bitmap = this.f4446a;
                }
                canvas.drawBitmap(bitmap, this.f4456l, this.f4457m, this.f4451g);
            }
        } catch (Throwable th2) {
            ka.a(th2, "WaterMarkerView", "onDraw");
            th2.printStackTrace();
        }
    }

    public void a(boolean z5) {
        if (this.f4463t) {
            try {
                this.f4452h = z5;
                if (z5) {
                    this.f4451g.setColor(-1);
                } else {
                    this.f4451g.setColor(-16777216);
                }
            } catch (Throwable th2) {
                ka.a(th2, "WaterMarkerView", "changeBitmap");
                th2.printStackTrace();
            }
        }
    }

    public void b() {
        try {
            Bitmap bitmap = this.f4446a;
            if (bitmap != null) {
                v4.a(bitmap);
                this.f4446a = null;
            }
            Bitmap bitmap2 = this.f4447b;
            if (bitmap2 != null) {
                v4.a(bitmap2);
                this.f4447b = null;
            }
            this.f4446a = null;
            this.f4447b = null;
            Bitmap bitmap3 = this.e;
            if (bitmap3 != null) {
                v4.a(bitmap3);
                this.e = null;
            }
            Bitmap bitmap4 = this.f4450f;
            if (bitmap4 != null) {
                v4.a(bitmap4);
                this.f4450f = null;
            }
            Bitmap bitmap5 = this.f4448c;
            if (bitmap5 != null) {
                v4.a(bitmap5);
            }
            this.f4448c = null;
            Bitmap bitmap6 = this.f4449d;
            if (bitmap6 != null) {
                v4.a(bitmap6);
            }
            this.f4449d = null;
            this.f4451g = null;
        } catch (Throwable th2) {
            ka.a(th2, "WaterMarkerView", "destory");
            th2.printStackTrace();
        }
    }

    public Point c() {
        return new Point(this.f4456l, this.f4457m - 2);
    }

    public void c(int i3) {
        this.f4458n = 1;
        this.f4459o = i3;
        e();
    }

    public void d(boolean z5) {
        this.f4463t = z5;
    }

    public boolean d() {
        return this.f4452h;
    }

    public void c(boolean z5) {
        if (this.f4463t && this.r != z5) {
            this.r = z5;
            if (z5) {
                if (this.f4452h) {
                    Bitmap bitmap = this.f4449d;
                    if (bitmap != null) {
                        this.f4454j = bitmap.getWidth();
                        this.f4453i = this.f4449d.getHeight();
                        return;
                    }
                    return;
                }
                Bitmap bitmap2 = this.f4448c;
                if (bitmap2 != null) {
                    this.f4454j = bitmap2.getWidth();
                    this.f4453i = this.f4448c.getHeight();
                    return;
                }
                return;
            }
            this.f4454j = this.f4446a.getWidth();
            this.f4453i = this.f4446a.getHeight();
        }
    }

    public float a(int i3) {
        float f2;
        if (!this.f4463t) {
            return 0.0f;
        }
        if (i3 == 0) {
            return this.f4464u;
        }
        if (i3 == 1) {
            f2 = this.f4464u;
        } else {
            if (i3 != 2) {
                return 0.0f;
            }
            f2 = this.f4465v;
        }
        return 1.0f - f2;
    }

    public void a(int i3, float f2) {
        if (this.f4463t) {
            this.f4458n = 2;
            float max = Math.max(0.0f, Math.min(f2, 1.0f));
            if (i3 == 0) {
                this.f4464u = max;
                this.f4466w = true;
            } else if (i3 == 1) {
                this.f4464u = 1.0f - max;
                this.f4466w = false;
            } else if (i3 == 2) {
                this.f4465v = 1.0f - max;
            }
            e();
        }
    }

    private void a() {
        int i3 = this.f4458n;
        if (i3 == 0) {
            int i10 = this.f4455k;
            if (i10 == 1) {
                this.f4459o = (getWidth() - this.f4454j) / 2;
            } else if (i10 == 2) {
                this.f4459o = (getWidth() - this.f4454j) - 10;
            } else {
                this.f4459o = 10;
            }
            this.f4460p = 8;
        } else if (i3 == 2) {
            if (this.f4466w) {
                this.f4459o = (int) (getWidth() * this.f4464u);
            } else {
                this.f4459o = (int) ((getWidth() * this.f4464u) - this.f4454j);
            }
            this.f4460p = (int) (getHeight() * this.f4465v);
        }
        this.f4456l = this.f4459o;
        int height = (getHeight() - this.f4460p) - this.f4453i;
        this.f4457m = height;
        if (this.f4456l < 0) {
            this.f4456l = 0;
        }
        if (height < 0) {
            this.f4457m = 0;
        }
    }

    public void b(int i3) {
        this.f4458n = 1;
        this.f4460p = i3;
        e();
    }

    public void b(boolean z5) {
        if (this.f4463t) {
            this.f4467x = z5;
            if (z5) {
                return;
            }
            this.f4454j = this.f4446a.getWidth();
            this.f4453i = this.f4446a.getHeight();
        }
    }

    public void a(String str, int i3) {
        try {
            if (this.f4463t && new File(str).exists()) {
                if (i3 == 0) {
                    Bitmap bitmap = this.f4448c;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    this.e = decodeFile;
                    this.f4448c = v4.a(decodeFile, v0.f5167b);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    v4.a(bitmap);
                    return;
                }
                if (i3 == 1) {
                    Bitmap bitmap2 = this.f4449d;
                    Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                    this.e = decodeFile2;
                    this.f4449d = v4.a(decodeFile2, v0.f5167b);
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    v4.a(bitmap2);
                }
            }
        } catch (Throwable th2) {
            ka.a(th2, "WaterMarkerView", "create");
            th2.printStackTrace();
        }
    }
}
