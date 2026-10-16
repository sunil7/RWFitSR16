package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import r5.a;

/* loaded from: classes.dex */
public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    private static final String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    private final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;
    public static final int ORIENTATION_270 = 270;
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, Integer.valueOf(ORIENTATION_270), -1);
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3, 4);

    public static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    public static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z5) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z5;
        }

        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = decoderFactory.make().decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, uri));
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e);
                this.exception = e;
                return null;
            } catch (OutOfMemoryError e10) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e10);
                this.exception = new RuntimeException(e10);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && num != null) {
                    if (this.preview) {
                        subsamplingScaleImageView.onPreviewLoaded(bitmap);
                        return;
                    } else {
                        subsamplingScaleImageView.onImageLoaded(bitmap, num.intValue(), false);
                        return;
                    }
                }
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                if (this.preview) {
                    subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                } else {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewReleased() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onCenterChanged(PointF pointF, int i3) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float f2, int i3) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i3);

        void onScaleChanged(float f2, int i3);
    }

    public static class ScaleAndTranslate {
        private float scale;
        private final PointF vTranslate;

        private ScaleAndTranslate(float f2, PointF pointF) {
            this.scale = f2;
            this.vTranslate = pointF;
        }
    }

    public static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private Tile() {
        }
    }

    public static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            tile.loading = true;
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.isReady() || !tile.visible) {
                    if (tile == null) {
                        return null;
                    }
                    tile.loading = false;
                    return null;
                }
                subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                subsamplingScaleImageView.decoderLock.readLock().lock();
                try {
                    if (!imageRegionDecoder.isReady()) {
                        tile.loading = false;
                        subsamplingScaleImageView.decoderLock.readLock().unlock();
                        return null;
                    }
                    subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                    if (subsamplingScaleImageView.sRegion != null) {
                        tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                    }
                    Bitmap decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return decodeRegion;
                } catch (Throwable th2) {
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    throw th2;
                }
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e);
                this.exception = e;
                return null;
            } catch (OutOfMemoryError e10) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e10);
                this.exception = new RuntimeException(e10);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap != null) {
                tile.bitmap = bitmap;
                tile.loading = false;
                subsamplingScaleImageView.onTileLoaded();
            } else {
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
            }
        }
    }

    public static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        @Override // android.os.AsyncTask
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder make = decoderFactory.make();
                this.decoder = make;
                Point init = make.init(context, this.source);
                int i3 = init.x;
                int i10 = init.y;
                int exifOrientation = subsamplingScaleImageView.getExifOrientation(context, uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(i3, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(i10, subsamplingScaleImageView.sRegion.bottom);
                    i3 = subsamplingScaleImageView.sRegion.width();
                    i10 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i3, i10, exifOrientation};
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e);
                this.exception = e;
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else {
                    if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                        return;
                    }
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = TILE_SIZE_AUTO;
        this.maxTileHeight = TILE_SIZE_AUTO;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL);
        setDoubleTapZoomDpi(GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL);
        setMinimumTileDpi(GlMapUtil.DEVICE_DISPLAY_DPI_HIGH);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_assetName) && (string = obtainStyledAttributes.getString(R.styleable.SubsamplingScaleImageView_assetName)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_src) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.SubsamplingScaleImageView_src, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(R.styleable.SubsamplingScaleImageView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f2) {
        int round;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth = (int) (sWidth() * f2);
        int sHeight = (int) (sHeight() * f2);
        if (sWidth == 0 || sHeight == 0) {
            return 32;
        }
        int i3 = 1;
        if (sHeight() > sHeight || sWidth() > sWidth) {
            round = Math.round(sHeight() / sHeight);
            int round2 = Math.round(sWidth() / sWidth);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        while (true) {
            int i10 = i3 * 2;
            if (i10 >= round) {
                return i3;
            }
            i3 = i10;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z5 = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z5) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
        }
        return z5;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize(px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth(px(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private float distance(float f2, float f10, float f11, float f12) {
        float f13 = f2 - f10;
        float f14 = f11 - f12;
        return (float) Math.sqrt((f14 * f14) + (f13 * f13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f2 = this.scale;
        boolean z5 = ((double) f2) <= ((double) min) * 0.9d || f2 == this.minScale;
        if (!z5) {
            min = minScale();
        }
        float f10 = min;
        int i3 = this.doubleTapZoomStyle;
        if (i3 != 3) {
            if (i3 == 2 || !z5 || !this.panEnabled) {
                new AnimationBuilder(f10, pointF).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
            } else if (i3 == 1) {
                new AnimationBuilder(f10, pointF, pointF2).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
            }
            invalidate();
        }
        setScaleAndCenter(f10, pointF);
        invalidate();
    }

    private float ease(int i3, long j4, float f2, float f10, long j10) {
        if (i3 == 1) {
            return easeOutQuad(j4, f2, f10, j10);
        }
        if (i3 == 2) {
            return easeInOutQuad(j4, f2, f10, j10);
        }
        throw new IllegalStateException(l0.j(i3, "Unexpected easing type: "));
    }

    private float easeInOutQuad(long j4, float f2, float f10, long j10) {
        float f11 = j4 / (j10 / 2.0f);
        if (f11 < 1.0f) {
            return ((f10 / 2.0f) * f11 * f11) + f2;
        }
        float f12 = f11 - 1.0f;
        return ((((f12 - 2.0f) * f12) - 1.0f) * ((-f10) / 2.0f)) + f2;
    }

    private float easeOutQuad(long j4, float f2, float f10, long j10) {
        float f11 = j4 / j10;
        return l0.a(f11, 2.0f, (-f10) * f11, f2);
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            int i3 = rect.top;
            int i10 = this.sHeight;
            rect2.set(i3, i10 - rect.right, rect.bottom, i10 - rect.left);
        } else if (getRequiredRotation() != 180) {
            int i11 = this.sWidth;
            rect2.set(i11 - rect.bottom, rect.left, i11 - rect.top, rect.right);
        } else {
            int i12 = this.sWidth;
            int i13 = i12 - rect.right;
            int i14 = this.sHeight;
            rect2.set(i13, i14 - rect.bottom, i12 - rect.left, i14 - rect.top);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z5, ScaleAndTranslate scaleAndTranslate) {
        float paddingLeft;
        float max;
        int max2;
        float max3;
        if (this.panLimit == 2 && isReady()) {
            z5 = false;
        }
        PointF pointF = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth = sWidth() * limitedScale;
        float sHeight = sHeight() * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - sWidth);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - sHeight);
        } else if (z5) {
            pointF.x = Math.max(pointF.x, getWidth() - sWidth);
            pointF.y = Math.max(pointF.y, getHeight() - sHeight);
        } else {
            pointF.x = Math.max(pointF.x, -sWidth);
            pointF.y = Math.max(pointF.y, -sHeight);
        }
        float f2 = 0.5f;
        if (getPaddingLeft() > 0 || getPaddingRight() > 0) {
            paddingLeft = getPaddingLeft() / (getPaddingRight() + getPaddingLeft());
        } else {
            paddingLeft = 0.5f;
        }
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f2 = getPaddingTop() / (getPaddingBottom() + getPaddingTop());
        }
        if (this.panLimit == 3 && isReady()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else {
            if (z5) {
                max = Math.max(0.0f, (getWidth() - sWidth) * paddingLeft);
                max3 = Math.max(0.0f, (getHeight() - sHeight) * f2);
                pointF.x = Math.min(pointF.x, max);
                pointF.y = Math.min(pointF.y, max3);
                scaleAndTranslate.scale = limitedScale;
            }
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        max3 = max2;
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max3);
        scaleAndTranslate.scale = limitedScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        if (r2 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (r2 == null) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getExifOrientation(android.content.Context r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Unsupported EXIF orientation: "
            java.lang.String r1 = "Unsupported orientation: "
            java.lang.String r2 = "content"
            boolean r2 = r12.startsWith(r2)
            r3 = 0
            if (r2 == 0) goto L6b
            r2 = 0
            java.lang.String r0 = "orientation"
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            android.net.Uri r5 = android.net.Uri.parse(r12)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            r9 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            if (r2 == 0) goto L55
            boolean r11 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            if (r11 == 0) goto L55
            int r11 = r2.getInt(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            java.util.List<java.lang.Integer> r12 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.VALID_ORIENTATIONS     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            boolean r12 = r12.contains(r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            if (r12 == 0) goto L40
            r12 = -1
            if (r11 == r12) goto L40
            r3 = r11
            goto L55
        L40:
            java.lang.String r12 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            r0.append(r11)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            java.lang.String r11 = r0.toString()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            android.util.Log.w(r12, r11)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5b
            goto L55
        L52:
            r0 = move-exception
            r11 = r0
            goto L65
        L55:
            if (r2 == 0) goto Lbd
        L57:
            r2.close()
            goto Lbd
        L5b:
            java.lang.String r11 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG     // Catch: java.lang.Throwable -> L52
            java.lang.String r12 = "Could not get orientation of image from media store"
            android.util.Log.w(r11, r12)     // Catch: java.lang.Throwable -> L52
            if (r2 == 0) goto Lbd
            goto L57
        L65:
            if (r2 == 0) goto L6a
            r2.close()
        L6a:
            throw r11
        L6b:
            java.lang.String r11 = "file:///"
            boolean r11 = r12.startsWith(r11)
            if (r11 == 0) goto Lbd
            java.lang.String r11 = "file:///android_asset/"
            boolean r11 = r12.startsWith(r11)
            if (r11 != 0) goto Lbd
            u1.g r11 = new u1.g     // Catch: java.lang.Exception -> Lb6
            r1 = 7
            java.lang.String r12 = r12.substring(r1)     // Catch: java.lang.Exception -> Lb6
            r11.<init>(r12)     // Catch: java.lang.Exception -> Lb6
            java.lang.String r12 = "Orientation"
            r1 = 1
            int r11 = r11.c(r1, r12)     // Catch: java.lang.Exception -> Lb6
            if (r11 == r1) goto Lb5
            if (r11 != 0) goto L91
            goto Lb5
        L91:
            r12 = 6
            if (r11 != r12) goto L97
            r11 = 90
            return r11
        L97:
            r12 = 3
            if (r11 != r12) goto L9d
            r11 = 180(0xb4, float:2.52E-43)
            return r11
        L9d:
            r12 = 8
            if (r11 != r12) goto La4
            r11 = 270(0x10e, float:3.78E-43)
            return r11
        La4:
            java.lang.String r12 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG     // Catch: java.lang.Exception -> Lb6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb6
            r1.<init>(r0)     // Catch: java.lang.Exception -> Lb6
            r1.append(r11)     // Catch: java.lang.Exception -> Lb6
            java.lang.String r11 = r1.toString()     // Catch: java.lang.Exception -> Lb6
            android.util.Log.w(r12, r11)     // Catch: java.lang.Exception -> Lb6
        Lb5:
            return r3
        Lb6:
            java.lang.String r11 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG
            java.lang.String r12 = "Could not get EXIF orientation of image"
            android.util.Log.w(r11, r12)
        Lbd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getExifOrientation(android.content.Context, java.lang.String):int");
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    private int getRequiredRotation() {
        int i3 = this.orientation;
        return i3 == -1 ? this.sOrientation : i3;
    }

    private synchronized void initialiseBaseLayer(Point point) {
        Throwable th2;
        try {
            try {
                debug("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
                this.satTemp = scaleAndTranslate;
                fitToBounds(true, scaleAndTranslate);
                int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
                this.fullImageSampleSize = calculateInSampleSize;
                if (calculateInSampleSize > 1) {
                    try {
                        this.fullImageSampleSize = calculateInSampleSize / 2;
                    } catch (Throwable th3) {
                        th2 = th3;
                        throw th2;
                    }
                }
                if (this.fullImageSampleSize != 1 || this.sRegion != null || sWidth() >= point.x || sHeight() >= point.y) {
                    initialiseTileMap(point);
                    Iterator<Tile> it = this.tileMap.get(Integer.valueOf(this.fullImageSampleSize)).iterator();
                    while (it.hasNext()) {
                        execute(new TileLoadTask(this, this.decoder, it.next()));
                    }
                    refreshRequiredTiles(true);
                } else {
                    this.decoder.recycle();
                    this.decoder = null;
                    execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
                }
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
            th2 = th;
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initialiseTileMap(Point point) {
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.tileMap = new LinkedHashMap();
        int i3 = this.fullImageSampleSize;
        int i10 = 1;
        int i11 = 1;
        int i12 = 1;
        while (true) {
            int sWidth = sWidth() / i11;
            int sHeight = sHeight() / i12;
            int i13 = sWidth / i3;
            int i14 = sHeight / i3;
            while (true) {
                if (i13 + i11 + i10 > point.x || (i13 > getWidth() * 1.25d && i3 < this.fullImageSampleSize)) {
                    i11++;
                    sWidth = sWidth() / i11;
                    i13 = sWidth / i3;
                }
            }
            while (true) {
                if (i14 + i12 + i10 > point.y || (i14 > getHeight() * 1.25d && i3 < this.fullImageSampleSize)) {
                    i12++;
                    sHeight = sHeight() / i12;
                    i14 = sHeight / i3;
                }
            }
            ArrayList arrayList = new ArrayList(i11 * i12);
            int i15 = 0;
            while (i15 < i11) {
                int i16 = 0;
                while (i16 < i12) {
                    Tile tile = new Tile();
                    tile.sampleSize = i3;
                    tile.visible = i3 == this.fullImageSampleSize ? i10 : 0;
                    tile.sRect = new Rect(i15 * sWidth, i16 * sHeight, i15 == i11 + (-1) ? sWidth() : (i15 + 1) * sWidth, i16 == i12 + (-1) ? sHeight() : (i16 + 1) * sHeight);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i16++;
                    i10 = 1;
                }
                i15++;
                i10 = 1;
            }
            this.tileMap.put(Integer.valueOf(i3), arrayList);
            i10 = 1;
            if (i3 == 1) {
                return;
            } else {
                i3 /= 2;
            }
        }
    }

    private boolean isBaseLayerReady() {
        boolean z5 = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.fullImageSampleSize) {
                for (Tile tile : entry.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z5 = false;
                    }
                }
            }
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF limitedSCenter(float f2, float f10, float f11, PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f2, f10, f11);
        pointF.set((((((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft()) - vTranslateForSCenter.x) / f11, (((((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2) + getPaddingTop()) - vTranslateForSCenter.y) / f11);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f2) {
        return Math.min(this.maxScale, Math.max(minScale(), f2));
    }

    private float minScale() {
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int i3 = this.minimumScaleType;
        if (i3 == 2 || i3 == 4) {
            return Math.max((getWidth() - paddingRight) / sWidth(), (getHeight() - paddingTop) / sHeight());
        }
        if (i3 == 3) {
            float f2 = this.minScale;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingRight) / sWidth(), (getHeight() - paddingTop) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap) {
        try {
            debug("onPreviewLoaded", new Object[0]);
            if (this.bitmap == null && !this.imageLoadedSent) {
                Rect rect = this.pRegion;
                if (rect != null) {
                    this.bitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.pRegion.height());
                } else {
                    this.bitmap = bitmap;
                }
                this.bitmapIsPreview = true;
                if (checkReady()) {
                    invalidate();
                    requestLayout();
                }
                return;
            }
            bitmap.recycle();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap;
        try {
            debug("onTileLoaded", new Object[0]);
            checkReady();
            checkImageLoaded();
            if (isBaseLayerReady() && (bitmap = this.bitmap) != null) {
                if (!this.bitmapIsCached) {
                    bitmap.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener = this.onImageEventListener;
                if (onImageEventListener != null && this.bitmapIsCached) {
                    onImageEventListener.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
            invalidate();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i3, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        try {
            debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i3), Integer.valueOf(i10), Integer.valueOf(this.orientation));
            int i15 = this.sWidth;
            if (i15 > 0 && (i14 = this.sHeight) > 0 && (i15 != i3 || i14 != i10)) {
                reset(false);
                Bitmap bitmap = this.bitmap;
                if (bitmap != null) {
                    if (!this.bitmapIsCached) {
                        bitmap.recycle();
                    }
                    this.bitmap = null;
                    OnImageEventListener onImageEventListener = this.onImageEventListener;
                    if (onImageEventListener != null && this.bitmapIsCached) {
                        onImageEventListener.onPreviewReleased();
                    }
                    this.bitmapIsPreview = false;
                    this.bitmapIsCached = false;
                }
            }
            this.decoder = imageRegionDecoder;
            this.sWidth = i3;
            this.sHeight = i10;
            this.sOrientation = i11;
            checkReady();
            if (!checkImageLoaded() && (i12 = this.maxTileWidth) > 0 && i12 != Integer.MAX_VALUE && (i13 = this.maxTileHeight) > 0 && i13 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
                initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
            }
            invalidate();
            requestLayout();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r1 != 262) goto L133;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onTouchEventInternal(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 1168
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.sWidth <= 0 || this.sHeight <= 0) {
            return;
        }
        if (this.sPendingCenter != null && (f2 = this.pendingScale) != null) {
            this.scale = f2.floatValue();
            if (this.vTranslate == null) {
                this.vTranslate = new PointF();
            }
            this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
            this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
            this.sPendingCenter = null;
            this.pendingScale = null;
            fitToBounds(true);
            refreshRequiredTiles(true);
        }
        fitToBounds(false);
    }

    private int px(int i3) {
        return (int) (this.density * i3);
    }

    private void refreshRequiredTiles(boolean z5) {
        if (this.decoder == null || this.tileMap == null) {
            return;
        }
        int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        Iterator<Map.Entry<Integer, List<Tile>>> it = this.tileMap.entrySet().iterator();
        while (it.hasNext()) {
            for (Tile tile : it.next().getValue()) {
                if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
                if (tile.sampleSize == min) {
                    if (tileVisible(tile)) {
                        tile.visible = true;
                        if (!tile.loading && tile.bitmap == null && z5) {
                            execute(new TileLoadTask(this, this.decoder, tile));
                        }
                    } else if (tile.sampleSize != this.fullImageSampleSize) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                } else if (tile.sampleSize == this.fullImageSampleSize) {
                    tile.visible = true;
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z5) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z5);
        }
    }

    private void reset(boolean z5) {
        OnImageEventListener onImageEventListener;
        debug(a.d("reset newImage=", z5), new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z5) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && !this.bitmapIsCached) {
                    bitmap.recycle();
                }
                if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                    onImageEventListener.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th2) {
                this.decoderLock.writeLock().unlock();
                throw th2;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            Iterator<Map.Entry<Integer, List<Tile>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (Tile tile : it.next().getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState == null || !VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.orientation = imageViewState.getOrientation();
        this.pendingScale = Float.valueOf(imageViewState.getScale());
        this.sPendingCenter = imageViewState.getCenter();
        invalidate();
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sWidth : this.sHeight;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sHeight : this.sWidth;
    }

    private void sendStateChanged(float f2, PointF pointF, int i3) {
        OnStateChangedListener onStateChangedListener = this.onStateChangedListener;
        if (onStateChangedListener != null) {
            float f10 = this.scale;
            if (f10 != f2) {
                onStateChangedListener.onScaleChanged(f10, i3);
            }
        }
        if (this.onStateChangedListener == null || this.vTranslate.equals(pointF)) {
            return;
        }
        this.onStateChangedListener.onCenterChanged(getCenter(), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!SubsamplingScaleImageView.this.zoomEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                SubsamplingScaleImageView.this.setGestureDetector(context);
                if (!SubsamplingScaleImageView.this.quickScaleEnabled) {
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView.doubleTapZoom(subsamplingScaleImageView.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView2.scaleStart = subsamplingScaleImageView2.scale;
                SubsamplingScaleImageView.this.isQuickScaling = true;
                SubsamplingScaleImageView.this.isZooming = true;
                SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.quickScaleSCenter = subsamplingScaleImageView3.viewToSourceCoord(subsamplingScaleImageView3.vCenterStart);
                SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                SubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                SubsamplingScaleImageView.this.quickScaleMoved = false;
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f10) {
                if (!SubsamplingScaleImageView.this.panEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f2) <= 500.0f && Math.abs(f10) <= 500.0f) || SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f2, f10);
                }
                PointF pointF = new PointF((f2 * 0.25f) + SubsamplingScaleImageView.this.vTranslate.x, (f10 * 0.25f) + SubsamplingScaleImageView.this.vTranslate.y);
                new AnimationBuilder(new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.scale, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f2, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        fArr[0] = f2;
        fArr[1] = f10;
        fArr[2] = f11;
        fArr[3] = f12;
        fArr[4] = f13;
        fArr[5] = f14;
        fArr[6] = f15;
        fArr[7] = f16;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
    }

    private float sourceToViewX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private PointF vTranslateForSCenter(float f2, float f10, float f11) {
        int width = (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        int height = (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2) + getPaddingTop();
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = f11;
        this.satTemp.vTranslate.set(width - (f2 * f11), height - (f10 * f11));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.scale;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(pointF);
        }
        return null;
    }

    public AnimationBuilder animateScale(float f2) {
        if (isReady()) {
            return new AnimationBuilder(f2);
        }
        return null;
    }

    public AnimationBuilder animateScaleAndCenter(float f2, PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(f2, pointF);
        }
        return null;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF rectF) {
        if (isReady()) {
            float sWidth = this.scale * sWidth();
            float sHeight = this.scale * sHeight();
            int i3 = this.panLimit;
            if (i3 == 3) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - (getHeight() / 2)));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - (getWidth() / 2)));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y - ((getHeight() / 2) - sHeight));
                rectF.right = Math.max(0.0f, this.vTranslate.x - ((getWidth() / 2) - sWidth));
                return;
            }
            if (i3 == 2) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - getHeight()));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - getWidth()));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y + sHeight);
                rectF.right = Math.max(0.0f, this.vTranslate.x + sWidth);
                return;
            }
            rectF.top = Math.max(0.0f, -this.vTranslate.y);
            rectF.left = Math.max(0.0f, -this.vTranslate.x);
            rectF.bottom = Math.max(0.0f, (sHeight + this.vTranslate.y) - getHeight());
            rectF.right = Math.max(0.0f, (sWidth + this.vTranslate.x) - getWidth());
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        return (this.uri == null && this.bitmap == null) ? false : true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        float f2;
        int i10;
        int i11;
        boolean z5;
        int i12;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth == 0 || this.sHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.tileMap == null && this.decoder != null) {
            initialiseBaseLayer(getMaxBitmapDimensions(canvas));
        }
        if (checkReady()) {
            preDraw();
            Anim anim = this.anim;
            if (anim != null && anim.vFocusStart != null) {
                float f10 = this.scale;
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(0.0f, 0.0f);
                }
                this.vTranslateBefore.set(this.vTranslate);
                long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                boolean z6 = currentTimeMillis > this.anim.duration;
                long min = Math.min(currentTimeMillis, this.anim.duration);
                this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                fitToBounds(z6 || this.anim.scaleStart == this.anim.scaleEnd);
                sendStateChanged(f10, this.vTranslateBefore, this.anim.origin);
                refreshRequiredTiles(z6);
                if (z6) {
                    if (this.anim.listener != null) {
                        try {
                            this.anim.listener.onComplete();
                        } catch (Exception e) {
                            Log.w(TAG, "Error thrown by animation listener", e);
                        }
                    }
                    this.anim = null;
                }
                invalidate();
            }
            int i13 = 180;
            int i14 = 90;
            int i15 = 5;
            if (this.tileMap == null || !isBaseLayerReady()) {
                i3 = 5;
                if (this.bitmap != null) {
                    float f11 = this.scale;
                    if (this.bitmapIsPreview) {
                        f11 *= this.sWidth / r0.getWidth();
                        f2 = this.scale * (this.sHeight / this.bitmap.getHeight());
                    } else {
                        f2 = f11;
                    }
                    if (this.matrix == null) {
                        this.matrix = new Matrix();
                    }
                    this.matrix.reset();
                    this.matrix.postScale(f11, f2);
                    this.matrix.postRotate(getRequiredRotation());
                    Matrix matrix = this.matrix;
                    PointF pointF = this.vTranslate;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.matrix;
                        float f12 = this.scale;
                        matrix2.postTranslate(this.sWidth * f12, f12 * this.sHeight);
                    } else if (getRequiredRotation() == 90) {
                        this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
                    }
                    if (this.tileBgPaint != null) {
                        if (this.sRect == null) {
                            this.sRect = new RectF();
                        }
                        this.sRect.set(0.0f, 0.0f, this.bitmapIsPreview ? this.bitmap.getWidth() : this.sWidth, this.bitmapIsPreview ? this.bitmap.getHeight() : this.sHeight);
                        this.matrix.mapRect(this.sRect);
                        canvas.drawRect(this.sRect, this.tileBgPaint);
                    }
                    canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                }
            } else {
                int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                boolean z8 = false;
                for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                    if (entry.getKey().intValue() == min2) {
                        for (Tile tile : entry.getValue()) {
                            if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                z8 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<Tile>> entry2 : this.tileMap.entrySet()) {
                    if (entry2.getKey().intValue() == min2 || z8) {
                        for (Tile tile2 : entry2.getValue()) {
                            sourceToViewRect(tile2.sRect, tile2.vRect);
                            if (tile2.loading || tile2.bitmap == null) {
                                i10 = i14;
                                i11 = i15;
                                z5 = z8;
                                i12 = i13;
                                if (tile2.loading && this.debug) {
                                    canvas.drawText("LOADING", tile2.vRect.left + px(i11), tile2.vRect.top + px(35), this.debugTextPaint);
                                }
                            } else {
                                if (this.tileBgPaint != null) {
                                    canvas.drawRect(tile2.vRect, this.tileBgPaint);
                                }
                                if (this.matrix == null) {
                                    this.matrix = new Matrix();
                                }
                                this.matrix.reset();
                                z5 = z8;
                                i11 = i15;
                                i12 = i13;
                                i10 = i14;
                                setMatrixArray(this.srcArray, 0.0f, 0.0f, tile2.bitmap.getWidth(), 0.0f, tile2.bitmap.getWidth(), tile2.bitmap.getHeight(), 0.0f, tile2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom);
                                } else if (getRequiredRotation() == i10) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top);
                                } else if (getRequiredRotation() == i12) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top);
                                } else if (getRequiredRotation() == 270) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom);
                                }
                                this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                canvas.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                if (this.debug) {
                                    canvas.drawRect(tile2.vRect, this.debugLinePaint);
                                }
                            }
                            if (tile2.visible && this.debug) {
                                canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + Const.STR_MART_COMMA + tile2.sRect.left + Const.STR_MART_COMMA + tile2.sRect.bottom + Const.STR_MART_COMMA + tile2.sRect.right, tile2.vRect.left + px(i11), tile2.vRect.top + px(15), this.debugTextPaint);
                            }
                            i13 = i12;
                            i14 = i10;
                            i15 = i11;
                            z8 = z5;
                        }
                    }
                    i13 = i13;
                    i14 = i14;
                    i15 = i15;
                    z8 = z8;
                }
                i3 = i15;
            }
            if (this.debug) {
                StringBuilder sb2 = new StringBuilder("Scale: ");
                Locale locale = Locale.ENGLISH;
                sb2.append(String.format(locale, "%.2f", Float.valueOf(this.scale)));
                sb2.append(" (");
                sb2.append(String.format(locale, "%.2f", Float.valueOf(minScale())));
                sb2.append(" - ");
                sb2.append(String.format(locale, "%.2f", Float.valueOf(this.maxScale)));
                sb2.append(")");
                canvas.drawText(sb2.toString(), px(i3), px(15), this.debugTextPaint);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.vTranslate.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(this.vTranslate.y)), px(i3), px(30), this.debugTextPaint);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(center.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(center.y)), px(i3), px(45), this.debugTextPaint);
                Anim anim2 = this.anim;
                if (anim2 != null) {
                    PointF sourceToViewCoord = sourceToViewCoord(anim2.sCenterStart);
                    PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                    PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                    canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, px(10), this.debugLinePaint);
                    this.debugLinePaint.setColor(-65536);
                    canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, px(20), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, px(25), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
                }
                if (this.vCenterStart != null) {
                    this.debugLinePaint.setColor(-65536);
                    PointF pointF2 = this.vCenterStart;
                    canvas.drawCircle(pointF2.x, pointF2.y, px(20), this.debugLinePaint);
                }
                if (this.quickScaleSCenter != null) {
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(35), this.debugLinePaint);
                }
                if (this.quickScaleVStart != null && this.isQuickScaling) {
                    this.debugLinePaint.setColor(-16711681);
                    PointF pointF3 = this.quickScaleVStart;
                    canvas.drawCircle(pointF3.x, pointF3.y, px(30), this.debugLinePaint);
                }
                this.debugLinePaint.setColor(-65281);
            }
        }
    }

    public void onImageLoaded() {
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i10) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i10);
        boolean z5 = mode != 1073741824;
        boolean z6 = mode2 != 1073741824;
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z5 && z6) {
                size = sWidth();
                size2 = sHeight();
            } else if (z6) {
                size2 = (int) ((sHeight() / sWidth()) * size);
            } else if (z5) {
                size = (int) ((sWidth() / sHeight()) * size2);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    public void onReady() {
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i10, int i11, int i12) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i3), Integer.valueOf(i10));
        PointF center = getCenter();
        if (!this.readySent || center == null) {
            return;
        }
        this.anim = null;
        this.pendingScale = Float.valueOf(this.scale);
        this.sPendingCenter = center;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim = this.anim;
        if (anim != null && !anim.interruptible) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        Anim anim2 = this.anim;
        if (anim2 != null && anim2.listener != null) {
            try {
                this.anim.listener.onInterruptedByUser();
            } catch (Exception e) {
                Log.w(TAG, "Error thrown by animation listener", e);
            }
        }
        this.anim = null;
        if (this.vTranslate == null) {
            GestureDetector gestureDetector2 = this.singleDetector;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        if (this.vTranslateStart == null) {
            this.vTranslateStart = new PointF(0.0f, 0.0f);
        }
        if (this.vTranslateBefore == null) {
            this.vTranslateBefore = new PointF(0.0f, 0.0f);
        }
        if (this.vCenterStart == null) {
            this.vCenterStart = new PointF(0.0f, 0.0f);
        }
        float f2 = this.scale;
        this.vTranslateBefore.set(this.vTranslate);
        boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
        sendStateChanged(f2, this.vTranslateBefore, 2);
        return onTouchEventInternal || super.onTouchEvent(motionEvent);
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.bitmapDecoderFactory = decoderFactory;
    }

    public final void setDebug(boolean z5) {
        this.debug = z5;
    }

    public final void setDoubleTapZoomDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setDoubleTapZoomDuration(int i3) {
        this.doubleTapZoomDuration = Math.max(0, i3);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.doubleTapZoomScale = f2;
    }

    public final void setDoubleTapZoomStyle(int i3) {
        if (!VALID_ZOOM_STYLES.contains(Integer.valueOf(i3))) {
            throw new IllegalArgumentException(l0.j(i3, "Invalid zoom style: "));
        }
        this.doubleTapZoomStyle = i3;
    }

    public void setEagerLoadingEnabled(boolean z5) {
        this.eagerLoadingEnabled = z5;
    }

    public void setExecutor(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("Executor must not be null");
        }
        this.executor = executor;
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public final void setMaxScale(float f2) {
        this.maxScale = f2;
    }

    public void setMaxTileSize(int i3) {
        this.maxTileWidth = i3;
        this.maxTileHeight = i3;
    }

    public final void setMaximumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinScale(float f2) {
        this.minScale = f2;
    }

    public final void setMinimumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinimumScaleType(int i3) {
        if (!VALID_SCALE_TYPES.contains(Integer.valueOf(i3))) {
            throw new IllegalArgumentException(l0.j(i3, "Invalid scale type: "));
        }
        this.minimumScaleType = i3;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i3);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.onStateChangedListener = onStateChangedListener;
    }

    public final void setOrientation(int i3) {
        if (!VALID_ORIENTATIONS.contains(Integer.valueOf(i3))) {
            throw new IllegalArgumentException(l0.j(i3, "Invalid orientation: "));
        }
        this.orientation = i3;
        reset(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z5) {
        PointF pointF;
        this.panEnabled = z5;
        if (z5 || (pointF = this.vTranslate) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        if (isReady()) {
            refreshRequiredTiles(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i3) {
        if (!VALID_PAN_LIMITS.contains(Integer.valueOf(i3))) {
            throw new IllegalArgumentException(l0.j(i3, "Invalid pan limit: "));
        }
        this.panLimit = i3;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setQuickScaleEnabled(boolean z5) {
        this.quickScaleEnabled = z5;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.regionDecoderFactory = new CompatDecoderFactory(cls);
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.regionDecoderFactory = decoderFactory;
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f2);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i3) {
        if (Color.alpha(i3) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i3);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z5) {
        this.zoomEnabled = z5;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect2.set((int) viewToSourceX(rect.left), (int) viewToSourceY(rect.top), (int) viewToSourceX(rect.right), (int) viewToSourceY(rect.bottom));
        fileSRect(rect2, rect2);
        rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
        Rect rect3 = this.sRegion;
        if (rect3 != null) {
            rect2.offset(rect3.left, rect3.top);
        }
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect.set(0, 0, getWidth(), getHeight());
        viewToFileRect(rect, rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i3, boolean z5) {
        OnImageEventListener onImageEventListener;
        try {
            debug("onImageLoaded", new Object[0]);
            int i10 = this.sWidth;
            if (i10 > 0) {
                if (this.sHeight > 0) {
                    if (i10 == bitmap.getWidth()) {
                        if (this.sHeight != bitmap.getHeight()) {
                        }
                    }
                    reset(false);
                }
            }
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null && !this.bitmapIsCached) {
                bitmap2.recycle();
            }
            if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                onImageEventListener.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = z5;
            this.bitmap = bitmap;
            this.sWidth = bitmap.getWidth();
            this.sHeight = bitmap.getHeight();
            this.sOrientation = i3;
            boolean checkReady = checkReady();
            boolean checkImageLoaded = checkImageLoaded();
            if (checkReady || checkImageLoaded) {
                invalidate();
                requestLayout();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    public final PointF sourceToViewCoord(float f2, float f10) {
        return sourceToViewCoord(f2, f10, new PointF());
    }

    public final PointF viewToSourceCoord(float f2, float f10) {
        return viewToSourceCoord(f2, f10, new PointF());
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public void setMaxTileSize(int i3, int i10) {
        this.maxTileWidth = i3;
        this.maxTileHeight = i10;
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        /* JADX INFO: Access modifiers changed from: private */
        public AnimationBuilder withOrigin(int i3) {
            this.origin = i3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z5) {
            this.panLimited = z5;
            return this;
        }

        public void start() {
            PointF pointF;
            if (SubsamplingScaleImageView.this.anim != null && SubsamplingScaleImageView.this.anim.listener != null) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e);
                }
            }
            int width = (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2) + SubsamplingScaleImageView.this.getPaddingLeft();
            int height = (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2) + SubsamplingScaleImageView.this.getPaddingTop();
            float limitedScale = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                pointF = subsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, limitedScale, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            SubsamplingScaleImageView.this.anim = new Anim();
            SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.anim.scaleEnd = limitedScale;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(width, height);
            SubsamplingScaleImageView.this.anim.duration = this.duration;
            SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            SubsamplingScaleImageView.this.anim.easing = this.easing;
            SubsamplingScaleImageView.this.anim.origin = this.origin;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f2 = pointF3.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * limitedScale);
                float f10 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * limitedScale);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f2, f10));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF((scaleAndTranslate.vTranslate.x - f2) + this.vFocus.x, (scaleAndTranslate.vTranslate.y - f10) + this.vFocus.y);
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public AnimationBuilder withDuration(long j4) {
            this.duration = j4;
            return this;
        }

        public AnimationBuilder withEasing(int i3) {
            if (!SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i3))) {
                throw new IllegalArgumentException(l0.j(i3, "Unknown easing type: "));
            }
            this.easing = i3;
            return this;
        }

        public AnimationBuilder withInterruptible(boolean z5) {
            this.interruptible = z5;
            return this;
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        private AnimationBuilder(PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f2, PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f2, PointF pointF, PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource != null) {
            reset(true);
            if (imageViewState != null) {
                restoreState(imageViewState);
            }
            if (imageSource2 != null) {
                if (imageSource.getBitmap() == null) {
                    if (imageSource.getSWidth() > 0 && imageSource.getSHeight() > 0) {
                        this.sWidth = imageSource.getSWidth();
                        this.sHeight = imageSource.getSHeight();
                        this.pRegion = imageSource2.getSRegion();
                        if (imageSource2.getBitmap() != null) {
                            this.bitmapIsCached = imageSource2.isCached();
                            onPreviewLoaded(imageSource2.getBitmap());
                        } else {
                            Uri uri = imageSource2.getUri();
                            if (uri == null && imageSource2.getResource() != null) {
                                uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                            }
                            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true));
                        }
                    } else {
                        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                }
            }
            if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
                onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
                return;
            }
            if (imageSource.getBitmap() != null) {
                onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
                return;
            }
            this.sRegion = imageSource.getSRegion();
            Uri uri2 = imageSource.getUri();
            this.uri = uri2;
            if (uri2 == null && imageSource.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
            }
            if (!imageSource.getTile() && this.sRegion == null) {
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
                return;
            } else {
                execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                return;
            }
        }
        throw new NullPointerException("imageSource must not be null");
    }

    public final PointF sourceToViewCoord(float f2, float f10, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f2), sourceToViewY(f10));
        return pointF;
    }

    public final PointF viewToSourceCoord(float f2, float f10, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f2), viewToSourceY(f10));
        return pointF;
    }

    private void fitToBounds(boolean z5) {
        boolean z6;
        float f2 = 0.0f;
        if (this.vTranslate == null) {
            this.vTranslate = new PointF(0.0f, 0.0f);
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(f2, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z5, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (!z6 || this.minimumScaleType == 4) {
            return;
        }
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }
}
