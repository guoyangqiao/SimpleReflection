package klass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/15/16.
 */
public class TreeConst {

    private String classNode;

    private List<TreeConst> interfaceNodes;

    public List<TreeConst> getInterfaceNodes() {
        return interfaceNodes;
    }

    public void setInterfaceNodes(List<TreeConst> interfaceNodes) {
        this.interfaceNodes = interfaceNodes;
    }

    public String getClassNode() {
        return classNode;
    }

    public void setClassNode(String classNode) {
        this.classNode = classNode;
    }

    @Override
    public String toString() {
        return "TreeConst{" +
                "classNode='" + classNode + '\'' +
                ", interfaceNodes=" + interfaceNodes +
                '}';
    }
}

class Tesla extends TreeConst {

    public static void main(String[] args) {
        Method[] methods = TreeConst.class.getMethods();
        for(Method m :methods){
            System.out.println(m.toString());
        }
        Constructor<?>[] constructors = TreeConst.class.getConstructors();
        for(Constructor c:constructors){
            System.out.println(c.toString());
        }

    }

    public static <T> TreeConst getTree(Class<T> c) {
        TreeConst treeConst = new TreeConst();
        treeConst.setClassNode(c.getName());
        Class<?>[] interfaces = c.getInterfaces();
        if (interfaces != null) {
            ArrayList<TreeConst> treeConstList = new ArrayList<>();
            for (Class inter : interfaces) {
                treeConstList.add(getTree(inter));
            }
            treeConst.setInterfaceNodes(treeConstList);
        }
        return treeConst;
    }


}
