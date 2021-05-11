/**
 * @author duxiaojie
 * @date 2021-05-07 15:35
 */
public class Singleton {

    private volatile static Singleton singleton;

    public Singleton getInstance() {

        if (singleton == null) {

            synchronized (Singleton.class) {

                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

}
