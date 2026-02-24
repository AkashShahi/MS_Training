package customoptionalclass;

public class main {

    public static void main(String[] args) {

        MyOptional<String> optional = MyOptional.ofNullable(null);

        System.out.println(optional.orElse("Not found"));

        System.out.println(optional.orElseGet(() -> "return default value"));
    }
}
