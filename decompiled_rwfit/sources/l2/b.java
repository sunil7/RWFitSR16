package l2;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final m0.b f15753a;

    /* renamed from: b, reason: collision with root package name */
    public final m0.b f15754b;

    /* renamed from: c, reason: collision with root package name */
    public final m0.b f15755c;

    public b(m0.b bVar, m0.b bVar2, m0.b bVar3) {
        this.f15753a = bVar;
        this.f15754b = bVar2;
        this.f15755c = bVar3;
    }

    public abstract c a();

    public final Class b(Class cls) {
        String name = cls.getName();
        m0.b bVar = this.f15755c;
        Class cls2 = (Class) bVar.getOrDefault(name, null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        bVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) {
        m0.b bVar = this.f15753a;
        Method method = (Method) bVar.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, b.class.getClassLoader()).getDeclaredMethod("read", b.class);
        bVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) {
        String name = cls.getName();
        m0.b bVar = this.f15754b;
        Method method = (Method) bVar.getOrDefault(name, null);
        if (method != null) {
            return method;
        }
        Class b3 = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = b3.getDeclaredMethod("write", cls, b.class);
        bVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i3);

    public final int f(int i3, int i10) {
        return !e(i10) ? i3 : ((c) this).e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i3) {
        if (!e(i3)) {
            return parcelable;
        }
        return ((c) this).e.readParcelable(c.class.getClassLoader());
    }

    public final d h() {
        String readString = ((c) this).e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (d) c(readString).invoke(null, a());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e11);
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e12.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
        }
    }

    public abstract void i(int i3);

    public final void j(int i3, int i10) {
        i(i10);
        ((c) this).e.writeInt(i3);
    }

    public final void k(Parcelable parcelable, int i3) {
        i(i3);
        ((c) this).e.writeParcelable(parcelable, 0);
    }

    public final void l(d dVar) {
        if (dVar == null) {
            ((c) this).e.writeString(null);
            return;
        }
        try {
            ((c) this).e.writeString(b(dVar.getClass()).getName());
            c a3 = a();
            try {
                d(dVar.getClass()).invoke(null, dVar, a3);
                int i3 = a3.f15760i;
                if (i3 >= 0) {
                    int i10 = a3.f15756d.get(i3);
                    Parcel parcel = a3.e;
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i10);
                    parcel.writeInt(dataPosition - i10);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
            } catch (NoSuchMethodException e11) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e11);
            } catch (InvocationTargetException e12) {
                if (!(e12.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
                }
                throw ((RuntimeException) e12.getCause());
            }
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException(dVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e13);
        }
    }
}
