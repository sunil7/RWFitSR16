package t1;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import com.example.test.utils.y;

/* loaded from: classes.dex */
public final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final KeyListener f18476a;

    /* renamed from: b, reason: collision with root package name */
    public final hc.a f18477b;

    public e(KeyListener keyListener) {
        hc.a aVar = new hc.a(19);
        this.f18476a = keyListener;
        this.f18477b = aVar;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i3) {
        this.f18476a.clearMetaKeyState(view, editable, i3);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f18476a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i3, KeyEvent keyEvent) {
        boolean z5;
        this.f18477b.getClass();
        if (i3 != 67 ? i3 != 112 ? false : y.m(editable, keyEvent, true) : y.m(editable, keyEvent, false)) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z5 = true;
        } else {
            z5 = false;
        }
        return z5 || this.f18476a.onKeyDown(view, editable, i3, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f18476a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i3, KeyEvent keyEvent) {
        return this.f18476a.onKeyUp(view, editable, i3, keyEvent);
    }
}
