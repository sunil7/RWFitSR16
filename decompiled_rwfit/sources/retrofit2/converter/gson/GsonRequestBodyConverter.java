package retrofit2.converter.gson;

import cc.b;
import com.google.gson.e;
import com.google.gson.k;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
import wh.i;
import wh.j;

/* loaded from: classes2.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final k adapter;
    private final e gson;

    public GsonRequestBodyConverter(e eVar, k kVar) {
        this.gson = eVar;
        this.adapter = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert((GsonRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T t8) throws IOException {
        j jVar = new j();
        b d5 = this.gson.d(new OutputStreamWriter(new i(jVar), UTF_8));
        this.adapter.b(d5, t8);
        d5.close();
        return RequestBody.create(MEDIA_TYPE, jVar.s(jVar.f19654b));
    }
}
