package c0;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.view.Surface;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.g0;
import androidx.camera.core.impl.q0;
import androidx.camera.core.impl.r0;
import androidx.camera.core.impl.s0;
import androidx.camera.core.processing.util.GLUtils$InputFormat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dh.imagepick.ImagePickClient;
import com.example.blesdk.service.z;
import com.example.database.table.User;
import com.example.network.bean.FirmwareInfoBean;
import com.example.test.R$string;
import com.example.test.presenter.main.p0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.MessageAdapter;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.device.model.MessageModel;
import com.example.test.ui.dialog.q;
import com.example.test.ui.main.fragment.HeadsetFragment;
import com.example.test.ui.mine.activity.FeedBackActivity;
import com.example.test.ui.mine.activity.RingFeedBackActivity;
import com.example.test.ui.mine.adapter.ImagePickAdapter;
import com.example.test.ui.testui.d1;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import n.d0;
import n.m0;
import n.n0;
import n.v0;
import t.e1;
import t.f1;
import t.t;
import t.v;
import t.z0;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements n0.g, e1, r3.a, t6.e, OnItemClickListener, a7.d, rg.o, de.l, x.a, q0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3279a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3280b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3281c;

    public /* synthetic */ b(int i3, Object obj, Object obj2) {
        this.f3279a = i3;
        this.f3280b = obj;
        this.f3281c = obj2;
    }

    @Override // t6.e
    public void a(int i3, int i10) {
        HeadsetFragment this$0 = (HeadsetFragment) this.f3280b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        com.example.test.ui.dialog.g tHeadsetOtaDialog = (com.example.test.ui.dialog.g) this.f3281c;
        kotlin.jvm.internal.e.f(tHeadsetOtaDialog, "$tHeadsetOtaDialog");
        if (i3 == 100) {
            this$0.e = false;
            String concat = String.format("%s: %d", Arrays.copyOf(new Object[]{this$0.getString(R$string.str_downloading), 0}, 2)).concat("%");
            tHeadsetOtaDialog.a().setProgress(0.0f);
            tHeadsetOtaDialog.a().setText(concat);
            y.u().y(true);
            y.u().A();
            p0 p0Var = (p0) this$0.X();
            FirmwareInfoBean firmwareInfoBean = this$0.f8072f;
            if (firmwareInfoBean == null) {
                kotlin.jvm.internal.e.m("bean");
                throw null;
            }
            String downloadUrl = firmwareInfoBean.getDownloadUrl();
            kotlin.jvm.internal.e.e(downloadUrl, "getDownloadUrl(...)");
            p0Var.getClass();
            p0Var.v(downloadUrl);
        }
    }

    @Override // x.a
    /* renamed from: apply */
    public ob.a mo0apply(Object obj) {
        switch (this.f3279a) {
            case 12:
                androidx.camera.camera2.internal.m mVar = (androidx.camera.camera2.internal.m) this.f3280b;
                mVar.a();
                ((s0) this.f3281c).a();
                return mVar.l();
            default:
                List list = (List) obj;
                n0 n0Var = (n0) this.f3280b;
                n0Var.getClass();
                a0.a("SyncCaptureSessionBase", "[" + n0Var + "] getSurface done with results: " + list);
                if (list.isEmpty()) {
                    return new x.k(new IllegalArgumentException("Unable to open capture session without surfaces"), 1);
                }
                if (!list.contains(null)) {
                    return x.i.c(list);
                }
                return new x.k(new DeferrableSurface$SurfaceClosedException("Surface closed", (g0) ((ArrayList) this.f3281c).get(list.indexOf(null))), 1);
        }
    }

    @Override // n0.g
    public Object b(androidx.concurrent.futures.b bVar) {
        switch (this.f3279a) {
            case 0:
                f fVar = (f) this.f3280b;
                fVar.getClass();
                Map map = Collections.EMPTY_MAP;
                fVar.b(new androidx.camera.camera2.internal.compat.h(fVar, (t) this.f3281c, bVar), new z(6));
                return "Init GlRenderer";
            case 8:
                d0.e eVar = (d0.e) this.f3280b;
                eVar.getClass();
                Map map2 = Collections.EMPTY_MAP;
                eVar.b(new androidx.camera.camera2.internal.compat.h(eVar, (t) this.f3281c, bVar), new z(6));
                return "Init GlRenderer";
            case 11:
                h0.l lVar = (h0.l) this.f3280b;
                lVar.getClass();
                a0.a("TextureViewImpl", "Surface set on Preview.");
                f1 f1Var = lVar.f14243h;
                w.a a3 = a6.a();
                androidx.activity.k kVar = new androidx.activity.k(bVar, 3);
                Surface surface = (Surface) this.f3281c;
                f1Var.a(surface, a3, kVar);
                return "provideSurface[request=" + lVar.f14243h + " surface=" + surface + "]";
            case 13:
                d0 d0Var = (d0) this.f3280b;
                d0Var.getClass();
                d0Var.f16152b.execute(new androidx.camera.camera2.internal.compat.h(d0Var, 12, bVar, (v) this.f3281c));
                return "startFocusAndMetering";
            case 15:
                v0 v0Var = (v0) this.f3280b;
                v0Var.getClass();
                ((androidx.camera.core.impl.utils.executor.b) v0Var.f16308c).execute(new androidx.camera.camera2.internal.compat.h(v0Var, 13, bVar, (y.b) this.f3281c));
                return "setZoomRatio";
            case 19:
                androidx.camera.core.b bVar2 = (androidx.camera.core.b) this.f3280b;
                bVar2.getClass();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ComponentActivity componentActivity = (ComponentActivity) this.f3281c;
                Executor executor = bVar2.f1298d;
                executor.execute(new androidx.camera.core.a(1, elapsedRealtime, componentActivity, bVar2, bVar, executor));
                return "CameraX initInternal";
            default:
                f1 f1Var2 = (f1) this.f3280b;
                f1Var2.getClass();
                ((AtomicReference) this.f3281c).set(bVar);
                return "SurfaceRequest-surface-recreation(" + f1Var2.hashCode() + ")";
        }
    }

    @Override // androidx.camera.core.impl.q0
    public void c(r0 r0Var) {
        switch (this.f3279a) {
            case 20:
                z0 z0Var = (z0) this.f3280b;
                z0Var.getClass();
                ((q0) this.f3281c).c(z0Var);
                break;
            default:
                m0 m0Var = (m0) this.f3280b;
                m0Var.getClass();
                ((q0) this.f3281c).c(m0Var);
                break;
        }
    }

    @Override // rg.o
    public void d(rg.n nVar) {
        oh.l runBlock = (oh.l) this.f3280b;
        kotlin.jvm.internal.e.f(runBlock, "$runBlock");
        Object invoke = runBlock.invoke((User) this.f3281c);
        if (invoke != null) {
            nVar.onNext(invoke);
        }
    }

    @Override // r3.a
    public void e(int i3, int i10, int i11) {
        Context context = (Context) this.f3280b;
        kotlin.jvm.internal.e.f(context, "$context");
        q this$0 = (q) this.f3281c;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (DateFormat.is24HourFormat(context)) {
            this$0.f8013b = i3;
            this$0.f8014c = i10;
        } else {
            this$0.f8012a = i3;
            this$0.f8013b = i10;
            this$0.f8014c = i11;
        }
    }

    @Override // t.e1
    public void g(t.l lVar) {
        f fVar = (f) this.f3280b;
        fVar.getClass();
        GLUtils$InputFormat gLUtils$InputFormat = GLUtils$InputFormat.DEFAULT;
        if (((f1) this.f3281c).f18321c.a() && lVar.f18357d) {
            gLUtils$InputFormat = GLUtils$InputFormat.YUV;
        }
        h hVar = fVar.f3291a;
        e0.h.d(hVar.f3303a, true);
        e0.h.c(hVar.f3305c);
        if (hVar.f3313l != gLUtils$InputFormat) {
            hVar.f3313l = gLUtils$InputFormat;
            hVar.k(hVar.f3314m);
        }
    }

    @Override // a7.d
    public void j(boolean z5) {
        switch (this.f3279a) {
            case 6:
                d1 d1Var = (d1) this.f3280b;
                if (d1Var.f8270a != null && d1Var.getAdapter2() != null) {
                    d1Var.f8270a.c(d1Var.getAdapter2().getItemPosition((DeviceOptionModel) this.f3281c), z5);
                    break;
                }
                break;
            case 16:
                r6.e eVar = (r6.e) this.f3280b;
                if (eVar.f18098a != null && eVar.getAdapter2() != null) {
                    eVar.f18098a.c(eVar.getAdapter2().getItemPosition((DeviceOptionModel) this.f3281c), z5);
                    break;
                }
                break;
            default:
                MessageAdapter messageAdapter = (MessageAdapter) this.f3280b;
                s6.b bVar = messageAdapter.f7904a;
                if (bVar != null) {
                    bVar.c(messageAdapter.getItemPosition((MessageModel) this.f3281c), z5);
                    break;
                }
                break;
        }
    }

    @Override // de.l
    public void k(Object obj) {
        rd.c cVar = (rd.c) obj;
        switch (this.f3279a) {
            case 9:
                cVar.g((BluetoothDevice) this.f3280b, (BleScanMessage) this.f3281c);
                break;
            default:
                cVar.m((BluetoothDevice) this.f3280b, (vd.b) this.f3281c);
                break;
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter adapter, View view, final int i3) {
        switch (this.f3279a) {
            case 4:
                final FeedBackActivity this$0 = (FeedBackActivity) this.f3280b;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                final ImagePickAdapter imagePickAdapter = (ImagePickAdapter) this.f3281c;
                kotlin.jvm.internal.e.f(adapter, "adapter");
                kotlin.jvm.internal.e.f(view, "view");
                v2.h hVar = new v2.h(this$0);
                hVar.o("android.permission.READ_EXTERNAL_STORAGE");
                final int i10 = 0;
                hVar.p(new nd.b() { // from class: com.example.test.ui.mine.activity.f
                    @Override // nd.b
                    public final void h(boolean z5) {
                        final int i11 = i3;
                        final ImagePickAdapter imagePickAdapter2 = imagePickAdapter;
                        XXBaseActivity xXBaseActivity = this$0;
                        switch (i10) {
                            case 0:
                                final FeedBackActivity this$02 = (FeedBackActivity) xXBaseActivity;
                                kotlin.jvm.internal.e.f(this$02, "this$0");
                                if (z5) {
                                    int i12 = FeedBackActivity.G;
                                    if (((CharSequence) this$02.R0().get(i11)).length() != 0) {
                                        oh.l lVar = new oh.l() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2$1$1$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                FeedBackActivity feedBackActivity = FeedBackActivity.this;
                                                int i13 = FeedBackActivity.G;
                                                feedBackActivity.R0().set(i11, it);
                                                imagePickAdapter2.notifyItemChanged(i11);
                                            }
                                        };
                                        FeedBackActivity$imageAdapter$2$1$1$4 errorBack = new oh.l() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2$1$1$4
                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                com.example.baselibrary.utils.d.b("error");
                                            }
                                        };
                                        kotlin.jvm.internal.e.f(errorBack, "errorBack");
                                        com.dh.imagepick.work.c with = ImagePickClient.with(this$02);
                                        with.getClass();
                                        new f5.b(with).h(new com.example.test.utils.o(errorBack, lVar, 0));
                                        break;
                                    } else {
                                        oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                FeedBackActivity feedBackActivity = FeedBackActivity.this;
                                                int i13 = FeedBackActivity.G;
                                                List R0 = feedBackActivity.R0();
                                                int size = FeedBackActivity.this.R0().size() - 1;
                                                R0.set(size, R0.get(size) + it);
                                                if (FeedBackActivity.this.R0().size() < 3 && !kotlin.jvm.internal.e.a(FeedBackActivity.this.R0().get(FeedBackActivity.this.R0().size() - 1), "")) {
                                                    FeedBackActivity.this.R0().add("");
                                                }
                                                imagePickAdapter2.notifyItemRangeChanged(0, FeedBackActivity.this.R0().size());
                                            }
                                        };
                                        FeedBackActivity$imageAdapter$2$1$1$2 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2$1$1$2
                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                com.example.baselibrary.utils.d.b("error");
                                            }
                                        };
                                        kotlin.jvm.internal.e.f(errorBack2, "errorBack");
                                        com.dh.imagepick.work.c with2 = ImagePickClient.with(this$02);
                                        with2.getClass();
                                        new f5.b(with2).h(new com.example.test.utils.o(errorBack2, lVar2, 0));
                                        break;
                                    }
                                }
                                break;
                            default:
                                final RingFeedBackActivity this$03 = (RingFeedBackActivity) xXBaseActivity;
                                kotlin.jvm.internal.e.f(this$03, "this$0");
                                if (z5) {
                                    int i13 = RingFeedBackActivity.I;
                                    if (((CharSequence) this$03.R0().get(i11)).length() != 0) {
                                        oh.l lVar3 = new oh.l() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2$1$1$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                RingFeedBackActivity ringFeedBackActivity = RingFeedBackActivity.this;
                                                int i14 = RingFeedBackActivity.I;
                                                ringFeedBackActivity.R0().set(i11, it);
                                                imagePickAdapter2.notifyItemChanged(i11);
                                            }
                                        };
                                        RingFeedBackActivity$imageAdapter$2$1$1$4 errorBack3 = new oh.l() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2$1$1$4
                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                com.example.baselibrary.utils.d.b("error");
                                            }
                                        };
                                        kotlin.jvm.internal.e.f(errorBack3, "errorBack");
                                        com.dh.imagepick.work.c with3 = ImagePickClient.with(this$03);
                                        with3.getClass();
                                        new f5.b(with3).h(new com.example.test.utils.o(errorBack3, lVar3, 0));
                                        break;
                                    } else {
                                        oh.l lVar4 = new oh.l() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                RingFeedBackActivity ringFeedBackActivity = RingFeedBackActivity.this;
                                                int i14 = RingFeedBackActivity.I;
                                                List R0 = ringFeedBackActivity.R0();
                                                int size = RingFeedBackActivity.this.R0().size() - 1;
                                                R0.set(size, R0.get(size) + it);
                                                if (RingFeedBackActivity.this.R0().size() < 3 && !kotlin.jvm.internal.e.a(RingFeedBackActivity.this.R0().get(RingFeedBackActivity.this.R0().size() - 1), "")) {
                                                    RingFeedBackActivity.this.R0().add("");
                                                }
                                                imagePickAdapter2.notifyItemRangeChanged(0, RingFeedBackActivity.this.R0().size());
                                            }
                                        };
                                        RingFeedBackActivity$imageAdapter$2$1$1$2 errorBack4 = new oh.l() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2$1$1$2
                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                com.example.baselibrary.utils.d.b("error");
                                            }
                                        };
                                        kotlin.jvm.internal.e.f(errorBack4, "errorBack");
                                        com.dh.imagepick.work.c with4 = ImagePickClient.with(this$03);
                                        with4.getClass();
                                        new f5.b(with4).h(new com.example.test.utils.o(errorBack4, lVar4, 0));
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                });
                break;
            default:
                final RingFeedBackActivity this$02 = (RingFeedBackActivity) this.f3280b;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                final ImagePickAdapter imagePickAdapter2 = (ImagePickAdapter) this.f3281c;
                kotlin.jvm.internal.e.f(adapter, "adapter");
                kotlin.jvm.internal.e.f(view, "view");
                v2.h hVar2 = new v2.h(this$02);
                hVar2.o("android.permission.READ_EXTERNAL_STORAGE");
                final int i11 = 1;
                hVar2.p(new nd.b() { // from class: com.example.test.ui.mine.activity.f
                    @Override // nd.b
                    public final void h(boolean z5) {
                        final int i112 = i3;
                        final ImagePickAdapter imagePickAdapter22 = imagePickAdapter2;
                        XXBaseActivity xXBaseActivity = this$02;
                        switch (i11) {
                            case 0:
                                final FeedBackActivity this$022 = (FeedBackActivity) xXBaseActivity;
                                kotlin.jvm.internal.e.f(this$022, "this$0");
                                if (z5) {
                                    int i12 = FeedBackActivity.G;
                                    if (((CharSequence) this$022.R0().get(i112)).length() != 0) {
                                        oh.l lVar = new oh.l() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2$1$1$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                FeedBackActivity feedBackActivity = FeedBackActivity.this;
                                                int i13 = FeedBackActivity.G;
                                                feedBackActivity.R0().set(i112, it);
                                                imagePickAdapter22.notifyItemChanged(i112);
                                            }
                                        };
                                        FeedBackActivity$imageAdapter$2$1$1$4 errorBack = new oh.l() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2$1$1$4
                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                com.example.baselibrary.utils.d.b("error");
                                            }
                                        };
                                        kotlin.jvm.internal.e.f(errorBack, "errorBack");
                                        com.dh.imagepick.work.c with = ImagePickClient.with(this$022);
                                        with.getClass();
                                        new f5.b(with).h(new com.example.test.utils.o(errorBack, lVar, 0));
                                        break;
                                    } else {
                                        oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                FeedBackActivity feedBackActivity = FeedBackActivity.this;
                                                int i13 = FeedBackActivity.G;
                                                List R0 = feedBackActivity.R0();
                                                int size = FeedBackActivity.this.R0().size() - 1;
                                                R0.set(size, R0.get(size) + it);
                                                if (FeedBackActivity.this.R0().size() < 3 && !kotlin.jvm.internal.e.a(FeedBackActivity.this.R0().get(FeedBackActivity.this.R0().size() - 1), "")) {
                                                    FeedBackActivity.this.R0().add("");
                                                }
                                                imagePickAdapter22.notifyItemRangeChanged(0, FeedBackActivity.this.R0().size());
                                            }
                                        };
                                        FeedBackActivity$imageAdapter$2$1$1$2 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2$1$1$2
                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                com.example.baselibrary.utils.d.b("error");
                                            }
                                        };
                                        kotlin.jvm.internal.e.f(errorBack2, "errorBack");
                                        com.dh.imagepick.work.c with2 = ImagePickClient.with(this$022);
                                        with2.getClass();
                                        new f5.b(with2).h(new com.example.test.utils.o(errorBack2, lVar2, 0));
                                        break;
                                    }
                                }
                                break;
                            default:
                                final RingFeedBackActivity this$03 = (RingFeedBackActivity) xXBaseActivity;
                                kotlin.jvm.internal.e.f(this$03, "this$0");
                                if (z5) {
                                    int i13 = RingFeedBackActivity.I;
                                    if (((CharSequence) this$03.R0().get(i112)).length() != 0) {
                                        oh.l lVar3 = new oh.l() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2$1$1$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                RingFeedBackActivity ringFeedBackActivity = RingFeedBackActivity.this;
                                                int i14 = RingFeedBackActivity.I;
                                                ringFeedBackActivity.R0().set(i112, it);
                                                imagePickAdapter22.notifyItemChanged(i112);
                                            }
                                        };
                                        RingFeedBackActivity$imageAdapter$2$1$1$4 errorBack3 = new oh.l() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2$1$1$4
                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                com.example.baselibrary.utils.d.b("error");
                                            }
                                        };
                                        kotlin.jvm.internal.e.f(errorBack3, "errorBack");
                                        com.dh.imagepick.work.c with3 = ImagePickClient.with(this$03);
                                        with3.getClass();
                                        new f5.b(with3).h(new com.example.test.utils.o(errorBack3, lVar3, 0));
                                        break;
                                    } else {
                                        oh.l lVar4 = new oh.l() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                RingFeedBackActivity ringFeedBackActivity = RingFeedBackActivity.this;
                                                int i14 = RingFeedBackActivity.I;
                                                List R0 = ringFeedBackActivity.R0();
                                                int size = RingFeedBackActivity.this.R0().size() - 1;
                                                R0.set(size, R0.get(size) + it);
                                                if (RingFeedBackActivity.this.R0().size() < 3 && !kotlin.jvm.internal.e.a(RingFeedBackActivity.this.R0().get(RingFeedBackActivity.this.R0().size() - 1), "")) {
                                                    RingFeedBackActivity.this.R0().add("");
                                                }
                                                imagePickAdapter22.notifyItemRangeChanged(0, RingFeedBackActivity.this.R0().size());
                                            }
                                        };
                                        RingFeedBackActivity$imageAdapter$2$1$1$2 errorBack4 = new oh.l() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2$1$1$2
                                            @Override // oh.l
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return eh.g.f12633a;
                                            }

                                            public final void invoke(String it) {
                                                kotlin.jvm.internal.e.f(it, "it");
                                                com.example.baselibrary.utils.d.b("error");
                                            }
                                        };
                                        kotlin.jvm.internal.e.f(errorBack4, "errorBack");
                                        com.dh.imagepick.work.c with4 = ImagePickClient.with(this$03);
                                        with4.getClass();
                                        new f5.b(with4).h(new com.example.test.utils.o(errorBack4, lVar4, 0));
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                });
                break;
        }
    }

    public /* synthetic */ b(f fVar, t tVar) {
        this.f3279a = 0;
        Map map = Collections.EMPTY_MAP;
        this.f3280b = fVar;
        this.f3281c = tVar;
    }

    public /* synthetic */ b(d0.e eVar, t tVar) {
        this.f3279a = 8;
        Map map = Collections.EMPTY_MAP;
        this.f3280b = eVar;
        this.f3281c = tVar;
    }
}
