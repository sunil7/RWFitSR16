package z4;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import com.dh.imagepick.DevUtil;
import com.dh.imagepick.Utils;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.e;
import oh.q;

/* loaded from: classes.dex */
public final class a extends Fragment implements c, b5.a {

    /* renamed from: a, reason: collision with root package name */
    public int f20315a = 2;

    /* renamed from: b, reason: collision with root package name */
    public int f20316b;

    /* renamed from: c, reason: collision with root package name */
    public Lambda f20317c;

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f20315a = 4;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, kotlin.jvm.internal.Lambda, oh.q] */
    @Override // android.app.Fragment
    public final void onActivityResult(int i3, int i10, Intent intent) {
        super.onActivityResult(i3, i10, intent);
        if (this.f20317c == null || this.f20316b != i3) {
            return;
        }
        if (!Utils.INSTANCE.isHostAvailable$imagepick_release(this)) {
            DevUtil.INSTANCE.e("ImagePick", " already dead ,did not callback");
            return;
        }
        ?? r02 = this.f20317c;
        e.c(r02);
        r02.invoke(Integer.valueOf(i3), Integer.valueOf(i10), intent);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        this.f20315a = 8;
        super.onDestroy();
        this.f20317c = null;
    }

    @Override // b5.a
    public final int t() {
        return this.f20315a;
    }

    @Override // z4.c
    public final Activity u() {
        return getActivity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z4.c
    public final void v(Intent intent, int i3, q qVar) {
        this.f20316b = i3;
        this.f20317c = (Lambda) qVar;
        startActivityForResult(intent, i3);
    }
}
