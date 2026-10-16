package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f912l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f913m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f914a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f915b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f916c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f917d = -1.0f;
    public float e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f918f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f919g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f920h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f921i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f922j;

    /* renamed from: k, reason: collision with root package name */
    public final d1 f923k;

    static {
        new ConcurrentHashMap();
    }

    public h1(TextView textView) {
        this.f921i = textView;
        this.f922j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f923k = new f1();
        } else {
            this.f923k = new d1();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i3 : iArr) {
                if (i3 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i3)) < 0) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i10 = 0; i10 < size; i10++) {
                    iArr2[i10] = ((Integer) arrayList.get(i10)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f913m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method != null || (method = TextView.class.getDeclaredMethod(str, null)) == null) {
                return method;
            }
            method.setAccessible(true);
            concurrentHashMap.put(str, method);
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    public static Object e(String str, Object obj, Object obj2) {
        try {
            return d(str).invoke(obj, null);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return obj2;
        }
    }

    public final void a() {
        if (f()) {
            if (this.f915b) {
                if (this.f921i.getMeasuredHeight() <= 0 || this.f921i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f923k.b(this.f921i) ? Const.I_MAX_OFFLINE_DATA_CACHE : (this.f921i.getMeasuredWidth() - this.f921i.getTotalPaddingLeft()) - this.f921i.getTotalPaddingRight();
                int height = (this.f921i.getHeight() - this.f921i.getCompoundPaddingBottom()) - this.f921i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f912l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float c9 = c(rectF);
                        if (c9 != this.f921i.getTextSize()) {
                            g(c9, 0);
                        }
                    } finally {
                    }
                }
            }
            this.f915b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f918f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i3 = length - 1;
        int i10 = 0;
        int i11 = 1;
        while (i11 <= i3) {
            int i12 = (i11 + i3) / 2;
            int i13 = this.f918f[i12];
            TextView textView = this.f921i;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                text = transformation;
            }
            int b3 = a1.b(textView);
            TextPaint textPaint = this.f920h;
            if (textPaint == null) {
                this.f920h = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.f920h.set(textView.getPaint());
            this.f920h.setTextSize(i13);
            StaticLayout a3 = c1.a(text, (Layout.Alignment) e("getLayoutAlignment", textView, Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b3, textView, this.f920h, this.f923k);
            if ((b3 == -1 || (a3.getLineCount() <= b3 && a3.getLineEnd(a3.getLineCount() - 1) == text.length())) && a3.getHeight() <= rectF.bottom) {
                int i14 = i12 + 1;
                i10 = i11;
                i11 = i14;
            } else {
                i10 = i12 - 1;
                i3 = i10;
            }
        }
        return this.f918f[i10];
    }

    public final boolean f() {
        return j() && this.f914a != 0;
    }

    public final void g(float f2, int i3) {
        Context context = this.f922j;
        float applyDimension = TypedValue.applyDimension(i3, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f921i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean a3 = b1.a(textView);
            if (textView.getLayout() != null) {
                this.f915b = false;
                try {
                    Method d5 = d("nullLayouts");
                    if (d5 != null) {
                        d5.invoke(textView, null);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (a3) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean h() {
        if (j() && this.f914a == 1) {
            if (!this.f919g || this.f918f.length == 0) {
                int floor = ((int) Math.floor((this.e - this.f917d) / this.f916c)) + 1;
                int[] iArr = new int[floor];
                for (int i3 = 0; i3 < floor; i3++) {
                    iArr[i3] = Math.round((i3 * this.f916c) + this.f917d);
                }
                this.f918f = b(iArr);
            }
            this.f915b = true;
        } else {
            this.f915b = false;
        }
        return this.f915b;
    }

    public final boolean i() {
        boolean z5 = this.f918f.length > 0;
        this.f919g = z5;
        if (z5) {
            this.f914a = 1;
            this.f917d = r0[0];
            this.e = r0[r1 - 1];
            this.f916c = -1.0f;
        }
        return z5;
    }

    public final boolean j() {
        return !(this.f921i instanceof AppCompatEditText);
    }

    public final void k(float f2, float f10, float f11) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f10 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f10 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f11 + "px) is less or equal to (0px)");
        }
        this.f914a = 1;
        this.f917d = f2;
        this.e = f10;
        this.f916c = f11;
        this.f919g = false;
    }
}
