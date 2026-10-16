package m4;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.example.test.utils.y;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f15949a;

    /* renamed from: b, reason: collision with root package name */
    public final y f15950b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15951c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15952d;
    public final androidx.appcompat.app.y e = new androidx.appcompat.app.y(this, 2);

    public c(Context context, y yVar) {
        this.f15949a = context.getApplicationContext();
        this.f15950b = yVar;
    }

    public static boolean j(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        t4.f.c(connectivityManager, "Argument must not be null");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (!Log.isLoggable("ConnectivityMonitor", 5)) {
                return true;
            }
            Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            return true;
        }
    }

    @Override // m4.g
    public final void i() {
        if (this.f15952d) {
            return;
        }
        Context context = this.f15949a;
        this.f15951c = j(context);
        try {
            context.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f15952d = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }

    @Override // m4.g
    public final void onDestroy() {
    }

    @Override // m4.g
    public final void onStop() {
        if (this.f15952d) {
            this.f15949a.unregisterReceiver(this.e);
            this.f15952d = false;
        }
    }
}
