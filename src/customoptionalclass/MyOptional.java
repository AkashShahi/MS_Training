package customoptionalclass;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class MyOptional<T> {

    private static final MyOptional Empty = new MyOptional<>(null);

    private T value;

    private MyOptional(T value) {
        this.value = value;
    }

    public static <T> MyOptional<T> of(T value) {
        if (value == null) {
            throw new NullPointerException("Value must not be null");
        }

        return new MyOptional<>(value);
    }

    public static <T> MyOptional<T> ofNullable(T value) {
        if (value == null) {
            return Empty;
        }

        return new MyOptional<>(value);
    }

    public static <T> MyOptional<T> empty() {
        MyOptional<T> t = (MyOptional<T>) Empty;
        return t;
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }

        return value;
    }

    public T orElse(T other) {
        if (value != null) {
            return value;
        }
        return other;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        if (value != null) {
            return value;
        }

        return supplier.get();
    }

    public T orElseThrow() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }

        return value;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }

    public void ifPresent(Consumer<? super T> action) {
        if (value != null) {
            action.accept(value);
        }
    }

    public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
        if (value != null) {
            action.accept(value);
        } else {
            emptyAction.run();
        }
    }

    public MyOptional<T> or(Supplier<? extends MyOptional<? extends T>> supplier) {
        if (isPresent()) {
            return this;
        } else {
            MyOptional<T> t = (MyOptional<T>) supplier.get();
            return Objects.requireNonNull(t);
        }
    }

    public Stream<T> stream() {
        if (isEmpty()) {
            return Stream.empty();
        } else {
            return Stream.of(value);
        }
    }

    public <U> MyOptional<U> map(Function<? super T, ? extends U> mapper) {
        if (isEmpty()) {
            return empty();
        } else {
            return MyOptional.ofNullable(mapper.apply(value));
        }
    }

    public <U> MyOptional<U> flatMap(Function<? super T, ? extends U> mapper) {
        if (isEmpty()) {
            return empty();
        } else {
            MyOptional<U> r = (MyOptional<U>) mapper.apply(value);
            return Objects.requireNonNull(r);
        }


    }

    public MyOptional<T> filter(Predicate<? super T> predicate) {
        if(isEmpty()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }

}
