import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.junit.Test;

/**
 * Created by fengyiwei on 2017/11/05.
 */
public class CrackMyBatisIdeaPlugin3154 {
    public ClassPool pool = ClassPool.getDefault();

    @Test
    public void test() throws NotFoundException {
        pool.insertClassPath("D://iMybatis-3.42.jar");
        CtClass m = pool.get("com.a.a.e.m");
        CtClass ar = pool.get("com.a.a.e.ar");
        CtClass h = pool.get("com.a.a.e.h");
        CtClass S = pool.get("com.a.a.e.S");
        CtClass an = pool.get("com.a.a.e.an");
        CtClass ao = pool.get("com.a.a.e.ao");
        pool.importPackage("com.google.gson.JsonObject;");
        pool.importPackage("com.intellij.openapi.diagnostic.Logger;");
        pool.importPackage("com.intellij.openapi.project.Project;");

        try {
            // productId
            // productVersion
            // sha
            // valid
            CtMethod ct = m.getDeclaredMethod("a", new CtClass[]{pool.get("java.lang.String")});
            ct.setBody("{" +
                    "       com.google.gson.JsonObject var3 = new com.google.gson.JsonObject();\n" +
                    "       var3.addProperty(\"productId\", Integer.valueOf(1));\n" +
                    "       var3.addProperty(\"productVersion\", \"3.154\");\n" +
                    "       return true;\n" +
                    "   }");

            ct = ar.getDeclaredMethod("a", new CtClass[]{pool.get("com.google.gson.JsonObject")});
            ct.setBody("{" +
                    "       com.google.gson.JsonObject v3 = new com.google.gson.JsonObject();\n" +
                    "       v3.addProperty(\"valid\", \"true\");\n" +
                    "       return v3;\n" +
                    "   }");


            ct = h.getDeclaredMethod("onSuccess");
            ct.setBody("{com.a.a.e.ao.h(\"Success\");}");

            ct = h.getDeclaredMethod("onThrowable");
            ct.setBody("{ }");

            ct = S.getDeclaredMethod("a");
            ct.setBody("{ return com.a.a.e.ao.g(\"1111111\"); }");

            ct = an.getDeclaredMethod("l");
            ct.setBody("{" +
                    "       com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();\n" +
                    "       jsonObject.addProperty(\"pid\", com.a.a.e.an.d());\n" +
                    "       jsonObject.addProperty(\"userId\", com.a.a.e.an.e());\n" +
                    "       jsonObject.addProperty(\"version\", com.a.a.e.ac.b());\n" +
                    "       return jsonObject;" +
                    "   }");

            ct = ao.getDeclaredMethod("d");
            ct.setBody("{" +
                    "       com.google.gson.JsonObject jsonObject = com.a.a.e.an.l();\n" +
                    "       jsonObject.addProperty(\"license\", \"Cracked_By_Freeway\");\n" +
                    "       return new com.a.a.e.j(true, \"Freeway\");" +
                    "   }");

            ct = ao.getDeclaredMethod("b", new CtClass[]{});
            ct.setBody("{" +
                    "       return new com.a.a.e.ai(false, 365, true, true);" +
                    "   }");


            ct = ao.getDeclaredMethod("a", new CtClass[]{});
            ct.setBody("{" +
                    "       if (com.a.a.e.an.c().compareAndSet(false, true)) {\n" +
                    "           new Thread(new com.a.a.e.af()).start();" +
                    "       }" +
                    "   }");

            m.writeFile("/Users/fengyiwei/Desktop/");
            ar.writeFile("/Users/fengyiwei/Desktop/");
            h.writeFile("/Users/fengyiwei/Desktop/");
            S.writeFile("/Users/fengyiwei/Desktop/");
            an.writeFile("/Users/fengyiwei/Desktop/");
            ao.writeFile("/Users/fengyiwei/Desktop/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}