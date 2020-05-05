package alexrm84.utils;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Logger implements Serializable {

    private static final long serialVersionUID = -1278666901290619173L;

    private FileWriter fw;

    public Logger(){
        try {
            fw = new FileWriter("/file.log", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AroundInvoke
    public Object writeLog(InvocationContext ctx) throws Exception {
        fw.write("Вызван метод " + ctx.getMethod().getName());
        fw.append('\n');
        fw.flush();
        return ctx.proceed();
    }
}
