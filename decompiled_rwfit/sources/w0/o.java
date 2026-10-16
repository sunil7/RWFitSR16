package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_common.g0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.open.log.TraceLevel;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f19437g = {0, 4, 8};

    /* renamed from: h, reason: collision with root package name */
    public static final SparseIntArray f19438h;

    /* renamed from: i, reason: collision with root package name */
    public static final SparseIntArray f19439i;

    /* renamed from: a, reason: collision with root package name */
    public String f19440a;

    /* renamed from: b, reason: collision with root package name */
    public String f19441b = "";

    /* renamed from: c, reason: collision with root package name */
    public int f19442c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f19443d = new HashMap();
    public boolean e = true;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f19444f = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19438h = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f19439i = sparseIntArray2;
        sparseIntArray.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sparseIntArray.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        sparseIntArray.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        sparseIntArray.append(R$styleable.Constraint_android_orientation, 27);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        sparseIntArray.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        sparseIntArray.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        sparseIntArray.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        sparseIntArray.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        sparseIntArray.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        sparseIntArray.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        sparseIntArray.append(R$styleable.Constraint_android_layout_marginRight, 28);
        sparseIntArray.append(R$styleable.Constraint_android_layout_marginStart, 31);
        sparseIntArray.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        sparseIntArray.append(R$styleable.Constraint_android_layout_marginTop, 34);
        sparseIntArray.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        sparseIntArray.append(R$styleable.Constraint_android_layout_width, 23);
        sparseIntArray.append(R$styleable.Constraint_android_layout_height, 21);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintWidth, 95);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintHeight, 96);
        sparseIntArray.append(R$styleable.Constraint_android_visibility, 22);
        sparseIntArray.append(R$styleable.Constraint_android_alpha, 43);
        sparseIntArray.append(R$styleable.Constraint_android_elevation, 44);
        sparseIntArray.append(R$styleable.Constraint_android_rotationX, 45);
        sparseIntArray.append(R$styleable.Constraint_android_rotationY, 46);
        sparseIntArray.append(R$styleable.Constraint_android_rotation, 60);
        sparseIntArray.append(R$styleable.Constraint_android_scaleX, 47);
        sparseIntArray.append(R$styleable.Constraint_android_scaleY, 48);
        sparseIntArray.append(R$styleable.Constraint_android_transformPivotX, 49);
        sparseIntArray.append(R$styleable.Constraint_android_transformPivotY, 50);
        sparseIntArray.append(R$styleable.Constraint_android_translationX, 51);
        sparseIntArray.append(R$styleable.Constraint_android_translationY, 52);
        sparseIntArray.append(R$styleable.Constraint_android_translationZ, 53);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintCircle, 61);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        sparseIntArray.append(R$styleable.Constraint_animateRelativeTo, 64);
        sparseIntArray.append(R$styleable.Constraint_transitionEasing, 65);
        sparseIntArray.append(R$styleable.Constraint_drawPath, 66);
        sparseIntArray.append(R$styleable.Constraint_transitionPathRotate, 67);
        sparseIntArray.append(R$styleable.Constraint_motionStagger, 79);
        sparseIntArray.append(R$styleable.Constraint_android_id, 38);
        sparseIntArray.append(R$styleable.Constraint_motionProgress, 68);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        sparseIntArray.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(R$styleable.Constraint_chainUseRtl, 71);
        sparseIntArray.append(R$styleable.Constraint_barrierDirection, 72);
        sparseIntArray.append(R$styleable.Constraint_barrierMargin, 73);
        sparseIntArray.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        sparseIntArray.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        sparseIntArray.append(R$styleable.Constraint_pathMotionArc, 76);
        sparseIntArray.append(R$styleable.Constraint_layout_constraintTag, 77);
        sparseIntArray.append(R$styleable.Constraint_visibilityMode, 78);
        sparseIntArray.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        sparseIntArray.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        sparseIntArray.append(R$styleable.Constraint_polarRelativeTo, 82);
        sparseIntArray.append(R$styleable.Constraint_transformPivotTarget, 83);
        sparseIntArray.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        sparseIntArray.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        sparseIntArray.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_orientation, 27);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_visibility, 22);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_alpha, 43);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_elevation, 44);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_rotation, 60);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_translationX, 51);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_translationY, 52);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        sparseIntArray2.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        sparseIntArray2.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        sparseIntArray2.append(R$styleable.ConstraintOverride_drawPath, 66);
        sparseIntArray2.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        sparseIntArray2.append(R$styleable.ConstraintOverride_motionStagger, 79);
        sparseIntArray2.append(R$styleable.ConstraintOverride_android_id, 38);
        sparseIntArray2.append(R$styleable.ConstraintOverride_motionTarget, 98);
        sparseIntArray2.append(R$styleable.ConstraintOverride_motionProgress, 68);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        sparseIntArray2.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        sparseIntArray2.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        sparseIntArray2.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        sparseIntArray2.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        sparseIntArray2.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sparseIntArray2.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        sparseIntArray2.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        sparseIntArray2.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        sparseIntArray2.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        sparseIntArray2.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        sparseIntArray2.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        sparseIntArray2.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static j d(Context context, XmlResourceParser xmlResourceParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        j jVar = new j();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R$styleable.ConstraintOverride);
        o(jVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return jVar;
    }

    public static int[] f(Barrier barrier, String str) {
        int i3;
        String[] split = str.split(Const.STR_MART_COMMA);
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < split.length) {
            String trim = split[i10].trim();
            Object obj = null;
            try {
                i3 = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i3 = 0;
            }
            if (i3 == 0) {
                i3 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i3 == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (trim != null) {
                    HashMap hashMap = constraintLayout.f1867m;
                    if (hashMap != null && hashMap.containsKey(trim)) {
                        obj = constraintLayout.f1867m.get(trim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    i3 = ((Integer) obj).intValue();
                }
            }
            iArr[i11] = i3;
            i10++;
            i11++;
        }
        return i11 != split.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public static j g(Context context, AttributeSet attributeSet, boolean z5) {
        j jVar = new j();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z5 ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        if (z5) {
            o(jVar, obtainStyledAttributes);
        } else {
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i3 = 0;
            while (true) {
                k kVar = jVar.e;
                if (i3 < indexCount) {
                    int index = obtainStyledAttributes.getIndex(i3);
                    int i10 = R$styleable.Constraint_android_id;
                    m mVar = jVar.f19362c;
                    n nVar = jVar.f19364f;
                    l lVar = jVar.f19363d;
                    if (index != i10 && R$styleable.Constraint_android_layout_marginStart != index && R$styleable.Constraint_android_layout_marginEnd != index) {
                        lVar.f19407a = true;
                        kVar.f19370b = true;
                        mVar.f19419a = true;
                        nVar.f19424a = true;
                    }
                    SparseIntArray sparseIntArray = f19438h;
                    switch (sparseIntArray.get(index)) {
                        case 1:
                            kVar.f19396p = l(obtainStyledAttributes, index, kVar.f19396p);
                            break;
                        case 2:
                            kVar.I = obtainStyledAttributes.getDimensionPixelSize(index, kVar.I);
                            break;
                        case 3:
                            kVar.f19394o = l(obtainStyledAttributes, index, kVar.f19394o);
                            break;
                        case 4:
                            kVar.f19392n = l(obtainStyledAttributes, index, kVar.f19392n);
                            break;
                        case 5:
                            kVar.f19404y = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            kVar.C = obtainStyledAttributes.getDimensionPixelOffset(index, kVar.C);
                            break;
                        case 7:
                            kVar.D = obtainStyledAttributes.getDimensionPixelOffset(index, kVar.D);
                            break;
                        case 8:
                            kVar.J = obtainStyledAttributes.getDimensionPixelSize(index, kVar.J);
                            break;
                        case 9:
                            kVar.f19401v = l(obtainStyledAttributes, index, kVar.f19401v);
                            break;
                        case 10:
                            kVar.f19400u = l(obtainStyledAttributes, index, kVar.f19400u);
                            break;
                        case 11:
                            kVar.P = obtainStyledAttributes.getDimensionPixelSize(index, kVar.P);
                            break;
                        case 12:
                            kVar.Q = obtainStyledAttributes.getDimensionPixelSize(index, kVar.Q);
                            break;
                        case 13:
                            kVar.M = obtainStyledAttributes.getDimensionPixelSize(index, kVar.M);
                            break;
                        case 14:
                            kVar.O = obtainStyledAttributes.getDimensionPixelSize(index, kVar.O);
                            break;
                        case 15:
                            kVar.R = obtainStyledAttributes.getDimensionPixelSize(index, kVar.R);
                            break;
                        case 16:
                            kVar.N = obtainStyledAttributes.getDimensionPixelSize(index, kVar.N);
                            break;
                        case 17:
                            kVar.e = obtainStyledAttributes.getDimensionPixelOffset(index, kVar.e);
                            break;
                        case 18:
                            kVar.f19377f = obtainStyledAttributes.getDimensionPixelOffset(index, kVar.f19377f);
                            break;
                        case 19:
                            kVar.f19379g = obtainStyledAttributes.getFloat(index, kVar.f19379g);
                            break;
                        case 20:
                            kVar.f19402w = obtainStyledAttributes.getFloat(index, kVar.f19402w);
                            break;
                        case 21:
                            kVar.f19374d = obtainStyledAttributes.getLayoutDimension(index, kVar.f19374d);
                            break;
                        case 22:
                            int i11 = obtainStyledAttributes.getInt(index, mVar.f19420b);
                            mVar.f19420b = i11;
                            mVar.f19420b = f19437g[i11];
                            break;
                        case 23:
                            kVar.f19372c = obtainStyledAttributes.getLayoutDimension(index, kVar.f19372c);
                            break;
                        case 24:
                            kVar.F = obtainStyledAttributes.getDimensionPixelSize(index, kVar.F);
                            break;
                        case 25:
                            kVar.f19381h = l(obtainStyledAttributes, index, kVar.f19381h);
                            break;
                        case 26:
                            kVar.f19383i = l(obtainStyledAttributes, index, kVar.f19383i);
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                            kVar.E = obtainStyledAttributes.getInt(index, kVar.E);
                            break;
                        case Const.ANDROID_VERSION_28 /* 28 */:
                            kVar.G = obtainStyledAttributes.getDimensionPixelSize(index, kVar.G);
                            break;
                        case Const.ANDROID_VERSION_29 /* 29 */:
                            kVar.f19384j = l(obtainStyledAttributes, index, kVar.f19384j);
                            break;
                        case 30:
                            kVar.f19386k = l(obtainStyledAttributes, index, kVar.f19386k);
                            break;
                        case 31:
                            kVar.K = obtainStyledAttributes.getDimensionPixelSize(index, kVar.K);
                            break;
                        case 32:
                            kVar.f19398s = l(obtainStyledAttributes, index, kVar.f19398s);
                            break;
                        case 33:
                            kVar.f19399t = l(obtainStyledAttributes, index, kVar.f19399t);
                            break;
                        case 34:
                            kVar.H = obtainStyledAttributes.getDimensionPixelSize(index, kVar.H);
                            break;
                        case 35:
                            kVar.f19390m = l(obtainStyledAttributes, index, kVar.f19390m);
                            break;
                        case 36:
                            kVar.f19388l = l(obtainStyledAttributes, index, kVar.f19388l);
                            break;
                        case 37:
                            kVar.f19403x = obtainStyledAttributes.getFloat(index, kVar.f19403x);
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                            jVar.f19360a = obtainStyledAttributes.getResourceId(index, jVar.f19360a);
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                            kVar.U = obtainStyledAttributes.getFloat(index, kVar.U);
                            break;
                        case 40:
                            kVar.T = obtainStyledAttributes.getFloat(index, kVar.T);
                            break;
                        case 41:
                            kVar.V = obtainStyledAttributes.getInt(index, kVar.V);
                            break;
                        case 42:
                            kVar.W = obtainStyledAttributes.getInt(index, kVar.W);
                            break;
                        case 43:
                            mVar.f19422d = obtainStyledAttributes.getFloat(index, mVar.f19422d);
                            break;
                        case 44:
                            nVar.f19435m = true;
                            nVar.f19436n = obtainStyledAttributes.getDimension(index, nVar.f19436n);
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                            nVar.f19426c = obtainStyledAttributes.getFloat(index, nVar.f19426c);
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                            nVar.f19427d = obtainStyledAttributes.getFloat(index, nVar.f19427d);
                            break;
                        case 47:
                            nVar.e = obtainStyledAttributes.getFloat(index, nVar.e);
                            break;
                        case TraceLevel.ABOVE_WARN /* 48 */:
                            nVar.f19428f = obtainStyledAttributes.getFloat(index, nVar.f19428f);
                            break;
                        case 49:
                            nVar.f19429g = obtainStyledAttributes.getDimension(index, nVar.f19429g);
                            break;
                        case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                            nVar.f19430h = obtainStyledAttributes.getDimension(index, nVar.f19430h);
                            break;
                        case 51:
                            nVar.f19432j = obtainStyledAttributes.getDimension(index, nVar.f19432j);
                            break;
                        case 52:
                            nVar.f19433k = obtainStyledAttributes.getDimension(index, nVar.f19433k);
                            break;
                        case 53:
                            nVar.f19434l = obtainStyledAttributes.getDimension(index, nVar.f19434l);
                            break;
                        case 54:
                            kVar.X = obtainStyledAttributes.getInt(index, kVar.X);
                            break;
                        case 55:
                            kVar.Y = obtainStyledAttributes.getInt(index, kVar.Y);
                            break;
                        case 56:
                            kVar.Z = obtainStyledAttributes.getDimensionPixelSize(index, kVar.Z);
                            break;
                        case 57:
                            kVar.f19369a0 = obtainStyledAttributes.getDimensionPixelSize(index, kVar.f19369a0);
                            break;
                        case 58:
                            kVar.f19371b0 = obtainStyledAttributes.getDimensionPixelSize(index, kVar.f19371b0);
                            break;
                        case 59:
                            kVar.f19373c0 = obtainStyledAttributes.getDimensionPixelSize(index, kVar.f19373c0);
                            break;
                        case 60:
                            nVar.f19425b = obtainStyledAttributes.getFloat(index, nVar.f19425b);
                            break;
                        case 61:
                            kVar.f19405z = l(obtainStyledAttributes, index, kVar.f19405z);
                            break;
                        case 62:
                            kVar.A = obtainStyledAttributes.getDimensionPixelSize(index, kVar.A);
                            break;
                        case TraceLevel.ALL /* 63 */:
                            kVar.B = obtainStyledAttributes.getFloat(index, kVar.B);
                            break;
                        case 64:
                            lVar.f19408b = l(obtainStyledAttributes, index, lVar.f19408b);
                            break;
                        case 65:
                            if (obtainStyledAttributes.peekValue(index).type != 3) {
                                lVar.f19410d = p0.e.f17312d[obtainStyledAttributes.getInteger(index, 0)];
                                break;
                            } else {
                                lVar.f19410d = obtainStyledAttributes.getString(index);
                                break;
                            }
                        case 66:
                            lVar.f19411f = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 67:
                            lVar.f19413h = obtainStyledAttributes.getFloat(index, lVar.f19413h);
                            break;
                        case 68:
                            mVar.e = obtainStyledAttributes.getFloat(index, mVar.e);
                            break;
                        case 69:
                            kVar.f19375d0 = obtainStyledAttributes.getFloat(index, 1.0f);
                            break;
                        case 70:
                            kVar.f19376e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                            break;
                        case 71:
                            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                            break;
                        case 72:
                            kVar.f19378f0 = obtainStyledAttributes.getInt(index, kVar.f19378f0);
                            break;
                        case 73:
                            kVar.f19380g0 = obtainStyledAttributes.getDimensionPixelSize(index, kVar.f19380g0);
                            break;
                        case 74:
                            kVar.f19385j0 = obtainStyledAttributes.getString(index);
                            break;
                        case 75:
                            kVar.f19393n0 = obtainStyledAttributes.getBoolean(index, kVar.f19393n0);
                            break;
                        case 76:
                            lVar.e = obtainStyledAttributes.getInt(index, lVar.e);
                            break;
                        case 77:
                            kVar.f19387k0 = obtainStyledAttributes.getString(index);
                            break;
                        case 78:
                            mVar.f19421c = obtainStyledAttributes.getInt(index, mVar.f19421c);
                            break;
                        case 79:
                            lVar.f19412g = obtainStyledAttributes.getFloat(index, lVar.f19412g);
                            break;
                        case 80:
                            kVar.f19389l0 = obtainStyledAttributes.getBoolean(index, kVar.f19389l0);
                            break;
                        case 81:
                            kVar.f19391m0 = obtainStyledAttributes.getBoolean(index, kVar.f19391m0);
                            break;
                        case 82:
                            lVar.f19409c = obtainStyledAttributes.getInteger(index, lVar.f19409c);
                            break;
                        case 83:
                            nVar.f19431i = l(obtainStyledAttributes, index, nVar.f19431i);
                            break;
                        case 84:
                            lVar.f19415j = obtainStyledAttributes.getInteger(index, lVar.f19415j);
                            break;
                        case 85:
                            lVar.f19414i = obtainStyledAttributes.getFloat(index, lVar.f19414i);
                            break;
                        case 86:
                            int i12 = obtainStyledAttributes.peekValue(index).type;
                            if (i12 != 1) {
                                if (i12 != 3) {
                                    lVar.f19417l = obtainStyledAttributes.getInteger(index, lVar.f19418m);
                                    break;
                                } else {
                                    String string = obtainStyledAttributes.getString(index);
                                    lVar.f19416k = string;
                                    if (string.indexOf("/") <= 0) {
                                        lVar.f19417l = -1;
                                        break;
                                    } else {
                                        lVar.f19418m = obtainStyledAttributes.getResourceId(index, -1);
                                        lVar.f19417l = -2;
                                        break;
                                    }
                                }
                            } else {
                                int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                                lVar.f19418m = resourceId;
                                if (resourceId == -1) {
                                    break;
                                } else {
                                    lVar.f19417l = -2;
                                    break;
                                }
                            }
                        case 87:
                            String hexString = Integer.toHexString(index);
                            int i13 = sparseIntArray.get(index);
                            StringBuilder sb2 = new StringBuilder(r5.a.a(33, hexString));
                            sb2.append("unused attribute 0x");
                            sb2.append(hexString);
                            sb2.append("   ");
                            sb2.append(i13);
                            Log.w("ConstraintSet", sb2.toString());
                            break;
                        case 88:
                        case 89:
                        case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                        default:
                            String hexString2 = Integer.toHexString(index);
                            int i14 = sparseIntArray.get(index);
                            StringBuilder sb3 = new StringBuilder(r5.a.a(34, hexString2));
                            sb3.append("Unknown attribute 0x");
                            sb3.append(hexString2);
                            sb3.append("   ");
                            sb3.append(i14);
                            Log.w("ConstraintSet", sb3.toString());
                            break;
                        case 91:
                            kVar.f19397q = l(obtainStyledAttributes, index, kVar.f19397q);
                            break;
                        case 92:
                            kVar.r = l(obtainStyledAttributes, index, kVar.r);
                            break;
                        case 93:
                            kVar.L = obtainStyledAttributes.getDimensionPixelSize(index, kVar.L);
                            break;
                        case 94:
                            kVar.S = obtainStyledAttributes.getDimensionPixelSize(index, kVar.S);
                            break;
                        case 95:
                            m(kVar, obtainStyledAttributes, index, 0);
                            break;
                        case 96:
                            m(kVar, obtainStyledAttributes, index, 1);
                            break;
                        case 97:
                            kVar.f19395o0 = obtainStyledAttributes.getInt(index, kVar.f19395o0);
                            break;
                    }
                    i3++;
                } else if (kVar.f19385j0 != null) {
                    kVar.i0 = null;
                }
            }
        }
        obtainStyledAttributes.recycle();
        return jVar;
    }

    public static int l(TypedArray typedArray, int i3, int i10) {
        int resourceId = typedArray.getResourceId(i3, i10);
        return resourceId == -1 ? typedArray.getInt(i3, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.o.m(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void n(e eVar, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i3 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                i3 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
                r2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(r2);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(r2, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i3 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        eVar.F = str;
    }

    public static void o(j jVar, TypedArray typedArray) {
        char c9;
        int indexCount = typedArray.getIndexCount();
        i iVar = new i();
        iVar.f19349a = new int[10];
        iVar.f19350b = new int[10];
        iVar.f19351c = 0;
        iVar.f19352d = new int[10];
        iVar.e = new float[10];
        iVar.f19353f = 0;
        iVar.f19354g = new int[5];
        iVar.f19355h = new String[5];
        iVar.f19356i = 0;
        iVar.f19357j = new int[4];
        iVar.f19358k = new boolean[4];
        iVar.f19359l = 0;
        jVar.f19366h = iVar;
        l lVar = jVar.f19363d;
        lVar.f19407a = false;
        k kVar = jVar.e;
        kVar.f19370b = false;
        m mVar = jVar.f19362c;
        mVar.f19419a = false;
        n nVar = jVar.f19364f;
        nVar.f19424a = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            int i10 = f19439i.get(index);
            SparseIntArray sparseIntArray = f19438h;
            switch (i10) {
                case 2:
                    c9 = 5;
                    iVar.b(2, typedArray.getDimensionPixelSize(index, kVar.I));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case Const.ANDROID_VERSION_29 /* 29 */:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                case 91:
                case 92:
                default:
                    String hexString = Integer.toHexString(index);
                    int i11 = sparseIntArray.get(index);
                    StringBuilder sb2 = new StringBuilder(r5.a.a(34, hexString));
                    sb2.append("Unknown attribute 0x");
                    sb2.append(hexString);
                    sb2.append("   ");
                    sb2.append(i11);
                    Log.w("ConstraintSet", sb2.toString());
                    c9 = 5;
                    break;
                case 5:
                    c9 = 5;
                    iVar.c(5, typedArray.getString(index));
                    break;
                case 6:
                    iVar.b(6, typedArray.getDimensionPixelOffset(index, kVar.C));
                    c9 = 5;
                    break;
                case 7:
                    iVar.b(7, typedArray.getDimensionPixelOffset(index, kVar.D));
                    c9 = 5;
                    break;
                case 8:
                    iVar.b(8, typedArray.getDimensionPixelSize(index, kVar.J));
                    c9 = 5;
                    break;
                case 11:
                    iVar.b(11, typedArray.getDimensionPixelSize(index, kVar.P));
                    c9 = 5;
                    break;
                case 12:
                    iVar.b(12, typedArray.getDimensionPixelSize(index, kVar.Q));
                    c9 = 5;
                    break;
                case 13:
                    iVar.b(13, typedArray.getDimensionPixelSize(index, kVar.M));
                    c9 = 5;
                    break;
                case 14:
                    iVar.b(14, typedArray.getDimensionPixelSize(index, kVar.O));
                    c9 = 5;
                    break;
                case 15:
                    iVar.b(15, typedArray.getDimensionPixelSize(index, kVar.R));
                    c9 = 5;
                    break;
                case 16:
                    iVar.b(16, typedArray.getDimensionPixelSize(index, kVar.N));
                    c9 = 5;
                    break;
                case 17:
                    iVar.b(17, typedArray.getDimensionPixelOffset(index, kVar.e));
                    c9 = 5;
                    break;
                case 18:
                    iVar.b(18, typedArray.getDimensionPixelOffset(index, kVar.f19377f));
                    c9 = 5;
                    break;
                case 19:
                    iVar.a(typedArray.getFloat(index, kVar.f19379g), 19);
                    c9 = 5;
                    break;
                case 20:
                    iVar.a(typedArray.getFloat(index, kVar.f19402w), 20);
                    c9 = 5;
                    break;
                case 21:
                    iVar.b(21, typedArray.getLayoutDimension(index, kVar.f19374d));
                    c9 = 5;
                    break;
                case 22:
                    iVar.b(22, f19437g[typedArray.getInt(index, mVar.f19420b)]);
                    c9 = 5;
                    break;
                case 23:
                    iVar.b(23, typedArray.getLayoutDimension(index, kVar.f19372c));
                    c9 = 5;
                    break;
                case 24:
                    iVar.b(24, typedArray.getDimensionPixelSize(index, kVar.F));
                    c9 = 5;
                    break;
                case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                    iVar.b(27, typedArray.getInt(index, kVar.E));
                    c9 = 5;
                    break;
                case Const.ANDROID_VERSION_28 /* 28 */:
                    iVar.b(28, typedArray.getDimensionPixelSize(index, kVar.G));
                    c9 = 5;
                    break;
                case 31:
                    iVar.b(31, typedArray.getDimensionPixelSize(index, kVar.K));
                    c9 = 5;
                    break;
                case 34:
                    iVar.b(34, typedArray.getDimensionPixelSize(index, kVar.H));
                    c9 = 5;
                    break;
                case 37:
                    iVar.a(typedArray.getFloat(index, kVar.f19403x), 37);
                    c9 = 5;
                    break;
                case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                    int resourceId = typedArray.getResourceId(index, jVar.f19360a);
                    jVar.f19360a = resourceId;
                    iVar.b(38, resourceId);
                    c9 = 5;
                    break;
                case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                    iVar.a(typedArray.getFloat(index, kVar.U), 39);
                    c9 = 5;
                    break;
                case 40:
                    iVar.a(typedArray.getFloat(index, kVar.T), 40);
                    c9 = 5;
                    break;
                case 41:
                    iVar.b(41, typedArray.getInt(index, kVar.V));
                    c9 = 5;
                    break;
                case 42:
                    iVar.b(42, typedArray.getInt(index, kVar.W));
                    c9 = 5;
                    break;
                case 43:
                    iVar.a(typedArray.getFloat(index, mVar.f19422d), 43);
                    c9 = 5;
                    break;
                case 44:
                    iVar.d(44, true);
                    iVar.a(typedArray.getDimension(index, nVar.f19436n), 44);
                    c9 = 5;
                    break;
                case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                    iVar.a(typedArray.getFloat(index, nVar.f19426c), 45);
                    c9 = 5;
                    break;
                case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                    iVar.a(typedArray.getFloat(index, nVar.f19427d), 46);
                    c9 = 5;
                    break;
                case 47:
                    iVar.a(typedArray.getFloat(index, nVar.e), 47);
                    c9 = 5;
                    break;
                case TraceLevel.ABOVE_WARN /* 48 */:
                    iVar.a(typedArray.getFloat(index, nVar.f19428f), 48);
                    c9 = 5;
                    break;
                case 49:
                    iVar.a(typedArray.getDimension(index, nVar.f19429g), 49);
                    c9 = 5;
                    break;
                case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                    iVar.a(typedArray.getDimension(index, nVar.f19430h), 50);
                    c9 = 5;
                    break;
                case 51:
                    iVar.a(typedArray.getDimension(index, nVar.f19432j), 51);
                    c9 = 5;
                    break;
                case 52:
                    iVar.a(typedArray.getDimension(index, nVar.f19433k), 52);
                    c9 = 5;
                    break;
                case 53:
                    iVar.a(typedArray.getDimension(index, nVar.f19434l), 53);
                    c9 = 5;
                    break;
                case 54:
                    iVar.b(54, typedArray.getInt(index, kVar.X));
                    c9 = 5;
                    break;
                case 55:
                    iVar.b(55, typedArray.getInt(index, kVar.Y));
                    c9 = 5;
                    break;
                case 56:
                    iVar.b(56, typedArray.getDimensionPixelSize(index, kVar.Z));
                    c9 = 5;
                    break;
                case 57:
                    iVar.b(57, typedArray.getDimensionPixelSize(index, kVar.f19369a0));
                    c9 = 5;
                    break;
                case 58:
                    iVar.b(58, typedArray.getDimensionPixelSize(index, kVar.f19371b0));
                    c9 = 5;
                    break;
                case 59:
                    iVar.b(59, typedArray.getDimensionPixelSize(index, kVar.f19373c0));
                    c9 = 5;
                    break;
                case 60:
                    iVar.a(typedArray.getFloat(index, nVar.f19425b), 60);
                    c9 = 5;
                    break;
                case 62:
                    iVar.b(62, typedArray.getDimensionPixelSize(index, kVar.A));
                    c9 = 5;
                    break;
                case TraceLevel.ALL /* 63 */:
                    iVar.a(typedArray.getFloat(index, kVar.B), 63);
                    c9 = 5;
                    break;
                case 64:
                    iVar.b(64, l(typedArray, index, lVar.f19408b));
                    c9 = 5;
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        iVar.c(65, typedArray.getString(index));
                    } else {
                        iVar.c(65, p0.e.f17312d[typedArray.getInteger(index, 0)]);
                    }
                    c9 = 5;
                    break;
                case 66:
                    iVar.b(66, typedArray.getInt(index, 0));
                    c9 = 5;
                    break;
                case 67:
                    iVar.a(typedArray.getFloat(index, lVar.f19413h), 67);
                    c9 = 5;
                    break;
                case 68:
                    iVar.a(typedArray.getFloat(index, mVar.e), 68);
                    c9 = 5;
                    break;
                case 69:
                    iVar.a(typedArray.getFloat(index, 1.0f), 69);
                    c9 = 5;
                    break;
                case 70:
                    iVar.a(typedArray.getFloat(index, 1.0f), 70);
                    c9 = 5;
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    c9 = 5;
                    break;
                case 72:
                    iVar.b(72, typedArray.getInt(index, kVar.f19378f0));
                    c9 = 5;
                    break;
                case 73:
                    iVar.b(73, typedArray.getDimensionPixelSize(index, kVar.f19380g0));
                    c9 = 5;
                    break;
                case 74:
                    iVar.c(74, typedArray.getString(index));
                    c9 = 5;
                    break;
                case 75:
                    iVar.d(75, typedArray.getBoolean(index, kVar.f19393n0));
                    c9 = 5;
                    break;
                case 76:
                    iVar.b(76, typedArray.getInt(index, lVar.e));
                    c9 = 5;
                    break;
                case 77:
                    iVar.c(77, typedArray.getString(index));
                    c9 = 5;
                    break;
                case 78:
                    iVar.b(78, typedArray.getInt(index, mVar.f19421c));
                    c9 = 5;
                    break;
                case 79:
                    iVar.a(typedArray.getFloat(index, lVar.f19412g), 79);
                    c9 = 5;
                    break;
                case 80:
                    iVar.d(80, typedArray.getBoolean(index, kVar.f19389l0));
                    c9 = 5;
                    break;
                case 81:
                    iVar.d(81, typedArray.getBoolean(index, kVar.f19391m0));
                    c9 = 5;
                    break;
                case 82:
                    iVar.b(82, typedArray.getInteger(index, lVar.f19409c));
                    c9 = 5;
                    break;
                case 83:
                    iVar.b(83, l(typedArray, index, nVar.f19431i));
                    c9 = 5;
                    break;
                case 84:
                    iVar.b(84, typedArray.getInteger(index, lVar.f19415j));
                    c9 = 5;
                    break;
                case 85:
                    iVar.a(typedArray.getFloat(index, lVar.f19414i), 85);
                    c9 = 5;
                    break;
                case 86:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        int resourceId2 = typedArray.getResourceId(index, -1);
                        lVar.f19418m = resourceId2;
                        iVar.b(89, resourceId2);
                        if (lVar.f19418m != -1) {
                            lVar.f19417l = -2;
                            iVar.b(88, -2);
                        }
                    } else if (i12 == 3) {
                        String string = typedArray.getString(index);
                        lVar.f19416k = string;
                        iVar.c(90, string);
                        if (lVar.f19416k.indexOf("/") > 0) {
                            int resourceId3 = typedArray.getResourceId(index, -1);
                            lVar.f19418m = resourceId3;
                            iVar.b(89, resourceId3);
                            lVar.f19417l = -2;
                            iVar.b(88, -2);
                        } else {
                            lVar.f19417l = -1;
                            iVar.b(88, -1);
                        }
                    } else {
                        int integer = typedArray.getInteger(index, lVar.f19418m);
                        lVar.f19417l = integer;
                        iVar.b(88, integer);
                    }
                    c9 = 5;
                    break;
                case 87:
                    String hexString2 = Integer.toHexString(index);
                    int i13 = sparseIntArray.get(index);
                    StringBuilder sb3 = new StringBuilder(r5.a.a(33, hexString2));
                    sb3.append("unused attribute 0x");
                    sb3.append(hexString2);
                    sb3.append("   ");
                    sb3.append(i13);
                    Log.w("ConstraintSet", sb3.toString());
                    c9 = 5;
                    break;
                case 93:
                    iVar.b(93, typedArray.getDimensionPixelSize(index, kVar.L));
                    c9 = 5;
                    break;
                case 94:
                    iVar.b(94, typedArray.getDimensionPixelSize(index, kVar.S));
                    c9 = 5;
                    break;
                case 95:
                    m(iVar, typedArray, index, 0);
                    c9 = 5;
                    break;
                case 96:
                    m(iVar, typedArray, index, 1);
                    c9 = 5;
                    break;
                case 97:
                    iVar.b(97, typedArray.getInt(index, kVar.f19395o0));
                    c9 = 5;
                    break;
                case 98:
                    if (MotionLayout.f1692q1) {
                        int resourceId4 = typedArray.getResourceId(index, jVar.f19360a);
                        jVar.f19360a = resourceId4;
                        if (resourceId4 == -1) {
                            jVar.f19361b = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        jVar.f19361b = typedArray.getString(index);
                    } else {
                        jVar.f19360a = typedArray.getResourceId(index, jVar.f19360a);
                    }
                    c9 = 5;
                    break;
            }
        }
    }

    public final void a(MotionLayout motionLayout) {
        j jVar;
        int childCount = motionLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = motionLayout.getChildAt(i3);
            int id2 = childAt.getId();
            HashMap hashMap = this.f19444f;
            if (!hashMap.containsKey(Integer.valueOf(id2))) {
                String valueOf = String.valueOf(g0.d(childAt));
                Log.w("ConstraintSet", valueOf.length() != 0 ? "id unknown ".concat(valueOf) : new String("id unknown "));
            } else {
                if (this.e && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (hashMap.containsKey(Integer.valueOf(id2)) && (jVar = (j) hashMap.get(Integer.valueOf(id2))) != null) {
                    b.f(childAt, jVar.f19365g);
                }
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        c(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public final void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = this.f19444f;
        HashSet hashSet = new HashSet(hashMap.keySet());
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            int id2 = childAt.getId();
            if (!hashMap.containsKey(Integer.valueOf(id2))) {
                String valueOf = String.valueOf(g0.d(childAt));
                Log.w("ConstraintSet", valueOf.length() != 0 ? "id unknown ".concat(valueOf) : new String("id unknown "));
            } else {
                if (this.e && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (hashMap.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        j jVar = (j) hashMap.get(Integer.valueOf(id2));
                        if (jVar != null) {
                            if (childAt instanceof Barrier) {
                                k kVar = jVar.e;
                                kVar.f19382h0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id2);
                                barrier.setType(kVar.f19378f0);
                                barrier.setMargin(kVar.f19380g0);
                                barrier.setAllowsGoneWidget(kVar.f19393n0);
                                int[] iArr = kVar.i0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = kVar.f19385j0;
                                    if (str != null) {
                                        int[] f2 = f(barrier, str);
                                        kVar.i0 = f2;
                                        barrier.setReferencedIds(f2);
                                    }
                                }
                            }
                            e eVar = (e) childAt.getLayoutParams();
                            eVar.a();
                            jVar.a(eVar);
                            b.f(childAt, jVar.f19365g);
                            childAt.setLayoutParams(eVar);
                            m mVar = jVar.f19362c;
                            if (mVar.f19421c == 0) {
                                childAt.setVisibility(mVar.f19420b);
                            }
                            childAt.setAlpha(mVar.f19422d);
                            n nVar = jVar.f19364f;
                            childAt.setRotation(nVar.f19425b);
                            childAt.setRotationX(nVar.f19426c);
                            childAt.setRotationY(nVar.f19427d);
                            childAt.setScaleX(nVar.e);
                            childAt.setScaleY(nVar.f19428f);
                            if (nVar.f19431i != -1) {
                                if (((View) childAt.getParent()).findViewById(nVar.f19431i) != null) {
                                    float bottom = (r8.getBottom() + r8.getTop()) / 2.0f;
                                    float right = (r8.getRight() + r8.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(nVar.f19429g)) {
                                    childAt.setPivotX(nVar.f19429g);
                                }
                                if (!Float.isNaN(nVar.f19430h)) {
                                    childAt.setPivotY(nVar.f19430h);
                                }
                            }
                            childAt.setTranslationX(nVar.f19432j);
                            childAt.setTranslationY(nVar.f19433k);
                            childAt.setTranslationZ(nVar.f19434l);
                            if (nVar.f19435m) {
                                childAt.setElevation(nVar.f19436n);
                            }
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder(43);
                        sb2.append("WARNING NO CONSTRAINTS for view ");
                        sb2.append(id2);
                        Log.v("ConstraintSet", sb2.toString());
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            j jVar2 = (j) hashMap.get(num);
            if (jVar2 != null) {
                k kVar2 = jVar2.e;
                if (kVar2.f19382h0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    int[] iArr2 = kVar2.i0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = kVar2.f19385j0;
                        if (str2 != null) {
                            int[] f10 = f(barrier2, str2);
                            kVar2.i0 = f10;
                            barrier2.setReferencedIds(f10);
                        }
                    }
                    barrier2.setType(kVar2.f19378f0);
                    barrier2.setMargin(kVar2.f19380g0);
                    s sVar = ConstraintLayout.r;
                    e eVar2 = new e();
                    barrier2.q();
                    jVar2.a(eVar2);
                    constraintLayout.addView(barrier2, eVar2);
                }
                if (kVar2.f19368a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    s sVar2 = ConstraintLayout.r;
                    e eVar3 = new e();
                    jVar2.a(eVar3);
                    constraintLayout.addView(guideline, eVar3);
                }
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = constraintLayout.getChildAt(i10);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).g(constraintLayout);
            }
        }
    }

    public final void e(ConstraintLayout constraintLayout) {
        o oVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = oVar.f19444f;
        hashMap.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (oVar.e && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id2))) {
                hashMap.put(Integer.valueOf(id2), new j());
            }
            j jVar = (j) hashMap.get(Integer.valueOf(id2));
            if (jVar != null) {
                HashMap hashMap2 = oVar.f19443d;
                HashMap hashMap3 = new HashMap();
                Class<?> cls = childAt.getClass();
                for (String str : hashMap2.keySet()) {
                    b bVar = (b) hashMap2.get(str);
                    try {
                        if (str.equals("BackgroundColor")) {
                            hashMap3.put(str, new b(bVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        } else {
                            hashMap3.put(str, new b(bVar, cls.getMethod(str.length() != 0 ? "getMap".concat(str) : new String("getMap"), null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e10) {
                        e10.printStackTrace();
                    } catch (InvocationTargetException e11) {
                        e11.printStackTrace();
                    }
                }
                jVar.f19365g = hashMap3;
                jVar.c(id2, eVar);
                int visibility = childAt.getVisibility();
                m mVar = jVar.f19362c;
                mVar.f19420b = visibility;
                mVar.f19422d = childAt.getAlpha();
                float rotation = childAt.getRotation();
                n nVar = jVar.f19364f;
                nVar.f19425b = rotation;
                nVar.f19426c = childAt.getRotationX();
                nVar.f19427d = childAt.getRotationY();
                nVar.e = childAt.getScaleX();
                nVar.f19428f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    nVar.f19429g = pivotX;
                    nVar.f19430h = pivotY;
                }
                nVar.f19432j = childAt.getTranslationX();
                nVar.f19433k = childAt.getTranslationY();
                nVar.f19434l = childAt.getTranslationZ();
                if (nVar.f19435m) {
                    nVar.f19436n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
                    k kVar = jVar.e;
                    kVar.f19393n0 = allowsGoneWidget;
                    kVar.i0 = barrier.getReferencedIds();
                    kVar.f19378f0 = barrier.getType();
                    kVar.f19380g0 = barrier.getMargin();
                }
            }
            i3++;
            oVar = this;
        }
    }

    public final j h(int i3) {
        HashMap hashMap = this.f19444f;
        if (!hashMap.containsKey(Integer.valueOf(i3))) {
            hashMap.put(Integer.valueOf(i3), new j());
        }
        return (j) hashMap.get(Integer.valueOf(i3));
    }

    public final j i(int i3) {
        HashMap hashMap = this.f19444f;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return (j) hashMap.get(Integer.valueOf(i3));
        }
        return null;
    }

    public final void j(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    j g10 = g(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        g10.e.f19368a = true;
                    }
                    this.f19444f.put(Integer.valueOf(g10.f19360a), g10);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d0, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.o.k(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
