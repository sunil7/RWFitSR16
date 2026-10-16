package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.example.baselibrary.R$dimen;
import com.example.baselibrary.R$styleable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import w4.a;
import x4.b;
import x4.c;

/* loaded from: classes.dex */
public class WheelView extends View {
    public static final String[] U = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    public float A;
    public float B;
    public float C;
    public float D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public float M;
    public long N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public final float S;
    public boolean T;

    /* renamed from: a, reason: collision with root package name */
    public DividerType f7057a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f7058b;

    /* renamed from: c, reason: collision with root package name */
    public final b f7059c;

    /* renamed from: d, reason: collision with root package name */
    public final GestureDetector f7060d;
    public a e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7061f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7062g;

    /* renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f7063h;

    /* renamed from: i, reason: collision with root package name */
    public ScheduledFuture f7064i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f7065j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f7066k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f7067l;

    /* renamed from: m, reason: collision with root package name */
    public v4.a f7068m;

    /* renamed from: n, reason: collision with root package name */
    public String f7069n;

    /* renamed from: o, reason: collision with root package name */
    public int f7070o;

    /* renamed from: p, reason: collision with root package name */
    public int f7071p;

    /* renamed from: q, reason: collision with root package name */
    public int f7072q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public float f7073s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f7074t;

    /* renamed from: u, reason: collision with root package name */
    public int f7075u;

    /* renamed from: v, reason: collision with root package name */
    public int f7076v;

    /* renamed from: w, reason: collision with root package name */
    public int f7077w;

    /* renamed from: x, reason: collision with root package name */
    public int f7078x;

