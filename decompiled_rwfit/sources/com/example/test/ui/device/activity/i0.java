package com.example.test.ui.device.activity;

import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.g2;
import androidx.recyclerview.widget.z1;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.VaperPowerBean;
import com.example.test.presenter.device.j1;
import com.example.test.presenter.device.l1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.main.activity.BODetailActivity;
import com.example.test.ui.main.activity.BTDetailActivity;
import com.example.test.ui.main.activity.SleepDetailActivity;
import com.example.test.ui.main.activity.SugarDetailActivity;
import com.example.test.ui.view.DateSelectView;
import com.google.android.gms.internal.mlkit_vision_barcode.bc;
import com.google.android.gms.internal.mlkit_vision_barcode.wf;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import com.google.android.gms.internal.mlkit_vision_barcode.zf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.otaliastudios.cameraview.CameraView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import f6.w2;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.WeakHashMap;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public final class i0 implements a7.e, t6.a, bb.a, d4.r, d4.e0, h8.a, ia.e, x3.d, c8.b, g2, com.dh.imagepick.preview.d, ia.d, l1.w, l1.e, m4.k, zf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7865a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7866b;

    public /* synthetic */ i0(Object obj, int i3) {
        this.f7865a = i3;
        this.f7866b = obj;
    }

    public static i0 o(int i3, int i10, int i11, int i12, boolean z5) {
        return new i0(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i10, i11, i12, false, z5), 27);
    }

    private final void p() {
    }

    private final void q() {
    }

    private final void r() {
    }

    private final void s() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.e
    public void B() {
        Object obj = this.f7866b;
        switch (this.f7865a) {
            case 0:
                int i3 = VaperPowerActivity.H;
                VaperPowerActivity vaperPowerActivity = (VaperPowerActivity) obj;
                j1 j1Var = (j1) vaperPowerActivity.I0();
                VaperPowerBean data = vaperPowerActivity.E;
                j1Var.getClass();
                kotlin.jvm.internal.e.f(data, "data");
                j1Var.f7441b = data;
                ((XXBaseActivity) ((f7.a0) j1Var.f7255a)).V();
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) -108);
                    break;
                } else {
                    x5.c b3 = x5.c.b();
                    int powerLevel = data.getPowerLevel();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(powerLevel, "getVaperPowerWCmdJL "));
                    char[] cArr = y5.b.f20001a;
                    b3.g((byte) -108, new byte[]{2, 97, 0, (byte) (powerLevel & 255)}, new boolean[0]);
                    break;
                }
            case 1:
                int i10 = WashHandActivity.J;
                WashHandActivity washHandActivity = (WashHandActivity) obj;
                washHandActivity.S0().setOpen(((w2) washHandActivity.f7247z.getValue()).f13427g.getItemOpen());
                l1 l1Var = (l1) washHandActivity.I0();
                DrinkReminderBean data2 = washHandActivity.S0();
                l1Var.getClass();
                kotlin.jvm.internal.e.f(data2, "data");
                l1Var.f7458b = data2;
                ((XXBaseActivity) ((f7.k) l1Var.f7255a)).V();
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) -55);
                    break;
                } else {
                    x5.c b10 = x5.c.b();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getWashHandReminderWCmdJL " + data2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(data2.isOpen() ? 1 : 0);
                    sb2.append(Byte.valueOf((byte) data2.getRepeatModel()[0]));
                    sb2.append(Byte.valueOf((byte) data2.getRepeatModel()[6]));
                    sb2.append(Byte.valueOf((byte) data2.getRepeatModel()[5]));
                    sb2.append(Byte.valueOf((byte) data2.getRepeatModel()[4]));
                    sb2.append(Byte.valueOf((byte) data2.getRepeatModel()[3]));
                    sb2.append(Byte.valueOf((byte) data2.getRepeatModel()[2]));
                    sb2.append(Byte.valueOf((byte) data2.getRepeatModel()[1]));
                    b10.g((byte) -55, new byte[]{2, 38, 0, y5.b.b(sb2.toString()), (byte) (data2.getStartHour() & 255), (byte) (data2.getStartMin() & 255), (byte) (data2.getEndHour() & 255), (byte) (data2.getEndMin() & 255), (byte) (data2.getRemindDuration() & 255)}, new boolean[0]);
                    break;
                }
        }
    }

    @Override // l1.w
    public x1 P(View view, x1 x1Var) {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.f7866b;
        WeakHashMap weakHashMap = z0.f15748a;
        x1 x1Var2 = l1.h0.b(collapsingToolbarLayout) ? x1Var : null;
        if (!k1.b.a(collapsingToolbarLayout.f10213y, x1Var2)) {
            collapsingToolbarLayout.f10213y = x1Var2;
            collapsingToolbarLayout.requestLayout();
        }
        return x1Var.f15738a.c();
    }

    @Override // l1.e
    public l1.h b() {
        ContentInfo build;
        build = ((ContentInfo.Builder) this.f7866b).build();
        return new l1.h(new e0(build));
    }

    @Override // d4.r
    public d4.q c(d4.x xVar) {
        switch (this.f7865a) {
            case 12:
                return new d4.c((d4.c0) this.f7866b, 1);
            default:
                return new d4.f0(this);
        }
    }

    @Override // x3.d
    public void d(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l3 = (Long) obj;
        messageDigest.update(bArr);
        synchronized (((ByteBuffer) this.f7866b)) {
            ((ByteBuffer) this.f7866b).position(0);
            messageDigest.update(((ByteBuffer) this.f7866b).putLong(l3.longValue()).array());
        }
    }

    @Override // com.dh.imagepick.preview.d
    public void e(z1 viewHolder, View view, float f2) {
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
        com.dh.imagepick.preview.e eVar = ((h5.a) this.f7866b).f14261b;
        if (eVar != null) {
            eVar.e(viewHolder, view, f2);
        }
    }

    @Override // h8.a
    public Object execute() {
        g8.g gVar = (g8.g) ((g8.c) this.f7866b);
        long c9 = gVar.f13888b.c() - gVar.f13890d.f13880d;
        SQLiteDatabase b3 = gVar.b();
        b3.beginTransaction();
        try {
            int delete = b3.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(c9)});
            b3.setTransactionSuccessful();
            b3.endTransaction();
            return Integer.valueOf(delete);
        } catch (Throwable th2) {
            b3.endTransaction();
            throw th2;
        }
    }

    @Override // d4.e0
    public com.bumptech.glide.load.data.e f(Uri uri) {
        return new com.bumptech.glide.load.data.a((ContentResolver) this.f7866b, uri, 0);
    }

    @Override // com.dh.imagepick.preview.d
    public void g(z1 viewHolder, View view) {
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
        com.dh.imagepick.preview.e eVar = ((h5.a) this.f7866b).f14261b;
        if (eVar != null) {
            eVar.g(viewHolder, view);
        }
    }

    @Override // dh.a
    public Object get() {
        return new g8.g(new gc.b(13), new ec.a(13), g8.a.f13876f, (g8.j) ((b8.e) this.f7866b).get());
    }

    @Override // l1.e
    public void h(Uri uri) {
        ((ContentInfo.Builder) this.f7866b).setLinkUri(uri);
    }

    @Override // com.dh.imagepick.preview.d
    public void i(z1 viewHolder, View view, float f2) {
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
        com.dh.imagepick.preview.e eVar = ((h5.a) this.f7866b).f14261b;
        if (eVar != null) {
            eVar.i(viewHolder, view, f2);
        }
    }

    @Override // l1.e
    public void j(int i3) {
        ((ContentInfo.Builder) this.f7866b).setFlags(i3);
    }

    public ValueAnimator k(int i3) {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f7866b;
        return smartRefreshLayout.m(i3, 0, smartRefreshLayout.f11685z, smartRefreshLayout.f11650f);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(int r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 761
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.i0.l(int, boolean):void");
    }

    @Override // androidx.appcompat.widget.g2
    public void m(h.k kVar, h.m mVar) {
        h.e eVar = (h.e) this.f7866b;
        eVar.f14110f.removeCallbacksAndMessages(null);
        ArrayList arrayList = eVar.f14112h;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (kVar == ((h.d) arrayList.get(i3)).f14104b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == -1) {
            return;
        }
        int i10 = i3 + 1;
        eVar.f14110f.postAtTime(new wf(this, i10 < arrayList.size() ? (h.d) arrayList.get(i10) : null, mVar, kVar, 4), kVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.g2
    public void n(h.k kVar, h.m mVar) {
        ((h.e) this.f7866b).f14110f.removeCallbacksAndMessages(kVar);
    }

    @Override // ia.d
    public void onSuccess(Object obj) {
        ((ia.g) ((i0) this.f7866b).f7866b).f14382a.i();
    }

    @Override // l1.e
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f7866b).setExtras(bundle);
    }

    public void t(float f2, float f10, float f11) {
        j7.m mVar = (j7.m) this.f7866b;
        if (mVar.d() < mVar.e || f2 < 1.0f) {
            if (mVar.d() > mVar.f15350c || f2 > 1.0f) {
                mVar.getClass();
                mVar.f15359m.postScale(f2, f2, f10, f11);
                mVar.a();
            }
        }
    }

    public String toString() {
        switch (this.f7865a) {
            case Const.ANDROID_VERSION_28 /* 28 */:
                return super.toString() + "{fragment=" + ((m4.l) this.f7866b) + "}";
            default:
                return super.toString();
        }
    }

    @Override // ia.e
    public ia.m u(Object obj) {
        ef.c cVar = (ef.c) obj;
        if (cVar == null) {
            throw new RuntimeException("Null options!");
        }
        ef.i iVar = ((ff.q) this.f7866b).f13647c;
        ((ef.b) iVar.f12629b).b(1, "dispatchOnCameraOpened", cVar);
        ((CameraView) iVar.f12630c).f11550j.post(new x.h(iVar, 11, cVar, false));
        return xc.c(null);
    }

    @Override // a7.e
    public void u0() {
        switch (this.f7865a) {
            case 0:
                ((VaperPowerActivity) this.f7866b).onBackPressed();
                break;
            case 1:
                ((WashHandActivity) this.f7866b).onBackPressed();
                break;
            case 2:
            default:
                ((SugarDetailActivity) this.f7866b).onBackPressed();
                break;
            case 3:
                ((BODetailActivity) this.f7866b).onBackPressed();
                break;
            case 4:
                ((BTDetailActivity) this.f7866b).onBackPressed();
                break;
            case 5:
                ((SleepDetailActivity) this.f7866b).onBackPressed();
                break;
        }
    }

    @Override // t6.a
    public void v(String data) {
        Date date;
        Object obj = this.f7866b;
        int i3 = this.f7865a;
        kotlin.jvm.internal.e.f(data, "data");
        switch (i3) {
            case 2:
                int i10 = WomenHealthActivity.I;
                WomenHealthActivity womenHealthActivity = (WomenHealthActivity) obj;
                womenHealthActivity.R0().setMensDays(Integer.parseInt(data));
                womenHealthActivity.S0();
                break;
            default:
                DateSelectView dateSelectView = (DateSelectView) obj;
                Calendar calendar = dateSelectView.f8375b;
                if (calendar != null) {
                    try {
                        date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(data);
                    } catch (Exception unused) {
                        date = null;
                    }
                    if (date == null) {
                        date = new Date();
                    }
                    calendar.setTime(date);
                }
                dateSelectView.f();
                break;
        }
    }

    public void w(RefreshState refreshState) {
        int i3 = dg.a.f12384a[refreshState.ordinal()];
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f7866b;
        switch (i3) {
            case 1:
                RefreshState refreshState2 = smartRefreshLayout.f11654g1;
                RefreshState refreshState3 = RefreshState.None;
                if (refreshState2 != refreshState3 && smartRefreshLayout.f11639b == 0) {
                    smartRefreshLayout.u(refreshState3);
                    break;
                } else if (smartRefreshLayout.f11639b != 0) {
                    k(0);
                    break;
                }
                break;
            case 2:
                if (!smartRefreshLayout.f11654g1.isOpening && smartRefreshLayout.r(smartRefreshLayout.B)) {
                    smartRefreshLayout.u(RefreshState.PullDownToRefresh);
                    break;
                } else {
                    smartRefreshLayout.setViceState(RefreshState.PullDownToRefresh);
                    break;
                }
                break;
            case 3:
                if (smartRefreshLayout.r(smartRefreshLayout.C)) {
                    RefreshState refreshState4 = smartRefreshLayout.f11654g1;
                    if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout.T || !smartRefreshLayout.H || !smartRefreshLayout.U)) {
                        smartRefreshLayout.u(RefreshState.PullUpToLoad);
                        break;
                    }
                }
                smartRefreshLayout.setViceState(RefreshState.PullUpToLoad);
                break;
            case 4:
                if (!smartRefreshLayout.f11654g1.isOpening && smartRefreshLayout.r(smartRefreshLayout.B)) {
                    smartRefreshLayout.u(RefreshState.PullDownCanceled);
                    w(RefreshState.None);
                    break;
                } else {
                    smartRefreshLayout.setViceState(RefreshState.PullDownCanceled);
                    break;
                }
            case 5:
                if (smartRefreshLayout.r(smartRefreshLayout.C) && !smartRefreshLayout.f11654g1.isOpening && (!smartRefreshLayout.T || !smartRefreshLayout.H || !smartRefreshLayout.U)) {
                    smartRefreshLayout.u(RefreshState.PullUpCanceled);
                    w(RefreshState.None);
                    break;
                } else {
                    smartRefreshLayout.setViceState(RefreshState.PullUpCanceled);
                    break;
                }
                break;
            case 6:
                if (!smartRefreshLayout.f11654g1.isOpening && smartRefreshLayout.r(smartRefreshLayout.B)) {
                    smartRefreshLayout.u(RefreshState.ReleaseToRefresh);
                    break;
                } else {
                    smartRefreshLayout.setViceState(RefreshState.ReleaseToRefresh);
                    break;
                }
                break;
            case 7:
                if (smartRefreshLayout.r(smartRefreshLayout.C)) {
                    RefreshState refreshState5 = smartRefreshLayout.f11654g1;
                    if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout.T || !smartRefreshLayout.H || !smartRefreshLayout.U)) {
                        smartRefreshLayout.u(RefreshState.ReleaseToLoad);
                        break;
                    }
                }
                smartRefreshLayout.setViceState(RefreshState.ReleaseToLoad);
                break;
            case 8:
                if (!smartRefreshLayout.f11654g1.isOpening && smartRefreshLayout.r(smartRefreshLayout.B)) {
                    smartRefreshLayout.u(RefreshState.ReleaseToTwoLevel);
                    break;
                } else {
                    smartRefreshLayout.setViceState(RefreshState.ReleaseToTwoLevel);
                    break;
                }
                break;
            case 9:
                if (!smartRefreshLayout.f11654g1.isOpening && smartRefreshLayout.r(smartRefreshLayout.B)) {
                    smartRefreshLayout.u(RefreshState.RefreshReleased);
                    break;
                } else {
                    smartRefreshLayout.setViceState(RefreshState.RefreshReleased);
                    break;
                }
            case 10:
                if (!smartRefreshLayout.f11654g1.isOpening && smartRefreshLayout.r(smartRefreshLayout.C)) {
                    smartRefreshLayout.u(RefreshState.LoadReleased);
                    break;
                } else {
                    smartRefreshLayout.setViceState(RefreshState.LoadReleased);
                    break;
                }
                break;
            case 11:
                smartRefreshLayout.setStateRefreshing(true);
                break;
            case 12:
                smartRefreshLayout.setStateLoading(true);
                break;
            default:
                smartRefreshLayout.u(refreshState);
                break;
        }
    }

    @Override // bb.a
    public void x(Typeface typeface) {
        com.google.android.material.internal.b bVar = (com.google.android.material.internal.b) this.f7866b;
        bb.b bVar2 = bVar.A;
        if (bVar2 != null) {
            bVar2.f3184c = true;
        }
        if (bVar.f10585w != typeface) {
            bVar.f10585w = typeface;
            bVar.i(false);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zf
    public androidx.appcompat.widget.b0 zza() {
        n.g0 g0Var = new n.g0();
        g0Var.f16176c = mc.a.c() ? zzra.TYPE_THICK : zzra.TYPE_THIN;
        e0 e0Var = new e0(8);
        e0Var.f7855b = (zzrb) this.f7866b;
        g0Var.e = new bc(e0Var);
        return new androidx.appcompat.widget.b0(g0Var, 0);
    }

    public i0(ViewGroup viewGroup) {
        this.f7865a = 10;
        this.f7866b = viewGroup.getOverlay();
    }

    public i0(int i3) {
        this.f7865a = i3;
        switch (i3) {
            case 18:
                this.f7866b = ByteBuffer.allocate(8);
                break;
            default:
                this.f7866b = new d4.c0(7);
                break;
        }
    }

    public i0(Field field) {
        this.f7865a = 11;
        this.f7866b = field;
        field.setAccessible(true);
    }

    public i0(ClipData clipData, int i3) {
        this.f7865a = 26;
        this.f7866b = je.c.g(clipData, i3);
    }
}
