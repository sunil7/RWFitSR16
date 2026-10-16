package t1;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.text.k;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f18470a;

    /* renamed from: b, reason: collision with root package name */
    public final gc.b f18471b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        gc.b bVar = new gc.b(19);
        this.f18470a = editText;
        this.f18471b = bVar;
        if (k.f2036j != null) {
            k a3 = k.a();
            if (a3.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            androidx.emoji2.text.f fVar = a3.e;
            fVar.getClass();
            Bundle bundle = editorInfo.extras;
            s1.b bVar2 = (s1.b) fVar.f2028c.f19146a;
            int a10 = bVar2.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", a10 != 0 ? ((ByteBuffer) bVar2.f15697d).getInt(a10 + bVar2.f15694a) : 0);
            Bundle bundle2 = editorInfo.extras;
            fVar.f2026a.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i3, int i10) {
        Editable editableText = this.f18470a.getEditableText();
        this.f18471b.getClass();
        return gc.b.m(this, editableText, i3, i10, false) || super.deleteSurroundingText(i3, i10);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i3, int i10) {
        Editable editableText = this.f18470a.getEditableText();
        this.f18471b.getClass();
        return gc.b.m(this, editableText, i3, i10, true) || super.deleteSurroundingTextInCodePoints(i3, i10);
    }
}
