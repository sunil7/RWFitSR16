package af;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.i0;
import androidx.camera.camera2.internal.compat.f;
import androidx.camera.core.impl.q0;
import androidx.camera.core.impl.r0;
import androidx.lifecycle.c0;
import androidx.swiperefreshlayout.widget.j;
import cf.e;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dh.imagepick.preview.ImageViewerDialogFragment;
import com.example.blesdk.bean.function.ReminderModeBean;
import com.example.test.R$id;
import com.example.test.ui.device.activity.DialListActivity;
import com.example.test.ui.device.adapter.TRingOptionAdapter;
import com.example.test.ui.device.fragment.DialRecommendFragment;
import com.example.test.ui.device.model.AlarmModel;
import com.example.test.ui.device.model.DialTypeModel;
import com.example.test.ui.device.model.OptionModel;
import com.example.test.ui.dialog.p;
import com.example.test.ui.mine.activity.AboutActivity;
import com.example.test.ui.mine.activity.MyQrCodeActivity;
import com.example.test.ui.mine.activity.PersonalJLActivity;
import com.example.test.ui.mine.activity.SettingActivity;
import com.example.test.ui.testui.TMainRingActivity;
import com.example.test.ui.testui.TRingFamilyActivity;
import com.example.test.ui.testui.TRingOptionActivity;
import com.example.test.ui.testui.TringAlarmAddActivity;
import com.example.test.utils.s;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import com.google.android.material.navigation.h;
import com.loper7.date_time_picker.number_picker.NumberPicker;
import de.l;
import java.util.Calendar;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import md.m;
import n.z0;
import n0.g;
import rg.n;
import rg.o;
import t.p0;
import t.s0;
import u.c;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements e, g, c0, o, OnItemChildClickListener, OnItemClickListener, r3.a, h, j, m, vg.g, l, q0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f276a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f277b;

    public /* synthetic */ a(Object obj, int i3) {
        this.f276a = i3;
        this.f277b = obj;
    }

    @Override // com.google.android.material.navigation.h
    public boolean a(MenuItem menuItem) {
        int i3 = TMainRingActivity.J;
        TMainRingActivity this$0 = (TMainRingActivity) this.f277b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId == R$id.nav_qcoder) {
            this$0.startActivity(new Intent(this$0, (Class<?>) MyQrCodeActivity.class));
            this$0.R0();
            return true;
        }
        if (itemId == R$id.nav_persional) {
            this$0.startActivity(new Intent(this$0, (Class<?>) PersonalJLActivity.class));
            this$0.R0();
            return true;
        }
        if (itemId == R$id.nav_settings) {
            this$0.startActivity(new Intent(this$0, (Class<?>) SettingActivity.class));
            this$0.R0();
            return true;
        }
        if (itemId != R$id.nav_about) {
            return false;
        }
        this$0.startActivity(new Intent(this$0, (Class<?>) AboutActivity.class));
        this$0.R0();
        return true;
    }

    @Override // n0.g
    public Object b(androidx.concurrent.futures.b bVar) {
        String str;
        switch (this.f276a) {
            case 1:
                c0.m mVar = (c0.m) this.f277b;
                mVar.f3327p = bVar;
                return "SettableFuture hashCode: " + mVar.hashCode();
            case 2:
                ((c0.o) this.f277b).f3352k = bVar;
                return "SurfaceOutputImpl close future complete";
            case 17:
                ((h0.l) this.f277b).f14246k.set(bVar);
                return "textureViewImpl_waitForNextFrame";
            case 18:
                n.h hVar = (n.h) this.f277b;
                hVar.getClass();
                hVar.f16180c.execute(new i0(21, hVar, bVar));
                return "updateSessionConfigAsync";
            case 21:
                androidx.camera.camera2.internal.m mVar2 = (androidx.camera.camera2.internal.m) this.f277b;
                synchronized (mVar2.f1267a) {
                    pd.f("Release completer expected to be null", mVar2.f1276k == null);
                    mVar2.f1276k = bVar;
                    str = "Release[session=" + mVar2 + "]";
                }
                return str;
            default:
                f fVar = (f) this.f277b;
                fVar.f1164b = bVar;
                return "RequestCompleteListener[" + fVar + "]";
        }
    }

    @Override // androidx.camera.core.impl.q0
    public void c(r0 r0Var) {
        switch (this.f276a) {
            case 22:
                z0 z0Var = (z0) this.f277b;
                z0Var.getClass();
                try {
                    p0 k10 = r0Var.k();
                    if (k10 != null) {
                        z0Var.f16329b.o(k10);
                        return;
                    }
                    return;
                } catch (IllegalStateException e) {
                    a0.b("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e.getMessage());
                    return;
                }
            case 26:
                s0 s0Var = (s0) this.f277b;
                synchronized (s0Var.f18393a) {
                    s0Var.f18395c++;
                }
                s0Var.f(r0Var);
                return;
            default:
                ((c) this.f277b).getClass();
                try {
                    p0 k11 = r0Var.k();
                    if (k11 != null) {
                        y5.a();
                        a0.e("CaptureNode", "Discarding ImageProxy which was inadvertently acquired: " + k11);
                        k11.close();
                        return;
                    }
                    return;
                } catch (IllegalStateException unused) {
                    return;
                }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, kotlin.jvm.internal.Lambda, oh.l] */
    @Override // rg.o
    public void d(n nVar) {
        ?? runBlock = (Lambda) this.f277b;
        kotlin.jvm.internal.e.f(runBlock, "$runBlock");
        Object invoke = runBlock.invoke("");
        if (invoke != null) {
            nVar.onNext(invoke);
        }
    }

    @Override // r3.a
    public void e(int i3, int i10, int i11) {
        Object obj = this.f277b;
        switch (this.f276a) {
            case 7:
                com.example.test.ui.dialog.l this$0 = (com.example.test.ui.dialog.l) obj;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                this$0.f7981b = (String) this$0.f7980a.get(i3);
                break;
            case 8:
                p this$02 = (p) obj;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                this$02.f8008b = (String) this$02.f8007a.get(i3);
                break;
            default:
                TringAlarmAddActivity this$03 = (TringAlarmAddActivity) obj;
                kotlin.jvm.internal.e.f(this$03, "this$0");
                if (!DateFormat.is24HourFormat(this$03)) {
                    int i12 = TringAlarmAddActivity.N;
                    AlarmModel R0 = this$03.R0();
                    int i13 = i10 + 1;
                    if (i3 == 1) {
                        if (i13 < 12) {
                            i13 = i10 + 13;
                        }
                    } else if (i13 == 12) {
                        i13 = 0;
                    }
                    R0.setStartHour(i13);
                    this$03.R0().setStartMin(i11);
                    break;
                } else {
                    int i14 = TringAlarmAddActivity.N;
                    this$03.R0().setStartHour(i3);
                    this$03.R0().setStartMin(i10);
                    break;
                }
        }
    }

    @Override // vg.g
    public void f(Object obj) {
        switch (this.f276a) {
            case 14:
                com.example.test.ui.view.e this$0 = (com.example.test.ui.view.e) this.f277b;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                this$0.b();
                break;
            default:
                ((s) this.f277b).c();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", android.support.v4.media.session.e.p((Throwable) obj, new StringBuilder("获取位置错误 ")));
                break;
        }
    }

    @Override // cf.e
    public void g(int i3, int i10) {
        NumberPicker numberPicker;
        b this$0 = (b) this.f277b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        Calendar calendar = this$0.f283g;
        if (calendar == null) {
            kotlin.jvm.internal.e.m("calendar");
            throw null;
        }
        calendar.clear();
        NumberPicker numberPicker2 = this$0.f278a;
        if (numberPicker2 != null) {
            Calendar calendar2 = this$0.f283g;
            if (calendar2 == null) {
                kotlin.jvm.internal.e.m("calendar");
                throw null;
            }
            calendar2.set(1, numberPicker2.getValue());
        }
        NumberPicker numberPicker3 = this$0.f279b;
        if (numberPicker3 != null) {
            Calendar calendar3 = this$0.f283g;
            if (calendar3 == null) {
                kotlin.jvm.internal.e.m("calendar");
                throw null;
            }
            calendar3.set(2, numberPicker3.getValue() - 1);
        }
        NumberPicker numberPicker4 = this$0.f278a;
        Integer valueOf = numberPicker4 == null ? null : Integer.valueOf(numberPicker4.getValue());
        NumberPicker numberPicker5 = this$0.f279b;
        int b3 = b.b(valueOf, Integer.valueOf((numberPicker5 == null ? 0 : numberPicker5.getValue()) - 1));
        NumberPicker numberPicker6 = this$0.f280c;
        if ((numberPicker6 != null ? numberPicker6.getValue() : 0) >= b3 && (numberPicker = this$0.f280c) != null) {
            numberPicker.setValue(b3);
        }
        NumberPicker numberPicker7 = this$0.f280c;
        if (numberPicker7 != null) {
            Calendar calendar4 = this$0.f283g;
            if (calendar4 == null) {
                kotlin.jvm.internal.e.m("calendar");
                throw null;
            }
            calendar4.set(5, numberPicker7.getValue());
        }
        NumberPicker numberPicker8 = this$0.f281d;
        if (numberPicker8 != null) {
            Calendar calendar5 = this$0.f283g;
            if (calendar5 == null) {
                kotlin.jvm.internal.e.m("calendar");
                throw null;
            }
            calendar5.set(11, numberPicker8.getValue());
        }
        NumberPicker numberPicker9 = this$0.e;
        if (numberPicker9 != null) {
            Calendar calendar6 = this$0.f283g;
            if (calendar6 == null) {
                kotlin.jvm.internal.e.m("calendar");
                throw null;
            }
            calendar6.set(12, numberPicker9.getValue());
        }
        NumberPicker numberPicker10 = this$0.f282f;
        if (numberPicker10 != null) {
            Calendar calendar7 = this$0.f283g;
            if (calendar7 == null) {
                kotlin.jvm.internal.e.m("calendar");
                throw null;
            }
            calendar7.set(13, numberPicker10.getValue());
        }
        this$0.c();
        this$0.d();
    }

    @Override // androidx.lifecycle.c0
    public void i(Object obj) {
        switch (this.f276a) {
            case 3:
                Pair pair = (Pair) obj;
                ImageViewerDialogFragment imageViewerDialogFragment = (ImageViewerDialogFragment) this.f277b;
                imageViewerDialogFragment.getClass();
                String str = pair != null ? (String) pair.getFirst() : null;
                if (!kotlin.jvm.internal.e.a(str, "setCurrentItem")) {
                    if (kotlin.jvm.internal.e.a(str, "dismiss")) {
                        imageViewerDialogFragment.X();
                        break;
                    }
                } else {
                    e5.a aVar = imageViewerDialogFragment.f7122q;
                    kotlin.jvm.internal.e.c(aVar);
                    Object second = pair.getSecond();
                    kotlin.jvm.internal.e.d(second, "null cannot be cast to non-null type kotlin.Int");
                    aVar.f12465c.setCurrentItem(Math.max(((Integer) second).intValue(), 0));
                    break;
                }
                break;
            default:
                ((n.n) this.f277b).k(obj);
                break;
        }
    }

    @Override // androidx.swiperefreshlayout.widget.j
    public void j() {
        int i3 = TRingFamilyActivity.J;
        TRingFamilyActivity this$0 = (TRingFamilyActivity) this.f277b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        new Handler().postDelayed(new androidx.activity.b(this$0, 21), 2000L);
    }

    @Override // de.l
    public void k(Object obj) {
        ((rd.c) obj).r((BluetoothDevice) this.f277b);
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        DialRecommendFragment this$0 = (DialRecommendFragment) this.f277b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        if (i3 <= -1 || i3 >= this$0.q0().size()) {
            return;
        }
        int i10 = DialListActivity.L;
        Context f02 = this$0.f0();
        String type = ((DialTypeModel) this$0.q0().get(i3)).getType();
        kotlin.jvm.internal.e.e(type, "getType(...)");
        int classifyId = ((DialTypeModel) this$0.q0().get(i3)).getClassifyId();
        Intent intent = new Intent(f02, (Class<?>) DialListActivity.class);
        intent.putExtra("dial_type", type);
        intent.putExtra("type_id", classifyId);
        f02.startActivity(intent);
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        Object obj = this.f277b;
        switch (this.f276a) {
            case 6:
                com.example.test.ui.dialog.j this$0 = (com.example.test.ui.dialog.j) obj;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
                t6.c cVar = this$0.f7968a;
                if (cVar != null) {
                    cVar.a(i3);
                    break;
                }
                break;
            default:
                int i10 = TRingOptionActivity.K;
                TRingOptionActivity this$02 = (TRingOptionActivity) obj;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
                boolean booleanValue = ((Boolean) this$02.F.getValue()).booleanValue();
                eh.b bVar = this$02.I;
                if (!booleanValue) {
                    ((OptionModel) this$02.T0().get(i3)).setCheck(!((OptionModel) this$02.T0().get(i3)).isCheck());
                    ((TRingOptionAdapter) bVar.getValue()).notifyItemChanged(i3);
                    break;
                } else {
                    Iterator it = this$02.T0().iterator();
                    while (it.hasNext()) {
                        ((OptionModel) it.next()).setCheck(false);
                    }
                    ((OptionModel) this$02.T0().get(i3)).setCheck(!((OptionModel) this$02.T0().get(i3)).isCheck());
                    ((TRingOptionAdapter) bVar.getValue()).notifyItemRangeChanged(0, this$02.T0().size());
                    if (((OptionModel) this$02.T0().get(i3)).isCheck()) {
                        ((ReminderModeBean) this$02.J.getValue()).setReminderMode(i3);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(oh.l lVar) {
        this.f276a = 4;
        this.f277b = (Lambda) lVar;
    }
}
