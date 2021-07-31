package iojava;

import Estrutura_2.Arvore;
import com.google.gson.Gson;
import java.io.File;
import java.lang.reflect.Type;

public class IOJson <T> extends IOTexto{
        private static Gson gson = new Gson();
        public IOJson(String path) throws Exception {
            super(path);
        }

        public Object read(Class<T> clazz) throws Exception {
            String str = super.read();
            return gson.fromJson(str, clazz);
        }

//    public Object read(Estrutura_2.Arvore<String> arvore) throws Exception {
//        String str = super.read();
//        return gson.fromJson(str,arvore);
//    }

        public Object read(Type type) throws Exception {
            String str = super.read();
            return gson.fromJson(str, type);
        }

        public void write(Object obj) throws Exception {
            String str = gson.toJson(obj);
            super.write(str);
        }

}
