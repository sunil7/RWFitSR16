package k9;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f15535i = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f15536j = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* renamed from: k, reason: collision with root package name */
    public static final float[] f15537k = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f15538l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: m, reason: collision with root package name */
    public static final float[] f15539m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public int f15540a;

    /* renamed from: b, reason: collision with root package name */
    public i9.f f15541b;

    /* renamed from: c, reason: collision with root package name */
    public int f15542c;

    /* renamed from: d, reason: collision with root package name */
    public int f15543d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f15544f;

    /* renamed from: g, reason: collision with root package name */
    public int f15545g;

    /* renamed from: h, reason: collision with root package name */
    public int f15546h;
}
