package micronaut.sandbox.ioc;

import jakarta.inject.Singleton;

import static micronaut.sandbox.ioc.BarType.Type.SMALL;

@Singleton
public class Foo {
    private final Bar bar;
    private final Baz baz;

    public Foo(@BarType(SMALL) Bar bar, Baz baz) {
        this.bar = bar;
        this.baz = baz;
    }

    public String getBarTypeName() {
        return bar.getTypeName();
    }

    public String getBazValue() {
        return baz.value();
    }
}
