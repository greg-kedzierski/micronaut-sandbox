package micronaut.sandbox.ioc;

import io.micronaut.context.BeanContext;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IocSandboxTest {
    final BeanContext context = BeanContext.run();

    @Test
    public void foo_should_be_created_with_bar_and_baz() {
        Foo foo = context.getBean(Foo.class);

        assertThat(foo.getBarTypeName()).isEqualTo("small");
        assertThat(foo.getBazValue()).isEqualTo("micronaut.sandbox.ioc.Foo");
    }
}
