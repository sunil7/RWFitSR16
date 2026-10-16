package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.g0;
import androidx.lifecycle.n;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import com.google.android.gms.internal.mlkit_vision_barcode.zd;
import l1.o;

/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements s, o {

    /* renamed from: a, reason: collision with root package name */
    public final u f1905a = new u(this);

    public void Q() {
        onBackPressed();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !zd.a(decorView, keyEvent)) {
            return zd.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !zd.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public n getLifecycle() {
        return this.f1905a;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g0.c(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
        u uVar = this.f1905a;
        uVar.d("markState");
        uVar.d("setCurrentState");
        uVar.f(lifecycle$State);
        super.onSaveInstanceState(bundle);
    }

    @Override // l1.o
    public final boolean t(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void u0() {
        finish();
    }

    public void z0() {
        invalidateOptionsMenu();
    }
}
