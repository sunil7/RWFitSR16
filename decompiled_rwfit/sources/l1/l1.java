package l1;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class l1 extends o1 {

    /* renamed from: c, reason: collision with root package name */
    public static Field f15706c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f15707d = false;
    public static Constructor e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f15708f = false;

    /* renamed from: a, reason: collision with root package name */
    public WindowInsets f15709a;

    /* renamed from: b, reason: collision with root package name */
    public c1.c f15710b;

    public l1() {
        this.f15709a = e();
    }

    private static WindowInsets e() {
        if (!f15707d) {
            try {
                f15706c = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e10) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
            }
            f15707d = true;
        }
        Field field = f15706c;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e11) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
            }
        }
        if (!f15708f) {
            try {
                e = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e12) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
            }
            f15708f = true;
        }
        Constructor constructor = e;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e13) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
            }
        }
        return null;
    }

    @Override // l1.o1
    public x1 b() {
        a();
        x1 h4 = x1.h(this.f15709a, null);
        v1 v1Var = h4.f15738a;
        v1Var.o(null);
        v1Var.q(this.f15710b);
        return h4;
    }

    @Override // l1.o1
    public void c(c1.c cVar) {
        this.f15710b = cVar;
    }

    @Override // l1.o1
    public void d(c1.c cVar) {
        WindowInsets windowInsets = this.f15709a;
        if (windowInsets != null) {
            this.f15709a = windowInsets.replaceSystemWindowInsets(cVar.f3354a, cVar.f3355b, cVar.f3356c, cVar.f3357d);
        }
    }

    public l1(x1 x1Var) {
        super(x1Var);
        this.f15709a = x1Var.g();
    }
}
