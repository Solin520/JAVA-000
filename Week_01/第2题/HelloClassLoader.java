package solin.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
	public static void main(String[] args) {
		try {
			Class<?> helloClass = new HelloClassLoader().findClass("Hello");
			Object helloInstance = helloClass.newInstance();
			Method method = helloClass.getMethod("hello");
            method.invoke(helloInstance);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		File file = new File(this.getClass().getResource("Hello.xlass").getPath());
		int length = (int)file.length();
        byte[] bytes = new byte[length];
        FileInputStream fis = null;
        try {
        	fis = new FileInputStream(file);
        	fis.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(name);
        } finally {
        	if (null != fis) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //因为Hello.xlass文件所有字节经过（x=255-x）处理过，所以这里要还原
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte)(255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
	}
}
