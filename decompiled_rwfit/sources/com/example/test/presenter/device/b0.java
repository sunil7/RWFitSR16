package com.example.test.presenter.device;

import com.example.blesdk.bean.function.DialInfoBean;
import com.example.test.ui.device.adapter.DialTypeAdapter;
import com.example.test.ui.device.fragment.DialRecommendFragment;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.device.model.DialTypeModel;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class b0 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x011d, code lost:
    
        if (android.support.v4.media.session.e.C(r0, r2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ur", false) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.device.b0.k():void");
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.DialRecommendPresenter$getLocalDialInfo$1
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
        }, new oh.l() { // from class: com.example.test.presenter.device.DialRecommendPresenter$getLocalDialInfo$2
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
                    DialRecommendFragment dialRecommendFragment = (DialRecommendFragment) ((f7.j) b0.this.f7255a);
                    dialRecommendFragment.getClass();
                    dialRecommendFragment.f7906d = dialInfoBean;
                    Iterator it = dialRecommendFragment.q0().iterator();
                    while (it.hasNext()) {
                        List<DialModel> dials = ((DialTypeModel) it.next()).getDials();
                        if (dials != null) {
                            Iterator<T> it2 = dials.iterator();
                            while (it2.hasNext()) {
                                ((DialModel) it2.next()).setDialInfoBean(dialInfoBean);
                            }
                        }
                    }
                    ((DialTypeAdapter) dialRecommendFragment.f7907f.getValue()).notifyItemRangeChanged(0, dialRecommendFragment.q0().size());
                }
            }
        });
    }
}
