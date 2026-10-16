package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public interface s1 extends Collection {
    int add(Object obj, int i3);

    int count(Object obj);

    Set elementSet();

    Set entrySet();

    int remove(Object obj, int i3);

    boolean setCount(Object obj, int i3, int i10);
}
