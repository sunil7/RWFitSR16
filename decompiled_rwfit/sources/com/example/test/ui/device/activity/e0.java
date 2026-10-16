package com.example.test.ui.device.activity;

import android.animation.AnimatorSet;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.device.h1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.main.activity.BPDetailActivity;
import com.example.test.ui.main.activity.BreatheDetailActivity;
import com.example.test.ui.main.activity.StartActivity;
import com.example.test.ui.sport.fragment.SportTypeFragment;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.navigation.NavigationBarView;
import com.google.mlkit.vision.barcode.internal.zzh;
import com.google.zxing.NotFoundException;
import f6.r3;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import l1.x1;

/* loaded from: classes.dex */
public class e0 implements a7.e, t6.a, t6.d, t6.b, a7.f, com.google.android.material.internal.z, bb.a, h.i, com.google.gson.internal.i, d4.r, d4.a, d4.e0, h8.a, ia.d, ia.c, ia.a, h1.c, l1.g, ia.e, lc.a, md.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7854a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7855b;

    public /* synthetic */ e0(zzh zzhVar, int i3, int i10) {
        this.f7854a = 26;
        this.f7855b = zzhVar;
    }

    private final void E() {
    }

    private final void F() {
    }

    public m1.d A(int i3) {
        return null;
    }

    @Override // a7.e
    public void B() {
        switch (this.f7854a) {
            case 0:
                int i3 = ScreenLongActivity.H;
                ScreenLongActivity screenLongActivity = (ScreenLongActivity) this.f7855b;
                h1 h1Var = (h1) screenLongActivity.I0();
                BrightScreenTimeBean data = screenLongActivity.S0();
                h1Var.getClass();
                kotlin.jvm.internal.e.f(data, "data");
                h1Var.f7435b = data;
                ((XXBaseActivity) ((f7.z) h1Var.f7255a)).V();
                if (!y5.d.f20005b) {
                    if (!r5.b.k().f18054c) {
                        x5.b.I0().F0((byte) 42);
                        break;
                    } else {
                        x5.d c9 = x5.d.c();
                        int timeSecond = data.getTimeSecond();
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(timeSecond, "getBrightTimeCmd "));
                        char[] cArr = y5.b.f20001a;
                        c9.j((byte) 42, new byte[]{(byte) (timeSecond & 255)});
                        break;
                    }
                } else if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) -21);
                    break;
                } else {
                    x5.c b3 = x5.c.b();
                    int timeSecond2 = data.getTimeSecond();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(timeSecond2, "getBrightTimeWCmdJL "));
                    char[] cArr2 = y5.b.f20001a;
                    b3.g((byte) -21, new byte[]{2, 8, 0, (byte) (timeSecond2 & 255)}, new boolean[0]);
                    break;
                }
        }
    }

    public kd.a C(float f2, float f10, int i3, int i10) {
        sc.b bVar;
        kd.a b3;
        kd.a b10;
        int i11 = (int) (f10 * f2);
        int max = Math.max(0, i3 - i11);
        sc.b bVar2 = (sc.b) this.f7855b;
        int min = Math.min(bVar2.f18221a - 1, i3 + i11) - max;
        float f11 = 3.0f * f2;
        if (min < f11) {
            throw NotFoundException.getNotFoundInstance();
        }
        int max2 = Math.max(0, i10 - i11);
        int min2 = Math.min(bVar2.f18222b - 1, i10 + i11) - max2;
        if (min2 < f11) {
            throw NotFoundException.getNotFoundInstance();
        }
        kd.b bVar3 = new kd.b((sc.b) this.f7855b, max, max2, min, min2, f2);
        int i12 = bVar3.e;
        int i13 = bVar3.f15606c;
        int i14 = i12 + i13;
        int i15 = bVar3.f15608f;
        int i16 = (i15 / 2) + bVar3.f15607d;
        int[] iArr = new int[3];
        for (int i17 = 0; i17 < i15; i17++) {
            int i18 = ((i17 & 1) == 0 ? (i17 + 1) / 2 : -((i17 + 1) / 2)) + i16;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i19 = i13;
            while (true) {
                bVar = bVar3.f15604a;
                if (i19 >= i14 || bVar.b(i19, i18)) {
                    break;
                }
                i19++;
            }
            int i20 = 0;
            while (i19 < i14) {
                if (!bVar.b(i19, i18)) {
                    if (i20 == 1) {
                        i20++;
                    }
                    iArr[i20] = iArr[i20] + 1;
                } else if (i20 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i20 != 2) {
                    i20++;
                    iArr[i20] = iArr[i20] + 1;
                } else {
                    if (bVar3.a(iArr) && (b10 = bVar3.b(iArr, i18, i19)) != null) {
                        return b10;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i20 = 1;
                }
                i19++;
            }
            if (bVar3.a(iArr) && (b3 = bVar3.b(iArr, i18, i14)) != null) {
                return b3;
            }
        }
        ArrayList arrayList = bVar3.f15605b;
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (kd.a) arrayList.get(0);
    }

    public m1.d D(int i3) {
        return null;
    }

    public boolean G(int i3, int i10, Bundle bundle) {
        return false;
    }

    public synchronized void H(w3.c cVar) {
        cVar.f19497b = null;
        cVar.f19498c = null;
        ((ArrayDeque) this.f7855b).offer(cVar);
    }

    public float I(int i3, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        e0 e0Var;
        int i19;
        int i20 = 1;
        boolean z5 = Math.abs(i12 - i10) > Math.abs(i11 - i3);
        if (z5) {
            i14 = i3;
            i13 = i10;
            i16 = i11;
            i15 = i12;
        } else {
            i13 = i3;
            i14 = i10;
            i15 = i11;
            i16 = i12;
        }
        int abs = Math.abs(i15 - i13);
        int abs2 = Math.abs(i16 - i14);
        int i21 = 2;
        int i22 = (-abs) / 2;
        int i23 = i13 < i15 ? 1 : -1;
        int i24 = i14 < i16 ? 1 : -1;
        int i25 = i15 + i23;
        int i26 = i13;
        int i27 = i14;
        int i28 = 0;
        while (true) {
            if (i26 == i25) {
                i17 = i21;
                break;
            }
            int i29 = z5 ? i27 : i26;
            int i30 = z5 ? i26 : i27;
            boolean z6 = z5;
            if (i28 == i20) {
                i18 = i20;
                i19 = abs;
                e0Var = this;
            } else {
                i18 = 0;
                e0Var = this;
                i19 = abs;
            }
            if (i18 == ((sc.b) e0Var.f7855b).b(i29, i30)) {
                if (i28 == 2) {
                    return com.google.android.gms.internal.mlkit_vision_common.e0.b(i26, i27, i13, i14);
                }
                i28++;
            }
            i22 += abs2;
            if (i22 > 0) {
                if (i27 == i16) {
                    i17 = 2;
                    break;
                }
                i27 += i24;
                i22 -= i19;
            }
            i26 += i23;
            abs = i19;
            z5 = z6;
            i20 = 1;
            i21 = 2;
        }
        if (i28 == i17) {
            return com.google.android.gms.internal.mlkit_vision_common.e0.b(i25, i16, i13, i14);
        }
        return Float.NaN;
    }

    public float J(int i3, int i10, int i11, int i12) {
        float f2;
        float f10;
        float I = I(i3, i10, i11, i12);
        int i13 = i3 - (i11 - i3);
        sc.b bVar = (sc.b) this.f7855b;
        int i14 = 0;
        if (i13 < 0) {
            f2 = i3 / (i3 - i13);
            i13 = 0;
        } else {
            int i15 = bVar.f18221a;
            if (i13 >= i15) {
                float f11 = ((i15 - 1) - i3) / (i13 - i3);
                int i16 = i15 - 1;
                f2 = f11;
                i13 = i16;
            } else {
                f2 = 1.0f;
            }
        }
        float f12 = i10;
        int i17 = (int) (f12 - ((i12 - i10) * f2));
        if (i17 < 0) {
            f10 = f12 / (i10 - i17);
        } else {
            int i18 = bVar.f18222b;
            if (i17 >= i18) {
                f10 = ((i18 - 1) - i10) / (i17 - i10);
                i14 = i18 - 1;
            } else {
                i14 = i17;
                f10 = 1.0f;
            }
        }
        return (I(i3, i10, (int) (((i13 - i3) * f10) + i3), i14) + I) - 1.0f;
    }

    @Override // l1.g
    public ClipData a() {
        ClipData clip;
        clip = ((ContentInfo) this.f7855b).getClip();
        return clip;
    }

    @Override // com.google.android.material.internal.z
    public x1 b(View view, x1 x1Var, com.google.android.material.internal.a0 a0Var) {
        boolean z5;
        BottomAppBar bottomAppBar = (BottomAppBar) this.f7855b;
        if (bottomAppBar.f10234b0) {
            bottomAppBar.f10240h0 = x1Var.a();
        }
        boolean z6 = false;
        if (bottomAppBar.f10235c0) {
            z5 = bottomAppBar.f10241j0 != x1Var.b();
            bottomAppBar.f10241j0 = x1Var.b();
        } else {
            z5 = false;
        }
        if (bottomAppBar.f10236d0) {
            boolean z8 = bottomAppBar.i0 != x1Var.c();
            bottomAppBar.i0 = x1Var.c();
            z6 = z8;
        }
        if (!z5 && !z6) {
            return x1Var;
        }
        AnimatorSet animatorSet = bottomAppBar.U;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = bottomAppBar.T;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        bottomAppBar.E();
        bottomAppBar.D();
        return x1Var;
    }

    @Override // d4.r
    public d4.q c(d4.x xVar) {
        switch (this.f7854a) {
            case 13:
                return new d4.b(0, (AssetManager) this.f7855b, this);
            case 14:
                return new d4.f0(this);
            default:
                return new e4.a((f0) this.f7855b);
        }
    }

    @Override // h.i
    public boolean d(h.k kVar, MenuItem menuItem) {
        int i3 = NavigationBarView.f10682f;
        NavigationBarView navigationBarView = (NavigationBarView) this.f7855b;
        navigationBarView.getClass();
        navigationBarView.getClass();
        return false;
    }

    @Override // ia.a
    public void e() {
        ((CountDownLatch) this.f7855b).countDown();
    }

    @Override // h8.a
    public Object execute() {
        f8.h hVar = (f8.h) this.f7855b;
        SQLiteDatabase b3 = ((g8.g) hVar.f13527b).b();
        b3.beginTransaction();
        try {
            List list = (List) g8.g.h(b3.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), g8.d.f13884a);
            b3.setTransactionSuccessful();
            b3.endTransaction();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hVar.f13528c.a((a8.b) it.next(), 1, false);
            }
            return null;
        } catch (Throwable th2) {
            b3.endTransaction();
            throw th2;
        }
    }

    @Override // d4.e0
    public com.bumptech.glide.load.data.e f(Uri uri) {
        return new com.bumptech.glide.load.data.a((ContentResolver) this.f7855b, uri, 1);
    }

    @Override // l1.g
    public int g() {
        int flags;
        flags = ((ContentInfo) this.f7855b).getFlags();
        return flags;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (r5 == 12) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        if (r5 == 12) goto L25;
     */
    @Override // t6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(int r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f7855b
            com.example.test.ui.device.activity.WashHandActivity r0 = (com.example.test.ui.device.activity.WashHandActivity) r0
            boolean r1 = r0.G
            r2 = 1
            r3 = 0
            r4 = 12
            if (r1 == 0) goto L3d
            boolean r1 = android.text.format.DateFormat.is24HourFormat(r0)
            if (r1 == 0) goto L21
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setStartHour(r8)
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setStartMin(r9)
            goto L6d
        L21:
            com.example.blesdk.bean.function.DrinkReminderBean r1 = r0.S0()
            int r5 = r8 + 1
            if (r7 != r2) goto L2e
            if (r5 >= r4) goto L31
            int r3 = r8 + 13
            goto L32
        L2e:
            if (r5 != r4) goto L31
            goto L32
        L31:
            r3 = r5
        L32:
            r1.setStartHour(r3)
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setStartMin(r9)
            goto L6d
        L3d:
            boolean r1 = android.text.format.DateFormat.is24HourFormat(r0)
            if (r1 == 0) goto L52
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setEndHour(r8)
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setEndMin(r9)
            goto L6d
        L52:
            com.example.blesdk.bean.function.DrinkReminderBean r1 = r0.S0()
            int r5 = r8 + 1
            if (r7 != r2) goto L5f
            if (r5 >= r4) goto L62
            int r3 = r8 + 13
            goto L63
        L5f:
            if (r5 != r4) goto L62
            goto L63
        L62:
            r3 = r5
        L63:
            r1.setEndHour(r3)
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setEndMin(r9)
        L6d:
            r0.R0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.e0.h(int, int, int):void");
    }

    @Override // d4.a
    public com.bumptech.glide.load.data.e i(AssetManager assetManager, String str) {
        return new com.bumptech.glide.load.data.k(assetManager, str, 0);
    }

    @Override // a7.f
    public void j(int i3) {
        TextView textView;
        SportTypeFragment sportTypeFragment = (SportTypeFragment) this.f7855b;
        sportTypeFragment.f8189d = i3;
        ((com.example.test.presenter.sport.z) sportTypeFragment.X()).k(sportTypeFragment.f8189d);
        if (sportTypeFragment.f8189d == 4) {
            r3 r3Var = (r3) sportTypeFragment.f7251b;
            View view = r3Var != null ? r3Var.f13281b : null;
            if (view != null) {
                view.setAlpha(0.15f);
            }
            r3 r3Var2 = (r3) sportTypeFragment.f7251b;
            textView = r3Var2 != null ? r3Var2.f13283d : null;
            if (textView == null) {
                return;
            }
            textView.setText(sportTypeFragment.getString(R$string.str_run_indoor_total_distance));
            return;
        }
        r3 r3Var3 = (r3) sportTypeFragment.f7251b;
        View view2 = r3Var3 != null ? r3Var3.f13281b : null;
        if (view2 != null) {
            view2.setAlpha(0.0f);
        }
        r3 r3Var4 = (r3) sportTypeFragment.f7251b;
        textView = r3Var4 != null ? r3Var4.f13283d : null;
        if (textView == null) {
            return;
        }
        textView.setText(sportTypeFragment.getString(R$string.str_run_outdoor_total_distance));
    }

    @Override // h.i
    public void k(h.k kVar) {
    }

    @Override // l1.g
    public ContentInfo l() {
        return (ContentInfo) this.f7855b;
    }

    @Override // l1.g
    public int m() {
        int source;
        source = ((ContentInfo) this.f7855b).getSource();
        return source;
    }

    @Override // lc.a
    public int n() {
        return ((zzu) this.f7855b).zza;
    }

    @Override // lc.a
    public String o() {
        return ((zzu) this.f7855b).zzc;
    }

    @Override // t6.b
    public void onCancel() {
        switch (this.f7854a) {
            case 6:
                ((StartActivity) this.f7855b).finish();
                break;
            default:
                ((j2.f0) this.f7855b).cancel();
                break;
        }
    }

    @Override // ia.d
    public void onSuccess(Object obj) {
        ((CountDownLatch) this.f7855b).countDown();
    }

    @Override // lc.a
    public Rect p() {
        zzu zzuVar = (zzu) this.f7855b;
        if (zzuVar.zze == null) {
            return null;
        }
        int i3 = 0;
        int i10 = Integer.MIN_VALUE;
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = zzuVar.zze;
            if (i3 >= pointArr.length) {
                return new Rect(i11, i12, i10, i13);
            }
            Point point = pointArr[i3];
            i11 = Math.min(i11, point.x);
            i10 = Math.max(i10, point.x);
            i12 = Math.min(i12, point.y);
            i13 = Math.max(i13, point.y);
            i3++;
        }
    }

    @Override // lc.a
    public int q() {
        return ((zzu) this.f7855b).zzd;
    }

    @Override // lc.a
    public Point[] r() {
        return ((zzu) this.f7855b).zze;
    }

    @Override // t6.b
    public void s() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.M(Boolean.TRUE, "is_init_launcher");
        }
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a().d();
        StartActivity startActivity = (StartActivity) this.f7855b;
        int i3 = StartActivity.G;
        ((com.example.baselibrary.utils.e) startActivity.E.getValue()).sendEmptyMessageDelayed(1, Const.L_MAX_WAIT_WIFI);
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        Constructor constructor = (Constructor) this.f7855b;
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e10) {
            throw new RuntimeException("Failed to invoke " + constructor + " with no args", e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("Failed to invoke " + constructor + " with no args", e11.getTargetException());
        }
    }

    public String toString() {
        switch (this.f7854a) {
            case 24:
                return "ContentInfoCompat{" + ((ContentInfo) this.f7855b) + "}";
            default:
                return super.toString();
        }
    }

    @Override // ia.e
    public ia.m u(Object obj) {
        ((zzh) this.f7855b).getClass();
        return xc.c((List) obj);
    }

    @Override // a7.e
    public void u0() {
        switch (this.f7854a) {
            case 0:
                ((ScreenLongActivity) this.f7855b).onBackPressed();
                break;
            case 4:
                ((BPDetailActivity) this.f7855b).onBackPressed();
                break;
            default:
                ((BreatheDetailActivity) this.f7855b).onBackPressed();
                break;
        }
    }

    @Override // t6.a
    public void v(String data) {
        int i3 = this.f7854a;
        kotlin.jvm.internal.e.f(data, "data");
        switch (i3) {
            case 1:
                VaperPowerActivity vaperPowerActivity = (VaperPowerActivity) this.f7855b;
                vaperPowerActivity.E.setPowerLevel(vaperPowerActivity.F.indexOf(data));
                vaperPowerActivity.R0();
                break;
            default:
                int i10 = WomenHealthActivity.I;
                WomenHealthActivity womenHealthActivity = (WomenHealthActivity) this.f7855b;
                womenHealthActivity.R0().setRangeDays(Integer.parseInt(data));
                womenHealthActivity.S0();
                break;
        }
    }

    @Override // ia.c
    public void w(Exception exc) {
        ((CountDownLatch) this.f7855b).countDown();
    }

    @Override // bb.a
    public void x(Typeface typeface) {
        com.google.android.material.internal.b bVar = (com.google.android.material.internal.b) this.f7855b;
        bb.b bVar2 = bVar.f10588z;
        if (bVar2 != null) {
            bVar2.f3184c = true;
        }
        if (bVar.f10586x != typeface) {
            bVar.f10586x = typeface;
            bVar.i(false);
        }
    }

    @Override // t6.d
    public void y() {
        ((WashHandActivity) this.f7855b).G = false;
    }

    public float z(kd.c cVar, kd.c cVar2) {
        int i3 = (int) cVar.f11247a;
        int i10 = (int) cVar.f11248b;
        int i11 = (int) cVar2.f11247a;
        int i12 = (int) cVar2.f11248b;
        float J = J(i3, i10, i11, i12);
        float J2 = J((int) cVar2.f11247a, i12, (int) cVar.f11247a, i10);
        return Float.isNaN(J) ? J2 / 7.0f : Float.isNaN(J2) ? J / 7.0f : (J + J2) / 14.0f;
    }

    public /* synthetic */ e0(Object obj, int i3) {
        this.f7854a = i3;
        this.f7855b = obj;
    }

    public e0(int i3) {
        this.f7854a = i3;
        switch (i3) {
            case 15:
                this.f7855b = new f0(12);
                break;
            case 20:
                this.f7855b = new CountDownLatch(1);
                break;
            case 22:
                char[] cArr = t4.l.f18523a;
                this.f7855b = new ArrayDeque(0);
                break;
            case 25:
                this.f7855b = new m1.e(this);
                break;
        }
    }

    public e0(ContentInfo contentInfo) {
        this.f7854a = 24;
        contentInfo.getClass();
        this.f7855b = je.c.i(contentInfo);
    }
}
