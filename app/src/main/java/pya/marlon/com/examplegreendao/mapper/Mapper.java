package pya.marlon.com.examplegreendao.mapper;

/**
 * Created by marlonpya on 29/07/17.
 */

public interface Mapper<T1, T2> {
    T1 map(T2 sql);
    T2 reverseMap(T1 bean);
}
