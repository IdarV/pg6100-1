package org.pg6100.multithreading.jee;

import org.pg6100.multithreading.CounterTestBaseJEE;

import static org.junit.Assert.*;

public class SingletonExample03Test extends CounterTestBaseJEE {

    @Override
    protected Class<?> getSingletonClass() {
        return SingletonExample03.class;
    }
}