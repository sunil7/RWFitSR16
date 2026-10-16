package d4;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class k implements h {

    /* renamed from: b, reason: collision with root package name */
    public final Map f12270b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Map f12271c;

    public k(Map map) {
        this.f12270b = Collections.unmodifiableMap(map);
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f12270b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                String str = ((j) list.get(i3)).f12269a;
                if (!TextUtils.isEmpty(str)) {
                    sb2.append(str);
                    if (i3 != list.size() - 1) {
                        sb2.append(',');
                    }
                }
            }
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(sb3)) {
                hashMap.put(entry.getKey(), sb3);
            }
        }
        return hashMap;
    }

    public final Map b() {
        if (this.f12271c == null) {
            synchronized (this) {
                try {
                    if (this.f12271c == null) {
                        this.f12271c = Collections.unmodifiableMap(a());
                    }
                } finally {
                }
            }
        }
        return this.f12271c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f12270b.equals(((k) obj).f12270b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12270b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f12270b + '}';
    }
}
