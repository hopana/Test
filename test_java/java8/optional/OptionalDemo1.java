package optional;

import java.util.Optional;

/**
 * Optional用法示例
 *
 * @author hupan
 * @since 2018-02-23 14:43
 */
public class OptionalDemo1 {

    public static void main(String[] args) {
        Optional<Integer> r = getNumber(50);
        System.out.println(r.isPresent());
    }

    private static Optional<Integer> getNumber(Integer i) {
        if (i > 0) {
            return Optional.of(i);
        }

        return Optional.empty();
    }

}
