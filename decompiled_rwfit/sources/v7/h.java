package v7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.exoplayer2.PlaybackException;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f19191a = null;

    /* renamed from: b, reason: collision with root package name */
    public static int f19192b = 50;

    /* renamed from: c, reason: collision with root package name */
    public static int f19193c = 8000;

    /* renamed from: d, reason: collision with root package name */
    public static final Rect f19194d;
    public static final Paint.FontMetrics e;

    /* renamed from: f, reason: collision with root package name */
    public static final Rect f19195f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f19196g;

    /* renamed from: h, reason: collision with root package name */
    public static final n6.a f19197h;

    /* renamed from: i, reason: collision with root package name */
    public static final Rect f19198i;

    /* renamed from: j, reason: collision with root package name */
    public static final Rect f19199j;

    /* renamed from: k, reason: collision with root package name */
    public static final Paint.FontMetrics f19200k;

    static {
        Double.longBitsToDouble(1L);
        Float.intBitsToFloat(1);
        f19194d = new Rect();
        e = new Paint.FontMetrics();
        f19195f = new Rect();
        f19196g = new int[]{1, 10, 100, 1000, 10000, 100000, PlaybackException.CUSTOM_ERROR_CODE_BASE, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};
        f19197h = new n6.a(1);
        f19198i = new Rect();
        f19199j = new Rect();
        f19200k = new Paint.FontMetrics();
    }

    public static int a(Paint paint, String str) {
        Rect rect = f19194d;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static a b(Paint paint, String str) {
        a aVar = (a) a.f19175d.b();
        aVar.f19176b = 0.0f;
        aVar.f19177c = 0.0f;
        Rect rect = f19195f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        aVar.f19176b = rect.width();
        aVar.f19177c = rect.height();
        return aVar;
    }

    public static float c(float f2) {
        DisplayMetrics displayMetrics = f19191a;
        if (displayMetrics != null) {
            return f2 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static void d(Canvas canvas, Drawable drawable, int i3, int i10, int i11, int i12) {
        d dVar = (d) d.f19181d.b();
        dVar.f19182b = i3 - (i11 / 2);
        dVar.f19183c = i10 - (i12 / 2);
        Rect rect = f19198i;
        drawable.copyBounds(rect);
        int i13 = rect.left;
        int i14 = rect.top;
        drawable.setBounds(i13, i14, i13 + i11, i11 + i14);
        int save = canvas.save();
        canvas.translate(dVar.f19182b, dVar.f19183c);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static String e(boolean z5, float f2) {
        boolean z6;
        float f10 = f2;
        int i3 = 35;
        char[] cArr = new char[35];
        if (f10 == 0.0f) {
            return "0";
        }
        int i10 = 0;
        boolean z8 = f10 < 1.0f && f10 > -1.0f;
        if (f10 < 0.0f) {
            f10 = -f10;
            z6 = true;
        } else {
            z6 = false;
        }
        int[] iArr = f19196g;
        int length = iArr.length < 0 ? iArr.length - 1 : 0;
        long round = Math.round(f10 * iArr[length]);
        int i11 = 34;
        boolean z10 = false;
        while (true) {
            if (round == 0 && i10 >= length + 1) {
                break;
            }
            char[] cArr2 = cArr;
            int i12 = (int) (round % 10);
            round /= 10;
            int i13 = i11 - 1;
            cArr2[i11] = (char) (i12 + 48);
            int i14 = i10 + 1;
            if (i14 == length) {
                i11 -= 2;
                cArr2[i13] = ',';
                i10 += 2;
                z10 = true;
            } else {
                if (z5 && round != 0 && i14 > length) {
                    if (z10) {
                        if ((i14 - length) % 4 == 0) {
                            i11 -= 2;
                            cArr2[i13] = '.';
                            i10 += 2;
                        }
                    } else if ((i14 - length) % 4 == 3) {
                        i11 -= 2;
                        cArr2[i13] = '.';
                        i10 += 2;
                    }
                }
                i10 = i14;
                i11 = i13;
            }
            cArr = cArr2;
            i3 = 35;
        }
        if (z8) {
            cArr[i11] = '0';
            i10++;
            i11--;
        }
        if (z6) {
            cArr[i11] = '-';
            i10++;
        }
        int i15 = i3 - i10;
        return String.valueOf(cArr, i15, 35 - i15);
    }

    public static a f(float f2, float f10) {
        double d5 = 0.0f;
        float abs = Math.abs(((float) Math.sin(d5)) * f10) + Math.abs(((float) Math.cos(d5)) * f2);
        float abs2 = Math.abs(f10 * ((float) Math.cos(d5))) + Math.abs(f2 * ((float) Math.sin(d5)));
        a aVar = (a) a.f19175d.b();
        aVar.f19176b = abs;
        aVar.f19177c = abs2;
        return aVar;
    }

    public static double g(double d5) {
        if (d5 == Double.POSITIVE_INFINITY) {
            return d5;
        }
        double d8 = d5 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d8) + (d8 >= 0.0d ? 1L : -1L));
    }

    public static float h(double d5) {
        if (Double.isInfinite(d5) || Double.isNaN(d5) || d5 == 0.0d) {
            return 0.0f;
        }
        return Math.round(d5 * r0) / ((float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d5 < 0.0d ? -d5 : d5)))));
    }
}
