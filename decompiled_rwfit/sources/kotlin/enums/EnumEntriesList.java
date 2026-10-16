package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.e;
import kotlin.collections.g;

/* loaded from: classes2.dex */
final class EnumEntriesList<T extends Enum<T>> extends e implements ih.a, Serializable {
    private final T[] entries;

    public EnumEntriesList(T[] entries) {
        kotlin.jvm.internal.e.f(entries, "entries");
        this.entries = entries;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return contains((EnumEntriesList<T>) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.entries.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((EnumEntriesList<T>) obj);
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return lastIndexOf((EnumEntriesList<T>) obj);
        }
        return -1;
    }

    public boolean contains(T element) {
        kotlin.jvm.internal.e.f(element, "element");
        return ((Enum) g.f(element.ordinal(), this.entries)) == element;
    }

    @Override // java.util.List
    public T get(int i3) {
        kotlin.collections.a aVar = e.Companion;
        int length = this.entries.length;
        aVar.getClass();
        kotlin.collections.a.a(i3, length);
        return this.entries[i3];
    }

    public int indexOf(T element) {
        kotlin.jvm.internal.e.f(element, "element");
        int ordinal = element.ordinal();
        if (((Enum) g.f(ordinal, this.entries)) == element) {
            return ordinal;
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        kotlin.jvm.internal.e.f(element, "element");
        return indexOf((Object) element);
    }
}
