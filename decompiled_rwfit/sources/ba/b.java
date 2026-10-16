package ba;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.mlkit_vision_barcode.g;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.lang.reflect.Field;
import q9.n;

/* loaded from: classes.dex */
public final class b extends g implements a {

    /* renamed from: b, reason: collision with root package name */
    public final Object f3181b;

    public b(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper", 2);
        this.f3181b = obj;
    }

    public static a A(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new c(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 2);
    }

    public static Object B(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f3181b;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i3 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i3++;
                field = field2;
            }
        }
        if (i3 != 1) {
            throw new IllegalArgumentException(l0.j(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
        }
        n.e(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(asBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e10) {
            throw new IllegalArgumentException("Binder object is null.", e10);
        }
    }
}
