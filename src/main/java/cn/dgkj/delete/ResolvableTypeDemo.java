package cn.dgkj.delete;

import org.springframework.core.ResolvableType;

public class ResolvableTypeDemo {

    class Person<T> {

    }

    class Man extends Person<String> {

    }

    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(Man.class);
        System.out.println(resolvableType);

        Class<?> resolve = resolvableType.getSuperType().getGeneric(0).resolve();
        System.out.println(resolve);

    }

}
