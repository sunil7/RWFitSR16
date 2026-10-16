package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.SparseArray;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.r6;
import com.google.android.gms.internal.mlkit_vision_common.t;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import q9.n;
import u8.b;
import x9.a;
import z9.c;

/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new b(18);
    private final int zaa;
    private final Parcel zab;
    private final int zac;
    private final zan zad;
    private final String zae;
    private int zaf;
    private int zag;

    public SafeParcelResponse(int i3, Parcel parcel, zan zanVar) {
        this.zaa = i3;
        n.e(parcel);
        this.zab = parcel;
        this.zac = 2;
        this.zad = zanVar;
        this.zae = zanVar == null ? null : zanVar.b();
        this.zaf = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v70, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r5v77 */
    /* JADX WARN: Type inference failed for: r5v78 */
    public static void l(StringBuilder sb2, Map map, Parcel parcel) {
        BigInteger bigInteger;
        Parcel obtain;
        BigInteger[] bigIntegerArr;
        long[] createLongArray;
        double[] createDoubleArray;
        BigDecimal[] bigDecimalArr;
        boolean[] createBooleanArray;
        Parcel[] parcelArr;
        a aVar;
        Serializable bigInteger2;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        a aVar7;
        a aVar8;
        a aVar9;
        a aVar10;
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse$Field) entry.getValue()).f9153f, entry);
        }
        sb2.append('{');
        int t8 = t.t(parcel);
        boolean z5 = false;
        while (parcel.dataPosition() < t8) {
            int readInt = parcel.readInt();
            Map.Entry entry2 = (Map.Entry) sparseArray.get((char) readInt);
            if (entry2 != null) {
                if (z5) {
                    sb2.append(Const.STR_MART_COMMA);
                }
                String str = (String) entry2.getKey();
                FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) entry2.getValue();
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                boolean k10 = fastJsonResponse$Field.k();
                int i3 = fastJsonResponse$Field.f9151c;
                if (k10) {
                    switch (i3) {
                        case 0:
                            Serializable valueOf = Integer.valueOf(t.o(parcel, readInt));
                            aVar = fastJsonResponse$Field.zak;
                            if (aVar != null) {
                                valueOf = fastJsonResponse$Field.h(valueOf);
                            }
                            n(sb2, fastJsonResponse$Field, valueOf);
                            break;
                        case 1:
                            int r = t.r(parcel, readInt);
                            int dataPosition = parcel.dataPosition();
                            if (r == 0) {
                                bigInteger2 = null;
                            } else {
                                byte[] createByteArray = parcel.createByteArray();
                                parcel.setDataPosition(dataPosition + r);
                                bigInteger2 = new BigInteger(createByteArray);
                            }
                            aVar2 = fastJsonResponse$Field.zak;
                            if (aVar2 != null) {
                                bigInteger2 = fastJsonResponse$Field.h(bigInteger2);
                            }
                            n(sb2, fastJsonResponse$Field, bigInteger2);
                            break;
                        case 2:
                            Serializable valueOf2 = Long.valueOf(t.p(parcel, readInt));
                            aVar3 = fastJsonResponse$Field.zak;
                            if (aVar3 != null) {
                                valueOf2 = fastJsonResponse$Field.h(valueOf2);
                            }
                            n(sb2, fastJsonResponse$Field, valueOf2);
                            break;
                        case 3:
                            t.u(parcel, readInt, 4);
                            Serializable valueOf3 = Float.valueOf(parcel.readFloat());
                            aVar4 = fastJsonResponse$Field.zak;
                            if (aVar4 != null) {
                                valueOf3 = fastJsonResponse$Field.h(valueOf3);
                            }
                            n(sb2, fastJsonResponse$Field, valueOf3);
                            break;
                        case 4:
                            Serializable valueOf4 = Double.valueOf(t.m(parcel, readInt));
                            aVar5 = fastJsonResponse$Field.zak;
                            if (aVar5 != null) {
                                valueOf4 = fastJsonResponse$Field.h(valueOf4);
                            }
                            n(sb2, fastJsonResponse$Field, valueOf4);
                            break;
                        case 5:
                            Serializable a3 = t.a(parcel, readInt);
                            aVar6 = fastJsonResponse$Field.zak;
                            if (aVar6 != null) {
                                a3 = fastJsonResponse$Field.h(a3);
                            }
                            n(sb2, fastJsonResponse$Field, a3);
                            break;
                        case 6:
                            Serializable valueOf5 = Boolean.valueOf(t.l(parcel, readInt));
                            aVar7 = fastJsonResponse$Field.zak;
                            if (aVar7 != null) {
                                valueOf5 = fastJsonResponse$Field.h(valueOf5);
                            }
                            n(sb2, fastJsonResponse$Field, valueOf5);
                            break;
                        case 7:
                            String g10 = t.g(parcel, readInt);
                            aVar8 = fastJsonResponse$Field.zak;
                            if (aVar8 != null) {
                                g10 = fastJsonResponse$Field.h(g10);
                            }
                            n(sb2, fastJsonResponse$Field, g10);
                            break;
                        case 8:
                        case 9:
                            byte[] c9 = t.c(parcel, readInt);
                            aVar9 = fastJsonResponse$Field.zak;
                            ?? r52 = c9;
                            if (aVar9 != null) {
                                r52 = fastJsonResponse$Field.h(c9);
                            }
                            n(sb2, fastJsonResponse$Field, r52);
                            break;
                        case 10:
                            Bundle b3 = t.b(parcel, readInt);
                            HashMap hashMap = new HashMap();
                            for (String str2 : b3.keySet()) {
                                String string = b3.getString(str2);
                                n.e(string);
                                hashMap.put(str2, string);
                            }
                            aVar10 = fastJsonResponse$Field.zak;
                            Serializable serializable = hashMap;
                            if (aVar10 != null) {
                                serializable = fastJsonResponse$Field.h(hashMap);
                            }
                            n(sb2, fastJsonResponse$Field, serializable);
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(l0.j(i3, "Unknown field out type = "));
                    }
                } else if (fastJsonResponse$Field.f9152d) {
                    sb2.append("[");
                    switch (i3) {
                        case 0:
                            int[] e = t.e(parcel, readInt);
                            int length = e.length;
                            for (int i10 = 0; i10 < length; i10++) {
                                if (i10 != 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append(e[i10]);
                            }
                            break;
                        case 1:
                            int r8 = t.r(parcel, readInt);
                            int dataPosition2 = parcel.dataPosition();
                            if (r8 == 0) {
                                bigIntegerArr = null;
                            } else {
                                int readInt2 = parcel.readInt();
                                bigIntegerArr = new BigInteger[readInt2];
                                for (int i11 = 0; i11 < readInt2; i11++) {
                                    bigIntegerArr[i11] = new BigInteger(parcel.createByteArray());
                                }
                                parcel.setDataPosition(dataPosition2 + r8);
                            }
                            int length2 = bigIntegerArr.length;
                            for (int i12 = 0; i12 < length2; i12++) {
                                if (i12 != 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append(bigIntegerArr[i12]);
                            }
                            break;
                        case 2:
                            int r9 = t.r(parcel, readInt);
                            int dataPosition3 = parcel.dataPosition();
                            if (r9 == 0) {
                                createLongArray = null;
                            } else {
                                createLongArray = parcel.createLongArray();
                                parcel.setDataPosition(dataPosition3 + r9);
                            }
                            int length3 = createLongArray.length;
                            for (int i13 = 0; i13 < length3; i13++) {
                                if (i13 != 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append(createLongArray[i13]);
                            }
                            break;
                        case 3:
                            float[] d5 = t.d(parcel, readInt);
                            int length4 = d5.length;
                            for (int i14 = 0; i14 < length4; i14++) {
                                if (i14 != 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append(d5[i14]);
                            }
                            break;
                        case 4:
                            int r10 = t.r(parcel, readInt);
                            int dataPosition4 = parcel.dataPosition();
                            if (r10 == 0) {
                                createDoubleArray = null;
                            } else {
                                createDoubleArray = parcel.createDoubleArray();
                                parcel.setDataPosition(dataPosition4 + r10);
                            }
                            int length5 = createDoubleArray.length;
                            for (int i15 = 0; i15 < length5; i15++) {
                                if (i15 != 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append(createDoubleArray[i15]);
                            }
                            break;
                        case 5:
                            int r11 = t.r(parcel, readInt);
                            int dataPosition5 = parcel.dataPosition();
                            if (r11 == 0) {
                                bigDecimalArr = null;
                            } else {
                                int readInt3 = parcel.readInt();
                                bigDecimalArr = new BigDecimal[readInt3];
                                for (int i16 = 0; i16 < readInt3; i16++) {
                                    bigDecimalArr[i16] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
                                }
                                parcel.setDataPosition(dataPosition5 + r11);
                            }
                            int length6 = bigDecimalArr.length;
                            for (int i17 = 0; i17 < length6; i17++) {
                                if (i17 != 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append(bigDecimalArr[i17]);
                            }
                            break;
                        case 6:
                            int r12 = t.r(parcel, readInt);
                            int dataPosition6 = parcel.dataPosition();
                            if (r12 == 0) {
                                createBooleanArray = null;
                            } else {
                                createBooleanArray = parcel.createBooleanArray();
                                parcel.setDataPosition(dataPosition6 + r12);
                            }
                            int length7 = createBooleanArray.length;
                            for (int i18 = 0; i18 < length7; i18++) {
                                if (i18 != 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append(createBooleanArray[i18]);
                            }
                            break;
                        case 7:
                            String[] h4 = t.h(parcel, readInt);
                            int length8 = h4.length;
                            for (int i19 = 0; i19 < length8; i19++) {
                                if (i19 != 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append("\"");
                                sb2.append(h4[i19]);
                                sb2.append("\"");
                            }
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            int r13 = t.r(parcel, readInt);
                            int dataPosition7 = parcel.dataPosition();
                            if (r13 == 0) {
                                parcelArr = null;
                            } else {
                                int readInt4 = parcel.readInt();
                                Parcel[] parcelArr2 = new Parcel[readInt4];
                                for (int i20 = 0; i20 < readInt4; i20++) {
                                    int readInt5 = parcel.readInt();
                                    if (readInt5 != 0) {
                                        int dataPosition8 = parcel.dataPosition();
                                        Parcel obtain2 = Parcel.obtain();
                                        obtain2.appendFrom(parcel, dataPosition8, readInt5);
                                        parcelArr2[i20] = obtain2;
                                        parcel.setDataPosition(dataPosition8 + readInt5);
                                    } else {
                                        parcelArr2[i20] = null;
                                    }
                                }
                                parcel.setDataPosition(dataPosition7 + r13);
                                parcelArr = parcelArr2;
                            }
                            int length9 = parcelArr.length;
                            for (int i21 = 0; i21 < length9; i21++) {
                                if (i21 > 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                parcelArr[i21].setDataPosition(0);
                                l(sb2, fastJsonResponse$Field.i(), parcelArr[i21]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (i3) {
                        case 0:
                            sb2.append(t.o(parcel, readInt));
                            break;
                        case 1:
                            int r14 = t.r(parcel, readInt);
                            int dataPosition9 = parcel.dataPosition();
                            if (r14 == 0) {
                                bigInteger = null;
                            } else {
                                byte[] createByteArray2 = parcel.createByteArray();
                                parcel.setDataPosition(dataPosition9 + r14);
                                bigInteger = new BigInteger(createByteArray2);
                            }
                            sb2.append(bigInteger);
                            break;
                        case 2:
                            sb2.append(t.p(parcel, readInt));
                            break;
                        case 3:
                            t.u(parcel, readInt, 4);
                            sb2.append(parcel.readFloat());
                            break;
                        case 4:
                            sb2.append(t.m(parcel, readInt));
                            break;
                        case 5:
                            sb2.append(t.a(parcel, readInt));
                            break;
                        case 6:
                            sb2.append(t.l(parcel, readInt));
                            break;
                        case 7:
                            String g11 = t.g(parcel, readInt);
                            sb2.append("\"");
                            sb2.append(c.a(g11));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] c10 = t.c(parcel, readInt);
                            sb2.append("\"");
                            sb2.append(c10 == null ? null : Base64.encodeToString(c10, 0));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] c11 = t.c(parcel, readInt);
                            sb2.append("\"");
                            sb2.append(c11 == null ? null : Base64.encodeToString(c11, 10));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle b10 = t.b(parcel, readInt);
                            Set<String> keySet = b10.keySet();
                            sb2.append(Const.STR_MART_JSON_BEGIN);
                            boolean z6 = true;
                            for (String str3 : keySet) {
                                if (!z6) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append("\"");
                                sb2.append(str3);
                                sb2.append("\":\"");
                                sb2.append(c.a(b10.getString(str3)));
                                sb2.append("\"");
                                z6 = false;
                            }
                            sb2.append("}");
                            break;
                        case 11:
                            int r15 = t.r(parcel, readInt);
                            int dataPosition10 = parcel.dataPosition();
                            if (r15 == 0) {
                                obtain = null;
                            } else {
                                obtain = Parcel.obtain();
                                obtain.appendFrom(parcel, dataPosition10, r15);
                                parcel.setDataPosition(dataPosition10 + r15);
                            }
                            obtain.setDataPosition(0);
                            l(sb2, fastJsonResponse$Field.i(), obtain);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z5 = true;
            }
        }
        if (parcel.dataPosition() != t8) {
            throw new SafeParcelReader$ParseException(l0.j(t8, "Overread allowed size end="), parcel);
        }
        sb2.append('}');
    }

    public static final void m(StringBuilder sb2, int i3, Object obj) {
        switch (i3) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                n.e(obj);
                sb2.append(c.a(obj.toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                byte[] bArr = (byte[]) obj;
                sb2.append(bArr != null ? Base64.encodeToString(bArr, 0) : null);
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                byte[] bArr2 = (byte[]) obj;
                sb2.append(bArr2 != null ? Base64.encodeToString(bArr2, 10) : null);
                sb2.append("\"");
                return;
            case 10:
                n.e(obj);
                r6.a(sb2, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(l0.j(i3, "Unknown type = "));
        }
    }

    public static final void n(StringBuilder sb2, FastJsonResponse$Field fastJsonResponse$Field, Serializable serializable) {
        boolean z5 = fastJsonResponse$Field.f9150b;
        int i3 = fastJsonResponse$Field.f9149a;
        if (!z5) {
            m(sb2, i3, serializable);
            return;
        }
        ArrayList arrayList = (ArrayList) serializable;
        sb2.append("[");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb2.append(Const.STR_MART_COMMA);
            }
            m(sb2, i3, arrayList.get(i10));
        }
        sb2.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final Map a() {
        zan zanVar = this.zad;
        if (zanVar == null) {
            return null;
        }
        String str = this.zae;
        n.e(str);
        return zanVar.h(str);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final Object d() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final boolean i() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Parcel k() {
        int i3 = this.zaf;
        if (i3 == 0) {
            int i10 = u.i(this.zab, 20293);
            this.zag = i10;
            u.j(this.zab, i10);
            this.zaf = 2;
        } else if (i3 == 1) {
            u.j(this.zab, this.zag);
            this.zaf = 2;
        }
        return this.zab;
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final String toString() {
        n.f(this.zad, "Cannot convert to JSON on client side.");
        Parcel k10 = k();
        k10.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        String str = this.zae;
        n.e(str);
        Map h4 = this.zad.h(str);
        n.e(h4);
        l(sb2, h4, k10);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = this.zaa;
        int i11 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(i10);
        Parcel k10 = k();
        if (k10 != null) {
            int i12 = u.i(parcel, 2);
            parcel.appendFrom(k10, 0, k10.dataSize());
            u.j(parcel, i12);
        }
        int i13 = this.zac;
        u.d(parcel, 3, i13 != 0 ? i13 != 1 ? this.zad : this.zad : null, i3);
        u.j(parcel, i11);
    }
}
