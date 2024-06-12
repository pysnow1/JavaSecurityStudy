package Javasist;

import javassist.*;

public class newClass {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("Javasist.person");
        ctClass.setModifiers(Modifier.PRIVATE);

        CtField name = new CtField(pool.get("java.lang.String"),"name",ctClass);
        name.setModifiers(Modifier.PRIVATE);
        ctClass.addField(name,CtField.Initializer.constant("pysnow"));

        ctClass.addMethod(CtNewMethod.getter("getName",name));
        ctClass.addMethod(CtNewMethod.setter("setName",name));

        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{},ctClass);
        ctConstructor.setBody("{ name=\"pysnow1\";}");
        ctClass.addConstructor(ctConstructor);

        CtConstructor ctConstructor1 = new CtConstructor(new CtClass[]{pool.get("java.lang.String")},ctClass);
        ctConstructor1.setBody("{ $0.name = $1;}");

        CtMethod echoName = new CtMethod(CtClass.voidType,"echoName",new CtClass[]{},ctClass);
        echoName.setModifiers(Modifier.PUBLIC);
        echoName.setBody("{System.out.println($0.name);}");
        ctClass.addMethod(echoName);

        ctClass.writeFile();
        ctClass.detach();
    }
}
