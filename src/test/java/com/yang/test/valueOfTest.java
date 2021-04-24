package com.yang.test;

public class valueOfTest {
	
	public static void main(String[] args) {
		
		Integer v1 = Integer.valueOf("50");
		Integer v2 = Integer.valueOf("50");
				
		Integer v3 = Integer.valueOf("200");
		Integer v4 = Integer.valueOf("200");
		
		System.out.println(v1 == v2);
		System.out.println(v3 == v4);
		
		// -128 ~ 127 缓存中取<IntegerCache.class中static代码块初始化cache>
		// else: new Integer()
		
	/*
	Integer静态内部类 
    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    } 
    
    
    public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
    
    
    */
		
	}

}
