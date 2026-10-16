package com.otaliastudios.cameraview.gesture;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NONE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class GestureAction {
    public static final GestureAction AUTO_FOCUS;
    static final GestureAction DEFAULT_LONG_TAP;
    static final GestureAction DEFAULT_PINCH;
    static final GestureAction DEFAULT_SCROLL_HORIZONTAL;
    static final GestureAction DEFAULT_SCROLL_VERTICAL;
    static final GestureAction DEFAULT_TAP;
    public static final GestureAction EXPOSURE_CORRECTION;
    public static final GestureAction FILTER_CONTROL_1;
    public static final GestureAction FILTER_CONTROL_2;
    public static final GestureAction NONE;
    public static final GestureAction TAKE_PICTURE;
    public static final GestureAction TAKE_PICTURE_SNAPSHOT;
    public static final GestureAction ZOOM;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GestureAction[] f11593a;
    private GestureType type;
    private int value;

    static {
        GestureType gestureType = GestureType.ONE_SHOT;
        GestureAction gestureAction = new GestureAction("NONE", 0, 0, gestureType);
        NONE = gestureAction;
        GestureAction gestureAction2 = new GestureAction("AUTO_FOCUS", 1, 1, gestureType);
        AUTO_FOCUS = gestureAction2;
        GestureAction gestureAction3 = new GestureAction("TAKE_PICTURE", 2, 2, gestureType);
        TAKE_PICTURE = gestureAction3;
        GestureAction gestureAction4 = new GestureAction("TAKE_PICTURE_SNAPSHOT", 3, 3, gestureType);
        TAKE_PICTURE_SNAPSHOT = gestureAction4;
        GestureType gestureType2 = GestureType.CONTINUOUS;
        GestureAction gestureAction5 = new GestureAction("ZOOM", 4, 4, gestureType2);
        ZOOM = gestureAction5;
        GestureAction gestureAction6 = new GestureAction("EXPOSURE_CORRECTION", 5, 5, gestureType2);
        EXPOSURE_CORRECTION = gestureAction6;
        GestureAction gestureAction7 = new GestureAction("FILTER_CONTROL_1", 6, 6, gestureType2);
        FILTER_CONTROL_1 = gestureAction7;
        GestureAction gestureAction8 = new GestureAction("FILTER_CONTROL_2", 7, 7, gestureType2);
        FILTER_CONTROL_2 = gestureAction8;
        f11593a = new GestureAction[]{gestureAction, gestureAction2, gestureAction3, gestureAction4, gestureAction5, gestureAction6, gestureAction7, gestureAction8};
        DEFAULT_PINCH = gestureAction;
        DEFAULT_TAP = gestureAction;
        DEFAULT_LONG_TAP = gestureAction;
        DEFAULT_SCROLL_HORIZONTAL = gestureAction;
        DEFAULT_SCROLL_VERTICAL = gestureAction;
    }

    public GestureAction(String str, int i3, int i10, GestureType gestureType) {
        this.value = i10;
        this.type = gestureType;
    }

    public static GestureAction fromValue(int i3) {
        for (GestureAction gestureAction : values()) {
            if (gestureAction.value() == i3) {
                return gestureAction;
            }
        }
        return null;
    }

    public static GestureAction valueOf(String str) {
        return (GestureAction) Enum.valueOf(GestureAction.class, str);
    }

    public static GestureAction[] values() {
        return (GestureAction[]) f11593a.clone();
    }

    public GestureType type() {
        return this.type;
    }

    public int value() {
        return this.value;
    }
}
