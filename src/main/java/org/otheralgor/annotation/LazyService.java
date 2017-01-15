package org.otheralgor.annotation;

@SimpleService(name = "VeryLazyNotWorkingService")
public class LazyService {
    @Init(name = "lInit")
    public void lazyInit() throws Exception{
        System.out.println("lazyyyyyyyyyyyyyyyyyInit");
    }
}
