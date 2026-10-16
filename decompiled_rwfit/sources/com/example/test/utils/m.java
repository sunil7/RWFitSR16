package com.example.test.utils;

import com.example.blesdk.bean.function.SupportMenuBean;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8734b = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.test.utils.FunctionAdaptationUtils$Companion$adaptation$2
        @Override // oh.a
        public final m invoke() {
            return new m();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public SupportMenuBean f8735a;

    public final boolean a() {
        SupportMenuBean supportMenuBean = this.f8735a;
        if (supportMenuBean != null) {
            return supportMenuBean.isActivityDataStaticTran2();
        }
        return false;
    }

    public final boolean b() {
        SupportMenuBean supportMenuBean = this.f8735a;
        if (supportMenuBean != null) {
            return supportMenuBean.isBloodSugar();
        }
        return false;
    }

    public final boolean c() {
        SupportMenuBean supportMenuBean = this.f8735a;
        if (supportMenuBean != null) {
            return supportMenuBean.isHealthRing();
        }
        return true;
    }

    public final boolean d() {
        SupportMenuBean supportMenuBean = this.f8735a;
        if (supportMenuBean != null) {
            return supportMenuBean.isPressure();
        }
        return false;
    }
}
