package ha;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import n.g0;

/* loaded from: classes.dex */
public final class a extends com.google.android.gms.common.internal.a implements com.google.android.gms.common.api.c {
    public final Bundle A;
    public final Integer B;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f14289y;

    /* renamed from: z, reason: collision with root package name */
    public final g0 f14290z;

    public a(Context context, Looper looper, g0 g0Var, Bundle bundle, g gVar, h hVar) {
        super(context, looper, 44, g0Var, gVar, hVar);
        this.f14289y = true;
        this.f14290z = g0Var;
        this.A = bundle;
        this.B = (Integer) g0Var.f16178f;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof c ? (c) queryLocalInterface : new c(iBinder, "com.google.android.gms.signin.internal.ISignInService", 1);
    }

    @Override // com.google.android.gms.common.api.c
    public final int g() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.a, com.google.android.gms.common.api.c
    public final boolean n() {
        return this.f14289y;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle p() {
        g0 g0Var = this.f14290z;
        boolean equals = this.f9115c.getPackageName().equals((String) g0Var.f16176c);
        Bundle bundle = this.A;
        if (!equals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) g0Var.f16176c);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String r() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String s() {
        return "com.google.android.gms.signin.service.START";
    }
}
