package invoke;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 并没有call site
 * Created by guoyangqiao on 02/03/2017.
 */
public class CallSiteTest {
    /**
     * invoke由jvm优化, 类似于直接调用
     * 方法检测发生在MethodHandle
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup totalLookup = MethodHandles.lookup();
        //String.valueOf(Object o);
        MethodHandle valueOfObject = totalLookup.findStatic(String.class, "valueOf", MethodType.methodType(String.class, Object.class));
        Object valueOfResult = valueOfObject.invoke('A');
        System.out.println(valueOfResult);
        //churlish asType by using polymorphism
        MethodHandle Tester = valueOfObject.asType(MethodType.methodType(String.class, CallSiteTest.class));
        Object invoke = Tester.invoke(new CallSiteTest());
        System.out.println(invoke);

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

        System.out.println("test bindTo");
        //what does bindTo  mean
        MethodHandle voidCon = totalLookup.findConstructor(StringBuilder.class, MethodType.methodType(void.class));
        Object voidObj = voidCon.invoke();
        /*
        these two is functionally familiar, if you want to invoke a virtual method on a object, you must first bind the method to a object
        MethodHandle stringBuilderAppend = totalLookup.findVirtual(StringBuilder.class, "append", MethodType.methodType(StringBuilder.class, String.class)).bindTo(stringBuilder);
         */
        MethodHandle append = totalLookup.findVirtual(voidObj.getClass(), "append", MethodType.methodType(voidObj.getClass(), String.class));
        Object abc = append.invoke(voidObj, "abc");
        System.out.println(abc);

        ConstantCallSite constantCallSite = new ConstantCallSite(Tester);


    }

    @Override
    public String toString() {
        return "I am a CallSiteTest";
    }
}
