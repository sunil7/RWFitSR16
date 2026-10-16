package com.example.test.presenter.device;

import com.example.blesdk.bean.function.CustomDialInfoBean;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.database.table.Devices;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class s extends g {

    /* renamed from: d, reason: collision with root package name */
    public final String f7476d;
    public String e;

    /* renamed from: f, reason: collision with root package name */
    public String f7477f;

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f7478g;

    public s(f7.e eVar) {
        super(eVar);
        this.f7476d = "CustomDialPresenter";
        this.f7478g = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.CustomDialPresenter$customDialInfoCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final r invoke() {
                return new r(s.this);
            }
        });
    }

    public static void B(String str) {
        com.example.baselibrary.preseneter.b.j(str, new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$saveCustomDialColor$1
            @Override // oh.l
            public final eh.g invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar == null) {
                    return null;
                }
                Devices c9 = kVar.c();
                if (c9 != null) {
                    kVar.M(it, c9.getMacAddress() + "custom_dial_color");
                }
                return eh.g.f12633a;
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$saveCustomDialColor$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }

            public final void invoke(eh.g gVar) {
            }
        });
    }

    public static void C(String path) {
        kotlin.jvm.internal.e.f(path, "path");
        com.example.baselibrary.preseneter.b.j(path, new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$saveCustomDialPath$1
            @Override // oh.l
            public final eh.g invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar == null) {
                    return null;
                }
                kVar.Q(it);
                return eh.g.f12633a;
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$saveCustomDialPath$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }

            public final void invoke(eh.g gVar) {
            }
        });
    }

    public final void A(final String path, final boolean z5, final float f2, final CustomDialInfoBean customDialInfoBean) {
        kotlin.jvm.internal.e.f(path, "path");
        kotlin.jvm.internal.e.f(customDialInfoBean, "customDialInfoBean");
        int length = path.length();
        Object obj = this.f7255a;
        if (length == 0) {
            ((XXBaseActivity) ((f7.e) obj)).V();
        }
        com.example.baselibrary.preseneter.b.j(((f7.e) obj).f0(), new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$saveCustomDial$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:81:0x01a0, code lost:
            
                if (r5 == null) goto L59;
             */
            /* JADX WARN: Removed duplicated region for block: B:77:0x0259  */
            @Override // oh.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final eh.g invoke(android.content.Context r22) {
                /*
                    Method dump skipped, instructions count: 608
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.device.CustomDialPresenter$saveCustomDial$1.invoke(android.content.Context):eh.g");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$saveCustomDial$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((eh.g) obj2);
                return eh.g.f12633a;
            }

            public final void invoke(eh.g gVar) {
            }
        });
    }

    @Override // com.example.test.presenter.device.g
    public final void o() {
    }

    @Override // com.example.test.presenter.device.g
    public final void p(float f2) {
    }

    @Override // com.example.test.presenter.device.g
    public final void q(String str) {
    }

    @Override // com.example.test.presenter.device.g
    public final void r(int i3) {
        ((f7.e) this.f7255a).a0(i3);
    }

    @Override // com.example.test.presenter.device.g
    public final void s(float f2) {
        ((f7.e) this.f7255a).E(f2);
    }

    @Override // com.example.test.presenter.device.g
    public final void t() {
        ((f7.e) this.f7255a).s();
    }

    public final void w(String currentPath) {
        kotlin.jvm.internal.e.f(currentPath, "currentPath");
        com.example.baselibrary.preseneter.b.j(currentPath, new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$analysisDialEvent$1
            @Override // oh.l
            public final Boolean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                return Boolean.valueOf(!kotlin.jvm.internal.e.a(com.example.test.utils.k.f8731b != null ? r0.h() : null, it));
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$analysisDialEvent$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return eh.g.f12633a;
            }

            public final void invoke(boolean z5) {
                ((f7.e) s.this.f7255a).p0(z5);
            }
        });
    }

    public final void x() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        ((f7.e) this.f7255a).k0(kVar != null ? kVar.h() : null);
    }

    public final void y() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        DeviceModelInfoBean j4 = kVar != null ? kVar.j() : null;
        if (j4 != null) {
            this.e = j4.getThumbWidth();
            this.f7477f = j4.getThumbHeight();
        }
        ((f7.e) this.f7255a).j0(j4);
    }

    public final void z() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$getLocalDialInfo$1
            @Override // oh.l
            public final DialInfoBean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.n();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.CustomDialPresenter$getLocalDialInfo$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DialInfoBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DialInfoBean dialInfoBean) {
                if (dialInfoBean != null) {
                    ((f7.e) s.this.f7255a).n0(dialInfoBean);
                }
            }
        });
    }
}
