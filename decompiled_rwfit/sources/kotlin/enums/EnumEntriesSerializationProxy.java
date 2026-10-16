package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    private final Class<E> f15645c;

    public EnumEntriesSerializationProxy(E[] entries) {
        e.f(entries, "entries");
        Class<E> cls = (Class<E>) entries.getClass().getComponentType();
        e.c(cls);
        this.f15645c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.f15645c.getEnumConstants();
        e.e(enumConstants, "c.enumConstants");
        return new EnumEntriesList(enumConstants);
    }
}
