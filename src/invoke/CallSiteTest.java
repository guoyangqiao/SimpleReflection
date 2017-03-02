package invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 并没有call site
 * Created by guoyangqiao on 02/03/2017.
 */
public class CallSiteTest {
    public static void main(String[] args) throws Throwable {
        //String.valueOf(Object o);
        MethodHandles.Lookup totalLookup = MethodHandles.lookup();
        MethodHandle valueOf = totalLookup.findStatic(String.class, "valueOf", MethodType.methodType(String.class, Object.class));
        Object valueOfResult = valueOf.invoke("淡淡的灰朦有一丝悲哀");
        System.out.println(valueOfResult);

        //StringBuilder builder = new StringBuilder("abc);
        MethodHandle stringBuilderConstructor = totalLookup.findConstructor(StringBuilder.class, MethodType.methodType(void.class, String.class));
        Object stringBuilder = stringBuilderConstructor.invoke("情画\n刘畊宏\n");
        MethodHandle stringBuilderAppend = totalLookup.findVirtual(StringBuilder.class, "append", MethodType.methodType(StringBuilder.class, String.class)).bindTo(stringBuilder);
        //builder.append("不能说的秘密");
        String[] statements = {"冷咖啡离开了杯垫", "我忍住的情绪在很后面", "拼命想挽回的从前", "在我脸颊依旧清晰可见"};
        for (String statement : statements) {
            stringBuilderAppend.invoke(statement);
            stringBuilderAppend.invoke("\n");
        }
        //System.out.println(StringBuilder.instance);
        System.out.println(stringBuilder);
    }
}
