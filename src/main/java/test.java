import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> listenerClasses = new ArrayList<>();
        for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            String classInfoNAme = info.getName();
            boolean isListenerClass = classInfoNAme.startsWith("com.clean.listener");
            boolean isRetryFailCase = classInfoNAme.startsWith("com.clean.listener.RetryFailCase");
            if (isListenerClass && !isRetryFailCase){
                listenerClasses.add(info.load());
            }

        }
        for (Class<?> aClass : listenerClasses) {
            System.out.println(aClass.getName());
        }
    }
}
