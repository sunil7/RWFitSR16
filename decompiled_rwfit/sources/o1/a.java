package o1;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import androidx.appcompat.widget.i3;

/* loaded from: classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i3 f16681a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(i3 i3Var) {
        super(new Handler());
        this.f16681a = i3Var;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z5) {
        Cursor cursor;
        i3 i3Var = this.f16681a;
        if (!i3Var.f16683b || (cursor = i3Var.f16684c) == null || cursor.isClosed()) {
            return;
        }
        i3Var.f16682a = i3Var.f16684c.requery();
    }
}
