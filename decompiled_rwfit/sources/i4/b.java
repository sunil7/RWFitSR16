package i4;

import android.content.Context;
import android.net.Uri;
import g4.c;
import w3.d;
import x3.f;
import x3.g;
import z3.s;

/* loaded from: classes.dex */
public final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14352a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14353b;

    public b(a4.b bVar) {
        this.f14353b = bVar;
    }

    @Override // x3.g
    public final boolean a(Object obj, f fVar) {
        switch (this.f14352a) {
            case 0:
                return ((Uri) obj).getScheme().equals("android.resource");
            default:
                return true;
        }
    }

    @Override // x3.g
    public final s b(Object obj, int i3, int i10, f fVar) {
        switch (this.f14352a) {
            case 0:
                return c((Uri) obj);
            default:
                return c.b((a4.b) this.f14353b, ((d) obj).b());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z3.s c(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getAuthority()
            java.lang.Object r1 = r7.f14353b
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r2 = r1.getPackageName()
            boolean r2 = r0.equals(r2)
            r3 = 0
            if (r2 == 0) goto L15
        L13:
            r0 = r1
            goto L26
        L15:
            android.content.Context r0 = r1.createPackageContext(r0, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1a
            goto L26
        L1a:
            r2 = move-exception
            java.lang.String r4 = r1.getPackageName()
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto Lba
            goto L13
        L26:
            java.util.List r2 = r8.getPathSegments()
            int r4 = r2.size()
            r5 = 2
            r6 = 1
            if (r4 != r5) goto L71
            java.util.List r2 = r8.getPathSegments()
            java.lang.String r4 = r8.getAuthority()
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            android.content.res.Resources r5 = r0.getResources()
            int r4 = r5.getIdentifier(r2, r3, r4)
            if (r4 != 0) goto L5a
            android.content.res.Resources r4 = android.content.res.Resources.getSystem()
            java.lang.String r5 = "android"
            int r4 = r4.getIdentifier(r2, r3, r5)
        L5a:
            if (r4 == 0) goto L5d
            goto L87
        L5d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find resource id for: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L71:
            int r2 = r2.size()
            java.lang.String r4 = "Unrecognized Uri format: "
            if (r2 != r6) goto La8
            java.util.List r2 = r8.getPathSegments()
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.NumberFormatException -> L95
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.NumberFormatException -> L95
            int r4 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L95
        L87:
            r8 = 0
            android.graphics.drawable.Drawable r0 = com.google.android.gms.internal.mlkit_vision_barcode.nc.a(r1, r0, r4, r8)
            if (r0 == 0) goto L94
            i4.a r8 = new i4.a
            r1 = 0
            r8.<init>(r0, r1)
        L94:
            return r8
        L95:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8, r0)
            throw r1
        La8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        Lba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to obtain context or unrecognized Uri format for: "
            r1.<init>(r3)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.b.c(android.net.Uri):z3.s");
    }

    public b(Context context) {
        this.f14353b = context.getApplicationContext();
    }
}
