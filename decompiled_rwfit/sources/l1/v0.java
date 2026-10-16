package l1;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class v0 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static h b(View view, h hVar) {
        ContentInfo l3 = hVar.f15699a.l();
        Objects.requireNonNull(l3);
        ContentInfo i3 = je.c.i(l3);
        ContentInfo performReceiveContent = view.performReceiveContent(i3);
        if (performReceiveContent == null) {
            return null;
        }
        return performReceiveContent == i3 ? hVar : new h(new com.example.test.ui.device.activity.e0(performReceiveContent));
    }

    public static void c(View view, String[] strArr, x xVar) {
        if (xVar == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new w0(xVar));
        }
    }
}
