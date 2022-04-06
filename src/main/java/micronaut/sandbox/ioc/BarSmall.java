package micronaut.sandbox.ioc;

class BarSmall implements Bar {

    @Override
    public String getTypeName() {
        return "small";
    }
}