    /* renamed from: y, reason: collision with root package name */
    public float f7079y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f7080z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ACTION {
        public static final ACTION CLICK;
        public static final ACTION DAGGLE;
        public static final ACTION FLING;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ACTION[] f7081a;

        static {
            ACTION action = new ACTION("CLICK", 0);
            CLICK = action;
            ACTION action2 = new ACTION("FLING", 1);
            FLING = action2;
            ACTION action3 = new ACTION("DAGGLE", 2);
            DAGGLE = action3;
            f7081a = new ACTION[]{action, action2, action3};
        }

        public static ACTION valueOf(String str) {
            return (ACTION) Enum.valueOf(ACTION.class, str);
        }

        public static ACTION[] values() {
            return (ACTION[]) f7081a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class DividerType {
        public static final DividerType CIRCLE;
        public static final DividerType FILL;
        public static final DividerType WRAP;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DividerType[] f7082a;

        static {
            DividerType dividerType = new DividerType("FILL", 0);
            FILL = dividerType;
            DividerType dividerType2 = new DividerType("WRAP", 1);
            WRAP = dividerType2;
            DividerType dividerType3 = new DividerType("CIRCLE", 2);
            CIRCLE = dividerType3;
            f7082a = new DividerType[]{dividerType, dividerType2, dividerType3};
        }

        public static DividerType valueOf(String str) {
            return (DividerType) Enum.valueOf(DividerType.class, str);
        }

        public static DividerType[] values() {
            return (DividerType[]) f7082a.clone();
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public static String b(Object obj) {
        if (obj == null) {
            return "";
        }
        if (!(obj instanceof Integer)) {
            return obj.toString();
        }
        int intValue = ((Integer) obj).intValue();
        return (intValue < 0 || intValue >= 10) ? String.valueOf(intValue) : U[intValue];
    }

    public final void a() {
        ScheduledFuture scheduledFuture = this.f7064i;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f7064i.cancel(true);
        this.f7064i = null;
    }

    public final int c(int i3) {
        return i3 < 0 ? c(this.f7068m.z() + i3) : i3 > this.f7068m.z() + (-1) ? c(i3 - this.f7068m.z()) : i3;
    }

    public final void d() {
        if (this.f7068m == null) {
            return;
        }
        Rect rect = new Rect();
        for (int i3 = 0; i3 < this.f7068m.z(); i3++) {
            String b3 = b(this.f7068m.getItem(i3));
            this.f7066k.getTextBounds(b3, 0, b3.length(), rect);
            int width = rect.width();
            if (width > this.f7071p) {
                this.f7071p = width;
            }
        }
        this.f7066k.getTextBounds("星期", 0, 2, rect);
        int height = rect.height() + 2;
        this.f7072q = height;
        float f2 = this.f7079y * height;
        this.f7073s = f2;
        this.I = (int) ((r0 * 2) / 3.141592653589793d);
        this.K = (int) (((int) (f2 * (this.H - 1))) / 3.141592653589793d);
        this.J = View.MeasureSpec.getSize(this.O);
        float f10 = this.I;
        float f11 = this.f7073s;
        this.A = (f10 - f11) / 2.0f;
        float f12 = (f10 + f11) / 2.0f;
        this.B = f12;
        this.C = (f12 - ((f11 - this.f7072q) / 2.0f)) - this.S;
        if (this.E == -1) {
            if (this.f7080z) {
                this.E = (this.f7068m.z() + 1) / 2;
            } else {
                this.E = 0;
            }
        }
        this.G = this.E;
    }

    public final void e(float f2, float f10) {
        int i3 = this.r;
        this.f7065j.setTextSkewX((i3 > 0 ? 1 : i3 < 0 ? -1 : 0) * (f10 <= 0.0f ? 1 : -1) * 0.5f * f2);
        this.f7065j.setAlpha(this.T ? (int) (((90.0f - Math.abs(f10)) / 90.0f) * 255.0f) : 255);
    }

    public final void f(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f2 = this.D;
            float f10 = this.f7073s;
            int i3 = (int) (((f2 % f10) + f10) % f10);
            this.L = i3;
            float f11 = i3;
            if (f11 > f10 / 2.0f) {
                this.L = (int) (f10 - f11);
            } else {
                this.L = -i3;
            }
        }
        this.f7064i = this.f7063h.scheduleWithFixedDelay(new c(this, this.L), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final v4.a getAdapter() {
        return this.f7068m;
    }

    public final int getCurrentItem() {
        int i3;
        v4.a aVar = this.f7068m;
        if (aVar == null) {
            return 0;
        }
        return (!this.f7080z || ((i3 = this.F) >= 0 && i3 < aVar.z())) ? Math.max(0, Math.min(this.F, this.f7068m.z() - 1)) : Math.max(0, Math.min(Math.abs(Math.abs(this.F) - this.f7068m.z()), this.f7068m.z() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f7059c;
    }

    public int getInitPosition() {
        return this.E;
    }

    public float getItemHeight() {
        return this.f7073s;
    }

    public int getItemsCount() {
        v4.a aVar = this.f7068m;
        if (aVar != null) {
            return aVar.z();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.D;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        int i3;
        float f2;
        int i10;
        boolean z5;
        int i11;
        String str;
        String str2;
        int i12;
        if (this.f7068m == null) {
            return;
        }
        int i13 = 0;
        int min = Math.min(Math.max(0, this.E), this.f7068m.z() - 1);
        this.E = min;
        try {
            this.G = min + (((int) (this.D / this.f7073s)) % this.f7068m.z());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.f7080z) {
            if (this.G < 0) {
                this.G = this.f7068m.z() + this.G;
            }
            if (this.G > this.f7068m.z() - 1) {
                this.G -= this.f7068m.z();
            }
        } else {
            if (this.G < 0) {
                this.G = 0;
            }
            if (this.G > this.f7068m.z() - 1) {
                this.G = this.f7068m.z() - 1;
            }
        }
        float f10 = this.D % this.f7073s;
        DividerType dividerType = this.f7057a;
        boolean z6 = false;
        if (dividerType == DividerType.WRAP) {
            float f11 = (TextUtils.isEmpty(this.f7069n) ? (this.J - this.f7071p) / 2 : (this.J - this.f7071p) / 4) - 12;
            float f12 = f11 <= 0.0f ? 10.0f : f11;
            float f13 = this.J - f12;
            float f14 = this.A;
            canvas2 = canvas;
            canvas2.drawLine(f12, f14, f13, f14, this.f7067l);
            float f15 = this.B;
            canvas2.drawLine(f12, f15, f13, f15, this.f7067l);
        } else if (dividerType == DividerType.CIRCLE) {
            this.f7067l.setStyle(Paint.Style.STROKE);
            this.f7067l.setStrokeWidth(this.f7078x);
            float f16 = (TextUtils.isEmpty(this.f7069n) ? (this.J - this.f7071p) / 2.0f : (this.J - this.f7071p) / 4.0f) - 12.0f;
            float f17 = f16 > 0.0f ? f16 : 10.0f;
            canvas.drawCircle(this.J / 2.0f, this.I / 2.0f, Math.max((this.J - f17) - f17, this.f7073s) / 1.8f, this.f7067l);
            canvas2 = canvas;
        } else {
            float f18 = this.A;
            canvas.drawLine(0.0f, f18, this.J, f18, this.f7067l);
            float f19 = this.B;
            canvas2 = canvas;
            canvas2.drawLine(0.0f, f19, this.J, f19, this.f7067l);
        }
        boolean isEmpty = TextUtils.isEmpty(this.f7069n);
        float f20 = this.S;
        if (!isEmpty && this.f7062g) {
            int i14 = this.J;
            Paint paint = this.f7066k;
            String str3 = this.f7069n;
            if (str3 == null || str3.length() <= 0) {
                i12 = 0;
            } else {
                int length = str3.length();
                paint.getTextWidths(str3, new float[length]);
                i12 = 0;
                for (int i15 = 0; i15 < length; i15++) {
                    i12 += (int) Math.ceil(r10[i15]);
                }
            }
            canvas2.drawText(this.f7069n, (i14 - i12) - f20, this.C, this.f7066k);
        }
        int i16 = 0;
        while (true) {
            int i17 = this.H;
            if (i16 >= i17) {
                return;
            }
            int i18 = this.G - ((i17 / 2) - i16);
            String item = this.f7080z ? this.f7068m.getItem(c(i18)) : (i18 >= 0 && i18 <= this.f7068m.z() + (-1)) ? this.f7068m.getItem(i18) : "";
            canvas2.save();
            double d5 = ((this.f7073s * i16) - f10) / this.K;
            float f21 = (float) (90.0d - ((d5 / 3.141592653589793d) * 180.0d));
            if (f21 > 90.0f || f21 < -90.0f) {
                i3 = i16;
                f2 = f20;
                i10 = i13;
                z5 = z6;
                canvas2.restore();
            } else {
                String b3 = (this.f7062g || TextUtils.isEmpty(this.f7069n) || TextUtils.isEmpty(b(item))) ? b(item) : b(item) + this.f7069n;
                float pow = (float) Math.pow(Math.abs(f21) / 90.0f, 2.2d);
                Rect rect = new Rect();
                this.f7066k.getTextBounds(b3, i13, b3.length(), rect);
                int i19 = this.f7070o;
                for (int width = rect.width(); width > this.J; width = rect.width()) {
                    i19--;
                    this.f7066k.setTextSize(i19);
                    this.f7066k.getTextBounds(b3, i13, b3.length(), rect);
                }
                this.f7065j.setTextSize(i19);
                Rect rect2 = new Rect();
                this.f7066k.getTextBounds(b3, i13, b3.length(), rect2);
                int i20 = this.P;
                if (i20 != 3) {
                    if (i20 == 5) {
                        this.Q = (this.J - rect2.width()) - ((int) f20);
                    } else if (i20 == 17) {
                        if (this.f7061f || (str2 = this.f7069n) == null || str2.equals("") || !this.f7062g) {
                            this.Q = (int) ((this.J - rect2.width()) * 0.5d);
                        } else {
                            this.Q = (int) ((this.J - rect2.width()) * 0.25d);
                        }
                    }
                    i11 = 0;
                } else {
                    i11 = 0;
                    this.Q = 0;
                }
                Rect rect3 = new Rect();
                this.f7065j.getTextBounds(b3, i11, b3.length(), rect3);
                int i21 = this.P;
                if (i21 == 3) {
                    this.R = 0;
                } else if (i21 == 5) {
                    this.R = (this.J - rect3.width()) - ((int) f20);
                } else if (i21 == 17) {
                    if (this.f7061f || (str = this.f7069n) == null || str.equals("") || !this.f7062g) {
                        this.R = (int) ((this.J - rect3.width()) * 0.5d);
                    } else {
                        this.R = (int) ((this.J - rect3.width()) * 0.25d);
                    }
                }
                i3 = i16;
                f2 = f20;
                float cos = (float) ((this.K - (Math.cos(d5) * this.K)) - ((Math.sin(d5) * this.f7072q) / 2.0d));
                canvas2.translate(0.0f, cos);
                float f22 = this.A;
                if (cos > f22 || this.f7072q + cos < f22) {
                    float f23 = this.B;
                    if (cos > f23 || this.f7072q + cos < f23) {
                        z5 = false;
                        if (cos >= f22) {
                            float f24 = this.f7072q;
                            if (cos + f24 <= f23) {
                                canvas2.drawText(b3, this.Q, f24 - f2, this.f7066k);
                                this.F = this.G - ((this.H / 2) - i3);
                            }
                        }
                        canvas2.save();
                        i10 = 0;
                        canvas2.clipRect(0, 0, this.J, (int) this.f7073s);
                        canvas2.scale(1.0f, ((float) Math.sin(d5)) * 0.8f);
                        e(pow, f21);
                        canvas2.drawText(b3, (this.r * pow) + this.R, this.f7072q, this.f7065j);
                        canvas2.restore();
                    } else {
                        canvas2.save();
                        canvas2.clipRect(0.0f, 0.0f, this.J, this.B - cos);
                        canvas2.scale(1.0f, ((float) Math.sin(d5)) * 1.0f);
                        canvas2.drawText(b3, this.Q, this.f7072q - f2, this.f7066k);
                        canvas2.restore();
                        canvas2.save();
                        z5 = false;
                        canvas2.clipRect(0.0f, this.B - cos, this.J, (int) this.f7073s);
                        canvas2.scale(1.0f, ((float) Math.sin(d5)) * 0.8f);
                        e(pow, f21);
                        canvas2.drawText(b3, this.R, this.f7072q, this.f7065j);
                        canvas2.restore();
                    }
                    i10 = 0;
                } else {
                    canvas2.save();
                    canvas2.clipRect(0.0f, 0.0f, this.J, this.A - cos);
                    canvas2.scale(1.0f, ((float) Math.sin(d5)) * 0.8f);
                    e(pow, f21);
                    canvas2.drawText(b3, this.R, this.f7072q, this.f7065j);
                    canvas2.restore();
                    canvas2.save();
                    canvas2.clipRect(0.0f, this.A - cos, this.J, (int) this.f7073s);
                    canvas2.scale(1.0f, ((float) Math.sin(d5)) * 1.0f);
                    canvas2.drawText(b3, this.Q, this.f7072q - f2, this.f7066k);
                    canvas2.restore();
                    i10 = 0;
                    z5 = false;
                }
                canvas2.restore();
                this.f7066k.setTextSize(this.f7070o);
            }
            i16 = i3 + 1;
            i13 = i10;
            z6 = z5;
            f20 = f2;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        this.O = i3;
        d();
        setMeasuredDimension(this.J, this.I);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f7060d.onTouchEvent(motionEvent);
        float f2 = (-this.E) * this.f7073s;
        float z5 = ((this.f7068m.z() - 1) - this.E) * this.f7073s;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.N = System.currentTimeMillis();
            a();
            this.M = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.M - motionEvent.getRawY();
            this.M = motionEvent.getRawY();
            float f10 = this.D + rawY;
            this.D = f10;
            if (!this.f7080z) {
                float f11 = this.f7073s;
                if ((f10 - (f11 * 0.25f) < f2 && rawY < 0.0f) || ((f11 * 0.25f) + f10 > z5 && rawY > 0.0f)) {
                    this.D = f10 - rawY;
                    return true;
                }
            }
        } else if (!onTouchEvent) {
            float y4 = motionEvent.getY();
            int i3 = this.K;
            double acos = Math.acos((i3 - y4) / i3) * this.K;
            float f12 = this.f7073s;
            this.L = (int) (((((int) ((acos + (f12 / 2.0f)) / f12)) - (this.H / 2)) * f12) - (((this.D % f12) + f12) % f12));
            if (System.currentTimeMillis() - this.N > 120) {
                f(ACTION.DAGGLE);
            } else {
                f(ACTION.CLICK);
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void setAdapter(v4.a aVar) {
        this.f7068m = aVar;
        d();
        invalidate();
    }

    public void setAlphaGradient(boolean z5) {
        this.T = z5;
    }

    public final void setCurrentItem(int i3) {
        this.F = i3;
        this.E = i3;
        this.D = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z5) {
        this.f7080z = z5;
    }

    public void setDividerColor(int i3) {
        this.f7077w = i3;
        this.f7067l.setColor(i3);
    }

    public void setDividerType(DividerType dividerType) {
        this.f7057a = dividerType;
    }

    public void setDividerWidth(int i3) {
        this.f7078x = i3;
        this.f7067l.setStrokeWidth(i3);
    }

    public void setGravity(int i3) {
        this.P = i3;
    }

    public void setIsOptions(boolean z5) {
        this.f7061f = z5;
    }

    public void setItemsVisibleCount(int i3) {
        if (i3 % 2 == 0) {
            i3++;
        }
        this.H = i3 + 2;
    }

    public void setLabel(String str) {
        this.f7069n = str;
    }

    public void setLineSpacingMultiplier(float f2) {
        if (f2 != 0.0f) {
            this.f7079y = f2;
            if (f2 < 1.0f) {
                this.f7079y = 1.0f;
            } else if (f2 > 4.0f) {
                this.f7079y = 4.0f;
            }
        }
    }

    public final void setOnItemSelectedListener(a aVar) {
        this.e = aVar;
    }

    public void setTextColorCenter(int i3) {
        this.f7076v = i3;
        this.f7066k.setColor(i3);
    }

    public void setTextColorOut(int i3) {
        this.f7075u = i3;
        this.f7065j.setColor(i3);
    }

    public final void setTextSize(float f2) {
        if (f2 > 0.0f) {
            int i3 = (int) (this.f7058b.getResources().getDisplayMetrics().density * f2);
            this.f7070o = i3;
            this.f7065j.setTextSize(i3);
            this.f7066k.setTextSize(this.f7070o);
        }
    }

    public void setTextXOffset(int i3) {
        this.r = i3;
        if (i3 != 0) {
            this.f7066k.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f2) {
        this.D = f2;
    }

    public final void setTypeface(Typeface typeface) {
        this.f7074t = typeface;
        this.f7065j.setTypeface(typeface);
        this.f7066k.setTypeface(this.f7074t);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7061f = false;
        this.f7062g = true;
        this.f7063h = Executors.newSingleThreadScheduledExecutor();
        this.f7074t = Typeface.MONOSPACE;
        this.f7079y = 1.6f;
        this.H = 11;
        this.L = 0;
        this.M = 0.0f;
        this.N = 0L;
        this.P = 17;
        this.Q = 0;
        this.R = 0;
        this.T = false;
        this.f7070o = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.S = 2.4f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.S = 4.0f;
        } else if (2.0f <= f2 && f2 < 3.0f) {
            this.S = 6.0f;
        } else if (f2 >= 3.0f) {
            this.S = f2 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.P = obtainStyledAttributes.getInt(R$styleable.pickerview_wheelview_gravity, 17);
            this.f7075u = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorOut, -5723992);
            this.f7076v = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.f7077w = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_dividerColor, -2763307);
            this.f7078x = obtainStyledAttributes.getDimensionPixelSize(R$styleable.pickerview_wheelview_dividerWidth, 2);
            this.f7070o = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_wheelview_textSize, this.f7070o);
            this.f7079y = obtainStyledAttributes.getFloat(R$styleable.pickerview_wheelview_lineSpacingMultiplier, this.f7079y);
            obtainStyledAttributes.recycle();
        }
        float f10 = this.f7079y;
        if (f10 < 1.0f) {
            this.f7079y = 1.0f;
        } else if (f10 > 4.0f) {
            this.f7079y = 4.0f;
        }
        this.f7058b = context;
        this.f7059c = new b(this);
        GestureDetector gestureDetector = new GestureDetector(context, new com.dh.imagepick.preview.widgets.video.c(this));
        this.f7060d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f7080z = true;
        this.D = 0.0f;
        this.E = -1;
        Paint paint = new Paint();
        this.f7065j = paint;
        paint.setColor(this.f7075u);
        this.f7065j.setAntiAlias(true);
        this.f7065j.setTypeface(this.f7074t);
        this.f7065j.setTextSize(this.f7070o);
        Paint paint2 = new Paint();
        this.f7066k = paint2;
        paint2.setColor(this.f7076v);
        this.f7066k.setAntiAlias(true);
        this.f7066k.setTextScaleX(1.1f);
        this.f7066k.setTypeface(this.f7074t);
        this.f7066k.setTextSize(this.f7070o);
        Paint paint3 = new Paint();
        this.f7067l = paint3;
        paint3.setColor(this.f7077w);
        this.f7067l.setAntiAlias(true);
        setLayerType(1, null);
    }
}
