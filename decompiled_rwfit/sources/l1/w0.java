package l1;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public final class w0 implements OnReceiveContentListener {

    /* renamed from: a, reason: collision with root package name */
    public final x f15736a;

    public w0(x xVar) {
        this.f15736a = xVar;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        h hVar = new h(new com.example.test.ui.device.activity.e0(contentInfo));
        h a3 = ((androidx.core.widget.v) this.f15736a).a(view, hVar);
        if (a3 == null) {
            return null;
        }
        if (a3 == hVar) {
            return contentInfo;
        }
        ContentInfo l3 = a3.f15699a.l();
        Objects.requireNonNull(l3);
        return je.c.i(l3);
    }
}
