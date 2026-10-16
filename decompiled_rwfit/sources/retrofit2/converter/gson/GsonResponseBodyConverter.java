package retrofit2.converter.gson;

import cc.a;
import com.google.gson.JsonIOException;
import com.google.gson.e;
import com.google.gson.k;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes2.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final k adapter;
    private final e gson;

    public GsonResponseBodyConverter(e eVar, k kVar) {
        this.gson = eVar;
        this.adapter = kVar;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        e eVar = this.gson;
        Reader charStream = responseBody.charStream();
        eVar.getClass();
        a aVar = new a(charStream);
        aVar.f3428b = false;
        try {
            T t8 = (T) this.adapter.a(aVar);
            if (aVar.b0() == JsonToken.END_DOCUMENT) {
                return t8;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
