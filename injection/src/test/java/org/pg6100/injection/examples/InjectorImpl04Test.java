package org.pg6100.injection.examples;

import org.pg6100.injection.InjectorBaseSuite;
import org.pg6100.injection.Injector;



public class InjectorImpl04Test extends InjectorBaseSuite {

    @Override
    protected Injector getInjector() {
        return new InjectorImp04();
    }
}