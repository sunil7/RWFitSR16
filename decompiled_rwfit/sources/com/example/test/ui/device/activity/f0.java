package com.example.test.ui.device.activity;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.camera.core.impl.y0;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import com.example.blesdk.bean.function.VideoHidBean;
import com.example.test.R$string;
import com.example.test.presenter.device.k1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.main.activity.BSDetailActivity;
import com.example.test.ui.main.activity.HRDetailActivity;
import com.example.test.ui.main.activity.StepDetailActivity;
import com.example.test.ui.sport.fragment.SportTypeFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.JsonIOException;
import com.haibin.calendarview.BaseWeekView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.WeekBar;
import com.haibin.calendarview.WeekViewPager;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import f6.v2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import l1.v1;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public final class f0 implements t6.a, a7.e, t6.b, com.google.android.material.button.b, l1.w, h.i, com.google.gson.internal.i, d4.r, d4.a, x3.a, d4.e0, ia.b, g4.k, com.bumptech.glide.load.data.g, vh.c, m4.k, m1.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7858a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7859b;

    public f0(int i3) {
        this.f7858a = i3;
        switch (i3) {
            case 12:
                this.f7859b = new d4.n(500L);
                break;
            case 18:
                this.f7859b = gd.a.e;
                break;
            case 20:
                this.f7859b = new f0(21);
                break;
            case 21:
                this.f7859b = new ia.m();
                break;
        }
    }

    public static f0 p(int i3, int i10, int i11) {
        return new f0(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i10, false, i11), 24);
    }

    private final void r() {
    }

    private final void u() {
    }

    private final void w() {
    }

    @Override // a7.e
    public void B() {
        switch (this.f7858a) {
            case 1:
                int i3 = VideoHidActivity.F;
                VideoHidActivity videoHidActivity = (VideoHidActivity) this.f7859b;
                VideoHidBean S0 = videoHidActivity.S0();
                eh.b bVar = videoHidActivity.f7247z;
                S0.setOpen(((v2) bVar.getValue()).f13406c.getItemOpen());
                videoHidActivity.S0().setDefaultOpen(((v2) bVar.getValue()).f13407d.getItemOpen());
                k1 k1Var = (k1) videoHidActivity.I0();
                VideoHidBean data = videoHidActivity.S0();
                k1Var.getClass();
                kotlin.jvm.internal.e.f(data, "data");
                k1Var.f7453b = data;
                ((XXBaseActivity) ((f7.b0) k1Var.f7255a)).V();
                com.google.android.gms.internal.mlkit_vision_common.p.R(data);
                break;
        }
    }

    @Override // l1.w
    public x1 P(View view, x1 x1Var) {
        switch (this.f7858a) {
            case 8:
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = (ScrimInsetsFrameLayout) this.f7859b;
                if (scrimInsetsFrameLayout.f10550b == null) {
                    scrimInsetsFrameLayout.f10550b = new Rect();
                }
                scrimInsetsFrameLayout.f10550b.set(x1Var.b(), x1Var.d(), x1Var.c(), x1Var.a());
                scrimInsetsFrameLayout.a(x1Var);
                v1 v1Var = x1Var.f15738a;
                scrimInsetsFrameLayout.setWillNotDraw(v1Var.j().equals(c1.c.e) || scrimInsetsFrameLayout.f10549a == null);
                WeakHashMap weakHashMap = z0.f15748a;
                l1.h0.k(scrimInsetsFrameLayout);
                return v1Var.c();
            default:
                AppBarLayout appBarLayout = (AppBarLayout) this.f7859b;
                WeakHashMap weakHashMap2 = z0.f15748a;
                x1 x1Var2 = l1.h0.b(appBarLayout) ? x1Var : null;
                if (!k1.b.a(appBarLayout.f10171g, x1Var2)) {
                    appBarLayout.f10171g = x1Var2;
                    if (appBarLayout.f10180p != null && appBarLayout.getTopInset() > 0) {
                        r8 = true;
                    }
                    appBarLayout.setWillNotDraw(!r8);
                    appBarLayout.requestLayout();
                }
                return x1Var;
        }
    }

    @Override // g4.k
    public long a(long j4) {
        if (j4 < 0) {
            return 0L;
        }
        long j10 = j4;
        while (j10 > 0) {
            InputStream inputStream = (InputStream) this.f7859b;
            long skip = inputStream.skip(j10);
            if (skip > 0) {
                j10 -= skip;
            } else {
                if (inputStream.read() == -1) {
                    break;
                }
                j10--;
            }
        }
        return j4 - j10;
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
    }

    @Override // d4.r
    public d4.q c(d4.x xVar) {
        switch (this.f7858a) {
            case 11:
                return new d4.b(0, (AssetManager) this.f7859b, this);
            default:
                return new d4.f0(this);
        }
    }

    @Override // h.i
    public boolean d(h.k kVar, MenuItem menuItem) {
        com.google.android.material.navigation.h hVar = ((NavigationView) this.f7859b).f10693h;
        return hVar != null && hVar.a(menuItem);
    }

    @Override // x3.a
    public boolean e(Object obj, File file, x3.f fVar) {
        InputStream inputStream = (InputStream) obj;
        a4.g gVar = (a4.g) this.f7859b;
        byte[] bArr = (byte[]) gVar.c(byte[].class, WXMediaMessage.THUMB_LENGTH_LIMIT);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        gVar.g(bArr);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        gVar.g(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                gVar.g(bArr);
                return true;
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // d4.e0
    public com.bumptech.glide.load.data.e f(Uri uri) {
        return new com.bumptech.glide.load.data.n(1, uri, (ContentResolver) this.f7859b);
    }

    @Override // m1.o
    public boolean g(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f7859b;
        if (!swipeDismissBehavior.s(view)) {
            return false;
        }
        WeakHashMap weakHashMap = z0.f15748a;
        boolean z5 = l1.i0.d(view) == 1;
        int i3 = swipeDismissBehavior.f10230c;
        view.offsetLeftAndRight((!(i3 == 0 && z5) && (i3 != 1 || z5)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    @Override // g4.k
    public short h() {
        int read = ((InputStream) this.f7859b).read();
        if (read != -1) {
            return (short) read;
        }
        throw new DefaultImageHeaderParser$Reader$EndOfFileException();
    }

    @Override // d4.a
    public com.bumptech.glide.load.data.e i(AssetManager assetManager, String str) {
        return new com.bumptech.glide.load.data.k(assetManager, str, 1);
    }

    @Override // vh.c
    public Iterator iterator() {
        return ((Iterable) this.f7859b).iterator();
    }

    @Override // ia.b
    public void j(ia.f fVar) {
        ((CountDownLatch) this.f7859b).countDown();
    }

    @Override // h.i
    public void k(h.k kVar) {
    }

    @Override // g4.k
    public int l() {
        return (h() << 8) | h();
    }

    @Override // com.bumptech.glide.load.data.g
    public Object m() {
        ByteBuffer byteBuffer = (ByteBuffer) this.f7859b;
        byteBuffer.position(0);
        return byteBuffer;
    }

    public void n() {
        ((ia.m) ((f0) this.f7859b).f7859b).j(null);
    }

    @Override // t6.b
    public void onCancel() {
    }

    public void q(Calendar calendar, boolean z5) {
        int year = calendar.getYear();
        CalendarView calendarView = (CalendarView) this.f7859b;
        md.r rVar = calendarView.f11324a;
        if (year == rVar.f16056h0.getYear() && calendar.getMonth() == rVar.f16056h0.getMonth() && calendarView.f11325b.getCurrentItem() != rVar.f16063l0) {
            return;
        }
        rVar.f16074r0 = calendar;
        if (rVar.f16048d == 0 || z5) {
            rVar.f16073q0 = calendar;
        }
        calendarView.f11326c.y(calendar);
        calendarView.f11325b.A();
        WeekBar weekBar = calendarView.f11328f;
        if (weekBar != null) {
            if (rVar.f16048d == 0 || z5) {
                weekBar.b(calendar, rVar.f16044b);
            }
        }
    }

    @Override // t6.b
    public void s() {
        SportTypeFragment sportTypeFragment = (SportTypeFragment) this.f7859b;
        if (sportTypeFragment.f8189d != 4) {
            v2.h hVar = new v2.h(sportTypeFragment.f0());
            hVar.o("android.permission.ACCESS_COARSE_LOCATION");
            hVar.o("android.permission.ACCESS_FINE_LOCATION");
            hVar.o("android.permission.ACCESS_BACKGROUND_LOCATION");
            hVar.p(new com.example.test.ui.sport.fragment.a(sportTypeFragment, 4));
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            v2.h hVar2 = new v2.h(sportTypeFragment.f0());
            hVar2.o("android.permission.ACTIVITY_RECOGNITION");
            hVar2.o("android.permission.BODY_SENSORS");
            hVar2.p(new com.example.test.ui.sport.fragment.a(sportTypeFragment, 5));
            return;
        }
        v2.h hVar3 = new v2.h(sportTypeFragment.f0());
        hVar3.o("android.permission.ACTIVITY_RECOGNITION");
        hVar3.o("android.permission.BODY_SENSORS");
        hVar3.o("android.permission.WRITE_EXTERNAL_STORAGE");
        hVar3.p(new com.example.test.ui.sport.fragment.a(sportTypeFragment, 6));
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        Type type = (Type) this.f7859b;
        if (!(type instanceof ParameterizedType)) {
            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
    }

    public String toString() {
        switch (this.f7858a) {
            case 25:
                return super.toString() + "{fragment=" + ((m4.i) this.f7859b) + "}";
            default:
                return super.toString();
        }
    }

    @Override // a7.e
    public void u0() {
        switch (this.f7858a) {
            case 1:
                ((VideoHidActivity) this.f7859b).onBackPressed();
                break;
            case 2:
                ((BSDetailActivity) this.f7859b).onBackPressed();
                break;
            case 3:
                ((HRDetailActivity) this.f7859b).onBackPressed();
                break;
            default:
                ((StepDetailActivity) this.f7859b).onBackPressed();
                break;
        }
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        int i3 = R$string.str_always_bright;
        ScreenLongActivity screenLongActivity = (ScreenLongActivity) this.f7859b;
        if (kotlin.jvm.internal.e.a(screenLongActivity.getString(i3), data)) {
            screenLongActivity.S0().setTimeSecond(0);
        } else {
            screenLongActivity.S0().setTimeSecond(Integer.parseInt(data));
        }
        screenLongActivity.R0();
    }

    public void x(Calendar calendar, boolean z5) {
        CalendarView calendarView = (CalendarView) this.f7859b;
        md.r rVar = calendarView.f11324a;
        rVar.f16074r0 = calendar;
        if (rVar.f16048d == 0 || z5 || calendar.equals(rVar.f16073q0)) {
            rVar.f16073q0 = calendar;
        }
        int month = (rVar.f16074r0.getMonth() + ((calendar.getYear() - rVar.W) * 12)) - rVar.Y;
        WeekViewPager weekViewPager = calendarView.f11326c;
        if (weekViewPager.f11346e0.f16048d != 0) {
            for (int i3 = 0; i3 < weekViewPager.getChildCount(); i3++) {
                BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.getChildAt(i3);
                if (!baseWeekView.f11298o.contains(baseWeekView.f11285a.f16073q0)) {
                    baseWeekView.f11304v = -1;
                    baseWeekView.invalidate();
                }
            }
        }
        calendarView.f11325b.v(month, false);
        calendarView.f11325b.A();
        if (calendarView.f11328f != null) {
            if (rVar.f16048d == 0 || z5 || rVar.f16074r0.equals(rVar.f16073q0)) {
                calendarView.f11328f.b(calendar, rVar.f16044b);
            }
        }
    }

    public /* synthetic */ f0(Object obj, int i3) {
        this.f7858a = i3;
        this.f7859b = obj;
    }

    public f0(y0 y0Var) {
        this.f7858a = 15;
        boolean z5 = y0Var.f1524a;
        this.f7859b = (byte[]) y0Var.e;
    }
}
