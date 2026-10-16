package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.col.p0003sl.a6;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.n1;
import com.amap.api.col.p0003sl.y5;
import com.amap.api.col.p0003sl.z5;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;

/* loaded from: classes.dex */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {

    /* renamed from: h, reason: collision with root package name */
    private static int f5782h;

    /* renamed from: c, reason: collision with root package name */
    private a f5783c;

    /* renamed from: d, reason: collision with root package name */
    private y5 f5784d;
    private y5[] e = new y5[32];

    /* renamed from: f, reason: collision with root package name */
    private int f5785f = -1;

    /* renamed from: g, reason: collision with root package name */
    private z5 f5786g;

    private void a(y5 y5Var) {
        try {
            a aVar = this.f5783c;
            z5 z5Var = null;
            if (aVar != null) {
                aVar.d();
                this.f5783c = null;
            }
            try {
                y5Var.getClass();
                if (this.f5786g == null) {
                    this.f5786g = new z5();
                }
                z5Var = this.f5786g;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            this.f5783c = z5Var;
            if (z5Var != null) {
                this.f5784d = y5Var;
                z5Var.a(this);
                a aVar2 = this.f5783c;
                Bundle bundle = this.f5784d.f5461a;
                aVar2.c();
                this.f5783c.e();
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void closeScr() {
        try {
            if (a((Bundle) null)) {
                return;
            }
            a aVar = this.f5783c;
            if (aVar != null) {
                aVar.d();
            }
            finish();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a aVar = this.f5783c;
            if (aVar != null) {
                aVar.a(view);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            b9.a(false);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            a6.a(getApplicationContext());
            n1.a(getApplicationContext());
            this.f5785f = -1;
            f5782h = 0;
            y5 y5Var = new y5(1, null);
            try {
                f5782h = 1;
                a(y5Var);
                int i3 = (this.f5785f + 1) % 32;
                this.f5785f = i3;
                this.e[i3] = y5Var;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            a aVar = this.f5783c;
            if (aVar != null) {
                aVar.d();
                this.f5783c = null;
            }
            this.f5784d = null;
            this.e = null;
            z5 z5Var = this.f5786g;
            if (z5Var != null) {
                z5Var.d();
                this.f5786g = null;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            try {
                a aVar = this.f5783c;
                if (aVar != null && !aVar.a()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (f5782h == 1) {
                        finish();
                    }
                    return false;
                }
                this.f5785f = -1;
                f5782h = 0;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.AMapPermissionActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        try {
            super.onStart();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        try {
            super.onStop();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.f5783c.b());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (a(bundle)) {
                return;
            }
            a aVar = this.f5783c;
            if (aVar != null) {
                aVar.d();
            }
            finish();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            int i3 = f5782h;
            if ((i3 != 1 || this.f5783c == null) && i3 > 1) {
                f5782h = i3 - 1;
                int i10 = (this.f5785f + 31) % 32;
                this.f5785f = i10;
                y5 y5Var = this.e[i10];
                y5Var.f5461a = bundle;
                a(y5Var);
                return true;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }
}
