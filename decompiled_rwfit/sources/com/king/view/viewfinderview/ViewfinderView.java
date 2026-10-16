package com.king.view.viewfinderview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewfinderView extends View {
    private static final float DEFAULT_RANGE_RATIO = 1.2f;
    private static final float MAX_ZOOM_RATIO = 1.2f;
    private static final int POINT_ANIMATION_INTERVAL = 3000;
    private float currentZoomRatio;
    private Rect frame;
    private Bitmap frameBitmap;
    private int frameColor;
    private int frameCornerColor;
    private int frameCornerSize;
    private int frameCornerStrokeWidth;
    private FrameGravity frameGravity;
    private int frameHeight;
    private int frameLineStrokeWidth;
    private float framePaddingBottom;
    private float framePaddingLeft;
    private float framePaddingRight;
    private float framePaddingTop;
    private float frameRatio;
    private int frameWidth;
    private GestureDetector gestureDetector;
    private boolean isPointAnimation;
    private boolean isShowPoints;
    private String labelText;
    private int labelTextColor;
    private TextLocation labelTextLocation;
    private float labelTextPadding;
    private float labelTextSize;
    private int labelTextWidth;
    private int laserAnimationInterval;
    private Bitmap laserBitmap;
    private float laserBitmapRatio;
    private float laserBitmapWidth;
    private int laserColor;
    private int laserGridColumn;
    private int laserGridHeight;
    private int laserLineHeight;
    private int laserMovementSpeed;
    private LaserStyle laserStyle;
    private float lastZoomRatio;
    private int maskColor;
    private int minDimension;
    private OnItemClickListener onItemClickListener;
    private Paint paint;
    private int pointAnimationInterval;
    private Bitmap pointBitmap;
    private int pointColor;
    private List<Point> pointList;
    private float pointRadius;
    private float pointRangeRadius;
    private int pointStrokeColor;
    private float pointStrokeRadius;
    private float pointStrokeRatio;
    private int scannerEnd;
    private int scannerStart;
    private TextPaint textPaint;
    private int viewfinderStyle;
    private int zoomCount;
    private float zoomSpeed;

    /* renamed from: com.king.view.viewfinderview.ViewfinderView$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$king$view$viewfinderview$ViewfinderView$FrameGravity;
        static final /* synthetic */ int[] $SwitchMap$com$king$view$viewfinderview$ViewfinderView$LaserStyle;

        static {
            int[] iArr = new int[LaserStyle.values().length];
            $SwitchMap$com$king$view$viewfinderview$ViewfinderView$LaserStyle = iArr;
            try {
                iArr[LaserStyle.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$king$view$viewfinderview$ViewfinderView$LaserStyle[LaserStyle.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$king$view$viewfinderview$ViewfinderView$LaserStyle[LaserStyle.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[FrameGravity.values().length];
            $SwitchMap$com$king$view$viewfinderview$ViewfinderView$FrameGravity = iArr2;
            try {
                iArr2[FrameGravity.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$king$view$viewfinderview$ViewfinderView$FrameGravity[FrameGravity.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$king$view$viewfinderview$ViewfinderView$FrameGravity[FrameGravity.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$king$view$viewfinderview$ViewfinderView$FrameGravity[FrameGravity.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum FrameGravity {
        CENTER(0),
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);

        private final int mValue;

        FrameGravity(int i3) {
            this.mValue = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static FrameGravity getFromInt(int i3) {
            for (FrameGravity frameGravity : values()) {
                if (frameGravity.mValue == i3) {
                    return frameGravity;
                }
            }
            return CENTER;
        }
    }

    public enum LaserStyle {
        NONE(0),
        LINE(1),
        GRID(2),
        IMAGE(3);

        private final int mValue;

        LaserStyle(int i3) {
            this.mValue = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static LaserStyle getFromInt(int i3) {
            for (LaserStyle laserStyle : values()) {
                if (laserStyle.mValue == i3) {
                    return laserStyle;
                }
            }
            return LINE;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int i3);
    }

    public enum TextLocation {
        TOP(0),
        BOTTOM(1);

        private final int mValue;

        TextLocation(int i3) {
            this.mValue = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static TextLocation getFromInt(int i3) {
            for (TextLocation textLocation : values()) {
                if (textLocation.mValue == i3) {
                    return textLocation;
                }
            }
            return TOP;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewfinderStyle {
        public static final int CLASSIC = 0;
        public static final int POPULAR = 1;
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    private void calcPointZoomAnimation() {
        float f2 = this.currentZoomRatio;
        if (f2 <= 1.0f) {
            this.lastZoomRatio = f2;
            this.currentZoomRatio = f2 + this.zoomSpeed;
            int i3 = this.zoomCount;
            if (i3 < 2) {
                this.zoomCount = i3 + 1;
            } else {
                this.zoomCount = 0;
            }
        } else if (f2 >= 1.2f) {
            this.lastZoomRatio = f2;
            this.currentZoomRatio = f2 - this.zoomSpeed;
        } else if (this.lastZoomRatio > f2) {
            this.lastZoomRatio = f2;
            this.currentZoomRatio = f2 - this.zoomSpeed;
        } else {
            this.lastZoomRatio = f2;
            this.currentZoomRatio = f2 + this.zoomSpeed;
        }
        postInvalidateDelayed((this.zoomCount == 0 && this.lastZoomRatio == 1.0f) ? this.pointAnimationInterval : this.laserAnimationInterval * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSingleTap(float f2, float f10) {
        if (this.pointList != null) {
            for (int i3 = 0; i3 < this.pointList.size(); i3++) {
                Point point = this.pointList.get(i3);
                if (getDistance(f2, f10, point.x, point.y) <= this.pointRangeRadius) {
                    OnItemClickListener onItemClickListener = this.onItemClickListener;
                    if (onItemClickListener == null) {
                        return true;
                    }
                    onItemClickListener.onItemClick(i3);
                    return true;
                }
            }
        }
        return false;
    }

    private void drawCorner(Canvas canvas, Rect rect) {
        this.paint.setColor(this.frameCornerColor);
        canvas.drawRect(rect.left, rect.top, r0 + this.frameCornerStrokeWidth, r1 + this.frameCornerSize, this.paint);
        canvas.drawRect(rect.left, rect.top, r14 + this.frameCornerSize, r0 + this.frameCornerStrokeWidth, this.paint);
        int i3 = rect.right;
        canvas.drawRect(i3 - this.frameCornerStrokeWidth, rect.top, i3, r0 + this.frameCornerSize, this.paint);
        int i10 = rect.right;
        canvas.drawRect(i10 - this.frameCornerSize, rect.top, i10, r0 + this.frameCornerStrokeWidth, this.paint);
        canvas.drawRect(rect.left, r0 - this.frameCornerStrokeWidth, r14 + this.frameCornerSize, rect.bottom, this.paint);
        canvas.drawRect(rect.left, r0 - this.frameCornerSize, r14 + this.frameCornerStrokeWidth, rect.bottom, this.paint);
        int i11 = rect.right;
        canvas.drawRect(i11 - this.frameCornerStrokeWidth, r0 - this.frameCornerSize, i11, rect.bottom, this.paint);
        int i12 = rect.right;
        canvas.drawRect(i12 - this.frameCornerSize, r15 - this.frameCornerStrokeWidth, i12, rect.bottom, this.paint);
    }

    private void drawExterior(Canvas canvas, Rect rect, int i3, int i10) {
        int i11 = this.maskColor;
        if (i11 != 0) {
            this.paint.setColor(i11);
            float f2 = i3;
            canvas.drawRect(0.0f, 0.0f, f2, rect.top, this.paint);
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.paint);
            canvas.drawRect(rect.right, rect.top, f2, rect.bottom, this.paint);
            canvas.drawRect(0.0f, rect.bottom, f2, i10, this.paint);
        }
    }

    private void drawFrame(Canvas canvas, Rect rect) {
        this.paint.setColor(this.frameColor);
        Bitmap bitmap = this.frameBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.paint);
            return;
        }
        canvas.drawRect(rect.left, rect.top, rect.right, r0 + this.frameLineStrokeWidth, this.paint);
        canvas.drawRect(rect.left, rect.top, r14 + this.frameLineStrokeWidth, rect.bottom, this.paint);
        canvas.drawRect(r14 - this.frameLineStrokeWidth, rect.top, rect.right, rect.bottom, this.paint);
        canvas.drawRect(rect.left, r14 - this.frameLineStrokeWidth, rect.right, rect.bottom, this.paint);
        drawCorner(canvas, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0089 A[LOOP:1: B:16:0x0082->B:18:0x0089, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9 A[EDGE_INSN: B:19:0x00a9->B:20:0x00a9 BREAK  A[LOOP:1: B:16:0x0082->B:18:0x0089], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0058 A[LOOP:0: B:7:0x0054->B:9:0x0058, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawGridScanner(android.graphics.Canvas r21, android.graphics.Rect r22) {
        /*
            Method dump skipped, instructions count: 194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.view.viewfinderview.ViewfinderView.drawGridScanner(android.graphics.Canvas, android.graphics.Rect):void");
    }

    private void drawImageScanner(Canvas canvas, Rect rect) {
        Bitmap bitmap = this.laserBitmap;
        if (bitmap == null) {
            drawLineScanner(canvas, rect);
            return;
        }
        canvas.drawBitmap(bitmap, (getWidth() - this.laserBitmap.getWidth()) / 2.0f, this.scannerStart, this.paint);
        int i3 = this.scannerStart;
        if (i3 < this.scannerEnd) {
            this.scannerStart = i3 + this.laserMovementSpeed;
        } else {
            this.scannerStart = rect.top;
        }
    }

    private void drawLaserScanner(Canvas canvas, Rect rect) {
        if (this.laserStyle != null) {
            this.paint.setColor(this.laserColor);
            int i3 = AnonymousClass2.$SwitchMap$com$king$view$viewfinderview$ViewfinderView$LaserStyle[this.laserStyle.ordinal()];
            if (i3 == 1) {
                drawLineScanner(canvas, rect);
            } else if (i3 == 2) {
                drawGridScanner(canvas, rect);
            } else if (i3 == 3) {
                drawImageScanner(canvas, rect);
            }
            this.paint.setShader(null);
        }
    }

    private void drawLineScanner(Canvas canvas, Rect rect) {
        this.paint.setShader(new LinearGradient(rect.centerX(), this.scannerStart, rect.centerX(), this.scannerStart + this.laserLineHeight, shadeColor(this.laserColor), this.laserColor, Shader.TileMode.MIRROR));
        if (this.scannerStart >= this.scannerEnd) {
            this.scannerStart = rect.top;
            return;
        }
        int i3 = rect.left;
        int i10 = this.frameCornerSize;
        canvas.drawOval(new RectF(i3 + i10, this.scannerStart, rect.right - i10, r3 + this.laserLineHeight), this.paint);
        this.scannerStart += this.laserMovementSpeed;
    }

    private void drawMask(Canvas canvas, int i3, int i10) {
        int i11 = this.maskColor;
        if (i11 != 0) {
            this.paint.setColor(i11);
            canvas.drawRect(0.0f, 0.0f, i3, i10, this.paint);
        }
    }

    private void drawResultPoint(Canvas canvas, Point point, float f2) {
        if (this.pointBitmap == null) {
            this.paint.setColor(this.pointStrokeColor);
            canvas.drawCircle(point.x, point.y, this.pointStrokeRadius * f2, this.paint);
            this.paint.setColor(this.pointColor);
            canvas.drawCircle(point.x, point.y, this.pointRadius * f2, this.paint);
            return;
        }
        float width = point.x - (r0.getWidth() / 2.0f);
        float height = point.y - (this.pointBitmap.getHeight() / 2.0f);
        if (!this.isPointAnimation) {
            canvas.drawBitmap(this.pointBitmap, width, height, this.paint);
            return;
        }
        int round = Math.round(this.pointBitmap.getWidth() * f2);
        int round2 = Math.round(this.pointBitmap.getHeight() * f2);
        int round3 = point.x - Math.round(round / 2.0f);
        int round4 = point.y - Math.round(round2 / 2.0f);
        canvas.drawBitmap(this.pointBitmap, (Rect) null, new Rect(round3, round4, round + round3, round2 + round4), this.paint);
    }

    private void drawResultPoints(Canvas canvas, List<Point> list) {
        this.paint.setColor(-1);
        if (list != null) {
            Iterator<Point> it = list.iterator();
            while (it.hasNext()) {
                drawResultPoint(canvas, it.next(), this.currentZoomRatio);
            }
        }
    }

    private void drawTextInfo(Canvas canvas, Rect rect) {
        if (TextUtils.isEmpty(this.labelText)) {
            return;
        }
        this.textPaint.setColor(this.labelTextColor);
        this.textPaint.setTextSize(this.labelTextSize);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        StaticLayout staticLayout = new StaticLayout(this.labelText, this.textPaint, this.labelTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, true);
        if (this.labelTextLocation == TextLocation.BOTTOM) {
            canvas.translate((rect.width() / 2.0f) + rect.left, rect.bottom + this.labelTextPadding);
        } else {
            canvas.translate((rect.width() / 2.0f) + rect.left, (rect.top - this.labelTextPadding) - staticLayout.getHeight());
        }
        staticLayout.draw(canvas);
    }

    private Bitmap getBitmapFormDrawable(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private int getColor(Context context, int i3) {
        return context.getColor(i3);
    }

    private float getDistance(float f2, float f10, float f11, float f12) {
        return (float) Math.sqrt(Math.pow(f10 - f12, 2.0d) + Math.pow(f2 - f11, 2.0d));
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewfinderView);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.viewfinderStyle = obtainStyledAttributes.getInt(R.styleable.ViewfinderView_vvViewfinderStyle, 0);
        this.maskColor = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_vvMaskColor, getColor(context, R.color.viewfinder_mask));
        this.frameColor = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_vvFrameColor, getColor(context, R.color.viewfinder_frame));
        this.frameWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_vvFrameWidth, 0);
        this.frameHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_vvFrameHeight, 0);
        this.frameRatio = obtainStyledAttributes.getFloat(R.styleable.ViewfinderView_vvFrameRatio, 0.625f);
        this.frameLineStrokeWidth = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvFrameLineStrokeWidth, TypedValue.applyDimension(1, 1.0f, displayMetrics));
        this.framePaddingLeft = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvFramePaddingLeft, 0.0f);
        this.framePaddingTop = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvFramePaddingTop, 0.0f);
        this.framePaddingRight = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvFramePaddingRight, 0.0f);
        this.framePaddingBottom = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvFramePaddingBottom, 0.0f);
        this.frameGravity = FrameGravity.getFromInt(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_vvFrameGravity, FrameGravity.CENTER.mValue));
        this.frameCornerColor = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_vvFrameCornerColor, getColor(context, R.color.viewfinder_corner));
        this.frameCornerSize = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvFrameCornerSize, TypedValue.applyDimension(1, 16.0f, displayMetrics));
        this.frameCornerStrokeWidth = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvFrameCornerStrokeWidth, TypedValue.applyDimension(1, 4.0f, displayMetrics));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ViewfinderView_vvFrameDrawable);
        this.laserLineHeight = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvLaserLineHeight, TypedValue.applyDimension(1, 5.0f, displayMetrics));
        this.laserMovementSpeed = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvLaserMovementSpeed, TypedValue.applyDimension(1, 2.0f, displayMetrics));
        this.laserAnimationInterval = obtainStyledAttributes.getInteger(R.styleable.ViewfinderView_vvLaserAnimationInterval, 20);
        this.laserGridColumn = obtainStyledAttributes.getInt(R.styleable.ViewfinderView_vvLaserGridColumn, 20);
        this.laserGridHeight = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvLaserGridHeight, TypedValue.applyDimension(1, 40.0f, displayMetrics));
        this.laserColor = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_vvLaserColor, getColor(context, R.color.viewfinder_laser));
        this.laserStyle = LaserStyle.getFromInt(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_vvLaserStyle, LaserStyle.LINE.mValue));
        this.laserBitmapRatio = obtainStyledAttributes.getFloat(R.styleable.ViewfinderView_vvLaserDrawableRatio, 0.625f);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ViewfinderView_vvLaserDrawable);
        this.labelText = obtainStyledAttributes.getString(R.styleable.ViewfinderView_vvLabelText);
        this.labelTextColor = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_vvLabelTextColor, getColor(context, R.color.viewfinder_label_text));
        this.labelTextSize = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvLabelTextSize, TypedValue.applyDimension(2, 14.0f, displayMetrics));
        this.labelTextPadding = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvLabelTextPadding, TypedValue.applyDimension(1, 24.0f, displayMetrics));
        this.labelTextWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_vvLabelTextWidth, 0);
        this.labelTextLocation = TextLocation.getFromInt(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_vvLabelTextLocation, 0));
        this.pointColor = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_vvPointColor, getColor(context, R.color.viewfinder_point));
        this.pointStrokeColor = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_vvPointStrokeColor, getColor(context, R.color.viewfinder_point_stroke));
        this.pointRadius = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_vvPointRadius, TypedValue.applyDimension(1, 15.0f, displayMetrics));
        this.pointStrokeRatio = obtainStyledAttributes.getFloat(R.styleable.ViewfinderView_vvPointStrokeRatio, 1.2f);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ViewfinderView_vvPointDrawable);
        this.isPointAnimation = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_vvPointAnimation, true);
        this.pointAnimationInterval = obtainStyledAttributes.getInt(R.styleable.ViewfinderView_vvPointAnimationInterval, 3000);
        obtainStyledAttributes.recycle();
        if (drawable != null) {
            this.frameBitmap = getBitmapFormDrawable(drawable);
        }
        if (drawable2 != null) {
            this.laserBitmap = getBitmapFormDrawable(drawable2);
        }
        if (drawable3 != null) {
            this.pointBitmap = getBitmapFormDrawable(drawable3);
            this.pointRangeRadius = ((this.pointBitmap.getHeight() + r11.getWidth()) / 4.0f) * 1.2f;
        } else {
            float f2 = this.pointRadius * this.pointStrokeRatio;
            this.pointStrokeRadius = f2;
            this.pointRangeRadius = f2 * 1.2f;
        }
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setAntiAlias(true);
        this.textPaint = new TextPaint(1);
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.king.view.viewfinderview.ViewfinderView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (ViewfinderView.this.isShowPoints && ViewfinderView.this.checkSingleTap(motionEvent.getX(), motionEvent.getY())) {
                    return true;
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
    }

    private void initFrame(int i3, int i10) {
        int min = Math.min(i3, i10);
        this.minDimension = min;
        int i11 = (int) (min * this.frameRatio);
        if (this.laserBitmapWidth <= 0.0f) {
            this.laserBitmapWidth = min * this.laserBitmapRatio;
            scaleLaserBitmap();
        }
        int i12 = this.frameWidth;
        if (i12 <= 0 || i12 > i3) {
            this.frameWidth = i11;
        }
        int i13 = this.frameHeight;
        if (i13 <= 0 || i13 > i10) {
            this.frameHeight = i11;
        }
        if (this.labelTextWidth <= 0) {
            this.labelTextWidth = (i3 - getPaddingLeft()) - getPaddingRight();
        }
        float f2 = (((i3 - this.frameWidth) / 2.0f) + this.framePaddingLeft) - this.framePaddingRight;
        float f10 = (((i10 - this.frameHeight) / 2.0f) + this.framePaddingTop) - this.framePaddingBottom;
        int i14 = AnonymousClass2.$SwitchMap$com$king$view$viewfinderview$ViewfinderView$FrameGravity[this.frameGravity.ordinal()];
        if (i14 == 1) {
            f2 = this.framePaddingLeft;
        } else if (i14 == 2) {
            f10 = this.framePaddingTop;
        } else if (i14 == 3) {
            f2 = (i3 - this.frameWidth) + this.framePaddingRight;
        } else if (i14 == 4) {
            f10 = (i10 - this.frameHeight) + this.framePaddingBottom;
        }
        int i15 = (int) f2;
        int i16 = (int) f10;
        this.frame = new Rect(i15, i16, this.frameWidth + i15, this.frameHeight + i16);
    }

    private void scaleLaserBitmap() {
        if (this.laserBitmap != null) {
            float f2 = this.laserBitmapWidth;
            if (f2 > 0.0f) {
                float width = f2 / r0.getWidth();
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                this.laserBitmap = Bitmap.createBitmap(this.laserBitmap, 0, 0, this.laserBitmap.getWidth(), this.laserBitmap.getHeight(), matrix, true);
            }
        }
    }

    private int shadeColor(int i3) {
        return Integer.valueOf("01" + Integer.toHexString(i3).substring(2), 16).intValue();
    }

    public boolean isShowPoints() {
        return this.isShowPoints;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.isShowPoints) {
            drawMask(canvas, getWidth(), getHeight());
            drawResultPoints(canvas, this.pointList);
            if (this.isPointAnimation) {
                calcPointZoomAnimation();
            }
        } else {
            Rect rect = this.frame;
            if (rect != null) {
                if (this.scannerStart == 0 || this.scannerEnd == 0) {
                    this.scannerStart = rect.top;
                    this.scannerEnd = rect.bottom - this.laserLineHeight;
                }
                int i3 = this.viewfinderStyle;
                if (i3 != 0) {
                    if (i3 == 1) {
                        drawLaserScanner(canvas, rect);
                        drawTextInfo(canvas, this.frame);
                        postInvalidateDelayed(this.laserAnimationInterval);
                        return;
                    }
                    return;
                }
                drawExterior(canvas, rect, getWidth(), getHeight());
                drawLaserScanner(canvas, this.frame);
                drawFrame(canvas, this.frame);
                drawTextInfo(canvas, this.frame);
                long j4 = this.laserAnimationInterval;
                Rect rect2 = this.frame;
                postInvalidateDelayed(j4, rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        initFrame(getWidth(), getHeight());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        return this.isShowPoints || super.onTouchEvent(motionEvent);
    }

    public void setFrameBitmap(Bitmap bitmap) {
        this.frameBitmap = bitmap;
    }

    public void setFrameColor(int i3) {
        this.frameColor = i3;
    }

    public void setFrameCornerColor(int i3) {
        this.frameCornerColor = i3;
    }

    public void setFrameCornerSize(int i3) {
        this.frameCornerSize = i3;
    }

    public void setFrameCornerStrokeWidth(int i3) {
        this.frameCornerStrokeWidth = i3;
    }

    public void setFrameDrawable(int i3) {
        setFrameBitmap(BitmapFactory.decodeResource(getResources(), i3));
    }

    public void setFrameGravity(FrameGravity frameGravity) {
        this.frameGravity = frameGravity;
    }

    public void setFrameHeight(int i3) {
        this.frameHeight = i3;
    }

    public void setFrameLineStrokeWidth(int i3) {
        this.frameLineStrokeWidth = i3;
    }

    public void setFramePadding(float f2, float f10, float f11, float f12) {
        this.framePaddingLeft = f2;
        this.framePaddingTop = f10;
        this.framePaddingRight = f11;
        this.framePaddingBottom = f12;
    }

    public void setFramePaddingBottom(float f2) {
        this.framePaddingBottom = f2;
    }

    public void setFramePaddingLeft(float f2) {
        this.framePaddingLeft = f2;
    }

    public void setFramePaddingRight(float f2) {
        this.framePaddingRight = f2;
    }

    public void setFramePaddingTop(float f2) {
        this.framePaddingTop = f2;
    }

    public void setFrameRatio(float f2) {
        this.frameRatio = f2;
    }

    public void setFrameWidth(int i3) {
        this.frameWidth = i3;
    }

    public void setLabelText(String str) {
        this.labelText = str;
    }

    public void setLabelTextColor(int i3) {
        this.labelTextColor = i3;
    }

    public void setLabelTextColorResource(int i3) {
        this.labelTextColor = getColor(getContext(), i3);
    }

    public void setLabelTextLocation(TextLocation textLocation) {
        this.labelTextLocation = textLocation;
    }

    public void setLabelTextPadding(float f2) {
        this.labelTextPadding = f2;
    }

    public void setLabelTextSize(float f2) {
        this.labelTextSize = f2;
    }

    public void setLabelTextWidth(int i3) {
        this.labelTextWidth = i3;
    }

    public void setLaserAnimationInterval(int i3) {
        this.laserAnimationInterval = i3;
    }

    public void setLaserBitmap(Bitmap bitmap) {
        this.laserBitmap = bitmap;
        scaleLaserBitmap();
    }

    public void setLaserBitmapRatio(float f2) {
        this.laserBitmapRatio = f2;
        int i3 = this.minDimension;
        if (i3 > 0) {
            this.laserBitmapWidth = i3 * f2;
            scaleLaserBitmap();
        }
    }

    public void setLaserBitmapWidth(float f2) {
        this.laserBitmapWidth = f2;
        scaleLaserBitmap();
    }

    public void setLaserColor(int i3) {
        this.laserColor = i3;
    }

    public void setLaserDrawable(int i3) {
        setLaserBitmap(BitmapFactory.decodeResource(getResources(), i3));
    }

    public void setLaserGridColumn(int i3) {
        this.laserGridColumn = i3;
    }

    public void setLaserGridHeight(int i3) {
        this.laserGridHeight = i3;
    }

    public void setLaserLineHeight(int i3) {
        this.laserLineHeight = i3;
    }

    public void setLaserMovementSpeed(int i3) {
        this.laserMovementSpeed = i3;
    }

    public void setLaserStyle(LaserStyle laserStyle) {
        this.laserStyle = laserStyle;
    }

    public void setMaskColor(int i3) {
        this.maskColor = i3;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setPointAnimation(boolean z5) {
        this.isPointAnimation = z5;
    }

    public void setPointAnimationInterval(int i3) {
        this.pointAnimationInterval = i3;
    }

    public void setPointBitmap(Bitmap bitmap) {
        this.pointBitmap = bitmap;
        this.pointRangeRadius = ((this.pointBitmap.getHeight() + bitmap.getWidth()) / 4.0f) * 1.2f;
    }

    public void setPointColor(int i3) {
        this.pointColor = i3;
    }

    public void setPointDrawable(int i3) {
        setPointBitmap(BitmapFactory.decodeResource(getResources(), i3));
    }

    public void setPointRadius(float f2) {
        this.pointRadius = f2;
    }

    public void setPointRangeRadius(float f2) {
        this.pointRangeRadius = f2;
    }

    public void setPointStrokeColor(int i3) {
        this.pointStrokeColor = i3;
    }

    public void setPointStrokeRadius(float f2) {
        this.pointStrokeRadius = f2;
    }

    public void setViewfinderStyle(int i3) {
        this.viewfinderStyle = i3;
    }

    public void setZoomSpeed(float f2) {
        this.zoomSpeed = f2;
    }

    public void showResultPoints(List<Point> list) {
        this.pointList = list;
        this.isShowPoints = true;
        this.zoomCount = 0;
        this.lastZoomRatio = 0.0f;
        this.currentZoomRatio = 1.0f;
        invalidate();
    }

    public void showScanner() {
        this.isShowPoints = false;
        invalidate();
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setFrameCornerSize(int i3, int i10) {
        this.frameCornerSize = (int) TypedValue.applyDimension(i10, i3, getResources().getDisplayMetrics());
    }

    public void setLabelTextPadding(float f2, int i3) {
        this.labelTextPadding = TypedValue.applyDimension(i3, f2, getResources().getDisplayMetrics());
    }

    public void setLabelTextSize(float f2, int i3) {
        this.labelTextSize = TypedValue.applyDimension(i3, f2, getResources().getDisplayMetrics());
    }

    public void setPointRadius(float f2, int i3) {
        this.pointRadius = TypedValue.applyDimension(i3, f2, getResources().getDisplayMetrics());
    }

    public ViewfinderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.scannerStart = 0;
        this.scannerEnd = 0;
        this.isPointAnimation = true;
        this.currentZoomRatio = 1.0f;
        this.zoomSpeed = 0.02f;
        this.viewfinderStyle = 0;
        this.isShowPoints = false;
        init(context, attributeSet);
    }
}
