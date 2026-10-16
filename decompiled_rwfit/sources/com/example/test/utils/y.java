package com.example.test.utils;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Handler;
import android.os.PowerManager;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.core.CameraState$Type;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.r1;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.w1;
import androidx.camera.core.impl.y1;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.load.EncodeStrategy;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.MemberFriendBean;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.CustomJLDialActivity;
import com.example.test.ui.sport.activity.SportCountDownActivity;
import com.example.test.ui.testui.TRingFamilyActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import com.google.android.gms.internal.mlkit_vision_barcode.c1;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Ref$ObjectRef;
import l1.g1;
import l1.x1;

/* loaded from: classes.dex */
public final class y implements c8.b, b, com.example.test.ui.view.r, t6.b, l1.w, x.c, h8.a, x3.h, g8.e, i6.h, rg.z, com.dh.imagepick.preview.widgets.b, androidx.camera.core.impl.n {

    /* renamed from: d, reason: collision with root package name */
    public static y f8771d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8772a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8773b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8774c;

    public /* synthetic */ y(int i3, Object obj, Object obj2) {
        this.f8772a = i3;
        this.f8774c = obj;
        this.f8773b = obj2;
    }

    public static boolean m(Editable editable, KeyEvent keyEvent, boolean z5) {
        androidx.emoji2.text.u[] uVarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (uVarArr = (androidx.emoji2.text.u[]) editable.getSpans(selectionStart, selectionEnd, androidx.emoji2.text.u.class)) != null && uVarArr.length > 0) {
                for (androidx.emoji2.text.u uVar : uVarArr) {
                    int spanStart = editable.getSpanStart(uVar);
                    int spanEnd = editable.getSpanEnd(uVar);
                    if ((z5 && spanStart == selectionStart) || ((!z5 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static y u() {
        int i3 = 0;
        Object[] objArr = 0;
        if (f8771d == null) {
            synchronized (y.class) {
                y yVar = new y(i3, objArr == true ? 1 : 0);
                XXApplication xXApplication = XXApplication.f7400h;
                yVar.f8773b = (PowerManager) j1.a().getSystemService("power");
                f8771d = yVar;
            }
        }
        return f8771d;
    }

    public void A() {
        PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.f8774c;
        if (wakeLock != null) {
            wakeLock.acquire();
            ((PowerManager.WakeLock) this.f8774c).setReferenceCounted(false);
        }
    }

    public void B(g.a aVar) {
        v2.h hVar = (v2.h) this.f8773b;
        ((ActionMode.Callback) hVar.f19146a).onDestroyActionMode(hVar.i(aVar));
        androidx.appcompat.app.c0 c0Var = (androidx.appcompat.app.c0) this.f8774c;
        if (c0Var.f443w != null) {
            c0Var.f433l.getDecorView().removeCallbacks(c0Var.f444x);
        }
        if (c0Var.f442v != null) {
            g1 g1Var = c0Var.f445y;
            if (g1Var != null) {
                g1Var.b();
            }
            g1 a3 = l1.z0.a(c0Var.f442v);
            a3.a(0.0f);
            c0Var.f445y = a3;
            a3.d(new androidx.appcompat.app.s(this, 2));
        }
        c0Var.f441u = null;
        ViewGroup viewGroup = c0Var.A;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.l0.c(viewGroup);
        c0Var.I();
    }

    @Override // x.c
    public void C(Throwable th2) {
        switch (this.f8772a) {
            case 16:
                int i3 = ((c0.n) this.f8773b).f3333f;
                if (i3 == 2 && (th2 instanceof CancellationException)) {
                    com.google.android.gms.internal.mlkit_vision_common.a0.a("DualSurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                    return;
                }
                com.google.android.gms.internal.mlkit_vision_common.a0.f("DualSurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + c1.a(i3), th2);
                return;
            default:
                throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th2);
        }
    }

    public boolean D(g.a aVar, h.k kVar) {
        ViewGroup viewGroup = ((androidx.appcompat.app.c0) this.f8774c).A;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.l0.c(viewGroup);
        v2.h hVar = (v2.h) this.f8773b;
        g.f i3 = hVar.i(aVar);
        m0.k kVar2 = (m0.k) hVar.f19149d;
        Menu menu = (Menu) kVar2.getOrDefault(kVar, null);
        if (menu == null) {
            menu = new h.a0((Context) hVar.f19147b, kVar);
            kVar2.put(kVar, menu);
        }
        return ((ActionMode.Callback) hVar.f19146a).onPrepareActionMode(i3, menu);
    }

    public void E(a4.i iVar, Object obj) {
        HashMap hashMap = (HashMap) this.f8774c;
        a4.d dVar = (a4.d) hashMap.get(iVar);
        if (dVar == null) {
            dVar = new a4.d(iVar);
            dVar.f83d = dVar;
            a4.d dVar2 = (a4.d) this.f8773b;
            dVar.f83d = dVar2.f83d;
            dVar.f82c = dVar2;
            dVar2.f83d = dVar;
            dVar.f83d.f82c = dVar;
            hashMap.put(iVar, dVar);
        } else {
            iVar.a();
        }
        if (dVar.f81b == null) {
            dVar.f81b = new ArrayList();
        }
        dVar.f81b.add(obj);
    }

    public void F() {
        PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.f8774c;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                try {
                    ((PowerManager.WakeLock) this.f8774c).release();
                } catch (Exception unused) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLockUtil", "电源锁释放异常");
                }
            }
            this.f8774c = null;
            f8771d = null;
        }
    }

    public void G() {
        PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.f8774c;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        try {
            ((PowerManager.WakeLock) this.f8774c).release();
        } catch (Exception unused) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLockUtil", "电源锁释放异常");
        }
    }

    public Object H() {
        a4.d dVar = (a4.d) this.f8773b;
        a4.d dVar2 = dVar.f83d;
        while (true) {
            if (dVar2.equals(dVar)) {
                return null;
            }
            ArrayList arrayList = dVar2.f81b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object remove = size > 0 ? dVar2.f81b.remove(size - 1) : null;
            if (remove != null) {
                return remove;
            }
            a4.d dVar3 = dVar2.f83d;
            dVar3.f82c = dVar2.f82c;
            dVar2.f82c.f83d = dVar3;
            HashMap hashMap = (HashMap) this.f8774c;
            a4.i iVar = dVar2.f80a;
            hashMap.remove(iVar);
            iVar.a();
            dVar2 = dVar2.f83d;
        }
    }

    public void I(int i3, int i10, int i11, int i12) {
        CardView cardView = (CardView) this.f8774c;
        cardView.f1603d.set(i3, i10, i11, i12);
        Rect rect = cardView.f1602c;
        super/*android.view.View*/.setPadding(i3 + rect.left, i10 + rect.top, i11 + rect.right, i12 + rect.bottom);
    }

    public void J(String str, s1 s1Var, a2 a2Var, androidx.camera.core.impl.h hVar, List list) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f8774c;
        if (linkedHashMap.containsKey(str)) {
            y1 y1Var = new y1(s1Var, a2Var, hVar, list);
            y1 y1Var2 = (y1) linkedHashMap.get(str);
            y1Var.e = y1Var2.e;
            y1Var.f1533f = y1Var2.f1533f;
            linkedHashMap.put(str, y1Var);
        }
    }

    @Override // l1.w
    public x1 P(View view, x1 x1Var) {
        switch (this.f8772a) {
            case 15:
                com.google.android.material.internal.a0 a0Var = new com.google.android.material.internal.a0();
                com.google.android.material.internal.a0 a0Var2 = (com.google.android.material.internal.a0) this.f8774c;
                a0Var.f10554a = a0Var2.f10554a;
                a0Var.f10555b = a0Var2.f10555b;
                a0Var.f10556c = a0Var2.f10556c;
                a0Var.f10557d = a0Var2.f10557d;
                return ((com.google.android.material.internal.z) this.f8773b).b(view, x1Var, a0Var);
            default:
                x1 h4 = l1.z0.h(view, x1Var);
                if (h4.f15738a.m()) {
                    return h4;
                }
                int b3 = h4.b();
                Rect rect = (Rect) this.f8773b;
                rect.left = b3;
                rect.top = h4.d();
                rect.right = h4.c();
                rect.bottom = h4.a();
                ViewPager viewPager = (ViewPager) this.f8774c;
                int childCount = viewPager.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    x1 b10 = l1.z0.b(viewPager.getChildAt(i3), h4);
                    rect.left = Math.min(b10.b(), rect.left);
                    rect.top = Math.min(b10.d(), rect.top);
                    rect.right = Math.min(b10.c(), rect.right);
                    rect.bottom = Math.min(b10.a(), rect.bottom);
                }
                return h4.f(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // androidx.camera.core.impl.n
    public w1 a() {
        return (w1) this.f8773b;
    }

    @Override // g8.e
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        x7.b bVar = g8.g.e;
        g8.g gVar = (g8.g) this.f8773b;
        gVar.getClass();
        ArrayList arrayList = new ArrayList();
        a8.b bVar2 = (a8.b) this.f8774c;
        Long c9 = g8.g.c(sQLiteDatabase, bVar2);
        if (c9 != null) {
            g8.g.h(sQLiteDatabase.query("events", new String[]{FileDownloadModel.ID, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{c9.toString()}, null, null, null, String.valueOf(gVar.f13890d.f13878b)), new de.o(gVar, 25, arrayList, bVar2));
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sb2.append(((g8.b) arrayList.get(i3)).f13881a);
            if (i3 < arrayList.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        Cursor query = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null);
        b2.h hVar = new b2.h();
        hVar.f3120a = hashMap;
        g8.g.h(query, hVar);
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            g8.b bVar3 = (g8.b) listIterator.next();
            if (hashMap.containsKey(Long.valueOf(bVar3.f13881a))) {
                n.g0 c10 = bVar3.f13883c.c();
                long j4 = bVar3.f13881a;
                for (g8.f fVar : (Set) hashMap.get(Long.valueOf(j4))) {
                    c10.a(fVar.f13885a, fVar.f13886b);
                }
                listIterator.set(new g8.b(j4, bVar3.f13882b, c10.c()));
            }
        }
        return arrayList;
    }

    @Override // com.example.test.ui.view.r
    public void b() {
        if (((SportTargetBean) this.f8773b).isVibrator() == 1) {
            ef.i.y().M(200L);
        }
    }

    @Override // com.example.test.utils.b
    public void c(String str, boolean z5) {
        if (z5) {
            int i3 = CustomJLDialActivity.U;
            CustomJLDialActivity customJLDialActivity = (CustomJLDialActivity) this.f8773b;
            ((com.example.test.presenter.device.s) customJLDialActivity.I0()).n((String) this.f8774c);
            String concat = String.format("%s: %d", Arrays.copyOf(new Object[]{customJLDialActivity.getString(R$string.str_installing), 0}, 2)).concat("%");
            eh.b bVar = customJLDialActivity.f7247z;
            ((f6.u) bVar.getValue()).f13360f.setProgress(0.0f);
            ((f6.u) bVar.getValue()).f13360f.setText(concat);
        }
    }

    @Override // androidx.camera.core.impl.n
    public long d() {
        Long l3 = (Long) ((TotalCaptureResult) this.f8774c).get(CaptureResult.SENSOR_TIMESTAMP);
        if (l3 == null) {
            return -1L;
        }
        return l3.longValue();
    }

    @Override // x3.a
    public boolean e(Object obj, File file, x3.f fVar) {
        return ((g4.b) this.f8774c).e(new g4.c((a4.b) this.f8773b, ((BitmapDrawable) ((z3.s) obj).get()).getBitmap()), file, fVar);
    }

    @Override // h8.a
    public Object execute() {
        g8.g gVar = (g8.g) ((f8.g) this.f8773b).f13522c;
        gVar.getClass();
        return (Iterable) gVar.e(new y(gVar, 19, (a8.b) this.f8774c, false));
    }

    @Override // com.example.test.ui.view.r
    public void f() {
        int i3 = 1;
        if (((SportTargetBean) this.f8773b).isVibrator() == 1) {
            ef.i.y().M(300L);
        }
        int i10 = SportCountDownActivity.I;
        SportCountDownActivity sportCountDownActivity = (SportCountDownActivity) this.f8774c;
        ((com.example.baselibrary.utils.e) sportCountDownActivity.F.getValue()).postDelayed(new com.example.test.ui.sport.activity.a(sportCountDownActivity, i3), 1000L);
    }

    @Override // androidx.camera.core.impl.n
    public CameraCaptureMetaData$AeState g() {
        Integer num = (Integer) ((TotalCaptureResult) this.f8774c).get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData$AeState.INACTIVE;
        }
        if (intValue != 1) {
            if (intValue == 2) {
                return CameraCaptureMetaData$AeState.CONVERGED;
            }
            if (intValue == 3) {
                return CameraCaptureMetaData$AeState.LOCKED;
            }
            if (intValue == 4) {
                return CameraCaptureMetaData$AeState.FLASH_REQUIRED;
            }
            if (intValue != 5) {
                com.google.android.gms.internal.mlkit_vision_common.a0.b("C2CameraCaptureResult", "Undefined ae state: " + num);
                return CameraCaptureMetaData$AeState.UNKNOWN;
            }
        }
        return CameraCaptureMetaData$AeState.SEARCHING;
    }

    @Override // dh.a
    public Object get() {
        return new b8.f((Context) ((yh.i) this.f8773b).f20163a, (b8.d) ((b8.e) this.f8774c).get());
    }

    @Override // androidx.camera.core.impl.n
    public CameraCaptureMetaData$AwbState h() {
        Integer num = (Integer) ((TotalCaptureResult) this.f8774c).get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData$AwbState.INACTIVE;
        }
        if (intValue == 1) {
            return CameraCaptureMetaData$AwbState.METERING;
        }
        if (intValue == 2) {
            return CameraCaptureMetaData$AwbState.CONVERGED;
        }
        if (intValue == 3) {
            return CameraCaptureMetaData$AwbState.LOCKED;
        }
        com.google.android.gms.internal.mlkit_vision_common.a0.b("C2CameraCaptureResult", "Undefined awb state: " + num);
        return CameraCaptureMetaData$AwbState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.n
    public CaptureResult i() {
        return (TotalCaptureResult) this.f8774c;
    }

    @Override // i6.h
    public void j(Object obj) {
        i6.i callback = (i6.i) obj;
        kotlin.jvm.internal.e.f(callback, "callback");
        callback.d((BluetoothDevice) this.f8773b, (BleScanInfo) this.f8774c);
    }

    @Override // androidx.camera.core.impl.n
    public CameraCaptureMetaData$AfState k() {
        Integer num = (Integer) ((TotalCaptureResult) this.f8774c).get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                break;
            case 1:
            case 3:
                break;
            case 2:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                com.google.android.gms.internal.mlkit_vision_common.a0.b("C2CameraCaptureResult", "Undefined af state: " + num);
                break;
        }
        return CameraCaptureMetaData$AfState.UNKNOWN;
    }

    public void l() {
        n.l lVar = (n.l) this.f8773b;
        if (lVar != null) {
            ((AtomicBoolean) lVar.f16246c).set(true);
            ((ScheduledFuture) lVar.f16245b).cancel(true);
        }
        this.f8773b = null;
    }

    public Object n(a4.i iVar) {
        HashMap hashMap = (HashMap) this.f8774c;
        a4.d dVar = (a4.d) hashMap.get(iVar);
        if (dVar == null) {
            dVar = new a4.d(iVar);
            hashMap.put(iVar, dVar);
        } else {
            iVar.a();
        }
        a4.d dVar2 = dVar.f83d;
        dVar2.f82c = dVar.f82c;
        dVar.f82c.f83d = dVar2;
        a4.d dVar3 = (a4.d) this.f8773b;
        dVar.f83d = dVar3;
        a4.d dVar4 = dVar3.f82c;
        dVar.f82c = dVar4;
        dVar4.f83d = dVar;
        dVar.f83d.f82c = dVar;
        ArrayList arrayList = dVar.f81b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return dVar.f81b.remove(size - 1);
        }
        return null;
    }

