package asm;


import jdk.internal.org.objectweb.asm.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by guoyangqiao on 12/03/2017.
 */
public class Asm {
    static Path path = Paths.get(URI.create("file:/Users/guoyangqiao/Desktop/asm/HelpAsm.class"));

    public static void main(String[] args) throws IOException {
        ClassWriter enhancedHelpAsmWriter;
        new ClassReader(HelpAsm.class.getName()).accept(new ClassEnhancer(Opcodes.ASM5, enhancedHelpAsmWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES)), ClassReader.SKIP_DEBUG);
        Files.deleteIfExists(path);
        Files.write(path, enhancedHelpAsmWriter.toByteArray(), StandardOpenOption.CREATE_NEW);
    }
}

class ClassEnhancer extends ClassVisitor {

    public ClassEnhancer(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.contains("<init>")) {
            return null;
        }
        MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
        methodVisitor.visitCode();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("ASM GO");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        methodVisitor.visitEnd();
        return methodVisitor;
    }
}