package com.amap.api.col.p0003sl;

import java.util.HashMap;

/* loaded from: classes.dex */
public class l7 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile l7 f4469b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, m7> f4470a = new HashMap<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4471a = true;

        /* renamed from: b, reason: collision with root package name */
        private long f4472b = 86400;

        /* renamed from: c, reason: collision with root package name */
        private int f4473c = 10;

        /* renamed from: d, reason: collision with root package name */
        private double f4474d = 0.0d;

        public void a(boolean z5) {
            this.f4471a = z5;
        }

        public int b() {
            return this.f4473c;
        }

        public long c() {
            return this.f4472b;
        }

        public boolean d() {
            return this.f4471a;
        }

        public void a(long j4) {
            this.f4472b = j4;
        }

        public void a(int i3) {
            this.f4473c = i3;
        }

        public double a() {
            return this.f4474d;
        }

        public void a(double d5) {
            this.f4474d = d5;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f4475a;

        /* renamed from: b, reason: collision with root package name */
        Object f4476b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.f4475a;
                if (str == null) {
                    return bVar.f4475a == null && this.f4476b == bVar.f4476b;
                }
                if (str.equals(bVar.f4475a) && this.f4476b == bVar.f4476b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            String str = this.f4475a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.f4476b;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        Object f4477a;

        /* renamed from: b, reason: collision with root package name */
        boolean f4478b;

        public c(Object obj, boolean z5) {
            this.f4477a = obj;
            this.f4478b = z5;
        }
    }

    public static l7 a() {
        if (f4469b == null) {
            synchronized (l7.class) {
                try {
                    if (f4469b == null) {
                        f4469b = new l7();
                    }
                } finally {
                }
            }
        }
        return f4469b;
    }

    public boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (m7 m7Var : this.f4470a.values()) {
            if (m7Var != null && m7Var.b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public synchronized m7 a(String str) {
        return this.f4470a.get(str);
    }

    public synchronized void a(String str, m7 m7Var) {
        this.f4470a.put(str, m7Var);
    }

    public c a(b bVar) {
        c a3;
        if (bVar == null) {
            return null;
        }
        for (m7 m7Var : this.f4470a.values()) {
            if (m7Var != null && (a3 = m7Var.a(bVar)) != null) {
                return a3;
            }
        }
        return null;
    }

    public void a(b bVar, Object obj) {
        for (m7 m7Var : this.f4470a.values()) {
            if (m7Var != null) {
                m7Var.a(bVar, obj);
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        for (m7 m7Var : this.f4470a.values()) {
            if (m7Var != null) {
                m7Var.a(aVar);
            }
        }
    }

    public void a(String str, a aVar) {
        m7 m7Var;
        if (aVar == null || (m7Var = this.f4470a.get(str)) == null) {
            return;
        }
        m7Var.a(aVar);
    }
}
