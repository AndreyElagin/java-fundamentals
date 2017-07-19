package javase02.t05;

/**
 * Created by daddyingrave on 28/06/2017.
 */
public enum Subjects {

    MATH(Double.class),
    PHYSICS(Double.class),
    HISTORY(Integer.class),
    FOREIGN_LANGUAGE(Integer.class);

    private Class<? extends Number> type;

    Subjects(Class<? extends Number> type) {
        this.type = type;
    }

    public boolean checkType(Object object) {
        return type.getCanonicalName()
                .equals(object.getClass().getCanonicalName());
    }

}
