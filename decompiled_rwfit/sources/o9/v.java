package o9;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import n.g0;
import n.v0;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class v extends ha.b implements com.google.android.gms.common.api.g, com.google.android.gms.common.api.h {

    /* renamed from: i, reason: collision with root package name */
    public static final ga.b f16895i = ga.c.f14022a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f16896b;

    /* renamed from: c, reason: collision with root package name */
    public final c5.b f16897c;

    /* renamed from: d, reason: collision with root package name */
    public final ga.b f16898d;
    public final Set e;

    /* renamed from: f, reason: collision with root package name */
    public final g0 f16899f;

    /* renamed from: g, reason: collision with root package name */
    public ha.a f16900g;

    /* renamed from: h, reason: collision with root package name */
    public v0 f16901h;

    public v(Context context, c5.b bVar, g0 g0Var) {
        super("com.google.android.gms.signin.internal.ISignInCallbacks", 1);
        this.f16896b = context;
        this.f16897c = bVar;
        this.f16899f = g0Var;
        this.e = (Set) g0Var.f16174a;
        this.f16898d = f16895i;
    }

    @Override // com.google.android.gms.common.api.g
    public final void g(int i3) {
        v0 v0Var = this.f16901h;
        n nVar = (n) ((c) v0Var.f16310f).f16859j.get((a) v0Var.f16308c);
        if (nVar != null) {
            if (nVar.f16876i) {
                nVar.p(new ConnectionResult(17));
            } else {
                nVar.g(i3);
            }
        }
    }

    @Override // com.google.android.gms.common.api.g
    public final void k() {
        GoogleSignInAccount googleSignInAccount;
        ha.a aVar = this.f16900g;
        aVar.getClass();
        try {
            aVar.f14290z.getClass();
            Account account = new Account("<<default account>>", "com.google");
            if ("<<default account>>".equals(account.name)) {
                Context context = aVar.f9115c;
                ReentrantLock reentrantLock = m9.a.f15992c;
                q9.n.e(context);
                ReentrantLock reentrantLock2 = m9.a.f15992c;
                reentrantLock2.lock();
                try {
                    if (m9.a.f15993d == null) {
                        m9.a.f15993d = new m9.a(context.getApplicationContext());
                    }
                    m9.a aVar2 = m9.a.f15993d;
                    reentrantLock2.unlock();
                    String a3 = aVar2.a("defaultGoogleSignInAccount");
                    if (!TextUtils.isEmpty(a3)) {
                        String a10 = aVar2.a("googleSignInAccount:" + a3);
                        if (a10 != null) {
                            try {
                                googleSignInAccount = GoogleSignInAccount.b(a10);
                            } catch (JSONException unused) {
                            }
                            Integer num = aVar.B;
                            q9.n.e(num);
                            zat zatVar = new zat(2, account, num.intValue(), googleSignInAccount);
                            ha.c cVar = (ha.c) aVar.q();
                            zai zaiVar = new zai(1, zatVar);
                            Parcel g10 = cVar.g();
                            da.a.c(g10, zaiVar);
                            da.a.d(g10, this);
                            cVar.k(g10, 12);
                        }
                    }
                } catch (Throwable th2) {
                    reentrantLock2.unlock();
                    throw th2;
                }
            }
            googleSignInAccount = null;
            Integer num2 = aVar.B;
            q9.n.e(num2);
            zat zatVar2 = new zat(2, account, num2.intValue(), googleSignInAccount);
            ha.c cVar2 = (ha.c) aVar.q();
            zai zaiVar2 = new zai(1, zatVar2);
            Parcel g102 = cVar2.g();
            da.a.c(g102, zaiVar2);
            da.a.d(g102, this);
            cVar2.k(g102, 12);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.f16897c.post(new ia.j(11, this, new zak(1, new ConnectionResult(8, null), null)));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // o9.h
    public final void m(ConnectionResult connectionResult) {
        this.f16901h.e(connectionResult);
    }
}