    @Override // x3.h
    public EncodeStrategy o(x3.f fVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // rg.z
    public void onError(Throwable th2) {
        ((rg.z) this.f8773b).onError(th2);
    }

    @Override // rg.z
    public void onSubscribe(ug.b bVar) {
        ((rg.z) this.f8773b).onSubscribe(bVar);
    }

    @Override // x.c
    public void onSuccess(Object obj) {
        switch (this.f8772a) {
            case 16:
                c0.o oVar = (c0.o) obj;
                oVar.getClass();
                try {
                    d0.e eVar = (d0.e) ((androidx.camera.core.impl.e) this.f8774c).f1378c;
                    if (eVar.f12193g.get()) {
                        oVar.close();
                    } else {
                        androidx.appcompat.app.i0 i0Var = new androidx.appcompat.app.i0(16, eVar, oVar);
                        Objects.requireNonNull(oVar);
                        eVar.b(i0Var, new androidx.activity.b(oVar, 9));
                    }
                    break;
                } catch (ProcessingException e) {
                    com.google.android.gms.internal.mlkit_vision_common.a0.c("DualSurfaceProcessorNode", "Failed to send SurfaceOutput to SurfaceProcessor.", e);
                    return;
                }
            case 20:
                pd.f("Unexpected result from SurfaceRequest. Surface was provided twice.", ((t.k) obj).f18352a != 3);
                com.google.android.gms.internal.mlkit_vision_common.a0.a("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                ((SurfaceTexture) this.f8773b).release();
                h0.l lVar = (h0.l) ((h0.k) this.f8774c).f14240b;
                if (lVar.f14245j != null) {
                    lVar.f14245j = null;
                    break;
                }
                break;
            default:
                try {
                    Object apply = ((n6.a) this.f8774c).apply(obj);
                    xg.c.b(apply, "The mapper function returned a null value.");
                    ((rg.z) this.f8773b).onSuccess(apply);
                    break;
                } catch (Throwable th2) {
                    ad.a(th2);
                    onError(th2);
                    return;
                }
        }
    }

    public r1 p() {
        r1 r1Var = new r1();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.f8774c).entrySet()) {
            y1 y1Var = (y1) entry.getValue();
            if (y1Var.e) {
                r1Var.a(y1Var.f1529a);
                arrayList.add((String) entry.getKey());
            }
        }
        com.google.android.gms.internal.mlkit_vision_common.a0.a("UseCaseAttachState", "All use case: " + arrayList + " for camera: " + ((String) this.f8773b));
        return r1Var;
    }

