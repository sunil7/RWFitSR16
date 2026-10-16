package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.p0003sl.a1;
import com.amap.api.col.p0003sl.m4;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.col.p0003sl.y4;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final String ICON_ID_PREFIX = "com.amap.api.icon_";

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(m4.marker_default.name() + ".png");
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(v4.a(context, str));
            }
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Throwable th2) {
            v4.a(th2);
            y4.a("[map][function][res]", "read bitmap from assets failed " + th2.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDescriptor(bitmap, ICON_ID_PREFIX + v4.a());
        } catch (Throwable th2) {
            v4.a(th2);
            y4.a("[map][function][res]", "read bitmap from bitmap failed " + th2.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            v4.a(decodeStream);
            return fromBitmap;
        } catch (Throwable th2) {
            v4.a(th2);
            y4.a("[map][function][res]", "read bitmap from disk failed " + th2.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable th2) {
            v4.a(th2);
            y4.a("[map][function][res]", "read bitmap from disk failed " + th2.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i3) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i3)));
            }
            return null;
        } catch (Throwable th2) {
            v4.a(th2);
            y4.a("[map][function][res]", "read bitmap from res failed " + th2.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.setDrawingCacheEnabled(true);
            return fromBitmap(v4.a(frameLayout));
        } catch (Throwable th2) {
            v4.a(th2);
            y4.a("[map][function][res]", "read bitmap from view failed " + th2.getMessage());
            return null;
        }
    }

    public static Context getContext() {
        return a1.f3562f;
    }

    public static BitmapDescriptor defaultMarker(float f2) {
        try {
            float f10 = (((int) (f2 + 15.0f)) / 30) * 30;
            float f11 = 330;
            if (f10 > f11) {
                f10 = f11;
            } else if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            return fromAsset((f10 == 0.0f ? "RED" : f10 == 30.0f ? "ORANGE" : f10 == 60.0f ? "YELLOW" : f10 == 120.0f ? "GREEN" : f10 == 180.0f ? "CYAN" : f10 == 210.0f ? "AZURE" : f10 == 240.0f ? "BLUE" : f10 == 270.0f ? "VIOLET" : f10 == 300.0f ? "MAGENTA" : f10 == 330.0f ? "ROSE" : "").concat(".png"));
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }
}
