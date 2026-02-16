package customfunctionalinterface;

@FunctionalInterface
public interface UserNameGenerator<T, U, V, W, R> {

    R generate(T t, U u, V v, W w);
}