    public Collection q() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.f8774c).entrySet()) {
            if (((y1) entry.getValue()).e) {
                arrayList.add(((y1) entry.getValue()).f1529a);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public Collection r() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.f8774c).entrySet()) {
            if (((y1) entry.getValue()).e) {
                arrayList.add(((y1) entry.getValue()).f1530b);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t6.b
    public void s() {
        Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.f8773b;
        if (((MemberFriendBean) ref$ObjectRef.element).getFriendId() != null) {
            int i3 = TRingFamilyActivity.J;
            com.example.test.presenter.main.l0 l0Var = (com.example.test.presenter.main.l0) ((TRingFamilyActivity) this.f8774c).I0();
            Integer friendId = ((MemberFriendBean) ref$ObjectRef.element).getFriendId();
            kotlin.jvm.internal.e.e(friendId, "getFriendId(...)");
            int intValue = friendId.intValue();
            Object obj = (g7.n) l0Var.f7255a;
            ((XXBaseActivity) obj).V();
            rg.l<HttpModel<String>> memberFriendDelete = ((UserApi) c6.d.f3392c.f113a).memberFriendDelete(Integer.valueOf(intValue));
            kotlin.jvm.internal.e.e(memberFriendDelete, "memberFriendDelete(...)");
            rg.l u10 = com.example.baselibrary.utils.b.u(memberFriendDelete);
            TRingFamilyActivity tRingFamilyActivity = (TRingFamilyActivity) obj;
            tRingFamilyActivity.getClass();
            u10.blockingSubscribe(new com.example.test.presenter.main.j0(l0Var, tRingFamilyActivity, w0.d(), 2));
        }
    }

    public LinkedHashSet t() {
        LinkedHashSet linkedHashSet;
        synchronized (this.f8773b) {
            linkedHashSet = new LinkedHashSet(((LinkedHashMap) this.f8774c).values());
        }
        return linkedHashSet;
    }

    public String toString() {
        switch (this.f8772a) {
            case 1:
                StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
                a4.d dVar = (a4.d) this.f8773b;
                a4.d dVar2 = dVar.f82c;
                boolean z5 = false;
                while (!dVar2.equals(dVar)) {
                    sb2.append('{');
                    sb2.append(dVar2.f80a);
                    sb2.append(':');
                    ArrayList arrayList = dVar2.f81b;
                    sb2.append(arrayList != null ? arrayList.size() : 0);
                    sb2.append("}, ");
                    dVar2 = dVar2.f82c;
                    z5 = true;
                }
                if (z5) {
                    sb2.delete(sb2.length() - 2, sb2.length());
                }
                sb2.append(" )");
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public String v(x3.c cVar) {
        String str;
        synchronized (((n.m) this.f8773b)) {
            str = (String) ((n.m) this.f8773b).a(cVar);
        }
        if (str == null) {
            b4.h hVar = (b4.h) ((n.l) this.f8774c).c();
            try {
                cVar.b(hVar.f3161a);
                byte[] digest = hVar.f3161a.digest();
                char[] cArr = t4.l.f18524b;
                synchronized (cArr) {
                    for (int i3 = 0; i3 < digest.length; i3++) {
                        byte b3 = digest[i3];
                        int i10 = i3 * 2;
                        char[] cArr2 = t4.l.f18523a;
                        cArr[i10] = cArr2[(b3 & 255) >>> 4];
                        cArr[i10 + 1] = cArr2[b3 & 15];
                    }
                    str = new String(cArr);
                }
            } finally {
                ((n.l) this.f8774c).q(hVar);
            }
        }
        synchronized (((n.m) this.f8773b)) {
            ((n.m) this.f8773b).f(cVar, str);
        }
        return str;
    }

    public boolean w(CharSequence charSequence, int i3, int i10, androidx.emoji2.text.n nVar) {
        if (nVar.f2050c == 0) {
            androidx.emoji2.text.d dVar = (androidx.emoji2.text.d) this.f8774c;
            s1.a b3 = nVar.b();
            int a3 = b3.a(8);
            if (a3 != 0) {
                ((ByteBuffer) b3.f15697d).getShort(a3 + b3.f15694a);
            }
            dVar.getClass();
            ThreadLocal threadLocal = androidx.emoji2.text.d.f2023b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb2 = (StringBuilder) threadLocal.get();
            sb2.setLength(0);
            while (i3 < i10) {
                sb2.append(charSequence.charAt(i3));
                i3++;
            }
            TextPaint textPaint = dVar.f2024a;
            String sb3 = sb2.toString();
            int i11 = c1.e.f3358a;
            nVar.f2050c = c1.d.a(textPaint, sb3) ? 2 : 1;
        }
        return nVar.f2050c == 2;
    }

    public void x(n.i iVar) {
        synchronized (this.f8773b) {
            try {
                iVar.getClass();
                for (String str : new LinkedHashSet(iVar.f16207f)) {
                    com.google.android.gms.internal.mlkit_vision_common.a0.a("CameraRepository", "Added camera: " + str);
                    ((LinkedHashMap) this.f8774c).put(str, iVar.a(str));
                }
            } catch (CameraUnavailableException e) {
                throw new InitializationException(e);
            }
        }
    }

    public void y(boolean z5) {
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a();
        PowerManager powerManager = (PowerManager) this.f8773b;
        if (z5) {
            this.f8774c = powerManager.newWakeLock(536870938, XXApplication.class.getCanonicalName());
        } else {
            this.f8774c = powerManager.newWakeLock(536870913, XXApplication.class.getCanonicalName());
        }
    }

    public boolean z(String str) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f8774c;
        if (linkedHashMap.containsKey(str)) {
            return ((y1) linkedHashMap.get(str)).e;
        }
        return false;
    }

    public /* synthetic */ y(int i3, boolean z5) {
        this.f8772a = i3;
    }

    public /* synthetic */ y(Object obj, int i3, Object obj2, boolean z5) {
        this.f8772a = i3;
        this.f8773b = obj;
        this.f8774c = obj2;
    }

    public y(Context context) {
        this.f8772a = 14;
        this.f8774c = new AtomicLong(-1L);
        this.f8773b = new s9.b(context, s9.b.f18216i, new q9.f("mlkit:vision"), com.google.android.gms.common.api.e.f9078b);
    }

    public y(String str, ga.b bVar, eb.e eVar) {
        this.f8772a = 13;
        this.f8774c = str;
        this.f8773b = bVar;
    }

    public y(int i3) {
        this.f8772a = i3;
        switch (i3) {
            case 4:
                this.f8773b = new Object();
                this.f8774c = new LinkedHashMap();
                new HashSet();
                break;
            case 7:
                this.f8773b = new n.m(1000L);
                this.f8774c = u4.d.a(10, new com.google.android.gms.internal.mlkit_common.o(3));
                break;
            default:
                this.f8773b = new a4.d(null);
                this.f8774c = new HashMap();
                break;
        }
    }

    public y(androidx.camera.core.impl.z zVar) {
        this.f8772a = 28;
        this.f8773b = zVar;
        androidx.lifecycle.b0 b0Var = new androidx.lifecycle.b0();
        this.f8774c = b0Var;
        b0Var.i(new t.e(CameraState$Type.CLOSED, null));
    }

    public y(String str) {
        this.f8772a = 5;
        this.f8774c = new LinkedHashMap();
        this.f8773b = str;
    }

    public y(Ref$ObjectRef ref$ObjectRef, TRingFamilyActivity tRingFamilyActivity, int i3) {
        this.f8772a = 12;
        this.f8773b = ref$ObjectRef;
        this.f8774c = tRingFamilyActivity;
    }

    public y(v2.h hVar, ec.a aVar, androidx.emoji2.text.d dVar) {
        this.f8772a = 6;
        this.f8773b = hVar;
        this.f8774c = dVar;
    }

    public y(Handler handler) {
        this.f8772a = 3;
        this.f8773b = new HashMap();
        this.f8774c = handler;
    }

    public y(ViewPager viewPager) {
        this.f8772a = 29;
        this.f8774c = viewPager;
        this.f8773b = new Rect();
    }

    public y(CardView cardView) {
        this.f8772a = 25;
        this.f8774c = cardView;
    }

    public y(androidx.camera.camera2.internal.i iVar) {
        this.f8772a = 27;
        this.f8774c = iVar;
        this.f8773b = null;
    }
}
