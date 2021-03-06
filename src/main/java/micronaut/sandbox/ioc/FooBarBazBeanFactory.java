package micronaut.sandbox.ioc;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.inject.InjectionPoint;

@Factory
public class FooBarBazBeanFactory {

    @Prototype
    public Bar engine(InjectionPoint<?> injectionPoint) {
        var barType = injectionPoint.getAnnotationMetadata()
                .enumValue(BarType.class, BarType.Type.class);

        return barType
                .<Bar>map(type ->
                        switch (type) {
                            case SMALL -> () -> "smaller";
                            case BIG -> () -> "bigger";
                        })
                .orElseGet(() -> () -> "def");
    }

    @Prototype
    public Baz baz(InjectionPoint<?> injectionPoint) {
        var beanClassName = injectionPoint.getDeclaringBean().getBeanType().getName();
        return new Baz(beanClassName);
    }
}
