//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LRUCacheService cache = new LRUCacheService(5);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        int value = cache.get(2);
        cache.put(3, 5);
        cache.put(5, 5);
        cache.put(6, 6);
        cache.put(7, 7);
        cache.put(6, 3);
        System.out.println(cache.get(7));
        cache.printCache();
    }
}