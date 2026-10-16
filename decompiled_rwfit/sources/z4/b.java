package z4;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.dh.imagepick.DevUtil;
import com.dh.imagepick.Utils;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.e;
import oh.q;

/* loaded from: classes.dex */
public final class b extends Fragment implements c, b5.a {

    /* renamed from: a, reason: collision with root package name */
    public int f20318a = 2;

    /* renamed from: b, reason: collision with root package name */
    public int f20319b;

    /* renamed from: c, reason: collision with root package name */
    public Lambda f20320c;

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f20318a = 4;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, kotlin.jvm.internal.Lambda, oh.q] */
    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i3, int i10, Intent intent) {
        super.onActivityResult(i3, i10, intent);
        if (this.f20320c == null || this.f20319b != i3) {
            return;
        }
        if (!Utils.INSTANCE.isHostAvailable$imagepick_release(this)) {
            DevUtil.INSTANCE.e("ImagePick", " already dead ,did not callback");
            return;
        }
        ?? r02 = this.f20320c;
        e.c(r02);
        r02.invoke(Integer.valueOf(i3), Integer.valueOf(i10), intent);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f20318a = 8;
        super.onDestroy();
        this.f20320c = null;
    }

    @Override // b5.a
    public final int t() {
        return this.f20318a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z4.c
    public final void v(Intent intent, int i3, q qVar) {
        this.f20319b = i3;
        this.f20320c = (Lambda) qVar;
        startActivityForResult(intent, i3);
    }
}
