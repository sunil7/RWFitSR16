package q4;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: d, reason: collision with root package name */
    public static Integer f17786d;

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f17787a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f17788b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public c f17789c;

    public h(ImageView imageView) {
        this.f17787a = imageView;
    }

    public final int a(int i3, int i10, int i11) {
        int i12 = i10 - i11;
        if (i12 > 0) {
            return i12;
        }
        int i13 = i3 - i11;
        if (i13 > 0) {
            return i13;
        }
        ImageView imageView = this.f17787a;
        if (imageView.isLayoutRequested() || i10 != -2) {
            return 0;
        }
        if (Log.isLoggable("ViewTarget", 4)) {
            Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        Context context = imageView.getContext();
        if (f17786d == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            t4.f.c(windowManager, "Argument must not be null");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f17786d = Integer.valueOf(Math.max(point.x, point.y));
        }
        return f17786d.intValue();
    }
}
