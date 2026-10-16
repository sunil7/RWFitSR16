package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e5 extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    private Context f3959a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f3960b;

    /* renamed from: c, reason: collision with root package name */
    private int f3961c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f3962d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f3963f;

    /* renamed from: g, reason: collision with root package name */
    private int f3964g;

    /* renamed from: h, reason: collision with root package name */
    private int f3965h;

    /* renamed from: i, reason: collision with root package name */
    private int f3966i;

    /* renamed from: j, reason: collision with root package name */
    private int f3967j;

    /* renamed from: k, reason: collision with root package name */
    private int f3968k;

    /* renamed from: l, reason: collision with root package name */
    int f3969l;

    /* renamed from: m, reason: collision with root package name */
    private int f3970m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f3971n;

    /* renamed from: o, reason: collision with root package name */
    private int f3972o;

    /* renamed from: p, reason: collision with root package name */
    private d f3973p;

    public class a implements Runnable {

        /* renamed from: com.amap.api.col.3sl.e5$a$a, reason: collision with other inner class name */
        public class RunnableC0003a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f3975a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f3976b;

            public RunnableC0003a(int i3, int i10) {
                this.f3975a = i3;
                this.f3976b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                e5 e5Var = e5.this;
                e5Var.smoothScrollTo(0, e5.this.f3961c + (e5Var.f3970m - this.f3975a));
                e5 e5Var2 = e5.this;
                e5Var2.f3969l = e5Var2.f3967j + this.f3976b + 1;
                e5.f(e5.this);
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f3978a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f3979b;

            public b(int i3, int i10) {
                this.f3978a = i3;
                this.f3979b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                e5 e5Var = e5.this;
                e5Var.smoothScrollTo(0, e5Var.f3970m - this.f3978a);
                e5 e5Var2 = e5.this;
                e5Var2.f3969l = e5Var2.f3967j + this.f3979b;
                e5.f(e5.this);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e5.this.f3970m - e5.this.getScrollY() != 0) {
                e5 e5Var = e5.this;
                e5Var.f3970m = e5Var.getScrollY();
                e5 e5Var2 = e5.this;
                e5Var2.postDelayed(e5Var2.f3971n, e5.this.f3972o);
                return;
            }
            if (e5.this.f3961c == 0) {
                return;
            }
            int i3 = e5.this.f3970m % e5.this.f3961c;
            int i10 = e5.this.f3970m / e5.this.f3961c;
            if (i3 == 0) {
                e5 e5Var3 = e5.this;
                e5Var3.f3969l = e5Var3.f3967j + i10;
                e5.f(e5.this);
            } else if (i3 > e5.this.f3961c / 2) {
                e5.this.post(new RunnableC0003a(i3, i10));
            } else {
                e5.this.post(new b(i3, i10));
            }
        }
    }

    public class b extends Drawable {
        public b() {
        }

        private void a(Canvas canvas) {
            Paint paint = new Paint();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = e5.this.f3963f.getWidth();
            rect.bottom = e5.this.f3963f.getHeight();
            rect2.left = 0;
            rect2.top = e5.k(e5.this)[0];
            rect2.right = e5.this.e;
            rect2.bottom = e5.k(e5.this)[1];
            canvas.drawBitmap(e5.this.f3963f, rect, rect2, paint);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            try {
                canvas.drawColor(e5.this.f3964g);
                a(canvas);
                Paint paint = new Paint();
                Rect clipBounds = canvas.getClipBounds();
                paint.setColor(e5.this.f3965h);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(e5.this.f3966i);
                canvas.drawRect(clipBounds, paint);
            } catch (Throwable unused) {
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3982a;

        public c(int i3) {
            this.f3982a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e5 e5Var = e5.this;
            e5Var.smoothScrollTo(0, e5Var.f3961c * this.f3982a);
        }
    }

    public interface d {
        void a(int i3);
    }

    public e5(Context context) {
        super(context);
        this.f3961c = 0;
        this.f3963f = null;
        this.f3964g = Color.parseColor("#eeffffff");
        this.f3965h = Color.parseColor("#44383838");
        this.f3966i = 4;
        this.f3967j = 1;
        this.f3969l = 1;
        this.f3972o = 50;
        a(context);
    }

    public static void f(e5 e5Var) {
        d dVar = e5Var.f3973p;
        if (dVar != null) {
            try {
                List<String> list = e5Var.f3962d;
                int i3 = 0;
                if (list != null && list.size() != 0) {
                    i3 = Math.min(e5Var.f3962d.size() - (e5Var.f3967j * 2), Math.max(0, ((e5Var.f3962d.size() - 1) - e5Var.f3969l) - e5Var.f3967j));
                }
                dVar.a(i3);
            } catch (Throwable unused) {
            }
        }
    }

    public static int[] k(e5 e5Var) {
        int i3 = e5Var.f3961c;
        int i10 = e5Var.f3967j;
        return new int[]{i3 * i10, (i10 + 1) * i3};
    }

    @Override // android.widget.ScrollView
    public void fling(int i3) {
        super.fling(i3 / 3);
    }

    @Override // android.view.View
    public void onScrollChanged(int i3, int i10, int i11, int i12) {
        super.onScrollChanged(i3, i10, i11, i12);
        a(i10);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        this.e = i3;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f3970m = getScrollY();
            postDelayed(this.f3971n, this.f3972o);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.f3964g = i3;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.e == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.f3959a.getSystemService("window");
                if (windowManager != null) {
                    this.e = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new b());
    }

    public boolean b() {
        return getVisibility() == 0;
    }

    private void a(Context context) {
        this.f3959a = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f3963f == null) {
                InputStream open = s4.a(context).open("map_indoor_select.png");
                this.f3963f = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.f3960b = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f3960b);
        this.f3971n = new a();
    }

    private void a(int i3) {
        int i10 = this.f3961c;
        if (i10 == 0) {
            return;
        }
        int i11 = (i3 / i10) + this.f3967j;
        int i12 = i3 % i10;
        if (i12 != 0 && i12 > i10 / 2) {
            i11++;
        }
        int childCount = this.f3960b.getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            TextView textView = (TextView) this.f3960b.getChildAt(i13);
            if (textView == null) {
                return;
            }
            if (i11 == i13) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
        }
    }

    public void a(String[] strArr) {
        if (this.f3962d == null) {
            this.f3962d = new ArrayList();
        }
        this.f3962d.clear();
        for (String str : strArr) {
            this.f3962d.add(str);
        }
        for (int i3 = 0; i3 < this.f3967j; i3++) {
            this.f3962d.add(0, "");
            this.f3962d.add("");
        }
        List<String> list = this.f3962d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f3960b.removeAllViews();
        this.f3968k = (this.f3967j * 2) + 1;
        for (int size = this.f3962d.size() - 1; size >= 0; size--) {
            LinearLayout linearLayout = this.f3960b;
            String str2 = this.f3962d.get(size);
            TextView textView = new TextView(this.f3959a);
            textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            textView.setSingleLine(true);
            textView.setTextSize(2, 16.0f);
            textView.setText(str2);
            textView.setGravity(17);
            textView.getPaint().setFakeBoldText(true);
            int i10 = (int) ((this.f3959a.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
            int i11 = (int) ((this.f3959a.getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
            textView.setPadding(i10, i11, i10, i11);
            if (this.f3961c == 0) {
                textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
                this.f3961c = textView.getMeasuredHeight();
                this.f3960b.setLayoutParams(new FrameLayout.LayoutParams(-2, this.f3961c * this.f3968k));
                setLayoutParams(new LinearLayout.LayoutParams(-2, this.f3961c * this.f3968k));
            }
            linearLayout.addView(textView);
        }
        a(0);
    }

    public void a() {
        Bitmap bitmap = this.f3963f;
        if (bitmap != null && !bitmap.isRecycled()) {
            v4.a(this.f3963f);
            this.f3963f = null;
        }
        if (this.f3973p != null) {
            this.f3973p = null;
        }
    }

    public void a(String str) {
        List<String> list = this.f3962d;
        if (list == null || list.size() == 0) {
            return;
        }
        int indexOf = this.f3962d.indexOf(str);
        int size = this.f3962d.size();
        int i3 = ((size - r1) - 1) - indexOf;
        this.f3969l = this.f3967j + i3;
        post(new c(i3));
    }

    public void a(d dVar) {
        this.f3973p = dVar;
    }

    public void a(boolean z5) {
        setVisibility(z5 ? 0 : 8);
    }
}
