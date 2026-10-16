package androidx.appcompat.widget;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class d0 {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f881d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f882a = 2;

    /* renamed from: b, reason: collision with root package name */
    public View f883b;

    /* renamed from: c, reason: collision with root package name */
    public Object f884c;

    public /* synthetic */ d0() {
    }

    public KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((o4.c) ((n6.a) this.f884c).f16381b).getClass();
        if (keyListener instanceof t1.e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new t1.e(keyListener);
    }

    public void b(AttributeSet attributeSet, int i3) {
        switch (this.f882a) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f883b;
                de.o I = de.o.I(absSeekBar.getContext(), attributeSet, f881d, i3);
                Drawable x10 = I.x(0);
                if (x10 != null) {
                    if (x10 instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) x10;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i10 = 0; i10 < numberOfFrames; i10++) {
                            Drawable e = e(animationDrawable.getFrame(i10), true);
                            e.setLevel(10000);
                            animationDrawable2.addFrame(e, animationDrawable.getDuration(i10));
                        }
                        animationDrawable2.setLevel(10000);
                        x10 = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(x10);
                }
                Drawable x11 = I.x(1);
                if (x11 != null) {
                    absSeekBar.setProgressDrawable(e(x11, false));
                }
                I.K();
                return;
            default:
                TypedArray obtainStyledAttributes = ((EditText) this.f883b).getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i3, 0);
                try {
                    boolean z5 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_emojiCompatEnabled) ? obtainStyledAttributes.getBoolean(R$styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
                    obtainStyledAttributes.recycle();
                    d(z5);
                    return;
                } catch (Throwable th2) {
                    obtainStyledAttributes.recycle();
                    throw th2;
                }
        }
    }

    public t1.b c(InputConnection inputConnection, EditorInfo editorInfo) {
        n6.a aVar = (n6.a) this.f884c;
        if (inputConnection == null) {
            aVar.getClass();
            inputConnection = null;
        } else {
            o4.c cVar = (o4.c) aVar.f16381b;
            cVar.getClass();
            if (!(inputConnection instanceof t1.b)) {
                inputConnection = new t1.b((EditText) cVar.f16732a, inputConnection, editorInfo);
            }
        }
        return (t1.b) inputConnection;
    }

    public void d(boolean z5) {
        t1.h hVar = (t1.h) ((o4.c) ((n6.a) this.f884c).f16381b).f16733b;
        if (hVar.f18484c != z5) {
            if (hVar.f18483b != null) {
                androidx.emoji2.text.k a3 = androidx.emoji2.text.k.a();
                k3 k3Var = hVar.f18483b;
                a3.getClass();
                pd.e(k3Var, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a3.f2037a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a3.f2038b.remove(k3Var);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            hVar.f18484c = z5;
            if (z5) {
                t1.h.a(hVar.f18482a, androidx.emoji2.text.k.a().b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable e(Drawable drawable, boolean z5) {
        if (drawable instanceof d1.h) {
            ((d1.i) ((d1.h) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    int id2 = layerDrawable.getId(i3);
                    drawableArr[i3] = e(layerDrawable.getDrawable(i3), id2 == 16908301 || id2 == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    layerDrawable2.setId(i10, layerDrawable.getId(i10));
                    layerDrawable2.setLayerGravity(i10, layerDrawable.getLayerGravity(i10));
                    layerDrawable2.setLayerWidth(i10, layerDrawable.getLayerWidth(i10));
                    layerDrawable2.setLayerHeight(i10, layerDrawable.getLayerHeight(i10));
                    layerDrawable2.setLayerInsetLeft(i10, layerDrawable.getLayerInsetLeft(i10));
                    layerDrawable2.setLayerInsetRight(i10, layerDrawable.getLayerInsetRight(i10));
                    layerDrawable2.setLayerInsetTop(i10, layerDrawable.getLayerInsetTop(i10));
                    layerDrawable2.setLayerInsetBottom(i10, layerDrawable.getLayerInsetBottom(i10));
                    layerDrawable2.setLayerInsetStart(i10, layerDrawable.getLayerInsetStart(i10));
                    layerDrawable2.setLayerInsetEnd(i10, layerDrawable.getLayerInsetEnd(i10));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f884c) == null) {
                    this.f884c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z5 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public d0(AbsSeekBar absSeekBar) {
        this.f883b = absSeekBar;
    }

    public d0(EditText editText) {
        this.f883b = editText;
        this.f884c = new n6.a(editText);
    }
}
