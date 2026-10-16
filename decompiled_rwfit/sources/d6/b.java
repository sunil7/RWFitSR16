package d6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.example.baselibrary.utils.d;
import com.example.test.R$string;
import com.example.test.utils.w0;
import retrofit2.HttpException;
import rg.s;

/* loaded from: classes.dex */
public abstract class b implements s {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12307a;

    /* renamed from: b, reason: collision with root package name */
    public final w0 f12308b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f12309c;

    public b(Context context, w0 w0Var) {
        this.f12307a = context;
        this.f12308b = w0Var;
    }

    public abstract void a(int i3, Throwable th2);

    public abstract void b(Object obj);

    @Override // rg.s
    public final void onComplete() {
        if (this.f12309c.isDisposed()) {
            this.f12309c.dispose();
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        NetworkInfo activeNetworkInfo;
        if (this.f12309c.isDisposed()) {
            this.f12309c.dispose();
        }
        th2.printStackTrace();
        if ((th2 instanceof HttpException) && ((HttpException) th2).code() >= 10086) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "HttpRequest", "自定义网络错误，账号异地登陆");
            return;
        }
        if (this.f12307a == null) {
            a(11111, th2);
            return;
        }
        this.f12308b.getClass();
        if (w0.b() != null) {
            w0.b().b0();
        }
        if (w0.b() == null || ((activeNetworkInfo = ((ConnectivityManager) w0.b().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected())) {
            d.a(R$string.str_network_error);
        } else {
            d.a(R$string.str_network_unconnect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (com.example.test.ui.mine.activity.AccountValidateActivity.class.getName().equals(com.example.test.utils.w0.b().getClass().getName()) != false) goto L81;
     */
    @Override // rg.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onNext(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.b.onNext(java.lang.Object):void");
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        this.f12309c = bVar;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12307a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            this.f12308b.getClass();
            if (!w0.g()) {
                if (w0.b() != null) {
                    w0.b().b0();
                }
                d.a(R$string.str_network_unconnect);
            }
            if (bVar.isDisposed()) {
                bVar.dispose();
            }
        }
    }
}
