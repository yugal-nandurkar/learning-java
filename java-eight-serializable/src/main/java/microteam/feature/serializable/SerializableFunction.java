package microteam.feature.serializable;

import java.io.Serializable;

@FunctionalInterface
public interface SerializableFunction<T, R> extends java.util.function.Function<T, R>, Serializable {
    R apply(T t);
}
