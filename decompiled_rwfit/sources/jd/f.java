package jd;

import androidx.recyclerview.widget.e1;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public final class f {
    public static final int[] e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: f, reason: collision with root package name */
    public static final f[] f15411f = a();

    /* renamed from: a, reason: collision with root package name */
    public final int f15412a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f15413b;

    /* renamed from: c, reason: collision with root package name */
    public final d6.a[] f15414c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15415d;

    public f(int i3, int[] iArr, d6.a... aVarArr) {
        this.f15412a = i3;
        this.f15413b = iArr;
        this.f15414c = aVarArr;
        d6.a aVar = aVarArr[0];
        int i10 = aVar.f12305a;
        int i11 = 0;
        for (e1 e1Var : (e1[]) aVar.f12306b) {
            i11 += (e1Var.f2555c + i10) * e1Var.f2554b;
        }
        this.f15415d = i11;
    }

    public static f[] a() {
        int i3 = 1;
        int i10 = 2;
        int i11 = 16;
        int i12 = 10;
        int i13 = 13;
        int i14 = 17;
        f fVar = new f(1, new int[0], new d6.a(7, new e1[]{new e1(i3, 19, i10)}), new d6.a(i12, new e1[]{new e1(i3, i11, i10)}), new d6.a(i13, new e1[]{new e1(i3, i13, i10)}), new d6.a(i14, new e1[]{new e1(i3, 9, i10)}));
        int i15 = 18;
        int i16 = 28;
        int i17 = 22;
        f fVar2 = new f(2, new int[]{6, 18}, new d6.a(i12, new e1[]{new e1(i3, 34, i10)}), new d6.a(i11, new e1[]{new e1(i3, i16, i10)}), new d6.a(i17, new e1[]{new e1(i3, i17, i10)}), new d6.a(i16, new e1[]{new e1(i3, i11, i10)}));
        int i18 = 26;
        f fVar3 = new f(3, new int[]{6, 22}, new d6.a(15, new e1[]{new e1(i3, 55, i10)}), new d6.a(i18, new e1[]{new e1(i3, 44, i10)}), new d6.a(i15, new e1[]{new e1(i10, i14, i10)}), new d6.a(i17, new e1[]{new e1(i10, 13, i10)}));
        int i19 = 4;
        f fVar4 = new f(4, new int[]{6, 26}, new d6.a(20, new e1[]{new e1(i3, 80, i10)}), new d6.a(i15, new e1[]{new e1(i10, 32, i10)}), new d6.a(i18, new e1[]{new e1(i10, 24, i10)}), new d6.a(16, new e1[]{new e1(i19, 9, i10)}));
        f fVar5 = new f(5, new int[]{6, 30}, new d6.a(i18, new e1[]{new e1(i3, 108, i10)}), new d6.a(24, new e1[]{new e1(i10, 43, i10)}), new d6.a(18, new e1[]{new e1(i10, 15, i10), new e1(i10, 16, i10)}), new d6.a(22, new e1[]{new e1(i10, 11, i10), new e1(i10, 12, i10)}));
        f fVar6 = new f(6, new int[]{6, 34}, new d6.a(18, new e1[]{new e1(i10, 68, i10)}), new d6.a(16, new e1[]{new e1(i19, 27, i10)}), new d6.a(24, new e1[]{new e1(i19, 19, i10)}), new d6.a(28, new e1[]{new e1(i19, 15, i10)}));
        f fVar7 = new f(7, new int[]{6, 22, 38}, new d6.a(20, new e1[]{new e1(i10, 78, i10)}), new d6.a(18, new e1[]{new e1(i19, 31, i10)}), new d6.a(18, new e1[]{new e1(i10, 14, i10), new e1(i19, 15, i10)}), new d6.a(26, new e1[]{new e1(i19, 13, i10), new e1(1, 14, i10)}));
        int i20 = 22;
        f fVar8 = new f(8, new int[]{6, 24, 42}, new d6.a(24, new e1[]{new e1(i10, 97, i10)}), new d6.a(i20, new e1[]{new e1(i10, 38, i10), new e1(i10, 39, i10)}), new d6.a(i20, new e1[]{new e1(4, 18, i10), new e1(i10, 19, i10)}), new d6.a(26, new e1[]{new e1(4, 14, i10), new e1(i10, 15, i10)}));
        int i21 = 4;
        f fVar9 = new f(9, new int[]{6, 26, 46}, new d6.a(30, new e1[]{new e1(i10, 116, i10)}), new d6.a(22, new e1[]{new e1(3, 36, i10), new e1(i10, 37, i10)}), new d6.a(20, new e1[]{new e1(i21, 16, i10), new e1(i21, 17, i10)}), new d6.a(24, new e1[]{new e1(i21, 12, i10), new e1(i21, 13, i10)}));
        d6.a aVar = new d6.a(18, new e1[]{new e1(i10, 68, i10), new e1(i10, 69, i10)});
        d6.a aVar2 = new d6.a(26, new e1[]{new e1(4, 43, i10), new e1(1, 44, i10)});
        int i22 = 6;
        f fVar10 = new f(10, new int[]{6, 28, 50}, aVar, aVar2, new d6.a(24, new e1[]{new e1(i22, 19, i10), new e1(i10, 20, i10)}), new d6.a(28, new e1[]{new e1(i22, 15, i10), new e1(i10, 16, i10)}));
        int i23 = 4;
        f fVar11 = new f(11, new int[]{6, 30, 54}, new d6.a(20, new e1[]{new e1(i23, 81, i10)}), new d6.a(30, new e1[]{new e1(1, 50, i10), new e1(i23, 51, i10)}), new d6.a(28, new e1[]{new e1(i23, 22, i10), new e1(i23, 23, i10)}), new d6.a(24, new e1[]{new e1(3, 12, i10), new e1(8, 13, i10)}));
        d6.a aVar3 = new d6.a(24, new e1[]{new e1(i10, 92, i10), new e1(i10, 93, i10)});
        int i24 = 6;
        int i25 = 4;
        f fVar12 = new f(12, new int[]{6, 32, 58}, aVar3, new d6.a(22, new e1[]{new e1(i24, 36, i10), new e1(i10, 37, i10)}), new d6.a(26, new e1[]{new e1(4, 20, i10), new e1(i24, 21, i10)}), new d6.a(28, new e1[]{new e1(7, 14, i10), new e1(i25, 15, i10)}));
        int i26 = 8;
        int i27 = 12;
        f fVar13 = new f(13, new int[]{6, 34, 62}, new d6.a(26, new e1[]{new e1(i25, 107, i10)}), new d6.a(22, new e1[]{new e1(i26, 37, i10), new e1(1, 38, i10)}), new d6.a(24, new e1[]{new e1(i26, 20, i10), new e1(4, 21, i10)}), new d6.a(22, new e1[]{new e1(i27, 11, i10), new e1(4, i27, i10)}));
        d6.a aVar4 = new d6.a(30, new e1[]{new e1(3, 115, i10), new e1(1, 116, i10)});
        int i28 = 5;
        f fVar14 = new f(14, new int[]{6, 26, 46, 66}, aVar4, new d6.a(24, new e1[]{new e1(4, 40, i10), new e1(i28, 41, i10)}), new d6.a(20, new e1[]{new e1(11, 16, i10), new e1(i28, 17, i10)}), new d6.a(24, new e1[]{new e1(11, 12, i10), new e1(5, 13, i10)}));
        int i29 = 5;
        int i30 = 24;
        f fVar15 = new f(15, new int[]{6, 26, 48, 70}, new d6.a(22, new e1[]{new e1(i29, 87, i10), new e1(1, 88, i10)}), new d6.a(i30, new e1[]{new e1(i29, 41, i10), new e1(i29, 42, i10)}), new d6.a(30, new e1[]{new e1(i29, i30, i10), new e1(7, 25, i10)}), new d6.a(24, new e1[]{new e1(11, 12, i10), new e1(7, 13, i10)}));
        int i31 = 15;
        f fVar16 = new f(16, new int[]{6, 26, 50, 74}, new d6.a(24, new e1[]{new e1(5, 98, i10), new e1(1, 99, i10)}), new d6.a(28, new e1[]{new e1(7, 45, i10), new e1(3, 46, i10)}), new d6.a(24, new e1[]{new e1(i31, 19, i10), new e1(i10, 20, i10)}), new d6.a(30, new e1[]{new e1(3, i31, i10), new e1(13, 16, i10)}));
        int i32 = 1;
        int i33 = 28;
        int i34 = 15;
        f fVar17 = new f(17, new int[]{6, 30, 54, 78}, new d6.a(i33, new e1[]{new e1(i32, 107, i10), new e1(5, 108, i10)}), new d6.a(i33, new e1[]{new e1(10, 46, i10), new e1(i32, 47, i10)}), new d6.a(28, new e1[]{new e1(i32, 22, i10), new e1(i34, 23, i10)}), new d6.a(28, new e1[]{new e1(i10, 14, i10), new e1(17, i34, i10)}));
        f fVar18 = new f(18, new int[]{6, 30, 56, 82}, new d6.a(30, new e1[]{new e1(5, 120, i10), new e1(1, 121, i10)}), new d6.a(26, new e1[]{new e1(9, 43, i10), new e1(4, 44, i10)}), new d6.a(28, new e1[]{new e1(17, 22, i10), new e1(1, 23, i10)}), new d6.a(28, new e1[]{new e1(i10, 14, i10), new e1(19, 15, i10)}));
        int i35 = 3;
        f fVar19 = new f(19, new int[]{6, 30, 58, 86}, new d6.a(28, new e1[]{new e1(i35, 113, i10), new e1(4, 114, i10)}), new d6.a(26, new e1[]{new e1(i35, 44, i10), new e1(11, 45, i10)}), new d6.a(26, new e1[]{new e1(17, 21, i10), new e1(4, 22, i10)}), new d6.a(26, new e1[]{new e1(9, 13, i10), new e1(16, 14, i10)}));
        int i36 = 3;
        d6.a aVar5 = new d6.a(28, new e1[]{new e1(i36, 107, i10), new e1(5, 108, i10)});
        d6.a aVar6 = new d6.a(26, new e1[]{new e1(i36, 41, i10), new e1(13, 42, i10)});
        d6.a aVar7 = new d6.a(30, new e1[]{new e1(15, 24, i10), new e1(5, 25, i10)});
        int i37 = 15;
        int i38 = 28;
        f fVar20 = new f(20, new int[]{6, 34, 62, 90}, aVar5, aVar6, aVar7, new d6.a(i38, new e1[]{new e1(i37, i37, i10), new e1(10, 16, i10)}));
        int i39 = 4;
        d6.a aVar8 = new d6.a(i38, new e1[]{new e1(i39, 116, i10), new e1(i39, 117, i10)});
        int i40 = 17;
        f fVar21 = new f(21, new int[]{6, 28, 50, 72, 94}, aVar8, new d6.a(26, new e1[]{new e1(i40, 42, i10)}), new d6.a(28, new e1[]{new e1(i40, 22, i10), new e1(6, 23, i10)}), new d6.a(30, new e1[]{new e1(19, 16, i10), new e1(6, 17, i10)}));
        int i41 = 7;
        int i42 = 28;
        f fVar22 = new f(22, new int[]{6, 26, 50, 74, 98}, new d6.a(i42, new e1[]{new e1(i10, AMapEngineUtils.ARROW_LINE_INNER_TEXTURE_ID, i10), new e1(i41, 112, i10)}), new d6.a(i42, new e1[]{new e1(17, 46, i10)}), new d6.a(30, new e1[]{new e1(i41, 24, i10), new e1(16, 25, i10)}), new d6.a(24, new e1[]{new e1(34, 13, i10)}));
        d6.a aVar9 = new d6.a(30, new e1[]{new e1(4, 121, i10), new e1(5, 122, i10)});
        d6.a aVar10 = new d6.a(28, new e1[]{new e1(4, 47, i10), new e1(14, 48, i10)});
        d6.a aVar11 = new d6.a(30, new e1[]{new e1(11, 24, i10), new e1(14, 25, i10)});
        int i43 = 16;
        f fVar23 = new f(23, new int[]{6, 30, 54, 78, 102}, aVar9, aVar10, aVar11, new d6.a(30, new e1[]{new e1(i43, 15, i10), new e1(14, i43, i10)}));
        int i44 = 6;
        d6.a aVar12 = new d6.a(30, new e1[]{new e1(i44, 117, i10), new e1(4, 118, i10)});
        d6.a aVar13 = new d6.a(28, new e1[]{new e1(i44, 45, i10), new e1(14, 46, i10)});
        int i45 = 16;
        int i46 = 30;
        f fVar24 = new f(24, new int[]{6, 28, 54, 80, 106}, aVar12, aVar13, new d6.a(i46, new e1[]{new e1(11, 24, i10), new e1(i45, 25, i10)}), new d6.a(30, new e1[]{new e1(i46, i45, i10), new e1(i10, 17, i10)}));
        int i47 = 8;
        d6.a aVar14 = new d6.a(26, new e1[]{new e1(i47, 106, i10), new e1(4, 107, i10)});
        d6.a aVar15 = new d6.a(28, new e1[]{new e1(i47, 47, i10), new e1(13, 48, i10)});
        int i48 = 22;
        f fVar25 = new f(25, new int[]{6, 32, 58, 84, 110}, aVar14, aVar15, new d6.a(30, new e1[]{new e1(7, 24, i10), new e1(i48, 25, i10)}), new d6.a(30, new e1[]{new e1(i48, 15, i10), new e1(13, 16, i10)}));
        e1[] e1VarArr = {new e1(10, 114, i10), new e1(i10, 115, i10)};
        int i49 = 28;
        f fVar26 = new f(26, new int[]{6, 30, 58, 86, 114}, new d6.a(i49, e1VarArr), new d6.a(i49, new e1[]{new e1(19, 46, i10), new e1(4, 47, i10)}), new d6.a(28, new e1[]{new e1(i49, 22, i10), new e1(6, 23, i10)}), new d6.a(30, new e1[]{new e1(33, 16, i10), new e1(4, 17, i10)}));
        int i50 = 30;
        d6.a aVar16 = new d6.a(i50, new e1[]{new e1(8, 122, i10), new e1(4, 123, i10)});
        int i51 = 28;
        f fVar27 = new f(27, new int[]{6, 34, 62, 90, 118}, aVar16, new d6.a(i51, new e1[]{new e1(22, 45, i10), new e1(3, 46, i10)}), new d6.a(30, new e1[]{new e1(8, 23, i10), new e1(26, 24, i10)}), new d6.a(30, new e1[]{new e1(12, 15, i10), new e1(28, 16, i10)}));
        int i52 = 3;
        f fVar28 = new f(28, new int[]{6, 26, 50, 74, 98, 122}, new d6.a(30, new e1[]{new e1(i52, 117, i10), new e1(10, 118, i10)}), new d6.a(28, new e1[]{new e1(i52, 45, i10), new e1(23, 46, i10)}), new d6.a(30, new e1[]{new e1(4, 24, i10), new e1(31, 25, i10)}), new d6.a(30, new e1[]{new e1(11, 15, i10), new e1(31, 16, i10)}));
        int i53 = 7;
        f fVar29 = new f(29, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT}, new d6.a(30, new e1[]{new e1(i53, 116, i10), new e1(i53, 117, i10)}), new d6.a(28, new e1[]{new e1(21, 45, i10), new e1(i53, 46, i10)}), new d6.a(30, new e1[]{new e1(1, 23, i10), new e1(37, 24, i10)}), new d6.a(30, new e1[]{new e1(19, 15, i10), new e1(26, 16, i10)}));
        int i54 = 10;
        int i55 = 30;
        int i56 = 15;
        int i57 = 25;
        int i58 = 30;
        f fVar30 = new f(30, new int[]{6, 26, 52, 78, 104, 130}, new d6.a(i55, new e1[]{new e1(5, 115, i10), new e1(i54, 116, i10)}), new d6.a(28, new e1[]{new e1(19, 47, i10), new e1(i54, 48, i10)}), new d6.a(30, new e1[]{new e1(i56, 24, i10), new e1(i57, i57, i10)}), new d6.a(i58, new e1[]{new e1(23, i56, i10), new e1(25, 16, i10)}));
        int i59 = 30;
        f fVar31 = new f(31, new int[]{6, 30, 56, 82, 108, 134}, new d6.a(i58, new e1[]{new e1(13, 115, i10), new e1(3, 116, i10)}), new d6.a(28, new e1[]{new e1(i10, 46, i10), new e1(29, 47, i10)}), new d6.a(30, new e1[]{new e1(42, 24, i10), new e1(1, 25, i10)}), new d6.a(i59, new e1[]{new e1(23, 15, i10), new e1(28, 16, i10)}));
        d6.a aVar17 = new d6.a(i59, new e1[]{new e1(17, 115, i10)});
        int i60 = 10;
        f fVar32 = new f(32, new int[]{6, 34, 60, 86, 112, 138}, aVar17, new d6.a(28, new e1[]{new e1(i60, 46, i10), new e1(23, 47, i10)}), new d6.a(30, new e1[]{new e1(i60, 24, i10), new e1(35, 25, i10)}), new d6.a(30, new e1[]{new e1(19, 15, i10), new e1(35, 16, i10)}));
        f fVar33 = new f(33, new int[]{6, 30, 58, 86, 114, 142}, new d6.a(30, new e1[]{new e1(17, 115, i10), new e1(1, 116, i10)}), new d6.a(28, new e1[]{new e1(14, 46, i10), new e1(21, 47, i10)}), new d6.a(30, new e1[]{new e1(29, 24, i10), new e1(19, 25, i10)}), new d6.a(30, new e1[]{new e1(11, 15, i10), new e1(46, 16, i10)}));
        int i61 = 30;
        f fVar34 = new f(34, new int[]{6, 34, 62, 90, 118, 146}, new d6.a(i61, new e1[]{new e1(13, 115, i10), new e1(6, 116, i10)}), new d6.a(28, new e1[]{new e1(14, 46, i10), new e1(23, 47, i10)}), new d6.a(30, new e1[]{new e1(44, 24, i10), new e1(7, 25, i10)}), new d6.a(30, new e1[]{new e1(59, 16, i10), new e1(1, 17, i10)}));
        int i62 = 12;
        f fVar35 = new f(35, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, 150}, new d6.a(30, new e1[]{new e1(i62, 121, i10), new e1(7, 122, i10)}), new d6.a(28, new e1[]{new e1(i62, 47, i10), new e1(26, 48, i10)}), new d6.a(30, new e1[]{new e1(39, 24, i10), new e1(14, 25, i10)}), new d6.a(30, new e1[]{new e1(22, 15, i10), new e1(41, 16, i10)}));
        int i63 = 6;
        int i64 = 30;
        f fVar36 = new f(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new d6.a(i64, new e1[]{new e1(i63, 121, i10), new e1(14, 122, i10)}), new d6.a(28, new e1[]{new e1(i63, 47, i10), new e1(34, 48, i10)}), new d6.a(30, new e1[]{new e1(46, 24, i10), new e1(10, 25, i10)}), new d6.a(30, new e1[]{new e1(i10, 15, i10), new e1(64, 16, i10)}));
        f fVar37 = new f(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new d6.a(30, new e1[]{new e1(17, 122, i10), new e1(4, 123, i10)}), new d6.a(28, new e1[]{new e1(29, 46, i10), new e1(14, 47, i10)}), new d6.a(30, new e1[]{new e1(49, 24, i10), new e1(10, 25, i10)}), new d6.a(30, new e1[]{new e1(24, 15, i10), new e1(46, 16, i10)}));
        f fVar38 = new f(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new d6.a(30, new e1[]{new e1(4, 122, i10), new e1(18, 123, i10)}), new d6.a(28, new e1[]{new e1(13, 46, i10), new e1(32, 47, i10)}), new d6.a(30, new e1[]{new e1(48, 24, i10), new e1(14, 25, i10)}), new d6.a(30, new e1[]{new e1(42, 15, i10), new e1(32, 16, i10)}));
        int i65 = 30;
        f fVar39 = new f(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new d6.a(i65, new e1[]{new e1(20, 117, i10), new e1(4, 118, i10)}), new d6.a(28, new e1[]{new e1(40, 47, i10), new e1(7, 48, i10)}), new d6.a(30, new e1[]{new e1(43, 24, i10), new e1(22, 25, i10)}), new d6.a(30, new e1[]{new e1(10, 15, i10), new e1(67, 16, i10)}));
        int i66 = 30;
        d6.a aVar18 = new d6.a(i66, new e1[]{new e1(19, 118, i10), new e1(6, 119, i10)});
        int i67 = 34;
        return new f[]{fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12, fVar13, fVar14, fVar15, fVar16, fVar17, fVar18, fVar19, fVar20, fVar21, fVar22, fVar23, fVar24, fVar25, fVar26, fVar27, fVar28, fVar29, fVar30, fVar31, fVar32, fVar33, fVar34, fVar35, fVar36, fVar37, fVar38, fVar39, new f(40, new int[]{6, 30, 58, 86, 114, 142, 170}, aVar18, new d6.a(28, new e1[]{new e1(18, 47, i10), new e1(31, 48, i10)}), new d6.a(30, new e1[]{new e1(i67, 24, i10), new e1(i67, 25, i10)}), new d6.a(30, new e1[]{new e1(20, 15, i10), new e1(61, 16, i10)}))};
    }

    public static f b(int i3) {
        int i10 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i11 = 0;
        for (int i12 = 0; i12 < 34; i12++) {
            int i13 = e[i12];
            if (i13 == i3) {
                return c(i12 + 7);
            }
            int bitCount = Integer.bitCount(i13 ^ i3);
            if (bitCount < i10) {
                i11 = i12 + 7;
                i10 = bitCount;
            }
        }
        if (i10 <= 3) {
            return c(i11);
        }
        return null;
    }

    public static f c(int i3) {
        if (i3 < 1 || i3 > 40) {
            throw new IllegalArgumentException();
        }
        return f15411f[i3 - 1];
    }

    public final String toString() {
        return String.valueOf(this.f15412a);
    }
}
