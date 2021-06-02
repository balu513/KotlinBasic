package com.komala.bkotlin.concepts;

class ThreadSafeLazyInitialization {

    private ThreadSafeLazyInitialization() {
    }

    private static class ReffoGet {
        private static final ThreadSafeLazyInitialization INSTANCE = new ThreadSafeLazyInitialization();
    }

    public ThreadSafeLazyInitialization getInstance() {
        return ReffoGet.INSTANCE;
    }
}


//    @Test
//    public void giveHeavyClass_whenInitLazy_thenShouldReturnInstanceOnFirstCall() {
//        // when
//        ClassWithHeavyInitialization_SingleTon classWithHeavyInitialization
//                = ClassWithHeavyInitialization_SingleTon.getInstance();
//        ClassWithHeavyInitialization_SingleTon classWithHeavyInitialization2
//                = ClassWithHeavyInitialization_SingleTon.getInstance();
//
//        // then
//        assertTrue(classWithHeavyInitialization == classWithHeavyInitialization2);
//    }